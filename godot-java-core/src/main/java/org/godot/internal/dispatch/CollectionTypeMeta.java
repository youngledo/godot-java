package org.godot.internal.dispatch;

/** Compile-time metadata for typed Array and Dictionary exports. */
public record CollectionTypeMeta(String containerType, String elementType, String keyType, String valueType,
		String elementClassName, String keyClassName, String valueClassName) {

	public static CollectionTypeMeta array(String elementType, String elementClassName) {
		return new CollectionTypeMeta("Array", elementType, "", "", elementClassName, "", "");
	}

	public static CollectionTypeMeta dictionary(String keyType, String valueType, String keyClassName,
			String valueClassName) {
		return new CollectionTypeMeta("Dictionary", "", keyType, valueType, "", keyClassName, valueClassName);
	}

	public boolean isArray() {
		return "Array".equals(containerType);
	}

	public boolean isDictionary() {
		return "Dictionary".equals(containerType);
	}

	public String arrayHintString() {
		if (!isArray() || elementType == null || elementType.isEmpty()) {
			return "";
		}
		if (elementClassName != null && !elementClassName.isEmpty()) {
			return elementType + ":" + elementClassName;
		}
		return elementType;
	}
}
