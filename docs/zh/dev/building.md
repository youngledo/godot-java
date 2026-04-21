# 构建与验证

本文档介绍如何从源码构建 godot-java 并进行端到端验证。

## 前置条件

| 工具 | 版本                  | 验证命令 |
|------|---------------------|----------|
| JDK | **25+**（Panama FFI） | `java -version` |
| Maven | 4.0.x（项目已含 Wrapper） | `mvn -version` 或 `./mvnw --version` |
| C++ 编译器 | C++17               | macOS: `clang++ --version`，Linux: `g++ --version` |
| Godot | **4.6+**            | `godot --version` |
| Git | 2.x                 | `git --version` |

确认 JAVA_HOME 已设置：

```bash
echo $JAVA_HOME
java -version    # 应显示 25+
```

## 从源码构建

### 1. 克隆仓库

```bash
git clone --recursive https://github.com/youngledo/godot-java.git
cd godot-java
```

如果已克隆但未初始化子模块：

```bash
git submodule update --init --recursive
```

### 2. 编译 Java 代码

```bash
cd godot-java-core
mvn compile -Dcheckstyle.skip=true
```

> **注意**：checkstyle 使用 `sun_checks.xml` 配置，本地开发时可跳过。

验证编译产物：

```bash
ls target/classes/org/godot/bridge/Bridge.class
ls target/classes/org/godot/bootstrap/Bootstrap.class
ls target/classes/org/godot/Godot.class
```

编译成功后 `target/classes/org/godot/` 目录下应有完整的 `.class` 文件。

### 3. 编译原生库

#### macOS

```bash
cd godot-java-core/native
bash build-macos.sh
```

产出物：`build/libgodot-java.dylib`（universal binary，支持 x86_64 + arm64）

#### Linux

```bash
cd godot-java-core/native
bash build-linux.sh
```

产出物：`build/libgodot-java.so`

#### Windows

```cmd
cd godot-java-core\native
build-windows.bat
```

产出物：`build\godot-java.dll`

#### 验证原生库

```bash
ls -lh godot-java-core/native/build/libgodot-java.*

# macOS: 检查架构
file godot-java-core/native/build/libgodot-java.dylib
# 应包含 x86_64 和 arm64

# 检查依赖项
otool -L godot-java-core/native/build/libgodot-java.dylib   # macOS
ldd godot-java-core/native/build/libgodot-java.so            # Linux
```

### 4. 完整构建

```bash
mvn clean install -DskipTests -Dcheckstyle.skip=true
```

## Maven 项目结构

```
godot-java/                     # 父 POM (org.godot:godot-java:0.1.0)
├── pom.xml                     # 父 POM，定义全局属性和依赖管理
├── godot-java-core/
│   └── pom.xml                 # org.godot:godot-java-core:0.1.0
│                                # 主模块：Java 绑定代码
│                                # 编译目标：Java 25
│                                # 依赖：log4j-api, log4j-core, junit-jupiter
├── godot-java-code-generator/
│   └── pom.xml                 # org.godot:godot-java-code-generator:0.1.0
│                                # 代码生成器：从 extension_api.json 生成包装类
├── godot-java-processor/
│   └── pom.xml                 # org.godot:godot-java-processor:0.1.0
│                                # APT 处理器：编译期生成 TypedDispatch/VirtualDispatch
├── godot-java-examples/
│   └── pom.xml                 # org.godot:godot-java-examples:0.1.0
│                                # 示例项目（10 个示例，含集成测试）
└── godot-api/                  # Godot API JSON 数据 (extension_api.json)
```

### 父 POM 关键配置

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

### 代码生成

项目使用两种代码生成机制：

#### 1. 代码生成器（extension_api.json → 节点包装类）

代码生成器在 `generate-sources` 阶段运行：

1. 读取 `godot-api/extension_api.json` 和 `godot-api/gdextension_interface.json`
2. 解析 Godot 类、方法、属性、结构体信息
3. 生成 Java 包装类到 `src/main/java/`
4. 运行时文件直接引用生成的常量，无需手动维护偏移量

生成的类包括 `Node` 包装类（如 `Sprite2D`、`CharacterBody2D` 等），每个类包含 `METHOD_HASHES` 映射表。

#### 2. APT 处理器（注解 → 类型化分派）

`godot-java-processor` 模块在编译期运行，根据注解为每个类生成分派代码。

**工作流程：**

1. Maven 先编译 `godot-java-core`，产出 `virtual_method_index.txt` 资源文件
2. 处理器模块通过 `maven-resources-plugin` 将索引复制到自身资源目录
3. 编译用户代码（如 `godot-java-examples`）时，APT 处理器：
   - 从 classpath 读取 `virtual_method_index.txt`
   - 对每个 `@GodotClass`，遍历父类继承链
   - 生成 `TypedDispatch_<ClassName>.java`（MethodHandle/VarHandle 分派）
   - 生成 `VirtualDispatch_<ParentClass>.java`（hash-to-name 映射）
   - 生成 `GeneratedClassRegistry.java`（类名 → Java Class 映射）

**在用户项目的 `target/generated-sources/annotations/` 中生成：**

| 文件 | 用途 |
|------|------|
| `TypedDispatch_<类名>.java` | @GodotMethod 的 MethodHandle 分派，@Export 的 VarHandle 访问 |
| `VirtualDispatch_<父类名>.java` | 按父类的虚方法 hash 映射 |
| `GeneratedClassRegistry.java` | 类名 → Java Class 映射（替代运行时扫描） |

**验证 APT 生成：**

```bash
ls godot-java-examples/target/generated-sources/annotations/org/godot/internal/
# 应显示 TypedDispatch_*.java, VirtualDispatch_*.java, GeneratedClassRegistry.java
```

### 自动生成的版本相关文件

| 文件 | 数据来源 | 说明 |
|------|----------|------|
| `StructOffsets.java` | `gdextension_interface.json` types[] | C 结构体字段偏移量（CreationInfo4、PropertyInfo、MethodInfo） |
| `VirtualMethods.java` | `extension_api.json` classes[] | Node 及父类的虚方法名列表 |
| `ObjectMethodHashes.java` | `extension_api.json` classes[] | Object 的方法绑定哈希 |
| 1016 个节点类 | `extension_api.json` classes[] | 引擎类型包装（Sprite2D、CharacterBody2D 等） |

运行时文件（`InstanceCallbacks`、`MethodRegistration`、`PropertyRegistration`、`SignalRegistration`、`VirtualDispatch`）直接引用生成的常量——结构体布局变化时无需手动修改。

APT 处理器在编译时读取 `virtual_method_index.txt`（由代码生成器产出）。升级时此文件自动重新生成，每个类的分派数据保持同步。

## 升级 Godot 版本

当 Godot 发布新版本（如 4.7、4.8）时，使用升级脚本：

```bash
./upgrade-godot-api.sh 4.7
```

### 脚本执行流程

1. 从 [godot-cpp](https://github.com/godotengine/godot-cpp) 仓库下载对应版本标签的 `extension_api.json` 和 `gdextension_interface.json`
2. 重新运行代码生成器（`mvn generate-sources`）

### 升级后验证

```bash
./mvnw clean install -DskipTests
```

### 仍需手写的文件

以下三个文件为手写维护：

- `ApiIndex.java` — API 函数索引（176 个枚举值）
- `ApiSignatures.java` — 每个 API 函数的 Panama `FunctionDescriptor`
- `VariantType.java` — Variant 类型枚举（47 个值）

**原因：** `gdextension_interface.json` 的 `interface[]` 段落中，176 个函数约有 77 个的参数列表与实际 C ABI（`gdextension_interface.h`）不一致。如果从 JSON 自动生成，会产生错误的函数签名，导致运行时崩溃（如 Variant 构造器失败）。

如果 Godot 后续版本修复了 JSON 的准确性问题，可以在 `Main.java` 中取消注释对应行来启用自动生成。

### 升级失败排查

1. **结构体布局变更** — 生成的 `StructOffsets` 会自动反映新值，通常不需要手动处理
2. **新增虚方法** — APT 处理器会自动生成更新后的 `VirtualDispatch_<Parent>` 类。如果引入了新的父类，可能需要将其添加到处理器的索引中
3. **ApiSignatures 需要更新** — 对比 `gdextension_interface.h` 与手写的函数签名

## 端到端验证

### 步骤 1：编译 Java

```bash
cd godot-java-core
mvn compile -Dcheckstyle.skip=true -q
```

### 步骤 2：部署原生库

```bash
mkdir -p /path/to/test-project/native
cp godot-java-core/native/build/libgodot-java.dylib \
   /path/to/test-project/native/
```

### 步骤 3：配置 Classpath

C++ 层按以下顺序查找 classpath：

1. 环境变量 `GODOT_JAVA_CLASSPATH`（优先）
2. 相对于 `godot_java.cpp` 的 `../../target/classes`（开发回退）

```bash
export GODOT_JAVA_CLASSPATH="/path/to/godot-java/godot-java-core/target/classes"
```

### 步骤 4：创建 .gdextension 文件

在测试项目中创建 `godot-java.gdextension`：

```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = 4.6

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
```

### 步骤 5：启动验证

```bash
/Applications/Godot.app/Contents/MacOS/Godot --path /path/to/test-project
```

### 预期输出

```
godot-java: init start
godot-java: Loading JVM library...
godot-java: Trying JVM at: .../lib/server/libjvm.dylib
godot-java: Classpath: -Djava.class.path=...
godot-java: Creating JVM with 6 options...
godot-java: JVM initialized successfully!
godot-java: Probing GDExtension APIs...
godot-java:   get_godot_version => OK
godot-java:   classdb_construct_object2 => OK
godot-java: Bootstrap.init() completed successfully!
godot-java: initialize level 2
godot-java: Classes registered at SCENE level
```

### 验证清单

| 验证项 | 预期结果 |
|--------|----------|
| JVM 启动 | "JVM initialized successfully!" |
| API 加载 | 176 个 GDExtension API 函数全部解析 |
| 类注册 | "Classes registered at SCENE level" |
| 原生库加载 | 无 "Can't load library" 错误 |
| 无崩溃 | 没有 `hs_err_pid*.log` 文件 |

## 常见构建问题

### JAVA_HOME 未设置

```bash
# macOS
export JAVA_HOME=$(/usr/libexec/java_home -v 25)

# Linux
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64
```

### Maven 构建失败

```bash
# 清理后重试
mvn clean install -U -DskipTests -Dcheckstyle.skip=true

# 查看详细错误
mvn clean compile -e -X
```

### 原生库编译失败

1. 确认 `$JAVA_HOME/include` 目录存在（JNI 头文件）
2. 确认 `godot-cpp` 子模块已初始化：`git submodule update --init --recursive`
3. 确认 C++ 编译器支持 C++17
4. 检查编译脚本中的 include 路径是否正确

### "FindClass(Bootstrap) failed"

JVM 找不到 Java 类文件。

```bash
# 确认 classpath 路径
export GODOT_JAVA_CLASSPATH="/path/to/godot-java-core/target/classes"
ls $GODOT_JAVA_CLASSPATH/org/godot/bootstrap/Bootstrap.class
```

### 跨平台注意事项

| 平台 | 原生库 | 编译器 | 注意事项 |
|------|--------|--------|----------|
| macOS | `.dylib` | `clang++` | 需要 universal binary (x86_64 + arm64) |
| Linux | `.so` | `g++` | 需要 `-fPIC` 标志 |
| Windows | `.dll` | MSVC | 需要 Visual Studio Developer Command Prompt |


## 跨平台构建详解

### .gdextension 文件格式

`.gdextension` 文件需要包含所有目标平台的库路径：

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

### Linux 构建要求

| 依赖 | 版本 | 安装命令 |
|------|------|---------|
| GCC/G++ | 12+ | `sudo apt install build-essential` |
| JDK | 25+ | SDKMAN: `sdk install java 25-tem` |
| Maven | 4.0.x | `sdk install maven 4.0.0-rc-3` |

构建步骤：

```bash
# Java 编译
./mvnw clean package -DskipTests

# 原生库编译
cd godot-java-core/native
./build-linux.sh

# 验证
ldd build/libgodot-java.so
nm build/libgodot-java.so | grep godot_java_init
```

### Windows 构建要求

| 依赖 | 版本 | 说明 |
|------|------|------|
| MSVC | 2022+ | 通过 Visual Studio Installer 安装 |
| JDK | 25+ | 建议使用 Eclipse Temurin |
| Maven | 4.0.x | 下载解压并添加到 PATH |

构建步骤：

```cmd
# 在 Developer Command Prompt for VS 中执行
mvnw.cmd clean package -DskipTests
cd godot-java-core\native
build-windows.bat
```

### 部署目录结构

```
your-godot-project/
├── godot-java.gdextension
├── native/
│   ├── libgodot-java.dylib   # macOS
│   ├── libgodot-java.so      # Linux
│   └── libgodot-java.dll     # Windows
└── project.godot
```

### 持续集成

项目包含 GitHub Actions 配置 (`.github/workflows/ci.yml`)，
支持 macOS 和 Linux 的自动化构建和测试。
