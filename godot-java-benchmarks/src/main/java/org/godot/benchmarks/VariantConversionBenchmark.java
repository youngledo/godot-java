package org.godot.benchmarks;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.concurrent.TimeUnit;

import org.godot.math.Vector2;
import org.godot.math.Vector3;
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
 * Benchmarks for Variant conversion hot paths.
 *
 * These benchmarks measure the Java-side cost of converting between Java
 * objects and Godot Variant memory layout. They simulate VariantUtils
 * operations without requiring a running Godot instance.
 *
 * The Variant memory layout is: 4 bytes type + 4 bytes padding + 16 bytes data.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class VariantConversionBenchmark {

	private static final int VARIANT_SIZE = 24;
	private static final int TYPE_INT = 2;
	private static final int TYPE_FLOAT = 3;
	private static final int TYPE_BOOL = 1;
	private static final int TYPE_NIL = 0;
	private static final int TYPE_VECTOR2 = 5;
	private static final int TYPE_VECTOR3 = 7;

	private Arena arena;
	private MemorySegment variantSlot;
	private MemorySegment intVariant;
	private MemorySegment floatVariant;
	private MemorySegment vector3Variant;
	private Vector3 testVector3;

	@Setup
	public void setup() {
		arena = Arena.ofShared();

		// Pre-allocate variant slots
		variantSlot = arena.allocate(VARIANT_SIZE, 8);
		intVariant = arena.allocate(VARIANT_SIZE, 8);
		floatVariant = arena.allocate(VARIANT_SIZE, 8);
		vector3Variant = arena.allocate(VARIANT_SIZE, 8);

		// Initialize an int variant
		intVariant.set(ValueLayout.JAVA_INT, 0, TYPE_INT);
		intVariant.set(ValueLayout.JAVA_LONG, 8, 42L);

		// Initialize a float variant
		floatVariant.set(ValueLayout.JAVA_INT, 0, TYPE_FLOAT);
		floatVariant.set(ValueLayout.JAVA_LONG, 8, Double.doubleToRawLongBits(3.14));

		// Initialize a Vector3 variant
		vector3Variant.set(ValueLayout.JAVA_INT, 0, TYPE_VECTOR3);
		vector3Variant.set(ValueLayout.JAVA_INT, 8, Float.floatToRawIntBits(1.0f));
		vector3Variant.set(ValueLayout.JAVA_INT, 12, Float.floatToRawIntBits(2.0f));
		vector3Variant.set(ValueLayout.JAVA_INT, 16, Float.floatToRawIntBits(3.0f));

		testVector3 = new Vector3(1.0, 2.0, 3.0);
	}

	// --- Writing (Java -> Variant) benchmarks ---

	/**
	 * Write null to variant (type = NIL, zero data).
	 */
	@Benchmark
	public MemorySegment writeNull() {
		variantSlot.set(ValueLayout.JAVA_INT, 0, TYPE_NIL);
		// Zero out data area
		variantSlot.set(ValueLayout.JAVA_LONG, 8, 0L);
		return variantSlot;
	}

	/**
	 * Write int to variant. Simulates VariantUtils.fromObjectInto for Integer.
	 */
	@Benchmark
	public MemorySegment writeInt() {
		variantSlot.set(ValueLayout.JAVA_INT, 0, TYPE_INT);
		variantSlot.set(ValueLayout.JAVA_LONG, 8, 42L);
		return variantSlot;
	}

	/**
	 * Write float/double to variant. Simulates VariantUtils.fromObjectInto for
	 * Double.
	 */
	@Benchmark
	public MemorySegment writeFloat() {
		variantSlot.set(ValueLayout.JAVA_INT, 0, TYPE_FLOAT);
		variantSlot.set(ValueLayout.JAVA_LONG, 8, Double.doubleToRawLongBits(3.14));
		return variantSlot;
	}

	/**
	 * Write boolean to variant.
	 */
	@Benchmark
	public MemorySegment writeBoolean() {
		variantSlot.set(ValueLayout.JAVA_INT, 0, TYPE_BOOL);
		variantSlot.set(ValueLayout.JAVA_BYTE, 8, (byte) 1);
		return variantSlot;
	}

	/**
	 * Write Vector3 to variant. Simulates the hot path in
	 * VariantUtils.fromObjectInto.
	 */
	@Benchmark
	public MemorySegment writeVector3() {
		Vector3 v = testVector3;
		variantSlot.set(ValueLayout.JAVA_INT, 0, TYPE_VECTOR3);
		variantSlot.set(ValueLayout.JAVA_INT, 8, Float.floatToRawIntBits((float) v.x));
		variantSlot.set(ValueLayout.JAVA_INT, 12, Float.floatToRawIntBits((float) v.y));
		variantSlot.set(ValueLayout.JAVA_INT, 16, Float.floatToRawIntBits((float) v.z));
		return variantSlot;
	}

	// --- Reading (Variant -> Java) benchmarks ---

	/**
	 * Read int from variant.
	 */
	@Benchmark
	public long readInt() {
		int type = intVariant.get(ValueLayout.JAVA_INT, 0);
		if (type == TYPE_INT) {
			return intVariant.get(ValueLayout.JAVA_LONG, 8);
		}
		return 0;
	}

	/**
	 * Read float from variant.
	 */
	@Benchmark
	public double readFloat() {
		int type = floatVariant.get(ValueLayout.JAVA_INT, 0);
		if (type == TYPE_FLOAT) {
			return Double.longBitsToDouble(floatVariant.get(ValueLayout.JAVA_LONG, 8));
		}
		return 0.0;
	}

	/**
	 * Read Vector3 from variant. Simulates VariantUtils.readVector3.
	 */
	@Benchmark
	public Vector3 readVector3() {
		int type = vector3Variant.get(ValueLayout.JAVA_INT, 0);
		if (type == TYPE_VECTOR3) {
			float x = Float.intBitsToFloat(vector3Variant.get(ValueLayout.JAVA_INT, 8));
			float y = Float.intBitsToFloat(vector3Variant.get(ValueLayout.JAVA_INT, 12));
			float z = Float.intBitsToFloat(vector3Variant.get(ValueLayout.JAVA_INT, 16));
			return new Vector3(x, y, z);
		}
		return new Vector3();
	}

	// --- instanceof dispatch benchmarks ---

	/**
	 * Instanceof dispatch for Integer. Simulates the hot path in
	 * VariantUtils.fromObject.
	 */
	@Benchmark
	public int instanceOfDispatchInteger() {
		return dispatchType(42);
	}

	/**
	 * Instanceof dispatch for Double. Simulates the hot path in
	 * VariantUtils.fromObject.
	 */
	@Benchmark
	public int dispatchTypeDouble() {
		return dispatchType(3.14);
	}

	/**
	 * Instanceof dispatch for Vector3 (further down the chain).
	 */
	@Benchmark
	public int dispatchTypeVector3() {
		return dispatchType(testVector3);
	}

	/**
	 * Simulates the instanceof chain in VariantUtils.fromObject. Returns a type ID
	 * for verification.
	 */
	private int dispatchType(Object value) {
		if (value == null)
			return TYPE_NIL;
		if (value instanceof Boolean)
			return TYPE_BOOL;
		if (value instanceof Integer || value instanceof Long)
			return TYPE_INT;
		if (value instanceof Float || value instanceof Double)
			return TYPE_FLOAT;
		if (value instanceof String)
			return 4; // STRING
		if (value instanceof Vector2)
			return TYPE_VECTOR2;
		if (value instanceof Vector3)
			return TYPE_VECTOR3;
		return -1;
	}
}
