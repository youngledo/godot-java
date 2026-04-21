# 使用指南

本文档介绍 godot-java 的核心概念和进阶用法。

## 为什么选择 Java

### Java vs GDScript

| 维度 | GDScript | Java |
|------|----------|------|
| 类型系统 | 动态类型，运行时报错 | 强类型，编译期检查 |
| 工具链 | Godot 编辑器 | IntelliJ IDEA、VS Code |
| 生态 | Godot 专用 | Maven Central 海量库 |
| 性能 | 解释执行 | Panama FFI 低开销原生调用 |
| 语言特性 | 简单脚本 | Lambda、Stream、泛型、模块化 |

### 适用场景

适合使用 Java：
- 有 Java / Android / 后端开发背景
- 需要复用已有 Java 库
- 项目规模较大，需要强类型和模块化架构
- 需要 IDE 级别的重构和调试支持

适合使用 GDScript：
- 编程初学者
- 快速原型开发
- 仅需简单游戏逻辑

---

## 核心概念

### 节点与继承

使用 `@GodotClass` 将 Java 类注册为 Godot 节点。Java 类必须继承对应的 Godot 父类：

```java
import org.godot.annotation.GodotClass;
import org.godot.node.Node2D;

@GodotClass(name = "Player", parent = "CharacterBody2D")
public class Player extends Node2D {
}
```

常用父类：

| 父类 | Java 基类 | 用途 |
|------|----------|------|
| `Node` | `org.godot.node.Node` | 基础节点 |
| `Node2D` | `org.godot.node.Node2D` | 2D 节点 |
| `Node3D` | `org.godot.node.Node3D` | 3D 节点 |
| `Control` | `org.godot.node.Control` | UI 节点 |
| `RefCounted` | `org.godot.core.RefCounted` | 引用计数对象（默认） |

### 虚方法

Godot 的虚方法在 Java 中通过 `@Override` 实现：

```java
@Override
public void _ready() {
    // 节点加入场景树时调用（仅一次）
}

@Override
public void _process(double delta) {
    // 每帧调用，delta 为距上一帧的时间（秒）
}

@Override
public void _physicsProcess(double delta) {
    // 每物理帧调用（固定时间步长）
}

@Override
public void _enterTree() {
    // 节点进入场景树时调用
}

@Override
public void _exitTree() {
    // 节点离开场景树时调用
}
```

这些虚方法由 `VirtualDispatch` 类通过 Panama upcall stub 路由到 Java 对象。当 Godot 调用 `get_virtual_func` 查询虚方法时，返回对应的方法分发 stub；Godot 调用该 stub 时，通过 `JavaObjectMap` 查找对应的 Java 实例并调用其方法。

### 完整示例：角色组件

```java
package com.example;

import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.node.Node;
import org.godot.node.Node2D;
import org.godot.math.Vector2;

@GodotClass(name = "Player", parent = "Node2D")
public class Player extends Node2D {

    @Export
    private float speed = 300.0f;

    @Export
    private int maxHealth = 100;

    private int currentHealth;

    @Signal(name = "health_changed")
    private void onHealthChanged(int newHealth) {}

    @Signal(name = "died")
    private void onDied() {}

    @Override
    public void _ready() {
        currentHealth = maxHealth;
    }

    @Override
    public void _process(double delta) {
        // 每帧更新逻辑
        handleMovement(delta);
    }

    private void handleMovement(double delta) {
        // 调用 Godot 方法检查输入
        Object rightPressed = call("is_action_pressed", "move_right");
        Object leftPressed = call("is_action_pressed", "move_left");

        double dx = 0;
        if (rightPressed instanceof Boolean b && b) dx += speed;
        if (leftPressed instanceof Boolean b && b) dx -= speed;

        translate(dx * delta, 0);
    }

    @GodotMethod
    public void takeDamage(int amount) {
        currentHealth -= amount;
        emit("health_changed", currentHealth);
        if (currentHealth <= 0) {
            emit("died");
        }
    }

    @GodotMethod
    public int getHealth() {
        return currentHealth;
    }
}
```

---

## 方法调用

### Java 调用 Godot 方法

使用 `Godot.call()` 调用任意 Godot 方法：

```java
// 无参数
Object name = call("get_name");

// 带参数
call("set_position", new Vector2(100, 200));

// 获取返回值
Object result = call("is_visible");
if (result instanceof Boolean visible && visible) {
    // ...
}
```

方法调用流程：
1. 通过 `METHOD_HASHES` 查找方法哈希值
2. 调用 `classdb_get_method_bind` 获取方法绑定
3. 将参数转换为 Variant
4. 调用 `object_method_bind_call` 执行
5. 将返回的 Variant 转换为 Java 对象

### Godot 调用 Java 方法

使用 `@GodotMethod` 暴露方法给 GDScript：

```java
@GodotMethod
public void takeDamage(int amount) {
    health -= amount;
}

@GodotMethod("custom_name_in_gdscript")
public void myJavaMethod() {
    // GDScript 中以 "custom_name_in_gdscript" 调用
}
```

### 类型转换

| Godot Variant | Java 类型 | 示例 |
|--------------|-----------|------|
| NIL | `null` | `null` |
| BOOL | `boolean` / `Boolean` | `true` |
| INT | `long` / `int` | `42L` |
| FLOAT | `double` / `float` | `3.14` |
| STRING | `String` | `"hello"` |
| VECTOR2 | `Vector2` | `new Vector2(1, 2)` |
| VECTOR3 | `Vector3` | `new Vector3(1, 2, 3)` |
| ARRAY | `GodotArray` | 从 native 构造 |
| DICTIONARY | `GodotDictionary` | 从 native 构造 |
| OBJECT | `Godot` 子类 | 包装 native 指针 |

类型转换由 `VariantUtils.fromObject()` 和 `VariantUtils.toObject()` 自动完成。

---

## 属性与导出

### @Export 注解

标记了 `@Export` 的字段会在 Godot 编辑器的属性检查器中显示，可在编辑器中直接修改：

```java
@Export
private int speed = 300;

@Export
private float jumpVelocity = -400.0f;

@Export
private String playerName = "Hero";
```

### 支持的属性类型

- 基本类型：`int`、`long`、`float`、`double`、`boolean`
- 字符串：`String`

### 自定义属性名和提示

```java
// 自定义属性名
@Export(propertyName = "move_speed")
private float speed = 300.0f;

// 带提示（range）
@Export(hint = "range:0,100,1")
private int health = 100;
```

---

## 信号

### 声明信号

```java
@Signal(name = "health_changed")
private void onHealthChanged(int newHealth) {}

@Signal(name = "died")
private void onDied() {}

@Signal(name = "item_collected")
private void onItemCollected(String itemType, int value) {}
```

### 发射信号

```java
emit("health_changed", currentHealth);
emit("died");
emit("item_collected", "coin", 100);
```

### 连接信号

在 GDScript 中：
```gdscript
player.connect("health_changed", self, "_on_health_changed")
```

在 Java 中：
```java
// 在 _ready() 中连接
connect("pressed", callable, 0);
```

### 连接标志

| 标志 | 值 | 说明 |
|------|---|------|
| `CONNECT_DEFERRED` | 1 | 延迟调用 |
| `CONNECT_PERSIST` | 2 | 节点移动时保持连接 |
| `CONNECT_ONE_SHOT` | 4 | 触发一次后自动断开 |

---

## 从 GDScript 迁移

### 基本语法对照

| GDScript | Java | 说明 |
|----------|------|------|
| `var x = 10` | `@Export private int x = 10;` | 使用 `@Export` 可在编辑器可见 |
| `const MAX = 100` | `private static final int MAX = 100;` | Java 常量 |
| `onready var node = $Child` | 在 `_ready()` 中初始化 | 无 `onready` 关键字 |
| `extends Node2D` | `@GodotClass(...) extends Node2D` | 注解 + 继承 |

### 方法命名对照

| GDScript | Java |
|----------|------|
| `_ready()` | `_ready()` |
| `_process(delta)` | `_process(double delta)` |
| `_physics_process(delta)` | `_physicsProcess(double delta)` |
| `move_and_slide()` | `call("move_and_slide")` |
| `get_node("path")` | `getNode("path")` |
| `get_children()` | `getChildren()` |

### 信号对照

```gdscript
# GDScript
signal health_changed(new_health)
emit_signal("health_changed", health)
```

```java
// Java
@Signal(name = "health_changed")
public void healthChanged(int newHealth) {}

emit("health_changed", health);
```

### 关键差异

- Java 使用静态类型，所有变量需要声明类型
- 无 `onready` 关键字，需在 `_ready()` 中显式初始化节点引用
- 方法名在 Godot 侧保持原样（snake_case），Java 侧使用 camelCase
- 节点引用通过 `getNode("Path")` 获取，建议在 `_ready()` 中缓存

---

## 资源管理

### 原生指针

`Godot` 类持有原生 Godot 对象的指针（`nativeObject` 字段）。通过 `getPtr()` 获取，`isValid()` 检查有效性。

### 实例生命周期

1. Godot 调用 `create_instance_func`（由 `InstanceCallbacks` 处理）
2. Java 创建实例，通过反射设置 `nativeObject` 字段
3. 实例注册到 `JavaObjectMap`（nativePtr -> Java 对象映射）
4. 虚方法通过 `VirtualDispatch` -> `JavaObjectMap` 查找实例并分发
5. Godot 调用 `free_instance_func` 时，从 `JavaObjectMap` 移除并调用 `onFreed()`

### 内存注意事项

- `RefCounted` 对象由 Godot 引用计数管理
- 节点由场景树管理生命周期
- 持久 Arena（`Bridge.ARENA`）用于注册阶段的 upcall stub 和静态数据，生命周期与 JVM 相同
- 运行时调用路径（`Godot.call()`、`GodotArray` 操作等）使用 scoped arena，通过 Java 25 `ScopedValue` 自动管理，每次调用结束后释放临时 Variant 和缓冲区
- 不要在节点被释放后继续使用（`isValid()` 返回 false）
