package org.godot.bridge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.Godot;
import org.godot.core.GodotStringName;
import org.godot.internal.GodotClassRegistry;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VirtualMethods;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.JavaObjectMap;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.godot.internal.ref.GenericGodotObject;

import static java.lang.foreign.ValueLayout.*;

/**
 * Virtual method dispatch for GDExtension class lifecycle callbacks.
 *
 * <p>
 * Architecture (aligned with gdext/Rust bindings):
 * <ol>
 * <li><b>Compile-time hash resolution</b> — the APT processor generates
 * dispatch data with exact hashes from the parent class hierarchy, aligned with
 * gdext's proc-macro approach. This eliminates false matches from unrelated
 * classes.</li>
 * <li><b>Lazy stub creation</b> — upcall stubs are created only for methods the
 * user actually overrides. No wasted stubs for 1000+ unneeded virtual
 * methods.</li>
 * <li><b>Per-class get_virtual_func</b> — each registered class gets its own
 * upcall stub with the class name pre-bound. Returns NULL for non-overridden
 * methods so Godot uses its default C++ implementation.</li>
 * <li><b>Hash → name reverse lookup</b> — Godot identifies virtuals by
 * compatibility hash. The Dispatch facade resolves hash to candidate method
 * names (typically 2-5, not 50+). Hash collisions within a hierarchy are
 * resolved by StringName pointer comparison.</li>
 * </ol>
 * <p>
 * All reflection has been eliminated. Override discovery, hash resolution, and
 * virtual dispatch are handled by the APT-generated DispatchIndex via the
 * {@link Dispatch} facade.
 */
public final class VirtualDispatch {

	private static final Logger logger = LogManager.getLogger(VirtualDispatch.class);

	private VirtualDispatch() {
	}

	// ------------------------------------------------------------------------
	// Per-class dispatch data
	// ------------------------------------------------------------------------

	/** Per-class get_virtual_func upcall stubs: godotClassName → stub. */
	private static final Map<String, MemorySegment> PER_CLASS_GET_VIRTUAL_STUBS = new ConcurrentHashMap<>();

	/** Per-class dispatch metadata: godotClassName → dispatch data. */
	private static final Map<String, ClassDispatchData> CLASS_DISPATCH_DATA = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// AptDispatchData — loaded from Dispatch facade
	// ------------------------------------------------------------------------

	private static class AptDispatchData {
		final Map<Long, Set<String>> hashToNames;
		final Set<String> allVirtualNames;

		AptDispatchData(Map<Long, Set<String>> hashToNames, Set<String> allVirtualNames) {
			this.hashToNames = hashToNames;
			this.allVirtualNames = allVirtualNames;
		}
	}

	private static class ClassDispatchData {
		final Map<String, MethodEntry> methodsByName;
		final Set<String> overriddenNames;
		/**
		 * Per-parent-class hash map (from Dispatch), or null to use global fallback.
		 */
		final AptDispatchData aptData;

		ClassDispatchData(Map<String, MethodEntry> methodsByName, Set<String> overriddenNames,
				AptDispatchData aptData) {
			this.methodsByName = methodsByName;
			this.overriddenNames = overriddenNames;
			this.aptData = aptData;
		}
	}

	private static class MethodEntry {
		final String methodName;
		final MemorySegment callStub;
		final long nameDataPtr;

		MethodEntry(String methodName, MemorySegment callStub, long nameDataPtr) {
			this.methodName = methodName;
			this.callStub = callStub;
			this.nameDataPtr = nameDataPtr;
		}
	}

	// ------------------------------------------------------------------------
	// Function descriptors
	// ------------------------------------------------------------------------

	private static final FunctionDescriptor CALL_VIRTUAL_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG,
			ADDRESS);

	private static final FunctionDescriptor GET_VIRTUAL_FD = FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS,
			JAVA_LONG);

	// ------------------------------------------------------------------------
	// APT-generated data loading via Dispatch facade
	// ------------------------------------------------------------------------

	/**
	 * Load APT-generated per-parent-class dispatch data via the Dispatch facade.
	 * Returns null if no APT data is available (falls back to global map).
	 */
	private static AptDispatchData loadAptDispatchData(String parentClassName) {
		Map<Long, Set<String>> hashToNames = Dispatch.getVirtualHashToNames(parentClassName);
		Set<String> allVirtualNames = Dispatch.getVirtualAllNames(parentClassName);

		if ((hashToNames == null || hashToNames.isEmpty()) && (allVirtualNames == null || allVirtualNames.isEmpty())) {
			logger.debug("No APT dispatch data for parent '{}', using global fallback", parentClassName);
			return null;
		}

		logger.debug("Loaded dispatch data for parent '{}': {} virtual methods", parentClassName,
				allVirtualNames != null ? allVirtualNames.size() : 0);
		return new AptDispatchData(hashToNames != null ? hashToNames : Map.of(),
				allVirtualNames != null ? allVirtualNames : Set.of());
	}

	// ------------------------------------------------------------------------
	// Per-class get_virtual_func creation (called at registration time)
	// ------------------------------------------------------------------------

	public static MemorySegment getGetVirtualFuncStubForClass(String godotClassName) {
		return PER_CLASS_GET_VIRTUAL_STUBS.computeIfAbsent(godotClassName, name -> {
			// Get override set from Dispatch (APT-generated, zero reflection)
			Set<String> overriddenMethods = Dispatch.getVirtualOverrides(name);
			if (overriddenMethods == null || overriddenMethods.isEmpty()) {
				overriddenMethods = Set.of();
			}

			// Try APT-generated per-parent-class data first
			String parentClass = InstanceCallbacks.getParentClassName(name);
			AptDispatchData aptData = parentClass != null ? loadAptDispatchData(parentClass) : null;

			Set<String> allVirtualNames = aptData != null ? aptData.allVirtualNames : getAllVirtualNames();

			Map<String, MethodEntry> methodsByName = new HashMap<>();
			Set<String> matchedNames = new HashSet<>();

			for (String methodName : overriddenMethods) {
				String godotName = methodName;
				boolean isVirtual = allVirtualNames.contains(godotName);
				if (!isVirtual) {
					godotName = javaToGodotMethodName(methodName);
					isVirtual = allVirtualNames.contains(godotName);
				}
				if (!isVirtual) {
					continue;
				}

				try {
					GodotStringName sn = GodotStringName.fromJavaString(godotName);
					long nameDataPtr = sn.segment().get(ADDRESS, 0).address();

					// Create dispatch stub that delegates to Dispatch.dispatchVirtual()
					MethodHandle adapter = MethodHandles.lookup().findStatic(VirtualDispatch.class,
							"callVirtualAdapter", MethodType.methodType(void.class, String.class, MemorySegment.class,
									MemorySegment.class, long.class, MemorySegment.class));
					MethodHandle bound = MethodHandles.insertArguments(adapter, 0, godotName);
					MemorySegment callStub = Bridge.linker().upcallStub(bound, CALL_VIRTUAL_FD, Bridge.arena());

					MethodEntry entry = new MethodEntry(godotName, callStub, nameDataPtr);
					methodsByName.put(godotName, entry);
					matchedNames.add(godotName);
				} catch (Exception e) {
					logger.warn("Failed to create call stub for virtual method '{}': {}", godotName, e.getMessage());
				}
			}

			CLASS_DISPATCH_DATA.put(name, new ClassDispatchData(methodsByName, matchedNames, aptData));

			try {
				MethodHandle gvh = MethodHandles.lookup().findStatic(VirtualDispatch.class, "getVirtualFunc",
						MethodType.methodType(MemorySegment.class, String.class, MemorySegment.class,
								MemorySegment.class, long.class));
				MethodHandle bound = MethodHandles.insertArguments(gvh, 0, name);
				MemorySegment stub = Bridge.linker().upcallStub(bound, GET_VIRTUAL_FD, Bridge.arena());

				String dataSource = aptData != null ? "APT per-class" : "global fallback";
				logger.info("Created per-class get_virtual_func for '{}' ({} overrides: {}, {})", name,
						matchedNames.size(), matchedNames, dataSource);
				return stub;
			} catch (Exception e) {
				throw new RuntimeException("Failed to create get_virtual_func stub for " + name, e);
			}
		});
	}

	// ------------------------------------------------------------------------
	// get_virtual_func — per-class dispatch (called by Godot)
	// ------------------------------------------------------------------------

	static MemorySegment getVirtualFunc(String godotClassName, MemorySegment userdata, MemorySegment namePtr,
			long compatHash) {
		ClassDispatchData dispatchData = CLASS_DISPATCH_DATA.get(godotClassName);
		if (dispatchData == null) {
			return MemorySegment.NULL;
		}

		// Normalize hash to unsigned 32-bit
		long normalizedHash = compatHash & 0xFFFFFFFFL;

		// Use APT-generated per-parent-class data when available
		Set<String> candidateNames;
		if (dispatchData.aptData != null) {
			candidateNames = dispatchData.aptData.hashToNames.get(normalizedHash);
		} else {
			candidateNames = VirtualMethods.HASH_TO_NAMES.get(normalizedHash);
		}

		if (candidateNames == null || candidateNames.isEmpty()) {
			return MemorySegment.NULL;
		}

		List<MethodEntry> matches = new ArrayList<>();
		for (String name : candidateNames) {
			MethodEntry entry = dispatchData.methodsByName.get(name);
			if (entry != null) {
				matches.add(entry);
			}
		}

		if (matches.isEmpty()) {
			return MemorySegment.NULL;
		}

		if (matches.size() == 1) {
			if (candidateNames.size() > 1 && namePtr.address() != 0) {
				MemorySegment sizedNamePtr = namePtr.reinterpret(ADDRESS.byteSize());
				long passedDataPtr = sizedNamePtr.get(ADDRESS, 0).address();
				if (matches.get(0).nameDataPtr != passedDataPtr) {
					return MemorySegment.NULL;
				}
			}
			return matches.get(0).callStub;
		}

		// Hash collision — disambiguate by StringName pointer
		if (namePtr.address() != 0) {
			MemorySegment sizedNamePtr = namePtr.reinterpret(ADDRESS.byteSize());
			long passedDataPtr = sizedNamePtr.get(ADDRESS, 0).address();
			for (MethodEntry entry : matches) {
				if (entry.nameDataPtr == passedDataPtr) {
					return entry.callStub;
				}
			}
		}

		return MemorySegment.NULL;
	}

	// ------------------------------------------------------------------------
	// callVirtualAdapter — dispatch to user's Java method via Dispatch
	// ------------------------------------------------------------------------

	static void callVirtualAdapter(String methodName, MemorySegment instance, MemorySegment args, long argCount,
			MemorySegment ret) {
		org.godot.internal.DebugLogger.logVirtual("dispatch", methodName, true);

		// Discard re-entrant upcall during downcall — native pointers are ephemeral
		if (Bridge.isInDowncall()) {
			writeNil(ret);
			return;
		}

		long instanceAddr = instance.address();
		Godot obj = JavaObjectMap.get(instanceAddr);
		if (obj == null) {
			logger.error("VirtualDispatch: no Java object for instance 0x{} method={}", Long.toHexString(instanceAddr),
					methodName);
			writeNil(ret);
			return;
		}

		// Resolve the Godot class name for this object
		String godotClassName = resolveGodotClassName(obj);

		if (godotClassName != null && Dispatch.isAvailable()) {
			try {
				Dispatch.dispatchVirtual(godotClassName, methodName, instance, args, argCount, ret);
				return;
			} catch (Exception e) {
				logger.error("VirtualDispatch dispatchVirtual error in {}: {}", methodName, e.getMessage(), e);
				writeNil(ret);
				return;
			}
		}

		// Fallback when Dispatch is not available — should not happen in normal
		// operation
		logger.warn("VirtualDispatch: no dispatch path for method {} on {} (Dispatch available={})", methodName,
				obj.getClass().getName(), Dispatch.isAvailable());
		writeNil(ret);
	}

	/**
	 * Resolve the Godot class name from a Java object using the Dispatch facade
	 * (APT-generated FQN-to-godot-name mapping).
	 */
	private static String resolveGodotClassName(Godot obj) {
		String name = Dispatch.getGodotClassName(obj.getClass().getName());
		if (name != null) {
			return name;
		}
		// Walk superclass hierarchy as fallback
		Class<?> current = obj.getClass().getSuperclass();
		while (current != null && current != Godot.class) {
			name = Dispatch.getGodotClassName(current.getName());
			if (name != null) {
				return name;
			}
			current = current.getSuperclass();
		}
		return null;
	}

	// ------------------------------------------------------------------------
	// Return value helpers
	// ------------------------------------------------------------------------

	private static void writeNil(MemorySegment ret) {
		if (ret.address() != 0) {
			Bridge.callVoid(ApiIndex.VARIANT_NEW_NIL, ret);
		}
	}

	// ------------------------------------------------------------------------
	// Typed Godot object wrapping (used by APT-generated dispatch code)
	// ------------------------------------------------------------------------

	/**
	 * Create or reuse a typed Godot wrapper for a native object pointer. Uses
	 * GodotClassRegistry for zero-reflection instantiation, with fallback to
	 * GenericGodotObject.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Godot> T wrapObject(Class<T> type, long ptr) {
		Godot existing = JavaObjectMap.get(ptr);
		if (existing != null && type.isInstance(existing)) {
			return (T) existing;
		}

		// Try GodotClassRegistry (zero-reflection, generated at compile time)
		Godot created = GodotClassRegistry.create(type.getSimpleName(), ptr);
		if (created != null && type.isInstance(created)) {
			return (T) created;
		}

		// Fallback to generic wrapper
		return (T) new GenericGodotObject(ptr, "Object");
	}

	// ------------------------------------------------------------------------
	// Virtual method name helpers (global fallback)
	// ------------------------------------------------------------------------

	private static Set<String> getAllVirtualNames() {
		Set<String> names = new HashSet<>();
		for (Set<String> nameSet : VirtualMethods.HASH_TO_NAMES.values()) {
			names.addAll(nameSet);
		}
		return names;
	}

	private static String javaToGodotMethodName(String javaName) {
		if (javaName.length() <= 1) {
			return javaName;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < javaName.length(); i++) {
			char c = javaName.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append('_').append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
