package org.godot.core;

import org.godot.internal.api.VariantType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for VariantUtils.toObjectRelaxed() — GDScript-like lenient
/// type coercion. Simple Variant types (INT, FLOAT, BOOL) are constructed
/// manually without Godot runtime. STRING-dependent coercion paths are
/// tested indirectly via Number-to-String fallbacks.
class VariantUtilsRelaxedTest {

	private Arena arena;

	@BeforeEach
	void setUp() {
		arena = Arena.ofAuto();
	}

	/// Create an INT Variant with the given long value.
	private Variant intVariant(long value) {
		MemorySegment seg = arena.allocate(Variant.SIZE);
		seg.set(JAVA_INT, 0, VariantType.INT.id());
		seg.set(JAVA_LONG, 8, value);
		return new Variant(seg);
	}

	/// Create a FLOAT Variant with the given double value.
	private Variant floatVariant(double value) {
		MemorySegment seg = arena.allocate(Variant.SIZE);
		seg.set(JAVA_INT, 0, VariantType.FLOAT.id());
		seg.set(JAVA_DOUBLE, 8, value);
		return new Variant(seg);
	}

	/// Create a BOOL Variant.
	private Variant boolVariant(boolean value) {
		MemorySegment seg = arena.allocate(Variant.SIZE);
		seg.set(JAVA_INT, 0, VariantType.BOOL.id());
		seg.set(JAVA_BYTE, 8, (byte) (value ? 1 : 0));
		return new Variant(seg);
	}

	/// Create a NIL Variant.
	private Variant nilVariant() {
		MemorySegment seg = arena.allocate(Variant.SIZE);
		seg.set(JAVA_INT, 0, VariantType.NIL.id());
		return new Variant(seg);
	}

	@Test
	void nullVariantReturnsNull() {
		assertNull(VariantUtils.toObjectRelaxed(null, Integer.class));
	}

	@Test
	void nilVariantReturnsNull() {
		assertNull(VariantUtils.toObjectRelaxed(nilVariant(), Integer.class));
	}

	@Test
	void intPassthrough() {
		// toObject returns Long for INT; requesting Long should pass through
		Object result = VariantUtils.toObjectRelaxed(intVariant(42L), Long.class);
		assertEquals(42L, result);
	}

	@Test
	void intToInteger() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(42L), Integer.class);
		assertEquals(42, result);
		assertTrue(result instanceof Integer);
	}

	@Test
	void intToFloat() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(7L), Float.class);
		assertEquals(7.0f, result);
		assertTrue(result instanceof Float);
	}

	@Test
	void intToDouble() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(99L), Double.class);
		assertEquals(99.0, result);
		assertTrue(result instanceof Double);
	}

	@Test
	void intToString() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(42L), String.class);
		assertEquals("42", result);
		assertTrue(result instanceof String);
	}

	@Test
	void floatToInteger() {
		// 3.7 truncated to int -> 3
		Object result = VariantUtils.toObjectRelaxed(floatVariant(3.7), Integer.class);
		assertEquals(3, result);
		assertTrue(result instanceof Integer);
	}

	@Test
	void floatToLong() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(99.9), Long.class);
		assertEquals(99L, result);
		assertTrue(result instanceof Long);
	}

	@Test
	void floatPassthrough() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(2.5), Double.class);
		assertEquals(2.5, result);
		assertTrue(result instanceof Double);
	}

	@Test
	void floatToString() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(3.14), String.class);
		assertNotNull(result);
		assertTrue(result instanceof String);
	}

	@Test
	void boolToIntegerTrue() {
		Object result = VariantUtils.toObjectRelaxed(boolVariant(true), Integer.class);
		// Boolean is not a Number; toObject returns Boolean, not matched by Number path
		// This falls through to return raw Boolean — testing actual behavior
		assertNotNull(result);
	}

	@Test
	void boolPassthrough() {
		Object result = VariantUtils.toObjectRelaxed(boolVariant(true), Boolean.class);
		assertEquals(true, result);
	}

	@Test
	void boolToString() {
		Object result = VariantUtils.toObjectRelaxed(boolVariant(true), String.class);
		assertEquals("true", result);
	}

	@Test
	void intToBooleanNonZero() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(1L), Boolean.class);
		assertEquals(true, result);
	}

	@Test
	void intToBooleanZero() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(0L), Boolean.class);
		assertEquals(false, result);
	}

	@Test
	void floatToBooleanNonZero() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(2.5), Boolean.class);
		assertEquals(true, result);
	}

	@Test
	void floatToBooleanZero() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(0.0), Boolean.class);
		assertEquals(false, result);
	}

	@Test
	void sameTypePassthroughLong() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(123L), Long.class);
		assertEquals(123L, result);
	}

	@Test
	void sameTypePassthroughDouble() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(4.56), Double.class);
		assertEquals(4.56, result);
	}

	@Test
	void sameTypePassthroughBoolean() {
		Object result = VariantUtils.toObjectRelaxed(boolVariant(false), Boolean.class);
		assertEquals(false, result);
	}

	@Test
	void intToPrimitiveInt() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(42L), int.class);
		assertEquals(42, result);
		assertTrue(result instanceof Integer);
	}

	@Test
	void intToPrimitiveLong() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(42L), long.class);
		assertEquals(42L, result);
		assertTrue(result instanceof Long);
	}

	@Test
	void floatToPrimitiveFloat() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(1.5), float.class);
		assertEquals(1.5f, result);
		assertTrue(result instanceof Float);
	}

	@Test
	void floatToPrimitiveDouble() {
		Object result = VariantUtils.toObjectRelaxed(floatVariant(1.5), double.class);
		assertEquals(1.5, result);
		assertTrue(result instanceof Double);
	}

	@Test
	void boolToPrimitiveBoolean() {
		Object result = VariantUtils.toObjectRelaxed(boolVariant(true), boolean.class);
		assertEquals(true, result);
	}

	@Test
	void negativeIntToFloat() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(-5L), Float.class);
		assertEquals(-5.0f, result);
	}

	@Test
	void largeLongToInteger() {
		Object result = VariantUtils.toObjectRelaxed(intVariant(Integer.MAX_VALUE + 1L), Integer.class);
		// Overflow expected — truncation via Number.intValue()
		assertEquals(Integer.MIN_VALUE, result);
	}
}
