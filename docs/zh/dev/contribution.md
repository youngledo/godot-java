# 贡献指南

感谢你对 godot-java 项目的关注。本文档介绍如何参与开发。

## 开发环境

### 必要工具

| 工具 | 版本要求 | 说明 |
|------|----------|------|
| JDK | **25+** | Panama FFI 硬性要求 |
| Maven | 4.0+ | 构建工具 |
| C++ 编译器 | C++17 | macOS: clang++，Linux: g++，Windows: MSVC |
| Git | 2.x | 版本控制 |

### 推荐工具

- **IDE**：IntelliJ IDEA
- **Godot**：4.6+（用于集成测试）

### 环境搭建

```bash
# 克隆仓库（包含子模块）
git clone --recursive https://github.com/youngledo/godot-java.git
cd godot-java

# 编译 Java 代码
cd godot-java-core
mvn compile -Dcheckstyle.skip=true

# 编译原生库（macOS 示例）
cd native
bash build-macos.sh
```

## 代码规范

### Java 代码风格

- **Checkstyle 配置**：`sun_checks.xml`
- **缩进**：4 个空格（不使用 Tab）
- **行宽**：80 字符（sun_checks 默认）
- **命名约定**：
  - 方法名：camelCase（如 `takeDamage`、`getPosition`）
  - 类名：PascalCase（如 `GodotBridge`、`Node2D`）
  - 常量：UPPER_SNAKE_CASE（如 `MAX_HEALTH`）
  - 包名：全小写（如 `org.godot.bridge`）
- **注释语言**：英文（代码注释必须使用英文）

### C++ 代码风格

- **缩进**：4 个空格
- **命名**：snake_case（如 `godot_java_init`）
- **日志前缀**：`godot-java:`

### Checkstyle

项目使用 `maven-checkstyle-plugin`，在 `validate` 阶段自动检查：

```bash
# 运行 checkstyle 检查
mvn checkstyle:check

# 编译时跳过 checkstyle
mvn compile -Dcheckstyle.skip=true
```

## 提交规范

使用 [Conventional Commits](https://www.conventionalcommits.org/) 格式：

```
<type>: <description>
```

### 类型

| 类型 | 说明 | 示例 |
|------|------|------|
| `feat:` | 新功能 | `feat: add Sprite2D wrapper class` |
| `fix:` | Bug 修复 | `fix: correct Variant type conversion for floats` |
| `docs:` | 文档变更 | `docs: update architecture overview` |
| `refactor:` | 代码重构 | `refactor: extract method bind caching logic` |
| `test:` | 测试相关 | `test: add GodotVariant unit tests` |
| `chore:` | 构建/工具变更 | `chore: update Maven dependencies` |
| `perf:` | 性能优化 | `perf: cache MethodHandle lookups` |

### 注意事项

- 描述使用英文
- 使用现在时态（"add" 而不是 "added"）
- 首字母小写，不加句号

## PR 流程

### 提交 Pull Request 的步骤

1. **Fork 仓库**到你的 GitHub 账号

2. **创建分支**：
   ```bash
   git checkout -b feat/add-sprite3d-wrapper
   ```

3. **开发和提交变更**：
   ```bash
   git add src/main/java/org/godot/node/Sprite3D.java
   git commit -m "feat: add Sprite3D wrapper class"
   ```

4. **确保构建通过**：
   ```bash
   mvn compile
   mvn test
   ```

5. **推送并创建 PR**：
   ```bash
   git push origin feat/add-sprite3d-wrapper
   ```
   在 GitHub 上创建 Pull Request。

6. **Code Review**：等待维护者审查并反馈。

### PR 描述模板

```markdown
## 变更内容
简要描述本 PR 的变更。

## 动机
为什么需要这个变更。

## 测试
- [ ] 新增/更新了单元测试
- [ ] 手动测试通过

## 相关 Issue
Fixes #123
```

## 测试

### 单元测试

使用 JUnit 5。测试位于 `godot-java-core/src/test/java/org/godot/`。

```bash
# 运行所有测试
mvn test

# 运行单个测试类
mvn test -Dtest=VariantTest

# 跳过测试构建
mvn clean install -DskipTests
```

### 测试示例

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VariantTest {

    @Test
    void shouldCreateIntVariant() {
        Variant variant = Variant.fromInt(42L);
        assertEquals(42L, variant.asLong());
    }

    @Test
    void shouldCreateStringVariant() {
        Variant variant = Variant.fromString("hello");
        assertEquals("hello", variant.asString());
    }
}
```

### 集成测试

需要 Godot 运行环境的测试使用 `Assumptions.assumeTrue(isGodotInitialized())` 标记，确保非 Godot 环境下优雅跳过。

## 添加新的 API 绑定

为 Godot 类型添加新的 Java 包装方法：

### 步骤

1. **在对应包装类中添加方法**：

```java
// org.godot.node 包中的类
public class Sprite2D extends Node2D {
    private static final java.util.Map<String, Long> METHOD_HASHES = java.util.Map.of(
        "set_texture", 1234567890L,  // 从 extension_api.json 获取
        "get_texture", 9876543210L
    );

    public void setTexture(GodotObject texture) {
        if (isValid()) {
            call("set_texture", texture);
        }
    }
}
```

2. **获取方法哈希值**：从 `extension_api.json` 或 Godot 的 method bind 系统获取正确的哈希值

3. **编写测试**

4. **手动验证**：在 Godot 项目中测试新方法

## 代码生成器

代码生成器位于 `godot-java-code-generator/` 模块：

- 读取 `godot-api/extension_api.json`
- 解析 Godot 类、方法、属性、信号信息
- 生成 Java 包装类（包含 `METHOD_HASHES`、方法签名等）
- 在 Maven `generate-sources` 阶段自动运行

## 依赖管理

### Maven 依赖

项目主要依赖：

- JDK 25+（Panama FFI 是 JDK 内置功能）
- JUnit 5（测试）
- Log4j2（日志）
- JaCoCo（测试覆盖率）

### 添加新依赖

在模块的 `pom.xml` 中添加，并在 PR 中说明理由。

## 常见问题

### Maven 构建失败

```bash
mvn clean install -U -DskipTests -Dcheckstyle.skip=true
```

### Checkstyle 检查失败

```bash
# 本地运行检查
mvn checkstyle:check

# 使用 IDE 的 "Reformat Code" 功能自动格式化
```

### 子模块未初始化

```bash
git submodule update --init --recursive
```

### SpotBugs 检查失败

```bash
# 运行 SpotBugs 检查
mvn spotbugs:check

# 生成报告
mvn spotbugs:spotbugs
```
