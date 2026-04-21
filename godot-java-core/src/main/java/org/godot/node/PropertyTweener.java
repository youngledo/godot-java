package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PropertyTweener extends Tweener {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_trans", 1899107404L), java.util.Map.entry("from_current", 4279177709L),
			java.util.Map.entry("set_delay", 2171559331L), java.util.Map.entry("set_ease", 1080455622L),
			java.util.Map.entry("as_relative", 4279177709L), java.util.Map.entry("from", 4190193059L),
			java.util.Map.entry("set_custom_interpolator", 3174170268L));

	PropertyTweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PropertyTweener(long nativePointer) {
		super(nativePointer);
	}

	public PropertyTweener from(Object value) {
		return (PropertyTweener) super.call("from", new java.lang.Object[]{(java.lang.Object) value});
	}

	public PropertyTweener from_current() {
		return (PropertyTweener) super.call("from_current");
	}

	public PropertyTweener as_relative() {
		return (PropertyTweener) super.call("as_relative");
	}
}
