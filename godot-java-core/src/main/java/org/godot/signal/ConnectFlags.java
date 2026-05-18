package org.godot.signal;

/// Signal connection flags matching Godot's Object.CONNECT_* constants.
///
/// These flags control signal connection behavior such as deferred dispatch,
/// persistence across scene saves, one-shot auto-disconnect, and reference
/// counting for the connection target.
public final class ConnectFlags {

	/// Emit the signal at the end of the current frame, similar to
	/// `call_deferred`.
	public static final int DEFERRED = 1;

	/// Persist the connection when the scene is saved to disk.
	public static final int PERSIST = 2;

	/// Disconnect automatically after the signal fires once.
	public static final int ONE_SHOT = 4;

	/// Reference-count the target object, preventing it from being freed
	/// while the connection exists.
	public static final int REFERENCE_COUNTED = 8;

	private ConnectFlags() {
	}
}
