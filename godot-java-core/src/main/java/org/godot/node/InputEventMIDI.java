package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventMIDI extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_channel", 3905245786L), java.util.Map.entry("set_pressure", 1286410249L),
			java.util.Map.entry("get_pressure", 3905245786L), java.util.Map.entry("get_controller_value", 3905245786L),
			java.util.Map.entry("get_message", 1936512097L), java.util.Map.entry("set_controller_value", 1286410249L),
			java.util.Map.entry("get_instrument", 3905245786L),
			java.util.Map.entry("set_controller_number", 1286410249L), java.util.Map.entry("set_velocity", 1286410249L),
			java.util.Map.entry("get_velocity", 3905245786L), java.util.Map.entry("get_controller_number", 3905245786L),
			java.util.Map.entry("set_channel", 1286410249L), java.util.Map.entry("set_message", 1064271510L),
			java.util.Map.entry("set_instrument", 1286410249L), java.util.Map.entry("set_pitch", 1286410249L),
			java.util.Map.entry("get_pitch", 3905245786L));

	InputEventMIDI(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventMIDI(long nativePointer) {
		super(nativePointer);
	}

	public long getChannel() {
		return (long) super.call("get_channel", new java.lang.Object[0]);
	}

	public void setChannel(long value) {
		super.call("set_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMessage() {
		return (long) super.call("get_message", new java.lang.Object[0]);
	}

	public void setMessage(long value) {
		super.call("set_message", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPitch() {
		return (long) super.call("get_pitch", new java.lang.Object[0]);
	}

	public void setPitch(long value) {
		super.call("set_pitch", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVelocity() {
		return (long) super.call("get_velocity", new java.lang.Object[0]);
	}

	public void setVelocity(long value) {
		super.call("set_velocity", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getInstrument() {
		return (long) super.call("get_instrument", new java.lang.Object[0]);
	}

	public void setInstrument(long value) {
		super.call("set_instrument", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPressure() {
		return (long) super.call("get_pressure", new java.lang.Object[0]);
	}

	public void setPressure(long value) {
		super.call("set_pressure", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getController_number() {
		return (long) super.call("get_controller_number", new java.lang.Object[0]);
	}

	public void setController_number(long value) {
		super.call("set_controller_number", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getController_value() {
		return (long) super.call("get_controller_value", new java.lang.Object[0]);
	}

	public void setController_value(long value) {
		super.call("set_controller_value", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
