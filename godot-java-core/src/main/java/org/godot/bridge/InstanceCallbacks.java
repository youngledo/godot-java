package org.godot.bridge;

import org.godot.Godot;
import org.godot.core.GodotString;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.internal.api.VariantType;
import org.godot.internal.ref.JavaObjectMap;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.StructOffsets;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.dispatch.PropertyMeta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static java.lang.foreign.ValueLayout.*;
import java.lang.foreign.ValueLayout;

/**
 * Handles GDExtensionClassCreationInfo4 struct creation and the create/free
 * instance upcall stubs required by Godot's ClassDB class registration API.
 *
 * <p>
 * When Godot calls classdb_register_extension_class5(), it receives a pointer
 * to a GDExtensionClassCreationInfo4 struct containing function pointers for
 * lifecycle callbacks. The two mandatory callbacks are:
 *
 * <ul>
 * <li>{@code create_instance_func}: called when Godot needs to instantiate the
 * class
 * <li>{@code free_instance_func}: called when Godot destroys an instance
 * </ul>
 *
 * <p>
 * This class creates Panama upcall stubs for those callbacks and allocates the
 * struct in native memory with all fields populated.
 *
 * <p>
 * All reflection has been eliminated. Instance creation uses
 * {@link Dispatch#createInstance}, property access uses
 * {@link Dispatch#getProperty}/{@link Dispatch#setProperty}, and metadata
 * lookups use {@link Dispatch#getExports}/{@link Dispatch#getParentClass}.
 * Upcall stub creation uses {@link MethodHandles#findStatic} instead of
 * {@code getDeclaredMethod + unreflect}.
 */
public final class InstanceCallbacks {

	private static final Logger logger = LogManager.getLogger(InstanceCallbacks.class);

	private InstanceCallbacks() {
	}

	// ------------------------------------------------------------------------
	// Registration tracking — keeps native allocations alive
	// ------------------------------------------------------------------------

	/**
	 * Maps class_userdata pointer address → Godot class name. Used by
	 * create_instance_func to look up the class from the opaque userdata pointer.
	 */
	private static final Map<Long, String> USERDATA_TO_CLASS_NAME = new ConcurrentHashMap<>();

	/**
	 * Extension class name → parent class name in Godot's hierarchy. Populated from
	 * Dispatch at registration time.
	 */
	private static final Map<String, String> PARENT_CLASS_NAMES = new ConcurrentHashMap<>();

	/**
	 * Live creation info structs: className → struct MemorySegment. The struct
	 * memory stays alive because the Arena never frees until JVM shutdown.
	 */
	private static final Map<String, MemorySegment> LIVE_CREATION_INFO = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// Upcall stubs — kept alive by the Arena (freed at JVM shutdown)
	// ------------------------------------------------------------------------

	private static final Map<String, MemorySegment> CREATE_INSTANCE_STUBS = new ConcurrentHashMap<>();
	private static final Map<String, MemorySegment> FREE_INSTANCE_STUBS = new ConcurrentHashMap<>();

	// ------------------------------------------------------------------------
	// Upcall stub implementations
	//
	// These methods are called by Godot via the native function pointers
	// we register. They must match the GDExtension FFI calling convention.
	//
	// GDExtensionClassCreateInstance2:
	// void* create_instance_func(void* p_class_userdata, GDExtensionBool
	// p_notify_postinitialize)
	// → returns GDExtensionObjectPtr
	//
	// GDExtensionClassFreeInstance:
	// void free_instance_func(void* p_class_userdata, GDExtensionClassInstancePtr
	// p_instance)
	// ------------------------------------------------------------------------

	/**
	 * create_instance_func implementation.
	 *
	 * @param classUserdataPtr
	 *            Address of the class name StringName (stored as class_userdata)
	 * @param notifyPostinit
	 *            GDExtensionBool — if true, call postinitialize()
	 * @return GDExtensionObjectPtr
	 */
	static long createInstanceFunc(long classUserdataPtr, byte notifyPostinit) {
		if (classUserdataPtr == 0) {
			logger.error("createInstanceFunc: classUserdata is NULL");
			return 0;
		}

		String className = USERDATA_TO_CLASS_NAME.get(classUserdataPtr);
		if (className == null) {
			logger.error("createInstanceFunc: no class mapping for userdata=0x{}", Long.toHexString(classUserdataPtr));
			return 0;
		}

		try {
			// Look up parent class name for native construction
			String parentName = PARENT_CLASS_NAMES.getOrDefault(className, "RefCounted");

			// Construct the native Godot object using the parent class
			GodotStringName parentSn = GodotStringName.fromJavaString(parentName);
			MemorySegment nativeObj = Bridge.callPtr(ApiIndex.CLASSDB_CONSTRUCT_OBJECT2, parentSn.segment());
			long nativePtr = nativeObj.address();

			if (nativePtr == 0) {
				logger.error("classdb_construct_object2('{}') returned NULL", parentName);
				return 0;
			}

			// Create Java instance via Dispatch — uses APT-generated factory lambdas
			// that call setNativeObject() internally. Zero reflection.
			Godot instance = Dispatch.createInstance(className, nativePtr);
			if (instance == null) {
				logger.error("Dispatch.createInstance returned null for '{}'", className);
				return 0;
			}
			JavaObjectMap.put(nativePtr, instance);

			// Register the extension instance with Godot so virtual dispatch works.
			// object_set_instance(GDExtensionObjectPtr, StringName*,
			// GDExtensionClassInstancePtr)
			// The instance pointer is the native object address — dispatch uses it to look
			// up the Java object.
			GodotStringName classNameSn = GodotStringName.fromJavaString(className);
			Bridge.callVoid(ApiIndex.OBJECT_SET_INSTANCE, nativeObj, classNameSn.segment(), nativeObj);

			return nativePtr;
		} catch (Exception e) {
			throw new RuntimeException("godot-java: Failed to instantiate " + className, e);
		}
	}

	// ------------------------------------------------------------------------
	// Panama upcall adapters
	//
	// Panama FFI requires upcall method handles to accept MemorySegment arguments
	// (representing native pointers). These adapters unpack the segments to
	// primitives, call the actual implementation, then pack the result back.
	// ------------------------------------------------------------------------

	/**
	 * Panama adapter for create_instance_func. FD: ADDRESS
	 * create_instance_adapter(ADDRESS classUserdataPtr, JAVA_INT notifyPostinit)
	 * Unpacks MemorySegments → calls createInstanceFunc → returns MemorySegment.
	 */
	private static MemorySegment createInstanceAdapter(MemorySegment classUserdataPtrSeg, byte notifyPostinit) {
		long result = createInstanceFunc(classUserdataPtrSeg.address(), notifyPostinit);
		return MemorySegment.ofAddress(result);
	}

	/**
	 * free_instance_func implementation.
	 *
	 * @param classUserdataPtr
	 *            Address of the class name StringName (stored as class_userdata)
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr to destroy
	 */
	static void freeInstanceFunc(long classUserdataPtr, long instancePtr) {
		if (instancePtr != 0) {
			Godot obj = JavaObjectMap.get(instancePtr);
			if (obj != null) {
				obj.invalidate();
			}
			JavaObjectMap.remove(instancePtr);
		}
	}

	/**
	 * Panama adapter for free_instance_func. FD: void free_instance_adapter(ADDRESS
	 * classUserdataPtr, ADDRESS instancePtr) Unpacks MemorySegments → calls
	 * freeInstanceFunc.
	 */
	private static void freeInstanceAdapter(MemorySegment classUserdataPtrSeg, MemorySegment instancePtrSeg) {
		freeInstanceFunc(classUserdataPtrSeg.address(), instancePtrSeg.address());
	}

	// ------------------------------------------------------------------------
	// set_func / get_func — @Export property access callbacks
	// ------------------------------------------------------------------------

	/**
	 * set_func implementation: called by Godot to set a property value.
	 *
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr (the native object pointer)
	 * @param namePtr
	 *            Pointer to StringName containing the property name
	 * @param valuePtr
	 *            Pointer to Variant containing the new value
	 * @return 1 if property was handled, 0 otherwise
	 */
	static int setPropertyFunc(long instancePtr, long namePtr, long valuePtr) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj == null)
			return 0;

		String className = resolveGodotClassName(obj);
		if (className == null)
			return 0;

		// Convert StringName to Java String
		String propName = stringNamePtrToString(namePtr);

		// Read Variant value
		MemorySegment valueSeg = MemorySegment.ofAddress(valuePtr).reinterpret(Variant.SIZE);
		Variant variant = new Variant(valueSeg);
		Object javaValue = VariantUtils.toObject(variant);

		// Use Dispatch for typed property access — zero reflection
		boolean handled = Dispatch.setProperty(className, propName, obj, javaValue);
		if (handled)
			return 1;

		return 0;
	}

	/**
	 * get_func implementation: called by Godot to get a property value.
	 */
	static int getPropertyFunc(long instancePtr, long namePtr, long retPtr) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj == null)
			return 0;

		String className = resolveGodotClassName(obj);
		if (className == null)
			return 0;

		String propName = stringNamePtrToString(namePtr);

		// Use Dispatch for typed property access — zero reflection
		Object value = Dispatch.getProperty(className, propName, obj);
		if (value == null)
			return 0;

		try {
			Variant variant = VariantUtils.fromObject(value);
			MemorySegment retSeg = MemorySegment.ofAddress(retPtr).reinterpret(Variant.SIZE);
			MemorySegment srcSeg = variant.getSegment().reinterpret(Variant.SIZE);
			MemorySegment.copy(srcSeg, 0, retSeg, 0, Variant.SIZE);
			Bridge.destroyVariant(srcSeg);
			return 1;
		} catch (Exception e) {
			logger.error("getPropertyFunc variant conversion failed for {}.{}: {}", className, propName,
					e.getMessage());
			return 0;
		}
	}

	private static String stringNamePtrToString(long namePtr) {
		try {
			// Read the StringName opaque handle from the pointer (8 bytes)
			MemorySegment nameData = MemorySegment.ofAddress(namePtr).reinterpret(8);
			long handle = nameData.get(JAVA_LONG, 0);

			// Create a temporary StringName Variant from the pointer data
			MemorySegment variantBuf = Bridge.allocate(16);
			variantBuf.set(JAVA_INT, 0, org.godot.internal.api.VariantType.STRING_NAME.id());
			variantBuf.set(JAVA_LONG, 8, handle);

			// Use variant_stringify to convert to String
			MemorySegment retBuf = Bridge.allocate(8);
			Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_STRINGIFY, variantBuf, retBuf);
			org.godot.core.GodotString gs = new org.godot.core.GodotString(retBuf);
			String result = gs.toJavaString();
			gs.destroy();
			return result;
		} catch (Exception e) {
			logger.error("stringNamePtrToString failed: {}", e.getMessage());
			return "";
		}
	}

	/** Panama adapter for set_func: bool set(ADDRESS, ADDRESS, ADDRESS) */
	private static int setPropertyAdapter(MemorySegment instanceSeg, MemorySegment nameSeg, MemorySegment valueSeg) {
		return setPropertyFunc(instanceSeg.address(), nameSeg.address(), valueSeg.address());
	}

	/** Panama adapter for get_func: bool get(ADDRESS, ADDRESS, ADDRESS) */
	private static int getPropertyAdapter(MemorySegment instanceSeg, MemorySegment nameSeg, MemorySegment retSeg) {
		return getPropertyFunc(instanceSeg.address(), nameSeg.address(), retSeg.address());
	}

	// ------------------------------------------------------------------------
	// notification_func — Godot notification forwarding
	// ------------------------------------------------------------------------

	/**
	 * notification_func implementation: called by Godot to deliver notifications
	 * (e.g., NOTIFICATION_READY, NOTIFICATION_ENTER_TREE, NOTIFICATION_DRAW).
	 *
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr
	 * @param what
	 *            Notification constant (e.g., 13 = NOTIFICATION_READY)
	 * @param reversed
	 *            Whether notification propagation is reversed
	 */
	static void notificationFunc(long instancePtr, int what, int reversed) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj != null) {
			obj.onNotification(what);
		}
	}

	/** Panama adapter for notification_func: void(ADDRESS, JAVA_INT, JAVA_BYTE) */
	private static void notificationAdapter(MemorySegment instanceSeg, int what, byte reversed) {
		// Guard against re-entrant upcall — prevents JVM crash when Godot's
		// crash handler sends notifications during an existing upcall
		if (Bridge.isInNativeCallback()) {
			return;
		}
		notificationFunc(instanceSeg.address(), what, reversed);
	}

	// ------------------------------------------------------------------------
	// to_string_func — Java toString() bridge
	// ------------------------------------------------------------------------

	/**
	 * to_string_func implementation: called by Godot to get a string representation
	 * of the extension object.
	 *
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr
	 * @param retPtr
	 *            Pointer to write the resulting GodotString (8 bytes opaque handle)
	 * @param classUserdataPtr
	 *            class_userdata pointer (unused)
	 */
	static void toStringFunc(long instancePtr, long isValidPtr, long outPtr) {
		Object obj = JavaObjectMap.get(instancePtr);
		String result;
		if (obj != null) {
			result = obj.toString();
		} else {
			result = "<freed object>";
		}

		// Set r_is_valid = true (GDExtensionBool = uint8_t)
		if (isValidPtr != 0) {
			MemorySegment.ofAddress(isValidPtr).reinterpret(1).set(ValueLayout.JAVA_BYTE, 0, (byte) 1);
		}

		// Write GodotString pointer to *r_out (GDExtensionConstStringPtr*)
		if (outPtr != 0) {
			GodotString gs = GodotString.fromJavaString(result);
			MemorySegment outSeg = MemorySegment.ofAddress(outPtr).reinterpret(ADDRESS.byteSize());
			outSeg.set(ADDRESS, 0, gs.segment());
		}
	}

	/** Panama adapter for to_string_func: void(ADDRESS, ADDRESS, ADDRESS) */
	private static void toStringAdapter(MemorySegment instanceSeg, MemorySegment retSeg, MemorySegment userdataSeg) {
		toStringFunc(instanceSeg.address(), retSeg.address(), userdataSeg.address());
	}

	// ------------------------------------------------------------------------
	// reference_func / unreference_func — RefCounted lifecycle
	// ------------------------------------------------------------------------

	/**
	 * reference_func implementation: called by Godot when a RefCounted object's
	 * reference count is incremented. Ensures the Java wrapper stays alive.
	 *
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr
	 */
	static void referenceFunc(long instancePtr) {
		// Java wrapper stays in JavaObjectMap as long as Godot holds a reference.
		// No action needed — the Java GC won't collect it while the map holds it.
		logger.trace("reference_func: instance=0x{}", Long.toHexString(instancePtr));
	}

	/**
	 * unreference_func implementation: called by Godot when a RefCounted object's
	 * reference count is decremented. When refcount reaches 0, invalidates the Java
	 * wrapper.
	 *
	 * @param instancePtr
	 *            GDExtensionClassInstancePtr
	 */
	static void unreferenceFunc(long instancePtr) {
		// When Godot decrements to 0, the object will be freed via free_instance_func.
		// We just log here; actual cleanup happens in freeInstanceFunc.
		logger.trace("unreference_func: instance=0x{}", Long.toHexString(instancePtr));
	}

	/** Panama adapter for reference_func: void(ADDRESS) */
	private static void referenceAdapter(MemorySegment instanceSeg) {
		referenceFunc(instanceSeg.address());
	}

	/** Panama adapter for unreference_func: void(ADDRESS) */
	private static void unreferenceAdapter(MemorySegment instanceSeg) {
		unreferenceFunc(instanceSeg.address());
	}

	// ------------------------------------------------------------------------
	// get_property_list_func / free_property_list_func
	// ------------------------------------------------------------------------

	private static final Map<String, MemorySegment> PROPERTY_LIST_ALLOCS = new ConcurrentHashMap<>();

	/**
	 * get_property_list_func: returns the list of @Export properties as a
	 * GDExtensionPropertyInfo array. Uses Dispatch.getExports() for metadata — zero
	 * reflection.
	 */
	static long getPropertyListFunc(long instancePtr, long countPtr) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj == null) {
			writeInt(countPtr, 0);
			return 0;
		}

		String className = resolveGodotClassName(obj);
		if (className == null) {
			writeInt(countPtr, 0);
			return 0;
		}

		PropertyMeta[] exports = Dispatch.getExports(className);
		if (exports == null || exports.length == 0) {
			writeInt(countPtr, 0);
			return 0;
		}

		int count = exports.length;
		writeInt(countPtr, count);

		// Allocate array of PropertyInfo structs
		long allocSize = StructOffsets.PROPERTY_INFO_SIZE * count;
		MemorySegment listBuf = Bridge.allocate(allocSize);
		PROPERTY_LIST_ALLOCS.put(className + "@" + instancePtr, listBuf);

		for (int i = 0; i < exports.length; i++) {
			PropertyMeta meta = exports[i];
			VariantType type = PropertyRegistration.stringTypeToVariantType(meta.typeName());

			long offset = i * StructOffsets.PROPERTY_INFO_SIZE;
			listBuf.set(JAVA_INT, offset + StructOffsets.PROPERTY_INFO_OFF_TYPE, type.id());

			GodotStringName nameSn = GodotStringName.fromJavaString(meta.godotName());
			listBuf.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_NAME,
					MemorySegment.ofAddress(nameSn.segment().address()));
			// class_name (StringName*) — MUST be valid pointer, Godot dereferences
			// unconditionally
			GodotStringName emptySn = GodotStringName.fromJavaString("");
			listBuf.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_CLASS_NAME,
					MemorySegment.ofAddress(emptySn.segment().address()));

			listBuf.set(JAVA_INT, offset + StructOffsets.PROPERTY_INFO_OFF_HINT, meta.hintId());

			String hintStr = meta.hintString();
			GodotString hintString = hintStr.isEmpty()
					? GodotString.fromJavaString("")
					: GodotString.fromJavaString(hintStr);
			listBuf.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_HINT_STRING,
					MemorySegment.ofAddress(hintString.segment().address()));

			listBuf.set(JAVA_INT, offset + StructOffsets.PROPERTY_INFO_OFF_USAGE, 1 | 4 | 8);
		}

		return listBuf.address();
	}

	/** Panama adapter for get_property_list_func: ADDRESS(ADDRESS, ADDRESS) */
	private static MemorySegment getPropertyListAdapter(MemorySegment instanceSeg, MemorySegment countSeg) {
		long result = getPropertyListFunc(instanceSeg.address(), countSeg.address());
		return MemorySegment.ofAddress(result);
	}

	/**
	 * free_property_list_func: called by Godot to free the property list.
	 */
	static void freePropertyListFunc(long instancePtr, long listPtr, int count) {
		String className = null;
		Godot godotObj = JavaObjectMap.get(instancePtr);
		if (godotObj != null) {
			className = resolveGodotClassName(godotObj);
		}
		if (className != null) {
			PROPERTY_LIST_ALLOCS.remove(className + "@" + instancePtr);
		}
	}

	/**
	 * Panama adapter for free_property_list_func: void(ADDRESS, ADDRESS, JAVA_INT)
	 */
	private static void freePropertyListAdapter(MemorySegment instanceSeg, MemorySegment listSeg, int count) {
		freePropertyListFunc(instanceSeg.address(), listSeg.address(), count);
	}

	// ------------------------------------------------------------------------
	// property_can_revert_func / property_get_revert_func
	// ------------------------------------------------------------------------

	/**
	 * property_can_revert_func: returns true if a default value is known for the
	 * property.
	 */
	static int propertyCanRevertFunc(long instancePtr, long namePtr) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj == null)
			return 0;

		String className = resolveGodotClassName(obj);
		if (className == null)
			return 0;

		PropertyMeta[] exports = Dispatch.getExports(className);
		if (exports == null || exports.length == 0)
			return 0;

		String propName = stringNamePtrToString(namePtr);
		for (PropertyMeta meta : exports) {
			if (meta.godotName().equals(propName))
				return 1;
		}
		return 0;
	}

	private static int propertyCanRevertAdapter(MemorySegment instanceSeg, MemorySegment nameSeg) {
		return propertyCanRevertFunc(instanceSeg.address(), nameSeg.address());
	}

	/**
	 * property_get_revert_func: returns the default value for a property.
	 */
	static int propertyGetRevertFunc(long instancePtr, long namePtr, long retPtr) {
		Godot obj = JavaObjectMap.get(instancePtr);
		if (obj == null)
			return 0;

		String className = resolveGodotClassName(obj);
		if (className == null)
			return 0;

		PropertyMeta[] exports = Dispatch.getExports(className);
		if (exports == null || exports.length == 0)
			return 0;

		String propName = stringNamePtrToString(namePtr);
		// Find the property metadata
		PropertyMeta found = null;
		for (PropertyMeta meta : exports) {
			if (meta.godotName().equals(propName)) {
				found = meta;
				break;
			}
		}
		if (found == null)
			return 0;

		try {
			// Create a fresh instance to read the default field value
			Godot fresh = Dispatch.createInstance(className, 0);
			if (fresh == null)
				return 0;

			Object defaultVal = Dispatch.getProperty(className, propName, fresh);
			if (defaultVal == null)
				return 0;

			Variant variant = VariantUtils.fromObject(defaultVal);
			MemorySegment retSeg = MemorySegment.ofAddress(retPtr).reinterpret(Variant.SIZE);
			MemorySegment.copy(variant.getSegment().reinterpret(Variant.SIZE), 0, retSeg, 0, Variant.SIZE);
			Bridge.destroyVariant(variant.getSegment());
			return 1;
		} catch (Exception e) {
			logger.trace("propertyGetRevertFunc failed for {}.{}: {}", className, propName, e.getMessage());
			return 0;
		}
	}

	private static int propertyGetRevertAdapter(MemorySegment instanceSeg, MemorySegment nameSeg,
			MemorySegment retSeg) {
		return propertyGetRevertFunc(instanceSeg.address(), nameSeg.address(), retSeg.address());
	}

	// ------------------------------------------------------------------------
	// validate_property_func
	// ------------------------------------------------------------------------

	/**
	 * validate_property_func: basic validation pass-through. Always returns true
	 * (property is valid). Can be extended later for range/enumeration validation.
	 */
	static int validatePropertyFunc(long instancePtr, long propertyInfoPtr) {
		return 1;
	}

	private static int validatePropertyAdapter(MemorySegment instanceSeg, MemorySegment propertyInfoSeg) {
		return validatePropertyFunc(instanceSeg.address(), propertyInfoSeg.address());
	}

	private static void writeInt(long ptr, int value) {
		if (ptr != 0) {
			MemorySegment.ofAddress(ptr).reinterpret(4).set(JAVA_INT, 0, value);
		}
	}

	// ------------------------------------------------------------------------
	// Class name resolution — uses Dispatch instead of annotation reflection
	// ------------------------------------------------------------------------

	/**
	 * Resolve the Godot class name for a Java object using Dispatch. Returns null
	 * if the class is not registered.
	 */
	private static String resolveGodotClassName(Godot obj) {
		return Dispatch.getGodotClassName(obj.getClass().getName());
	}

	// ------------------------------------------------------------------------
	// Public API
	// ------------------------------------------------------------------------

	/**
	 * Register a Godot class so it can be instantiated by Godot via the
	 * create_instance_func callback.
	 *
	 * <p>
	 * This must be called before {@link #createCreationInfo} for each class. All
	 * metadata (parent class, exports, etc.) is retrieved from Dispatch at this
	 * point — zero reflection.
	 *
	 * @param godotClassName
	 *            The Godot class name (from APT-generated DispatchIndex)
	 */
	public static void registerClass(String godotClassName) {
		// Store parent class name from Dispatch metadata
		String parentClass = Dispatch.getParentClass(godotClassName);
		if (parentClass != null) {
			PARENT_CLASS_NAMES.put(godotClassName, parentClass);
		}
	}

	/**
	 * Get the registered Java class for a Godot class name.
	 */
	public static Class<?> getJavaClass(String godotClassName) {
		return Dispatch.getJavaClass(godotClassName);
	}

	/**
	 * Get the parent Godot class name for a registered class.
	 */
	public static String getParentClassName(String godotClassName) {
		return PARENT_CLASS_NAMES.get(godotClassName);
	}

	/**
	 * Look up the Godot class name from a class_userdata pointer address. Used by
	 * VirtualDispatch to resolve class identity from the opaque userdata.
	 */
	public static String lookupClassName(long userdataAddr) {
		return USERDATA_TO_CLASS_NAME.get(userdataAddr);
	}

	/**
	 * Create and return a native GDExtensionClassCreationInfo4 struct for the given
	 * class.
	 *
	 * <p>
	 * This allocates memory in the shared Bridge Arena and populates all 22 fields.
	 * The mandatory fields set is:
	 * <ul>
	 * <li>create_instance_func → our upcall stub
	 * <li>free_instance_func → our upcall stub
	 * <li>class_userdata → address of the class name StringName
	 * </ul>
	 *
	 * @param godotClassName
	 *            The Godot class name (used as class_userdata key)
	 * @return MemorySegment pointing to the allocated struct (176 bytes)
	 */
	public static MemorySegment createCreationInfo(String godotClassName) {
		// Create the StringName for class_userdata
		GodotStringName classNameSn = GodotStringName.fromJavaString(godotClassName);
		long classNamePtr = classNameSn.segment().address();

		// Build create_instance_func upcall stub using MethodHandles.findStatic
		// (zero reflection — these are our own private static methods)
		FunctionDescriptor createFd = FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_BYTE);
		MethodHandle createHandle = findStatic("createInstanceAdapter",
				MethodType.methodType(MemorySegment.class, MemorySegment.class, byte.class));
		MemorySegment createStub = Bridge.linker().upcallStub(createHandle, createFd, Bridge.ARENA);
		CREATE_INSTANCE_STUBS.put(godotClassName, createStub);

		// Build free_instance_func upcall stub
		FunctionDescriptor freeFd = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
		MethodHandle freeHandle = findStatic("freeInstanceAdapter",
				MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class));
		MemorySegment freeStub = Bridge.linker().upcallStub(freeHandle, freeFd, Bridge.ARENA);
		FREE_INSTANCE_STUBS.put(godotClassName, freeStub);

		// Allocate the creation info struct (160 bytes)
		MemorySegment info = Bridge.allocate(StructOffsets.CREATION_INFO4_SIZE);

		// Zero-initialize the entire struct
		for (long i = 0; i < StructOffsets.CREATION_INFO4_SIZE; i += 8) {
			info.set(ADDRESS, i, MemorySegment.ofAddress(0));
		}

		// Set mandatory fields
		// is_exposed = true (byte offset 2, GDExtensionBool = uint8_t)
		info.set(ValueLayout.JAVA_BYTE, StructOffsets.CREATION_INFO4_OFF_IS_EXPOSED, (byte) 1);
		// is_runtime = true (byte offset 3) — required by Godot 4.5+
		info.set(ValueLayout.JAVA_BYTE, StructOffsets.CREATION_INFO4_OFF_IS_RUNTIME, (byte) 1);
		// create_instance_func
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_CREATE_INSTANCE_FUNC,
				MemorySegment.ofAddress(createStub.address()));
		// free_instance_func
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_FREE_INSTANCE_FUNC,
				MemorySegment.ofAddress(freeStub.address()));
		// class_userdata = address of StringName struct
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_CLASS_USERDATA, MemorySegment.ofAddress(classNamePtr));

		// Map userdata pointer → class name for create_instance lookup
		USERDATA_TO_CLASS_NAME.put(classNamePtr, godotClassName);

		// Check if class has exported properties via Dispatch
		PropertyMeta[] exports = Dispatch.getExports(godotClassName);
		boolean hasProperties = exports != null && exports.length > 0;

		// set_func / get_func — property access callbacks for @Export fields
		if (hasProperties) {
			FunctionDescriptor propFd = FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);

			MethodHandle setHandle = findStatic("setPropertyAdapter",
					MethodType.methodType(int.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));
			MemorySegment setStub = Bridge.linker().upcallStub(setHandle, propFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_SET_FUNC, MemorySegment.ofAddress(setStub.address()));

			MethodHandle getHandle = findStatic("getPropertyAdapter",
					MethodType.methodType(int.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));
			MemorySegment getStub = Bridge.linker().upcallStub(getHandle, propFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_GET_FUNC, MemorySegment.ofAddress(getStub.address()));
		}

		// Virtual method dispatch: register class dispatch data and wire up
		// two-phase API (Godot 4.6+)
		VirtualDispatch.registerClassDispatchData(godotClassName);

		// Deprecated get_virtual_func (offset 128) — set to NULL, use new API
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_GET_VIRTUAL_FUNC, MemorySegment.ofAddress(0));

		// get_virtual_call_data_func (offset 136) — phase 1: returns userdata
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_GET_VIRTUAL_CALL_DATA_FUNC,
				VirtualDispatch.getVirtualCallDataStub());

		// call_virtual_with_data_func (offset 144) — phase 2: dispatches call
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_CALL_VIRTUAL_WITH_DATA_FUNC,
				VirtualDispatch.callVirtualWithDataStub());

		// validate_property_func — basic validation pass-through (always accepts)
		FunctionDescriptor validatePropFd = FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS);
		MethodHandle validatePropHandle = findStatic("validatePropertyAdapter",
				MethodType.methodType(int.class, MemorySegment.class, MemorySegment.class));
		MemorySegment validatePropStub = Bridge.linker().upcallStub(validatePropHandle, validatePropFd, Bridge.ARENA);
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_VALIDATE_PROPERTY_FUNC,
				MemorySegment.ofAddress(validatePropStub.address()));

		// notification_func — re-entrant-safe via Bridge.isInNativeCallback() guard
		// in notificationAdapter. Drops notifications that arrive mid-upcall to avoid
		// JVM crashes when Godot sends notifications during _thread_in_Java state.
		FunctionDescriptor notifyFd = FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, JAVA_BYTE);
		MethodHandle notifyHandle = findStatic("notificationAdapter",
				MethodType.methodType(void.class, MemorySegment.class, int.class, byte.class));
		MemorySegment notifyStub = Bridge.linker().upcallStub(notifyHandle, notifyFd, Bridge.ARENA);
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_NOTIFICATION_FUNC,
				MemorySegment.ofAddress(notifyStub.address()));

		// to_string_func — bridge Java toString() to Godot
		FunctionDescriptor toStringFd = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);
		MethodHandle toStringHandle = findStatic("toStringAdapter",
				MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));
		MemorySegment toStringStub = Bridge.linker().upcallStub(toStringHandle, toStringFd, Bridge.ARENA);
		info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_TO_STRING_FUNC,
				MemorySegment.ofAddress(toStringStub.address()));

		// reference_func / unreference_func — only for RefCounted-derived classes
		if (isRefCountedParent(godotClassName)) {
			FunctionDescriptor refFd = FunctionDescriptor.ofVoid(ADDRESS);
			MethodHandle refHandle = findStatic("referenceAdapter",
					MethodType.methodType(void.class, MemorySegment.class));
			MemorySegment refStub = Bridge.linker().upcallStub(refHandle, refFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_REFERENCE_FUNC,
					MemorySegment.ofAddress(refStub.address()));

			MethodHandle unrefHandle = findStatic("unreferenceAdapter",
					MethodType.methodType(void.class, MemorySegment.class));
			MemorySegment unrefStub = Bridge.linker().upcallStub(unrefHandle, refFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_UNREFERENCE_FUNC,
					MemorySegment.ofAddress(unrefStub.address()));
		}

		if (hasProperties) {
			// get_property_list_func / free_property_list_func
			FunctionDescriptor getPropListFd = FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			FunctionDescriptor freePropListFd = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_INT);

			MethodHandle getPropListHandle = findStatic("getPropertyListAdapter",
					MethodType.methodType(MemorySegment.class, MemorySegment.class, MemorySegment.class));
			MemorySegment getPropListStub = Bridge.linker().upcallStub(getPropListHandle, getPropListFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_GET_PROPERTY_LIST_FUNC,
					MemorySegment.ofAddress(getPropListStub.address()));

			MethodHandle freePropListHandle = findStatic("freePropertyListAdapter",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, int.class));
			MemorySegment freePropListStub = Bridge.linker().upcallStub(freePropListHandle, freePropListFd,
					Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_FREE_PROPERTY_LIST_FUNC,
					MemorySegment.ofAddress(freePropListStub.address()));

			// property_can_revert_func / property_get_revert_func
			FunctionDescriptor canRevertFd = FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS);
			FunctionDescriptor getRevertFd = FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);

			MethodHandle canRevertHandle = findStatic("propertyCanRevertAdapter",
					MethodType.methodType(int.class, MemorySegment.class, MemorySegment.class));
			MemorySegment canRevertStub = Bridge.linker().upcallStub(canRevertHandle, canRevertFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_PROPERTY_CAN_REVERT_FUNC,
					MemorySegment.ofAddress(canRevertStub.address()));

			MethodHandle getRevertHandle = findStatic("propertyGetRevertAdapter",
					MethodType.methodType(int.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));
			MemorySegment getRevertStub = Bridge.linker().upcallStub(getRevertHandle, getRevertFd, Bridge.ARENA);
			info.set(ADDRESS, StructOffsets.CREATION_INFO4_OFF_PROPERTY_GET_REVERT_FUNC,
					MemorySegment.ofAddress(getRevertStub.address()));
		}

		LIVE_CREATION_INFO.put(godotClassName, info);
		return info;
	}

	/**
	 * Check if the parent class of the given registered class inherits from
	 * RefCounted. Uses Dispatch to look up the Java class instead of Class.forName.
	 */
	private static boolean isRefCountedParent(String godotClassName) {
		String parent = PARENT_CLASS_NAMES.get(godotClassName);
		if (parent == null) {
			return false;
		}
		if ("RefCounted".equals(parent)) {
			return true;
		}
		Class<?> parentClass = Dispatch.getJavaClass(parent);
		if (parentClass != null) {
			return org.godot.node.RefCounted.class.isAssignableFrom(parentClass);
		}
		return false;
	}

	// ------------------------------------------------------------------------
	// MethodHandle lookup helper — replaces getDeclaredMethod + unreflect
	// ------------------------------------------------------------------------

	/**
	 * Look up a static method on InstanceCallbacks using MethodHandles.findStatic.
	 * This avoids all reflection (getDeclaredMethod, unreflect, setAccessible).
	 *
	 * @param name
	 *            The method name
	 * @param type
	 *            The method type
	 * @return The MethodHandle
	 * @throws RuntimeException
	 *             if the method cannot be found
	 */
	private static MethodHandle findStatic(String name, MethodType type) {
		try {
			return MethodHandles.lookup().findStatic(InstanceCallbacks.class, name, type);
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw new RuntimeException("Failed to find static method " + name + " on InstanceCallbacks", e);
		}
	}
}
