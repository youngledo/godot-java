#!/bin/bash
# Upgrade Godot API files and regenerate binding code.
#
# Modes:
#   ./upgrade-godot-api.sh                  # Auto-detect: local Godot binary, fallback to download
#   ./upgrade-godot-api.sh --local          # Force local Godot binary export
#   ./upgrade-godot-api.sh --download 4.7   # Download from godot-cpp GitHub
#
# Official Godot workflow:
#   godot --headless --dump-extension-api              → extension_api.json
#   godot --headless --dump-gdextension-interface      → gdextension_interface.h
#   godot --headless --dump-gdextension-interface-json → gdextension_interface.json

set -e

API_DIR="godot-api"
MODE=""
VERSION=""

# Parse arguments
for arg in "$@"; do
    case "$arg" in
        --local)   MODE="local" ;;
        --download) MODE="download" ;;
        --*)       echo "Unknown option: $arg"; exit 1 ;;
        *)         VERSION="$arg" ;;
    esac
done

# Auto-detect mode
if [ -z "$MODE" ]; then
    if [ -x "/Applications/Godot.app/Contents/MacOS/Godot" ]; then
        MODE="local"
        echo "Found local Godot, using local export mode."
    else
        MODE="download"
        echo "No local Godot found, using download mode."
    fi
fi

mkdir -p "${API_DIR}"

# ------------------------------------------------------------------------
# Local mode: export from installed Godot binary (official recommended way)
# ------------------------------------------------------------------------
export_from_local() {
    # Find Godot binary
    local GODOT_BIN=""
    if [ -x "/Applications/Godot.app/Contents/MacOS/Godot" ]; then
        GODOT_BIN="/Applications/Godot.app/Contents/MacOS/Godot"
    elif command -v godot &>/dev/null; then
        GODOT_BIN="$(command -v godot)"
    else
        echo "ERROR: No Godot binary found."
        echo "Install Godot or use: $0 --download <version>"
        exit 1
    fi

    local GODOT_VERSION=$("$GODOT_BIN" --version 2>/dev/null || echo "unknown")
    echo "Using Godot binary: ${GODOT_BIN} (${GODOT_VERSION})"

    # Export all 3 files (official commands)
    echo "Exporting extension_api.json..."
    (cd "${API_DIR}" && "$GODOT_BIN" --headless --dump-extension-api 2>/dev/null)

    echo "Exporting gdextension_interface.h..."
    (cd "${API_DIR}" && "$GODOT_BIN" --headless --dump-gdextension-interface 2>/dev/null)

    echo "Exporting gdextension_interface.json..."
    (cd "${API_DIR}" && "$GODOT_BIN" --headless --dump-gdextension-interface-json 2>/dev/null)

    echo "All 3 API files exported from Godot ${GODOT_VERSION}."
}

# ------------------------------------------------------------------------
# Download mode: fetch from godot-cpp GitHub
# ------------------------------------------------------------------------
download_from_github() {
    if [ -z "$VERSION" ]; then
        echo "ERROR: Version required for download mode."
        echo "Usage: $0 --download <version> (e.g. 4.7)"
        exit 1
    fi

    local TAG="godot-${VERSION}-stable"
    local BASE_URL="https://raw.githubusercontent.com/godotengine/godot-cpp/${TAG}/gdextension"

    echo "Downloading from godot-cpp (${TAG})..."

    curl -L -sS "${BASE_URL}/extension_api.json" -o "${API_DIR}/extension_api.json"
    curl -L -sS "${BASE_URL}/gdextension_interface.json" -o "${API_DIR}/gdextension_interface.json"

    # godot-cpp doesn't bundle gdextension_interface.json in all versions,
    # so also download the .h file
    curl -L -sS "${BASE_URL}/gdextension_interface.h" -o "${API_DIR}/gdextension_interface.h"

    echo "API files downloaded for Godot ${VERSION}."
    echo "NOTE: These files come from godot-cpp, not from a local Godot binary."
    echo "      For exact version match, use --local mode with the target Godot installed."
}

# ------------------------------------------------------------------------
# Execute
# ------------------------------------------------------------------------
echo "=== Upgrading godot-java API files ==="
echo "Mode: ${MODE}"
echo ""

case "$MODE" in
    local)   export_from_local ;;
    download) download_from_github ;;
esac

echo ""
echo "Re-running code generator..."
./mvnw generate-sources -pl godot-java-core -q 2>/dev/null || {
    echo "Note: Maven may show compilation errors until the runtime files are updated."
    echo "      The generated files are in place — update references as needed."
}

echo ""
echo "=== Done ==="
echo "Next: review generated files and run: ./mvnw clean install -DskipTests"
