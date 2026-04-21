package org.godot.benchmark;

import org.godot.Godot;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Micro-benchmarks for dispatch overhead in the Godot Java binding.
 *
 * Measures three critical paths:
 * <ol>
 * <li>MethodHandle vs Reflection dispatch for virtual method calls</li>
 * <li>HashMap lookup (per-class) vs global fallback for method name
 * resolution</li>
 * <li>Variant conversion (fromObject) type-dispatch overhead</li>
 * </ol>
 *
 * Run manually via IDE or {@code mvn test -Dtest=DispatchBenchmarkTest}.
 * Annotated {@code @Disabled} so CI skips it automatically.
 */
@Disabled("Manual benchmark -- run in IDE or with -Dtest=DispatchBenchmarkTest")
class DispatchBenchmarkTest {

	// -----------------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------------

	private static final int WARMUP_ITERATIONS = 10_000;
	private static final int MEASURE_ITERATIONS = 100_000;

	// -----------------------------------------------------------------------
	// Mock test node (does not require native Godot runtime)
	// -----------------------------------------------------------------------

	/**
	 * Minimal concrete subclass of Godot for benchmarking virtual dispatch. Uses
	 * nativeObject=0 so no native calls are made.
	 */
	private static class BenchNode extends Godot {
		BenchNode() {
			super(0L);
		}

		@Override
		public void _process(double delta) {
			// intentionally empty -- measuring dispatch overhead, not workload
		}

		@Override
		public void _ready() {
			// intentionally empty
		}
	}

	// =======================================================================
	// Benchmark 1: MethodHandle vs Reflection dispatch
	// =======================================================================

	@Test
	void benchmarkMethodHandleVsReflection() throws Throwable {
		BenchNode node = new BenchNode();
		double delta = 1.0 / 60.0;

		// --- Set up MethodHandle for _process(double) ---
		Method processMethod = Godot.class.getDeclaredMethod("_process", double.class);
		processMethod.setAccessible(true);

		// Unreflect and adapt to accept Godot as receiver, Object... for args is NOT
		// needed here; we want the exact-typed handle for maximum throughput.
		MethodHandle processHandle = MethodHandles.lookup().unreflect(processMethod)
				.asType(MethodType.methodType(void.class, Godot.class, double.class));

		// --- Warmup all three paths ---
		for (int i = 0; i < WARMUP_ITERATIONS; i++) {
			node._process(delta); // direct virtual
			processHandle.invoke(node, delta); // MethodHandle
			processMethod.invoke(node, delta); // reflection
		}

		// --- Measure: direct virtual call ---
		long directStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			node._process(delta);
		}
		long directNanos = System.nanoTime() - directStart;

		// --- Measure: MethodHandle dispatch ---
		long mhStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			processHandle.invoke(node, delta);
		}
		long mhNanos = System.nanoTime() - mhStart;

		// --- Measure: Reflection dispatch ---
		long reflStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			processMethod.invoke(node, delta);
		}
		long reflNanos = System.nanoTime() - reflStart;

		// --- Also benchmark _ready() (void, no args) for comparison ---
		Method readyMethod = Godot.class.getDeclaredMethod("_ready");
		readyMethod.setAccessible(true);
		MethodHandle readyHandle = MethodHandles.lookup().unreflect(readyMethod)
				.asType(MethodType.methodType(void.class, Godot.class));

		for (int i = 0; i < WARMUP_ITERATIONS; i++) {
			node._ready();
			readyHandle.invoke(node);
			readyMethod.invoke(node);
		}

		long directReadyStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			node._ready();
		}
		long directReadyNanos = System.nanoTime() - directReadyStart;

		long mhReadyStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			readyHandle.invoke(node);
		}
		long mhReadyNanos = System.nanoTime() - mhReadyStart;

		long reflReadyStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			readyMethod.invoke(node);
		}
		long reflReadyNanos = System.nanoTime() - reflReadyStart;

		// --- Report ---
		printSeparator();
		System.out.println("DISPATCH BENCHMARK: MethodHandle vs Reflection");
		printSeparator();
		printRow("Test", "Total (ms)", "Per-call (ns)");
		printSeparator();
		printRow("_process() direct virtual", nsToMs(directNanos), nsPerCall(directNanos));
		printRow("_process() MethodHandle", nsToMs(mhNanos), nsPerCall(mhNanos));
		printRow("_process() Method.invoke()", nsToMs(reflNanos), nsPerCall(reflNanos));
		printSeparator();
		printRow("_ready() direct virtual", nsToMs(directReadyNanos), nsPerCall(directReadyNanos));
		printRow("_ready() MethodHandle", nsToMs(mhReadyNanos), nsPerCall(mhReadyNanos));
		printRow("_ready() Method.invoke()", nsToMs(reflReadyNanos), nsPerCall(reflReadyNanos));
		printSeparator();
		System.out.printf("  MethodHandle overhead vs direct (_process): %.2fx%n", ratio(mhNanos, directNanos));
		System.out.printf("  Reflection overhead vs direct (_process):   %.2fx%n", ratio(reflNanos, directNanos));
		System.out.printf("  MethodHandle overhead vs direct (_ready):   %.2fx%n",
				ratio(mhReadyNanos, directReadyNanos));
		System.out.printf("  Reflection overhead vs direct (_ready):     %.2fx%n",
				ratio(reflReadyNanos, directReadyNanos));
		printSeparator();
	}

	// =======================================================================
	// Benchmark 2: HashMap lookup -- small vs large map
	// =======================================================================

	@Test
	void benchmarkHashMapLookup() {
		// Build a small map simulating per-class method dispatch (5 entries)
		Map<String, Long> smallMap = new HashMap<>();
		smallMap.put("_process", 100L);
		smallMap.put("_ready", 101L);
		smallMap.put("_enterTree", 102L);
		smallMap.put("_exitTree", 103L);
		smallMap.put("_physicsProcess", 104L);

		// Build a large map simulating a global fallback (500 entries)
		Map<String, Long> largeMap = new HashMap<>(600);
		for (int i = 0; i < 500; i++) {
			largeMap.put("method_" + i, (long) i);
		}
		// Ensure the lookup keys exist in the large map too
		largeMap.put("_process", 100L);
		largeMap.put("_ready", 101L);
		largeMap.put("_enterTree", 102L);
		largeMap.put("_exitTree", 103L);
		largeMap.put("_physicsProcess", 104L);

		// Lookup keys -- mix of hits and a miss
		String[] lookupKeys = {"_process", "_ready", "_physicsProcess", "_enterTree", "_exitTree",
				"nonexistent_method"};

		// --- Warmup ---
		for (int i = 0; i < WARMUP_ITERATIONS; i++) {
			for (String key : lookupKeys) {
				smallMap.get(key);
				largeMap.get(key);
			}
		}

		// --- Measure small map ---
		long smallStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			for (String key : lookupKeys) {
				smallMap.get(key);
			}
		}
		long smallNanos = System.nanoTime() - smallStart;

		// --- Measure large map ---
		long largeStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			for (String key : lookupKeys) {
				largeMap.get(key);
			}
		}
		long largeNanos = System.nanoTime() - largeStart;

		// --- Measure single-key hit only (best case for small map) ---
		long singleSmallStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			smallMap.get("_process");
		}
		long singleSmallNanos = System.nanoTime() - singleSmallStart;

		// --- Measure single-key hit only (best case for large map) ---
		long singleLargeStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			largeMap.get("_process");
		}
		long singleLargeNanos = System.nanoTime() - singleLargeStart;

		// --- Measure containsKey (common alternative pattern) ---
		long containsSmallStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			smallMap.containsKey("_process");
		}
		long containsSmallNanos = System.nanoTime() - containsSmallStart;

		long containsLargeStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			largeMap.containsKey("_process");
		}
		long containsLargeNanos = System.nanoTime() - containsLargeStart;

		// --- Report ---
		int batchSize = lookupKeys.length;
		printSeparator();
		System.out.println("LOOKUP BENCHMARK: HashMap small (5) vs large (500)");
		printSeparator();
		printRow("Test", "Total (ms)", "Per-lookup (ns)");
		printSeparator();
		printRow("Small map 6-key batch", nsToMs(smallNanos), nsPerCall(smallNanos, MEASURE_ITERATIONS * batchSize));
		printRow("Large map 6-key batch", nsToMs(largeNanos), nsPerCall(largeNanos, MEASURE_ITERATIONS * batchSize));
		printSeparator();
		printRow("Small map single hit", nsToMs(singleSmallNanos), nsPerCall(singleSmallNanos));
		printRow("Large map single hit", nsToMs(singleLargeNanos), nsPerCall(singleLargeNanos));
		printSeparator();
		printRow("Small map containsKey", nsToMs(containsSmallNanos), nsPerCall(containsSmallNanos));
		printRow("Large map containsKey", nsToMs(containsLargeNanos), nsPerCall(containsLargeNanos));
		printSeparator();
		System.out.printf("  Large/small ratio (batch):     %.2fx%n", ratio(largeNanos, smallNanos));
		System.out.printf("  Large/small ratio (single):    %.2fx%n", ratio(singleLargeNanos, singleSmallNanos));
		System.out.printf("  Large/small ratio (contains):  %.2fx%n", ratio(containsLargeNanos, containsSmallNanos));
		printSeparator();
	}

	// =======================================================================
	// Benchmark 3: Variant conversion type-dispatch overhead
	// =======================================================================

	/**
	 * Since VariantUtils.fromObject() requires the native Bridge, this benchmark
	 * measures the Java-side instanceof chain overhead in isolation. This is the
	 * dispatch cost that dominates when the native runtime IS loaded.
	 *
	 * <p>
	 * We also measure boxing overhead (int->Integer, double->Double) since
	 * fromObject accepts Object and primitives must be boxed.
	 */
	@Test
	void benchmarkVariantConversionDispatch() {
		// Pre-boxed values to avoid measuring boxing in the instanceof chain
		Object intValue = 42;
		Object doubleValue = 3.14;
		Object stringValue = "hello";
		Object boolValue = true;
		Object nullValue = null;

		// --- Warmup ---
		for (int i = 0; i < WARMUP_ITERATIONS; i++) {
			simulateFromObjectDispatch(intValue);
			simulateFromObjectDispatch(doubleValue);
			simulateFromObjectDispatch(stringValue);
			simulateFromObjectDispatch(boolValue);
			simulateFromObjectDispatch(nullValue);
		}

		// --- Measure instanceof dispatch for each type ---
		long intStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			simulateFromObjectDispatch(intValue);
		}
		long intNanos = System.nanoTime() - intStart;

		long doubleStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			simulateFromObjectDispatch(doubleValue);
		}
		long doubleNanos = System.nanoTime() - doubleStart;

		long strStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			simulateFromObjectDispatch(stringValue);
		}
		long strNanos = System.nanoTime() - strStart;

		long boolStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			simulateFromObjectDispatch(boolValue);
		}
		long boolNanos = System.nanoTime() - boolStart;

		long nullStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			simulateFromObjectDispatch(nullValue);
		}
		long nullNanos = System.nanoTime() - nullStart;

		// --- Measure boxing overhead ---
		long intBoxStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			Object boxed = i; // autoboxing int -> Integer
		}
		long intBoxNanos = System.nanoTime() - intBoxStart;

		long doubleBoxStart = System.nanoTime();
		for (int i = 0; i < MEASURE_ITERATIONS; i++) {
			Object boxed = (double) i; // autoboxing double -> Double
		}
		long doubleBoxNanos = System.nanoTime() - doubleBoxStart;

		// --- Report ---
		printSeparator();
		System.out.println("VARIANT CONVERSION BENCHMARK: instanceof dispatch + boxing");
		printSeparator();
		printRow("Test", "Total (ms)", "Per-call (ns)");
		printSeparator();
		printRow("instanceof dispatch (int)", nsToMs(intNanos), nsPerCall(intNanos));
		printRow("instanceof dispatch (double)", nsToMs(doubleNanos), nsPerCall(doubleNanos));
		printRow("instanceof dispatch (String)", nsToMs(strNanos), nsPerCall(strNanos));
		printRow("instanceof dispatch (Boolean)", nsToMs(boolNanos), nsPerCall(boolNanos));
		printRow("instanceof dispatch (null)", nsToMs(nullNanos), nsPerCall(nullNanos));
		printSeparator();
		printRow("autobox int -> Integer", nsToMs(intBoxNanos), nsPerCall(intBoxNanos));
		printRow("autobox double -> Double", nsToMs(doubleBoxNanos), nsPerCall(doubleBoxNanos));
		printSeparator();
		System.out.printf("  Note: These measure the Java-side instanceof chain only.%n");
		System.out.printf("  Full VariantUtils.fromObject() also includes native alloc.%n");
		System.out.printf("  String dispatch is furthest in the chain (after Boolean, Number).%n");
		printSeparator();
	}

	// =======================================================================
	// Simulated instanceof chain (mirrors VariantUtils.fromObject order)
	// =======================================================================

	/**
	 * Simulates the instanceof dispatch chain from VariantUtils.fromObject()
	 * without calling any native methods. Returns an int tag representing the
	 * resolved type to prevent JIT from eliminating the dead code.
	 *
	 * <p>
	 * Tag values: 0=nil, 1=bool, 2=int, 3=float, 4=string, -1=fallback
	 */
	private static int simulateFromObjectDispatch(Object value) {
		if (value == null)
			return 0; // NIL
		if (value instanceof Boolean)
			return 1;
		if (value instanceof Integer || value instanceof Long)
			return 2;
		if (value instanceof Float || value instanceof Double)
			return 3;
		if (value instanceof String)
			return 4;
		return -1;
	}

	// =======================================================================
	// Formatting helpers
	// =======================================================================

	private static void printSeparator() {
		System.out.println("+---------------------------------------------+------------+--------------+");
	}

	private static void printRow(String col1, String col2, String col3) {
		System.out.printf("| %-43s | %10s | %12s |%n", col1, col2, col3);
	}

	private static String nsToMs(long nanos) {
		return String.format("%.2f", nanos / 1_000_000.0);
	}

	private static String nsPerCall(long totalNanos) {
		return String.format("%.1f", (double) totalNanos / MEASURE_ITERATIONS);
	}

	private static String nsPerCall(long totalNanos, long totalCalls) {
		return String.format("%.1f", (double) totalNanos / totalCalls);
	}

	private static double ratio(long numerator, long denominator) {
		if (denominator == 0)
			return Double.NaN;
		return (double) numerator / denominator;
	}
}
