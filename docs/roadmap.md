# godot-java 补齐路线图

> 推进规则:**按序逐项推进,完成一项即在本文档标记 `[x]`**,提交信息引用条目编号。
> 完整对比记录见 [gdext_parity.md](gdext_parity.md)(基线:gdext master,2026-11-06)。

## 已完成的三轮(摘要)

| 轮次 | 内容 |
|---|---|
| 2026-10-21 | P0 生命周期 upcall 防护、Callable 有效性、单例缓存失效、关闭语义(延迟任务/协程取消)、Variant destroy 省略 |
| 2026-11-05 | 命名转换(toVector2i 等 + 字符串互转)、调用中销毁诊断 |
| 2026-11-05 | bitfield 强类型化(final class + with/without/has + Int64 ABI 修正 + 属性类型错位修复) |

## 待办(按优先级排序)

### 1. [ ] enum/bitfield 类型的用户方法参数(APT)
- **现状**:`@GodotMethod` 参数只支持基元/String/Object。枚举与 bitfield 类参数在
  ptrcall/variant 分发里无法转换(枚举同样受限——先行限制,P1-7 收尾时记录)。
- **目标**:`GodotClassProcessor.generateArgRead` 支持 int→`Enum.fromValue`/int64→
  `Flags.of`;`unboxExpr` 支持 Variant→枚举/标志类;`MethodDispatch.writeTypedPtr`
  支持其返回值(写 `.value`)。it-test 增加端到端场景。
- **工作量**:中偏大(动 APT 处理器与写回路径)。
- **来源**:P1-7 遗留限制;补全 P1-7 的用户侧闭环。

### 2. [ ] NODE_PATH "special none"(需先复现)
- **现状**(gdext e8cb880d):编辑器清空导出字段可能发送空 NodePath;
  `VariantUtils.toObject` 无 NODE_PATH 分支,兜底 `asString()` 变成 `""`。
- **步骤**:先在 Godot 4.7 编辑器复现(headless 难复现,可能需要 `--editor` 脚本
  或手工验证),确认后补 NODE_PATH 分支与对象字段清空语义。
- **工作量**:修复小,复现成本高。

### 3. [ ] 启动消息缓冲 + fatal 级别
- **现状**(gdext 15034934/0d70b3ab):注册期错误直接打 log4j,无缓冲、无按类去重、
  无致命终止语义;失败后注册继续。
- **目标**:StartupMessages 聚合器(缓冲到编辑器 UI 就绪、once-per-class 去重键、
  fatal 级别在 init 完成点终止进程)。
- **工作量**:中。

### 4. [ ] 线程安全 FFI 白名单
- **现状**(gdext b1439376):所有 Bridge 辅助方法断言主线程,仅全局开关可关。
- **目标**:为引擎标明线程安全的 `VARIANT_*`/`STRING_*` 操作提供免断言的调用变体
  (对齐 gdext 的 thread_safe 访问表)。
- **工作量**:中。**前置**:出现跨线程 Variant/String 使用需求再排期。

### 5. [ ] 引擎内端到端基准
- **现状**(gdext 0aa01c6e/9c4e9b43):JMH 套件是纯 Java 微模拟,缺活引擎内
  upcall→dispatch→typed return 全链路测量。
- **目标**:godot-java-benchmarks 增加 in-engine 模式(如 Java Node 自计时循环)。
- **工作量**:中(测试基建)。

### 6. [ ] async GDScript 虚方法
- **现状**(gdext aa69ba1c):`@GodotMethod(virtual)` 仅同步;无协程暴露给 GDScript。
- **工作量**:大(涉及 APT、代码生成与运行时协同设计)。**放最后,按需排期**。

## 条件项(不排期,触发时处理)

- [ ] Godot 4.8 升级观察项:`var(no_get)` 语义变化、Quaternion 预期结果、
  `process_rawptr` 签名(gdext 23d27dc0/b18b64f4/a710fc1b)。升级 API JSON 时核对。

## 顺手项(可选,低优先)

- [ ] 文档陈旧数字:README 的 "1016 包装类/1144 虚方法" 与当前生成物(~2072)不符。
- [ ] SpotBugs 存量:`Bridge.LIBRARY_PTR` 64 位写非原子、`GodotPackedArray` 构造器
  抛异常(threshold=LOW 不拦截;可修或加豁免)。
- [ ] examples 本地构建:缺 `godot-java-native` zip 工件时本地 `package` 报错
  (CI 在 reactor 内正常);可加本地回退(--native-lib)说明或修复解析顺序。
