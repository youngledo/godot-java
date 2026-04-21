# Development Guide

A practical guide to building game logic with godot-java.

## Creating a Game Entity

This walkthrough builds a `Player` entity with health, movement, properties, and signals.

### Full Example

```java
package com.example;

import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.math.Vector2;
import org.godot.node.Node2D;

@GodotClass(name = "Player", parent = "Node2D")
public class Player extends Node2D {

    // -- Exported properties (visible in editor) --

    @Export
    private float moveSpeed = 300.0f;

    @Export
    private int maxHealth = 100;

    // -- Internal state --

    private int health;

    // -- Signals --

    @Signal(name = "health_changed")
    private void onHealthChanged(int newHealth) {}

    @Signal(name = "died")
    private void onDied() {}

    @Signal(name = "moved")
    private void onMoved(double x, double y) {}

    // -- Lifecycle --

    @Override
    public void _ready() {
        health = maxHealth;
    }

    @Override
    public void _process(double delta) {
        // Movement logic would go here
        // e.g., read input, update position
    }

    // -- Public methods (callable from GDScript) --

    @GodotMethod
    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
        emitSignal("health_changed", health);
        if (health <= 0) {
            emitSignal("died");
        }
    }

    @GodotMethod
    public void heal(int amount) {
        health = Math.min(health + amount, maxHealth);
        emitSignal("health_changed", health);
    }

    @GodotMethod
    public int getHealth() {
        return health;
    }

    @GodotMethod
    public void teleportTo(double x, double y) {
        setPosition(x, y);
        emitSignal("moved", x, y);
    }
}
```

Use from GDScript:

```gdscript
extends Node2D

func _ready():
    var player = Player.new()
    add_child(player)
    player.connect("health_changed", self, "_on_health_changed")
    player.connect("died", self, "_on_died")
    player.take_damage(30)

func _on_health_changed(new_health):
    print("Health: ", new_health)

func _on_died():
    print("Player died!")
```

## How Method Dispatch Works

Understanding the call chain helps debug issues.

### GDScript Calling Java

When GDScript calls `player.take_damage(30)`:

```
GDScript: player.take_damage(30)
  |
  v
Godot engine: looks up method bind via ClassDB
  |
  v
GDExtension: object_method_bind_call()
  |
  v
C++ bridge: methodCallCallback (registered upcall stub)
  |
  v
JNI: calls into JVM
  |
  v
MethodDispatch.callAdapter()
  - looks up Method from registered methods by userdata key
  - finds Java instance via JavaObjectMap.get(instancePtr)
  - converts Variant args to Java types via VariantUtils.toObject()
  - coerces types via coerceType() (Number -> int, etc.)
  - invokes method via reflection: method.invoke(obj, javaArgs)
  - converts return value back to Variant
  |
  v
Java: Player.takeDamage(30)
```

### Java Calling Godot

When Java calls `call("set_position", pos)`:

```
Java: call("set_position", pos)
  |
  v
Godot.call()
  - walks class hierarchy to find METHOD_HASHES
  - gets method bind via CLASSDB_GET_METHOD_BIND
  - converts args to Variants via VariantUtils.fromObject()
  - calls OBJECT_METHOD_BIND_CALL via Panama MethodHandle
  |
  v
Panama FFI: ~50ns per call
  |
  v
Godot C++ engine: executes set_position
```

## Virtual Methods

Virtual methods are lifecycle callbacks that Godot invokes automatically. Override them with `@Override`:

```java
@GodotClass(name = "Enemy", parent = "Node2D")
public class Enemy extends Node2D {

    @Override
    public void _ready() {
        // Called once when node enters scene tree.
        // Initialize state, connect signals, find child nodes.
    }

    @Override
    public void _process(double delta) {
        // Called every frame. delta is seconds since last frame.
        // Use for visual updates, input, non-physics logic.
    }

    @Override
    public void _physicsProcess(double delta) {
        // Called every physics frame (default: 60 Hz).
        // Use for physics, collision, movement.
    }

    @Override
    public void _enterTree() {
        // Called when node enters the scene tree.
    }

    @Override
    public void _exitTree() {
        // Called when node exits the scene tree.
        // Clean up connections, free resources.
    }
}
```

### How Virtual Dispatch Works

Godot queries `get_virtual_func` once per virtual method per class. godot-java returns Panama upcall stubs that route to the correct Java instance:

```
Godot: "What is _process for class Player?"
  |
  v
VirtualDispatch.getVirtualFunc()
  - matches method name against registered stubs
  - returns a Panama upcall stub bound to "_process"
  |
  v
Godot calls the stub each frame:
  |
  v
VirtualDispatch.dispatch("_process", instancePtr, args, ret)
  - looks up Java object via JavaObjectMap.get(instancePtr)
  - extracts double delta from args
  - calls obj._process(delta)
```

Supported virtual methods: `_ready`, `_process`, `_physics_process`, `_enter_tree`, `_exit_tree`.

## Properties with @Export

`@Export` fields appear in the Godot editor Inspector and are serialized with the scene.

### Supported Types

| Java Type | Godot Type | Editor Widget |
|---|---|---|
| `int` | INT | Number input |
| `long` | INT | Number input |
| `float` | FLOAT | Number input |
| `double` | FLOAT | Number input |
| `boolean` | BOOL | Checkbox |
| `String` | STRING | Text input |
| `GodotArray` | ARRAY | Array editor |
| `GodotDictionary` | DICTIONARY | Dictionary editor |

### Best Practices

- Always give exported fields a default value.
- Mark them `private` -- access from Java via normal field reads/writes.
- Do not mark them `static` or `final`.

```java
@Export
private float speed = 300.0f;      // good

@Export
private static float SPEED = 300;  // wrong: static

@Export
private final float speed = 300;   // wrong: final
```

## Signal Emission

### Declaring Signals

```java
@Signal(name = "health_changed")
private void onHealthChanged(int newHealth) {}
```

- The method body is never executed.
- The parameter types define the signal's argument signature.
- The `name` parameter sets the signal name in Godot.

### Emitting Signals

```java
emitSignal("health_changed", health);       // one arg
emitSignal("died");                          // no args
emitSignal("item_collected", "coin", 100);   // multiple args
```

`emitSignal()` is inherited from `Godot`. It calls the Godot C API to emit the signal on the native object.

### Connecting Signals

From Java:

```java
@Override
public void _ready() {
    Node child = getNode("Timer");
    child.connect("timeout", callable, 0);
}
```

From GDScript:

```gdscript
player.connect("health_changed", self, "_on_health_changed")
```

## Type Coercion

When Godot calls a Java `@GodotMethod`, the runtime automatically converts Variant arguments to the expected Java types:

```java
@GodotMethod
public void processValue(int count, double ratio, String label) {
    // Godot may pass:
    //   process_value(42, 3.14, "hello")  -- exact match
    //   process_value(42L, 3.14f, "hello") -- coerced: Long->int, Float->double
}
```

The `MethodDispatch.coerceType()` method handles:
- `Number` to `int`, `long`, `float`, `double`
- `Boolean` passes through
- Other types pass through unchanged

## Resource Management

### Arena Usage

The `Bridge` class uses a two-tier arena strategy:

- **Persistent arena** (`Bridge.ARENA`): Used during registration for upcall stubs and static data. Lives for the JVM's lifetime.
- **Scoped arena**: Each runtime call (`Godot.call()`, `GodotArray` operations, etc.) automatically creates a scoped arena via `Bridge.runScoped()`. Temporary Variants and buffers are allocated from this arena and freed when the call returns. `variant_destroy` is called on all temporary Variants before the arena closes.

For most user code, you do not need to manage arenas manually. The framework handles all allocation and cleanup automatically.

### Object Lifecycle

- **RefCounted** objects: managed by Godot's reference counting.
- **Node** objects: managed by the scene tree. Use `queueFree()` to remove.
- **JavaObjectMap**: maintains the bidirectional mapping between native pointers and Java wrappers. When Godot frees a native object, the Java wrapper's `onFreed()` callback is invoked.

## Migrating from GDScript

### Syntax Comparison

| GDScript | Java |
|---|---|
| `var x = 10` | `@Export private int x = 10;` |
| `const MAX = 100` | `private static final int MAX = 100;` |
| `extends Node2D` | `@GodotClass(name="...", parent="Node2D")` |
| `signal health_changed(val)` | `@Signal(name = "health_changed") private void ...` |
| `emit_signal("health_changed", val)` | `emitSignal("health_changed", val)` |

### Method Name Mapping

GDScript uses `snake_case`; Java uses `camelCase`:

| GDScript | Java |
|---|---|
| `_ready()` | `_ready()` |
| `_process(delta)` | `_process(double delta)` |
| `_physics_process(delta)` | `_physicsProcess(double delta)` |
| `move_and_slide()` | `moveAndSlide()` |
| `get_node()` | `getNode()` |
| `queue_free()` | `queueFree()` |

### Key Differences

- Java is statically typed -- all variables need type declarations.
- No `onready` keyword; initialize node references in `_ready()`.
- No `yield`; use virtual threads (`Thread.startVirtualThread()`) for async patterns.
- Method names follow Java camelCase conventions.
