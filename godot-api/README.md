# Godot API JSON Files

This directory contains the Godot extension API definitions used by the code generator.

## Default (v4.6)

The root-level files are for Godot 4.6.x:
- `extension_api.json` — engine class API
- `gdextension_interface.json` — GDExtension C interface
- `gdextension_interface.h` — C header (for reference)

## Using a Different Godot Version

Place the API JSON files for your target version in a versioned subdirectory:

```
godot-api/
├── extension_api.json          ← default (4.6)
├── gdextension_interface.json  ← default
├── v4.4/
│   └── (place extension_api.json here)
├── v4.5/
│   └── (place extension_api.json here)
└── v4.6/
    └── (place extension_api.json here)
```

### How to Extract API JSON from Godot

Run Godot with the `--dump-extension-api` flag:

```bash
godot --headless --dump-extension-api
```

This creates `extension_api.json` in the current directory. Copy it to the appropriate versioned subdirectory.

### Building with a Custom API

Use the `api-custom` profile with the path to your JSON:

```bash
mvn generate-sources -pl godot-java-core -Papi-custom \
    -Dgodot.api.json=godot-api/v4.4/extension_api.json
```

If the GDExtension interface also differs between versions:

```bash
mvn generate-sources -pl godot-java-core -Papi-custom \
    -Dgodot.api.json=godot-api/v4.4/extension_api.json \
    -Dgodot.interface.json=godot-api/v4.4/gdextension_interface.json
```

Combine with other profiles as needed:

```bash
mvn generate-sources -pl godot-java-core -Papi-custom,double-precision \
    -Dgodot.api.json=godot-api/v4.4/extension_api.json
```
