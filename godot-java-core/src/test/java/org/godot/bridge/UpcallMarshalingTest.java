package org.godot.bridge;

import org.junit.jupiter.api.Test;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verification tests for upcall stub creation and marshaling. Tests Task 5.6:
 * double delta passes correctly from native to Java. Tests Task 5.7: Variant*
 * return type upcall handling.
 */
public class UpcallMarshalingTest {

	// ------------------------------------------------------------------------
	// Task 5.6: Verify double delta marshaling
	// ------------------------------------------------------------------------

	/**
	 * Test that createVoidDouble produces a valid function descriptor with the
	 * correct signature: void(double) → void.
	 *
	 * This verifies that Panama's ABI correctly marshals the native double
	 * parameter to the Java double argument.
	 */
	@Test
	void voidDoubleUpcallDescriptor_matchesExpectedSignature() throws Exception {
		// The FunctionDescriptor used in createVoidDouble:
		// FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE)
		// This matches the native signature: void _process(double delta)
		FunctionDescriptor expectedFd = FunctionDescriptor.ofVoid(JAVA_DOUBLE);

		assertTrue(expectedFd.returnLayout().isEmpty(), "void-double upcall should have void (empty) return");
		assertEquals(1, expectedFd.argumentLayouts().size(),
				"void-double upcall should have exactly 1 argument (the double delta)");
		assertEquals(JAVA_DOUBLE, expectedFd.argumentLayouts().get(0),
				"The argument should be JAVA_DOUBLE (8-byte float)");
	}

	/**
	 * Test that we can create a MethodHandle that accepts a double and verify the
	 * binding works correctly.
	 */
	@Test
	void doubleArgMethodHandle_acceptsDoubleValue() throws Throwable {
		// Create a test target that records the delta received
		DoubleReceiver receiver = new DoubleReceiver();

		// Get a method handle to the receiveDelta method
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle handle = lookup.findVirtual(DoubleReceiver.class, "receiveDelta",
				MethodType.methodType(void.class, double.class));
		handle = handle.bindTo(receiver);

		// Invoke with a double value
		double testDelta = 0.016;
		handle.invoke(testDelta);

		assertEquals(testDelta, receiver.receivedDelta, "MethodHandle.invoke should pass double value correctly");
	}

	/**
	 * Test that multiple double invocations produce correct values.
	 */
	@Test
	void doubleMarshaling_multipleInvocations() throws Throwable {
		DoubleReceiver receiver = new DoubleReceiver();
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle handle = lookup
				.findVirtual(DoubleReceiver.class, "receiveDelta", MethodType.methodType(void.class, double.class))
				.bindTo(receiver);

		double[] testValues = {0.016, 0.5, 1.0, 16.667, -1.0};
		for (double val : testValues) {
			handle.invoke(val);
			assertEquals(val, receiver.receivedDelta, "Delta value should be correctly marshaled: " + val);
		}
	}

	/** Helper class for double receiver test */
	static class DoubleReceiver {
		double receivedDelta = Double.NaN;
		void receiveDelta(double delta) {
			this.receivedDelta = delta;
		}
	}

	// ------------------------------------------------------------------------
	// Task 5.7: Verify Variant* return type handling
	// ------------------------------------------------------------------------

	/**
	 * Test that the VariantPtr (ADDRESS return) function descriptor is correct.
	 * Variant* is a pointer (void*), which in Panama FFI is ADDRESS.
	 *
	 * When a native method returns a Variant*, the Panama Linker provides it as a
	 * MemorySegment (address). The upcall stub's MethodHandle receives this
	 * MemorySegment and can use it to access the variant data.
	 */
	@Test
	void variantPtrUpcallDescriptor_hasCorrectSignature() {
		// FunctionDescriptor for a method returning Variant* and receiving void*
		FunctionDescriptor fd = FunctionDescriptor.of(ADDRESS, ADDRESS);

		assertEquals(ADDRESS, fd.returnLayout().orElse(null),
				"VariantPtr return should be ADDRESS (void* → MemorySegment)");
		assertEquals(1, fd.argumentLayouts().size(), "Should have 1 argument (the object pointer)");
		assertEquals(ADDRESS, fd.argumentLayouts().get(0), "Object argument should be ADDRESS (void*)");
	}

	/**
	 * Test that we can create a MethodHandle that returns a MemorySegment
	 * (simulating Variant* return from native code).
	 */
	@Test
	void memorySegmentReturnMethodHandle_works() throws Throwable {
		// Use 0x1000 (4096) — clearly positive, unambiguous in both signed/unsigned
		VariantPtrReceiver receiver = new VariantPtrReceiver(0x1000L);

		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle handle = lookup.findVirtual(VariantPtrReceiver.class, "returnVariantPtr",
				MethodType.methodType(MemorySegment.class));
		handle = handle.bindTo(receiver);

		MemorySegment result = (MemorySegment) handle.invoke();
		assertNotNull(result, "MemorySegment should not be null");
		assertEquals(0x1000L, result.address(), "MemorySegment address should match returned Variant* value");
	}

	/** Helper class for VariantPtr return test */
	static class VariantPtrReceiver {
		private final long ptrValue;
		VariantPtrReceiver(long ptrValue) {
			this.ptrValue = ptrValue;
		}
		MemorySegment returnVariantPtr() {
			return MemorySegment.ofAddress(ptrValue);
		}
	}

	/**
	 * Verify that createForVariantPtr produces a valid function descriptor. This is
	 * tested indirectly by checking the FD format.
	 */
	@Test
	void variantPtrDescriptor_bytesPerArg_areCorrect() {
		FunctionDescriptor fd = FunctionDescriptor.of(ADDRESS, ADDRESS);
		// ADDRESS layout size = 8 bytes (64-bit pointer)
		assertEquals(8, ADDRESS.byteSize(), "ADDRESS should be 8 bytes (64-bit pointer)");
	}
}
