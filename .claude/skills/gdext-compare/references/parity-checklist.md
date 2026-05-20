# gdext Feature Parity Checklist

Use this checklist when comparing godot-java against gdext. For each area, check both sides and mark status.

## Status Codes
- **ALIGNED**: Fully implemented on both sides
- **PARTIAL**: Implemented but missing sub-features
- **GAP**: Not implemented in godot-java
- **JAVA-ONLY**: Exists in godot-java but not gdext

---

## Core Registration
- [ ] Class registration with name/parent/base
- [ ] Tool class support
- [ ] Editor plugin registration
- [ ] Singleton registration
- [ ] Internal class (hidden from create dialog)
- [ ] noInit (prevent GDScript instantiation)
- [ ] InitLevel per-level registration (CORE/SERVERS/SCENE/EDITOR)
- [ ] Hot reload support

## Property System
- [ ] @Export / #[export] property registration
- [ ] Property hints (range, enum, file, dir, color, etc.)
- [ ] Property usage flags
- [ ] Export groups and subgroups
- [ ] Custom getter/setter
- [ ] Read-only properties
- [ ] Default values
- [ ] Dynamic properties (_get/_set/_get_property_list)
- [ ] Property validation (validate_property)
- [ ] Property revert (property_can_revert / property_get_revert)
- [ ] Collection type metadata (typed Array/Dictionary hints)
- [ ] Object/Resource class name hints for editor pickers

## Signal System
- [ ] Signal declaration and registration
- [ ] Typed signal accessors (per-class facade)
- [ ] Engine class signal collections
- [ ] ConnectFlags support
- [ ] ConnectBuilder fluent API
- [ ] Signal disconnection

## Virtual Method Dispatch
- [ ] Virtual stub generation (ITrait / VirtualStubs)
- [ ] Two-phase dispatch (get_virtual_call_data + call_virtual_with_data)
- [ ] Virtual method override detection
- [ ] Editor mode suppression for non-tool classes
- [ ] Required virtual method tracking
- [ ] _notification / on_notification support

## Callable
- [ ] Native callable creation (callable_custom_create2)
- [ ] Callable round-trip (Java ↔ Godot ↔ Java)
- [ ] Lambda/function callables
- [ ] Thread-safe callables
- [ ] Linked callables (auto-invalidate on object free)
- [ ] Bound arguments

## Collections
- [ ] Array<T> (typed, reference type)
- [ ] Dictionary<K,V> (typed, reference type)
- [ ] PackedArray types (PackedByteArray, PackedStringArray, etc.)
- [ ] Element type metadata (Element trait / CollectionTypeMeta)
- [ ] Factory methods (of, fromList, fromMap)
- [ ] Read-only views

## Resource Handling
- [ ] Typed resource loading (load::<T> / Resources.load)
- [ ] Resource saving
- [ ] Resource existence check
- [ ] OnReady resource loading (delayed init)

## Editor Integration
- [ ] @ExportToolButton / #[export_tool_button]
- [ ] @RequiredInEditor / configuration warnings
- [ ] _get_configuration_warnings virtual dispatch
- [ ] Editor-only property initialization (OnEditor<T>)

## Async / Coroutines
- [ ] Coroutine/task spawning
- [ ] Async signal await with timeout
- [ ] Typed async signal return values
- [ ] Delay/sleep in coroutines

## Documentation
- [ ] Doc comment parsing (/// or ///)
- [ ] Markdown-to-BBCode conversion
- [ ] Class/method/property/signal/constant docs
- [ ] Editor doc registration (EDITOR_HELP_LOAD_XML)

## Code Generation
- [ ] API index / function table generation
- [ ] FFI signature generation
- [ ] Struct offset computation
- [ ] Variant type enum generation
- [ ] Virtual method index + hash generation
- [ ] Node/engine class wrappers
- [ ] Singleton wrappers
- [ ] Builtin method extensions
- [ ] Godot version metadata generation
- [ ] Class registry generation

## Networking
- [ ] RPC attribute/method registration
- [ ] RPC mode (authority, any_peer)
- [ ] RPC transfer mode (reliable, unreliable)
- [ ] RPC call-local option

## Constants
- [ ] Constant registration with ClassDB
- [ ] Constant documentation

## OnReady / Initialization
- [ ] @OnReady field initialization before _ready()
- [ ] OnReady modes (NEW, NODE, MANUAL)
- [ ] Auto-detect NODE mode from path

## Build / Configuration
- [ ] Double-precision real_t support
- [ ] Lazy API function loading
- [ ] Custom API JSON path support
- [ ] Force code regeneration
- [ ] Release signing and publishing

## Memory / Object Lifecycle
- [ ] Godot object wrapping (Gd<T> / JavaObjectMap)
- [ ] RefCounted reference tracking
- [ ] Manual object freeing (non-RefCounted)
- [ ] Object downcasting with type safety
- [ ] Null safety (Option<Gd<T>> / null checks)

## Error Handling
- [ ] Custom exception hierarchy
- [ ] Thread safety checks
- [ ] Re-entrant upcall protection
- [ ] Deferred startup messages
