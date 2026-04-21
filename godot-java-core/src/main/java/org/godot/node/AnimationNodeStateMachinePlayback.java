package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeStateMachinePlayback extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("next", 3218959716L), java.util.Map.entry("get_current_play_position", 1740695150L),
			java.util.Map.entry("get_fading_from_length", 1740695150L), java.util.Map.entry("start", 3823612587L),
			java.util.Map.entry("get_current_length", 1740695150L),
			java.util.Map.entry("get_fading_from_play_position", 1740695150L),
			java.util.Map.entry("get_travel_path", 3995934104L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("get_fading_length", 1740695150L), java.util.Map.entry("is_playing", 36873697L),
			java.util.Map.entry("get_fading_from_node", 2002593661L),
			java.util.Map.entry("get_fading_position", 1740695150L),
			java.util.Map.entry("get_current_node", 2002593661L), java.util.Map.entry("travel", 3823612587L));

	AnimationNodeStateMachinePlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeStateMachinePlayback(long nativePointer) {
		super(nativePointer);
	}

	public void travel(String to_node, boolean reset_on_teleport) {
		super.call("travel",
				new java.lang.Object[]{(java.lang.Object) to_node, java.lang.Boolean.valueOf(reset_on_teleport)});
	}

	public void start(String node, boolean reset) {
		super.call("start", new java.lang.Object[]{(java.lang.Object) node, java.lang.Boolean.valueOf(reset)});
	}

	public void next() {
		super.call("next");
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}
}
