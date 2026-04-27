package org.godot.bridge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.Godot;
import org.godot.internal.GodotClassRegistry;
import org.godot.internal.api.VirtualMethods;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.JavaObjectMap;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.godot.internal.ref.GenericGodotObject;

import static java.lang.foreign.ValueLayout.*;

/**
 * Virtual method dispatch for GDExtension class lifecycle callbacks.
 *
 * <p>
 * Implements Godot 4.6's two-phase virtual dispatch:
 * <ol>
 * <li><b>get_virtual_call_data_func</b> — called once per virtual method at
 * class registration. Returns opaque userdata identifying the overridden
 * method, or NULL if not overridden.</li>
 * <li><b>call_virtual_with_data_func</b> — called every time the virtual method
 * is invoked. Receives the userdata from phase 1, plus instance, name, args,
 * and ret pointers.</li>
 * </ol>
 * <p>
 * This replaces the deprecated get_virtual_func approach which returned
 * per-method function pointers. The new API uses a single shared call stub with
 * userdata-based dispatch, eliminating per-method upcall stub creation.
 * <p>
 * All reflection has been eliminated. Override discovery and hash resolution
 * are handled by the APT-generated DispatchIndex via the {@link Dispatch}
 * facade. Argument counts are hardcoded in the generated dispatch code (known
 * at compile time from method signatures).
 */
public final class VirtualDispatch {

	private static final Logger logger = LogManager.getLogger(VirtualDispatch.class);

	private VirtualDispatch() {
	}

	// ------------------------------------------------------------------------
	// Function descriptors for the two-phase virtual dispatch API
	// ------------------------------------------------------------------------

	// get_virtual_call_data_func:
	// void* get_virtual_call_data(void* class_userdata,
	// GDExtensionConstStringNamePtr name,
	// uint32_t hash)
	private static final FunctionDescriptor GET_VIRTUAL_CALL_DATA_FD = FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS,
			JAVA_INT);

	// call_virtual_with_data_func:
	// void call_virtual_with_data(GDExtensionClassInstancePtr instance,
	// GDExtensionConstStringNamePtr name,
	// void* virtual_call_userdata,
	// const GDExtensionConstTypePtr* args,
	// GDExtensionTypePtr ret)
	private static final FunctionDescriptor CALL_VIRTUAL_WITH_DATA_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS,
			ADDRESS, ADDRESS, ADDRESS);

	// ------------------------------------------------------------------------
	// Shared upcall stubs (created once, used for all classes)
	// ------------------------------------------------------------------------

	private static final MemorySegment GET_VIRTUAL_CALL_DATA_STUB;
	private static final MemorySegment CALL_VIRTUAL_WITH_DATA_STUB;

	static {
		try {
			MethodHandle gvcd = MethodHandles.lookup().findStatic(VirtualDispatch.class, "getVirtualCallDataFunc",
					MethodType.methodType(MemorySegment.class, MemorySegment.class, MemorySegment.class, int.class));
			GET_VIRTUAL_CALL_DATA_STUB = Bridge.linker().upcallStub(gvcd, GET_VIRTUAL_CALL_DATA_FD, Bridge.ARENA);

			MethodHandle cvwd = MethodHandles.lookup().findStatic(VirtualDispatch.class, "callVirtualWithDataFunc",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class,
							MemorySegment.class, MemorySegment.class));
			CALL_VIRTUAL_WITH_DATA_STUB = Bridge.linker().upcallStub(cvwd, CALL_VIRTUAL_WITH_DATA_FD, Bridge.ARENA);

			logger.info("Virtual dispatch stubs created (two-phase API)");
		} catch (Exception e) {
			throw new RuntimeException("Failed to create virtual dispatch stubs", e);
		}
	}

	// ------------------------------------------------------------------------
	// Per-class dispatch data
	// ------------------------------------------------------------------------

	/** Per-class dispatch metadata: godotClassName → dispatch data. */
	private static final Map<String, ClassDispatchData> CLASS_DISPATCH_DATA = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// Userdata mapping for virtual method identification
	// ------------------------------------------------------------------------

	private static final AtomicLong NEXT_USERDATA_ID = new AtomicLong(1);
	private static final ConcurrentHashMap<Long, String> USERDATA_TO_METHOD = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// Inner classes
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
		final Set<String> overriddenNames;
		final AptDispatchData aptData;

		ClassDispatchData(Set<String> overriddenNames, AptDispatchData aptData) {
			this.overriddenNames = overriddenNames;
			this.aptData = aptData;
		}
	}

	// ------------------------------------------------------------------------
	// APT-generated data loading via Dispatch facade
	// ------------------------------------------------------------------------

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
	// Class registration (called from InstanceCallbacks.createCreationInfo)
	// ------------------------------------------------------------------------

	/**
	 * Register per-class dispatch data for virtual method resolution. Called at
	 * class registration time — no upcall stubs created here.
	 */
	public static void registerClassDispatchData(String godotClassName) {
		CLASS_DISPATCH_DATA.computeIfAbsent(godotClassName, name -> {
			Set<String> overriddenMethods = Dispatch.getVirtualOverrides(name);
			if (overriddenMethods == null || overriddenMethods.isEmpty()) {
				overriddenMethods = Set.of();
			}

			// Expand Java method names to Godot names if needed
			Set<String> godotOverrideNames = new HashSet<>();
			for (String methodName : overriddenMethods) {
				godotOverrideNames.add(methodName);
				godotOverrideNames.add(javaToGodotMethodName(methodName));
			}

			String parentClass = InstanceCallbacks.getParentClassName(name);
			AptDispatchData aptData = parentClass != null ? loadAptDispatchData(parentClass) : null;

			Set<String> allVirtualNames = aptData != null ? aptData.allVirtualNames : getAllVirtualNames();

			// Filter to only include methods that are actual virtuals
			Set<String> matchedNames = new HashSet<>();
			for (String godotName : godotOverrideNames) {
				if (allVirtualNames.contains(godotName)) {
					matchedNames.add(godotName);
				}
			}

			String dataSource = aptData != null ? "APT per-class" : "global fallback";
			logger.info("Registered dispatch data for '{}' ({} overrides: {}, {})", name, matchedNames.size(),
					matchedNames, dataSource);

			return new ClassDispatchData(matchedNames, aptData);
		});
	}

	// ------------------------------------------------------------------------
	// Public stub accessors
	// ------------------------------------------------------------------------

	public static MemorySegment getVirtualCallDataStub() {
		return GET_VIRTUAL_CALL_DATA_STUB;
	}

	public static MemorySegment callVirtualWithDataStub() {
		return CALL_VIRTUAL_WITH_DATA_STUB;
	}

	// ------------------------------------------------------------------------
	// get_virtual_call_data_func — Phase 1 (called by Godot once per virtual)
	// ------------------------------------------------------------------------

	static MemorySegment getVirtualCallDataFunc(MemorySegment classUserdata, MemorySegment namePtr, int hash) {
		// Resolve class name from class_userdata
		long userdataAddr = classUserdata.address();
		String className = resolveClassNameFromUserdata(userdataAddr);
		if (className == null) {
			return MemorySegment.NULL;
		}

		ClassDispatchData dispatchData = CLASS_DISPATCH_DATA.get(className);
		if (dispatchData == null) {
			return MemorySegment.NULL;
		}

		// Normalize hash to unsigned 32-bit
		long normalizedHash = hash & 0xFFFFFFFFL;

		// Find candidate method names for this hash
		Set<String> candidateNames;
		if (dispatchData.aptData != null) {
			candidateNames = dispatchData.aptData.hashToNames.get(normalizedHash);
		} else {
			candidateNames = VirtualMethods.HASH_TO_NAMES.get(normalizedHash);
		}

		if (candidateNames == null || candidateNames.isEmpty()) {
			return MemorySegment.NULL;
		}

		// Check if any candidate is overridden for this class
		for (String name : candidateNames) {
			if (dispatchData.overriddenNames.contains(name)) {
				// Allocate a unique userdata ID
				long id = NEXT_USERDATA_ID.getAndIncrement();
				USERDATA_TO_METHOD.put(id, name);
				return MemorySegment.ofAddress(id);
			}
		}

		return MemorySegment.NULL;
	}

	// ------------------------------------------------------------------------
	// call_virtual_with_data_func — Phase 2 (called by Godot on invocation)
	// ------------------------------------------------------------------------

	static void callVirtualWithDataFunc(MemorySegment instance, MemorySegment namePtr,
			MemorySegment virtualCallUserdata, MemorySegment args, MemorySegment ret) {
		long userdataId = virtualCallUserdata.address();
		String methodName = USERDATA_TO_METHOD.get(userdataId);
		if (methodName == null) {
			writeNil(ret);
			return;
		}

		org.godot.internal.DebugLogger.logVirtual("dispatch", methodName, true);

		// Discard re-entrant upcall during downcall or nested upcall
		if (Bridge.isInNativeCallback()) {
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
				Dispatch.dispatchVirtual(godotClassName, methodName, instance, args, ret);
				return;
			} catch (Exception e) {
				logger.error("VirtualDispatch dispatchVirtual error in {}: {}", methodName, e.getMessage(), e);
				writeNil(ret);
				return;
			}
		}

		logger.warn("VirtualDispatch: no dispatch path for method {} on {} (Dispatch available={})", methodName,
				obj.getClass().getName(), Dispatch.isAvailable());
		writeNil(ret);
	}

	// ------------------------------------------------------------------------
	// Class name resolution
	// ------------------------------------------------------------------------

	private static String resolveClassNameFromUserdata(long userdataAddr) {
		// class_userdata is the address of the class name StringName.
		// InstanceCallbacks maps this to the class name.
		return InstanceCallbacks.lookupClassName(userdataAddr);
	}

	private static String resolveGodotClassName(Godot obj) {
		String name = Dispatch.getGodotClassName(obj.getClass().getName());
		if (name != null) {
			return name;
		}
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
			Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_NIL, ret);
		}
	}

	// ------------------------------------------------------------------------
	// Typed Godot object wrapping (used by APT-generated dispatch code)
	// ------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public static <T extends Godot> T wrapObject(Class<T> type, long ptr) {
		Godot existing = JavaObjectMap.get(ptr);
		if (existing != null && type.isInstance(existing)) {
			return (T) existing;
		}

		Godot created = GodotClassRegistry.create(type.getSimpleName(), ptr);
		if (created != null && type.isInstance(created)) {
			return (T) created;
		}

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
