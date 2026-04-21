#!/bin/bash
# Build script for godot-java on Linux
# Usage: ./build-linux.sh

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

# Output library name (Linux uses .so)
OUTPUT_LIB="$OUTPUT_DIR/libgodot-java.so"

echo "Building godot-java for Linux..."
echo "JAVA_HOME: $JAVA_HOME"
echo "Output: $OUTPUT_LIB"

# Detect architecture
ARCH=$(uname -m)
if [ "$ARCH" = "x86_64" ]; then
    ARCH_FLAGS="-march=x86-64"
elif [ "$ARCH" = "aarch64" ]; then
    ARCH_FLAGS="-march=armv8-a"
else
    ARCH_FLAGS=""
fi

# Compile command for Linux
# Note: Linux uses libjvm.so in the JDK
clang++ -shared -fPIC -o "$OUTPUT_LIB" \
    -I "$JAVA_HOME/include" \
    -I "$JAVA_HOME/include/linux" \
    -std=c++17 \
    -fvisibility=hidden \
    -fPIC \
    $ARCH_FLAGS \
    -O2 \
    "$SCRIPT_DIR/src/godot_java.cpp"

if [ -f "$OUTPUT_LIB" ]; then
    echo "Build successful: $OUTPUT_LIB"

    # Deploy to shared-native (examples use symlinks)
    SHARED_NATIVE="$SCRIPT_DIR/../../godot-java-examples/examples/shared-native"
    mkdir -p "$SHARED_NATIVE"
    cp "$OUTPUT_LIB" "$SHARED_NATIVE/"
    echo "Deployed to shared-native/"
else
    echo "Build failed!"
    exit 1
fi