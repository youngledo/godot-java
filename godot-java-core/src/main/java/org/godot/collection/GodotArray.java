package org.godot.collection;

import org.godot.core.RefCounted;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * Godot Array type. A dynamically-typed container that can hold any Variant
 * values. Extends RefCounted since Godot Arrays are reference-counted objects.
 *
 * Array is a Variant built-in type (not an Object), so ALL method dispatch goes
 * through VARIANT_CALL (not classdb_get_method_bind, which is Object-only).
 */
public class GodotArray extends RefCounted {

	public GodotArray() {
		super(0);
	}

	public GodotArray(long nativePtr) {
		super(nativePtr);
	}

	/**
	 * Create a GodotArray from a Variant's memory segment. Extracts the array
	 * pointer from the Variant at offset 8.
	 */
	public GodotArray(MemorySegment variantSeg) {
		super(variantSeg.get(ADDRESS, 8));
	}

	public static GodotArray fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotArray(nativePtr);
	}

	/**
	 * Get element at index via VARIANT_CALL "get".
	 */
	public Object get(int index) {
		if (nativeObject == 0)
			return null;
		return callVariantMethodReturning("get", index);
	}

	/**
	 * Set element at index via VARIANT_CALL "set".
	 */
	public void set(int index, Object value) {
		if (nativeObject == 0)
			return;
		callVariantMethod("set", index, value);
	}

	/**
	 * Add element to the end of the array via VARIANT_CALL "push_back".
	 */
	public void add(Object value) {
		if (nativeObject == 0)
			return;
		callVariantMethod("push_back", value);
	}

	public void append(Object value) {
		add(value);
	}

	/**
	 * Remove element at index via VARIANT_CALL "remove_at".
	 */
	public void remove(int index) {
		if (nativeObject == 0)
			return;
		callVariantMethod("remove_at", index);
	}

	/**
	 * Insert element at index via VARIANT_CALL "insert".
	 */
	public void insert(int index, Object value) {
		if (nativeObject == 0)
			return;
		callVariantMethod("insert", index, value);
	}

	/**
	 * Clear the array via VARIANT_CALL "clear".
	 */
	public void clear() {
		if (nativeObject == 0)
			return;
		callVariantMethod("clear");
	}

	/**
	 * Resize the array via VARIANT_CALL "resize".
	 */
	public void resize(int newSize) {
		if (nativeObject == 0)
			return;
		callVariantMethod("resize", newSize);
	}

	/**
	 * Sort the array via VARIANT_CALL "sort".
	 */
	public void sort() {
		if (nativeObject == 0)
			return;
		callVariantMethod("sort");
	}

	/**
	 * Shuffle the array using Fisher-Yates algorithm.
	 */
	public void shuffle() {
		if (nativeObject == 0)
			return;
		int n = size();
		for (int i = n - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			if (i != j) {
				Object temp = get(i);
				set(i, get(j));
				set(j, temp);
			}
		}
	}

	/**
	 * Reverse the array in place using two-pointer swap.
	 */
	public void reverse() {
		if (nativeObject == 0)
			return;
		int i = 0;
		int j = size() - 1;
		while (i < j) {
			Object temp = get(i);
			set(i, get(j));
			set(j, temp);
			i++;
			j--;
		}
	}

	/**
	 * Get the number of elements via VARIANT_CALL "size".
	 */
	public int size() {
		if (nativeObject == 0)
			return 0;
		Object result = callVariantMethodReturning("size");
		if (result == null)
			return 0;
		return ((Number) result).intValue();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public static GodotArray fromVariant(MemorySegment variantSeg) {
		return new GodotArray(variantSeg);
	}

	// ------------------------------------------------------------------------
	// VARIANT_CALL helpers
	// ------------------------------------------------------------------------

	/**
	 * Build a Variant wrapping this Array for use with VARIANT_CALL.
	 */
	private MemorySegment buildSelfVariant() {
		MemorySegment selfVar = Bridge.allocVariant();
		selfVar.set(JAVA_INT, 0, VariantType.ARRAY.id());
		selfVar.set(ADDRESS, 8, MemorySegment.ofAddress(nativeObject));
		return selfVar;
	}

	/**
	 * Call a void-returning method on this Array via VARIANT_CALL.
	 */
	private void callVariantMethod(String methodName, Object... args) {
		Bridge.runScoped(() -> {
			MemorySegment selfVar = buildSelfVariant();
			org.godot.core.GodotStringName methodSn = org.godot.core.GodotStringName.fromJavaString(methodName);

			int argc = args.length;
			MemorySegment argPtrs;
			if (argc > 0) {
				argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
				for (int i = 0; i < argc; i++) {
					Variant argVar = VariantUtils.fromObject(args[i]);
					argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVar.getSegment());
				}
			} else {
				argPtrs = MemorySegment.NULL;
			}

			MemorySegment retVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(4 * 4);

			Bridge.callVoid(ApiIndex.VARIANT_CALL, selfVar, methodSn.segment(), argPtrs, (long) argc, retVar, errorVar);

			Bridge.destroyVariant(retVar);

			int errorCode = errorVar.get(JAVA_INT, 0);
			if (errorCode != 0) {
				throw new RuntimeException("VARIANT_CALL error " + errorCode + " calling " + methodName + " on Array");
			}
		});
	}

	/**
	 * Call a method on this Array via VARIANT_CALL and return the result as a Java
	 * Object. The native Variant is destroyed inside the scoped arena.
	 */
	private Object callVariantMethodReturning(String methodName, Object... args) {
		return Bridge.runScoped(() -> {
			MemorySegment selfVar = buildSelfVariant();
			org.godot.core.GodotStringName methodSn = org.godot.core.GodotStringName.fromJavaString(methodName);

			int argc = args.length;
			MemorySegment argPtrs;
			if (argc > 0) {
				argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
				for (int i = 0; i < argc; i++) {
					Variant argVar = VariantUtils.fromObject(args[i]);
					argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVar.getSegment());
				}
			} else {
				argPtrs = MemorySegment.NULL;
			}

			MemorySegment retVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(4 * 4);

			Bridge.callVoid(ApiIndex.VARIANT_CALL, selfVar, methodSn.segment(), argPtrs, (long) argc, retVar, errorVar);

			int errorCode = errorVar.get(JAVA_INT, 0);
			if (errorCode != 0) {
				return null;
			}

			Variant result = new Variant(retVar);
			Object javaResult = VariantUtils.toObject(result);
			Bridge.destroyVariant(retVar);
			return javaResult;
		});
	}
}
