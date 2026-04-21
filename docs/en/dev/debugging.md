# Debugging

How to debug Java code running inside Godot via godot-java.

## Log4j2 Configuration

godot-java uses Log4j2 for structured logging. The framework classes use named loggers:

```java
private static final Logger logger = LogManager.getLogger(Bridge.class);
```

### Configuring Log Levels

Create or edit `src/main/resources/log4j2.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
        <!-- Debug-level for framework internals -->
        <Logger name="org.godot.bridge" level="debug"/>
        <Logger name="org.godot.registration" level="debug"/>
        <!-- Your game code -->
        <Logger name="com.example" level="debug"/>
    </Loggers>
</Configuration>
```

### Log Levels

| Level | Use For |
|---|---|
| TRACE | Fine-grained debug (every variant conversion) |
| DEBUG | Framework internals (method dispatch, registration) |
| INFO | Lifecycle events (init, class registration) |
| WARN | Recoverable issues (fallback code paths) |
| ERROR | Failures (missing API, dispatch errors) |

### What Gets Logged

At **INFO** level, you will see:
```
Phase 1 complete. Bridge loaded, 3 classes scanned.
Classes registered at SCENE level.
VirtualDispatch initialized (5 methods)
```

At **DEBUG** level, additional details:
```
MethodDispatch: registered takeDamage on Player -> key 1
PropertyRegistration: registered maxHealth on Player
SignalRegistration: registered health_changed on Player
```

## System.out for Quick Debugging

`System.out` and `System.err` output appears in both the Godot console and the terminal:

```java
@Override
public void _process(double delta) {
    System.out.println("Position: " + getX() + ", " + getY());
}
```

This is useful for quick debugging but should be removed before shipping. Prefer Log4j2 for production code.

## Remote Debugging (JDWP)

You can attach a Java debugger (IntelliJ or VS Code) to the JVM embedded inside Godot.

### Enable JDWP

Set the JDWP agent before starting Godot:

```bash
export JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"
godot --path /path/to/project
```

Parameters:
- `server=y` -- JVM listens for debugger connections.
- `suspend=y` -- JVM waits for debugger before executing (useful for debugging init).
- `suspend=n` -- JVM runs immediately, debugger attaches later.
- `address=5005` -- Port number.

### IntelliJ IDEA Setup

1. **Run > Edit Configurations...**
2. Click **+**, select **Remote JVM Debug**.
3. Set Host: `localhost`, Port: `5005`.
4. Click **OK**.
5. Set breakpoints in your Java source.
6. Start Godot (with JDWP enabled).
7. In IntelliJ, click **Debug** (Shift+F9).

### VS Code Setup

Add to `.vscode/launch.json`:

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

### Verify JDWP Is Listening

```bash
lsof -i :5005    # macOS/Linux
# Should show: java ... TCP *:5005 (LISTEN)
```

## Debugging Common Scenarios

### Method Call Fails Silently

The method is called from GDScript but nothing happens.

1. Check that the method has `@GodotMethod`:
   ```java
   @GodotMethod
   public void takeDamage(int amount) { ... }
   ```

2. Check that the method is `public` (not `private` or `protected`).

3. Verify the method is registered. Enable DEBUG logging for `org.godot.bridge` and look for:
   ```
   MethodDispatch: registered takeDamage on Player -> key 1
   ```

4. Check parameter type compatibility. The `coerceType()` method handles Number conversions but custom types are not converted.

### Class Not Registered

The class exists but does not appear in the Godot editor.

1. Verify `@GodotClass` annotation:
   ```java
   @GodotClass(name = "Player", parent = "Node2D")
   public class Player extends Node2D { }
   ```

2. Check that the Java class extends the correct base class matching the `parent` value.

3. Verify the class is compiled and on the classpath:
   ```bash
   find target/classes -name "Player.class"
   ```

4. Check scanner output at INFO level:
   ```
   Phase 1 complete. Bridge loaded, 3 classes scanned.
   ```

### SIGSEGV on Method Call

1. Check that `isValid()` returns `true` before calling:
   ```java
   if (!isValid()) {
       System.err.println("Invalid object: " + this);
       return;
   }
   ```

2. Verify Godot version is 4.6+.

3. Check `hs_err_pid*.log` for the crash stack trace.

### Signal Not Firing

1. Verify the signal is declared with `@Signal`:
   ```java
   @Signal(name = "health_changed")
   private void onHealthChanged(int newHealth) {}
   ```

2. Check it was registered (DEBUG log):
   ```
   SignalRegistration: registered health_changed on Player
   ```

3. Verify the signal name matches exactly when emitting:
   ```java
   emitSignal("health_changed", health);  // must match @Signal name
   ```

### Memory Issues

Monitor JVM memory from within a node:

```java
@Override
public void _process(double delta) {
    Runtime runtime = Runtime.getRuntime();
    long used = runtime.totalMemory() - runtime.freeMemory();
    long max = runtime.maxMemory();
    if (used > max * 0.9) {
        System.err.println("WARNING: High memory: " + (used / 1024 / 1024) + "MB");
    }
}
```

## C++ Layer Debugging

### Enable C++ Debug Output

In the C++ source, enable verbose logging:
```cpp
#define GODOT_JAVA_DEBUG 1
```

All C++ logs are prefixed with `godot-java:`:
```
godot-java: Loading JVM library...
godot-java: JVM initialized successfully!
godot-java: Bootstrap.init() completed successfully!
```

### Check JVM Library

```bash
# macOS: verify libjvm exists
ls $JAVA_HOME/lib/server/libjvm.dylib

# Linux
ls $JAVA_HOME/lib/server/libjvm.so
```

### Check Native Library

```bash
# Library dependencies
otool -L native/libgodot-java.dylib    # macOS
ldd native/libgodot-java.so             # Linux

# Undefined symbols
nm -u native/libgodot-java.dylib

# Architecture
file native/libgodot-java.dylib
```

## Debugging Tips

1. Use Log4j2 instead of `System.out.println` for production code.
2. Use conditional breakpoints to reduce noise (e.g., `amount > 100`).
3. Set breakpoints in `Bootstrap.init()` to debug initialization.
4. Use `suspend=y` for init debugging, `suspend=n` for runtime debugging.
5. Check `hs_err_pid*.log` files after crashes.
6. Start with a simple test case before debugging complex interactions.
7. Use `assert` for invariant checks during development:
   ```java
   assert health >= 0 : "Health should never be negative";
   ```


## Diagnostic Tools (v0.2+)

### Thread Safety

Godot's engine is single-threaded. All API calls must happen on the main
(initialization) thread. `ThreadChecker` automatically validates the thread on
every `Bridge.call*()` invocation:

```java
// Enabled by default. Disable via system property:
// -Dgodot.java.threadCheck=false
```

Calling Godot APIs from a background thread throws `GodotThreadException`.

### Deferred Execution

Background threads can safely schedule work on the main thread via
`DeferredExecutor`:

```java
// Call from any thread
DeferredExecutor.callDeferred(() -> {
    // This runs on the main thread
    node.call("set_visible", true);
});
```

Call `DeferredExecutor.flush()` from `_process()` or `_physicsProcess()` to
execute queued tasks.

### Enhanced Error Reporting

All `Bridge.call*()` methods throw `GodotApiException` on failure, containing:
- API function name (e.g., `CLASSDB_GET_METHOD_BIND`)
- Call method (e.g., `callPtr`)
- Full exception chain

```java
try {
    Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
} catch (GodotApiException e) {
    // e.getApiName() -> "GLOBAL_GET_SINGLETON"
}
```

### Exception Hierarchy

| Exception | Trigger |
|-----------|---------|
| `GodotException` | Base class for all godot-java exceptions |
| `GodotApiException` | Godot C API call failure |
| `GodotInvalidObjectException` | Accessing a freed Godot object |
| `GodotThreadException` | API call from non-main thread |

### Memory Tracking

`NativeMemoryTracker` tracks native memory allocated via `Bridge.allocate()`:

```java
String stats = Bridge.getMemoryStats();
// "NativeMemoryTracker{totalAllocations=1024, totalBytes=65536,
//  liveAllocations=512, liveBytes=32768}"
```

### Debug Logging

Enable internal component debug logging via system properties:

```bash
# Log Bridge API calls (API name and timing per call)
godot --headless -Dgodot.java.debug.bridge=true

# Log virtual method dispatch (method name and class)
godot --headless -Dgodot.java.debug.virtual=true
```

Output goes to stderr:

```
[godot-java:bridge] CLASSDB_GET_METHOD_BIND via callPtr2S1L in 5200ns
[godot-java:virtual] Player._process (stub=true)
```

### Registration Summary

A summary is printed during startup:

```
[godot-java:registry] Registered 11 classes in 34ms: 39 methods, 15 properties, 7 signals
```

If the counts don't match expectations, check classpath scanning or annotation processing.
