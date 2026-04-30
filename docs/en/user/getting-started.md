# Getting Started

Set up godot-java in 5 minutes.

## Prerequisites

| Tool | Minimum Version | Verification |
|---|-----------------|---|
| JDK | 25+             | `java -version` |
| Godot | 4.6+            | `godot --version` |
| Maven | 4.0.x (Wrapper included) | `mvn -version` or `./mvnw --version` |

Java 25 is required because godot-java uses the Panama Foreign Function & Memory API (`java.lang.foreign`) for all native calls to the Godot C API.

### Install JDK 25

**macOS:**
```bash
brew install openjdk@25 maven
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 25)' >> ~/.zshrc
source ~/.zshrc
```

**Linux (Ubuntu/Debian):**
```bash
curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh
sdk install java 25.0.0-tem
sudo apt install maven
```

**Windows:**
1. Download JDK 25 from [Adoptium](https://adoptium.net/)
2. Install Maven: `choco install maven`

Verify:
```bash
java -version    # must show 25+
./mvnw --version # First-time: auto-downloads Maven 4.0+
# or use system Maven (requires 4.0+ pre-installed)
mvn -version
```

## Step 1: Create a Maven Project

### Option A: IntelliJ IDEA (recommended)

1. **File > New > Project**, select **Maven Archetype**
2. Set Group ID: `com.example`, Artifact ID: `my-godot-game`
3. Select JDK 25+
4. Click **Create**

### Option B: Command Line

```bash
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=my-godot-game \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
cd my-godot-game
```

## Step 2: Add the Dependency

### Maven

Edit `pom.xml` and add godot-java-core inside `<dependencies>`:

```xml
<dependencies>
    <dependency>
        <groupId>io.github.youngledo</groupId>
        <artifactId>godot-java-core</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

Set the Java 25 compiler target:

```xml
<properties>
    <maven.compiler.release>25</maven.compiler.release>
</properties>
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

## Step 3: Write Your First Godot Class

Create `src/main/java/com/example/HealthComponent.java`:

```java
package com.example;

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
    private void onHealthChanged(int newHealth) {}

    @Signal(name = "died")
    private void onDied() {}

    @Override
    public void _ready() {
        currentHealth = maxHealth;
    }

    @GodotMethod
    public void takeDamage(int amount) {
        currentHealth -= amount;
        emitSignal("health_changed", currentHealth);
        if (currentHealth <= 0) {
            emitSignal("died");
        }
    }

    @GodotMethod
    public int getHealth() {
        return currentHealth;
    }
}
```

Key points:

- `@GodotClass` registers the class with Godot's ClassDB (auto-discovered at startup).
- `@Export` exposes a field to the Godot editor Inspector panel.
- `@Signal` declares a signal; the method body is unused, only the signature matters.
- `@GodotMethod` makes a method callable from GDScript.
- Virtual methods like `_ready()` are overridden normally with `@Override`.

## Step 4: Compile

```bash
mvn compile
```

On success, class files appear in `target/classes/`.

## Step 5: Deploy to Your Godot Project

### 5.1 Download the Native Library

Download the platform-native shared library from [GitHub Releases](https://github.com/youngledo/godot-java/releases):

| Platform | File |
|---|---|
| macOS (ARM64 / x86_64) | `libgodot-java.dylib` |
| Linux (x86_64) | `libgodot-java.so` |
| Windows (x86_64) | `godot-java.dll` |

Place it in your Godot project under `native/`.

### 5.2 Create the .gdextension File

Create `godot-java.gdextension` in your Godot project root:

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

### 5.3 Final Directory Layout

```
your-godot-project/
  godot-java.gdextension
  native/
    libgodot-java.dylib    # or .so / .dll
  scenes/
  scripts/
```

### 5.4 Enable in Godot

1. Open your Godot project.
2. Go to **Project > Project Settings > GDExtensions**.
3. Click **Add** and select the `godot-java.gdextension` file.
4. Restart the Godot editor.

## Step 6: Use from GDScript

Create a GDScript (e.g., `main.gd`) and attach it to a scene node:

```gdscript
extends Node2D

func _ready():
    var health = HealthComponent.new()
    add_child(health)
    health.connect("health_changed", self, "_on_health_changed")
    health.connect("died", self, "_on_died")
    health.take_damage(30)
    print("Current health: ", health.get_health())

func _on_health_changed(new_health):
    print("Health changed to: ", new_health)

func _on_died():
    print("Entity died!")
```

Press **F5** to run. The console should output:

```
Health changed to: 70
Current health: 70
```

## Common Issues

### "JVM not found"

Set `JAVA_HOME` to your JDK 25 installation:
```bash
export JAVA_HOME=/path/to/jdk-25
```

### "Class not found"

- Run `mvn compile` to compile your classes.
- Verify the class is annotated with `@GodotClass`.
- Check that the classpath configured in the C++ layer points to `target/classes/`.

### Native library load failure

- Verify the `.gdextension` file paths match the actual file locations.
- Confirm the library architecture matches your Godot editor (x64 vs ARM64).

## Next Steps

- [API Reference](api.md) -- Full annotation and type documentation
- [Development Guide](guide.md) -- In-depth walkthroughs
- [Troubleshooting](troubleshooting.md) -- Detailed error resolution
