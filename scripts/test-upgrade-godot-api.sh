#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORK_DIR=""

cleanup() {
    if [ -n "${WORK_DIR}" ]; then
        rm -rf "${WORK_DIR}"
    fi
}
trap cleanup EXIT

fail() {
    echo "FAIL: $*" >&2
    exit 1
}

assert_file_exists() {
    [ -f "$1" ] || fail "expected file to exist: $1"
}

assert_file_absent() {
    [ ! -e "$1" ] || fail "expected file to be absent: $1"
}

create_fixture() {
    WORK_DIR="$(mktemp -d)"
    mkdir -p "${WORK_DIR}/bin" "${WORK_DIR}/godot-api"
    cp "${ROOT_DIR}/upgrade-godot-api.sh" "${WORK_DIR}/upgrade-godot-api.sh"
    chmod +x "${WORK_DIR}/upgrade-godot-api.sh"

    printf '%s\n' '#!/usr/bin/env bash' 'echo "openjdk version \"25.0.3\"" >&2' \
        > "${WORK_DIR}/bin/java"
    chmod +x "${WORK_DIR}/bin/java"

    printf '%s\n' '#!/usr/bin/env bash' \
        'printf "%s\\n" "$*" >> "${MAVEN_CALLS}"' \
        'exit "${MAVEN_EXIT_CODE:-0}"' > "${WORK_DIR}/mvnw"
    chmod +x "${WORK_DIR}/mvnw"

    printf '%s\n' '#!/usr/bin/env bash' \
        'printf "%s\\n" "$*" >> "${CURL_CALLS}"' \
        'output=""' \
        'while [ "$#" -gt 0 ]; do' \
        '    if [ "$1" = "-o" ]; then output="$2"; shift 2; continue; fi' \
        '    shift' \
        'done' \
        'printf "{}\\n" > "${output}"' > "${WORK_DIR}/bin/curl"
    chmod +x "${WORK_DIR}/bin/curl"

    printf '%s\n' '#!/usr/bin/env bash' \
        'case "$1" in' \
        '    --version) echo "4.7.1.stable" ;;' \
        '    --dump-extension-api) printf "{}\n" > extension_api.json ;;' \
        '    --dump-gdextension-interface-json) printf "{}\n" > gdextension_interface.json ;;' \
        '    --dump-gdextension-interface) printf "// interface\n" > gdextension_interface.h ;;' \
        'esac' > "${WORK_DIR}/bin/fake-godot"
    chmod +x "${WORK_DIR}/bin/fake-godot"

    printf '%s\n' '#!/usr/bin/env bash' \
        'destination=""' \
        'while [ "$#" -gt 0 ]; do' \
        '    if [ "$1" = "-d" ]; then destination="$2"; shift 2; continue; fi' \
        '    shift' \
        'done' \
        'mkdir -p "${destination}/Godot.app/Contents/MacOS"' \
        'cp "${FAKE_GODOT_BIN}" "${destination}/Godot.app/Contents/MacOS/Godot"' \
        'chmod +x "${destination}/Godot.app/Contents/MacOS/Godot"' > "${WORK_DIR}/bin/unzip"
    chmod +x "${WORK_DIR}/bin/unzip"
}

run_upgrade() {
    local java_version="$1"
    shift
    printf '%s\n' '#!/usr/bin/env bash' "echo 'openjdk version \"${java_version}\"' >&2" \
        > "${WORK_DIR}/bin/java"
    chmod +x "${WORK_DIR}/bin/java"

    (
        cd "${WORK_DIR}"
        env -u JAVA_HOME \
            PATH="${WORK_DIR}/bin:${PATH}" \
            CURL_CALLS="${WORK_DIR}/curl-calls" \
            MAVEN_CALLS="${WORK_DIR}/maven-calls" \
            MAVEN_EXIT_CODE="${MAVEN_EXIT_CODE:-0}" \
            FAKE_GODOT_BIN="${WORK_DIR}/bin/fake-godot" \
            bash ./upgrade-godot-api.sh "$@"
    )
}

test_bare_version_uses_download_mode() {
    create_fixture
    run_upgrade 25.0.3 4.7.1
    assert_file_exists "${WORK_DIR}/curl-calls"
    grep -q 'releases/download/4.7.1-stable/Godot_v4.7.1-stable_macos.universal.zip' "${WORK_DIR}/curl-calls" \
        || fail "bare version did not download the requested official release"
    cleanup
    WORK_DIR=""
}

test_maven_failure_is_not_reported_as_success() {
    create_fixture
    MAVEN_EXIT_CODE=23
    if run_upgrade 25.0.3 --download 4.7.1; then
        fail "Maven failure was reported as success"
    fi
    cleanup
    WORK_DIR=""
}

test_java_25_is_required_before_maven() {
    create_fixture
    if run_upgrade 21.0.10 --download 4.7.1; then
        fail "Java 21 was accepted"
    fi
    assert_file_absent "${WORK_DIR}/maven-calls"
    cleanup
    WORK_DIR=""
}

test_bare_version_uses_download_mode
test_maven_failure_is_not_reported_as_success
test_java_25_is_required_before_maven

echo "PASS: upgrade-godot-api.sh"
