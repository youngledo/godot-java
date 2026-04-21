# Architecture

Internal design of the godot-java GDExtension binding.

## Three-Layer Architecture

```
+------------------------------------------+
|        Godot Editor / Runtime             |
+------------------+-----------------------+
                   |
+------------------v-----------------------+
|     C++ Thin Layer (~500 lines)           |
|  - GDExtension entry point                |
|  - JVM lifecycle (JNI_CreateJavaVM)       |
|  - Delegates to Java via JNI              |
+------------------+-----------------------+
                   | JNI
+------------------v-----------------------+
|       Java Layer (Panama FFI)             |
|  - Bootstrap: init + registerClasses      |
|  - Bridge: 176 API MethodHandles          |
|  - Registry: ClassDB register             |
|  - Dispatch: APT-generated + upcall stubs |
|  - APT Processor: compile-time dispatch   |
|  - User game logic (@GodotClass)          |
+------------------------------------------+
```

## Bootstrap Phases

Initialization happens in two phases, matching Godot's GDExtension lifecycle.

### Phase 1: init()

Called from the C++ GDExtension entry point (`godot_java_init`) before init levels begin.

```java
Bootstrap.init(getProcAddress, libraryPtr)
```

Steps:
1. **Bridge.load()** -- Resolves all 176 Godot C API functions as Panama `MethodHandle`s. Each API function is looked up via `get_proc_address` and linked through `Linker.nativeLinker().downcallHandle()`.
2. **Variant.initConstructors()** -- Loads Variant type constructors for String and Object.
3. **Registry.registerBuiltinTypes()** -- Hook for registering built-in type wrappers.
4. **Scanner.scan()** -- Scans the module path for classes annotated with `@GodotClass`.
5. **GeneratedClassRegistry.load()** -- Loads APT-generated class registry (replaces runtime classpath scanning).

### Phase 2: registerClasses()

Called at SCENE initialization level, when Node and other scene classes are available in ClassDB.

```java
Bootstrap.registerClasses()
```

Steps:
1. **Registry.registerUserClasses()** -- For each scanned class, register it with ClassDB.

## Bridge: Panama FFI to Godot C API

`org.godot.bridge.Bridge` is the central FFI bridge.

**Loading API functions:**
```java
// For each of 176 API indices:
long addr = Bootstrap.getProcAddressImpl(cName);
MethodHandle mh = Linker.nativeLinker().downcallHandle(
    MemorySegment.ofAddress(addr), functionDescriptor);
API[api.index()] = mh;
```

**Memory allocation:**
Two-tier arena strategy using Java 25's `ScopedValue`:

```java
// Persistent arena: registration-phase allocations (upcall stubs, static data)
static final Arena ARENA = Arena.ofShared();

// Scoped arena: call-path temporary allocations, auto-freed per call
private static final ScopedValue<Arena> CALL_ARENA = ScopedValue.newInstance();
```

- `Bridge.runScoped(Callable/Runnable)` binds a fresh `Arena.ofShared()` via `ScopedValue`. All allocations inside the callback (Variants, StringNames, arg arrays) use this scoped arena and are freed when the scope exits.
- `Bridge.destroyVariant(MemorySegment)` calls `variant_destroy` before the arena closes, releasing Godot's internal references (refcounted objects held by Variants).
- Persistent arena (`ARENA`) is used only for registration-phase upcall stubs and static data.

**Convenience methods:**
Bridge provides typed call helpers: `callVoid()`, `callLong()`, `callInt()`, `callPtr()`, each accepting an `ApiIndex` enum and typed arguments.

## Registration Pipeline

```
Scanner.scan() / GeneratedClassRegistry.load()
  |  (finds @GodotClass classes)
  v
Registry.registerUserClasses()
  |
  v
Registry.registerClass(Class<?> cls)
  |
  +-- InstanceCallbacks.registerClass()      (maps className -> Class<? extends Godot>)
  +-- InstanceCallbacks.createCreationInfo()  (builds GDExtensionClassCreationInfo4 struct)
  +-- VirtualDispatch.getGetVirtualFuncStubForClass() (creates per-class virtual dispatch stub)
  +-- CLASSDB_REGISTER_EXTENSION_CLASS5()     (registers with Godot ClassDB)
  +-- MethodRegistration.registerMethods()    (registers @GodotMethod methods)
  +-- PropertyRegistration.registerProperties() (registers @Export fields)
  +-- SignalRegistration.registerSignals()    (registers @Signal declarations)
```

### Class Registration Details

For each `@GodotClass`, the system:

1. Creates `GDExtensionClassCreationInfo4` struct (native memory, ~160 bytes).
2. Populates upcall stubs:
   - `create_instance_func` -- allocates Java object, stores in `JavaObjectMap`.
   - `free_instance_func` -- removes from `JavaObjectMap`, calls `onFreed()`.
   - `get_virtual_func` -- returns virtual method dispatch stubs.
3. Calls `classdb_register_extension_class5` to register with Godot's ClassDB.
4. Registers methods, properties, and signals via their respective registration classes.

## Method Dispatch

### Godot Calling Java (@GodotMethod)

```
GDScript: obj.my_method(arg)
  |
  v
Godot: object_method_bind_call(bind, obj, args, argc, ret, error)
  |
  v
MethodDispatch.callAdapter(userdata, instance, args, argc, ret, error)
  |
  +-- Look up Method from REGISTERED_METHODS by userdata key
  +-- Find Java instance: JavaObjectMap.get(instance.address())
  +-- Convert Variant args to Java objects: VariantUtils.toObject()
  +-- Coerce types: coerceType() (Number -> int/long/float/double)
  +-- Invoke: method.invoke(javaObj, javaArgs)
  +-- Convert return: VariantUtils.fromObject() -> variant_new_copy
```

The upcall stub is created once during registration:
```java
callStub = Bridge.linker().upcallStub(mh, METHOD_CALL_FD, Bridge.arena());
```

### ptrcall Support (zero-copy typed dispatch)

- `MethodDispatch.ptrcallAdapter()` receives typed pointers instead of Variants
- `readTypedPtr()` reads primitives directly (double, float, int, long, boolean), String via GodotString, objects via ref_get_object for RefCounted or direct dereference for non-RefCounted
- `writeTypedPtr()` writes return values as typed pointers
- APT-generated `TypedDispatch_<ClassName>` uses MethodHandle dispatch (zero reflection)
- Falls back to reflection when APT data unavailable

### Java Calling Godot (call())

```
Java: godot.call("set_position", new Vector2(100, 200))
  |
  +-- getMethodHashWithClass("set_position")
  |     walks class hierarchy, finds METHOD_HASHES map
  +-- CLASSDB_GET_METHOD_BIND(classSn, methodSn, hash)
  +-- VariantUtils.fromObject() for each argument
  +-- OBJECT_METHOD_BIND_CALL(bind, obj, args, argc, ret, error)
  |
  v
Variant result -> VariantUtils.toObject() -> Java Object
```

## Virtual Method Dispatch

### APT-Generated Per-Class Virtual Dispatch

The virtual dispatch architecture is aligned with gdext (Rust GDExtension bindings):

1. **APT processor generates `VirtualDispatch_<ParentClass>`** -- contains hash-to-name maps for all virtual methods in that parent class hierarchy. E.g., `VirtualDispatch_Node` has ~12 entries instead of the global 527.

2. **Per-class `get_virtual_func`** -- each registered class gets its own upcall stub with the class name pre-bound. Returns NULL for non-overridden methods.

3. **Hash -> name resolution** -- Godot identifies virtuals by compatibility hash. The APT-generated map resolves hash to candidate names (typically 2-5). Hash collisions are resolved by StringName pointer comparison.

4. **MethodHandle dispatch** -- during registration, a `MethodHandle` is pre-created for each overridden virtual method, adapted to accept `Godot` as receiver type. At dispatch time:
   - Try cached MethodHandle first (zero reflection, ~36ns/call)
   - Fall back to `Method.invoke()` if no MethodHandle available (~134ns/call)

```
get_virtual_func(godotClassName, userdata, namePtr, compatHash)
  |
  +-- CLASS_DISPATCH_DATA.get(godotClassName) -> per-class metadata
  +-- aptData.hashToNames.get(normalizedHash) -> candidate names (APT, 2-5 entries)
  |   OR VirtualMethods.HASH_TO_NAMES.get(hash) -> candidates (global fallback, 527 entries)
  +-- Match candidate against methodsByName
  +-- If single match: return callStub
  +-- If collision: disambiguate by StringName pointer
```

```
callVirtualAdapter(methodName, instance, args, ret)
  |
  +-- JavaObjectMap.get(instanceAddr) -> Java object
  +-- findMethodEntry(obj.getClass(), methodName) -> cached MethodEntry
  +-- If handle != null:
  |     MethodHandle.dispatch(obj, args...) -> result (fast path)
  +-- Else:
        Method.invoke(obj, args) -> result (reflection fallback)
  +-- VariantUtils.fromObject(result) -> write return Variant
```

## Instance Management

`org.godot.internal.ref.JavaObjectMap` maintains the mapping between native Godot object pointers and Java wrapper objects.

```java
// Two concurrent maps:
ConcurrentHashMap<Long, Godot> NATIVE_TO_JAVA
ConcurrentHashMap<Godot, Long> JAVA_TO_NATIVE
```

**Creation:** When Godot creates an instance (via `create_instance_func` upcall), the Java object is constructed and registered:
```java
JavaObjectMap.put(nativePtr, javaObj);
```

**Lookup:** When Godot calls back into Java (method dispatch, virtual dispatch), the map finds the Java object:
```java
Godot obj = JavaObjectMap.get(instanceAddr);
```

**Destruction:** When Godot frees the native object (via `free_instance_func` upcall), the mapping is removed and `onFreed()` is called:
```java
JavaObjectMap.remove(nativePtr);  // calls obj.onFreed()
```

### Lifecycle Callbacks (CreationInfo4)

The `GDExtensionClassCreationInfo4` struct wires these callbacks:

| Callback | Offset | Purpose |
|----------|--------|---------|
| `set_func` / `get_func` | 24 / 32 | Property access for @Export fields |
| `get_property_list_func` | 40 | Exposes @Export fields to Godot Inspector |
| `free_property_list_func` | 48 | Frees property list memory |
| `property_can_revert_func` | 52 | Returns true if default value known |
| `property_get_revert_func` | 56 | Returns default value as Variant |
| `validate_property_func` | 64 | Property validation pass-through |
| `notification_func` | 72 | Forwards Godot notifications to `onNotification(int)` |
| `to_string_func` | 80 | Bridges Java `toString()` to Godot |
| `reference_func` / `unreference_func` | 88 / 96 | Atomic ref counting for RefCounted-derived classes |
| `create_instance_func` | 104 | Creates Java object, registers in JavaObjectMap |
| `free_instance_func` | 112 | Removes from JavaObjectMap, calls `onFreed()` |
| `get_virtual_func` | 128 | Returns virtual method dispatch stub |

## Key Classes

| Class | Package | Responsibility |
|---|---|---|
| `Bootstrap` | `org.godot.bootstrap` | Entry point: init() and registerClasses() |
| `Bridge` | `org.godot.bridge` | 176 API MethodHandles, memory allocation |
| `ApiIndex` | `org.godot.internal.api` | Enum of all Godot C API function indices |
| `ApiSignatures` | `org.godot.bridge` | FunctionDescriptor for each API function |
| `MethodDispatch` | `org.godot.bridge` | Upcall stub for @GodotMethod calls |
| `VirtualDispatch` | `org.godot.bridge` | Upcall stubs for virtual lifecycle methods |
| `InstanceCallbacks` | `org.godot.bridge` | create/free instance upcall stubs |
| `MethodRegistration` | `org.godot.bridge` | Registers @GodotMethod with ClassDB |
| `PropertyRegistration` | `org.godot.bridge` | Registers @Export properties |
| `SignalRegistration` | `org.godot.bridge` | Registers @Signal signals |
| `GodotClassProcessor` | `org.godot.processor` (godot-java-processor) | APT annotation processor, generates TypedDispatch/VirtualDispatch classes |
| `GeneratedClassRegistry` | `org.godot.internal` | APT-generated class name -> Java class mapping |
| `TypedDispatch_*` | `org.godot.internal` (generated) | Per-class MethodHandle dispatch for @GodotMethod |
| `VirtualDispatch_*` | `org.godot.internal` (generated) | Per-parent-class hash maps for virtual method resolution |
| `Registry` | `org.godot.registration` | Registers classes with ClassDB |
| `JavaObjectMap` | `org.godot.internal.ref` | Native pointer <-> Java object bidirectional map |
| `Variant` | `org.godot.core` | Godot Variant wrapper (24 bytes) |
| `VariantUtils` | `org.godot.core` | Variant <-> Java Object conversion |
| `Godot` | `org.godot` | Abstract base of all Godot wrappers |

## Project Structure

```
godot-java/
  pom.xml                           # Parent POM (org.godot:godot-java:0.1.0)
  godot-java-core/                  # Core binding module
    pom.xml                         # (org.godot:godot-java-core:0.1.0)
    src/main/java/
      module-info.java              # Module: org.godot
      org/godot/
        Godot.java                  # Abstract base class
        GodotObject.java            # Extends Godot, for RefCounted types
        annotation/                 # @GodotClass, @GodotMethod, @Export, @Signal
        bootstrap/                  # Bootstrap: init + registerClasses
        bridge/                     # Bridge, MethodDispatch, VirtualDispatch, ...
        collection/                 # GodotArray, GodotDictionary
        core/                       # Variant, GodotString, GodotStringName, Callable
        internal/
          api/                      # ApiIndex, VariantType, VirtualMethods, StructOffsets
          ref/                      # JavaObjectMap, RefcountTracker
        math/                       # Vector2, Vector3, Color, Transform3D, ...
        node/                       # Node, Node2D, Node3D, Control, Viewport
        registration/               # Registry
    src/main/resources/
      method_hashes.txt             # Method hash values for method bind lookup
      class_hierarchy.txt           # Godot class hierarchy data
  godot-java-processor/             # APT annotation processor
    pom.xml
    src/main/java/org/godot/processor/
      GodotClassProcessor.java     # Processes @GodotClass, generates dispatch classes
  godot-java-code-generator/        # Code generator (reads extension_api.json)
  godot-api/                        # extension_api.json
  godot-cpp/                        # C++ bindings (git submodule)
  docs/                             # Documentation
```

## Data Flow

### Initialization

```
Godot loads .gdextension
  -> godot_java_init() [C++]
  -> JNI_CreateJavaVM()
  -> Bootstrap.init(procAddress, libraryPtr) [Java via JNI]
  -> Bridge.load(): 176 API functions -> MethodHandles
  -> Variant.initConstructors()
  -> Scanner.scan() / GeneratedClassRegistry.load(): find @GodotClass classes
  -> [wait for SCENE init level]
  -> Bootstrap.registerClasses() [Java via JNI]
  -> For each @GodotClass: Registry.registerClass()
    -> InstanceCallbacks: create/free stubs
    -> VirtualDispatch.getGetVirtualFuncStubForClass()
    -> CLASSDB_REGISTER_EXTENSION_CLASS5
    -> MethodRegistration: @GodotMethod methods
    -> PropertyRegistration: @Export fields
    -> SignalRegistration: @Signal signals
  -> Java classes appear in Godot editor
```

### Method Call (GDScript -> Java)

```
GDScript: obj.take_damage(30)
  -> Godot: object_method_bind_call()
  -> C++ callback -> JNI -> JVM
  -> MethodDispatch.callAdapter()
    -> Try APT-generated TypedDispatch_<Class>.dispatchMethod() first
    -> Fall back to reflection if APT data unavailable
    -> JavaObjectMap.get(instancePtr)
    -> VariantUtils.toObject(): Variant[30] -> Integer(30)
    -> coerceType(): Integer -> int
    -> method.invoke(playerObj, 30)
  -> Player.takeDamage(30)
```

## Performance

Benchmark results (10K warmup, 100K iterations, JDK 25, macOS ARM64):

| Dispatch Path | Per-call | vs Direct Call |
|---------------|----------|----------------|
| Direct virtual call | ~17 ns | 1x (baseline) |
| MethodHandle (APT) | ~36 ns | 2.1x |
| Method.invoke() (reflection) | ~134 ns | 7.9x |

APT-generated MethodHandle dispatch is **3.7x faster** than reflection.
