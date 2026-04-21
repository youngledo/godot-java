# API Reference

Complete reference for godot-java annotations, core types, and node classes.

## Annotations

### @GodotClass

Registers a Java class as a Godot extension class visible in ClassDB and the editor.

```java
package org.godot.annotation;
```

| Parameter | Type | Default | Description |
|---|---|---|---|
| `name` | String | (required) | Class name in Godot |
| `parent` | String | `"RefCounted"` | Parent class in Godot's class hierarchy |

```java
@GodotClass(name = "Player", parent = "Node2D")
public class Player extends Node2D {
    // visible in Godot as "Player" inheriting Node2D
}
```

Common parent classes:

| Parent | Use Case |
|---|---|
| `RefCounted` | Reference-counted objects (default) |
| `Node` | Base scene node |
| `Node2D` | 2D game objects |
| `Node3D` | 3D game objects |
| `Control` | UI elements |

The Java class must extend the corresponding wrapper class:

| Godot parent | Java base class |
|---|---|
| `RefCounted` | `org.godot.GodotObject` |
| `Node` | `org.godot.node.Node` |
| `Node2D` | `org.godot.node.Node2D` |
| `Node3D` | `org.godot.node.Node3D` |

### @GodotMethod

Exposes a Java method to GDScript. Methods without this annotation are private to Java.

```java
package org.godot.annotation;
```

| Parameter | Type | Default | Description |
|---|---|---|---|
| `value` | String | `""` | GDScript method name (defaults to Java method name) |

```java
@GodotMethod
public int add(int a, int b) {
    return a + b;
}

// Custom GDScript name
@GodotMethod("get_player_name")
public String getPlayerName() {
    return "Hero";
}
```

Supported return types: `void`, `boolean`, `int`, `long`, `float`, `double`, `String`, `GodotObject` and subclasses, `GodotArray`, `GodotDictionary`, `Variant`.

Supported parameter types: same as return types.

### @Export

Exposes a field as a Godot property visible in the editor Inspector.

```java
package org.godot.annotation;
```

| Parameter | Type | Default | Description |
|---|---|---|---|
| `propertyName` | String | `""` | Godot property name (defaults to field name) |
| `hint` | String | `""` | Property hint string for the editor |

```java
@Export
private int maxHealth = 100;

@Export
private float speed = 300.0f;

@Export
private String playerName = "Hero";
```

Supported field types: `int`, `long`, `float`, `double`, `boolean`, `String`, `GodotArray`, `GodotDictionary`.

### @Signal

Declares a Godot signal. The annotated method's body is never executed; only its parameter signature defines the signal's argument types.

```java
package org.godot.annotation;
```

| Parameter | Type | Default | Description |
|---|---|---|---|
| `name` | String | `""` | Signal name in Godot (defaults to method name) |

```java
// No-argument signal
@Signal(name = "died")
private void onDied() {}

// Signal with arguments
@Signal(name = "health_changed")
private void onHealthChanged(int newHealth) {}

// Multi-argument signal
@Signal(name = "item_collected")
private void onItemCollected(String itemType, int value) {}
```

Emit signals using `emitSignal()`:

```java
emitSignal("health_changed", currentHealth);
emitSignal("died");
emitSignal("item_collected", "coin", 100);
```

## Core Types

### Godot (Base Class)

`org.godot.Godot` is the abstract root of the entire Godot object hierarchy. All wrappers (Node, Node2D, GodotObject, etc.) extend this class.

**Key methods:**

```java
// Native pointer access
long getPtr()
boolean isValid()

// Method calling
Object call(String methodName, Object... args)

// Property access
Object getProperty(String name)
void setProperty(String name, Object value)

// Signal connection
boolean connect(String signalName, Callable callable, int flags)

// Virtual lifecycle methods (override in subclasses)
void _ready()
void _process(double delta)
void _physicsProcess(double delta)
void _enterTree()
void _exitTree()

// Cleanup
void free()
void onFreed()
```

### GodotObject

`org.godot.GodotObject` extends `Godot`. Use this as the base class when your `@GodotClass` has `parent = "RefCounted"`.

```java
@GodotClass(name = "MyService")
public class MyService extends GodotObject {
    // parent defaults to "RefCounted"
}
```

### Variant

`org.godot.core.Variant` wraps a Godot Variant (24 bytes: 16 data + 8 type tag). Variants are the universal value container in Godot.

**Factory methods:**

```java
Variant v = Variant.fromNil();
Variant v = Variant.fromBoolean(true);
Variant v = Variant.fromInt(42L);
Variant v = Variant.fromFloat(3.14);
Variant v = Variant.fromString("hello");
Variant v = Variant.fromVector2(new Vector2(1, 2));
Variant v = Variant.fromObjectPtr(nativePtr);
```

**Value extraction:**

```java
boolean b = v.asBoolean();
long    n = v.asLong();
double  d = v.asDouble();
String  s = v.asString();
```

**Type checking:**

```java
int type = v.getType();            // VariantType constant
VariantType vt = v.getVariantType();
```

### GodotStringName

`org.godot.core.GodotStringName` wraps Godot's interned string type used for method and signal names.

```java
GodotStringName sn = GodotStringName.fromJavaString("get_position");
MemorySegment segment = sn.segment();   // native pointer for API calls
```

### GodotString

`org.godot.core.GodotString` wraps Godot's native string type.

```java
GodotString gs = GodotString.fromJavaString("hello");
String javaStr = gs.toJavaString();
```

## Math Types

All in package `org.godot.math`.

### Vector2

```java
public class Vector2 {
    public double x, y;

    public Vector2(double x, double y)
    public double length()
    public Vector2 normalized()
    public double dot(Vector2 other)
}
```

### Vector3

```java
public class Vector3 {
    public double x, y, z;

    public Vector3(double x, double y, double z)
    public double length()
    public Vector3 normalized()
    public double dot(Vector3 other)
    public Vector3 cross(Vector3 other)
}
```

Additional math types: `Vector2i`, `Vector3i`, `Vector4`, `Vector4i`, `Color`, `Rect2`, `Rect2i`, `AABB`, `Basis`, `Plane`, `Quaternion`, `Projection`, `Transform2D`, `Transform3D`.

## Node Classes

### Node

`org.godot.node.Node` -- base class for all scene nodes. Extends `Godot`.

```java
String getName()
void setName(String name)
Node getParent()
List<Node> getChildren()
int getChildCount()
void addChild(Node child)
void removeChild(Node child)
Node getNode(String path)
String getPath()
boolean isInsideTree()
void queueFree()

// Lifecycle (override in subclasses)
void _ready()
void _process(double delta)
void _physicsProcess(double delta)
```

### Node2D

`org.godot.node.Node2D` -- 2D game object. Extends `Node`.

```java
// Position
Vector2 getPosition()
double getX()
double getY()
void setPosition(Vector2 pos)
void setPosition(double x, double y)
void setX(double x)
void setY(double y)

// Rotation
double getRotation()           // radians
void setRotation(double radians)
double getRotationDeg()        // degrees
void setRotationDeg(double degrees)

// Scale
Vector2 getScale()
void setScale(Vector2 s)
void setScale(double scaleX, double scaleY)

// Transforms
void translate(double dx, double dy)
void rotate(double radians)
```

### Node3D

`org.godot.node.Node3D` -- 3D game object. Extends `Node`.

```java
// Position
Vector3 getPosition()
double getX()
double getY()
double getZ()
void setPosition3D(Vector3 pos)
void setPosition3D(double x, double y, double z)

// Rotation (Euler angles in radians)
Vector3 getRotation()
void setRotation3D(Vector3 rot)
void setRotation3D(double x, double y, double z)

// Scale
Vector3 getScale()
void setScale3D(Vector3 s)
void setScale3D(double x, double y, double z)

// Transforms
void translate3D(double dx, double dy, double dz)
```

## Collections

### GodotArray

`org.godot.collection.GodotArray` -- dynamic array backed by Godot's native Array type. Implements `AutoCloseable`.

```java
// Creation
GodotArray arr = new GodotArray();

// Modification
void append(Object value)
void set(int index, Object value)
void removeAt(int index)
void clear()

// Access
Object get(int index)
int size()
boolean isEmpty()

// Query
int indexOf(Object value)
boolean contains(Object value)

// Conversion
Variant toVariant()
```

### GodotDictionary

`org.godot.collection.GodotDictionary` -- key-value container backed by Godot's native Dictionary. Implements `AutoCloseable`.

```java
// Creation
GodotDictionary dict = new GodotDictionary();

// Modification
void put(Object key, Object value)

// Access
Object get(Object key)
boolean has(Object key)

// Deletion
boolean remove(Object key)
void clear()

// Iteration
GodotArray keys()
GodotArray values()

// Query
int size()
boolean isEmpty()
```

## Type Mapping

### Java to Godot Variant

| Java Type | Godot Variant Type |
|---|---|
| `null` | NIL |
| `boolean` | BOOL |
| `int` / `long` | INT |
| `float` / `double` | FLOAT |
| `String` | STRING |
| `Vector2` | VECTOR2 |
| `Vector3` | VECTOR3 |
| `GodotObject` | OBJECT |
| `GodotArray` | ARRAY |
| `GodotDictionary` | DICTIONARY |

### Type Coercion in Method Dispatch

When Godot calls a `@GodotMethod`, arguments are automatically coerced via `MethodDispatch.coerceType()`:

- `Number` to `int`, `long`, `float`, `double` as needed by the parameter type.
- `Boolean` passes through.
- Other types pass through unchanged.

## Module Configuration

The module `org.godot` exports the following packages for user code:

```java
// module-info.java
module org.godot {
    exports org.godot;             // Godot base class
    exports org.godot.annotation;  // @GodotClass, @GodotMethod, @Export, @Signal
    exports org.godot.core;        // Variant, GodotString, GodotStringName
    exports org.godot.node;        // Node, Node2D, Node3D
    exports org.godot.math;        // Vector2, Vector3, ...
    exports org.godot.collection;  // GodotArray, GodotDictionary
    exports org.godot.registration; // Scanner
}
```

Internal packages (`bridge`, `bootstrap`, `internal`) are not exported and should not be accessed from user code.
