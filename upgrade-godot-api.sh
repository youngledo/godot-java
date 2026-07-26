#!/bin/bash
# Upgrade Godot API files and regenerate binding code.
#
# Modes:
#   ./upgrade-godot-api.sh                  # Auto-detect: local Godot binary, fallback to download
#   ./upgrade-godot-api.sh 4.7.1            # Download the requested Godot version
#   ./upgrade-godot-api.sh --local          # Force local Godot binary export
#   ./upgrade-godot-api.sh --download 4.7   # Download a Godot release and export its API
#
# Official Godot workflow:
#   godot --headless --dump-extension-api              → extension_api.json
#   godot --headless --dump-gdextension-interface      → gdextension_interface.h
#   godot --headless --dump-gdextension-interface-json → gdextension_interface.json

set -euo pipefail

API_DIR="${API_DIR:-godot-api}"
MAVEN_WRAPPER="${MAVEN_WRAPPER:-./mvnw}"
JAVA_CMD="${JAVA_CMD:-java}"
MODE=""
VERSION=""
DOWNLOAD_DIR=""

error() {
    echo "ERROR: $*" >&2
    exit 1
}

cleanup_download() {
    if [ -n "${DOWNLOAD_DIR}" ]; then
        rm -rf "${DOWNLOAD_DIR}"
    fi
}
trap cleanup_download EXIT

find_local_godot() {
    if [ -n "${GODOT_BIN:-}" ]; then
        [ -x "${GODOT_BIN}" ] || error "GODOT_BIN is not executable: ${GODOT_BIN}"
        echo "${GODOT_BIN}"
    elif [ -x "/Applications/Godot.app/Contents/MacOS/Godot" ]; then
        echo "/Applications/Godot.app/Contents/MacOS/Godot"
    elif command -v godot >/dev/null 2>&1; then
        command -v godot
    else
        return 1
    fi
}

parse_arguments() {
    for arg in "$@"; do
        case "$arg" in
            --local)    MODE="local" ;;
            --download) MODE="download" ;;
            --*)        error "Unknown option: $arg" ;;
            *)
                [ -z "${VERSION}" ] || error "Only one Godot version may be specified."
                VERSION="$arg"
                ;;
        esac
    done

    if [ "${MODE}" = "local" ] && [ -n "${VERSION}" ]; then
        error "--local exports the installed Godot version; do not specify a version."
    fi
}

select_mode() {
    if [ -n "${MODE}" ]; then
        return
    fi

    if [ -n "${VERSION}" ]; then
        MODE="download"
        echo "Version ${VERSION} requested, using download mode."
    elif find_local_godot >/dev/null; then
        MODE="local"
        echo "Found local Godot, using local export mode."
    else
        MODE="download"
        echo "No local Godot found, using download mode."
    fi
}

require_java_25() {
    local java_bin="${JAVA_CMD}"
    local java_version
    local java_major

    if [ -n "${JAVA_HOME:-}" ]; then
        java_bin="${JAVA_HOME}/bin/java"
    fi

    [ -x "${java_bin}" ] || command -v "${java_bin}" >/dev/null 2>&1 \
        || error "Java executable not found: ${java_bin}"

    java_version="$("${java_bin}" -version 2>&1)" \
        || error "Unable to determine the Java version from ${java_bin}"
    if [[ "${java_version}" =~ version[[:space:]]+\"([0-9]+) ]]; then
        java_major="${BASH_REMATCH[1]}"
    else
        error "Unable to determine the Java major version from: ${java_version}"
    fi

    if [ "${java_major}" -lt 25 ]; then
        error "Java 25 or newer is required; found Java ${java_major}. Set JAVA_HOME to a JDK 25+ installation."
    fi
}

mkdir -p "${API_DIR}"

# ------------------------------------------------------------------------
# Local mode: export from installed Godot binary (official recommended way)
# ------------------------------------------------------------------------
export_api_files() {
    local godot_bin="$1"
    local godot_version
    godot_version="$("${godot_bin}" --version 2>/dev/null || echo "unknown")"
    echo "Using Godot binary: ${godot_bin} (${godot_version})"

    # Export all 3 files (official commands)
    echo "Exporting extension_api.json..."
    (cd "${API_DIR}" && "${godot_bin}" --headless --dump-extension-api 2>/dev/null)

    echo "Exporting gdextension_interface.h..."
    (cd "${API_DIR}" && "${godot_bin}" --headless --dump-gdextension-interface 2>/dev/null)

    echo "Exporting gdextension_interface.json..."
    (cd "${API_DIR}" && "${godot_bin}" --headless --dump-gdextension-interface-json 2>/dev/null)

    echo "All 3 API files exported from Godot ${godot_version}."
}

export_from_local() {
    local godot_bin
    godot_bin="$(find_local_godot)" || error "No Godot binary found. Install Godot or use: $0 --download <version>"
    export_api_files "${godot_bin}"
}

# ------------------------------------------------------------------------
# Download mode: fetch an official Godot release and export its API
# ------------------------------------------------------------------------
release_asset_name() {
    local system
    local architecture

    system="$(uname -s)"
    architecture="$(uname -m)"
    case "${system}" in
        Darwin)
            echo "Godot_v${VERSION}-stable_macos.universal.zip"
            ;;
        Linux)
            case "${architecture}" in
                x86_64) echo "Godot_v${VERSION}-stable_linux.x86_64.zip" ;;
                aarch64|arm64) echo "Godot_v${VERSION}-stable_linux.arm64.zip" ;;
                armv7l|armv6l) echo "Godot_v${VERSION}-stable_linux.arm32.zip" ;;
                *) error "Unsupported Linux architecture: ${architecture}. Use --local with an installed Godot binary." ;;
            esac
            ;;
        *) error "Unsupported operating system: ${system}. Use --local with an installed Godot binary." ;;
    esac
}

download_from_release() {
    if [ -z "$VERSION" ]; then
        echo "ERROR: Version required for download mode."
        echo "Usage: $0 --download <version> (e.g. 4.7)"
        exit 1
    fi

    command -v unzip >/dev/null 2>&1 || error "unzip is required to extract a downloaded Godot release."

    local asset_name
    local archive
    local godot_bin
    asset_name="$(release_asset_name)"
    DOWNLOAD_DIR="$(mktemp -d)" || error "Unable to create a temporary directory."
    archive="${DOWNLOAD_DIR}/${asset_name}"

    echo "Downloading official Godot release ${VERSION} (${asset_name})..."
    curl --fail --location --silent --show-error \
        "https://github.com/godotengine/godot/releases/download/${VERSION}-stable/${asset_name}" \
        -o "${archive}"

    unzip -q "${archive}" -d "${DOWNLOAD_DIR}/extracted"
    godot_bin="$(find "${DOWNLOAD_DIR}/extracted" -type f -name 'Godot*' -perm -u+x -print -quit)"
    [ -n "${godot_bin}" ] || error "Downloaded release did not contain an executable Godot binary."

    export_api_files "${godot_bin}"
}

run_codegen() {
    require_java_25

    [ -x "${MAVEN_WRAPPER}" ] || error "Maven Wrapper is not executable: ${MAVEN_WRAPPER}"

    echo "Installing code generator..."
    "${MAVEN_WRAPPER}" install -pl godot-java-code-generator -DskipTests -q

    echo "Re-running code generator..."
    "${MAVEN_WRAPPER}" generate-sources -pl godot-java-core -Dcodegen.force=true -q
}

# ------------------------------------------------------------------------
# Execute
# ------------------------------------------------------------------------
parse_arguments "$@"
select_mode

echo "=== Upgrading godot-java API files ==="
echo "Mode: ${MODE}"
echo ""

case "$MODE" in
    local)   export_from_local ;;
    download) download_from_release ;;
esac

echo ""
run_codegen

echo ""
echo "=== Done ==="
echo "Next: review generated files and run: ./mvnw clean install -DskipTests"
