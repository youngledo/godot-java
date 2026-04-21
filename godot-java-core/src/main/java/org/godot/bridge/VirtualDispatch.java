package org.godot.bridge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.Godot;
import org.godot.annotation.GodotClass;
import org.godot.core.GodotStringName;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VirtualMethods;
import org.godot.internal.ref.JavaObjectMap;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.foreign.ValueLayout.*;

/**
 * Virtual method dispatch for GDExtension class lifecycle callbacks.
 *
 * <p>
 * Architecture (aligned with gdext/Rust bindings):
 * <ol>
 * <li><b>Compile-time hash resolution</b> — the APT processor generates
 * {@code VirtualDispatch_<ParentClass>} with exact hashes from the parent class
 * hierarchy, aligned with gdext's proc-macro approach. This eliminates false
 * matches from unrelated classes.</li>
 * <li><b>Lazy stub creation</b> — upcall stubs are created only for methods the
 * user actually overrides. No wasted stubs for 1000+ unneeded virtual
 * methods.</li>
 * <li><b>Per-class get_virtual_func</b> — each registered class gets its own
 * upcall stub with the class name pre-bound. Returns NULL for non-overridden
 * methods so Godot uses its default C++ implementation.</li>
 * <li><b>Hash → name reverse lookup</b> — Godot identifies virtuals by
 * compatibility hash. The APT-generated per-parent-class map resolves hash to
 * candidate method names (typically 2-5, not 50+). Hash collisions within a
 * hierarchy are resolved by StringName pointer comparison.</li>
 * </ol>
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

	/** Per-class method cache: Java Class → (method name → Method). */
	private static final Map<Class<?>, Map<String, Method>> PER_CLASS_METHOD_CACHE = new ConcurrentHashMap<>();

	/** Cache for APT-generated per-parent-class dispatch data. */
	private static final Map<String, AptDispatchData> APT_DISPATCH_CACHE = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// AptDispatchData — loaded from APT-generated VirtualDispatch_<Parent> classes
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
		/** Per-parent-class hash map (from APT), or null to use global fallback. */
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
		final MethodHandle handle;
		final Class<?>[] paramTypes;

		MethodEntry(String methodName, MemorySegment callStub, long nameDataPtr, MethodHandle handle,
				Class<?>[] paramTypes) {
			this.methodName = methodName;
			this.callStub = callStub;
			this.nameDataPtr = nameDataPtr;
			this.handle = handle;
			this.paramTypes = paramTypes;
		}
	}

	// ------------------------------------------------------------------------
	// Function descriptors
	// ------------------------------------------------------------------------

	private static final FunctionDescriptor CALL_VIRTUAL_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);

	private static final FunctionDescriptor GET_VIRTUAL_FD = FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS,
			JAVA_LONG);

	// ------------------------------------------------------------------------
	// APT-generated data loading
	// ------------------------------------------------------------------------

	/**
	 * Load APT-generated per-parent-class dispatch data via reflection. Returns
	 * null if no APT data is available (falls back to global map).
	 */

	@SuppressWarnings("unchecked")
	private static AptDispatchData loadAptDispatchData(String parentClassName) {
		return APT_DISPATCH_CACHE.computeIfAbsent(parentClassName, parent -> {
			try {
				Class<?> dispatchClass = Class.forName("org.godot.internal.VirtualDispatch_" + parent);
				java.lang.reflect.Field htnField = dispatchClass.getDeclaredField("HASH_TO_NAMES");
				htnField.setAccessible(true);
				@SuppressWarnings("unchecked")
				Map<Long, Set<String>> hashToNames = (Map<Long, Set<String>>) htnField.get(null);
				java.lang.reflect.Field avnField = dispatchClass.getDeclaredField("ALL_VIRTUAL_NAMES");
				avnField.setAccessible(true);
				Set<String> allVirtualNames = (Set<String>) avnField.get(null);
				logger.debug("Loaded APT dispatch data for parent '{}': {} virtual methods", parent,
						allVirtualNames.size());
				return new AptDispatchData(hashToNames, allVirtualNames);
			} catch (ClassNotFoundException e) {
				logger.debug("No APT dispatch data for parent '{}', using global fallback", parent);
				return null;
			} catch (ReflectiveOperationException e) {
				logger.warn("Failed to load APT dispatch data for parent '{}': {}", parent, e.getMessage());
				return null;
			}
		});
	}

	// ------------------------------------------------------------------------
	// Per-class get_virtual_func creation (called at registration time)
	// ------------------------------------------------------------------------

	public static MemorySegment getGetVirtualFuncStubForClass(String godotClassName) {
		return PER_CLASS_GET_VIRTUAL_STUBS.computeIfAbsent(godotClassName, name -> {
			Class<?> javaClass = InstanceCallbacks.getJavaClass(name);
			Set<String> overriddenMethods = javaClass != null ? scanOverrides(javaClass) : Set.of();

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
					MethodHandle adapter = MethodHandles.lookup().findStatic(VirtualDispatch.class,
							"callVirtualAdapter", MethodType.methodType(void.class, String.class, MemorySegment.class,
									MemorySegment.class, MemorySegment.class));
					MethodHandle bound = MethodHandles.insertArguments(adapter, 0, godotName);
					MemorySegment callStub = Bridge.linker().upcallStub(bound, CALL_VIRTUAL_FD, Bridge.arena());

					GodotStringName sn = GodotStringName.fromJavaString(godotName);
					long nameDataPtr = sn.segment().get(ADDRESS, 0).address();

					// Pre-create MethodHandle for zero-reflection dispatch
					MethodHandle methodHandle = null;
					Class<?>[] paramTypes = null;
					try {
						Method m = findMethodOnClassHierarchy(javaClass, godotName);
						if (m != null) {
							m.setAccessible(true);
							methodHandle = MethodHandles.lookup().unreflect(m)
									.asType(MethodType.methodType(m.getReturnType(), Godot.class)
											.appendParameterTypes(m.getParameterTypes()));
							paramTypes = m.getParameterTypes();
						}
					} catch (Exception e) {
						logger.trace("Could not create MethodHandle for {}", godotName);
					}
					MethodEntry entry = new MethodEntry(godotName, callStub, nameDataPtr, methodHandle, paramTypes);
					methodsByName.put(godotName, entry);
					matchedNames.add(godotName);
				} catch (ReflectiveOperationException e) {
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
			} catch (ReflectiveOperationException e) {
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
			// If the hash maps to multiple candidate names (collision), verify
			// StringName before returning. Otherwise a _ready override would
			// also be returned for _enter_tree, _exit_tree etc. which share
			// the same hash but are NOT overridden.
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
	// callVirtualAdapter — dispatch to user's Java method
	// ------------------------------------------------------------------------

	static void callVirtualAdapter(String methodName, MemorySegment instance, MemorySegment args, MemorySegment ret) {
		org.godot.internal.DebugLogger.logVirtual("dispatch", methodName, true);
		long instanceAddr = instance.address();
		Godot obj = JavaObjectMap.get(instanceAddr);
		if (obj == null) {
			logger.error("VirtualDispatch: no Java object for instance 0x{} method={}", Long.toHexString(instanceAddr),
					methodName);
			writeNil(ret);
			return;
		}

		// Try pre-cached dispatch data (avoids per-call Method lookup)
		MethodEntry cachedEntry = findMethodEntry(obj.getClass(), methodName);
		if (cachedEntry != null && cachedEntry.handle != null) {
			try {
				Object[] javaArgs = cachedEntry.paramTypes != null && cachedEntry.paramTypes.length > 0
						? convertArgs0(args, cachedEntry.paramTypes)
						: new Object[0];
				Object result = cachedEntry.handle.invokeWithArguments(prependReceiver(obj, javaArgs));

				if (ret.address() != 0) {
					if (result != null) {
						Variant retVar = VariantUtils.fromObject(result);
						Bridge.callVoid(ApiIndex.VARIANT_NEW_COPY, ret, retVar.getSegment());
					} else {
						writeNil(ret);
					}
				}
				return;
			} catch (Throwable t) {
				logger.error("VirtualDispatch cached dispatch error in {}: {}", methodName, t.getMessage(), t);
				writeNil(ret);
				return;
			}
		}

		// Fallback: reflection-based dispatch
		Method javaMethod = findMethodOnClassHierarchy(obj.getClass(), methodName);
		if (javaMethod == null) {
			logger.warn("VirtualDispatch: method {} not found on {}", methodName, obj.getClass().getName());
			writeNil(ret);
			return;
		}

		try {
			Object[] javaArgs = convertArgs(javaMethod, args);
			Object result = javaMethod.invoke(obj, javaArgs);

			if (ret.address() != 0) {
				if (result != null) {
					Variant retVar = VariantUtils.fromObject(result);
					Bridge.callVoid(ApiIndex.VARIANT_NEW_COPY, ret, retVar.getSegment());
				} else {
					writeNil(ret);
				}
			}
		} catch (Throwable t) {
			logger.error("VirtualDispatch error in {}: {}", methodName, t.getMessage(), t);
			writeNil(ret);
		}
	}

	/**
	 * Find a cached MethodEntry by walking the class hierarchy and checking
	 * dispatch data.
	 */
	private static MethodEntry findMethodEntry(Class<?> javaClass, String methodName) {
		// Walk class hierarchy to find the @GodotClass annotation
		Class<?> current = javaClass;
		while (current != null && current != Godot.class) {
			GodotClass ann = current.getAnnotation(GodotClass.class);
			if (ann != null) {
				ClassDispatchData data = CLASS_DISPATCH_DATA.get(ann.name());
				if (data != null) {
					MethodEntry entry = data.methodsByName.get(methodName);
					if (entry != null)
						return entry;
					// Try java-style name
					String godotName = javaToGodotMethodName(methodName);
					entry = data.methodsByName.get(godotName);
					if (entry != null)
						return entry;
				}
			}
			current = current.getSuperclass();
		}
		return null;
	}

	private static Object[] prependReceiver(Object receiver, Object[] args) {
		Object[] result = new Object[1 + args.length];
		result[0] = receiver;
		System.arraycopy(args, 0, result, 1, args.length);
		return result;
	}

	// ------------------------------------------------------------------------
	// Argument conversion
	// ------------------------------------------------------------------------

	private static Object[] convertArgs(Method javaMethod, MemorySegment args) {
		return convertArgs0(args, javaMethod.getParameterTypes());
	}

	private static Object[] convertArgs0(MemorySegment args, Class<?>[] paramTypes) {
		int n = paramTypes.length;
		if (n == 0) {
			return new Object[0];
		}

		MemorySegment sizedArgs = args.reinterpret(n * ADDRESS.byteSize());

		Object[] result = new Object[n];
		for (int i = 0; i < n; i++) {
			Class<?> pt = paramTypes[i];
			MemorySegment argPtr = sizedArgs.get(ADDRESS, (long) i * ADDRESS.byteSize());

			if (argPtr.address() == 0 || argPtr.equals(MemorySegment.NULL)) {
				result[i] = null;
				continue;
			}

			if (pt == double.class || pt == Double.class) {
				result[i] = argPtr.reinterpret(8).get(JAVA_DOUBLE, 0);
			} else if (pt == float.class || pt == Float.class) {
				result[i] = (float) argPtr.reinterpret(4).get(JAVA_FLOAT, 0);
			} else if (pt == int.class || pt == Integer.class) {
				result[i] = argPtr.reinterpret(4).get(JAVA_INT, 0);
			} else if (pt == long.class || pt == Long.class) {
				result[i] = argPtr.reinterpret(8).get(JAVA_LONG, 0);
			} else if (pt == boolean.class || pt == Boolean.class) {
				result[i] = argPtr.get(JAVA_BYTE, 0) != 0;
			} else if (pt == String.class) {
				result[i] = new org.godot.core.GodotString(argPtr);
			} else {
				long ptr = argPtr.get(ADDRESS, 0).address();
				if (ptr == 0) {
					result[i] = null;
				} else {
					Variant objVar = Variant.fromObjectPtr(ptr);
					result[i] = VariantUtils.toObject(objVar);
				}
			}
		}
		return result;
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
	// Virtual method name helpers (global fallback)
	// ------------------------------------------------------------------------

	private static Set<String> getAllVirtualNames() {
		Set<String> names = new HashSet<>();
		for (Set<String> nameSet : VirtualMethods.HASH_TO_NAMES.values()) {
			names.addAll(nameSet);
		}
		return names;
	}

	// ------------------------------------------------------------------------
	// Reflection helpers
	// ------------------------------------------------------------------------

	private static Set<String> scanOverrides(Class<?> javaClass) {
		Set<String> overrides = new HashSet<>();
		Class<?> current = javaClass;
		while (current != null && current != Godot.class) {
			for (Method m : current.getDeclaredMethods()) {
				if (m.getName().startsWith("_") && Modifier.isPublic(m.getModifiers())) {
					overrides.add(m.getName());
				}
			}
			current = current.getSuperclass();
		}
		return overrides;
	}

	private static Method findMethodOnClassHierarchy(Class<?> clazz, String godotMethodName) {
		Map<String, Method> classCache = PER_CLASS_METHOD_CACHE.computeIfAbsent(clazz, c -> {
			Map<String, Method> cache = new HashMap<>();
			Class<?> current = c;
			while (current != null) {
				for (Method m : current.getDeclaredMethods()) {
					if (m.getName().startsWith("_") && Modifier.isPublic(m.getModifiers())) {
						m.setAccessible(true);
						cache.putIfAbsent(m.getName(), m);
					}
				}
				current = current.getSuperclass();
			}
			return cache;
		});

		String javaName = godotToJavaMethodName(godotMethodName);
		Method m = classCache.get(javaName);
		if (m != null) {
			return m;
		}
		return classCache.get(godotMethodName);
	}

	private static String godotToJavaMethodName(String godotName) {
		if (godotName.length() <= 1) {
			return godotName;
		}
		String rest = godotName.substring(1);
		StringBuilder sb = new StringBuilder("_");
		boolean capitalizeNext = false;
		for (int i = 0; i < rest.length(); i++) {
			char c = rest.charAt(i);
			if (c == '_' && i < rest.length() - 1) {
				capitalizeNext = true;
			} else {
				sb.append(capitalizeNext ? Character.toUpperCase(c) : c);
				capitalizeNext = false;
			}
		}
		return sb.toString();
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
