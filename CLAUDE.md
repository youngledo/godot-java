# godot-java

Java bindings for Godot Engine via Panama FFI (Java 25).

## Build

```bash
mvn install -DskipTests -Dspotbugs.skip=true   # framework
cd godot-java-3d-demo && mvn package -DskipTests  # demo
```

Code generation runs automatically in `generate-sources` phase. Output in `target/generated-sources/codegen/`.

## Conventions

- See [CONTRIBUTING.md](CONTRIBUTING.md) for architecture constraints and code style
- Do not push to remote unless explicitly asked
- No `Co-Authored-By` in commits
