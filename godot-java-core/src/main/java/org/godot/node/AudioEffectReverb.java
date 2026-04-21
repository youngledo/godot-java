package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectReverb extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_damping", 1740695150L), java.util.Map.entry("get_predelay_msec", 1740695150L),
			java.util.Map.entry("set_spread", 373806689L), java.util.Map.entry("get_dry", 1740695150L),
			java.util.Map.entry("get_predelay_feedback", 1740695150L),
			java.util.Map.entry("get_room_size", 1740695150L), java.util.Map.entry("set_damping", 373806689L),
			java.util.Map.entry("set_hpf", 373806689L), java.util.Map.entry("set_predelay_msec", 373806689L),
			java.util.Map.entry("get_wet", 1740695150L), java.util.Map.entry("set_predelay_feedback", 373806689L),
			java.util.Map.entry("set_dry", 373806689L), java.util.Map.entry("set_room_size", 373806689L),
			java.util.Map.entry("set_wet", 373806689L), java.util.Map.entry("get_spread", 1740695150L),
			java.util.Map.entry("get_hpf", 1740695150L));

	AudioEffectReverb(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectReverb(long nativePointer) {
		super(nativePointer);
	}

	public double getPredelay_msec() {
		return (double) super.call("get_predelay_msec", new java.lang.Object[0]);
	}

	public void setPredelay_msec(double value) {
		super.call("set_predelay_msec", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPredelay_feedback() {
		return (double) super.call("get_predelay_feedback", new java.lang.Object[0]);
	}

	public void setPredelay_feedback(double value) {
		super.call("set_predelay_feedback", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRoom_size() {
		return (double) super.call("get_room_size", new java.lang.Object[0]);
	}

	public void setRoom_size(double value) {
		super.call("set_room_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping() {
		return (double) super.call("get_damping", new java.lang.Object[0]);
	}

	public void setDamping(double value) {
		super.call("set_damping", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpread() {
		return (double) super.call("get_spread", new java.lang.Object[0]);
	}

	public void setSpread(double value) {
		super.call("set_spread", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHipass() {
		return (double) super.call("get_hpf", new java.lang.Object[0]);
	}

	public void setHipass(double value) {
		super.call("set_hpf", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDry() {
		return (double) super.call("get_dry", new java.lang.Object[0]);
	}

	public void setDry(double value) {
		super.call("set_dry", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWet() {
		return (double) super.call("get_wet", new java.lang.Object[0]);
	}

	public void setWet(double value) {
		super.call("set_wet", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
