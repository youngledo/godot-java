# 贡献指南

## 环境要求

- **Java 25** — 使用 Preview/Finalized 特性：Scoped Values、Structured Concurrency、Panama FFI（Foreign Function & Memory API）
- **Maven 4.x** — 构建系统

## 技术原则

优先使用 Java 25 高性能特性，避免遗留 API：

| 场景 | 使用 | 避免 |
|---|---|---|
| 线程局部状态 | `ScopedValue` | `ThreadLocal` |
| 原生函数调用 | Panama FFI（`Linker`、`Arena`、`FunctionDescriptor`） | JNI、JNA |
| 内存管理 | `Arena.ofShared()` / scoped arena | `sun.misc.Unsafe`、`ByteBuffer.allocateDirect` |
| 类型安全的方法引用 | `MethodHandle.invokeExact()` | `Method.invoke()` |
| 不可变数据 | `record` | 手写 POJO |
| 模式匹配 | `switch` 模式匹配、`instanceof` 模式 | 级联 `if-else` + 强制转换 |
| 字符串模板 | 字符串模板（如可用） | 字符串拼接 |

## 架构约束

### 零运行时反射

`godot-java-core/src/main/java/` 中禁止运行时反射。类型和注解的发现必须在编译时通过 APT processor 完成。

**禁止的模式：**

| 模式 | 替代方案 |
|---|---|
| `Class.forName(动态字符串)` | APT 生成的静态 Map 查找 |
| `setAccessible(true)` | protected 访问器或 APT 生成的 lambda |
| `Method.invoke()` | `MethodHandle.invokeExact()`，由 APT 生成分发代码 |
| `Field.get/set` 私有字段 | protected 访问器或 APT 生成的 VarHandle |
| 运行时 `getDeclaredMethods/Fields()` | APT 编译时扫描，结果写入生成的代码 |
| 运行时 `getAnnotation()` | APT 编译时读取，结果写入生成的代码 |
| `privateLookupIn()` + `findConstructor()` | `GodotClassRegistry.create()` |

**例外：** APT processor（`org.godot.processor.*`）和 code generator 可以使用反射——它们仅在编译期运行。

**原因：** GraalVM native image 兼容性 + 性能（`Method.invoke` 比 `MethodHandle.invokeExact` 慢 10-100 倍）。

## 构建命令

```bash
# 框架构建（跳过测试和 spotbugs）
mvn install -DskipTests -Dspotbugs.skip=true

# Demo 项目构建
cd godot-java-3d-demo && mvn package -DskipTests

# 运行 demo
/Applications/Godot.app/Contents/MacOS/Godot --debug --path godot-java-3d-demo
```

## 代码风格

- 代码注释只用英文
- 不使用 `Co-Authored-By` 提交标记
- 所有 Java→Godot 调用通过 Panama FFI Bridge，不使用 JNI helper
- 不要推送代码到远程仓库，除非明确要求
