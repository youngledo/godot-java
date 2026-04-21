# godot-java

ENGLISH | [中文](README_ZH.md)

---

## Overview

Java bindings for [Godot](https://godotengine.org/).  
Built on top of GDExtension and Panama FFI to make Java a first-class citizen in the Godot ecosystem.

> Status: 0.1.0 – production-ready with scoped memory management and full GDExtension feature coverage.

Project examples:
- [godot-java-examples](godot-java-examples/README.md)
- [godot-java-3d-demo](https://github.com/youngledo/godot-java-3d-demo)

---

## Why does this project exist?

In the game engine world, Java is almost always the missing language:

- Unity offers C# as its scripting language — no Java
- Unreal Engine is firmly C++ — no Java
- Godot ships with GDScript and C# — no Java
- Even community-maintained bindings (e.g. godot-kotlin-jvm) target Kotlin or require recompiling the engine

Meanwhile, Java remains one of the most widely used languages on the planet — dominant in enterprise backends, Android development, and large-scale data processing. Millions of developers write Java every day, yet the game engine ecosystem offers them almost nothing.

For teams with an existing Java stack, this is a real gap:

- Their codebase, tools, and engineering practices are all built around Java
- Trying a game engine often means:
  - Learning and maintaining a completely different language (C++/GDScript/C#), or
  - Building and maintaining a fragile bridge between Java and the engine

**godot-java aims to challenge the “no Java in game development” status quo**:

- Give Java a first-class seat in the Godot ecosystem
- Let existing Java teams reuse:
  - Their language and IDEs (IntelliJ IDEA / Eclipse / VS Code, etc.)
  - Their build and dependency tooling (Maven/Gradle)
  - Their testing, logging, diagnostics, and CI/CD pipelines

From an engineering point of view, the goals are:

- Provide a natural Java experience (annotations, strong typing, modern FFI)
- Avoid piles of custom JNI glue – lean on Java 25’s Panama FFI instead

---

## Why Java 25?

This project deliberately targets **Java 25+** instead of trying to support older LTS releases like 8/11/17.

There are three main reasons:

1. **No legacy baggage**  
   By focusing on a single modern Java version, we keep the codebase clean and straightforward.  
   There is no need to carry around compatibility layers or branching logic for older JDKs.

2. **Use the latest language and platform features**  
   We can freely use:
   - Records, sealed types, pattern matching
   - The enhanced `switch` expression and `var` where it makes sense
   - The latest `java.lang.foreign` Panama FFI APIs  
   This allows the binding code itself to look and feel like modern Java, not “Java written as if it were C”.

3. **Let you fully enjoy modern Java**  
   The idea is to let you write game code while enjoying everything modern Java has to offer:
   - Expressive language features
   - A rich library ecosystem
   - A familiar toolchain  
   Without constantly worrying “will this feature work on some old JDK?”

If you are curious what “Godot + modern Java + Panama FFI” can look like, this project is meant as a clean, modern starting point rather than a legacy SDK that evolved from older Java versions.

---

## What does it do? (Feature overview)

Core capabilities currently implemented:

- **Godot GDExtension binding (C API)**  
  - Uses `GDExtensionInterfaceGetProcAddress` to dynamically load the Godot API  
  - Models core C structs such as `GDExtensionClassLibraryPtr`, `GDExtensionPropertyInfo`, `GDExtensionClassMethodInfo`, etc.

- **Java 25 Panama FFI integration**  
  - Uses `java.lang.foreign` (`Linker`, `FunctionDescriptor`, `MemorySegment`, …) to call into Godot  
  - No custom JNI-based helper library is required

- **Annotation-driven class / method / property / signal registration**
  - `@GodotClass` – declare a Java class that can be instantiated from Godot
  - `@GodotMethod` – expose a Java method to be called from Godot
  - `@Export` – export a field to the Godot Inspector with `hint`/`hintString` support
  - `@Signal` – declare and emit Godot signals from Java
  - APT processor (`godot-java-processor`) generates typed dispatch code at compile time (zero runtime reflection in the hot path)

- **APT-compiled typed dispatch (aligned with gdext/Rust architecture)**
  - `TypedDispatch_<ClassName>` — MethodHandle/VarHandle-based method dispatch
  - `PropertyAccess_<ClassName>` — VarHandle-based property access for @Export fields
  - `VirtualDispatch_<ParentClass>` — per-parent-class hash maps for virtual method resolution
  - Reflection fallback when APT data is unavailable

- **Virtual methods and lifecycle callbacks**
  - Supports all 1144 virtual methods across all Godot classes
  - Per-class `get_virtual_func` upcall stubs (lazy, only for overridden methods)
  - Lifecycle callbacks: `notification_func`, `to_string_func`, `reference_func`/`unreference_func`, `validate_property_func`

- **ptrcall support**
  - Zero-copy typed pointer dispatch (avoids Variant boxing for method calls)
  - RefCounted-aware: uses `ref_get_object`/`ref_set_object` for RefPtr parameters
  - APT-generated MethodHandle dispatch for registered @GodotMethod methods

- **Property system**
  - `get_property_list_func` — exposes @Export fields to Godot editor
  - `property_can_revert_func`/`property_get_revert_func` — default value support
  - Hash collision resolution by StringName pointer comparison

- **Type system and Variant interop**
  - Java-side types for `Variant`, `GodotStringName`, `GodotString`, `GodotArray`, `GodotDictionary`, etc.
  - Safe conversions between common Java types and Godot Variants

---

## Architecture

The dispatch architecture is aligned with [gdext](https://github.com/godot-rust/gdext) (the Rust bindings): upcall stubs are created lazily at class registration time, only for methods the user actually overrides. Unimplemented methods return `NULL` so Godot uses its default C++ implementation.

### 1. APT-Generated Typed Dispatch

The annotation processor (`godot-java-processor`) generates per-class dispatch code at compile time:

- **`TypedDispatch_<ClassName>`** — `MethodHandle`/`VarHandle`-based method dispatch (zero reflection on the hot path)
- **`PropertyAccess_<ClassName>`** — `VarHandle`-based property access for `@Export` fields
- **`VirtualDispatch_<ParentClass>`** — per-parent-class hash maps for virtual method resolution (reduces candidate names from 1000+ to ~12)
- Falls back to runtime reflection when APT-generated data is unavailable

### 2. Virtual Method Dispatch (aligned with gdext/Rust)

- Per-class `get_virtual_func` upcall stubs — lazy, only created for methods the user actually overrides
- APT-generated per-parent-class hash resolution — eliminates false matches across unrelated classes sharing method names
- `MethodHandle` pre-cached dispatch with reflection fallback
- Hash collision resolution by `StringName` pointer comparison

### 3. Lifecycle Callbacks

- **`notification_func`** — forwards Godot notifications to `onNotification(int)` on the Java instance
- **`to_string_func`** — bridges Java `toString()` to Godot's string representation
- **`reference_func` / `unreference_func`** — atomic reference counting for `RefCounted`-derived classes
- **`validate_property_func`** — property validation pass-through for editor integration

### 4. ptrcall Support

- Zero-copy typed pointer dispatch — avoids `Variant` boxing overhead for method calls
- RefCounted-aware — uses `ref_get_object`/`ref_set_object` for `RefPtr` parameters
- APT-generated `MethodHandle` dispatch for registered `@GodotMethod` methods

### 5. Property System

- `@Export` annotation with `hint` and `hintString` for Godot editor integration
- `get_property_list_func` — exposes `@Export` fields to the Godot Inspector
- `property_can_revert_func` / `property_get_revert_func` — default value support for revert behavior
- `@Signal` annotation for signal declaration and emission from Java

---

## Tech stack highlights

Some key technical choices in this project:

1. **GDExtension (Godot 4 official extension mechanism)**
   - No reliance on legacy GDNative/JNI plugin approaches
   - Aligned with Godot’s loading and lifecycle model
   - Distributed as a shared library (`.dylib / .so / .dll`)

2. **Java 25 Panama FFI**
   - Uses the standard FFI API in the JDK (`java.lang.foreign`)
   - Function signatures and memory layouts are modeled via `FunctionDescriptor` / `MemoryLayout`
   - Easier to navigate and refactor in IDEs

3. **Annotation-based registration model**
   - Generates the registration data Godot needs from annotations and reflection
   - Avoids writing repetitive registration code on the C/C++ side
   - Feels more like writing a normal Java application

---

## Comparison with Other Language Bindings

There are several ways to bring other languages into Godot. Here is how godot-java compares to the main alternatives:

| | Integration | FFI | Virtual methods | ptrcall | Barrier to entry | Maturity  |
|---|---|---|---|---|---|-----------|
| **godot-java** | GDExtension | Panama FFI (Java 25) | All 1144 | Supported | Low (no engine recompile) | Alpha     |
| **[godot-rust/gdext](https://github.com/godot-rust/gdext)** | GDExtension | Rust FFI | All supported | Supported | Low (no engine recompile) | Stable    |
| **[graphics.gd (Go)](https://github.com/quaadgras/graphics.gd)** | GDExtension | CGO | Supported | — | Low (no engine recompile) | Community |
| **[godot-kotlin-jvm](https://github.com/utopia-rise/godot-kotlin-jvm)** | Engine module | JNI | All supported | Supported | **High (requires recompiling Godot)** | Stable    |
| C# (official) | Engine module | N/A | All supported | Supported | Medium (Mono embedded) | Official  |

### Key distinction: Engine module vs GDExtension

The fundamental difference is how a language integrates with Godot:

- **GDExtension** is Godot 4's official plugin API. Languages built on it compile to a shared library (`.so`/`.dylib`/`.dll`) that Godot loads at runtime. No engine recompilation is needed — users download a standard Godot binary and load the extension. This is the path taken by godot-java, gdext, and graphics.gd.

- **Engine module** compiles the language directly into the Godot C++ process. This gives full access to everything the engine offers (all virtual methods, `Input.*`, etc.) but requires recompiling the entire Godot engine from source. This is the path taken by godot-kotlin-jvm (due to JVM embedding requirements) and C# (Godot's built-in option).

### What this means for godot-java

godot-java follows the GDExtension path. It supports all 1144 virtual methods across all Godot classes, auto-scanned from `extension_api.json`. The dispatch architecture is aligned with gdext (Rust bindings): upcall stubs are created lazily at class registration time, only for methods the user actually overrides. Unimplemented methods return NULL so Godot uses its default C++ implementation.

If you are coming from gdext: godot-java aims for a similar architecture, with Java instead of Rust and Panama FFI instead of native Rust FFI.

---

## Documentation

There are two documentation tracks: English and Chinese.

- Index: `docs/README.md`  
  - Explains the documentation structure  
  - Helps you find the right language / role-specific docs

### English docs

Under `docs/en/`:

- `docs/en/user/getting-started.md` — Requirements, build, loading the extension in Godot
- `docs/en/user/api.md` — API overview and common types
- `docs/en/user/guide.md` — Usage guide and best practices
- `docs/en/user/troubleshooting.md` — Common issues and debugging tips
- `docs/en/dev/architecture.md` — Internal architecture (GDExtension + FFI)
- `docs/en/dev/building.md` — Build, packaging, and upgrading Godot version
- `docs/en/dev/contributing.md` — How to contribute
- `docs/en/dev/debugging.md` — Debugging Godot/Java integration

---

## Repository layout (short version)

```text
godot-java/
├── pom.xml                          # Root Maven project (aggregator)
├── godot-api/                       # Godot API JSON files (input to code generator)
│   ├── extension_api.json           #   Godot class/method/property definitions
│   ├── gdextension_interface.json   #   GDExtension C interface definitions
│   └── gdextension_interface.h      #   GDExtension C header (reference)
├── godot-java-core/                 # Core runtime and Godot Java bindings
│   ├── native/src/godot_java.cpp    #   C++ entry point (GDExtension initialization)
│   ├── src/main/java/org/godot/
│   │   ├── annotation/              #   @GodotClass, @GodotMethod, @Export, @Signal
│   │   ├── bootstrap/               #   JVM startup & GDExtension entry
│   │   ├── bridge/                  #   Panama FFI bridge (VirtualDispatch, InstanceCallbacks)
│   │   ├── core/                    #   Variant, StringName, GodotString, Callable…
│   │   ├── collection/              #   GodotArray, GodotDictionary
│   │   ├── math/                    #   Vector2/Vector3, Transform2D/3D…
│   │   ├── node/                    #   1016 generated node wrappers (Node, Node2D, Control…)
│   │   ├── internal/api/            #   Auto-generated: ApiIndex, ApiSignatures, VariantType, VirtualMethods…
│   │   └── registration/            #   Annotation scanning & class registration
│   └── src/test/java/               #   Unit tests
├── godot-java-code-generator/       # Code generator (from Godot API JSON)
│   └── src/main/java/com/godot/codegen/
│       ├── Main.java                #   Entry point
│       ├── ApiIndexGenerator.java   #   176 API function indices
│       ├── ApiSignaturesGenerator.java # Panama FunctionDescriptors
│       ├── VariantTypeGenerator.java #   Variant type enum
│       ├── VirtualMethodGenerator.java # Virtual method metadata
│       ├── ClassGenerator.java      #   1016 node wrapper classes
│       └── StructLayoutComputer.java #  C struct offset calculator
├── godot-java-processor/            # APT annotation processor
│   └── src/main/java/org/godot/processor/
│       └── GodotClassProcessor.java #   Generates TypedDispatch/VirtualDispatch at compile time
├── godot-java-examples/             # Example projects (10 examples)
│   ├── src/main/java/examples/      #   Java source (helloworld, pong, snake…)
│   └── examples/01-*/~10-*/         #   Godot projects with .tscn, .gd, native/
├── upgrade-godot-api.sh             # One-command Godot version upgrade
└── docs/                            # Documentation (EN + ZH)
    ├── en/user/ | en/dev/
    └── zh/user/ | zh/dev/
```

---

## Upgrading to a New Godot Version

When Godot releases a new version, godot-java can be upgraded in one step:

```bash
./upgrade-godot-api.sh 4.7
```

This script:
1. Downloads the new `extension_api.json` and `gdextension_interface.json` from godot-cpp
2. Re-runs the code generator, which auto-updates:
   - **ApiIndex.java** — 176 API function indices
   - **ApiSignatures.java** — Panama FunctionDescriptor for each function
   - **VariantType.java** — Variant type enum
   - **StructOffsets.java** — C struct field offsets
   - **VirtualMethods.java** — virtual method metadata (1144 methods, name→hash lookup)
   - **ObjectMethodHashes.java** — method bind hashes for Object
   - **1016 node wrapper classes** — engine type API changes

Then verify:

```bash
./mvnw clean install -DskipTests
```

---

## Where to start?

To get a demo running:

1. Make sure you have:
   - JDK 25+
   - Maven 4.0.x
   - Godot

2. Read:
   - [docs/en/user/getting-started.md](docs/en/user/getting-started.md)

3. Then:
   - Build `godot-java-core` and `godot-java-code-generator`
   - Load the built GDExtension into a new Godot project
   - Create a simple `@GodotClass`-annotated Java script and experiment

---

## Contributing

Contributions are very welcome:

- Bug reports, design discussions, and UX feedback
- Documentation improvements
- Platform / Godot version compatibility testing
- Expanding API coverage and tests

See: [docs/en/dev/contribution.md](docs/en/dev/contribution.md)

---

## Acknowledgements

- The Godot Engine team and community for an open, powerful engine and GDExtension API
- The OpenJDK Panama team for bringing modern FFI to Java
- Everyone who has tried to use Java in game development – this project is also for you.
