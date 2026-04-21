package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RandomNumberGenerator extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("randi", 2455072627L), java.util.Map.entry("set_seed", 1286410249L),
			java.util.Map.entry("get_state", 3905245786L), java.util.Map.entry("randf", 191475506L),
			java.util.Map.entry("randi_range", 50157827L), java.util.Map.entry("set_state", 1286410249L),
			java.util.Map.entry("get_seed", 2455072627L), java.util.Map.entry("randf_range", 4269894367L),
			java.util.Map.entry("rand_weighted", 4189642986L), java.util.Map.entry("randomize", 3218959716L),
			java.util.Map.entry("randfn", 837325100L));

	RandomNumberGenerator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RandomNumberGenerator(long nativePointer) {
		super(nativePointer);
	}

	public long randi() {
		return (long) super.call("randi");
	}

	public double randf() {
		return (double) super.call("randf");
	}

	public double randfn(double mean, double deviation) {
		return (double) super.call("randfn",
				new java.lang.Object[]{java.lang.Double.valueOf(mean), java.lang.Double.valueOf(deviation)});
	}

	public double randf_range(double from, double to) {
		return (double) super.call("randf_range",
				new java.lang.Object[]{java.lang.Double.valueOf(from), java.lang.Double.valueOf(to)});
	}

	public int randi_range(long from, long to) {
		return (int) super.call("randi_range",
				new java.lang.Object[]{java.lang.Long.valueOf(from), java.lang.Long.valueOf(to)});
	}

	public long rand_weighted(double[] weights) {
		return (long) super.call("rand_weighted", new java.lang.Object[]{(java.lang.Object) weights});
	}

	public void randomize() {
		super.call("randomize");
	}

	public long getSeed() {
		return (long) super.call("get_seed", new java.lang.Object[0]);
	}

	public void setSeed(long value) {
		super.call("set_seed", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getState() {
		return (long) super.call("get_state", new java.lang.Object[0]);
	}

	public void setState(long value) {
		super.call("set_state", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
