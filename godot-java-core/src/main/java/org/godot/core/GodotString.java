package org.godot.core;

import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;

/**
 * Godot String wrapper. Wraps a native Godot String (UTF-32 internally). This
 * is a minimal implementation sufficient for method name arguments.
 *
 * Memory model: stores a pointer to a native Godot String struct. The struct
 * itself is allocated by Godot; we just hold the pointer.
 */
public final class GodotString {

	/** Pointer to native Godot String struct. */
	private final MemorySegment ptr;

	/** Lazy-loaded string_destroy function handle. */
	private static volatile MethodHandle stringDestroy;

	static {
		try {
			long addr = org.godot.bootstrap.Bootstrap.getProcAddressImpl("string_destroy");
			if (addr != 0) {
				stringDestroy = Linker.nativeLinker().downcallHandle(MemorySegment.ofAddress(addr),
						FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));
			}
		} catch (Exception _) {
		}
	}

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/** Create an empty String wrapper (null pointer). */
	public GodotString() {
		this.ptr = MemorySegment.NULL;
	}

	/** Wrap an existing native String pointer (ptr to String struct). */
	public GodotString(MemorySegment ptr) {
		this.ptr = ptr;
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Create a GodotString from a Java String. Allocates a native Godot String via
	 * STRING_NEW_WITH_UTF8_CHARS_AND_LEN. The returned GodotString wraps the native
	 * buffer containing the String struct.
	 */
	public static GodotString fromJavaString(java.lang.String javaString) {
		byte[] utf8 = javaString.getBytes(java.nio.charset.StandardCharsets.UTF_8);

		// Allocate UTF-8 C string (null-terminated)
		MemorySegment cstr = Bridge.allocate(utf8.length + 1);
		cstr.asByteBuffer().put(utf8);
		cstr.set(JAVA_BYTE, utf8.length, (byte) 0);

		// Allocate buffer for the String struct (16 bytes on 64-bit: CowData<char32_t>
		// = {char32_t* ptr; int64_t size})
		MemorySegment strBuf = Bridge.arena().allocate(16, 8);

		// Call: void string_new_with_utf8_chars_and_len(String* r_dest, const char*
		// p_cstr, int64_t p_len)
		Bridge.callVoid(ApiIndex.STRING_NEW_WITH_UTF8_CHARS_AND_LEN, strBuf, cstr, (long) utf8.length);

		return new GodotString(strBuf);
	}

	/**
	 * Convert to Java String. Uses two-pass API: first get byte count, then get
	 * bytes.
	 */
	public java.lang.String toJavaString() {
		if (ptr.address() == 0)
			return "";

		// Pass NULL buffer, 0 length to get required byte count
		long byteCount = Bridge.callLong(ApiIndex.STRING_TO_UTF8_CHARS, ptr, MemorySegment.NULL, 0L);
		if (byteCount <= 0)
			return "";

		// Second pass: get actual bytes
		MemorySegment buf = Bridge.allocate(byteCount + 1);
		Bridge.callLong(ApiIndex.STRING_TO_UTF8_CHARS, ptr, buf, byteCount + 1);

		byte[] bytes = new byte[(int) byteCount];
		buf.asByteBuffer().get(bytes);
		return new java.lang.String(bytes, java.nio.charset.StandardCharsets.UTF_8);
	}

	// ------------------------------------------------------------------------
	// Native access
	// ------------------------------------------------------------------------

	/**
	 * Get the native pointer to the String struct. Pass this to Godot C APIs that
	 * expect a String*.
	 */
	public long getPtr() {
		return ptr.address();
	}

	/**
	 * Get the MemorySegment containing the String struct data (8 bytes). Use this
	 * when passing the String to GDExtension constructors.
	 */
	public MemorySegment buffer() {
		return ptr;
	}

	/** Get the MemorySegment wrapping the native String pointer. */
	public MemorySegment segment() {
		return ptr;
	}

	/** Check if this is a null string. */
	public boolean isNull() {
		return ptr.address() == 0;
	}

	/**
	 * Destroy the native Godot String, decrementing its CowData reference count.
	 * Must be called when the string is no longer needed (e.g., after copying into
	 * a Variant via type constructor). Safe to call on null strings (no-op).
	 */
	public void destroy() {
		if (stringDestroy != null && ptr.address() != 0) {
			try {
				stringDestroy.invoke(ptr);
			} catch (Throwable _) {
			}
		}
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public java.lang.String toString() {
		return toJavaString();
	}
}
