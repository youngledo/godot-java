package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3i;

public class GridMapEditorPlugin extends EditorPlugin {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_selection", 3659408297L), java.util.Map.entry("clear_selection", 3218959716L),
			java.util.Map.entry("has_selection", 36873697L), java.util.Map.entry("get_current_grid_map", 1184264483L),
			java.util.Map.entry("get_selection", 1068685055L),
			java.util.Map.entry("get_selected_palette_item", 3905245786L),
			java.util.Map.entry("get_selected_cells", 3995934104L),
			java.util.Map.entry("set_selected_palette_item", 998575451L));

	GridMapEditorPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GridMapEditorPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void set_selection(Vector3i begin, Vector3i end) {
		super.call("set_selection", new java.lang.Object[]{(java.lang.Object) begin, (java.lang.Object) end});
	}

	public void clear_selection() {
		super.call("clear_selection");
	}

	public boolean has_selection() {
		return (boolean) super.call("has_selection");
	}
}
