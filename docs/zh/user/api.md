# API 参考

godot-java API 参考文档，涵盖注解、核心类型、节点层级和集合类型。

> **包名前缀**：所有公开 API 位于 `org.godot.*` 下。模块名为 `org.godot`。

---

## 注解

### @GodotClass

将 Java 类标记为 Godot 扩展类，注册到 ClassDB。

**所在包**：`org.godot.annotation.GodotClass`

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `name` | String | (必填) | Godot 中显示的类名 |
| `parent` | String | `"RefCounted"` | 父类 Godot 类名 |

**常用父类**：

| 父类 | Java 基类 | 说明 |
|------|----------|------|
| `RefCounted` | `org.godot.core.RefCounted` | 引用计数对象（默认） |
| `Node` | `org.godot.node.Node` | 场景节点基类 |
| `Node2D` | `org.godot.node.Node2D` | 2D 场景节点 |
| `Node3D` | `org.godot.node.Node3D` | 3D 场景节点 |
| `Control` | `org.godot.node.Control` | UI 节点 |
| `CharacterBody2D` | 生成类 | 2D 角色控制器 |
| `CharacterBody3D` | 生成类 | 3D 角色控制器 |

```java
import org.godot.annotation.GodotClass;
import org.godot.node.Node2D;

@GodotClass(name = "Player", parent = "Node2D")
public class Player extends Node2D {
    @Override
    public void _ready() {
        // 节点加入场景树时调用
    }
}

// 使用默认父类 RefCounted
@GodotClass(name = "GameConfig")
public class GameConfig extends RefCounted {
    // GDScript: var obj = GameConfig.new()
}
```

### @GodotMethod

将 Java 方法暴露为可从 GDScript 调用的方法。

**所在包**：`org.godot.annotation.GodotMethod`

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `value` | String | `""` | GDScript 中显示的方法名，空则使用 Java 方法名 |

**支持的返回类型**：`void`、`boolean`、`int`、`long`、`float`、`double`、`String`、`Godot` 及子类

**支持的参数类型**：同返回类型

```java
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;

@GodotClass(name = "Calculator", parent = "RefCounted")
public class Calculator extends RefCounted {

    @GodotMethod
    public int add(int a, int b) {
        return a + b;
    }

    // 自定义 GDScript 方法名
    @GodotMethod("get_player_name")
    public String getPlayerName() {
        return "Hero";
    }
}
```

GDScript 调用：

```gdscript
var calc = Calculator.new()
print(calc.add(5, 3))         # 8
print(calc.get_player_name()) # Hero
```

### @Export

将字段标记为 Godot 导出属性，在编辑器属性检查器中可见且可编辑。

**所在包**：`org.godot.annotation.Export`

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `propertyName` | String | `""` | Godot 属性名，空则使用 Java 字段名 |
| `hint` | String | `""` | 属性提示字符串 |

**支持的字段类型**：`int`、`long`、`float`、`double`、`boolean`、`String`

```java
import org.godot.annotation.Export;

@GodotClass(name = "Enemy", parent = "Node2D")
public class Enemy extends Node2D {

    // 基本导出
    @Export
    private int maxHealth = 100;

    @Export
    private float speed = 200.0f;

    @Export
    private String enemyName = "Goblin";

    // 带提示的导出
    @Export(hint = "range:0,100,1")
    private int health = 100;
}
```

### @Signal

将方法声明为 Godot 信号。方法体不会被执行，方法签名定义信号的参数类型。

**所在包**：`org.godot.annotation.Signal`

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `name` | String | `""` | 信号名称，空则使用 Java 方法名 |

**支持的参数类型**：`int`、`long`、`float`、`double`、`boolean`、`String`

```java
import org.godot.annotation.Signal;

@GodotClass(name = "Player", parent = "Node2D")
public class Player extends Node2D {

    // 无参数信号
    @Signal(name = "died")
    private void onDied() {}

    // 带参数信号
    @Signal(name = "health_changed")
    private void onHealthChanged(int newHealth) {}

    // 多参数信号
    @Signal(name = "item_collected")
    private void onItemCollected(String itemType, int value) {}

    @GodotMethod
    public void takeDamage(int amount) {
        // ...
        emit("health_changed", currentHealth);
        if (currentHealth <= 0) {
            emit("died");
        }
    }
}
```

GDScript 中连接信号：

```gdscript
var player = Player.new()
player.connect("health_changed", self, "_on_health_changed")

func _on_health_changed(new_health):
    print("生命值: ", new_health)
```

---

## 核心类型

### Godot（抽象基类）

**所在包**：`org.godot.Godot`

所有 Godot 对象的抽象根类。提供方法调用、属性访问和信号功能。

```java
public abstract class Godot {
    // 原生对象管理
    public long getPtr()
    public boolean isValid()

    // 方法调用
    public Object call(String methodName, Object... args)

    // 属性访问
    public Object getProperty(String name)
    public void setProperty(String name, Object value)

    // 信号
    public boolean connect(String signalName, Callable callable, int flags)
    public void emit(String signalName, Object... args)

    // 虚方法（子类重写）
    public void _ready()
    public void _process(double delta)
    public void _physicsProcess(double delta)
    public void _enterTree()
    public void _exitTree()

    // 生命周期
    public void free()
    public void onFreed()
}
```

### GodotObject

**所在包**：`org.godot.GodotObject`

所有 Godot 引擎对象的包装器，继承 `Godot`。用于封装已有的 Godot 原生对象。

```java
public class GodotObject extends Godot {
    protected GodotObject(MemorySegment nativePtr)
    protected GodotObject(long nativePtr)
}
```

### Variant

**所在包**：`org.godot.core.Variant`

Godot Variant 类型的包装器。Variant 是 Godot 的动态类型容器，可持有任意 Godot 值。内存布局为 24 字节（16 字节数据 + 8 字节类型/元数据）。

```java
// 创建 Variant
Variant v = Variant.fromInt(42L);
Variant v = Variant.fromFloat(3.14);
Variant v = Variant.fromBoolean(true);
Variant v = Variant.fromString("hello");
Variant v = Variant.fromNil();

// 从 Vector2 创建
Variant v = Variant.fromVector2(new Vector2(1, 2));

// 提取值
long n = v.asLong();
double d = v.asDouble();
boolean b = v.asBoolean();
String s = v.asString();

// 类型查询
int type = v.getType();
```

**Variant 类型常量**（定义在 `org.godot.internal.api.VariantType`）：

| 类型 | 说明 |
|------|------|
| `NIL` | 空值 |
| `BOOL` | 布尔值 |
| `INT` | 整数 |
| `FLOAT` | 浮点数 |
| `STRING` | 字符串 |
| `VECTOR2` | 2D 向量 |
| `VECTOR3` | 3D 向量 |
| `OBJECT` | Godot 对象 |
| `DICTIONARY` | 字典 |
| `ARRAY` | 数组 |

### GodotString

**所在包**：`org.godot.core.GodotString`

Godot String 类型的包装器。Godot 内部使用 UTF-32 编码。

```java
// 从 Java String 创建
GodotString gs = GodotString.fromJavaString("Hello");

// 转换回 Java String
String javaStr = gs.toJavaString();
```

### GodotStringName

**所在包**：`org.godot.core.GodotStringName`

Godot StringName 的包装器。StringName 是 Godot 中用于快速比较的不可变字符串，常用于方法名和属性名查找。

```java
GodotStringName sn = GodotStringName.fromJavaString("get_position");
MemorySegment segment = sn.segment(); // 获取原生内存段
```

---

## 数学类型

所有数学类型位于 `org.godot.math` 包中。

### Vector2

```java
import org.godot.math.Vector2;

Vector2 v = new Vector2(3, 4);

// 基本属性
double len = v.length();        // 5.0
Vector2 n = v.normalized();     // (0.6, 0.8)

// 运算
Vector2 sum = v.add(new Vector2(1, 1));
Vector2 diff = v.sub(new Vector2(1, 1));
Vector2 scaled = v.mul(2.0);
Vector2 divided = v.div(2.0);

// 点积和叉积
double dot = v.dot(other);
double cross = v.cross(other);

// 其他
double dist = v.distanceTo(other);
Vector2 rotated = v.rotated(Math.PI / 4);
Vector2 lerped = v.lerp(other, 0.5);
```

**常量**：`ZERO`、`ONE`、`UP`、`DOWN`、`LEFT`、`RIGHT`、`INF`

### Vector3

```java
import org.godot.math.Vector3;

Vector3 v = new Vector3(1, 2, 3);
```

**常量**：`ZERO`、`ONE`、`UP`、`DOWN`、`LEFT`、`RIGHT`、`FORWARD`、`BACK`、`INF`

### 其他数学类型

| 类型 | 说明 |
|------|------|
| `Vector2i` | 2D 整数向量 |
| `Vector3i` | 3D 整数向量 |
| `Vector4` | 4D 向量 |
| `Vector4i` | 4D 整数向量 |
| `Rect2` | 2D 矩形 |
| `Rect2i` | 2D 整数矩形 |
| `Transform2D` | 2D 变换矩阵 |
| `Transform3D` | 3D 变换矩阵 |
| `Basis` | 3x3 矩阵 |
| `Quaternion` | 四元数 |
| `AABB` | 轴对齐包围盒 |
| `Plane` | 3D 平面 |
| `Color` | RGBA 颜色 |
| `Projection` | 4x4 投影矩阵 |

---

## 节点层级

所有节点类型位于 `org.godot.node` 包中。

### Node

场景节点基类，继承自 `Godot`。

```java
import org.godot.node.Node;

// 生命周期虚方法
public void _ready()                    // 节点加入场景树时调用
public void _process(double delta)      // 每帧调用
public void _physicsProcess(double delta) // 每物理帧调用
public void _enterTree()                // 进入场景树
public void _exitTree()                 // 离开场景树

// 场景树导航
public Node getNode(String path)
public List<Node> getChildren()
public void addChild(Node child)
public void removeChild(Node child)
public String getName()
public void setName(String name)

// 静态工厂
public static Node fromNativePointer(long nativePtr)
```

### Node2D

2D 场景节点，继承自 `Node`。提供位置、旋转、缩放和 Z 轴排序。

```java
import org.godot.node.Node2D;
import org.godot.math.Vector2;

// 位置
public Vector2 getPosition()
public double getX()
public double getY()
public void setPosition(Vector2 pos)
public void setPosition(double x, double y)
public void setX(double x)
public void setY(double y)

// 旋转（弧度）
public double getRotation()
public void setRotation(double radians)
public double getRotationDeg()            // 角度
public void setRotationDeg(double degrees)

// 缩放
public Vector2 getScale()
public void setScale(Vector2 s)
public void setScale(double scaleX, double scaleY)

// 变换
public void translate(double dx, double dy)
public void rotate(double radians)
```

### Node3D

3D 场景节点，继承自 `Node`。提供 3D 位置、旋转和缩放。

```java
import org.godot.node.Node3D;

// 位置
public void setPosition(double x, double y, double z)

// 旋转（弧度）
public void setRotation(double x, double y, double z)

// 缩放
public void setScale(double x, double y, double z)
```

---

## 集合类型

集合类型位于 `org.godot.collection` 包中。

### GodotArray

Godot 动态数组，可持有任意 Variant 值。

```java
import org.godot.collection.GodotArray;

GodotArray array = new GodotArray(variantSegment);

// 访问
Object elem = array.get(index);
int size = array.size();
```

### GodotDictionary

Godot 字典，键值对容器。继承 `RefCounted`。

```java
import org.godot.collection.GodotDictionary;

GodotDictionary dict = new GodotDictionary(nativePtr);

// 访问
Object val = dict.get("key");
dict.put("key", 42);
boolean has = dict.has("key");
int size = dict.size();
```

---

## 类型映射

### Java <-> Godot 类型对照表

| Java 类型 | Godot Variant 类型 | 说明 |
|-----------|-------------------|------|
| `int` / `long` | INT | 整数 |
| `float` / `double` | FLOAT | 浮点数 |
| `boolean` | BOOL | 布尔值 |
| `String` | STRING | 字符串 |
| `Godot` 及子类 | OBJECT | Godot 对象 |
| `GodotArray` | ARRAY | 动态数组 |
| `GodotDictionary` | DICTIONARY | 字典 |
| `Vector2` | VECTOR2 | 2D 向量 |
| `Vector3` | VECTOR3 | 3D 向量 |
| `null` | NIL | 空值 |

---

## 模块信息

godot-java 使用 Java 模块系统（JPMS）。`module-info.java` 位于 `org.godot` 模块中：

```java
module org.godot {
    requires java.base;
    requires org.apache.logging.log4j;

    // 公开 API 包
    exports org.godot;              // Godot, GodotObject
    exports org.godot.annotation;   // @GodotClass, @GodotMethod, @Export, @Signal
    exports org.godot.core;         // Variant, GodotString, GodotStringName
    exports org.godot.node;         // Node, Node2D, Node3D
    exports org.godot.math;         // Vector2, Vector3, etc.
    exports org.godot.collection;   // GodotArray, GodotDictionary
    exports org.godot.registration; // Scanner

    // 内部包（不导出）
    // org.godot.bootstrap, org.godot.bridge, org.godot.internal
}
```

如果你的项目也使用模块系统，在 `module-info.java` 中添加：

```java
module your.game {
    requires org.godot;
}
```
