# 调试

本文档介绍如何调试 godot-java 中运行的 Java 代码，包括远程调试、日志配置和常见调试场景。

## 环境变量

| 变量 | 说明 | 示例 |
|------|------|------|
| `GODOT_JAVA_DEBUG` | 启用 JDWP 调试模式 | `export GODOT_JAVA_DEBUG=1` |
| `GODOT_JAVA_DEBUG_PORT` | JDWP 端口（默认 5005） | `export GODOT_JAVA_DEBUG_PORT=5005` |
| `GODOT_JAVA_CLASSPATH` | 手动指定 classpath | `export GODOT_JAVA_CLASSPATH=/path/to/classes` |
| `GODOT_JAVA_CRASH_HANDLER` | 启用崩溃处理器 | `export GODOT_JAVA_CRASH_HANDLER=1` |
| `GODOT_JAVA_JMX` | 启用 JMX 远程监控 | `export GODOT_JAVA_JMX=1` |
| `GODOT_JAVA_JMX_PORT` | JMX 端口（默认 9010） | `export GODOT_JAVA_JMX_PORT=9010` |

启用调试模式后从终端启动 Godot：

```bash
export GODOT_JAVA_DEBUG=1
export GODOT_JAVA_DEBUG_PORT=5005
godot --path /path/to/project
```

C++ 层会自动添加 JDWP agent 参数，JVM 启动后等待调试器连接。

## IntelliJ 远程调试

### 配置步骤

1. **启动 Godot（带调试模式）**：

```bash
export GODOT_JAVA_DEBUG=1
export GODOT_JAVA_DEBUG_PORT=5005
godot --path /path/to/project
```

JDWP 参数说明：
- `transport=dt_socket` -- 使用 Socket 传输
- `server=y` -- JVM 作为服务器（Godot 监听调试器连接）
- `suspend=y` -- 等待调试器连接后再执行（调试初始化时推荐）
- `address=*:5005` -- 监听端口号

2. **在 IntelliJ 中配置**：

   - **Run -> Edit Configurations... -> + -> Remote JVM Debug**
   - 名称：`Godot Remote Debug`
   - Host：`localhost`
   - Port：`5005`
   - 点击 **OK**

3. **设置断点**：在 Java 源码中点击行号左侧。

4. **连接调试器**：选择 "Godot Remote Debug"，点击 **Debug**（Shift+F9）。JVM 会在断点处暂停。

5. **调试操作**：
   - Evaluate Expression：Alt+F8
   - 条件断点：右键断点设置 Condition
   - Watch 变量：拖拽到 Watches 面板

### 调试初始化代码

在 `Bootstrap.init()` 中设置断点，可以调试整个初始化流程：

```java
public static void init(long getProcAddress, long libraryPtr) {
    try {
        Bridge.load(getProcAddress, libraryPtr);          // <-- 断点
        Variant.initConstructors();
        Registry.registerBuiltinTypes();
        pendingClasses = Scanner.scan();                   // <-- 断点
    } catch (Throwable t) {
        throw new RuntimeException("Bootstrap.init() failed", t);
    }
}
```

## VS Code 调试

### 配置

创建 `.vscode/launch.json`：

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Debug Godot Java",
      "request": "attach",
      "hostName": "localhost",
      "port": 5005
    }
  ]
}
```

先启动 Godot（带 `GODOT_JAVA_DEBUG=1`），然后在 VS Code 中按 F5 连接。

## 日志

### Log4j2 配置

godot-java 使用 Log4j2 作为日志框架。配置文件位于 `godot-java-core/src/main/resources/log4j2.xml`。

默认配置：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <RollingFile name="GameLog" fileName="godot-java.log" ...>
            ...
        </RollingFile>
    </Appenders>
    <Loggers>
        <Logger name="core" level="debug"/>
        <Logger name="scene" level="debug"/>
        <Logger name="input" level="debug"/>
        <Logger name="physics" level="debug"/>
        <Logger name="jni" level="debug"/>
        <Logger name="game" level="debug"/>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

日志级别（从低到高）：TRACE、DEBUG、INFO、WARN、ERROR。

### 日志分类

| 分类 | 说明 |
|------|------|
| `core` | 核心引擎功能 |
| `scene` | 场景树操作 |
| `input` | 输入事件处理 |
| `physics` | 物理模拟 |
| `jni` | JNI/FFI 调用 |
| `game` | 游戏逻辑 |

### 在代码中使用日志

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player extends Node2D {
    private static final Logger logger = LogManager.getLogger(Player.class);

    @Override
    public void _ready() {
        logger.info("Player initialized at ({}, {})", getX(), getY());
        logger.debug("Health: {}", currentHealth);
    }

    @GodotMethod
    public void takeDamage(int amount) {
        logger.info("Taking damage: {}", amount);
        currentHealth -= amount;
        if (currentHealth <= 0) {
            logger.warn("Player died!");
        }
    }
}
```

### 调整日志级别

修改 `log4j2.xml` 中的 Logger 级别：

```xml
<!-- 开启 bridge 包的 DEBUG 日志 -->
<Logger name="org.godot.bridge" level="debug"/>

<!-- 开启所有 godot 包的 TRACE 日志 -->
<Logger name="org.godot" level="trace"/>
```

### System.out 输出

`System.out` 和 `System.err` 的输出会显示在 Godot 控制台和终端中，适合快速调试：

```java
@Override
public void _process(double delta) {
    System.out.println("Position: " + getX() + ", " + getY());
}
```

## C++ 层调试

### C++ 日志前缀

所有 C++ 层日志以 `godot-java:` 为前缀。从终端启动 Godot 可以看到这些日志。

### 检查 JVM 加载

```bash
# 确认 libjvm 文件存在
ls $JAVA_HOME/lib/server/libjvm.dylib    # macOS
ls $JAVA_HOME/lib/server/libjvm.so        # Linux

# 检查环境变量
echo $JAVA_HOME
```

### 检查原生库

```bash
# 检查库依赖
otool -L native/libgodot-java.dylib    # macOS
ldd native/libgodot-java.so             # Linux

# 检查导出符号
nm -gU native/libgodot-java.dylib       # macOS
nm -D native/libgodot-java.so           # Linux

# 确认入口函数存在
nm -gU native/libgodot-java.dylib | grep godot_java_init
```

### 在 C++ 中添加调试输出

```cpp
printf("godot-java: debug: procAddress=0x%lx\n", (unsigned long)procAddress);
fflush(stdout);  // 确保立即输出
```

## 常见调试场景

### 方法调用失败

**症状**：GDScript 调用 Java 方法返回错误或 nil。

**排查步骤**：

1. 检查 `@GodotMethod` 注解是否存在
2. 确认方法是 `public`
3. 检查终端日志中是否有 "Method bind not found" 错误
4. 添加调试日志：

```java
@GodotMethod
public void attack(int damage) {
    logger.info("=== attack() called, damage={}", damage);
    // ...
}
```

### 属性访问问题

**症状**：`@Export` 属性在编辑器中不显示。

**排查步骤**：

1. 确认字段类型受支持（`int`、`long`、`float`、`double`、`boolean`、`String`）
2. 确认 `@Export` 注解存在
3. 检查终端日志中是否有注册相关错误

### 信号未触发

**症状**：信号连接后回调不执行。

**排查步骤**：

1. 确认 `@Signal` 注解中的 `name` 与 `emit()` 中的名称一致
2. 确认信号已注册（查看终端日志）
3. 在 `emit()` 前后添加日志

### 虚方法未调用

**症状**：`_ready()` 或 `_process()` 未被调用。

**排查步骤**：

1. 确认类正确继承（如 `extends Node` 或 `extends Node2D`）
2. 确认 `@Override` 注解存在
3. 检查 `VirtualDispatch` 日志
4. 确认 `get_virtual_func` stub 已正确注册到 `GDExtensionClassCreationInfo4` 结构体

### 内存泄漏

**常见原因**：`JavaObjectMap` 持续增长。

**监控方法**：

```java
@Override
public void _process(double delta) {
    if (frameCount++ % 300 == 0) {  // 每 5 秒检查一次（60fps）
        Runtime runtime = Runtime.getRuntime();
        long used = runtime.totalMemory() - runtime.freeMemory();
        long max = runtime.maxMemory();
        logger.info("Memory: {}MB / {}MB ({}%)",
            used / 1024 / 1024,
            max / 1024 / 1024,
            used * 100 / max);
    }
}
```

### 性能分析

```java
@GodotMethod
public void expensiveOperation() {
    long startTime = System.nanoTime();

    // ... 耗时操作 ...

    long duration = (System.nanoTime() - startTime) / 1_000_000;
    logger.info("Operation took: {}ms", duration);
}
```

## JDWP 验证

检查 JDWP 端口是否在监听：

```bash
# macOS/Linux
lsof -i :5005

# 应输出类似：
# java    12345 user   5u  IPv4 ... TCP *:5005 (LISTEN)
```

## 崩溃处理

启用崩溃处理器：

```bash
export GODOT_JAVA_CRASH_HANDLER=1
godot --path /path/to/project
```

崩溃时会输出：
- 原生堆栈追踪
- Java 堆栈追踪
- 信号类型

查看 JVM 崩溃日志：

```bash
ls hs_err_pid*.log
cat $(ls -t hs_err_pid*.log | head -1)
```

## 调试技巧

1. 使用 Log4j2 结构化日志而非 `System.out.println`
2. 在逻辑边界设置有意义的断点
3. 使用条件断点减少干扰（如 `amount > 100`）
4. 在复杂流程中记录方法进入和退出
5. 先测量再优化
6. 提交代码前清理调试代码
7. 使用 `assert` 进行不变量检查：
   ```java
   assert currentHealth >= 0 : "Health should never be negative";
   ```


## 诊断工具（v0.2+）

### 线程安全检查

Godot 引擎是单线程的，所有 API 调用必须在主线程（初始化线程）上执行。`ThreadChecker`
在每次 `Bridge.call*()` 时自动验证线程：

```java
// 默认启用，可通过系统属性关闭
// -Dgodot.java.threadCheck=false
```

如果从后台线程调用 Godot API，会抛出 `GodotThreadException`。

### 延迟执行

后台线程可以通过 `DeferredExecutor` 安全地调度主线程工作：

```java
// 从任意线程调用
DeferredExecutor.callDeferred(() -> {
    // 这段代码会在主线程执行
    node.call("set_visible", true);
});
```

需在主线程的 `_process()` 或 `_physicsProcess()` 中调用
`DeferredExecutor.flush()` 来执行队列中的任务。

### 增强错误报告

所有 `Bridge.call*()` 方法在失败时抛出 `GodotApiException`，包含：
- API 函数名（如 `CLASSDB_GET_METHOD_BIND`）
- 调用方法名（如 `callPtr`）
- 原始异常链

```java
try {
    Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
} catch (GodotApiException e) {
    // e.getApiName() → "GLOBAL_GET_SINGLETON"
    // e.getMessage()  → 包含完整上下文
}
```

### 异常体系

| 异常类 | 触发条件 |
|--------|---------|
| `GodotException` | 所有 godot-java 异常的基类 |
| `GodotApiException` | Godot C API 调用失败 |
| `GodotInvalidObjectException` | 访问已释放的 Godot 对象 |
| `GodotThreadException` | 从非主线程调用 API |

### 内存追踪

`NativeMemoryTracker` 统计通过 `Bridge.allocate()` 分配的原生内存：

```java
String stats = Bridge.getMemoryStats();
// "NativeMemoryTracker{totalAllocations=1024, totalBytes=65536,
//  liveAllocations=512, liveBytes=32768}"
```

### 调试日志

通过系统属性启用内部组件的调试日志：

```bash
# 启用 Bridge API 调用日志（输出每次调用的 API 名和耗时）
godot --headless -Dgodot.java.debug.bridge=true

# 启用虚拟方法分派日志（输出每次分派的方法名和类名）
godot --headless -Dgodot.java.debug.virtual=true
```

日志输出到 stderr，格式如：

```
[godot-java:bridge] CLASSDB_GET_METHOD_BIND via callPtr2S1L in 5200ns
[godot-java:virtual] Player._process (stub=true)
```

### 启动注册摘要

每次启动时，注册阶段会输出统计信息：

```
[godot-java:registry] Registered 11 classes in 34ms: 39 methods, 15 properties, 7 signals
```

如果注册数量与预期不符，说明类扫描或注解处理有问题。
