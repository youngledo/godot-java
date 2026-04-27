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
}
