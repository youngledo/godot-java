package org.godot.benchmarks;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.util.concurrent.TimeUnit;

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
 * Benchmarks for property access patterns used in godot-java.
 *
 * Measures VarHandle get/put, MethodHandle getter invocation, and field access
 * costs. These patterns are used throughout the framework for @Export property
 * access and generated getter/setter dispatch.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class PropertyAccessBenchmark {

	// Target object with fields to benchmark
	@SuppressWarnings("unused")
	public static class Target {
		int intField;
		Object objectField;
		float floatField;
		long longField;
		double doubleField;
		boolean booleanField;

		public int getIntField() {
			return intField;
		}
		public void setIntField(int v) {
			intField = v;
		}
		public Object getObjectField() {
			return objectField;
		}
		public void setObjectField(Object v) {
			objectField = v;
		}
	}

	private Target target;
	private VarHandle intVarHandle;
	private VarHandle objectVarHandle;
	private VarHandle floatVarHandle;
	private MethodHandle intGetter;
	private MethodHandle intSetter;
	private MethodHandle objectGetter;
	private MethodHandle objectSetter;

	@Setup
	public void setup() throws Throwable {
		target = new Target();
		target.intField = 42;
		target.objectField = "test";
		target.floatField = 3.14f;

		MethodHandles.Lookup lookup = MethodHandles.lookup();

		// VarHandles for direct field access
		intVarHandle = lookup.findVarHandle(Target.class, "intField", int.class);
		objectVarHandle = lookup.findVarHandle(Target.class, "objectField", Object.class);
		floatVarHandle = lookup.findVarHandle(Target.class, "floatField", float.class);

		// MethodHandles for getter/setter methods
		intGetter = lookup.findVirtual(Target.class, "getIntField", MethodType.methodType(int.class));
		intSetter = lookup.findVirtual(Target.class, "setIntField", MethodType.methodType(void.class, int.class));
		objectGetter = lookup.findVirtual(Target.class, "getObjectField", MethodType.methodType(Object.class));
		objectSetter = lookup.findVirtual(Target.class, "setObjectField",
				MethodType.methodType(void.class, Object.class));
	}

	// --- VarHandle read benchmarks ---

	/**
	 * VarHandle get on int field. This is the primary pattern for @Export property
	 * read in generated dispatch code.
	 */
	@Benchmark
	public int varHandleGetInt() {
		return (int) intVarHandle.get(target);
	}

	/**
	 * VarHandle get on Object field.
	 */
	@Benchmark
	public Object varHandleGetObject() {
		return objectVarHandle.get(target);
	}

	/**
	 * VarHandle get on float field.
	 */
	@Benchmark
	public float varHandleGetFloat() {
		return (float) floatVarHandle.get(target);
	}

	// --- VarHandle write benchmarks ---

	/**
	 * VarHandle set on int field.
	 */
	@Benchmark
	public void varHandleSetInt() {
		intVarHandle.set(target, 99);
	}

	/**
	 * VarHandle set on Object field.
	 */
	@Benchmark
	public void varHandleSetObject() {
		objectVarHandle.set(target, "benchmark");
	}

	// --- MethodHandle benchmarks ---

	/**
	 * MethodHandle getter invocation for int property.
	 */
	@Benchmark
	public int methodHandleGetInt() throws Throwable {
		return (int) intGetter.invokeExact(target);
	}

	/**
	 * MethodHandle setter invocation for int property.
	 */
	@Benchmark
	public void methodHandleSetInt() throws Throwable {
		intSetter.invokeExact(target, 99);
	}

	/**
	 * MethodHandle getter invocation for Object property.
	 */
	@Benchmark
	public Object methodHandleGetObject() throws Throwable {
		return objectGetter.invokeExact(target);
	}

	/**
	 * MethodHandle setter invocation for Object property.
	 */
	@Benchmark
	public void methodHandleSetObject() throws Throwable {
		objectSetter.invokeExact(target, "benchmark");
	}

	// --- Direct field access baseline ---

	/**
	 * Direct field access baseline (int). No reflection or handle overhead.
	 */
	@Benchmark
	public int directFieldGetInt() {
		return target.intField;
	}

	/**
	 * Direct field set baseline (int).
	 */
	@Benchmark
	public void directFieldSetInt() {
		target.intField = 99;
	}

	/**
	 * Direct field access baseline (Object).
	 */
	@Benchmark
	public Object directFieldGetObject() {
		return target.objectField;
	}

	// --- Round-trip benchmarks ---

	/**
	 * Full property read round-trip: VarHandle get + type check + box. Simulates
	 * the full property read path from generated dispatch code.
	 */
	@Benchmark
	public Object propertyReadRoundTrip() {
		Object raw = intVarHandle.get(target);
		if (raw instanceof Integer) {
			return raw;
		}
		return null;
	}

	/**
	 * Full property write round-trip: unbox + VarHandle set. Simulates the full
	 * property write path from generated dispatch code.
	 */
	@Benchmark
	public void propertyWriteRoundTrip() {
		Object value = 42;
		intVarHandle.set(target, value);
	}
}
