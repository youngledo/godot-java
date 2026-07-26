#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORKFLOW="$ROOT_DIR/.github/workflows/release.yml"
CI_WORKFLOW="$ROOT_DIR/.github/workflows/ci.yml"

fail() {
    echo "FAIL: $*" >&2
    exit 1
}

grep -q -- '-Dmaven.consumer.pom=false' "$WORKFLOW" \
    || fail "release publish command must disable Maven 4 consumer POM artifacts"

grep -q '^  release-workflow-check:$' "$CI_WORKFLOW" \
    || fail "CI must include a release workflow regression check"

grep -q 'bash scripts/test-release-workflow.sh' "$CI_WORKFLOW" \
    || fail "CI must run the release workflow regression check"

echo "PASS: release workflow disables Maven 4 consumer POM artifacts"
