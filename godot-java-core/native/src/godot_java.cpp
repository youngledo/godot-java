/**
 * godot-java - Panama FFI binding for Godot 4.x
 * Thin C++ shim: GDExtension entry point + JVM embedding + pass function pointers to Java
 *
 * Cross-platform support: macOS, Linux, Windows
 * - Uses platform detection macros to select correct JVM library name and search paths
 * - Uses dlfcn.h (dlopen/dlsym) on Unix, windows.h (LoadLibrary/GetProcAddress) on Windows
 */

#include <iostream>
#include <cstring>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

// Platform-specific dynamic library loading
#if defined(_WIN32)
    #include <windows.h>
    #include <cstdlib>
#else
    #include <dlfcn.h>
    #include <dirent.h>
    #include <cstdlib>
#endif

// Platform detection macros are built-in: __APPLE__, __linux__, _WIN32

// JNI
#include <jni.h>

// GDExtension interface types (copied from headers, no godot-cpp dependency)
extern "C" {

typedef unsigned char GDExtensionBool;
typedef int64_t GDExtensionInt;
typedef void *GDExtensionObjectPtr;
typedef void *GDExtensionClassLibraryPtr;

typedef enum {
    GDEXTENSION_INITIALIZATION_CORE = 0,
    GDEXTENSION_INITIALIZATION_SERVERS = 1,
    GDEXTENSION_INITIALIZATION_SCENE = 2,
    GDEXTENSION_INITIALIZATION_EDITOR = 3,
} GDExtensionInitializationLevel;

typedef void (*GDExtensionInitializeCallback)(void *p_userdata, GDExtensionInitializationLevel p_level);
typedef void (*GDExtensionDeinitializeCallback)(void *p_userdata, GDExtensionInitializationLevel p_level);

typedef struct {
    GDExtensionInitializationLevel minimum_initialization_level;
    void *userdata;
    GDExtensionInitializeCallback initialize;
    GDExtensionDeinitializeCallback deinitialize;
} GDExtensionInitialization;

typedef void (*GDExtensionInterfaceFunctionPtr)();
typedef GDExtensionInterfaceFunctionPtr (*GDExtensionInterfaceGetProcAddress)(const char *p_function_name);
typedef GDExtensionBool (*GDExtensionInitializationFunction)(
    GDExtensionInterfaceGetProcAddress p_get_proc_address,
    GDExtensionClassLibraryPtr p_library,
    GDExtensionInitialization *r_initialization);

} // extern "C"

// Export macro
#if defined(_WIN32)
    #define GDE_EXPORT __declspec(dllexport)
#elif defined(__APPLE__)
    #define GDE_EXPORT __attribute__((visibility("default")))
#else
    #define GDE_EXPORT __attribute__((visibility("default")))
#endif

static JavaVM* g_java_vm = nullptr;
static JNIEnv* g_jni_env = nullptr;
static void* g_libjvm = nullptr;

// ---------------------------------------------------------------------------
// Task 5.5: C++ trampoline registration
// Stores upcall function pointers received from Java for dispatching.
// When Godot calls a registered Java method, the C++ dispatcher uses this
// map to find the correct native function pointer and invoke it.
// ---------------------------------------------------------------------------

#include <map>
#include <string>

// Global map: "ClassName::method_name" → native function pointer
static std::map<std::string, void*> g_upcall_trampolines;

// GDExtension function pointers (set during initialization)
static GDExtensionInterfaceGetProcAddress g_get_proc_address = nullptr;
static GDExtensionClassLibraryPtr g_library = nullptr;
static bool g_java_init_called = false;

// Get a trampoline function pointer by class and method name
static void* get_trampoline(const char* class_name, const char* method_name) {
    std::string key = std::string(class_name) + "::" + method_name;
    auto it = g_upcall_trampolines.find(key);
    if (it != g_upcall_trampolines.end()) {
        return it->second;
    }
    return nullptr; // Not found
}

// JNI: resolve a GDExtension function by name and return its address as jlong
// This bypasses Panama FFI's handling of function pointers for get_proc_address
static GDExtensionInterfaceGetProcAddress g_gpa_func = nullptr;

static jlong JNICALL
Java_org_godot_bootstrap_Bootstrap_getProcAddressImpl(
    JNIEnv* env, jclass clazz, jstring funcName) {
    if (!g_gpa_func) return 0;
    const char* name = env->GetStringUTFChars(funcName, nullptr);
    GDExtensionInterfaceFunctionPtr ptr = g_gpa_func(name);
    env->ReleaseStringUTFChars(funcName, name);
    return reinterpret_cast<jlong>(ptr);
}

// JNI callback: receives upcall function pointers from Java and stores them
// This is called by Bootstrap.registerUpcallTrampoline() via JNI
static void JNICALL
Java_org_godot_bootstrap_Bootstrap_registerUpcallTrampoline(
    JNIEnv* env, jclass clazz,
    jstring className, jstring methodName, jlong functionPtr) {
    const char* c_class_name = env->GetStringUTFChars(className, nullptr);
    const char* c_method_name = env->GetStringUTFChars(methodName, nullptr);
    std::string key = std::string(c_class_name) + "::" + c_method_name;
    g_upcall_trampolines[key] = reinterpret_cast<void*>(functionPtr);
    env->ReleaseStringUTFChars(className, c_class_name);
    env->ReleaseStringUTFChars(methodName, c_method_name);
    std::cout << "godot-java: Registered upcall trampoline: " << key
              << " → " << reinterpret_cast<void*>(functionPtr) << std::endl;
}

// JNI: return the GDExtension library pointer
static jlong JNICALL
Java_org_godot_bootstrap_Bootstrap_getLibraryPtrImpl(
    JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(g_library);
}

// JNI native method table for Bootstrap class
static JNINativeMethod g_bootstrap_methods[] = {
    {
        const_cast<char*>("registerUpcallTrampoline"),
        const_cast<char*>("(Ljava/lang/String;Ljava/lang/String;J)V"),
        reinterpret_cast<void*>(&Java_org_godot_bootstrap_Bootstrap_registerUpcallTrampoline)
    },
    {
        const_cast<char*>("getProcAddressImpl"),
        const_cast<char*>("(Ljava/lang/String;)J"),
        reinterpret_cast<void*>(&Java_org_godot_bootstrap_Bootstrap_getProcAddressImpl)
    },
    {
        const_cast<char*>("getLibraryPtrImpl"),
        const_cast<char*>("()J"),
        reinterpret_cast<void*>(&Java_org_godot_bootstrap_Bootstrap_getLibraryPtrImpl)
    }
};

// Register JNI native methods for the Bootstrap class
static bool register_bootstrap_natives(JNIEnv* env) {
    jclass bootstrap_class = env->FindClass("org/godot/bootstrap/Bootstrap");
    if (!bootstrap_class) {
        std::cerr << "godot-java: FindClass(Bootstrap) failed in register_bootstrap_natives" << std::endl;
        if (env->ExceptionOccurred()) env->ExceptionDescribe();
        return false;
    }
    jint result = env->RegisterNatives(
        bootstrap_class,
        g_bootstrap_methods,
        sizeof(g_bootstrap_methods) / sizeof(JNINativeMethod));
    if (result != 0) {
        std::cerr << "godot-java: RegisterNatives failed with code " << result << std::endl;
        return false;
    }
    std::cout << "godot-java: JNI natives registered for Bootstrap" << std::endl;
    return true;
}

// Debug configuration
static bool g_debug_mode = false;
static int g_debug_port = 5005;

// ---------------------------------------------------------------------------
// Debug configuration
// ---------------------------------------------------------------------------

static void check_debug_config() {
    // Check for debug environment variables
    std::string debug_port_str = getenv("GODOT_JAVA_DEBUG_PORT") ? getenv("GODOT_JAVA_DEBUG_PORT") : "";
    if (!debug_port_str.empty()) {
        try {
            g_debug_port = std::stoi(debug_port_str);
            g_debug_mode = true;
        } catch (...) {
            g_debug_port = 5005;
        }
    }

    // Alternative: check for GODOT_JAVA_DEBUG flag
    std::string debug_flag = getenv("GODOT_JAVA_DEBUG") ? getenv("GODOT_JAVA_DEBUG") : "";
    if (!debug_flag.empty() && (debug_flag == "1" || debug_flag == "true" || debug_flag == "yes")) {
        g_debug_mode = true;
    }

    if (g_debug_mode) {
        std::cout << "godot-java: Debug mode enabled on port " << g_debug_port << std::endl;
    }
}

static bool is_debug_enabled() {
    return g_debug_mode;
}

static int get_debug_port() {
    return g_debug_port;
}

// ---------------------------------------------------------------------------
// JMX configuration
// ---------------------------------------------------------------------------

static bool g_jmx_enabled = false;
static int g_jmx_port = 9010;

static void check_jmx_config() {
    std::string jmx_flag = getenv("GODOT_JAVA_JMX") ? getenv("GODOT_JAVA_JMX") : "";
    if (!jmx_flag.empty() && (jmx_flag == "1" || jmx_flag == "true" || jmx_flag == "yes")) {
        g_jmx_enabled = true;

        std::string jmx_port_str = getenv("GODOT_JAVA_JMX_PORT") ? getenv("GODOT_JAVA_JMX_PORT") : "";
        if (!jmx_port_str.empty()) {
            try {
                g_jmx_port = std::stoi(jmx_port_str);
            } catch (...) {
                g_jmx_port = 9010;
            }
        }
        std::cout << "godot-java: JMX enabled on port " << g_jmx_port << std::endl;
    }
}

static bool is_jmx_enabled() {
    return g_jmx_enabled;
}

static int get_jmx_port() {
    return g_jmx_port;
}

// ---------------------------------------------------------------------------
// Platform-specific path helpers
// ---------------------------------------------------------------------------

#if defined(_WIN32)

// Windows: use GetEnvironmentVariable to read env vars
static std::string get_env(const char* name) {
    DWORD size = GetEnvironmentVariableA(name, nullptr, 0);
    if (size == 0) return "";
    std::vector<char> buf(size);
    GetEnvironmentVariableA(name, buf.data(), size);
    return std::string(buf.data());
}

static void* platform_dlopen(const char* path) {
    return (void*)LoadLibraryA(path);
}

static void* platform_dlsym(void* handle, const char* symbol) {
    return (void*)GetProcAddress((HMODULE)handle, symbol);
}

static void platform_dlclose(void* handle) {
    FreeLibrary((HMODULE)handle);
}

static std::string platform_dlerror() {
    DWORD err = GetLastError();
    if (err == 0) return "";
    LPSTR buf = nullptr;
    FormatMessageA(FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
                   nullptr, err, MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT), (LPSTR)&buf, 0, nullptr);
    std::string msg(buf ? buf : "Unknown error");
    LocalFree(buf);
    return msg;
}

#else

// Unix (macOS, Linux): use std::getenv
static std::string get_env(const char* name) {
    const char* val = std::getenv(name);
    return val ? std::string(val) : "";
}

static void* platform_dlopen(const char* path) {
    return dlopen(path, RTLD_NOW);
}

static void* platform_dlsym(void* handle, const char* symbol) {
    return dlsym(handle, symbol);
}

static void platform_dlclose(void* handle) {
    dlclose(handle);
}

static std::string platform_dlerror() {
    const char* err = dlerror();
    return err ? std::string(err) : "";
}

#endif

// Forward declaration (needed by get_native_library_dir)
extern "C" GDExtensionBool GDE_EXPORT godot_java_init(
    GDExtensionInterfaceGetProcAddress p_get_proc_address,
    GDExtensionClassLibraryPtr p_library,
    GDExtensionInitialization *r_initialization);

// ---------------------------------------------------------------------------
// Path helpers
// ---------------------------------------------------------------------------

static std::string get_dir_name(const std::string& path) {
#if defined(_WIN32)
    char sep = '\\';
#else
    char sep = '/';
#endif
    size_t pos = path.find_last_of(sep);
    if (pos == std::string::npos) return ".";
    return path.substr(0, pos);
}

static std::string get_native_library_dir() {
    // Use platform API to find the directory containing this shared library
#if defined(_WIN32)
    char path[MAX_PATH];
    HMODULE hm = NULL;
    if (GetModuleHandleExA(GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS | GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT,
                           (LPCSTR)&godot_java_init, &hm)) {
        GetModuleFileNameA(hm, path, sizeof(path));
        return get_dir_name(std::string(path));
    }
#elif defined(__APPLE__) || defined(__linux__)
    Dl_info info;
    if (dladdr((void*)&godot_java_init, &info) && info.dli_fname) {
        return get_dir_name(std::string(info.dli_fname));
    }
#endif
    return "";
}

static std::string path_join(const std::string& a, const std::string& b) {
#if defined(_WIN32)
    char sep = '\\';
#else
    char sep = '/';
#endif
    if (a.empty()) return b;
    if (b.empty()) return a;
    if (a.back() == sep || a.back() == '/') return a + b;
    return a + sep + b;
}

// ---------------------------------------------------------------------------
// JVM library path detection
// ---------------------------------------------------------------------------

#if defined(__APPLE__)
    static const char* JVM_LIB_NAME = "libjvm.dylib";
#elif defined(__linux__)
    static const char* JVM_LIB_NAME = "libjvm.so";
#elif defined(_WIN32)
    static const char* JVM_LIB_NAME = "jvm.dll";
#else
    static const char* JVM_LIB_NAME = "libjvm.so";
#endif

static std::vector<std::string> get_jvm_search_paths() {
    std::vector<std::string> paths;
    std::string java_home = get_env("JAVA_HOME");

#if defined(__APPLE__)
    // macOS search paths for libjvm.dylib
    if (!java_home.empty()) {
        paths.push_back(path_join(java_home, "lib/server/libjvm.dylib"));
    }
    // sdkman candidates
    std::string home = get_env("HOME");
    if (!home.empty()) {
        // Common sdkman location - check known versions
        paths.push_back(path_join(home, ".sdkman/candidates/java/25.0.2-tem/lib/server/libjvm.dylib"));
        paths.push_back(path_join(home, ".sdkman/candidates/java/current/lib/server/libjvm.dylib"));
    }
    // /Library/Java installations
    paths.push_back("/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home/lib/server/libjvm.dylib");
    paths.push_back("/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home/lib/server/libjvm.dylib");

#elif defined(__linux__)
    // Linux search paths for libjvm.so
    if (!java_home.empty()) {
        paths.push_back(path_join(java_home, "lib/server/libjvm.so"));
        paths.push_back(path_join(java_home, "lib/amd64/server/libjvm.so"));
        paths.push_back(path_join(java_home, "lib/aarch64/server/libjvm.so"));
    }
    // Common system locations
    paths.push_back("/usr/lib/jvm/java-25-openjdk-amd64/lib/server/libjvm.so");
    paths.push_back("/usr/lib/jvm/java-21-openjdk-amd64/lib/server/libjvm.so");
    paths.push_back("/usr/lib/jvm/default-java/lib/server/libjvm.so");
    // sdkman on Linux
    std::string home = get_env("HOME");
    if (!home.empty()) {
        paths.push_back(path_join(home, ".sdkman/candidates/java/current/lib/server/libjvm.so"));
    }
    // /opt/java
    paths.push_back("/opt/java/lib/server/libjvm.so");
    paths.push_back("/opt/jdk/lib/server/libjvm.so");

#elif defined(_WIN32)
    // Windows search paths for jvm.dll
    if (!java_home.empty()) {
        paths.push_back(path_join(java_home, "bin\\server\\jvm.dll"));
        paths.push_back(path_join(java_home, "lib\\server\\jvm.dll"));
    }
    // Program Files locations
    paths.push_back("C:\\Program Files\\Java\\jdk-25\\bin\\server\\jvm.dll");
    paths.push_back("C:\\Program Files\\Java\\jdk-21\\bin\\server\\jvm.dll");
    paths.push_back("C:\\Program Files\\Eclipse Adoptium\\jdk-25-hotspot\\bin\\server\\jvm.dll");
    paths.push_back("C:\\Program Files\\Eclipse Adoptium\\jdk-21-hotspot\\bin\\server\\jvm.dll");
#endif

    return paths;
}

static std::string find_jvm_library() {
    // First, check JAVA_HOME directly for the JVM library
    std::string java_home = get_env("JAVA_HOME");
    if (!java_home.empty()) {
#if defined(_WIN32)
        std::string jvm_path = path_join(java_home, "bin\\server\\jvm.dll");
#else
        std::string jvm_path = path_join(java_home, "lib/server/" + std::string(JVM_LIB_NAME));
#endif
        // Quick check if JAVA_HOME path works
        void* test = platform_dlopen(jvm_path.c_str());
        if (test) {
            platform_dlclose(test);
            return jvm_path;
        }
    }

    // Try all search paths
    std::vector<std::string> paths = get_jvm_search_paths();
    for (const auto& path : paths) {
        void* test = platform_dlopen(path.c_str());
        if (test) {
            platform_dlclose(test);
            return path;
        }
    }

    // Return empty string - caller will handle error
    return "";
}

// ---------------------------------------------------------------------------
// Classpath detection
// ---------------------------------------------------------------------------

static std::string find_classpath() {
    // 1. Check GODOT_JAVA_CLASSPATH env var (explicit override)
    std::string cp = get_env("GODOT_JAVA_CLASSPATH");
    if (!cp.empty()) {
        return cp;
    }

    // 2. Look for JAR files in the same directory as this native library
    std::string lib_dir = get_native_library_dir();
    if (!lib_dir.empty()) {
        // Scan for .jar files in the library directory
#if defined(_WIN32)
        std::string pattern = lib_dir + "\\*.jar";
        WIN32_FIND_DATAA fd;
        HANDLE hFind = FindFirstFileA(pattern.c_str(), &fd);
        if (hFind != INVALID_HANDLE_VALUE) {
            std::string jar_path = path_join(lib_dir, fd.cFileName);
            FindClose(hFind);
            std::cout << "godot-java: Found JAR next to native library: " << jar_path << std::endl;
            return jar_path;
        }
#else
        DIR* dir = opendir(lib_dir.c_str());
        if (dir) {
            struct dirent* entry;
            std::string best_jar;
            while ((entry = readdir(dir)) != nullptr) {
                std::string name(entry->d_name);
                if (name.size() > 4 && name.substr(name.size() - 4) == ".jar") {
                    // Prefer the first JAR found (or could add smarter selection)
                    if (best_jar.empty()) {
                        best_jar = path_join(lib_dir, name);
                    }
                }
            }
            closedir(dir);
            if (!best_jar.empty()) {
                std::cout << "godot-java: Found JAR next to native library: " << best_jar << std::endl;
                return best_jar;
            }
        }
#endif
    }

    // 3. Development fallback: look for target/classes relative to source
    std::string base = path_join(__FILE__, "../../..");
    std::string dev_path = path_join(base, "target/classes");
    return dev_path;
}

// ---------------------------------------------------------------------------
// JVM initialization
// ---------------------------------------------------------------------------

static void init_crash_handler();

static bool init_jvm() {
    std::cout << "godot-java: Loading JVM library..." << std::endl;

    // Setup crash handler before anything else
    init_crash_handler();

    // Check debug configuration first
    check_debug_config();

    // Check JMX configuration
    check_jmx_config();

    std::string jvm_path = find_jvm_library();
    if (jvm_path.empty()) {
        std::cerr << "godot-java: Could not find JVM library (" << JVM_LIB_NAME << ")" << std::endl;
        std::cerr << "godot-java: Please set JAVA_HOME environment variable" << std::endl;
        return false;
    }

    std::cout << "godot-java: Trying JVM at: " << jvm_path << std::endl;

    g_libjvm = platform_dlopen(jvm_path.c_str());
    if (!g_libjvm) {
        std::cerr << "godot-java: Failed to load JVM library: " << platform_dlerror() << std::endl;
        return false;
    }

    using CreateJavaVM_t = jint (*)(JavaVM**, void**, void*);
    auto create_jvm = (CreateJavaVM_t)platform_dlsym(g_libjvm, "JNI_CreateJavaVM");
    if (!create_jvm) {
        std::cerr << "godot-java: Failed to find JNI_CreateJavaVM symbol" << std::endl;
        return false;
    }

    std::string classpath = find_classpath();

    // Build JVM options array - allocate enough space for all options
    JavaVMOption options[16];
    int option_count = 0;

    std::string cp_option = "-Djava.class.path=" + classpath;
    options[option_count++].optionString = const_cast<char*>(cp_option.c_str());
    options[option_count++].optionString = const_cast<char*>("-Xmx512m");
    options[option_count++].optionString = const_cast<char*>("-Xms256m");
    options[option_count++].optionString = const_cast<char*>("--enable-native-access=ALL-UNNAMED");
    options[option_count++].optionString = const_cast<char*>("--add-opens=java.base/java.lang=ALL-UNNAMED");
    options[option_count++].optionString = const_cast<char*>("--add-opens=java.base/java.lang.foreign=ALL-UNNAMED");

    // Add JDWP options when debug mode is enabled
    if (is_debug_enabled()) {
        int debug_port = get_debug_port();

        // JDWP agent options
        std::string transport_opt = "transport=dt_socket,server=y,suspend=y,address=*:" + std::to_string(debug_port);
        options[option_count++].optionString = const_cast<char*>(strdup(("-agentlib:jdwp=" + transport_opt).c_str()));

        // Additional debug options
        options[option_count++].optionString = const_cast<char*>("-Xdebug");
        options[option_count++].optionString = const_cast<char*>(strdup(("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=localhost:" + std::to_string(debug_port)).c_str()));

        std::cout << "godot-java: Debug enabled on port " << debug_port << std::endl;
    }

    // Add JMX options when JMX is enabled
    if (is_jmx_enabled()) {
        int jmx_port = get_jmx_port();

        std::string jmx_port_opt = "com.sun.management.jmxremote.port=" + std::to_string(jmx_port);
        options[option_count++].optionString = const_cast<char*>(strdup(jmx_port_opt.c_str()));

        options[option_count++].optionString = const_cast<char*>("com.sun.management.jmxremote=true");
        options[option_count++].optionString = const_cast<char*>("com.sun.management.jmxremote.authenticate=false");
        options[option_count++].optionString = const_cast<char*>("com.sun.management.jmxremote.ssl=false");

        std::cout << "godot-java: JMX enabled on port " << jmx_port << std::endl;
    }

    std::cout << "godot-java: Classpath: " << cp_option << std::endl;

    JavaVMInitArgs args;
    args.version = JNI_VERSION_1_8;
    args.nOptions = option_count;
    args.options = options;
    args.ignoreUnrecognized = JNI_TRUE;

    std::cout << "godot-java: Creating JVM with " << option_count << " options..." << std::endl;

    jint result = create_jvm(&g_java_vm, (void**)&g_jni_env, &args);
    if (result != JNI_OK || !g_java_vm || !g_jni_env) {
        std::cerr << "godot-java: Failed to create JVM: error code " << result << std::endl;
        return false;
    }

    std::cout << "godot-java: JVM initialized successfully!" << std::endl;
    return true;
}

// ---------------------------------------------------------------------------
// Call Java GodotBridge.init() via JNI
// ---------------------------------------------------------------------------

static void call_java_init(GDExtensionInterfaceGetProcAddress get_proc_address,
                            GDExtensionClassLibraryPtr library) {
    if (!g_jni_env) {
        std::cerr << "godot-java: JNIEnv is null" << std::endl;
        return;
    }

    JNIEnv* env = g_jni_env;

    jclass bootstrap_class = env->FindClass("org/godot/bootstrap/Bootstrap");
    if (!bootstrap_class) {
        std::cerr << "godot-java: FindClass(Bootstrap) failed" << std::endl;
        if (env->ExceptionOccurred()) {
            env->ExceptionDescribe();
            env->ExceptionClear();
        }
        return;
    }

    jmethodID init_method = env->GetStaticMethodID(bootstrap_class, "init", "(JJ)V");
    if (!init_method) {
        std::cerr << "godot-java: GetStaticMethodID(init) failed" << std::endl;
        if (env->ExceptionOccurred()) {
            env->ExceptionDescribe();
            env->ExceptionClear();
        }
        return;
    }

    // Pass C function pointer and library pointer as jlong to Java
    env->CallStaticVoidMethod(bootstrap_class, init_method,
        (jlong)get_proc_address,
        (jlong)library);

    if (env->ExceptionOccurred()) {
        std::cerr << "godot-java: Bootstrap.init() threw exception" << std::endl;
        env->ExceptionDescribe();
        env->ExceptionClear();
        return;
    }

    std::cout << "godot-java: Bootstrap.init() completed successfully!" << std::endl;
}

// ---------------------------------------------------------------------------
// JVM cleanup
// ---------------------------------------------------------------------------

static void cleanup_jvm() {
    if (g_java_vm) {
        g_java_vm->DestroyJavaVM();
        g_java_vm = nullptr;
        g_jni_env = nullptr;
    }
    if (g_libjvm) {
        platform_dlclose(g_libjvm);
        g_libjvm = nullptr;
    }
}

// ---------------------------------------------------------------------------
// Crash Handler
// ---------------------------------------------------------------------------

#include <csignal>
#include <cstdio>
#include <cstdlib>
#if !defined(_WIN32)
    #include <execinfo.h>
#endif
#include <mutex>

static std::mutex g_crash_mutex;
static bool g_crash_handler_enabled = false;

static void crash_handler(int sig) {
    std::lock_guard<std::mutex> lock(g_crash_mutex);

    std::cerr << "========================================" << std::endl;
    std::cerr << "=== Godot Java Crash Report ===" << std::endl;
    std::cerr << "========================================" << std::endl;
    std::cerr << "Signal: " << sig << std::endl;

#if !defined(_WIN32)
    // Get native stack trace (POSIX only)
    const int MAX_STACK_FRAMES = 64;
    void* buffer[MAX_STACK_FRAMES];

    int nframes = backtrace(buffer, MAX_STACK_FRAMES);
    char** symbols = backtrace_symbols(buffer, nframes);

    if (symbols) {
        std::cerr << "\nNative Stack Trace:" << std::endl;
        for (int i = 0; i < nframes; i++) {
            std::cerr << "  #" << i << " " << symbols[i] << std::endl;
        }
        std::free(symbols);
    }
#else
    std::cerr << "\nNative stack trace not available on Windows" << std::endl;
#endif

    // Try to get Java stack trace
    if (g_jni_env) {
        std::cerr << "\nJava Stack Trace:" << std::endl;
        jthrowable exc = g_jni_env->ExceptionOccurred();
        if (exc) {
            g_jni_env->ExceptionDescribe();
            g_jni_env->ExceptionClear();
        } else {
            // Get current thread and its stack
            jclass thread_class = g_jni_env->FindClass("java/lang/Thread");
            if (thread_class) {
                jmethodID get_stack = g_jni_env->GetStaticMethodID(
                    thread_class, "getStackTrace", "()[Ljava/lang/StackTraceElement;");
                if (get_stack) {
                    jobjectArray stack = (jobjectArray)g_jni_env->CallStaticObjectMethod(
                        thread_class, get_stack);
                    if (stack) {
                        jint length = g_jni_env->GetArrayLength(stack);
                        for (jint i = 0; i < length && i < 20; i++) {
                            jobject frame = g_jni_env->GetObjectArrayElement(stack, i);
                            jclass frame_class = g_jni_env->GetObjectClass(frame);
                            jmethodID toString = g_jni_env->GetMethodID(
                                frame_class, "toString", "()Ljava/lang/String;");
                            if (toString) {
                                jstring str = (jstring)g_jni_env->CallObjectMethod(frame, toString);
                                if (str) {
                                    const char* chars = g_jni_env->GetStringUTFChars(str, nullptr);
                                    std::cerr << "  at " << chars << std::endl;
                                    g_jni_env->ReleaseStringUTFChars(str, chars);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    std::cerr << "========================================" << std::endl;
    std::cerr << "Crashing..." << std::endl;

    // Re-raise the signal with default handler
    signal(sig, SIG_DFL);
    raise(sig);
}

static void init_crash_handler() {
    std::string crash_enabled = get_env("GODOT_JAVA_CRASH_HANDLER");
    if (!crash_enabled.empty() && (crash_enabled == "1" || crash_enabled == "true" || crash_enabled == "yes")) {
        g_crash_handler_enabled = true;

        // Register signal handlers
        signal(SIGSEGV, crash_handler);  // Segmentation fault
        signal(SIGABRT, crash_handler);  // Abort
        signal(SIGFPE, crash_handler);   // Floating point exception
        signal(SIGILL, crash_handler);   // Illegal instruction

        std::cout << "godot-java: Crash handler enabled" << std::endl;
    }
}

// ---------------------------------------------------------------------------
// GDExtension initialization/deinitialization callbacks
// ---------------------------------------------------------------------------

static void godot_java_initialize(void *userdata, GDExtensionInitializationLevel p_level) {
    std::cout << "godot-java: initialize level " << p_level << std::endl;
    std::cout.flush();

    // Register extension classes at SCENE level, when Node and other scene classes are available
    if (p_level == GDEXTENSION_INITIALIZATION_SCENE && g_jni_env) {
        JNIEnv* env = g_jni_env;
        jclass bootstrap_class = env->FindClass("org/godot/bootstrap/Bootstrap");
        if (bootstrap_class) {
            jmethodID register_method = env->GetStaticMethodID(bootstrap_class, "registerClasses", "()V");
            if (register_method) {
                env->CallStaticVoidMethod(bootstrap_class, register_method);
                if (env->ExceptionOccurred()) {
                    std::cerr << "godot-java: Bootstrap.registerClasses() threw exception" << std::endl;
                    env->ExceptionDescribe();
                    env->ExceptionClear();
                } else {
                    std::cout << "godot-java: Classes registered at SCENE level" << std::endl;
                }
            }
        }
    }
}

static void godot_java_deinitialize(void *userdata, GDExtensionInitializationLevel p_level) {
    std::cout << "godot-java: deinitialize level " << p_level << std::endl;
    if (p_level == GDEXTENSION_INITIALIZATION_CORE) {
        cleanup_jvm();
    }
}

// ---------------------------------------------------------------------------
// GDExtension entry point - called by Godot engine
// ---------------------------------------------------------------------------

extern "C" GDExtensionBool GDE_EXPORT godot_java_init(
    GDExtensionInterfaceGetProcAddress p_get_proc_address,
    GDExtensionClassLibraryPtr p_library,
    GDExtensionInitialization *r_initialization
) {
    std::cout << "godot-java: init start" << std::endl;
    std::cout.flush();

    // Fill initialization structure
    r_initialization->minimum_initialization_level = GDEXTENSION_INITIALIZATION_SCENE;
    r_initialization->userdata = nullptr;
    r_initialization->initialize = godot_java_initialize;
    r_initialization->deinitialize = godot_java_deinitialize;

    // Initialize JVM
    if (!init_jvm()) {
        std::cerr << "godot-java: JVM init failed" << std::endl;
        return 0; // false
    }

    // Store get_proc_address for trampoline lookup and JNI bridge
    g_get_proc_address = p_get_proc_address;
    g_gpa_func = p_get_proc_address;
    g_library = p_library;

    // Probe available GDExtension API functions
    std::cout << "godot-java: Probing GDExtension APIs..." << std::endl;
    const char* probe_functions[] = {
        "get_godot_version",
        "mem_alloc", "mem_alloc2", "mem_realloc", "mem_realloc2", "mem_free", "mem_free2",
        "print_error", "get_native_struct_size",
        "variant_new_copy", "variant_new_nil", "variant_destroy",
        "string_new_with_utf8_chars_and_len", "string_new_with_utf8_chars_and_len2",
        "classdb_construct_object", "classdb_construct_object2",
        "classdb_get_method_bind",
        "classdb_register_extension_class", "classdb_register_extension_class5",
        "object_method_bind_call", "object_method_bind_ptrcall",
        "object_destroy", "object_get_instance_binding",
        "get_library_path",
        "array_operator_index", "dictionary_operator_index",
    };
    for (const char* fn : probe_functions) {
        void* ptr = (void*)(p_get_proc_address(fn));
        std::cout << "godot-java:   " << fn << " => " << (ptr ? "OK" : "MISSING") << std::endl;
    }

    // Register JNI native methods for Bootstrap (trampoline registration — Task 5.5)
    if (!register_bootstrap_natives(g_jni_env)) {
        std::cerr << "godot-java: Failed to register Bootstrap natives" << std::endl;
        return 0;
    }

    // Pass function pointers to Java Panama layer
    // Note: This runs synchronously in the extension entry point before Godot's
    // multi-threaded initialization begins. Java can safely call Godot ClassDB APIs
    // here since Godot's core level is initialized first.
    call_java_init(p_get_proc_address, p_library);

    std::cout << "godot-java: init complete" << std::endl;
    std::cout.flush();
    return 1; // true
}
