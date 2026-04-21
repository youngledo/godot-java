package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;
import org.godot.core.RefCounted;

public class EditorContextMenuPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_context_menu_item_from_shortcut", 3799546916L),
			java.util.Map.entry("add_menu_shortcut", 851596305L),
			java.util.Map.entry("add_context_submenu_item", 1994674995L),
			java.util.Map.entry("add_context_menu_item", 2748336951L));

	EditorContextMenuPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorContextMenuPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void add_menu_shortcut(Shortcut shortcut, Callable callback) {
		super.call("add_menu_shortcut",
				new java.lang.Object[]{(java.lang.Object) shortcut, (java.lang.Object) callback});
	}

	public void add_context_menu_item(String name, Callable callback, Texture2D icon) {
		super.call("add_context_menu_item",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) callback, (java.lang.Object) icon});
	}

	public void add_context_menu_item_from_shortcut(String name, Shortcut shortcut, Texture2D icon) {
		super.call("add_context_menu_item_from_shortcut",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) shortcut, (java.lang.Object) icon});
	}

	public void add_context_submenu_item(String name, PopupMenu menu, Texture2D icon) {
		super.call("add_context_submenu_item",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) menu, (java.lang.Object) icon});
	}
}
