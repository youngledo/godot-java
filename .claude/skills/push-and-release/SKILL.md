---
name: push-and-release
description: >
  Automate push and release workflows for the godot-java project.
  (1) "推送代码" / "push code" — push code and monitor CI only.
  (2) "发布版本" / "release version" — full release: strip SNAPSHOT, push, CI, tag, publish
  to Maven Central, update downstream repos (godot-java-template, godot-java-3d-demo,
  godot-java-demo-projects).
  Only applicable in the godot-java project directory.
---

# Push and Release

Two modes: push-only vs full release. Shared CI monitoring and failure handling.

## Mode Selection

- User says "推送代码" or "push code" → **Push mode** (Step 1 → Step 2 → done)
- User says "发布版本" or "release version" → **Release mode** (Step 0 → Step 1 → Step 2 → Step 3 → Step 4 → Step 5 → done)

## Prerequisites

- Working directory must be the godot-java project root
- `gh` CLI authenticated with push access
- Clean git working tree or user-approved changes

## Step 0: Prepare Release Version (Release mode only)

1. Read `<revision>` from `pom.xml`.
2. If it ends with `-SNAPSHOT`, strip the suffix (e.g. `0.4.1-SNAPSHOT` → `0.4.1`).
   Update `pom.xml` with the stripped version.
3. Commit: `git commit -m "Bump revision to <version>"`
4. This commit will be pushed in Step 1.

## Step 1: Push

1. Check `git status` for uncommitted changes. If dirty, ask user whether to commit.
2. `git push origin main`
3. Capture the commit SHA for CI monitoring.

## Step 2: Monitor CI

1. Find the CI run triggered by the push:
   ```
   gh run list --workflow=ci.yml --limit 1 --json databaseId,status,conclusion
   ```
2. Poll until completion (`gh run watch <id> --exit-status`).
3. **If CI succeeds**:
   - Push mode → report success, done.
   - Release mode → proceed to Step 3.
4. **If CI fails** → run `gh run view <id> --log-failed`, analyze errors, fix code,
   commit, push, and re-monitor. Repeat until CI passes.

## Step 3: Tag and Trigger Release (Release mode only)

1. Read `<revision>` from `pom.xml` — this is the release version.
2. Create and push the tag:
   ```
   git tag v<revision>
   git push origin v<revision>
   ```
3. This triggers the "Release to Maven Central" workflow.

## Step 4: Monitor Release (Release mode only)

1. Find the release run:
   ```
   gh run list --workflow=release.yml --limit 1 --json databaseId,status
   ```
2. `gh run watch <id> --exit-status` — this can take 5-10 minutes (native builds on 3 platforms).
3. **If release succeeds** → proceed to Step 5.
4. **If release fails** → check logs with `gh run view <id> --log-failed`:
   - **Sonatype validation error** ("Failed to associate file with coordinates"):
     Try `gh run rerun <id> --failed` — often a transient Sonatype issue.
   - **Build error**: Fix the issue, delete the remote tag, re-tag and push.
   - **GPG/signing error**: Check secrets configuration; may need manual intervention.
   Repeat until release passes.

## Step 5: Post-Release (Release mode only)

1. `git pull origin main` — sync the auto-bumped `-SNAPSHOT` version.
2. Verify GitHub Release exists with native artifacts:
   ```
   gh release view v<revision> --json assets --jq '.assets[].name'
   ```
3. Update downstream repositories (see below).
4. Report final status to user.

## Downstream Repositories

After a successful release, update `godot-java.version` in all downstream repos.
Each repo uses `<godot-java.version>X.Y.Z</godot-java.version>` in `pom.xml`.

| Repository | Local Path |
|---|---|
| `youngledo/godot-java-template` | (GitHub only, use API) |
| `youngledo/godot-java-3d-demo` | `~/Workspace/mine/godot-java-3d-demo` |
| `youngledo/godot-java-demo-projects` | `~/Workspace/mine/godot-java-demo-projects` |

**Local repos** — sed + git push:
```bash
cd <local-path>
sed -i '' 's/<godot-java.version>[^<]*<\/godot-java.version>/<godot-java.version>VERSION<\/godot-java.version>/' pom.xml
git add pom.xml && git commit -m "Bump godot-java to VERSION" && git push origin main
```

**GitHub-only repos** — API with proper base64:
```bash
SHA=$(gh api repos/OWNER/REPO/contents/pom.xml --jq '.sha')
CONTENT=$(gh api repos/OWNER/REPO/contents/pom.xml --jq '.content' \
  | base64 -d \
  | sed 's/<godot-java.version>[^<]*<\/godot-java.version>/<godot-java.version>VERSION<\/godot-java.version>/' \
  | base64 | tr -d '\n')
gh api repos/OWNER/REPO/contents/pom.xml -X PUT \
  -f message="Bump godot-java to VERSION" -f sha="$SHA" -f content="$CONTENT"
```

## Failure Handling Loop

For any failure (CI or release):
1. Read failed logs: `gh run view <id> --log-failed`
2. Diagnose root cause
3. Fix code or configuration
4. Commit and push (for CI fixes) or re-tag (for release fixes)
5. Re-monitor the triggered workflow
6. Repeat until success

Do NOT give up after a single failure. Keep iterating until the full pipeline succeeds or user intervention is needed (e.g., secret rotation).
