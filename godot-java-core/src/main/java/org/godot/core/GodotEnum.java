package org.godot.core;

/// Marker interface implemented by every generated engine enum.
///
/// Lets the APT processor recognize enum-typed method parameters at compile
/// time and lets runtime marshaling extract the raw value without reflection
/// (`writeTypedPtr`, `VariantUtils.fromObject`).
public interface GodotEnum {

	/// The engine-side integer value of this enum constant.
	int godotValue();
}
