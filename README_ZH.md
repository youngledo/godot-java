# godot-java

中文 | [ENGLISH](README.md)

---

## 概览

[Godot](https://godotengine.org/zh-cn/) 的 Java 绑定，通过 GDExtension + Panama FFI 让 Java 在 Godot 生态中成为一等公民。

> 状态：0.1.0——生产就绪，具备 scoped 内存管理和完整的 GDExtension 功能覆盖。

项目示例：
- [godot-java-examples](godot-java-examples/README_ZH.md)
- [godot-java-3d-demo](https://github.com/youngledo/godot-java-3d-demo)

---

## 为什么会有这个项目？

在游戏开发领域，语言的”默认组合”很多年都没有 Java 的位置：

- Unity 以 C# 作为脚本语言——没有 Java
- Unreal Engine 坚定地走 C++ 路线——没有 Java
- Godot 官方只提供 GDScript 和 C#——没有 Java
- 即便是社区维护的绑定（如 godot-kotlin-jvm）也只面向 Kotlin，或者需要重编译引擎

而与此同时，Java 仍然是全球使用最广泛的语言之一——在企业后端、Android 开发和大规模数据处理领域占据主导地位。每天有数百万开发者在写 Java，但游戏引擎生态却几乎不给他们任何选择。

这对已经有成熟 Java 技术栈的团队来说，是一个真正的缺口：

- 现有的业务代码、工具链和工程实践都建立在 Java 之上
- 想要尝试游戏引擎，往往意味着：
  - 要么新学一套 C++/GDScript/C#
  - 要么在 Java 与引擎语言之间维护一层脆弱的桥接

**godot-java 想做的事情，就是打破这种“游戏开发没有 Java”的惯例**：

- 让 Java 在 Godot 生态里也能成为一等公民
- 让已有 Java 团队可以直接复用：
  - 熟悉的语言与 IDE（IntelliJ IDEA / Eclipse / VS Code 等）
  - 现有的构建与依赖管理（Maven/Gradle）
  - 成熟的测试、日志、诊断、CI/CD 工具链

从工程角度看，目标是：

- 提供一个尽量“原生”的 Java 体验（注解驱动、强类型 API、现代 FFI）
- 避免在 Java 侧堆砌大量 JNI 辅助代码，而是直接拥抱 Java 25 的 Panama FFI

---

## 为什么选择 Java 25？

这个项目一开始就选择 **Java 25+**，而不是兼容 Java 8/11/17 等 LTS 版本，原因有三点：

1. **避免历史包袱**  
   不再背负旧版 Java 的限制，只针对一个现代版本设计 API 和内部实现，代码可以更干净、更直接，不需要为了兼容早期 JDK 写各种分支和适配层。

2. **用上最新的语言与平台特性**  
   可以放心使用：
   - 记录类型（records）、密封类（sealed）、模式匹配（pattern matching）
   - 更强的 `switch` 表达式和 `var` 等语法糖
   - 更完善的 `java.lang.foreign` Panama FFI API  
   这些特性让绑定代码本身也可以保持现代 Java 的风格，而不是“C 风格 Java”。

3. **满足你对现代 Java 的一切想象**  
   目标是让使用者可以在游戏项目里，尽情使用最新一代 Java 的表达能力和工具链：  
   - 既写游戏逻辑，又享受现代 Java 的类型系统和库生态  
   - 不需要担心“因为要兼容旧版本，所以很多语言特性不能用”

如果你只是想探索 “Godot + 现代 Java + Panama FFI” 能做到什么，这个项目会更偏向一个“给你一个完全现代的起点”，而不是一个“从历史包袱里一路升级上来的 SDK”。

---

## 它做了什么？（功能概览）

目前已实现的核心能力包括：

- **Godot GDExtension 绑定（C API）**
  - 通过 `GDExtensionInterfaceGetProcAddress` 动态加载 Godot API
  - 基于 C 结构体（`GDExtensionClassLibraryPtr`, `GDExtensionPropertyInfo`, `GDExtensionClassMethodInfo` 等）完成注册

- **Java 25 Panama FFI 集成**
  - 使用 `java.lang.foreign`（`Linker`, `FunctionDescriptor`, `MemorySegment` 等）调用 Godot 的 C 函数
  - 完全避免项目自定义的 JNI 辅助库，减少一层胶水代码

- **注解驱动的类 / 方法 / 属性 / 信号注册**
  - `@GodotClass`：声明一个可以在 Godot 中实例化的 Java 类
  - `@GodotMethod`：暴露给 Godot 调用的成员方法
  - `@Export`：导出到 Godot Inspector 的属性，支持 `hint` 和 `hintString` 参数用于编辑器集成
  - `@Signal`：在 Java 侧声明并发射 Godot 信号
  - APT 注解处理器（`godot-java-processor`）在编译期生成类型化分派代码，热路径零反射

- **虚方法与生命周期回调**
  - 支持全部 1144 个虚方法（从 `extension_api.json` 自动扫描）
  - 支持常见 Godot 生命周期方法（例如 `_ready`, `_process`, `_physics_process` 等）
  - Java 实例与 Godot 对象通过映射表关联，虚方法通过 upcall stub 回调到 Java
  - 生命周期回调包括：通知转发（`notification`）、字符串表示（`toString` 桥接）、引用计数（`RefCounted` 的原子引用计数）、属性验证等

- **ptrcall 零拷贝分派**
  - 基于类型化指针的分派，避免 `Variant` 装箱开销
  - APT 生成的 `MethodHandle` 分派，针对注册的 `@GodotMethod` 方法
  - 对 `RefCounted` 派生类使用 `ref_get_object`/`ref_set_object` 处理 `RefPtr` 参数

- **类型系统与 Variant 互操作**
  - 提供 Java 侧的 `Variant`, `GodotStringName`, `GodotString`, `GodotArray`, `GodotDictionary` 等类型
  - 支持常见 Java 类型与 Godot Variant 之间的安全转换

---

## 使用了哪些技术？亮点是什么？

从技术栈角度，这个项目的几个关键点：

1. **GDExtension（Godot 4 官方扩展机制）**
   - 不依赖旧的 GDNative/JNI 插件方案
   - 与 Godot 的生命周期和加载方式保持一致
   - 可以作为共享库加载（`.dylib / .so / .dll`）

2. **Java 25 Panama FFI**
   - 使用标准库中的 FFI（`java.lang.foreign`），不需要第三方 native bridge
   - 函数签名和内存布局通过 `FunctionDescriptor`、`MemoryLayout` 精确建模
   - 更容易在 IDE 中追踪、调试和重构

3. **注解驱动的注册模型**
   - 通过注解和反射生成 Godot 需要的注册信息
   - 避免在 C++/C 侧写大量重复的 class/method 注册代码
   - 较为贴近”普通 Java 应用”的开发体验

---

## 架构

分派架构与 [gdext](https://github.com/godot-rust/gdext)（Rust 绑定）对齐：upcall stub 在类注册时按需创建，仅为用户实际 override 的方法创建 stub。未实现的方法返回 `NULL`，由 Godot 使用默认的 C++ 实现。

### 1. APT 生成的类型化分派

注解处理器（`godot-java-processor`）在编译期为每个类生成分派代码：

- **`TypedDispatch_<ClassName>`** — 基于 `MethodHandle`/`VarHandle` 的方法分派（热路径零反射）
- **`PropertyAccess_<ClassName>`** — 基于 `VarHandle` 的 `@Export` 属性访问
- **`VirtualDispatch_<ParentClass>`** — 按父类分组的虚方法哈希映射（将候选方法名从 1000+ 缩减到约 12 个）
- 当 APT 生成的数据不可用时，回退到运行时反射

### 2. 虚方法分派（对齐 gdext/Rust）

- 按类的 `get_virtual_func` upcall stub — 按需创建，仅为用户实际 override 的方法生成
- APT 生成的按父类哈希解析 — 消除不同类之间同名方法的误匹配
- `MethodHandle` 预缓存分派，辅以反射回退
- 通过 `StringName` 指针比较解决哈希冲突

### 3. 生命周期回调

- **`notification_func`** — 将 Godot 通知转发到 Java 实例的 `onNotification(int)`
- **`to_string_func`** — 将 Java `toString()` 桥接到 Godot 的字符串表示
- **`reference_func` / `unreference_func`** — 为 `RefCounted` 派生类提供原子引用计数
- **`validate_property_func`** — 属性验证透传，用于编辑器集成

### 4. ptrcall 支持

- 零拷贝类型化指针分派 — 避免方法调用时的 `Variant` 装箱开销
- 感知 RefCounted — 对 `RefPtr` 参数使用 `ref_get_object`/`ref_set_object`
- APT 生成的 `MethodHandle` 分派，用于已注册的 `@GodotMethod` 方法

### 5. 属性系统

- `@Export` 注解支持 `hint` 和 `hintString` 参数，用于 Godot 编辑器集成
- `get_property_list_func` — 将 `@Export` 字段暴露到 Godot Inspector
- `property_can_revert_func` / `property_get_revert_func` — 默认值支持，提供还原行为
- `@Signal` 注解用于信号声明和从 Java 发射信号

---

## 与其他语言绑定的对比

将其他语言引入 Godot 有多种方式。以下是 godot-java 与主要替代方案的对比：

| | 集成方式 | FFI 层 | 虚方法 | ptrcall | 用户门槛 | 成熟度   |
|---|---|---|---|---|---|-------|
| **godot-java** | GDExtension | Panama FFI (Java 25) | 全部 1144 个 | 支持 | 低（无需重编译引擎） | Alpha |
| **[godot-rust/gdext](https://github.com/godot-rust/gdext)** | GDExtension | Rust FFI | 全部支持 | 支持 | 低（无需重编译引擎） | 稳定    |
| **[graphics.gd (Go)](https://github.com/quaadgras/graphics.gd)** | GDExtension | CGO | 支持 | — | 低（无需重编译引擎） | 社区维护  |
| **[godot-kotlin-jvm](https://github.com/utopia-rise/godot-kotlin-jvm)** | 引擎模块 | JNI | 全部支持 | 支持 | **高（需要重编译 Godot）** | 稳定    |
| C#（官方） | 引擎模块 | N/A | 全部支持 | 支持 | 中（内置 Mono） | 官方    |

### 根本区别：引擎模块 vs GDExtension

两种集成方式的核心差异在于语言如何与 Godot 结合：

- **GDExtension** 是 Godot 4 的官方插件 API。基于它的语言会编译为共享库（`.so`/`.dylib`/`.dll`），Godot 在运行时加载。用户只需下载标准 Godot 即可，无需重编译引擎。godot-java、gdext、graphics.gd 均走这条路。

- **引擎模块** 将语言直接编译进 Godot C++ 进程。好处是可以完全访问引擎所有能力（全部虚方法、直接调用 `Input.*` 等），但代价是必须从源码重编译整个 Godot。godot-kotlin-jvm（JVM 必须嵌入进程）和 C#（Godot 内置）走这条路。

### 对 godot-java 的影响

godot-java 选择了 GDExtension 路线。支持全部 1144 个虚方法（从 `extension_api.json` 自动扫描）。分派架构对齐 gdext（Rust 绑定）：upcall stub 在类注册时按需创建，仅为用户实际 override 的方法创建 stub。未实现的方法返回 NULL，由 Godot 使用默认 C++ 实现。

如果你熟悉 gdext：godot-java 的架构目标与其相似，只是用 Java 替代了 Rust，用 Panama FFI 替代了 Rust 原生 FFI。

---

## 文档导航

本仓库的文档分为英文与中文两套，针对不同读者做了区分。

- 文档索引：`docs/README.md`  
  - 概览整个文档结构  
  - 帮助你快速找到对应语言 / 角色的文档入口

### 中文文档（面向中文社区）

中文文档分为两部分：

- 用户文档：`docs/zh/user/`
  - `getting-started.md` — 快速开始
  - `api.md` — 常用 API 与类型说明
  - `guide.md` — 使用指南与实践建议
  - `troubleshooting.md` — 常见问题处理

- 开发者文档：`docs/zh/dev/`
  - `architecture.md` — 项目架构与内部实现
  - `building.md` — 如何构建、打包与升级 Godot 版本
  - `contributing.md` — 面向贡献者的指南
  - `debugging.md` — 如何调试 Godot + Java 交互问题

---

## 仓库结构（简要）

```text
godot-java/
├── pom.xml                          # 根 Maven 项目（聚合模块）
├── godot-api/                       # Godot API JSON 文件（代码生成器输入）
│   ├── extension_api.json           #   Godot 类/方法/属性定义
│   ├── gdextension_interface.json   #   GDExtension C 接口定义
│   └── gdextension_interface.h      #   GDExtension C 头文件（参考）
├── godot-java-core/                 # 核心运行时与 Godot Java 绑定
│   ├── native/src/godot_java.cpp    #   C++ 入口（GDExtension 初始化）
│   ├── src/main/java/org/godot/
│   │   ├── annotation/              #   @GodotClass, @GodotMethod, @Export, @Signal
│   │   ├── bootstrap/               #   JVM 启动与 GDExtension 入口
│   │   ├── bridge/                  #   Panama FFI 桥接（VirtualDispatch, InstanceCallbacks）
│   │   ├── core/                    #   Variant, StringName, GodotString, Callable…
│   │   ├── collection/              #   GodotArray, GodotDictionary
│   │   ├── math/                    #   Vector2/Vector3, Transform2D/3D…
│   │   ├── node/                    #   1016 个生成的节点封装（Node, Node2D, Control…）
│   │   ├── internal/api/            #   自动生成：ApiIndex, ApiSignatures, VariantType, VirtualMethods…
│   │   └── registration/            #   注解扫描与类注册
│   └── src/test/java/               #   单元测试
├── godot-java-code-generator/       # 代码生成器（基于 Godot API JSON）
│   └── src/main/java/com/godot/codegen/
│       ├── Main.java                #   入口
│       ├── ApiIndexGenerator.java   #   176 个 API 函数索引
│       ├── ApiSignaturesGenerator.java # Panama FunctionDescriptor
│       ├── VariantTypeGenerator.java #   Variant 类型枚举
│       ├── VirtualMethodGenerator.java # 虚方法元数据
│       ├── ClassGenerator.java      #   1016 个节点封装类
│       └── StructLayoutComputer.java #  C 结构体偏移计算
├── godot-java-processor/            # APT 注解处理器
│   └── src/main/java/org/godot/processor/
│       └── GodotClassProcessor.java #   编译期生成 TypedDispatch/VirtualDispatch
├── godot-java-examples/             # 示例项目（10 个示例）
│   ├── src/main/java/examples/      #   Java 源码（helloworld, pong, snake…）
│   └── examples/01-*/~10-*/         #   Godot 项目（.tscn, .gd, native/）
├── upgrade-godot-api.sh             # 一键升级 Godot 版本
└── docs/                            # 文档（中英文）
    ├── en/user/ | en/dev/
    └── zh/user/ | zh/dev/
```

---

## 升级到新版本 Godot

当 Godot 发布新版本时，godot-java 只需一步即可完成升级：

```bash
./upgrade-godot-api.sh 4.7
```

该脚本会：
1. 从 godot-cpp 下载新版本的 `extension_api.json` 和 `gdextension_interface.json`
2. 重新运行代码生成器，自动更新：
   - **ApiIndex.java** — 176 个 API 函数索引
   - **ApiSignatures.java** — 每个函数的 Panama FunctionDescriptor
   - **VariantType.java** — Variant 类型枚举
   - **StructOffsets.java** — C 结构体字段偏移量
   - **VirtualMethods.java** — Node 继承链的虚方法
   - **ObjectMethodHashes.java** — Object 的方法绑定哈希
   - **1016 个节点包装类** — 引擎类型 API 变更

然后验证：

```bash
./mvnw clean install -DskipTests
```

---

## 我应该从哪开始？

如果你想快速跑起来：

1. 确保本地有：
   - JDK 25+
   - Maven 4.0.x
   - Godot

2. 阅读：
   - [docs/zh/user/getting-started.md](docs/zh/user/getting-started.md)

3. 然后根据文档：
   - 构建 `godot-java-core` 和 `godot-java-code-generator`
   - 在一个新的 Godot 项目中加载生成的 GDExtension
   - 创建一个简单的 `@GodotClass` Java 脚本进行试验

---

## 参与贡献

欢迎：

- 反馈 Bug / 设计建议 / 使用体验
- 补充或改进文档
- 帮忙验证在不同平台 / 不同 Godot 版本上的兼容性
- 一起完善 API 覆盖度与测试

具体细节请参见：[docs/zh/dev/contribution.md](docs/zh/dev/contribution.md)

---

## 致谢

- Godot Engine 团队与社区，提供开放且强大的引擎与 GDExtension 接口
- OpenJDK Panama 团队，为 Java 带来了现代化的 FFI 能力
- 所有尝试在游戏开发中使用 Java 的工程师 —— 这个项目也是为你们准备的。
