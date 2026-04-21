package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OggPacketSequence extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_packet_data", 381264803L),
			java.util.Map.entry("set_packet_granule_positions", 3709968205L),
			java.util.Map.entry("get_packet_data", 3995934104L), java.util.Map.entry("set_sampling_rate", 373806689L),
			java.util.Map.entry("get_sampling_rate", 1740695150L),
			java.util.Map.entry("get_packet_granule_positions", 235988956L),
			java.util.Map.entry("get_length", 1740695150L));

	OggPacketSequence(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OggPacketSequence(long nativePointer) {
		super(nativePointer);
	}

	public Object[] getPacket_data() {
		return (Object[]) super.call("get_packet_data", new java.lang.Object[0]);
	}

	public void setPacket_data(Object[] value) {
		super.call("set_packet_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long[] getGranule_positions() {
		return (long[]) super.call("get_packet_granule_positions", new java.lang.Object[0]);
	}

	public void setGranule_positions(long[] value) {
		super.call("set_packet_granule_positions", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSampling_rate() {
		return (double) super.call("get_sampling_rate", new java.lang.Object[0]);
	}

	public void setSampling_rate(double value) {
		super.call("set_sampling_rate", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
