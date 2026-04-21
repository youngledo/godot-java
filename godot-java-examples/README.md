# godot-java-examples

ENGLISH | [中文](README_ZH.md)

Progressive tutorial examples for [godot-java](https://github.com/youngledo/godot-java) — Java 25 + Panama FFI bindings for Godot.

## Prerequisites

- **JDK 25+** (required for Project Panama FFI)
- **Godot 4.6+**
- **Maven 4.0+**
- godot-java-core installed in local Maven repository

## Setup

### 1. Build the native bridge library

The native library is required for Godot to start the JVM. Build it for your platform:

```shell
# macOS (requires Xcode command line tools)
cd godot-java-core/native && ./build-macos.sh

# Linux (requires clang++)
cd godot-java-core/native && ./build-linux.sh
```

```cmd
REM Windows (requires MSVC or MinGW)
cd godot-java-core\native && build-windows.bat
```

This compiles `godot_java.cpp` and deploys the library to `examples/shared-native/`.

### 2. Build the fat jar

```shell
cd godot-java-examples
mvn package
```

This produces the fat JAR and automatically deploys it to `examples/shared-native/`.

### 3. Set environment variables

Before running any example, set these environment variables:

```shell
# macOS / Linux
export JAVA_HOME=/path/to/jdk-25
export GODOT_JAVA_CLASSPATH=$(pwd)/examples/shared-native/godot-java-examples.jar
```

```powershell
# Windows PowerShell
$env:JAVA_HOME = "C:\path\to\jdk-25"
$env:GODOT_JAVA_CLASSPATH = ".\examples\shared-native\godot-java-examples.jar"
```

### 3. Open an example in Godot

Open any example directory under `examples/` as a Godot project:

```shell
# macOS
open -a Godot.app ./examples/01-hello-world
```

Or run in headless mode:
```shell
# Step 1
/Applications/Godot.app/Contents/MacOS/Godot \                                                                                                                                                               
    --path godot-java-examples/examples/01-hello-world \                                                                                                                                                             
    --editor --quit-after 2

# Step 2
/Applications/Godot.app/Contents/MacOS/Godot \                                                                                                                                                                     
    --path godot-java-examples/examples/01-hello-world \                                                                                                                                                             
    --headless --quit
```

## Examples

| # | Name | Concepts | Description |
|---|------|----------|-------------|
| 01 | [hello-world](examples/01-hello-world) | `@GodotClass`, `_ready()` | Print a message from Java when the node enters the scene tree |
| 02 | [export-properties](examples/02-export-properties) | `@Export` | Expose fields to the Godot Inspector for editing |
| 03 | [godot-methods](examples/03-godot-methods) | `@GodotMethod` | Call Java methods from GDScript with parameters and return values |
| 04 | [signals](examples/04-signals) | `@Signal` | Declare and emit signals from Java, connect in GDScript |
| 05 | [process-loop](examples/05-process-loop) | `_process(delta)` | Per-frame updates — circular orbit motion |
| 06 | [node-tree](examples/06-node-tree) | `getChildren()`, `addChild()`, `getNode()` | Scene tree traversal and dynamic node creation |
| 07 | [physics-2d](examples/07-physics-2d) | `CharacterBody2D`, `_physicsProcess()`, `move_and_slide()` | 2D physics with gravity and movement |
| 08 | [math-types](examples/08-math-types) | `Vector2`, `Vector3`, `Color` | Math type operations (pure computation, no movement) |

## How It Works

Each example follows the same pattern:

1. **Java class** — annotated with `@GodotClass`, extends a Godot node type (e.g., `Node`, `Node2D`, `CharacterBody2D`)
2. **GDScript** — creates the Java object via `ClassDB.instantiate("ClassName")` and adds it to the scene tree
3. **Godot project** — minimal project with `project.godot`, `godot-java.gdextension`, and a scene

The `godot-java.gdextension` file tells Godot to load the native bridge library (`libgodot-java.so`/`.dylib`), which starts a JVM and registers all `@GodotClass`-annotated classes found on the classpath.

## Key Annotations

```java
@GodotClass(name = "MyNode", parent = "Node2D")  // Register as a Godot class
public class MyNode extends Node2D {

    @Export                                       // Visible in Godot Inspector
    public double speed = 200.0;

    @Override
    public void _ready() { ... }                  // Lifecycle: called once when added to tree

    @Override
    public void _process(double delta) { ... }    // Lifecycle: called every frame

    @GodotMethod                                  // Callable from GDScript
    public int compute(int x) { return x * 2; }

    @Signal                                       // Declare a signal
    public void onHit(int damage) {}
}
```

Emit signals from Java:
```java
call("emit_signal", "onHit", 42);
```

Connect signals in GDScript:
```gdscript
var node = ClassDB.instantiate("MyNode")
node.connect("onHit", _on_hit)
```

## Project Structure

```
godot-java-examples/
├── pom.xml                       # Maven build (shade → fat jar)
├── src/main/java/examples/       # Java example classes
└── examples/
    ├── shared-native/            # Shared deployment target (JAR + native lib)
    │   ├── godot-java-examples.jar
    │   └── libgodot-java.dylib   # (or .so / .dll per platform)
    ├── 01-hello-world/
    │   ├── native/               # Symlinks → ../../shared-native/
    │   ├── godot-java.gdextension
    │   └── main.tscn
    ├── 02-export-properties/
    └── ...
```

Each example's `native/` directory contains symlinks to `shared-native/`, so a single build deploys to all examples.

## License

Apache-2.0
