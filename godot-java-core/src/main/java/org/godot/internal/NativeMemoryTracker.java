package org.godot.internal;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Tracks native memory allocations made via
 * {@link org.godot.bridge.Bridge#allocate(long)}. Provides diagnostics for
 * detecting memory leaks.
 */
public final class NativeMemoryTracker {

	private NativeMemoryTracker() {
	}

	private static final LongAdder totalAllocations = new LongAdder();
	private static final LongAdder totalBytes = new LongAdder();
	private static final AtomicLong liveAllocations = new AtomicLong();
	private static final AtomicLong liveBytes = new AtomicLong();

	public static void onAllocate(long size) {
		totalAllocations.increment();
		totalBytes.add(size);
		liveAllocations.incrementAndGet();
		liveBytes.addAndGet(size);
	}

	public static void onFree(long size) {
		liveAllocations.decrementAndGet();
		liveBytes.addAndGet(-size);
	}

	public static String getStats() {
		return String.format(
				"NativeMemoryTracker{totalAllocations=%d, totalBytes=%d, liveAllocations=%d, liveBytes=%d}",
				totalAllocations.sum(), totalBytes.sum(), liveAllocations.get(), liveBytes.get());
	}

	public static long getLiveAllocationCount() {
		return liveAllocations.get();
	}

	public static long getLiveBytes() {
		return liveBytes.get();
	}

	public static String dump() {
		return "NativeMemoryTracker{liveAllocations=" + liveAllocations.get() + ", liveBytes=" + liveBytes.get() + "}";
	}
}
