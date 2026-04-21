# Building from Source

How to build godot-java from source and run end-to-end verification.

## Prerequisites

| Tool | Version          | Verify |
|---|------------------|---|
| JDK | 25+ (Panama FFI) | `java -version` |
| Maven | 4.0.x (Wrapper included) | `mvn -version` or `./mvnw --version` |
| C++ Compiler | C++17 support    | macOS: `clang++ --version`, Linux: `g++ --version` |
| Godot | 4.6+             | `godot --version` |
| Git | 2.x              | `git --version` |

Confirm `JAVA_HOME` is set:
```bash
echo $JAVA_HOME
```

## Clone the Repository

```bash
git clone --recursive https://github.com/youngledo/godot-java.git
cd godot-java
```

If you already cloned without submodules:
```bash
git submodule update --init --recursive
```

## Build the Java Code

### Quick Build

```bash
cd godot-java-core
mvn compile -Dcheckstyle.skip=true
```

The `-Dcheckstyle.skip=true` flag bypasses checkstyle during development. CI enforces checkstyle.

### Full Build

```bash
mvn clean install -DskipTests -Dcheckstyle.skip=true
```

### Verify Compilation

```bash
ls godot-java-core/target/classes/org/godot/
# Should show annotation/, bootstrap/, bridge/, core/, node/, math/, etc.
```

## Maven Module Structure

The project has a parent POM with two child modules:

```
godot-java (parent POM)
  |-- pom.xml    groupId: org.godot, artifactId: godot-java, version: 0.1.0
  |
  |-- godot-java-core/
  |     pom.xml  artifactId: godot-java-core
  |     Core binding: annotations, bridge, nodes, types
  |
  |-- godot-java-code-generator/
  |     pom.xml  artifactId: godot-java-code-generator
  |     Reads extension_api.json, generates Node wrapper classes
  |
  |-- godot-java-processor/
  |     pom.xml  artifactId: godot-java-processor
  |     APT processor: generates TypedDispatch/VirtualDispatch at compile time
  |
  |-- godot-java-examples/
        pom.xml  artifactId: godot-java-examples
        Example projects (10 examples with integration tests)
```

### Parent POM Key Properties

```xml
<groupId>org.godot</groupId>
<artifactId>godot-java</artifactId>
<version>0.1.0</version>
<packaging>pom</packaging>

<properties>
    <maven.compiler.release>25</maven.compiler.release>
    <checkstyle.config>sun_checks.xml</checkstyle.config>
</properties>
```

## Code Generation

The project uses two code generation mechanisms:

### 1. Code Generator (extension_api.json → node wrappers)

The `godot-java-code-generator` module reads Godot's `extension_api.json` and generates Java wrapper classes for engine types.

**How it works:**

1. During the `generate-sources` phase, the `exec-maven-plugin` runs `com.godot.codegen.Main`.
2. The generator reads `godot-api/extension_api.json`.
3. It generates Java source files into `target/src-gen/main/java/`.
4. The `build-helper-maven-plugin` adds the generated sources to the compile path.

**Generated artifacts:**

- `ApiIndex.java` — API function index (176 entries)
- `ApiSignatures.java` — Panama FunctionDescriptor for each API function
- `VariantType.java` — Variant type enum (47 values)
- `StructOffsets.java` — C struct field offsets
- `VirtualMethods.java` — Virtual method hash/name data
- `ObjectMethodHashes.java` — Object method bind hashes
- `virtual_method_index.txt` — Compact virtual method index (input for APT processor)
- 1016 node wrapper classes

### 2. APT Processor (annotations → typed dispatch)

The `godot-java-processor` module runs during compilation and generates per-class dispatch code from annotations.

**How it works:**

1. Maven compiles `godot-java-core` first, producing `virtual_method_index.txt` in resources.
2. The processor module copies this index into its own resources via `maven-resources-plugin`.
3. When compiling user code (e.g., `godot-java-examples`), the APT processor:
   - Reads `virtual_method_index.txt` from classpath
   - For each `@GodotClass`, walks the parent inheritance chain
   - Generates `TypedDispatch_<ClassName>.java` with MethodHandle/VarHandle dispatch
   - Generates `VirtualDispatch_<ParentClass>.java` with hash-to-name maps
   - Generates `GeneratedClassRegistry.java` with class name → Java class mapping

**Generated in user project's `target/generated-sources/annotations/`:**

| File | Purpose |
|------|---------|
| `TypedDispatch_<Class>.java` | MethodHandle dispatch for @GodotMethod, VarHandle for @Export |
| `VirtualDispatch_<Parent>.java` | Per-parent-class hash maps for virtual method resolution |
| `GeneratedClassRegistry.java` | Class name → Java Class mapping (replaces runtime scanning) |

**To verify APT generation:**

```bash
ls godot-java-examples/target/generated-sources/annotations/org/godot/internal/
# Should show TypedDispatch_*.java, VirtualDispatch_*.java, GeneratedClassRegistry.java
```

## Upgrading to a New Godot Version

When Godot releases a new version (e.g. 4.7, 4.8), use the upgrade script:

```bash
./upgrade-godot-api.sh 4.7
```

### What It Does

1. Downloads the matching `extension_api.json` and `gdextension_interface.json` from the [godot-cpp](https://github.com/godotengine/godot-cpp) repository (tagged release)
2. Re-runs the code generator (`mvn generate-sources`)

### What Gets Auto-Updated

The code generator automatically regenerates these files from the JSON sources:

| File | Source | Description |
|------|--------|-------------|
| `StructOffsets.java` | `gdextension_interface.json` types[] | C struct field offsets (CreationInfo4, PropertyInfo, MethodInfo) |
| `VirtualMethods.java` | `extension_api.json` classes[] | Virtual method names for Node and parent classes |
| `ObjectMethodHashes.java` | `extension_api.json` classes[] | Method bind hashes for Object |
| 1016 node classes | `extension_api.json` classes[] | Engine type wrappers (Sprite2D, CharacterBody2D, etc.) |

Runtime files (`InstanceCallbacks`, `MethodRegistration`, `PropertyRegistration`, `SignalRegistration`, `VirtualDispatch`) reference the generated constants — no manual updates needed when struct layouts change.

The APT processor reads `virtual_method_index.txt` (generated by the code generator) at compile time. When upgrading, this file is automatically regenerated, so per-class dispatch data stays in sync.

### What Remains Hand-Written

Three files are intentionally kept hand-written:

- `ApiIndex.java` — API function index (176 enum values)
- `ApiSignatures.java` — Panama `FunctionDescriptor` for each API function
- `VariantType.java` — Variant type enum (47 values)

**Reason:** The `interface[]` section of `gdextension_interface.json` has inaccurate parameter lists for approximately 77 out of 176 functions compared to the actual C ABI in `gdextension_interface.h`. Auto-generating from the JSON would produce wrong function signatures, causing runtime crashes (e.g. Variant constructor failures).

If Godot fixes the JSON accuracy in a future release, these files can be switched to auto-generation by uncommenting the corresponding lines in `Main.java`.

### After Running the Script

```bash
# Full build to verify everything compiles
./mvnw clean install -DskipTests
```

If the build fails after an upgrade:

1. Check if Godot changed any struct layouts — the generated `StructOffsets` will reflect the new values automatically
2. Check if new virtual methods were added — the APT processor will automatically generate updated `VirtualDispatch_<Parent>` classes with the new virtual methods. If a new parent class is introduced, you may need to add it to the processor's index
3. Check if `ApiSignatures` needs manual updates — compare `gdextension_interface.h` against the hand-written signatures

## Build the Native Library

The native library is a C++ shared library that acts as the GDExtension entry point and embeds the JVM. It must be compiled separately for each platform.

### macOS

```bash
cd godot-java-core/native
bash build-macos.sh
```

Or manually:

```bash
clang++ -shared -fPIC \
  -o build/libgodot-java.dylib \
  -I $JAVA_HOME/include \
  -I $JAVA_HOME/include/darwin \
  -I ../../godot-cpp/include \
  -I ../../godot-cpp/gen/include \
  src/godot_java.cpp \
  ../../godot-cpp/bin/libgodot-cpp.macos.template_debug.universal.a \
  -stdlib=libc++ -std=c++17
```

The macOS build produces a universal binary (x86_64 + ARM64).

### Linux

```bash
g++ -shared -fPIC \
  -o build/libgodot-java.so \
  -I $JAVA_HOME/include \
  -I $JAVA_HOME/include/linux \
  -I ../../godot-cpp/include \
  -I ../../godot-cpp/gen/include \
  src/godot_java.cpp \
  ../../godot-cpp/bin/libgodot-cpp.linux.template_debug.x86_64.a \
  -std=c++17
```

### Windows

From a Visual Studio Developer Command Prompt:

```powershell
cl.exe /LD /EHsc /Fe:build\godot-java.dll ^
  /I"%JAVA_HOME%\include" /I"%JAVA_HOME%\include\win32" ^
  /I"..\..\godot-cpp\include" /I"..\..\godot-cpp\gen\include" ^
  src\godot_java.cpp ^
  ..\..\godot-cpp\bin\godot-cpp.windows.template_debug.x86_64.lib
```

### Verify the Build

```bash
ls -lh build/libgodot-java.*     # should be ~2MB
file build/libgodot-java.dylib   # macOS: universal binary
```

## Cross-Platform Libraries

| Platform | File Extension | Build Script |
|---|---|---|
| macOS (ARM64 + x86_64) | `.dylib` | `build-macos.sh` |
| Linux (x86_64) | `.so` | manual g++ command |
| Windows (x86_64) | `.dll` | manual MSVC command |

## End-to-End Verification

### Step 1: Compile Java

```bash
cd godot-java-core
mvn compile -Dcheckstyle.skip=true -q
```

### Step 2: Deploy Native Library

Copy the compiled native library to your Godot test project:

```bash
mkdir -p /path/to/test-project/native
cp godot-java-core/native/build/libgodot-java.dylib \
   /path/to/test-project/native/
```

### Step 3: Configure Classpath

The C++ layer creates the JVM with a classpath pointing to your compiled classes. Verify:

```bash
ls godot-java-core/target/classes/org/godot/bridge/Bridge.class
```

Optionally set the classpath via environment variable:
```bash
export GODOT_JAVA_CLASSPATH=/path/to/godot-java/godot-java-core/target/classes
```

### Step 4: Run Godot

```bash
# macOS (command line to see terminal output)
/Applications/Godot.app/Contents/MacOS/Godot --path /path/to/test-project
```

### Step 5: Verify Output

Expected terminal output:

```
godot-java: Loading JVM library...
godot-java: JVM initialized successfully!
godot-java: Bootstrap.init() completed successfully!
Registered Java class: HealthComponent (parent: Node)
```

### Verification Checklist

| Check | Expected |
|---|---|
| JVM starts | "JVM initialized successfully!" |
| Bridge loads | "Bootstrap.init() completed successfully!" |
| Classes registered | "Registered Java class: ..." |
| No crash | No `hs_err_pid*.log` files |

## Common Build Issues

### JAVA_HOME Not Set

```bash
# macOS: find JDK 25
/usr/libexec/java_home -V
export JAVA_HOME=$(/usr/libexec/java_home -v 25)

# Linux
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64
```

### Maven Build Fails

```bash
mvn clean install -U -Dcheckstyle.skip=true
```

### Native Compilation Fails

1. Verify all include paths exist.
2. Ensure `godot-cpp` submodule is initialized: `git submodule update --init --recursive`.
3. Confirm the C++ compiler supports C++17.
4. Check that JNI headers exist at `$JAVA_HOME/include`.

### Godot Cannot Load Library

1. Verify `.gdextension` paths.
2. Check library architecture matches Godot.
3. Ensure execute permission: `chmod +x native/libgodot-java.*`


## Cross-Platform Build Details

### .gdextension File Format

The `.gdextension` file must include library paths for all target platforms:

```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = "4.6"

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
linux.debug = "res://native/libgodot-java.so"
linux.release = "res://native/libgodot-java.so"
windows.debug = "res://native/libgodot-java.dll"
windows.release = "res://native/libgodot-java.dll"
```

### Linux Build Requirements

| Dependency | Version | Install Command |
|------------|---------|-----------------|
| GCC/G++ | 12+ | `sudo apt install build-essential` |
| JDK | 25+ | SDKMAN: `sdk install java 25-tem` |
| Maven | 4.0.x | `sdk install maven 4.0.0-rc-3` |

Build steps:

```bash
# Java compilation
./mvnw clean package -DskipTests

# Native library compilation
cd godot-java-core/native
./build-linux.sh

# Verify
ldd build/libgodot-java.so
nm build/libgodot-java.so | grep godot_java_init
```

### Windows Build Requirements

| Dependency | Version | Notes |
|------------|---------|-------|
| MSVC | 2022+ | Install via Visual Studio Installer |
| JDK | 25+ | Eclipse Temurin recommended |
| Maven | 4.0.x | Download and add to PATH |

Build steps:

```cmd
:: Run in Developer Command Prompt for VS
mvnw.cmd clean package -DskipTests
cd godot-java-core\native
build-windows.bat
```

### Deployment Directory Structure

```
your-godot-project/
  godot-java.gdextension
  native/
    libgodot-java.dylib    # macOS
    libgodot-java.so       # Linux
    libgodot-java.dll      # Windows
  project.godot
```

### Continuous Integration

The project includes a GitHub Actions configuration (`.github/workflows/ci.yml`)
with automated build and test for macOS and Linux.
