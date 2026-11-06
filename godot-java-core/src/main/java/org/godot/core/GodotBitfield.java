package org.godot.core;

/// Marker interface implemented by every generated bitfield flag class.
///
/// Lets the APT processor recognize bitfield-typed method parameters at
/// compile time and lets runtime marshaling extract the raw value without
/// reflection (`writeTypedPtr`, `VariantUtils.fromObject`). Values are 64-bit
/// end to end, matching the GDExtension ABI.
public interface GodotBitfield {

	/// The engine-side 64-bit flag value.
	long godotValue();
}
