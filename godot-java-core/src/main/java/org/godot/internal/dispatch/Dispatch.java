package org.godot.internal.dispatch;

import org.godot.Godot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.Set;

/**
 * Facade that loads the APT-generated DispatchIndex at startup and delegates
 * all calls. This is the ONLY place in the framework that uses Class.forName —
 * two Class.forName calls during static initialization. All subsequent calls go
 * through direct interface method dispatch via MethodHandle.
 */
public final class Dispatch {

	private static final Logger logger = LogManager.getLogger(Dispatch.class);
	private static final DispatchAccessor accessor;

	static {
		DispatchAccessor a;
		try {
			Class<?> cls = Class.forName("org.godot.internal.DispatchIndex");
			MethodHandle mh = MethodHandles.lookup().findStaticGetter(cls, "INSTANCE", DispatchAccessor.class);
			a = (DispatchAccessor) mh.invoke();
		} catch (Throwable e) {
			logger.error("Failed to load DispatchIndex: {}", e.getMessage());
			a = new NoOpAccessor();
		}
		accessor = a;
	}

	public static boolean isAvailable() {
		return !(accessor instanceof NoOpAccessor);
	}

	public static String getParentClass(String name) {
		return accessor.getParentClass(name);
	}

	public static Class<?> getJavaClass(String name) {
		return accessor.getJavaClass(name);
	}

	public static String getGodotClassName(String fqn) {
		return accessor.getGodotClassName(fqn);
	}

	public static Godot createInstance(String name, long nativePtr) {
		return accessor.createInstance(name, nativePtr);
	}

	public static PropertyMeta[] getExports(String name) {
		return accessor.getExports(name);
	}

	public static MethodMeta[] getMethods(String name) {
		return accessor.getMethods(name);
	}

	public static SignalMeta[] getSignals(String name) {
		return accessor.getSignals(name);
	}

	public static Set<String> getVirtualOverrides(String name) {
		return accessor.getVirtualOverrides(name);
	}

	public static Map<Long, Set<String>> getVirtualHashToNames(String parent) {
		return accessor.getVirtualHashToNames(parent);
	}

	public static Set<String> getVirtualAllNames(String parent) {
		return accessor.getVirtualAllNames(parent);
	}

	public static boolean hasProperty(String className, String propName) {
		return accessor.hasProperty(className, propName);
	}

	public static Object getProperty(String className, String propName, Godot instance) {
		return accessor.getProperty(className, propName, instance);
	}

	public static boolean setProperty(String className, String propName, Godot instance, Object value) {
		return accessor.setProperty(className, propName, instance, value);
	}

	public static boolean hasMethod(String className, String methodName) {
		return accessor.hasMethod(className, methodName);
	}

	public static Object dispatchPtrcall(String className, String methodName, Godot instance, MemorySegment args,
			int argc) throws Throwable {
		return accessor.dispatchPtrcall(className, methodName, instance, args, argc);
	}

	public static Object dispatchVariantCall(String className, String methodName, Godot instance, Object[] args)
			throws Throwable {
		return accessor.dispatchVariantCall(className, methodName, instance, args);
	}

	public static void dispatchVirtual(String className, String methodName, MemorySegment instance, MemorySegment args,
			MemorySegment ret) {
		accessor.dispatchVirtual(className, methodName, instance, args, ret);
	}

	private Dispatch() {
	}

	private static final class NoOpAccessor implements DispatchAccessor {

		@Override
		public String getParentClass(String n) {
			return null;
		}

		@Override
		public Class<?> getJavaClass(String n) {
			return null;
		}

		@Override
		public String getGodotClassName(String f) {
			return null;
		}

		@Override
		public Godot createInstance(String n, long p) {
			return null;
		}

		@Override
		public PropertyMeta[] getExports(String n) {
			return new PropertyMeta[0];
		}

		@Override
		public MethodMeta[] getMethods(String n) {
			return new MethodMeta[0];
		}

		@Override
		public SignalMeta[] getSignals(String n) {
			return new SignalMeta[0];
		}

		@Override
		public Set<String> getVirtualOverrides(String n) {
			return Set.of();
		}

		@Override
		public Map<Long, Set<String>> getVirtualHashToNames(String p) {
			return Map.of();
		}

		@Override
		public Set<String> getVirtualAllNames(String p) {
			return Set.of();
		}

		@Override
		public boolean hasProperty(String c, String p) {
			return false;
		}

		@Override
		public Object getProperty(String c, String p, Godot i) {
			return null;
		}

		@Override
		public boolean setProperty(String c, String p, Godot i, Object v) {
			return false;
		}

		@Override
		public boolean hasMethod(String c, String m) {
			return false;
		}

		@Override
		public Object dispatchPtrcall(String c, String m, Godot i, MemorySegment a, int ac) {
			return null;
		}

		@Override
		public Object dispatchVariantCall(String c, String m, Godot i, Object[] a) {
			return null;
		}

		@Override
		public void dispatchVirtual(String c, String m, MemorySegment i, MemorySegment a, MemorySegment r) {
		}
	}
}
