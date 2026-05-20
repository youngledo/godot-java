---
name: gdext-parity
description: Feature-by-feature parity status between godot-java and gdext (godot-rust). Updated 2026-05-20.
metadata:
  node_type: memory
  type: project
  originSessionId: f8c41623-1139-44ac-86c4-414086c0b55b
---

# godot-java vs gdext Parity Matrix

Last compared: 2026-05-20 against gdext (godot-rust/gdext) latest.

## Fully Aligned (23/25 areas)

| Area | gdext | godot-java | Commit |
|------|-------|------------|--------|
| Class registration | `#[derive(GodotClass)]` | `@GodotClass` + APT | initial |
| Tool classes | `#[class(tool)]` | `@Tool` | initial |
| Editor plugins | `base = EditorPlugin` | `@EditorPlugin` | a725e60 |
| Singleton/internal/noInit | class attributes | annotation attributes | initial |
| Property export | `#[export]` + hints | `@Export` + `PropertyHint` | initial |
| Property groups | `#[export_group/subgroup]` | `@ExportGroup/Subgroup` | initial |
| Dynamic properties | `get/set/get_property_list` | `@GetProperty/SetProperty/GetPropertyList` | initial |
| Property validation | `validate_property` | `@ValidateProperty` | initial |
| Signals | `#[signal]` + TypedSignal | `@Signal` + TypedSignal0-5 | initial |
| Typed signal await | `to_future::<(T,)>().await` | `TypedSignal1.await()` returns A | e7f38e2 |
| Virtual dispatch | ITrait + two-phase | VirtualStubs + two-phase | e06e92b |
| Callable | `Callable::from_fn` | NativeCallable + CallableDispatch | e06e92b |
| Lambda callable | `from_fn(closure)` | `registerLambdaCallable(Runnable)` | 1e2a28b |
| Collections | `Array<T>` + `Dictionary<K,V>` | `GodotArray<T>` + `GodotDictionary<K,V>` | 933fade |
| Collection type metadata | Element trait | CollectionTypeMeta | 933fade |
| PackedArray support | All 10 types | All 10 types including PackedVector4Array | 05f9404 |
| Resource loading | `load::<T>()` | `Resources.load()` | 7209db0 |
| InitLevel per-level registration | `on_stage_init(level)` | `registerClassesAtLevel(level)` | 2458ba0 |
| Docs generation | register-docs feature | DocConverter + markdown-to-bbcode | initial |
| Code generation | godot-codegen crate | godot-java-code-generator | 5d2fef4 |
| Godot version metadata | GdextRuntimeMetadata | GodotApiVersion | 5d2fef4 |
| RPC | `#[rpc]` | `@Rpc` | initial |
| Constants | `#[constant]` | `@Constant` | initial |
| OnReady | `OnReady<T>` | `@OnReady` + OnReadyMode | initial |
| Hot reload | Debug build default | HotReloadWatcher + Dispatch.reload() | initial |
| Async signal await | SignalFuture + to_future() | GodotScope.awaitSignal() | 1e2a28b |
| Editor tool buttons | `#[export_tool_button]` | `@ExportToolButton` | 55f968c |
| Required editor fields | manual _get_configuration_warnings | `@RequiredInEditor` | 0134191 |

## No Remaining Gaps

All previously identified gaps have been closed:
- Typed async signal return: `TypedSignal1<A>.await()` returns typed A; 2+ args return `Object[]`
- PackedVector4Array: Full support in TypeMapper, TypedAbiModel, engine calls, typed arg wrappers
- InitLevel per-level: C++ minimum level set to CORE, classes grouped and registered per level

## Java-Only Advantages (not in gdext)
- Virtual Thread coroutines (`GodotScope`) — lighter than gdext's `spawn()`
- JMH benchmark module for performance regression detection
- Maven profile system for compile-time feature switching
- TypedSignal0-5 with await() and emit() — gdext only has emit on its signal types
