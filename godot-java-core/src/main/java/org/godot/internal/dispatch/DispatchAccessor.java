package org.godot.internal.dispatch;

import org.godot.Godot;
import java.lang.foreign.MemorySegment;
import java.util.Map;
import java.util.Set;

/**
 * Interface implemented by the APT-generated DispatchIndex. Provides all
 * dispatch and metadata access without runtime reflection.
 */
public interface DispatchAccessor {

	String getParentClass(String godotClassName);

	Class<?> getJavaClass(String godotClassName);

	String getGodotClassName(String fqn);

	Godot createInstance(String godotClassName, long nativePtr);

	PropertyMeta[] getExports(String godotClassName);

	MethodMeta[] getMethods(String godotClassName);

	SignalMeta[] getSignals(String godotClassName);

	Set<String> getVirtualOverrides(String godotClassName);

	Map<Long, Set<String>> getVirtualHashToNames(String parentClassName);

	Set<String> getVirtualAllNames(String parentClassName);

	boolean hasProperty(String godotClassName, String propName);

	Object getProperty(String godotClassName, String propName, Godot instance);

	boolean setProperty(String godotClassName, String propName, Godot instance, Object value);

	boolean hasMethod(String godotClassName, String methodName);

	Object dispatchPtrcall(String godotClassName, String methodName, Godot instance, MemorySegment args, int argc)
			throws Throwable;

	Object dispatchVariantCall(String godotClassName, String methodName, Godot instance, Object[] args)
			throws Throwable;

	void dispatchVirtual(String godotClassName, String methodName, MemorySegment instance, MemorySegment args,
			MemorySegment ret);

	boolean isToolClass(String godotClassName);

	boolean isSingletonClass(String godotClassName);

	boolean isInternalClass(String godotClassName);

	boolean isNoInitClass(String godotClassName);

	/** Returns constant entries as String[][]: each row is {name, value}. */
	String[][] getConstants(String godotClassName);

	/**
	 * Returns virtual script methods as String[][]: each row is {godotName,
	 * returnType, paramType1, ...}.
	 */
	String[][] getVirtualScriptMethods(String godotClassName);

	/**
	 * Returns Godot class reference XML for editor documentation, or null if no
	 * docs were generated for this class.
	 */
	String getClassDocXml(String godotClassName);

	boolean hasDynamicGetter(String godotClassName);

	boolean hasDynamicSetter(String godotClassName);

	boolean hasDynamicPropertyList(String godotClassName);

	Object dispatchDynamicGet(String godotClassName, Godot instance, String propertyName);

	boolean dispatchDynamicSet(String godotClassName, Godot instance, String propertyName, Object value);

	Object dispatchDynamicPropertyList(String godotClassName, Godot instance);

	boolean hasValidateProperty(String godotClassName);

	boolean dispatchValidateProperty(String godotClassName, Godot instance, String propertyName, long propertyInfoPtr);

	/// Initialize @OnReady fields for the given class before _ready().
	void initOnReadyFields(String godotClassName, Godot instance);

	/// Returns the explicit default value string for an exported property, or null if none.
	String getExportDefaultValue(String godotClassName, String propertyName);
}
