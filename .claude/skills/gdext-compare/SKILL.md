---
name: gdext-compare
description: Compare godot-java feature parity against gdext (godot-rust/gdext). Use when the user asks to check parity, compare features, verify alignment, or audit gaps between godot-java and gdext. Also use when the user says "对比gdext", "检查parity", "还有什么差距", or similar comparison requests.
---

# gdext Compare

Compare godot-java features against gdext (godot-rust/gdext) by directly reading gdext source from GitHub.

## Key gdext Source Locations

When comparing, read these gdext source files directly via `mcp__zread__read_file`:

| Feature Area | gdext Source Path |
|---|---|
| Class registration attributes | `godot-derive/src/derive_godot_class.rs` |
| Export/property system | `godot-derive/src/property_attributes.rs` |
| Signal declarations | `godot-derive/src/signal.rs` |
| Virtual method dispatch | `godot-derive/src/virtual_methods.rs` |
| GodotClass attribute spec | `godot-derive/src/lib.rs` |
| Class registration runtime | `godot-core/src/obj/godot_class.rs` |
| Signal runtime | `godot-core/src/builtin/signal.rs` |
| Callable | `godot-core/src/builtin/callable.rs` |
| Array/Dictionary | `godot-core/src/builtin/collections/` |
| Init level lifecycle | `godot-core/src/init/` |
| Code generation | `godot-codegen/src/` |
| RPC | `godot-derive/src/rpc.rs` |
| PackedArray types | `godot-core/src/builtin/packed_array.rs` |

## Workflow

1. **Load baseline**: Read `docs/gdext_parity.md` in the project root. If not found, start empty.

2. **Check gdext source**: Use `mcp__zread__read_file` with `repoName: "godot-rust/gdext"` to read the relevant gdext source files listed above. Focus on areas that changed since last comparison.

3. **Check gdext structure for new features**: Use `mcp__zread__get_repo_structure` on `godot-rust/gdext` to spot new directories or files that may indicate new features.

4. **Check godot-java changes**: Use `git log --oneline` since last comparison date to find new commits.

5. **Compare feature by feature**: For each area in `references/parity-checklist.md`:
   - Read the gdext source file for that area
   - Read the corresponding godot-java source file
   - Determine ALIGNED, PARTIAL, GAP, or JAVA-ONLY

6. **Report** in this format:
   ```
   ## Newly Aligned (since YYYY-MM-DD)
   - [area]: [brief description] ✓

   ## New Gaps (found in gdext but not in godot-java)
   - [area]: [what gdext has] → [what's missing]

   ## Unchanged Gaps
   - [area]: [status from baseline, still valid]

   ## Java-Only Advantages
   - [feature]: [description]
   ```

7. **Update parity file**: Write updated `docs/gdext_parity.md` with new comparison date, new aligned items, and revised gap list.

## References

- `references/parity-checklist.md` — Full feature checklist covering 12 areas with ~70 items
