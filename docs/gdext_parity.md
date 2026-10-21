---
name: gdext-parity
description: Feature-by-feature parity status between godot-java and gdext (godot-rust). Updated 2026-10-21.
metadata:
  node_type: memory
  type: project
  originSessionId: f8c41623-1139-44ac-86c4-414086c0b55b
---

# godot-java vs gdext Parity Matrix

Last compared: 2026-10-21 against gdext master `0b680b4d` (2026-10-04) + remote tip
`395476db` (Linux hot-reload libstdc++ fix, Rust-specific). Delta analyzed: 139
non-merge commits since 2026-05-20.

## Previously Aligned (unchanged since 2026-05-20)

Class registration, tool/editor-plugin/singleton/internal/noInit attributes,
@Export + hints + groups, dynamic properties, property validation, signals +
TypedSignal0-5 + await, two-phase virtual dispatch, NativeCallable/lambda
callables, collections + type metadata, all 10 PackedArray types, MainLoop
callbacks, per-level registration, docs generation, codegen pipeline, RPC
registration, constants, OnReady, hot reload, @ExportToolButton,
@RequiredInEditor.

## Newly Aligned (since 2026-05-20)

- **Type-safe RPC API** (gdext eec4afd3/9b4b87bd/45acc234): godot-java already
  generates typed `methodNameRpc(...)`/`methodNameRpcId(peer, ...)` proxies in
  the `<Class>Signals` facade; RPC config registers in the factory lambda, so
  the no-`_ready` bug cannot occur. Nit: proxies discard the error code (no
  typed RpcError).
- **Godot 4.7 API level** (gdext 4ff9608b): godot-java already generates from
  the 4.7.1 API; 4.7.2 verified byte-identical (2026-10-20).
- **Array::resize_default** semantics: engine-side resize already default-fills.
- **unbind() reentrant scope** (gdext 9619c275): solves a Rust borrow problem
  that does not exist in Java; Bridge IN_DOWNCALL/IN_UPCALL + per-depth call
  frames cover the same ground.

## New Gaps — Correctness (shared bugs, verified 2026-10-21)

1. **NODE_PATH "special none" unhandled** (gdext e8cb880d): `VariantUtils.toObject`
   has no NODE_PATH case and falls through to `asString()` (VariantUtils.java:431);
   an editor clear on an exported field can surface as `""`/ClassCastException
   on a now-guarded setter path (logged, no longer escapes the upcall). Needs a
   4.7 repro before fixing (4.2 behavior documented by gdext).

## Fixed on 2026-10-21 (gap-closure pass)

- **Unguarded lifecycle upcalls** (was gap 1, gdext 1857465d): every
  InstanceCallbacks adapter and the VirtualDispatch hot path now catches
  Throwable; toString failures mark the result invalid; Engine.singleton()
  access in virtual dispatch is guarded. Exceptions can no longer escape into
  native code.
- **Callable.isValid() / callable validity** (was gap 2, gdext 25122226):
  Callable tracks its source NativeCallable; NativeCallable.isValid() follows
  the bound object's liveness via CallableDispatch; is_valid_func and free_func
  are now wired into CallableCustomInfo2 (engine-side validity is truthful, and
  dispatch entries are unregistered when the engine frees a custom callable —
  also closes an entry leak). CallableDispatch key generation is now atomic.
- **Singleton cache invalidation + user singleton cache** (was gap 3, gdext
  03d22780/97f8d0df): generated singletons expose invalidateCache(); the
  generated SingletonCaches aggregate clears all 41 engine singleton pointers
  at CORE deinit; Registry caches user singleton instances (populated at
  registration, cleared at unregister/deinit) with a zero-FFI
  Registry.getUserSingleton(...) accessor.
- **Shutdown-aware deferred + async cancellation** (was gap 5, gdext
  73fed1f2/a72dd959): DeferredExecutor gained a shutdown state (queued tasks
  dropped, new tasks rejected); GodotScope.shutdown() cancels every parked
  coroutine (delay() and SignalHandle.await()) with a CancellationException so
  awaited signals never park a virtual thread forever. Wired into
  Bootstrap.cleanupAtLevel(0).
- **Variant destroy elision** (was gap 11, gdext e3b1e689): destroyVariant
  skips the variant_destroy FFI for Godot's in-place, destructor-less types
  (its needs_deinit table) and resets the type tag to NIL, saving one downcall
  per primitive arg/result on hot paths.

## New Gaps — Lifecycle / Features (remaining)

2. **Destroyed-during-call reporting** (gdext 574c9298/305c69f0): no claim
   counting or diagnostics when the receiver is freed mid-call (Java wrappers
   stay on-stack so lower severity than gdext; a log diagnostic would do).
3. **async GDScript virtual functions** (gdext aa69ba1c): `@GodotMethod(virtual)`
   is sync-only; no coroutine exposure to GDScript.
4. **Bitfield combinators + strong typing** (gdext ee828c28): generated
   bitfields are plain enums with raw `.value`; TypeMapper erases
   `bitfield::X -> int`. No `with()/without()`; no compile-time flag types.
5. **Named string/vector conversions** (gdext 9a56d34e/0de78392): no
   toVector2i/toRect2-style helpers; NodePath maps to plain String.
6. **Startup message buffering + fatal level** (gdext 15034934/0d70b3ab):
    registration errors log straight to log4j; no dedup keys, no fatal-abort.

## New Gaps — Performance (remaining)

7. **Thread-safe FFI allowlist** (gdext b1439376): every Bridge helper asserts
   main-thread; no allowlisted unchecked variants for VARIANT_*/STRING_* ops.
8. **In-engine end-to-end benchmarks** (gdext 0aa01c6e/9c4e9b43): JMH suites are
   pure-Java micro-simulations; no live-engine dispatch-path measurement.

## Not Affected (audited gdext bugfixes with no godot-java analog)

Aabb Z-axis bound, Dictionary find_key_by_value (API absent), Callable::object
FFI path, PackedByteArray overflow, tool-button quotes, call-error OOB index,
OnEditor reload panic, RPC call_local borrow panic, connect_self refcount leak,
codegen pointer mapping, shutdown deferred/future panics (behavior differs:
hang-not-panic for awaitSignal). Watch-items for a future 4.8 upgrade:
`var(no_get)` semantics, Quaternion expected results, `process_rawptr`
signature (gdext 23d27dc0).

## Java-Only Advantages (unchanged)

Virtual-thread coroutines (GodotScope), JMH benchmark module, Maven feature
profiles, TypedSignal0-5 emit+await, @RequiredInEditor.
