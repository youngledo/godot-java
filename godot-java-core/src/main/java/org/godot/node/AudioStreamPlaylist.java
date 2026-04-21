package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPlaylist extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_list_stream", 2739380747L), java.util.Map.entry("set_shuffle", 2586408642L),
			java.util.Map.entry("get_shuffle", 36873697L), java.util.Map.entry("get_stream_count", 3905245786L),
			java.util.Map.entry("set_list_stream", 111075094L), java.util.Map.entry("set_fade_time", 373806689L),
			java.util.Map.entry("set_stream_count", 1286410249L), java.util.Map.entry("get_fade_time", 1740695150L),
			java.util.Map.entry("has_loop", 36873697L), java.util.Map.entry("get_bpm", 1740695150L),
			java.util.Map.entry("set_loop", 2586408642L));

	AudioStreamPlaylist(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaylist(long nativePointer) {
		super(nativePointer);
	}

	public void set_list_stream(long stream_index, AudioStream audio_stream) {
		super.call("set_list_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index), (java.lang.Object) audio_stream});
	}

	public AudioStream get_list_stream(long stream_index) {
		return (AudioStream) super.call("get_list_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index)});
	}

	public boolean has_loop() {
		return (boolean) super.call("has_loop");
	}

	public boolean getShuffle() {
		return (boolean) super.call("get_shuffle", new java.lang.Object[0]);
	}

	public void setShuffle(boolean value) {
		super.call("set_shuffle", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getLoop() {
		return (boolean) super.call("has_loop", new java.lang.Object[0]);
	}

	public void setLoop(boolean value) {
		super.call("set_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFade_time() {
		return (double) super.call("get_fade_time", new java.lang.Object[0]);
	}

	public void setFade_time(double value) {
		super.call("set_fade_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getStream_count() {
		return (long) super.call("get_stream_count", new java.lang.Object[0]);
	}

	public void setStream_count(long value) {
		super.call("set_stream_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public AudioStream getStream_0() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_0(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_1() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_1(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_2() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_2(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_3() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_3(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_4() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_4(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_5() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_5(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_6() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_6(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_7() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_7(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_8() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_8(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_9() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_9(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_10() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_10(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_11() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_11(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_12() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_12(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_13() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_13(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_14() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_14(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_15() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_15(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_16() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_16(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_17() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_17(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_18() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_18(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_19() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_19(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_20() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_20(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_21() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_21(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_22() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_22(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_23() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_23(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_24() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_24(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_25() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_25(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_26() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_26(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_27() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_27(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_28() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_28(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_29() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_29(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_30() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_30(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_31() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_31(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_32() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_32(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_33() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_33(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_34() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_34(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_35() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_35(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_36() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_36(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_37() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_37(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_38() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_38(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_39() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_39(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_40() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_40(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_41() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_41(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_42() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_42(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_43() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_43(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_44() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_44(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_45() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_45(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_46() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_46(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_47() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_47(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_48() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_48(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_49() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_49(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_50() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_50(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_51() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_51(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_52() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_52(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_53() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_53(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_54() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_54(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_55() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_55(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_56() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_56(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_57() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_57(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_58() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_58(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_59() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_59(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_60() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_60(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_61() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_61(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_62() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_62(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AudioStream getStream_63() {
		return (AudioStream) super.call("get_list_stream", new java.lang.Object[0]);
	}

	public void setStream_63(AudioStream value) {
		super.call("set_list_stream", new java.lang.Object[]{(java.lang.Object) value});
	}
}
