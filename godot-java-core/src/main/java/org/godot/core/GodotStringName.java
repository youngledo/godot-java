package org.godot.core;

import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;

/**
 * Godot StringName wrapper. Wraps a native Godot StringName (interned string).
 *
 * StringName is an interned, hashed string used throughout Godot for fast
 * lookup. Unlike GodotString (which owns UTF-32 string data), StringName is a
 * lookup key into Godot's global string table.
 *
 * Memory model: stores a pointer to a native Godot StringName struct (8 bytes
 * on 64-bit). Cached StringNames are allocated in the persistent arena.
 */
public final class GodotStringName {

	private final MemorySegment ptr;

	/** Cache: Java string → persistent StringName. Never evicted. */
	private static final ConcurrentHashMap<String, GodotStringName> CACHE = new ConcurrentHashMap<>();

	public GodotStringName() {
		this.ptr = MemorySegment.NULL;
	}

	public GodotStringName(MemorySegment ptr) {
		this.ptr = ptr;
	}

	/**
	 * Create a GodotStringName from a Java String, using a per-JVM cache. Cached
	 * instances are allocated in the persistent arena and never freed. This avoids
	 * repeated string_name_new_with_utf8_chars_and_len calls for the same string
	 * (e.g. method names like "get_node", "call", etc.).
	 */
	public static GodotStringName fromJavaString(String javaString) {
		return CACHE.computeIfAbsent(javaString, GodotStringName::createPersistent);
	}

	/** Create a StringName in the persistent arena (survives across all calls). */
	private static GodotStringName createPersistent(String javaString) {
		byte[] utf8 = javaString.getBytes(StandardCharsets.UTF_8);

		MemorySegment cstr = Bridge.ARENA.allocate(utf8.length + 1, 8);
		cstr.asByteBuffer().put(utf8);
		cstr.set(JAVA_BYTE, utf8.length, (byte) 0);

		MemorySegment strNameBuf = Bridge.ARENA.allocate(8, 8);

		Bridge.callVoid(ApiIndex.STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN, strNameBuf, cstr, (long) utf8.length);

		return new GodotStringName(strNameBuf);
	}

	/**
	 * Create a non-cached StringName in the active (scoped) arena. Use only for
	 * one-shot strings that won't recur.
	 */
	public static GodotStringName fromJavaStringUncached(String javaString) {
		byte[] utf8 = javaString.getBytes(StandardCharsets.UTF_8);

		MemorySegment cstr = Bridge.allocate(utf8.length + 1);
		cstr.asByteBuffer().put(utf8);
		cstr.set(JAVA_BYTE, utf8.length, (byte) 0);

		MemorySegment strNameBuf = Bridge.arena().allocate(8, 8);

		Bridge.callVoid(ApiIndex.STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN, strNameBuf, cstr, (long) utf8.length);

		return new GodotStringName(strNameBuf);
	}

	public MemorySegment segment() {
		return ptr;
	}

	public long address() {
		return ptr.address();
	}
}
