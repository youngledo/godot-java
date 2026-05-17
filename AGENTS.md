# AGENTS.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Full framework build (code generator + core + tests)
mvn install -DskipTests -Dspotbugs.skip=true

# Build examples (fat JAR with shade plugin)
cd godot-java-examples && mvn package -DskipTests

# Run unit tests only
mvn test -pl godot-java-core

# Run a single test class
mvn test -pl godot-java-core -Dtest=GodotStringTest

# Run a single test method
mvn test -pl godot-java-core -Dtest=GodotStringTest#testLength

# Run integration tests (requires Godot binary — auto-skips if missing)
mvn verify -pl godot-java-core

# Spotless format check (runs automatically during build)
mvn spotless:check

# SpotBugs static analysis
mvn spotbugs:check -pl godot-java-core

# Force code regeneration (skips up-to-date check)
mvn generate-sources -pl godot-java-core -Dcodegen.force=true
```

**Requirements:** Java 25 (enforced), Maven >= 4.0.0-rc-5.

## Architecture

**godot-java** provides Java bindings for Godot 4.x via GDExtension + Panama FFI. The architecture follows gdext (Rust bindings) closely.

### Module Dependency Chain

```
godot-api/              ← Static JSON data (extension_api.json, gdextension_interface.json)
   ↓  (file paths, not a Maven module)
godot-java-code-generator  ← Reads JSON → generates Java source (ApiIndex, node wrappers, etc.)
   ↓  (exec'd during generate-sources)
godot-java-core         ← Runtime: annotations, Panama FFI bridge, APT processor, tests
   ↓
godot-java-examples     ← Tutorial examples, shaded fat JAR
godot-java-native       ← Packages C++ shared library per platform
```

### Two-Phase Code Generation

**Phase 1 — Code Generator** (`godot-java-code-generator`): Runs during `generate-sources`. Reads `extension_api.json` and `gdextension_interface.json`, produces ~1000 generated Java files: node wrappers (`org.godot.node.*`), singleton wrappers (`org.godot.singleton.*`), `ApiIndex`, `ApiSignatures`, `StructOffsets`, `VariantType`, `VirtualMethods`. Output in `target/generated-sources/codegen/`.

**Phase 2 — APT Processor** (`org.godot.processor.GodotClassProcessor`): Lives inside `godot-java-core`, registered via `META-INF/services`. Scans user `@GodotClass` annotations at compile time and generates:
- `DispatchIndex` — consolidated zero-reflection dispatch tables (factories, methods, properties, signals, virtual overrides, constants, docs)
- `GeneratedClassRegistry` — class list for runtime scanning
- Per-class `Signals` facades for typed signal accessors

### Core Runtime Components

| Component | Purpose |
|-----------|---------|
| `Bridge` | Panama FFI bridge to all 176 Godot C API functions. Cached `MethodHandle[]`, scoped call frames for re-entrant calls. |
| `Dispatch` / `DispatchAccessor` | Facade over APT-generated `DispatchIndex.INSTANCE`. The ONLY place `Class.forName` is used (two calls in static init). |
| `InstanceCallbacks` | Creates `GDExtensionClassCreationInfo4` structs with upcall stubs for create/free/recreate instance. |
| `MethodRegistration` | Builds `GDExtensionClassMethodInfo` structs, registers `@GodotMethod` and `@GodotMethod(virtual=true)` with ClassDB. |
| `VirtualDispatch` | Implements Godot 4.6's two-phase virtual dispatch (`get_virtual_call_data_func` + `call_virtual_with_data_func`). |
| `Registry` | Central type registration: calls ClassDB APIs to register classes, methods, properties, signals, constants, singletons, docs. |
| `VariantUtils` | Converts between Java objects and Godot Variant native memory. |

### Data Flow

```
User @GodotClass → APT generates DispatchIndex → Dispatch loads it at startup
                                                    ↓
Bootstrap.init() → Bridge.load() → Scanner.scan() → Registry.registerUserClasses()
                                                        ↓
                                                  For each class:
                                                  1. CLASSDB_REGISTER_EXTENSION_CLASS5
                                                  2. Register methods, properties, signals
                                                  3. Register constants, virtual methods
                                                  4. Register docs (editor only)
                                                  5. Register singleton (if annotated)
```

## Conventions

- **Zero runtime reflection** in `godot-java-core/src/main/java/` — all type discovery via APT. No `Class.forName()`, `Method.invoke()`, `Field.get/set()`, `setAccessible(true)`, `getDeclaredMethods()`, or `getAnnotation()` at runtime.
- **All Java→Godot calls** through Panama FFI Bridge, never JNI helpers.
- **Documentation comments** use Java 23 Markdown format (`///`) instead of traditional `/** */` Javadoc — enables Godot editor doc registration.
- **Upcall stubs** must use `Bridge.ARENA` (shared, JVM-lifetime), never `Bridge.arena()` (scoped).
- All string pointers in GDExtension structs must be valid (non-NULL) — Godot dereferences unconditionally.
- Code comments in English only.
- No `Co-Authored-By` in commits.
- Do not push to remote unless explicitly asked.
- See [CONTRIBUTING.md](CONTRIBUTING.md) for full architecture constraints and style rules.

## Spotless

Code formatting uses Eclipse defaults with `removeUnusedImports`. Spotless runs automatically during `process-sources` phase (after code generation). Spotless can revert edits — if the Edit tool fails on tab-indented files, use Python `content.replace()` or the IDE's `replace_text_in_file` instead.

After editing `GodotClassProcessor.java`, the APT processor must be reinstalled before downstream modules pick up changes: `mvn install -pl godot-java-core -DskipTests`.

## SpotBugs

Runs on `godot-java-core` only with `threshold=LOW`. Exclusions in `spotbugs-exclude.xml` allow Panama FFI patterns (exposing `MemorySegment` references) and generated code. New public fields or mutable static arrays may need exclusions.

## Integration Tests

`GodotIntegrationTest` launches Godot headless (`--headless --quit-after 10`) against `godot-java-examples/examples/it-test/` and asserts on stdout markers. Auto-skips if Godot binary not found. Set `GODOT_BIN` env var or `godot.bin` system property to point to Godot.
