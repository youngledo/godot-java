package org.godot.collection;

import org.godot.node.RefCounted;
import org.godot.core.OwnedVariant;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.bridge.Bridge;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import java.util.Map;
import static java.lang.foreign.ValueLayout.ADDRESS;

/**
 * Godot Dictionary type. A key-value container with Variant keys and values.
 * Extends RefCounted since Godot Dictionaries are reference-counted objects.
 *
 * The type parameters K and V provide compile-time type safety for keys and
 * values. At runtime, type metadata is managed by Godot's native Dictionary.
 * Raw type usage ({@code GodotDictionary} without type parameters) is
 * backward-compatible.
 *
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 */
public class GodotDictionary<K, V> extends RefCounted {

	private final OwnedVariant ownedVariant;

	/**
	 * Create a wrapper for an existing native Dictionary.
	 */
	public GodotDictionary(long nativePtr) {
		super(nativePtr);
		this.ownedVariant = null;
	}

	/**
	 * Create an empty Dictionary wrapper (invalid until assigned).
	 */
	public GodotDictionary() {
		super(0);
		this.ownedVariant = null;
	}

	private GodotDictionary(OwnedVariant ownedVariant) {
		super(ownedVariant.segment().get(ADDRESS, 8).address());
		this.ownedVariant = ownedVariant;
	}

	public static GodotDictionary<?, ?> fromOwnedVariant(MemorySegment variantSeg) {
		OwnedVariant owned = OwnedVariant.copyOf(variantSeg);
		return new GodotDictionary<>(owned);
	}

	public static GodotDictionary<?, ?> of(Object... keyValues) {
		if (keyValues.length % 2 != 0) {
			throw new IllegalArgumentException("GodotDictionary.of requires an even number of key/value arguments");
		}
		GodotDictionary<Object, Object> dictionary = new GodotDictionary<>();
		for (int i = 0; i < keyValues.length; i += 2) {
			dictionary.put(keyValues[i], keyValues[i + 1]);
		}
		return dictionary;
	}

	public static <K, V> GodotDictionary<K, V> fromMap(Map<? extends K, ? extends V> values) {
		GodotDictionary<K, V> dictionary = new GodotDictionary<>();
		for (Map.Entry<? extends K, ? extends V> entry : values.entrySet()) {
			dictionary.put(entry.getKey(), entry.getValue());
		}
		return dictionary;
	}

	/**
	 * Get the value for the given key.
	 *
	 * @param key
	 *            Key (converted to Variant)
	 * @return Value for key, or null if not found
	 */
	// Override Object.get(String) to avoid shadowing by the generated property
	// getter
	@SuppressWarnings("unchecked")
	@Override
	public V get(String key) {
		return (V) get((Object) key);
	}

	@SuppressWarnings("unchecked")
	public V get(Object key) {
		if (nativeObject == 0)
			return null;

		return (V) Bridge.runScoped(() -> {
			MemorySegment dictPtrBuf = Bridge.allocate(ADDRESS.byteSize());
			dictPtrBuf.set(ADDRESS, 0, MemorySegment.ofAddress(nativeObject));
			Variant keyVar = VariantUtils.fromObject(key);
			MemorySegment keyVarSegment = keyVar.getSegment();
			try {
				MemorySegment value = Bridge.callPtr(ApiIndex.DICTIONARY_OPERATOR_INDEX_CONST, dictPtrBuf,
						keyVarSegment);
				if (value.address() == 0) {
					return null;
				}
				return VariantUtils.toObject(new Variant(value.reinterpret(Variant.SIZE)));
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
