# 架构概览

godot-java 是 Godot Engine 4.6 的 Java 语言绑定，使用 [Panama FFI](https://openjdk.org/projects/panama/)（Foreign Function & Memory API）实现 Java 与 Godot C++ 核心之间的高性能原生互操作。

## 核心特性

- **嵌入式 JVM** -- 无需外部进程，JVM 直接运行在 Godot 进程内部
- **Panama FFI** -- 基于 `java.lang.foreign` 的现代 Java 原生互操作（Java 25+）
- **完整 Godot API 访问** -- 从 Java 调用任意 Godot 方法
- **类型安全注解** -- `@GodotClass`、`@GodotMethod`、`@Export`、`@Signal`
- **APT 编译期代码生成** -- 零反射 MethodHandle 分派，性能提升 3.7x
- **编辑器集成** -- Java 类出现在 Godot 编辑器中

## 项目结构

```
godot-java/
├── godot-java-core/                  # 核心：嵌入式 JVM 模块
│   ├── native/
│   │   ├── src/godot_java.cpp        # C++ GDExtension 入口（~800 行）
│   │   ├── build-macos.sh            # macOS 编译脚本
│   │   ├── build-linux.sh            # Linux 编译脚本
│   │   └── build-windows.bat         # Windows 编译脚本
│   └── src/main/java/org/godot/
│       ├── Godot.java                # 所有 Godot 对象的抽象根类
│       ├── GodotObject.java          # 对象包装器
│       ├── annotation/
│       │   ├── GodotClass.java       # @GodotClass 注解
│       │   ├── GodotMethod.java      # @GodotMethod 注解
│       │   ├── Export.java           # @Export 注解
│       │   └── Signal.java           # @Signal 注解
│       ├── bootstrap/
│       │   └── Bootstrap.java        # C++ -> Java 初始化入口
│       ├── bridge/
│       │   ├── Bridge.java           # Panama FFI 桥接（176 个 API MethodHandle）
│       │   ├── ApiSignatures.java    # API 函数签名定义
│       │   ├── MethodBindCache.java  # 方法绑定缓存
│       │   ├── MethodDispatch.java   # 方法分发
│       │   ├── MethodRegistration.java  # @GodotMethod 注册
│       │   ├── PropertyRegistration.java # @Export 注册
│       │   ├── SignalRegistration.java   # @Signal 注册
│       │   ├── InstanceCallbacks.java    # create/free instance 回调
│       │   ├── UpcallStub.java       # Panama upcall stub 创建
│       │   └── VirtualDispatch.java  # 虚方法分发
│       ├── core/
│       │   ├── Variant.java          # Godot Variant 类型包装器（24 字节）
│       │   ├── GodotString.java      # Godot String 包装器
│       │   ├── GodotStringName.java  # Godot StringName 包装器
│       │   ├── VariantUtils.java     # Variant <-> Java 类型转换
│       │   ├── Callable.java         # Godot Callable 包装器
│       │   ├── RefCounted.java       # RefCounted 基类
│       │   └── Signal.java           # 信号运行时
│       ├── collection/
│       │   ├── GodotArray.java       # Godot Array 包装器
│       │   └── GodotDictionary.java  # Godot Dictionary 包装器
│       ├── math/
│       │   ├── Vector2.java          # 2D 向量
│       │   ├── Vector3.java          # 3D 向量
│       │   └── ...                   # 其他数学类型
│       ├── node/
│       │   ├── Node.java             # Node 基类
│       │   ├── Node2D.java           # 2D 节点
│       │   ├── Node3D.java           # 3D 节点
│       │   ├── Control.java          # UI 节点
│       │   └── Viewport.java         # 视口
│       ├── internal/
│       │   ├── api/ApiIndex.java     # 176 个 API 函数索引
│       │   ├── api/VariantType.java  # Variant 类型枚举
│       │   ├── ref/JavaObjectMap.java    # nativePtr <-> Java 对象映射
│       │   ├── ref/GenericGodotObject.java # 通用对象包装器
│       │   ├── GeneratedClassRegistry.java # APT 生成的类名 -> Java 类映射
│       │   └── memory/               # 内存管理工具
│       ├── registration/
│       │   ├── Scanner.java          # classpath 扫描
│       │   └── Registry.java         # 类注册引擎
│       └── generated/                # 代码生成器输出
├── godot-java-processor/              # APT 注解处理器
│   └── src/main/java/org/godot/processor/
│       └── GodotClassProcessor.java   # 处理 @GodotClass，生成分派类
├── godot-java-code-generator/        # Extension API 解析器与代码生成
│   └── src/main/java/com/godot/codegen/
│       ├── ExtensionApiParser.java   # 解析 extension_api.json
│       ├── ClassInfo.java            # 类元数据
│       ├── TypeMapper.java           # Godot -> Java 类型映射
│       └── Main.java                 # 生成器入口
├── godot-api/            # Godot API JSON 数据
├── godot-cpp/            # Godot C++ 绑定（Git 子模块）
├── docs/                 # 文档
└── pom.xml              # Maven 父 POM
```

## 三层架构

```
┌─────────────────────────────────────────┐
│         Godot 编辑器 / 运行时            │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│     C++ 薄层 (~800 行)                   │
│  - GDExtension 入口点 (godot_java_init)  │
│  - JVM 生命周期管理 (JNI_CreateJavaVM)   │
│  - JNI 桥接 (getProcAddress 等)         │
│  - 崩溃处理器                           │
└─────────────────┬───────────────────────┘
                  │ JNI
┌─────────────────▼───────────────────────┐
│       Java 层 (Panama FFI)              │
│  - Bootstrap (两阶段初始化)             │
│  - Bridge (176 个 API MethodHandle)     │
│  - Variant (类型转换)                   │
│  - GodotObject (对象包装)               │
│  - InstanceCallbacks (create/free)      │
│  - VirtualDispatch (APT 虚方法分发)     │
│  - APT Processor (编译期代码生成)       │
│  - 你的游戏逻辑                         │
└─────────────────────────────────────────┘
```

### C++ 薄层

C++ 薄层位于 `godot-java-core/native/src/godot_java.cpp`，职责：

- **GDExtension 生命周期**：实现 `godot_java_init` 入口函数，填充 `GDExtensionInitialization` 结构体
- **JVM 嵌入**：通过 `JNI_CreateJavaVM` 创建 JVM 实例，传递 `--enable-native-access=ALL-UNNAMED` 等参数
- **JNI 桥接**：注册 3 个 JNI native 方法供 Java 调用：
  - `getProcAddressImpl(String)` -- 解析 GDExtension API 函数地址
  - `registerUpcallTrampoline(String, String, long)` -- 注册 upcall 函数指针
  - `getLibraryPtrImpl()` -- 获取 library 指针
- **初始化回调**：在 SCENE 初始化级别调用 Java 的 `registerClasses()`
- **崩溃处理器**：捕获 SIGSEGV/SIGABRT 等信号，打印 native 和 Java 堆栈

### Panama FFI 层

Java 层是核心绑定逻辑所在：

- **Bridge**：通过 JNI `getProcAddressImpl` 获取每个 API 函数地址，然后用 `Linker.nativeLinker().downcallHandle()` 将其解析为 `MethodHandle`，缓存在 `API[]` 数组中
- **Arena（两层策略）**：持久 Arena 用于注册阶段的 upcall stub 和静态数据；运行时调用路径使用 Java 25 `ScopedValue` 绑定的 scoped arena，每次 `Godot.call()` 等方法调用自动创建和释放，临时 Variant 在释放前调用 `variant_destroy` 清理 Godot 内部引用
- **类型映射**：`void*` -> `MemorySegment`，`int64_t` -> `JAVA_LONG`，实现 Godot 类型与 Java 类型的安全转换
- **APT 代码生成**：编译期处理 `@GodotClass`，生成 `TypedDispatch_*` 和 `VirtualDispatch_*`，实现零反射方法分派

## 初始化流程

### 两阶段初始化

```
Godot 加载 .gdextension
  |
godot_java_init() 被调用
  |
  +-- C++ 层: find_jvm_library() -> 搜索 libjvm
  +-- C++ 层: init_jvm() -> JNI_CreateJavaVM 创建 JVM
  +-- C++ 层: register_bootstrap_natives() -> 注册 JNI 方法
  +-- C++ 层: call_java_init() -> JNI 调用 Bootstrap.init()
  |
  +-- Java Phase 1: Bootstrap.init(getProcAddress, libraryPtr)
  |     |
  |     +-- Bridge.load() -> 遍历 ApiIndex，解析 176 个 API 函数为 MethodHandle
  |     +-- Variant.initConstructors() -> 初始化 Variant 类型构造器
  |     +-- Registry.registerBuiltinTypes() -> 注册内建类型
  |     +-- Scanner.scan() -> 扫描 classpath 中的 @GodotClass 类
  |     +-- GeneratedClassRegistry.load() -> 加载 APT 生成的类注册表
  |
Godot 进入 SCENE 初始化级别
  |
  +-- godot_java_initialize(SCENE) 被调用
  |
  +-- Java Phase 2: Bootstrap.registerClasses()
        |
        +-- Registry.registerUserClasses() -> 注册所有 @GodotClass 类
              |
              +-- InstanceCallbacks.registerClass() -> 注册类映射
              +-- InstanceCallbacks.createCreationInfo() -> 创建 CreationInfo4 结构体
              |     +-- create_instance_func upcall stub
              |     +-- free_instance_func upcall stub
              |     +-- get_virtual_func upcall stub (VirtualDispatch)
              +-- classdb_register_extension_class5() -> 注册到 ClassDB
              +-- MethodRegistration.registerMethods() -> 注册 @GodotMethod
              +-- PropertyRegistration.registerProperties() -> 注册 @Export
              +-- SignalRegistration.registerSignals() -> 注册 @Signal
```

## 方法分发机制

### APT 生成的类型化分派

APT 处理器（`godot-java-processor`）在编译期为每个 `@GodotClass` 生成：

- `TypedDispatch_<ClassName>` -- MethodHandle/VarHandle 方法分派（零反射）
- `VirtualDispatch_<ParentClass>` -- 按父类的 hash 映射（减少候选名称从 1000+ 到 ~12）
- 属性访问 VarHandle

运行时优先使用 APT 数据，无 APT 数据时回退到反射。

### GDScript 调用 Java 方法

```
GDScript: object.my_method(arg)
  |
Godot: classdb_get_method_bind(className, methodName, hash)
  |
Godot: object_method_bind_call(bind, object, args, argc, result, error)
  |
C++ methodCallCallback (通过 upcall stub 注册)
  |
Java: MethodDispatch.dispatch()
  |
APT 路径: TypedDispatch_<ClassName>.dispatch(obj, args) -> MethodHandle 调用
反射回退: Method.invoke(obj, args)
  |
返回结果经 Variant 转换回 GDScript
```

### ptrcall 零拷贝分派

- `MethodDispatch.ptrcallAdapter()` 接收类型化指针而非 Variant
- `readTypedPtr()` 直接读取原语类型（double, float, int, long, boolean）
- RefCounted 参数通过 `ref_get_object` 提取，非 RefCounted 直接解引用
- `writeTypedPtr()` 写入返回值
- APT 生成的 `TypedDispatch_<ClassName>` 使用 MethodHandle 分派

### 虚方法分派（对齐 gdext/Rust）

虚方法分派架构对齐 gdext（Rust GDExtension 绑定）：

1. **APT 生成 `VirtualDispatch_<ParentClass>`** -- 包含该父类继承链的所有虚方法 hash-to-name 映射。例如 `VirtualDispatch_Node` 有 ~12 个条目，而非全局的 527 个。

2. **每个类独立的 `get_virtual_func`** -- 每个注册类获得自己的 upcall stub。未 override 的方法返回 NULL。

3. **Hash -> name 解析** -- Godot 通过兼容性 hash 识别虚方法。APT 生成的映射将 hash 解析为候选名称（通常 2-5 个）。Hash 冲突通过 StringName 指针比较解决。

4. **MethodHandle 分派** -- 注册时预创建 MethodHandle，适配接收者为 Godot 类型：
   - 优先使用缓存 MethodHandle（零反射，~36ns/调用）
   - 回退到 Method.invoke()（~134ns/调用）

```
callVirtualAdapter(methodName, instance, args, ret)
  |
  +-- JavaObjectMap.get(instanceAddr) -> Java 对象
  +-- findMethodEntry(obj.getClass(), methodName) -> 缓存的 MethodEntry
  +-- 若 handle != null:
  |     MethodHandle.dispatch(obj, args...) -> result（快速路径）
  +-- 否则:
        Method.invoke(obj, args) -> result（反射回退）
  +-- VariantUtils.fromObject(result) -> 写入返回 Variant
```

### 实例管理

```
create_instance_func(classUserdata, notifyPostinit):
  1. USERDATA_TO_CLASS_NAME 查找类名
  2. 反射创建 Java 实例
  3. classdb_construct_object2(parentName) 创建原生对象
  4. 反射设置 Java 实例的 nativeObject 字段
  5. JavaObjectMap.put(nativePtr, javaInstance) 注册映射
  6. object_set_instance() 注册扩展实例
  7. 返回 nativePtr

free_instance_func(classUserdata, instancePtr):
  1. JavaObjectMap.remove(instancePtr) 移除映射
  2. 调用 obj.onFreed() 通知清理
```

## 生命周期回调

CreationInfo4 结构体连接的回调：

| 回调 | 偏移 | 用途 |
|------|------|------|
| `set_func` / `get_func` | 24 / 32 | @Export 字段属性访问 |
| `get_property_list_func` | 40 | 暴露 @Export 字段到 Inspector |
| `free_property_list_func` | 48 | 释放属性列表内存 |
| `property_can_revert_func` | 52 | 判断是否有默认值 |
| `property_get_revert_func` | 56 | 返回默认值 Variant |
| `validate_property_func` | 64 | 属性验证透传 |
| `notification_func` | 72 | 转发 Godot 通知到 `onNotification(int)` |
| `to_string_func` | 80 | Java `toString()` 桥接到 Godot |
| `reference_func` / `unreference_func` | 88 / 96 | RefCounted 原子引用计数 |
| `create_instance_func` | 104 | 创建 Java 对象，注册到 JavaObjectMap |
| `free_instance_func` | 112 | 从 JavaObjectMap 移除，调用 `onFreed()` |
| `get_virtual_func` | 128 | 返回虚方法分派 stub |

## 关键类

| 类名 | 包 | 职责 |
|------|---|------|
| `Bridge` | `org.godot.bridge` | 176 个 API MethodHandle 入口，全局 Arena |
| `Bootstrap` | `org.godot.bootstrap` | 两阶段初始化入口，C++ 通过 JNI 调用 |
| `Variant` | `org.godot.core` | Godot Variant 包装器（24 字节），类型转换 |
| `Godot` | `org.godot` | 所有 Godot 对象的抽象根类 |
| `GodotObject` | `org.godot` | 引擎对象包装器 |
| `Registry` | `org.godot.registration` | 类注册引擎，协调注解扫描和 ClassDB 注册 |
| `Scanner` | `org.godot.registration` | 模块路径扫描，发现 @GodotClass 类 |
| `InstanceCallbacks` | `org.godot.bridge` | CreationInfo4 结构体、create/free instance 回调 |
| `VirtualDispatch` | `org.godot.bridge` | 虚方法分发，get_virtual_func 回调 |
| `MethodDispatch` | `org.godot.bridge` | 普通 @GodotMethod 方法分发 |
| `MethodBindCache` | `org.godot.bridge` | 方法绑定缓存 |
| `JavaObjectMap` | `org.godot.internal.ref` | nativePtr <-> Java 对象双向映射 |
| `ApiIndex` | `org.godot.internal.api` | 176 个 API 函数索引枚举 |
| `VariantType` | `org.godot.internal.api` | Variant 类型 ID 枚举 |
| `GodotString` | `org.godot.core` | Godot String 包装器 |
| `GodotStringName` | `org.godot.core` | Godot StringName 包装器 |
| `GodotClassProcessor` | `org.godot.processor` | APT 注解处理器，生成 TypedDispatch/VirtualDispatch |
| `GeneratedClassRegistry` | `org.godot.internal` | APT 生成的类名 -> Java 类映射 |
| `TypedDispatch_*` | `org.godot.internal`（生成） | 按类的 MethodHandle 方法分派 |
| `VirtualDispatch_*` | `org.godot.internal`（生成） | 按父类的虚方法 hash 映射 |

### 类继承体系

```
Godot (抽象根类，org.godot)
├── GodotObject (引擎对象)
├── RefCounted (引用计数，org.godot.core)
│   └── GodotDictionary (字典)
├── GodotArray (数组，org.godot.collection)
└── Node (场景节点，org.godot.node)
    ├── Node2D
    ├── Node3D
    ├── Control
    └── Viewport
```

## GDExtension 配置

`godot-java.gdextension` 示例：

```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = 4.6

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
linux.debug = "res://native/libgodot-java.so"
linux.release = "res://native/libgodot-java.so"
windows.debug = "res://native/godot-java.dll"
windows.release = "res://native/godot-java.dll"
```

## 性能特征

### Panama FFI 调用开销

- **Panama 直接调用**：约 50ns/次
- **经 JNI 桥接（getProcAddress）**：约 200ns/次
- **Bridge.call() 完整流程**（含方法查找、参数转换、Variant 处理）：约 500ns/次
- 显著快于 GDScript，约为 C++ GDExtension 的 2-3 倍开销

### 分派性能基准

| 分派路径 | 每次调用 | 对比直接调用 |
|---------|---------|------------|
| 直接虚调用 | ~17 ns | 1x（基准） |
| MethodHandle（APT） | ~36 ns | 2.1x |
| Method.invoke()（反射） | ~134 ns | 7.9x |

APT 生成的 MethodHandle 分派比反射快 **3.7x**。

### 优化建议

1. 使用 `MethodBindCache` 缓存方法绑定，避免重复查找
2. 使用类型专用方法减少 Variant 转换
3. 缓存频繁使用的对象引用
4. 批量操作替代逐个调用
5. 尽量减少跨 Java-Godot 边界的调用次数
