# Contributing

How to contribute to the godot-java project.

## Development Environment

### Required Tools

| Tool | Version | Purpose |
|---|---|---|
| JDK | 25+ | Panama FFI |
| Maven | 4.0.x | Build system |
| C++ Compiler | C++17 | Native library |
| Git | 2.x | Version control |

### Recommended Tools

- **IDE**: IntelliJ IDEA (best Java 25 + Panama support)
- **Godot**: 4.6+ (for integration testing)

### Setup

```bash
git clone --recursive https://github.com/youngledo/godot-java.git
cd godot-java

# Compile Java code
cd godot-java-core
mvn compile -Dcheckstyle.skip=true

# Compile native library (macOS example)
cd native
bash build-macos.sh
```

## Code Style

### Java

- **Style**: Sun Checks (enforced by Maven checkstyle plugin)
- **Config**: `sun_checks.xml` (set in parent POM)
- **Indentation**: 4 spaces (no tabs)
- **Comments**: English only
- **Naming**:
  - Methods: `camelCase` (e.g., `takeDamage`, `getPosition`)
  - Classes: `PascalCase` (e.g., `Bridge`, `Node2D`)
  - Constants: `UPPER_SNAKE_CASE` (e.g., `METHOD_HASHES`)
  - Packages: all lowercase (e.g., `org.godot.bridge`)

Run checkstyle locally:
```bash
mvn checkstyle:check
```

Skip checkstyle during development:
```bash
mvn compile -Dcheckstyle.skip=true
```

### C++

- **Indentation**: 4 spaces
- **Naming**: `snake_case` (e.g., `godot_java_init`)
- **Log prefix**: `godot-java:`

## Commit Messages

Follow [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>: <description>
```

### Types

| Type | Description | Example |
|---|---|---|
| `feat:` | New feature | `feat: add Node3D wrapper class` |
| `fix:` | Bug fix | `fix: correct Variant type conversion for floats` |
| `docs:` | Documentation | `docs: add architecture overview` |
| `refactor:` | Code restructuring | `refactor: extract method bind caching logic` |
| `test:` | Tests | `test: add Variant unit tests` |
| `chore:` | Build/tooling | `chore: update Maven dependencies` |
| `perf:` | Performance | `perf: cache MethodHandle lookups` |

### Guidelines

- Use English for descriptions.
- Use present tense ("add" not "added").
- Lowercase first letter, no trailing period.

## Pull Request Process

1. **Fork** the repository on GitHub.

2. **Create a branch**:
   ```bash
   git checkout -b feat/add-sprite3d-wrapper
   ```

3. **Develop and commit**:
   ```bash
   # Write code...
   git add src/main/java/org/godot/node/Sprite3D.java
   git commit -m "feat: add Sprite3D wrapper class"
   ```

4. **Verify CI passes locally**:
   ```bash
   mvn compile
   mvn test
   mvn checkstyle:check
   ```

5. **Push and create a PR**:
   ```bash
   git push origin feat/add-sprite3d-wrapper
   ```
   Create a Pull Request on GitHub describing the change and motivation.

6. **Code review**: A maintainer will review and may request changes.

### PR Description Template

```markdown
## Summary
Brief description of the change.

## Motivation
Why this change is needed.

## Testing
- [ ] New/updated unit tests
- [ ] Manual testing passed
```

## Testing

### Unit Tests

- Use JUnit 5.
- Tests go in `godot-java-core/src/test/java/`.
- Integration tests that require a running Godot instance should use `Assumptions.assumeTrue(isGodotInitialized())` to skip gracefully in non-Godot environments.

### Running Tests

```bash
# All tests
mvn test

# Single test class
mvn test -Dtest=VariantTest

# Skip tests
mvn clean install -DskipTests
```

### Writing Tests

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VariantTest {
    @Test
    void shouldCreateIntVariant() {
        Variant v = Variant.fromInt(42L);
        assertEquals(42L, v.asLong());
    }
}
```

## Adding API Bindings

To add a new Godot type wrapper:

1. Create a class in the appropriate package (e.g., `org.godot.node` for node types, `org.godot.math` for math types).

2. Include a `METHOD_HASHES` static map with method hashes from `method_hashes.txt`:
   ```java
   private static final Map<String, Long> METHOD_HASHES = Map.of(
       "set_position", 743155724L,
       "get_position", 3341600327L
   );
   ```

3. Include a `GODOT_CLASS_NAME` constant:
   ```java
   private static final String GODOT_CLASS_NAME = "Node2D";
   ```

4. Override `getGodotClassName()` to return the Godot class name.

5. Write tests.

## Code Generation

The `godot-java-code-generator` module reads `extension_api.json` and generates wrapper classes. It is currently active and runs during the `generate-sources` phase.

Generated sources go to `godot-java-core/target/src-gen/main/java/` and are added to the compile path automatically.

To skip code generation, set `<skip>true</skip>` in the `exec-maven-plugin` configuration within `godot-java-core/pom.xml`.
