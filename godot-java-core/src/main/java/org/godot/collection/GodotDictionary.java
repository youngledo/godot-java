package org.godot.collection;

import org.godot.core.RefCounted;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.ADDRESS;

/**
 * Godot Dictionary type. A key-value container with Variant keys and values.
 * Extends RefCounted since Godot Dictionaries are reference-counted objects.
 *
 * ```java GodotDictionary dict = new GodotDictionary(nativePtr);
 * dict.put("key", 42); Object val = dict.get("key"); int size = dict.size();
 * ```
 */
public class GodotDictionary extends RefCounted {

	/**
	 * Create a wrapper for an existing native Dictionary.
	 */
	public GodotDictionary(long nativePtr) {
		super(nativePtr);
	}

	/**
	 * Create an empty Dictionary wrapper (invalid).
	 */
	public GodotDictionary() {
		super(0);
	}

	/**
	 * Get the value for the given key.
	 *
	 * @param key
	 *            Key (converted to Variant)
	 * @return Value for key, or null if not found
	 */
	public Object get(Object key) {
		if (nativeObject == 0)
			return null;

		return Bridge.runScoped(() -> {
			MemorySegment dictPtrBuf = Bridge.allocate(ADDRESS.byteSize());
			dictPtrBuf.set(ADDRESS, 0, MemorySegment.ofAddress(nativeObject));
			Variant keyVar = VariantUtils.fromObject(key);
			MemorySegment keyVarSegment = keyVar.getSegment();
			try {
				MemorySegment retVar = Bridge.allocVariant();

				Bridge.callVoid(ApiIndex.DICTIONARY_OPERATOR_INDEX_CONST, dictPtrBuf, keyVarSegment, retVar);
				Object result = VariantUtils.toObject(new Variant(retVar));
				Bridge.destroyVariant(retVar);
				return result;
			} finally {
				Bridge.destroyVariant(keyVarSegment);
			}
		});
	}

	/**
	 * Set the value for the given key.
	 */
	public void put(Object key, Object value) {
		if (nativeObject == 0)
			return;

		Bridge.runScoped(() -> {
			MemorySegment dictPtrBuf = Bridge.allocate(ADDRESS.byteSize());
			dictPtrBuf.set(ADDRESS, 0, MemorySegment.ofAddress(nativeObject));
			Variant keyVar = VariantUtils.fromObject(key);
			Variant valueVar = VariantUtils.fromObject(value);
			MemorySegment keyVarSegment = keyVar.getSegment();
			MemorySegment valueVarSegment = valueVar.getSegment();
			try {
				Bridge.callVoid(ApiIndex.DICTIONARY_OPERATOR_INDEX, dictPtrBuf, keyVarSegment, valueVarSegment);
			} finally {
				Bridge.destroyVariant(keyVarSegment);
				Bridge.destroyVariant(valueVarSegment);
			}
		});
	}

	/**
	 * Check if the dictionary contains the given key.
	 */
	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	/**
	 * Get the number of key-value pairs in the dictionary.
	 */
	public int size() {
		if (nativeObject == 0)
			return 0;
		Object result = call("size");
		if (result instanceof Number) {
			return ((Number) result).intValue();
		}
		return 0;
	}

	/**
	 * Returns true if the dictionary is empty.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Clear all key-value pairs from the dictionary.
	 */
	public void clear() {
		call("clear");
	}

	/**
	 * Remove the key from the dictionary.
	 */
	public void remove(Object key) {
		call("erase", key);
	}
}
