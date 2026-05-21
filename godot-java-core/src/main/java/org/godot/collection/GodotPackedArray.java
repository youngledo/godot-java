package org.godot.collection;

import org.godot.bridge.Bridge;
import org.godot.core.OwnedVariant;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * Base class for Godot PackedArray types.
 *
 * PackedArrays are value-typed, copy-on-write containers with contiguous
 * memory. They are Variant built-in types, so all method dispatch goes through
 * VARIANT_CALL.
 *
 * @param <T>
 *            the Java array element type
 */
public abstract class GodotPackedArray<T> {

	protected long nativePtr;
	private final OwnedVariant ownedVariant;
	private final int variantTypeId;

	protected GodotPackedArray(int variantTypeId) {
		this.variantTypeId = variantTypeId;
		OwnedVariant owned = createEmptyVariant(variantTypeId);
		MemorySegment ptrSeg = owned.segment().get(ADDRESS, 8);
		this.nativePtr = ptrSeg.address();
		this.ownedVariant = owned;
	}

	protected GodotPackedArray(long nativePtr, int variantTypeId) {
		this.nativePtr = nativePtr;
		this.ownedVariant = null;
		this.variantTypeId = variantTypeId;
	}

	protected GodotPackedArray(MemorySegment variantSeg, int variantTypeId) {
		MemorySegment ptrSeg = variantSeg.get(ADDRESS, 8);
		this.nativePtr = ptrSeg.address();
		this.ownedVariant = null;
		this.variantTypeId = variantTypeId;
	}

	private static OwnedVariant createEmptyVariant(int variantTypeId) {
		MemorySegment variant = Bridge.allocVariant();
		MethodHandle ctor = Variant.getTypeConstructor(variantTypeId);
		if (ctor == null) {
			throw new IllegalStateException("PackedArray Variant constructor not available for type " + variantTypeId);
		}
		MemorySegment arrayData = Bridge.allocate(8);
		try {
			ctor.invoke(variant, arrayData);
			return OwnedVariant.copyOf(variant);
		} catch (Throwable t) {
			throw new RuntimeException("Failed to create PackedArray variant type " + variantTypeId, t);
		} finally {
			Bridge.destroyVariant(variant);
		}
	}

	/// Size of the packed array.
	public int size() {
		if (nativePtr == 0)
			return 0;
		Object result = callVariantMethodReturning("size");
		return result == null ? 0 : ((Number) result).intValue();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/// Clear all elements.
	public void clear() {
		if (nativePtr == 0)
			return;
		callVariantMethod("clear");
	}

	/// Resize the array.
	public void resize(int newSize) {
		if (nativePtr == 0)
			return;
		callVariantMethod("resize", newSize);
	}

	/// Reverse the array in place.
	public void reverse() {
		if (nativePtr == 0)
			return;
		callVariantMethod("reverse");
	}

	/// Sort the array in ascending order.
	public void sort() {
		if (nativePtr == 0)
			return;
		callVariantMethod("sort");
	}

	/// Append another packed array of the same type.
	public void appendArray(GodotPackedArray<T> other) {
		if (nativePtr == 0 || other.nativePtr == 0)
			return;
		callVariantMethod("append_array", other);
	}

	/// Check if the array contains a value.
	public boolean contains(T value) {
		if (nativePtr == 0)
			return false;
		Object result = callVariantMethodReturning("has", value);
		return result != null && (Boolean) result;
	}

	/// Count occurrences of a value.
	public int count(T value) {
		if (nativePtr == 0)
			return 0;
		Object result = callVariantMethodReturning("count", value);
		return result == null ? 0 : ((Number) result).intValue();
	}

	/// Find first occurrence of value, starting from given index.
	public int find(T value, int from) {
		if (nativePtr == 0)
			return -1;
		Object result = callVariantMethodReturning("find", value, from);
		return result == null ? -1 : ((Number) result).intValue();
	}

	/// Find first occurrence of value from the beginning.
	public int find(T value) {
		return find(value, 0);
	}

	/// Find last occurrence of value.
	public int rfind(T value, int from) {
		if (nativePtr == 0)
			return -1;
		Object result = callVariantMethodReturning("rfind", value, from);
		return result == null ? -1 : ((Number) result).intValue();
	}

	/// Return a sub-range as a new packed array.
	public abstract GodotPackedArray<T> subarray(int begin, int end);

	/// Return a copy as a Java array.
	public abstract Object toJavaArray();

	/// Return the Variant type ID for this packed array type.
	public int variantTypeId() {
		return variantTypeId;
	}

	/// Return the raw native pointer.
	public long nativePtr() {
		return nativePtr;
	}

	// ------------------------------------------------------------------------
	// VARIANT_CALL infrastructure
	// ------------------------------------------------------------------------

	private MemorySegment buildSelfVariant() {
		MemorySegment selfVar = Bridge.allocVariant();
		selfVar.set(JAVA_INT, 0, variantTypeId);
		selfVar.set(ADDRESS, 8, MemorySegment.ofAddress(nativePtr));
		return selfVar;
	}

	void callVariantMethod(String methodName, Object... args) {
		Bridge.runScoped(() -> {
			MemorySegment selfVar = buildSelfVariant();
			org.godot.core.GodotStringName methodSn = org.godot.core.GodotStringName.fromJavaString(methodName);
			int argc = args.length;
			MemorySegment argPtrs;
			MemorySegment[] argVarSegments = new MemorySegment[argc];
			try {
				if (argc > 0) {
					argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
					for (int i = 0; i < argc; i++) {
						Variant argVar = VariantUtils.fromObject(args[i]);
						argVarSegments[i] = argVar.getSegment();
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVarSegments[i]);
					}
				} else {
					argPtrs = MemorySegment.NULL;
				}
				MemorySegment retVar = Bridge.allocVariant();
				MemorySegment errorVar = Bridge.allocate(16);
				Bridge.callVoid(ApiIndex.VARIANT_CALL, selfVar, methodSn.segment(), argPtrs, (long) argc, retVar,
						errorVar);
				Bridge.destroyVariant(retVar);
			} finally {
				Bridge.destroyVariant(selfVar);
				for (MemorySegment seg : argVarSegments) {
					if (seg != null)
						Bridge.destroyVariant(seg);
				}
			}
		});
	}

	Object callVariantMethodReturning(String methodName, Object... args) {
		return Bridge.runScoped(() -> {
			MemorySegment selfVar = buildSelfVariant();
			org.godot.core.GodotStringName methodSn = org.godot.core.GodotStringName.fromJavaString(methodName);
			int argc = args.length;
			MemorySegment argPtrs;
			MemorySegment[] argVarSegments = new MemorySegment[argc];
			try {
				if (argc > 0) {
					argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
					for (int i = 0; i < argc; i++) {
						Variant argVar = VariantUtils.fromObject(args[i]);
						argVarSegments[i] = argVar.getSegment();
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVarSegments[i]);
					}
				} else {
					argPtrs = MemorySegment.NULL;
				}
				MemorySegment retVar = Bridge.allocVariant();
				MemorySegment errorVar = Bridge.allocate(16);
				Bridge.callVoid(ApiIndex.VARIANT_CALL, selfVar, methodSn.segment(), argPtrs, (long) argc, retVar,
						errorVar);
				Variant result = new Variant(retVar);
				Object javaResult = VariantUtils.toObject(result);
				Bridge.destroyVariant(retVar);
				return javaResult;
			} finally {
				Bridge.destroyVariant(selfVar);
				for (MemorySegment seg : argVarSegments) {
					if (seg != null)
						Bridge.destroyVariant(seg);
				}
			}
		});
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{size=" + size() + "}";
	}
}
