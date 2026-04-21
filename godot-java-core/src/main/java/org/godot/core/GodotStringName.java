package org.godot.core;

import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;

/**
 * Godot StringName wrapper. Wraps a native Godot StringName (interned string).
 *
 * StringName is an interned, hashed string used throughout Godot for fast
 * lookup. Unlike GodotString (which owns UTF-32 string data), StringName is a
 * lookup key into Godot's global string table.
 *
 * Memory model: stores a pointer to a native Godot StringName struct (32
 * bytes). The struct itself is allocated in our arena and populated by Godot.
 */
public final class GodotStringName {

	/**
	 * Pointer to native Godot StringName struct (32 bytes, allocated in our arena).
	 */
	private final MemorySegment ptr;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/** Create a null StringName wrapper. */
	public GodotStringName() {
		this.ptr = MemorySegment.NULL;
	}

	/** Wrap an existing native StringName pointer. */
	public GodotStringName(MemorySegment ptr) {
		this.ptr = ptr;
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Create a GodotStringName from a Java String. Allocates a native StringName
	 * via STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN.
	 *
	 * @param javaString
	 *            the Java string to convert
	 * @return a new GodotStringName wrapping the native StringName
	 */
	public static GodotStringName fromJavaString(java.lang.String javaString) {
		byte[] utf8 = javaString.getBytes(java.nio.charset.StandardCharsets.UTF_8);

		// Allocate UTF-8 C string (null-terminated)
		MemorySegment cstr = Bridge.allocate(utf8.length + 1);
		cstr.asByteBuffer().put(utf8);
		cstr.set(JAVA_BYTE, utf8.length, (byte) 0);

		// Allocate buffer for the StringName struct (8 bytes on 64-bit — just an opaque
		// pointer).
		// See Godot GDExtension C example: STRING_NAME_SIZE = 8 on 64-bit builds.
		MemorySegment strNameBuf = Bridge.arena().allocate(8, 8);

		// Call: void string_name_new_with_utf8_chars_and_len(StringName* r_dest, const
		// char* p_contents, int64_t p_size)
		Bridge.callVoid(ApiIndex.STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN, strNameBuf, cstr, (long) utf8.length);

		return new GodotStringName(strNameBuf);
	}

	// ------------------------------------------------------------------------
	// Accessors
	// ------------------------------------------------------------------------

	/** Return the raw native pointer to this StringName struct. */
	public MemorySegment segment() {
		return ptr;
	}

	/** Return the native address as a long. */
	public long address() {
		return ptr.address();
	}
}
