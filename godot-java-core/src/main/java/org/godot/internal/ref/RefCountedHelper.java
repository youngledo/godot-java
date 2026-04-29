package org.godot.internal.ref;

import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.foreign.ValueLayout.*;

/**
 * Manages RefCounted lifecycle for Java wrappers.
 *
 * <p>
 * When a Godot method returns a RefCounted object (Resource, Material,
 * PackedScene, etc.), the Variant holds a reference. Once the Variant is
 * destroyed, the ref count drops. If no other owner holds a ref, the object is
 * freed while Java still has a wrapper pointer.
 *
 * <p>
 * This helper calls {@code reference()} once per Java wrapper to add an extra
 * ref, matching godot-kotlin-jvm's approach. The extra ref is released in
 * {@link #unreference(long)} when the wrapper is freed.
 *
 * <p>
 * Uses method_bind_call (not ptrcall) for type safety — calling reference() on
 * a non-RefCounted object via ptrcall would corrupt memory.
 */
public final class RefCountedHelper {

	private RefCountedHelper() {
	}

	/** Cached method bind for RefCounted.reference(). */
	private static volatile MemorySegment referenceMethodBind;
	/** Cached method bind for RefCounted.unreference(). */
	private static volatile MemorySegment unreferenceMethodBind;

	/**
	 * Method hash for RefCounted.reference() and unreference() from
	 * extension_api.json. Godot 4.6+ requires exact hash — 0 is rejected.
	 */
	private static final long HASH_REFERENCE = 2240911060L;
	private static final long HASH_UNREFERENCE = 2240911060L;

	/** Tracks which pointers have had reference() called (to avoid double-ref). */
	private static final Map<Long, Boolean> REFFED = new ConcurrentHashMap<>();

	private static MemorySegment getReferenceMethodBind() {
		if (referenceMethodBind == null) {
			synchronized (RefCountedHelper.class) {
				if (referenceMethodBind == null) {
					GodotStringName className = GodotStringName.fromJavaString("RefCounted");
					GodotStringName methodName = GodotStringName.fromJavaString("reference");
					referenceMethodBind = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, className.segment(),
							methodName.segment(), HASH_REFERENCE);
				}
			}
		}
		return referenceMethodBind;
	}

	private static MemorySegment getUnreferenceMethodBind() {
		if (unreferenceMethodBind == null) {
			synchronized (RefCountedHelper.class) {
				if (unreferenceMethodBind == null) {
					GodotStringName className = GodotStringName.fromJavaString("RefCounted");
					GodotStringName methodName = GodotStringName.fromJavaString("unreference");
					unreferenceMethodBind = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, className.segment(),
							methodName.segment(), HASH_UNREFERENCE);
				}
			}
		}
		return unreferenceMethodBind;
	}

	/**
	 * Call reference() on the object. Uses method_bind_call (Variant-based) for
	 * type safety — if the object is not actually RefCounted, the call fails
	 * gracefully instead of corrupting memory.
	 */
	public static boolean reference(long ptr) {
		if (ptr == 0)
			return false;
		// Only reference once per pointer
		if (REFFED.putIfAbsent(ptr, Boolean.TRUE) != null)
			return true; // already reffed

		MemorySegment mb = getReferenceMethodBind();
		if (mb == null || mb.address() == 0) {
			REFFED.remove(ptr);
			return false;
		}

		try {
			// Use method_bind_call for type safety — it handles non-RefCounted objects
			// gracefully (returns error code instead of corrupting memory).
			MemorySegment retVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(12);
			Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, mb, MemorySegment.ofAddress(ptr), MemorySegment.NULL, 0L,
					retVar, errorVar);
			int errorCode = errorVar.get(JAVA_INT, 0);
			Bridge.destroyVariant(retVar);
			if (errorCode != 0) {
				// Object is not RefCounted or method failed — safe to skip
				REFFED.remove(ptr);
				return false;
			}
			return true;
		} catch (Exception e) {
			REFFED.remove(ptr);
			return false;
		}
	}

	/**
	 * Call unreference() on the object. Called when the Java wrapper is freed. Uses
	 * method_bind_call for type safety.
	 */
	public static void unreference(long ptr) {
		if (ptr == 0)
			return;
		if (!REFFED.remove(ptr, Boolean.TRUE))
			return; // wasn't reffed by us

		MemorySegment mb = getUnreferenceMethodBind();
		if (mb == null || mb.address() == 0)
			return;

		try {
			MemorySegment retVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(12);
			Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, mb, MemorySegment.ofAddress(ptr), MemorySegment.NULL, 0L,
					retVar, errorVar);
			Bridge.destroyVariant(retVar);
		} catch (Exception e) {
			// Object may already be freed
		}
	}
}
