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

### 1. [x] enum/bitfield 类型的用户方法参数(APT)
- **现状**:`@GodotMethod` 参数只支持基元/String/Object。枚举与 bitfield 类参数在
  ptrcall/variant 分发里无法转换(枚举同样受限——先行限制,P1-7 收尾时记录)。
- **目标**:`GodotClassProcessor.generateArgRead` 支持 int→`Enum.fromValue`/int64→
  `Flags.of`;`unboxExpr` 支持 Variant→枚举/标志类;`MethodDispatch.writeTypedPtr`
  支持其返回值(写 `.value`)。it-test 增加端到端场景。
- **工作量**:中偏大(动 APT 处理器与写回路径)。
- **来源**:P1-7 遗留限制;补全 P1-7 的用户侧闭环。
- **完成**(2026-11-06):新增 `GodotEnum`/`GodotBitfield` 标记接口(`godotValue()`),
  生成器让全部枚举/标志类实现之;APT 按 `Types.isAssignable` 识别 kind,
  ptrcall 读参(int32→`fromValue`、int64→`of`)、variant 解包、MethodMeta 注册类型
  (枚举→int、标志→long)全部接入;运行时 `writeTypedPtr`/`VariantUtils.fromObject`
  按 `instanceof` 写值。it-test 四个端到端场景(GDScript 双向传枚举/标志)全过。

### 2. [x] NODE_PATH "special none"(需先复现)
- **现状**(gdext e8cb880d):编辑器清空导出字段可能发送空 NodePath;
  `VariantUtils.toObject` 无 NODE_PATH 分支,兜底 `asString()` 变成 `""`。
- **步骤**:先在 Godot 4.7 编辑器复现(headless 难复现,可能需要 `--editor` 脚本
  或手工验证),确认后补 NODE_PATH 分支与对象字段清空语义。
- **工作量**:修复小,复现成本高。
- **完成**(2026-11-06):复现方式确定——GDScript `set("exportedNode", NodePath(""))`
  走与编辑器清除按钮相同的 set_property 链路,无需 UI。修复:`toObject` 新增
  NODE_PATH 分支,空路径→null(gdext "special none" 语义),非空→路径字符串
  (顺带修掉非空路径被 `asString()` 静默吞成 `""` 的问题)。it-test 两个场景
  (空清除 + 非空拒收不崩)在真机通过。

### 3. [x] 启动消息缓冲 + fatal 级别
- **现状**(gdext 15034934/0d70b3ab):注册期错误直接打 log4j,无缓冲、无按类去重、
  无致命终止语义;失败后注册继续。
- **目标**:StartupMessages 聚合器(缓冲到编辑器 UI 就绪、once-per-class 去重键、
  fatal 级别在 init 完成点终止进程)。
- **工作量**:中。
- **完成**(2026-11-12):`StartupMessages`(单锁结构、按 key 去重、ERROR/FATAL、
  flush 在每级注册末尾输出、fatal 跨级闩锁);Registry 每类 try/catch 隔离
  (单个类失败不再中断整批注册,fatal 上报;无名类改为显式 error 而非静默跳过);
  单例失败改走缓冲上报。Bootstrap 分级末尾 flush,fatal 时:编辑器内保持存活
  (可读消息),运行期经 DeferredExecutor 延迟到首帧 `SceneTree.quit(111)`
  (OS.quit 不在扩展 API 中,经 Engine.getMainLoop→SceneTree 路径退出)。
  单测 4 个(去重/flush/闩锁/reset),586 全绿;真机 56 PASS 无回归。

### 4. [ ] 线程安全 FFI 白名单(推迟,等待触发场景)
- **现状**(gdext b1439376):所有 Bridge 辅助方法断言主线程,仅全局开关可关。
- **目标**:为引擎标明线程安全的 `VARIANT_*`/`STRING_*` 操作提供免断言的调用变体
 (对齐 gdext 的 thread_safe 访问表)。
- **工作量**:中。**前置**(2026-11-12 重申):无跨线程 Variant/String 使用需求,
 speculative 实现无法验证收益——移至 #6 之后,出现真实需求即提级。

### 5. [x] 引擎内端到端基准
- **现状**(gdext 0aa01c6e/9c4e9b43):JMH 套件是纯 Java 微模拟,缺活引擎内
 upcall→dispatch→typed return 全链路测量。
- **目标**:godot-java-benchmarks 增加 in-engine 模式(如 Java Node 自计时循环)。
- **工作量**:中(测试基建)。
- **完成**(2026-11-12):落地为 it-test 基准场景(`BENCH:` 结构化输出),每次
 CI 六条腿自动产出数据,优于独立模块需手动运行。两条热路径:varcall 上行
 (GDScript→@GodotMethod,含正确性求和断言)与 typed 下行(Java→引擎 ptrcall,
 预热+自计时)。基准立即产出发现:**下行 13.3µs/次 vs 上行 1.8µs/次**——
 根因是 `callMethodBindPtr` 每次调用 `Bridge.runScoped` 新建 Arena + typedArgFrame
 分配,已立 #7 优化项。本机 Godot 4.6.2 验证 58 PASS。

### 6. [ ] async GDScript 虚方法
- **现状**(gdext aa69ba1c):`@GodotMethod(virtual)` 仅同步;无协程暴露给 GDScript。
- **工作量**:大(涉及 APT、代码生成与运行时协同设计)。**放最后,按需排期**。

### 7. [ ] downcall 热路径优化(#5 基准发现,新增 2026-11-12)
- **现状**:`callMethodBindPtr` 每次调用经 `Bridge.runScoped` 新建
 `Arena.ofShared()`(分配+关闭≈µs 级)并新建 TypedArgFrame;实测 13.3µs/次,
 比上行 varcall(1.8µs)慢 7 倍,是所有引擎 getter/setter 调用的公共路径。
- **方向**:Arena 池化/复用(参照 Bridge.CALL_FRAMES 对 Variant 调用帧的预分配
 做法)、或轻量级栈式作用域;以 #5 基准为验收(目标:下行进入百纳秒量级)。
- **工作量**:中。**验收**:#5 基准数据对比。

## 条件项(不排期,触发时处理)

- [ ] Godot 4.8 升级观察项:`var(no_get)` 语义变化、Quaternion 预期结果、
  `process_rawptr` 签名(gdext 23d27dc0/b18b64f4/a710fc1b)。升级 API JSON 时核对。

## 顺手项(可选,低优先)

- [ ] 文档陈旧数字:README 的 "1016 包装类/1144 虚方法" 与当前生成物(~2072)不符。
- [ ] SpotBugs 存量:`Bridge.LIBRARY_PTR` 64 位写非原子、`GodotPackedArray` 构造器
  抛异常(threshold=LOW 不拦截;可修或加豁免)。
- [ ] examples 本地构建:缺 `godot-java-native` zip 工件时本地 `package` 报错
  (CI 在 reactor 内正常);可加本地回退(--native-lib)说明或修复解析顺序。
