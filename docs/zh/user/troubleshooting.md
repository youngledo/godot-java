# 问题排查

使用 godot-java 时的常见错误及解决方案。

---

## 1. JVM 未找到

**症状**

```
godot-java: Could not find JVM library (libjvm.dylib)
godot-java: Please set JAVA_HOME environment variable
```

**原因**

- `JAVA_HOME` 未设置或指向错误的路径
- 未安装 JDK 25+

**解决方案**

1. 确认安装了 JDK 25+：

```bash
java -version
# 应显示 openjdk version "25" 或更高
```

2. 设置 `JAVA_HOME`：

```bash
# macOS
export JAVA_HOME=$(/usr/libexec/java_home -v 25)

# Linux
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64

# Windows (PowerShell)
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-25", "User")
```

3. 确认 JVM 库文件存在：

```bash
# macOS
ls $JAVA_HOME/lib/server/libjvm.dylib

# Linux
ls $JAVA_HOME/lib/server/libjvm.so

# Windows
dir %JAVA_HOME%\bin\server\jvm.dll
```

C++ 层会按以下优先级搜索 JVM 库：
1. `$JAVA_HOME/lib/server/libjvm.{dylib|so|dll}`
2. 预定义的系统路径（如 `/Library/Java/...`、`/usr/lib/jvm/...`）
3. SDKMAN 安装路径

---

## 2. 原生库加载失败

**症状**

```
ERROR: Can't load library: res://native/libgodot-java.dylib
```

**原因**

- 库文件缺失或路径错误
- `.gdextension` 文件中配置了错误的文件名或路径
- 库的架构与 Godot 不匹配

**解决方案**

1. 确认库文件存在：

```bash
ls -lh native/libgodot-java.dylib
file native/libgodot-java.dylib
# macOS 应显示: Mach-O 64-bit dynamically linked shared library arm64
```

2. 检查 `.gdextension` 配置：

```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = 4.6

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
```

常见错误：
- 文件扩展名错误（`.dll` vs `.so` vs `.dylib`）
- 平台名称错误（应为 `macos`，不是 `osx`）
- 路径使用了 `../` 相对路径（应使用 `res://` 绝对路径）
- `compatibility_minimum` 设为 4.2 而不是 4.6

3. 检查库的依赖项：

```bash
otool -L native/libgodot-java.dylib   # macOS
ldd native/libgodot-java.so            # Linux
```

4. 确保文件有执行权限：

```bash
chmod +x native/libgodot-java.dylib
```

---

## 3. 编译错误

### 3.1 Java 版本不满足

**症状**

```
error: package java.lang.foreign does not exist
```

**原因**：JDK 版本低于 25。

**解决方案**：安装 JDK 25+：

```bash
java -version    # 确认版本
mvn -version     # 确认 Maven 使用的 JDK 版本
```

### 3.2 包不存在

**症状**

```
error: package org.godot does not exist
```

**解决方案**：

```bash
# 确认依赖已安装
mvn dependency:resolve

# 重新编译
mvn compile -Dcheckstyle.skip=true
```

### 3.3 Checkstyle 检查失败

**症状**

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-checkstyle-plugin
```

**解决方案**：

```bash
# 跳过 checkstyle 编译
mvn compile -Dcheckstyle.skip=true

# 或运行 checkstyle 检查并修复
mvn checkstyle:check
```

项目使用 `sun_checks.xml` 作为 checkstyle 配置。

---

## 4. 运行时崩溃（SIGSEGV / SIGBUS）

**症状**

```
Signal: SIGSEGV (Segmentation fault)
Signal: SIGBUS (Bad address)
```

**常见原因**

1. **Panama 内存段已释放** -- `Bridge.ARENA` 分配的内存在 JVM 生命周期内有效，但如果手动使用了 `Arena.ofConfined()` 且已关闭，会导致崩溃
2. **空指针** -- 在 `nativeObject == 0` 时调用 `call()`
3. **类型映射错误** -- Variant 类型与实际数据不匹配
4. **Godot 版本不兼容** -- 方法哈希值与实际 Godot 版本不匹配

**解决方案**

1. 检查对象有效性：

```java
if (!isValid()) {
    System.err.println("Object is invalid!");
    return;
}
```

2. 确认 Godot 版本：

```bash
godot --version    # 应为 4.6 或更高
```

3. 启用崩溃处理器获取详细堆栈：

```bash
export GODOT_JAVA_CRASH_HANDLER=1
godot --path /path/to/project
```

4. 检查 JVM 崩溃日志：

```bash
ls hs_err_pid*.log
cat $(ls -t hs_err_pid*.log | head -1)
```

---

## 5. 类未找到

**症状**

```
godot-java: FindClass(Bootstrap) failed
```

或 Java 类未被注册。

**原因**

- Classpath 配置不正确
- 类未编译
- 类未标注 `@GodotClass` 注解

**解决方案**

1. 设置 classpath 环境变量：

```bash
export GODOT_JAVA_CLASSPATH="/path/to/your/target/classes:/path/to/godot-java-core/target/classes"
```

2. 确认类文件已编译：

```bash
find target/classes -name "YourClass.class"
```

3. 确认类上标注了 `@GodotClass`：

```java
@GodotClass(name = "MyClass", parent = "Node")  // 必须有此注解
public class MyClass extends Node { }
```

4. 如果使用 Java 模块系统，确认 `module-info.java` 中正确导出了包含 `@GodotClass` 类的包

---

## 6. 方法未注册或不可调用

**症状**

```
RuntimeError: Method bind not found for my_method on ...
```

或 GDScript 调用 Java 方法返回 `nil`。

**原因**

- 方法缺少 `@GodotMethod` 注解
- 方法为 `private`（应为 `public`）
- 方法参数类型不受支持

**解决方案**

```java
// 错误：缺少注解
public void myMethod() { }

// 正确：添加注解
@GodotMethod
public void myMethod() { }
```

```java
// 错误：private 方法
@GodotMethod
private void myMethod() { }

// 正确：public 方法
@GodotMethod
public void myMethod() { }
```

---

## 7. Godot 版本兼容性

**症状**

```
ERROR: GDExtension version mismatch
```

或方法调用崩溃。

**解决方案**

1. 确认 Godot 版本为 4.6+：

```bash
godot --version
```

2. 更新 `.gdextension` 中的兼容性配置：

```ini
[configuration]
compatibility_minimum = 4.6
```

3. 如果从源码构建，确保 `godot-cpp` 子模块版本与 Godot 版本匹配

---

## 8. 性能问题

**症状**：帧率低、运行卡顿。

**常见原因**：频繁跨 Java-Godot 边界调用、每帧创建对象。

**解决方案**

1. 减少跨边界调用 -- 缓存频繁使用的值：

```java
// 错误：每帧查找节点
@Override
public void _process(double delta) {
    Object node = call("get_node", "Player");
}

// 正确：在 _ready() 中缓存
private Node playerNode;

@Override
public void _ready() {
    playerNode = getNode("Player");
}
```

2. 控制日志输出频率：

```java
// 错误：每帧打印
@Override
public void _process(double delta) {
    System.out.println("Position: " + getX());
}

// 正确：控制频率
private int frameCount = 0;
@Override
public void _process(double delta) {
    if (frameCount++ % 60 == 0) {
        System.out.println("Position: " + getX());
    }
}
```

3. 使用 `MethodBindCache` 避免重复查找方法绑定

---

## 调试技巧

### 启用 C++ 层日志

C++ 层所有日志以 `godot-java:` 为前缀。运行 Godot 时从终端启动可以看到这些日志：

```bash
# macOS
/Applications/Godot.app/Contents/MacOS/Godot --path /path/to/project

# Linux
godot --path /path/to/project
```

正常启动应看到：

```
godot-java: Loading JVM library...
godot-java: Trying JVM at: .../lib/server/libjvm.dylib
godot-java: JVM initialized successfully!
godot-java: Bootstrap.init() completed successfully!
godot-java: Classes registered at SCENE level
```

### 远程调试

```bash
export GODOT_JAVA_DEBUG=1
export GODOT_JAVA_DEBUG_PORT=5005
godot --path /path/to/project
```

然后在 IntelliJ 中配置 Remote JVM Debug（端口 5005）并连接。

### 日志配置

编辑 `log4j2.xml` 调整日志级别：

```xml
<Logger name="org.godot" level="debug"/>
```

---

## 预防措施

1. 始终使用 Java 25+（Panama FFI 硬性要求）
2. 方法调用前检查 `isValid()`
3. 开发前确认 Godot 版本为 4.6+
4. 先用简单示例测试，再编写复杂逻辑
5. 将原生库和 classpath 配置纳入版本控制

## 获取帮助

如果以上方案未能解决问题：

1. 从终端启动 Godot 获取完整日志
2. 创建最小复现用例
3. 提交 GitHub Issue，附上：
   - Godot 版本：`godot --version`
   - Java 版本：`java -version`
   - 操作系统和架构
   - 完整错误信息
   - 最小代码示例
