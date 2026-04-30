# 快速上手

5 分钟完成 godot-java 安装、配置并运行第一个示例。

## 前置条件

| 工具 | 最低版本     | 说明 |
|------|----------|------|
| JDK | **25+**  | Panama FFI (`java.lang.foreign`) 必需 |
| Godot | **4.6+** | GDExtension 支持 |
| Maven | 4.0.x（项目含 Wrapper） | 构建工具，可用 `./mvnw` 替代 |

> **Java 25 是硬性要求**。godot-java 使用 Panama Foreign Function & Memory API（`java.lang.foreign`），这是 Java 25+ 才稳定可用的特性。

### 安装 JDK

**macOS：**
```bash
brew install openjdk@25 maven
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 25)' >> ~/.zshrc
source ~/.zshrc
```

**Linux（Ubuntu/Debian）：**
```bash
curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh
sdk install java 25.0.2-tem
sudo apt install maven
```

**Windows：**
1. 从 [Adoptium](https://adoptium.net/) 下载 JDK 25
2. `choco install maven`

验证安装：
```bash
java -version    # 应显示 25+
./mvnw --version # 首次使用 Maven Wrapper，自动下载 Maven 4.0+
# 或使用系统 Maven（需预装 4.0+）
mvn -version
```

## 第一步：创建 Maven 项目

```bash
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=my-godot-game \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
cd my-godot-game
```

也可以在 IntelliJ IDEA 中选择 **File -> New -> Project -> Maven Archetype** 创建。

## 第二步：添加依赖

### Maven

编辑 `pom.xml`：

```xml
<properties>
    <maven.compiler.release>25</maven.compiler.release>
</properties>

<dependencies>
    <dependency>
        <groupId>io.github.youngledo</groupId>
        <artifactId>godot-java-core</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("io.github.youngledo:godot-java-core:0.1.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

### Gradle (Groovy DSL)

```groovy
dependencies {
    implementation 'io.github.youngledo:godot-java-core:0.1.0'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

## 第三步：编写 Java 类

创建 `src/main/java/com/example/HealthComponent.java`：

```java
package com.example;

import org.godot.Godot;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.node.Node;

@GodotClass(name = "HealthComponent", parent = "Node")
public class HealthComponent extends Node {

    @Export
    private int maxHealth = 100;

    private int currentHealth;

    @Signal(name = "health_changed")
    private void onHealthChanged(int newHealth) {
        // 方法体不使用，仅声明信号签名
    }

    @Signal(name = "died")
    private void onDied() {}

    @Override
    public void _ready() {
        currentHealth = maxHealth;
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
    public void heal(int amount) {
        currentHealth = Math.min(currentHealth + amount, maxHealth);
        emit("health_changed", currentHealth);
    }

    @GodotMethod
    public int getHealth() {
        return currentHealth;
    }
}
```

要点：
- `@GodotClass` 将类注册到 Godot ClassDB，`name` 为 Godot 中显示的类名
- `@Export` 将字段暴露到 Godot 编辑器的属性检查器
- `@Signal` 声明信号，方法签名定义参数类型
- `@GodotMethod` 将方法暴露给 GDScript 调用
- 虚方法（`_ready`、`_process` 等）通过 `@Override` 实现

## 第四步：编译

```bash
mvn compile -Dcheckstyle.skip=true
```

编译产物在 `target/classes/` 目录下。

## 第五步：配置 Godot 项目

### 5.1 下载原生库

从 [GitHub Releases](https://github.com/youngledo/godot-java/releases) 下载对应平台的原生库：

| 平台 | 文件 |
|------|------|
| macOS (ARM64/x86_64) | `libgodot-java.dylib` |
| Linux (x86_64) | `libgodot-java.so` |
| Windows (x86_64) | `godot-java.dll` |

或从源码构建（参见 [构建文档](../dev/building.md)）。

### 5.2 创建 .gdextension 文件

在 Godot 项目根目录创建 `godot-java.gdextension`：

```ini
[configuration]
entry_symbol = "godot_java_init"
compatibility_minimum = 4.6

[libraries]
macos.debug = "res://native/libgodot-java.dylib"
macos.release = "res://native/libgodot-java.dylib"
linux.debug = "res://native/libgodot-java.so"
linux.release = "res://native/libgodot-java.so"
windows.debug = "res://native/godot-java.dll"
windows.release = "res://native/godot-java.dll"
```

### 5.3 部署目录结构

```
your-godot-project/
├── godot-java.gdextension
├── native/
│   └── libgodot-java.dylib   # 或 .so / .dll
├── scenes/
└── scripts/
```

C++ 层启动 JVM 时需要找到 Java 类文件。通过以下方式之一指定 classpath：

1. 设置环境变量 `GODOT_JAVA_CLASSPATH` 指向你的 `target/classes` 目录
2. 将编译好的 `.class` 文件放入 `native/classes/` 目录

### 5.4 在 Godot 编辑器中启用

1. 打开 Godot，进入 **项目 -> 项目设置 -> GDExtensions**
2. 点击 **添加** 并选择 `godot-java.gdextension` 文件
3. 重启 Godot 编辑器

## 第六步：在 GDScript 中使用

```gdscript
extends Node2D

func _ready():
    var health = HealthComponent.new()
    add_child(health)

    health.connect("health_changed", self, "_on_health_changed")
    health.connect("died", self, "_on_died")

    health.takeDamage(30)
    print("当前生命值: ", health.get_health())

func _on_health_changed(new_health):
    print("生命值变为: ", new_health)

func _on_died():
    print("角色死亡！")
```

按 **F5** 运行，控制台应输出：

```
生命值变为: 70
当前生命值: 70
```

## 常见问题

### "JVM not found"

确认 `JAVA_HOME` 指向 JDK 25+：

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 25)  # macOS
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64  # Linux
```

### "Class not found"

- 确认 `GODOT_JAVA_CLASSPATH` 环境变量指向正确的 `target/classes` 目录
- 执行 `mvn compile -Dcheckstyle.skip=true` 确保类已编译
- 确认类上标注了 `@GodotClass` 注解

### 原生库加载失败

- 检查 `.gdextension` 文件中的路径是否正确
- 确认原生库文件存在于 `native/` 目录中
- 确认库文件架构与 Godot 匹配（x64/ARM64）

## 下一步

- [API 参考](api.md) -- 完整的注解和 API 文档
- [使用指南](guide.md) -- 核心概念和进阶用法
- [常见问题](troubleshooting.md) -- 错误排查
