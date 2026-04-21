#!/bin/bash
# Build script for godot-java on macOS
# Usage: ./build-macos.sh

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Check JAVA_HOME
if [ -z "$JAVA_HOME" ]; then
    echo "ERROR: JAVA_HOME not set. Please set it to your JDK installation."
    exit 1
fi

# Output directory
OUTPUT_DIR="$SCRIPT_DIR/build"
mkdir -p "$OUTPUT_DIR"

# Output library name (macOS uses .dylib)
OUTPUT_LIB="$OUTPUT_DIR/libgodot-java.dylib"

echo "Building godot-java for macOS..."
echo "JAVA_HOME: $JAVA_HOME"
echo "Output: $OUTPUT_LIB"

# Compile command for macOS
# Note: macOS bundles libjvm.dylib in the JDK
clang++ -shared -fPIC -o "$OUTPUT_LIB" \
    -I "$JAVA_HOME/include" \
    -I "$JAVA_HOME/include/darwin" \
    -std=c++17 \
    -stdlib=libc++ \
    -mmacosx-version-min=10.15 \
    -arch x86_64 -arch arm64 \
    -fvisibility=hidden \
    -O2 \
    "$SCRIPT_DIR/src/godot_java.cpp"

if [ -f "$OUTPUT_LIB" ]; then
    echo "Build successful: $OUTPUT_LIB"

    # Re-sign the dylib (macOS requires valid code signature for loaded libraries)
    codesign --force --sign - "$OUTPUT_LIB" 2>/dev/null && echo "Code signed" || echo "Warning: codesign failed (may cause macOS SIGKILL)"

    # Deploy to shared-native (examples use symlinks)
    SHARED_NATIVE="$SCRIPT_DIR/../../godot-java-examples/examples/shared-native"
    mkdir -p "$SHARED_NATIVE"
    cp "$OUTPUT_LIB" "$SHARED_NATIVE/"
    echo "Deployed to shared-native/"
else
    echo "Build failed!"
    exit 1
fi