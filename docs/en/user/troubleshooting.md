# Troubleshooting

Common errors and solutions when using godot-java.

---

## 1. JVM Not Found

**Symptom:**
```
ERROR: JVM not found at path: /path/to/jvm
```

**Cause:** `JAVA_HOME` is unset, points to the wrong JDK, or JDK 25+ is not installed.

**Solution:**

Verify Java installation:
```bash
java -version          # must show 25+
/usr/libexec/java_home -V   # macOS: list installed JDKs
```

Set `JAVA_HOME`:
```bash
# macOS/Linux
export JAVA_HOME=$(/usr/libexec/java_home -v 25)   # macOS
export JAVA_HOME=/usr/lib/jvm/java-25              # Linux

# Windows (PowerShell)
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Path\To\JDK-25", "User")
```

---

## 2. Native Library Load Failure

**Symptom:**
```
ERROR: Can't load library: res://native/libgodot-java.so
```

**Cause:** Missing library, wrong path in `.gdextension`, or architecture mismatch.

**Solution:**

1. Verify the library file exists:
```bash
ls -lh native/libgodot-java.dylib    # macOS
file native/libgodot-java.dylib       # check architecture
```

2. Check `.gdextension` configuration:
```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = 4.6

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
```

Common mistakes:
- Wrong file extension (`.dll` vs `.so` vs `.dylib`).
- Wrong platform key (`macos` not `osx`).
- Incorrect path (`res://native/` not `res://../native/`).

3. Check library dependencies:
```bash
otool -L native/libgodot-java.dylib    # macOS
ldd native/libgodot-java.so             # Linux
```

---

## 3. Compile Errors

### 3.1 Java Version Requirement

**Symptom:**
```
error: cannot find symbol java.lang.foreign.MemorySegment
```

**Cause:** JDK is older than 25.

**Solution:** Install JDK 25+ and verify:
```bash
java -version    # must show 25+
```

### 3.2 Package Does Not Exist

**Symptom:**
```
error: package org.godot.annotation does not exist
```

**Cause:** godot-java-core dependency is missing or not resolved.

**Solution:**
```bash
mvn clean compile
```

Verify the dependency in `pom.xml`:
```xml
<dependency>
    <groupId>io.github.youngledo</groupId>
    <artifactId>godot-java-core</artifactId>
    <version>0.1.0</version>
</dependency>
```

---

## 4. Runtime Crashes (SIGBUS / SIGSEGV)

**Symptom:**
```
Signal: SIGBUS (Bad address)
Signal: SIGSEGV (Segmentation fault)
```

**Possible causes:**

1. **Invalid native pointer** -- calling methods on a freed or uninitialized object.
2. **Arena lifecycle violation** -- accessing memory after an Arena is closed.
3. **Godot version mismatch** -- running with Godot older than 4.6.

**Solutions:**

Check Godot version:
```bash
godot --version    # must be 4.6+
```

Always validate objects before calling:
```java
if (!isValid()) {
    return;  // native pointer is 0
}
```

Check for JVM crash logs:
```bash
ls hs_err_pid*.log
cat $(ls -t hs_err_pid*.log | head -1)
```

---

## 5. Class Not Found

**Symptom:**
```
ERROR: Class not found: com.example.MyClass
```

**Cause:** Class is not compiled, not on the classpath, or not annotated.

**Solution:**

1. Verify the class is compiled:
```bash
find target/classes -name "MyClass.class"
```

2. Check the classpath configuration. The C++ layer sets the classpath when creating the JVM. It must point to the directory containing your compiled classes.

3. Verify the class has the `@GodotClass` annotation:
```java
@GodotClass(name = "MyClass", parent = "Node")
public class MyClass extends Node { }
```

---

## 6. Method Not Callable from GDScript

**Symptom:**
```
ERROR: Method 'my_method' not found
```

**Cause:** Missing `@GodotMethod` annotation, or method is `private`.

**Solution:**

```java
// Wrong: no annotation
public void myMethod() { }

// Wrong: private method
@GodotMethod
private void myMethod() { }

// Correct
@GodotMethod
public void myMethod() { }
```

Also check:
- Parameter types are supported (int, long, float, double, boolean, String, GodotObject).
- The method is on a class that has `@GodotClass`.

---

## 7. @Export Property Not Visible in Editor

**Symptom:** Property does not appear in the Godot Inspector panel.

**Cause:** Field type is not supported, or field is `static`/`final`.

**Solution:**

Supported types: `int`, `long`, `float`, `double`, `boolean`, `String`, `GodotArray`, `GodotDictionary`.

```java
// Wrong
@Export
private static int count = 0;

@Export
private final String name = "fixed";

// Correct
@Export
private int count = 0;

@Export
private String name = "editable";
```

---

## 8. Godot Version Mismatch

**Symptom:**
```
ERROR: GDExtension version mismatch
```

**Solution:**

Verify Godot version:
```bash
godot --version    # must be 4.6+
```

Update `.gdextension`:
```ini
[configuration]
compatibility_minimum = 4.6
```

---

## 9. Performance Issues

**Symptom:** Low frame rate, stuttering.

**Cause:** Excessive cross-boundary calls, per-frame allocations, or verbose logging.

**Solutions:**

1. Cache frequently accessed values:
```java
private String cachedName;

@Override
public void _ready() {
    cachedName = getName();    // one native call
}

@Override
public void _process(double delta) {
    // Use cachedName instead of calling getName() every frame
}
```

2. Throttle logging:
```java
private int frameCount = 0;

@Override
public void _process(double delta) {
    if (frameCount % 60 == 0) {
        System.out.println("Position: " + getX() + ", " + getY());
    }
    frameCount++;
}
```

3. Minimize cross-boundary calls. Each `call()` from Java to Godot costs ~300-600ns (Panama + method bind lookup + variant conversion).

---

## Getting Help

If none of the above resolves your issue:

1. Enable debug logging in the C++ layer: `#define GODOT_JAVA_DEBUG 1`
2. Create a minimal reproduction case.
3. File a GitHub Issue with:
   - Godot version (`godot --version`)
   - Java version (`java -version`)
   - OS and architecture
   - Full error output
   - Minimal code sample
