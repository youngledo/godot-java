package org.godot.core;

import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VariantType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.ADDRESS;

/**
 * Godot Variant wrapper. A Variant is a type-tagged container that can hold any
 * Godot value (int, float, bool, String, Object, Array, Dictionary, etc.).
 *
 * Memory layout: 24 bytes (16 bytes data + 8 bytes type/metadata). This class
 * wraps a MemorySegment pointing to the native Variant memory.
 */
public final class Variant {

	private static final Logger logger = LogManager.getLogger(Variant.class);

	/**
	 * Size of a Godot Variant in bytes. GDExtension uses 24-byte opaque Variant.
	 * Larger types (Transform3D, Projection) must use VARIANT_NEW_COPY.
	 */
	public static final long SIZE = 24;

	/** Native memory segment pointing to the Variant. */
	private final MemorySegment segment;

	// Cached constructor functions for creating typed Variants
	private static volatile MethodHandle stringConstructor;
	private static volatile MethodHandle stringNameConstructor;
	private static volatile MethodHandle objectConstructor;
	private static volatile boolean constructorsInitialized = false;

	// Lazy-loaded type constructors/extractors for types that don't fit in 24 bytes
	private static final Map<Integer, MethodHandle> FROM_TYPE_CTORS = new ConcurrentHashMap<>();
	private static final Map<Integer, MethodHandle> TO_TYPE_CTORS = new ConcurrentHashMap<>();
	private static final FunctionDescriptor TYPE_CTOR_DESC = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);

	/** Get a variant-from-type constructor for the given VariantType ID. */
	public static MethodHandle getTypeConstructor(int typeId) {
		return FROM_TYPE_CTORS.computeIfAbsent(typeId, id -> {
			try {
				MemorySegment ptr = (MemorySegment) Bridge.getAPI(ApiIndex.GET_VARIANT_FROM_TYPE_CONSTRUCTOR)
						.invoke(id);
				if (ptr.address() != 0) {
					return Linker.nativeLinker().downcallHandle(ptr, TYPE_CTOR_DESC);
				}
			} catch (Throwable t) {
				logger.error("Failed to get variant_from_type constructor for type {}", id, t);
			}
			return null;
		});
	}

	/** Get a type-from-variant extractor for the given VariantType ID. */
	public static MethodHandle getTypeExtractor(int typeId) {
		return TO_TYPE_CTORS.computeIfAbsent(typeId, id -> {
			try {
				MemorySegment ptr = (MemorySegment) Bridge.getAPI(ApiIndex.GET_VARIANT_TO_TYPE_CONSTRUCTOR).invoke(id);
				if (ptr.address() != 0) {
					return Linker.nativeLinker().downcallHandle(ptr, TYPE_CTOR_DESC);
				}
			} catch (Throwable t) {
				logger.error("Failed to get variant_to_type extractor for type {}", id, t);
			}
			return null;
		});
	}

	/** Initialize type constructors. Must be called after Bridge.load(). */
	public static synchronized void initConstructors() {
		if (constructorsInitialized)
			return;
		FunctionDescriptor ctorDesc = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
		try {
			// String -> Variant constructor
			MemorySegment strCtorPtr = (MemorySegment) Bridge.getAPI(ApiIndex.GET_VARIANT_FROM_TYPE_CONSTRUCTOR)
					.invoke(VariantType.STRING.id());
			if (strCtorPtr.address() != 0) {
				stringConstructor = Linker.nativeLinker().downcallHandle(strCtorPtr, ctorDesc);
			}
		} catch (Throwable t) {
			logger.error("Failed to init String Variant constructor", t);
		}
		try {
			// Object* -> Variant constructor: signature is void(Variant*, Object**)
			// The second arg must be the ADDRESS OF the pointer, not the pointer itself.
			MemorySegment objCtorPtr = (MemorySegment) Bridge.getAPI(ApiIndex.GET_VARIANT_FROM_TYPE_CONSTRUCTOR)
					.invoke(VariantType.OBJECT.id());
			if (objCtorPtr.address() != 0) {
				objectConstructor = Linker.nativeLinker().downcallHandle(objCtorPtr, ctorDesc);
				logger.debug("Object Variant constructor loaded: {}", objCtorPtr.address());
			}
		} catch (Throwable t) {
			logger.error("Failed to init Object Variant constructor", t);
		}
		try {
			MemorySegment snCtorPtr = (MemorySegment) Bridge.getAPI(ApiIndex.GET_VARIANT_FROM_TYPE_CONSTRUCTOR)
					.invoke(VariantType.STRING_NAME.id());
			if (snCtorPtr.address() != 0) {
				stringNameConstructor = Linker.nativeLinker().downcallHandle(snCtorPtr, ctorDesc);
			}
		} catch (Throwable t) {
			logger.error("Failed to init StringName Variant constructor", t);
		}
		constructorsInitialized = true;
	}

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/** Wrap an existing native Variant memory segment. */
	public Variant(MemorySegment segment) {
		this.segment = segment;
	}

	/** Allocate a new Variant on the shared Arena. */
	public static Variant allocate() {
		return new Variant(Bridge.allocate(SIZE));
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	public static Variant fromNil() {
		Variant v = allocate();
		Bridge.callVoid(ApiIndex.VARIANT_NEW_NIL, v.segment);
		return v;
	}

	public static Variant fromBoolean(boolean value) {
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.BOOL.id());
		v.segment.set(JAVA_BYTE, 8, (byte) (value ? 1 : 0));
		return v;
	}

	public static Variant fromInt(long value) {
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.INT.id());
		v.segment.set(JAVA_LONG, 8, value);
		return v;
	}

	public static Variant fromFloat(double value) {
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.FLOAT.id());
		v.segment.set(JAVA_DOUBLE, 8, value);
		return v;
	}

	public static Variant fromRid(long id) {
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.RID.id());
		v.segment.set(JAVA_LONG, 8, id);
		return v;
	}

	/**
	 * Create a VECTOR2 Variant from a Java Vector2. Godot stores Vector2 as two
	 * 32-bit floats in the Variant.
	 */
	public static Variant fromVector2(org.godot.math.Vector2 v) {
		Variant variant = allocate();
		variant.segment.set(JAVA_INT, 0, VariantType.VECTOR2.id());
		// Write two floats (x, y) at offset 8
		variant.segment.set(JAVA_INT, 8, Float.floatToRawIntBits((float) v.x));
		variant.segment.set(JAVA_INT, 12, Float.floatToRawIntBits((float) v.y));
		return variant;
	}

	public static Variant fromVector3(org.godot.math.Vector3 v) {
		Variant variant = allocate();
		variant.segment.set(JAVA_INT, 0, VariantType.VECTOR3.id());
		variant.segment.set(JAVA_INT, 8, Float.floatToRawIntBits((float) v.x));
		variant.segment.set(JAVA_INT, 12, Float.floatToRawIntBits((float) v.y));
		variant.segment.set(JAVA_INT, 16, Float.floatToRawIntBits((float) v.z));
		return variant;
	}

	/**
	 * Create an OBJECT Variant wrapping a raw Godot Object pointer. Uses
	 * GDExtension's get_variant_from_type_constructor for proper construction.
	 */
	public static Variant fromObjectPtr(long objectPtr) {
		if (objectConstructor != null) {
			try {
				Variant v = allocate();
				// The Object constructor expects (Variant*, Object**) — the second arg
				// must be the address of the pointer, not the pointer itself.
				MemorySegment ptrBuf = Bridge.allocate(JAVA_LONG.byteSize());
				ptrBuf.set(JAVA_LONG, 0, objectPtr);
				objectConstructor.invoke(v.getSegment(), ptrBuf);
				return v;
			} catch (Throwable t) {
				logger.error("objectConstructor.invoke failed: {}", t.getMessage());
				// Fall through to manual construction
			}
		}
		// Fallback: manual construction
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.OBJECT.id());
		v.segment.set(JAVA_LONG, 8, objectPtr);
		return v;
	}

	/**
	 * Create a String Variant from a Java String using GDExtension's
	 * get_variant_from_type_constructor for proper construction.
	 */
	public static Variant fromString(String javaString) {
		GodotString godotString = GodotString.fromJavaString(javaString);
		MemorySegment strBuf = godotString.buffer();

		if (stringConstructor == null) {
			throw new org.godot.exception.GodotException(
					"stringConstructor is null — cannot create String Variant without GDExtension type constructor");
		}
		try {
			Variant v = allocate();
			stringConstructor.invoke(v.getSegment(), strBuf);
			return v;
		} catch (Throwable t) {
			throw new org.godot.exception.GodotException("stringConstructor.invoke failed", t);
		} finally {
			godotString.destroy();
		}
	}

	/**
	 * Create a STRING_NAME Variant from a GodotStringName.
	 */
	public static Variant fromStringName(GodotStringName sn) {
		if (stringNameConstructor != null) {
			try {
				Variant v = allocate();
				stringNameConstructor.invoke(v.getSegment(), sn.segment());
				return v;
			} catch (Throwable t) {
			}
		}
		// Fallback: store as opaque handle with STRING_NAME type
		Variant v = allocate();
		v.segment.set(JAVA_INT, 0, VariantType.STRING_NAME.id());
		v.segment.set(ADDRESS, 8, sn.segment());
		return v;
	}

	/** Create a String Variant directly into a pre-allocated slot. */
	public static void fromStringInto(String javaString, MemorySegment target) {
		GodotString godotString = GodotString.fromJavaString(javaString);
		try {
			if (stringConstructor != null) {
				stringConstructor.invoke(target, godotString.buffer());
				return;
			}
		} catch (Throwable _) {
		}
		// Safe fallback: create proper Variant and copy
		Variant v = fromString(javaString);
		Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, target, v.getSegment());
		Bridge.destroyVariant(v.getSegment());
		godotString.destroy();
	}

	/** Create a StringName Variant directly into a pre-allocated slot. */
	public static void fromStringNameInto(GodotStringName sn, MemorySegment target) {
		if (stringNameConstructor != null) {
			try {
				stringNameConstructor.invoke(target, sn.segment());
				return;
			} catch (Throwable t) {
			}
		}
		// Safe fallback: create proper Variant and copy to avoid ref count corruption
		Variant v = fromStringName(sn);
		Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, target, v.getSegment());
		Bridge.destroyVariant(v.getSegment());
	}

	/** Create an Object Variant directly into a pre-allocated slot. */
	public static void fromObjectPtrInto(long objectPtr, MemorySegment target) {
		if (objectConstructor != null) {
			try {
				MemorySegment ptrBuf = Bridge.allocate(8);
				ptrBuf.set(JAVA_LONG, 0, objectPtr);
				objectConstructor.invoke(target, ptrBuf);
				return;
			} catch (Throwable t) {
			}
		}
		target.set(JAVA_INT, 0, VariantType.OBJECT.id());
		target.set(JAVA_LONG, 8, objectPtr);
	}

	/** Convert this Variant to a Java String. */
	public String asString() {
		if (getType() != VariantType.STRING.id()) {
			return "";
		}
		// The String opaque data is at offset 8 in the Variant
		MemorySegment strData = Bridge.allocate(8);
		strData.set(JAVA_LONG, 0, segment.get(JAVA_LONG, 8));
		GodotString godotString = new GodotString(strData);
		return godotString.toJavaString();
	}

	// ------------------------------------------------------------------------
	// Type
	// ------------------------------------------------------------------------

	/** Get the Variant type ID. */
	public int getType() {
		return segment.get(JAVA_INT, 0);
	}

	/** Get the Variant type enum. */
	public VariantType getVariantType() {
		return VariantType.fromId(getType());
	}

	// ------------------------------------------------------------------------
	// Conversions
	// ------------------------------------------------------------------------

	public boolean asBoolean() {
		return segment.get(JAVA_BYTE, 8) != 0;
	}

	public long asLong() {
		return segment.get(JAVA_LONG, 8);
	}

	public double asDouble() {
		return segment.get(JAVA_DOUBLE, 8);
	}

	/** Get the native memory segment. */
	MemorySegment segment() {
		return segment;
	}

	/** Package-private: get the segment for use by VariantUtils. */
	public MemorySegment getSegment() {
		return segment;
	}
}
