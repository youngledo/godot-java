package org.godot.benchmarks;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks for Panama FFI overhead in the godot-java bridge.
 *
 * These benchmarks measure the Java-side cost of FFI infrastructure
 * (ScopedValue binding, arena allocation, MethodHandle invocation) without
 * requiring a running Godot instance.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class FfiCallBenchmark {

	// Simulates Bridge's ScopeContext for scoped arena management
	private static final ScopedValue<Arena> SCOPE_ARENA = ScopedValue.newInstance();

	// Simulates Bridge's call frame pre-allocation
	private static final int VARIANT_SIZE = 24;
	private static final int MAX_ARGS = 16;
	private static final long FRAME_SIZE = (long) MAX_ARGS * VARIANT_SIZE + VARIANT_SIZE + 16 + (long) MAX_ARGS * 8;
	private Arena sharedArena;
	private MemorySegment callFrames;

	// Simulates a trivial native function (strlen-like) for baseline FFI cost
	private MethodHandle identityLong;

	@Setup
	public void setup() throws Throwable {
		sharedArena = Arena.ofShared();
		callFrames = sharedArena.allocate(FRAME_SIZE, 8);

		// Use Linker.nativeLinker() to get a real native function for baseline.
		// We use the C library's abs() function (available on all platforms)
		// as a minimal FFI target — it takes and returns a single long/int.
		Linker linker = Linker.nativeLinker();
		try {
			// On most platforms, "abs" is available in libc
			MemorySegment absAddr = linker.defaultLookup().find("abs").orElse(MemorySegment.ofAddress(0));
			if (absAddr.address() != 0) {
				identityLong = linker.downcallHandle(absAddr, FunctionDescriptor
						.of(java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_INT));
			}
		} catch (Exception e) {
			// Fallback: use a pure-Java MethodHandle to simulate FFI overhead
			identityLong = MethodHandles.lookup().findStatic(FfiCallBenchmark.class, "javaAbs",
					MethodType.methodType(int.class, int.class));
		}
	}

	private static int javaAbs(int val) {
		return Math.abs(val);
	}

	/**
	 * Baseline: ScopedValue binding cost (simulates Bridge.runScoped). Measures the
	 * overhead of binding a ScopedValue and executing a lambda.
	 */
	@Benchmark
	public long scopedValueBinding() {
		AtomicLong result = new AtomicLong(0);
		ScopedValue.where(SCOPE_ARENA, sharedArena).run(() -> {
			Arena arena = SCOPE_ARENA.get();
			result.set(arena.allocate(8, 8).address());
		});
		return result.get();
	}

	/**
	 * Baseline: ScopedValue binding with nested depth (simulates re-entrant calls).
	 */
	@Benchmark
	public int scopedValueNestedBinding() {
		AtomicReference<Integer> depth = new AtomicReference<>(0);
		ScopedValue.where(SCOPE_ARENA, sharedArena).run(() -> {
			ScopedValue.where(SCOPE_ARENA, sharedArena).run(() -> {
				depth.set(2);
			});
		});
		return depth.get();
	}

	/**
	 * Measures pre-allocated call frame access (argSlot, resultSlot, errorSlot).
	 * This simulates the hot path in Bridge where arguments are written to
	 * pre-allocated memory instead of allocating per-call.
	 */
	@Benchmark
	public long preAllocatedFrameAccess() {
		// Simulate writing 4 args + reading result slot
		MemorySegment arg0 = callFrames.asSlice(0, VARIANT_SIZE);
		MemorySegment arg1 = callFrames.asSlice(VARIANT_SIZE, VARIANT_SIZE);
		MemorySegment arg2 = callFrames.asSlice(2 * VARIANT_SIZE, VARIANT_SIZE);
		MemorySegment arg3 = callFrames.asSlice(3 * VARIANT_SIZE, VARIANT_SIZE);
		MemorySegment result = callFrames.asSlice((long) MAX_ARGS * VARIANT_SIZE, VARIANT_SIZE);

		arg0.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 42L);
		arg1.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 43L);
		arg2.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 44L);
		arg3.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 45L);

		return result.address();
	}

	/**
	 * Measures MethodHandle.invokeExact with a simple int->int function. This is
	 * the baseline FFI call cost through Panama.
	 */
	@Benchmark
	public int methodHandleInvoke() throws Throwable {
		return (int) identityLong.invokeExact(42);
	}

	/**
	 * Measures Arena.ofShared() creation + close cost (simulates top-level call
	 * scope).
	 */
	@Benchmark
	public long sharedArenaCreateAndClose() {
		Arena arena = Arena.ofShared();
		MemorySegment seg = arena.allocate(64, 8);
		seg.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 123L);
		long val = seg.get(java.lang.foreign.ValueLayout.JAVA_LONG, 0);
		arena.close();
		return val;
	}

	/**
	 * Measures allocation from an existing shared arena (simulates nested call
	 * scope).
	 */
	@Benchmark
	public long sharedArenaAllocate() {
		MemorySegment seg = sharedArena.allocate(64, 8);
		seg.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 456L);
		return seg.get(java.lang.foreign.ValueLayout.JAVA_LONG, 0);
	}

	/**
	 * Measures the full runScoped flow: create arena, bind ScopedValue, allocate,
	 * read, close arena.
	 */
	@Benchmark
	public long fullRunScopedFlow() {
		return runScoped(() -> {
			Arena arena = SCOPE_ARENA.get();
			MemorySegment seg = arena.allocate(24, 8);
			seg.set(java.lang.foreign.ValueLayout.JAVA_LONG, 0, 789L);
			return seg.get(java.lang.foreign.ValueLayout.JAVA_LONG, 0);
		});
	}

	private static <T> T runScoped(Callable<T> action) {
		Arena scope = Arena.ofShared();
		try {
			return ScopedValue.where(SCOPE_ARENA, scope).call(action::call);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			scope.close();
		}
	}
}
