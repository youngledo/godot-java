package org.godot.signal;

import org.godot.Godot;
import org.godot.core.Callable;

/// Builder for signal connections with full ConnectFlags support.
///
/// Provides a fluent API for constructing signal connections on Godot objects.
/// Flags can be combined by chaining method calls.
///
/// Usage:
/// ```java
/// SignalBuilder.on(emitter, "health_changed")
///     .to(receiver, "onHealthChanged")
///     .deferred()
///     .oneShot()
///     .connect();
/// ```
public class SignalBuilder {

	private final Godot source;
	private final String signalName;
	private Godot target;
	private String methodName;
	private Callable callable;
	private int flags;

	private SignalBuilder(Godot source, String signalName) {
		this.source = source;
		this.signalName = signalName;
	}

	/// Start building a connection for the given signal on the source object.
	public static SignalBuilder on(Godot source, String signalName) {
		return new SignalBuilder(source, signalName);
	}

	/// Connect to a method on a target object.
	public SignalBuilder to(Godot target, String methodName) {
		this.target = target;
		this.methodName = methodName;
		return this;
	}

	/// Connect using a pre-built Callable.
	public SignalBuilder to(Callable callable) {
		this.callable = callable;
		return this;
	}

	/// Add DEFERRED flag — emit at end of frame.
	public SignalBuilder deferred() {
		flags |= ConnectFlags.DEFERRED;
		return this;
	}

	/// Add ONE_SHOT flag — auto-disconnect after first emission.
	public SignalBuilder oneShot() {
		flags |= ConnectFlags.ONE_SHOT;
		return this;
	}

	/// Add REFERENCE_COUNTED flag — keep target alive while connected.
	public SignalBuilder referenceCounted() {
		flags |= ConnectFlags.REFERENCE_COUNTED;
		return this;
	}

	/// Add PERSIST flag — save connection with the scene.
	public SignalBuilder persist() {
		flags |= ConnectFlags.PERSIST;
		return this;
	}

	/// Set custom flags directly, replacing any previously set flags.
	public SignalBuilder flags(int flags) {
		this.flags = flags;
		return this;
	}

	/// Return the currently composed flags. Useful for testing.
	public int getFlags() {
		return flags;
	}

	/// Execute the connection.
	///
	/// @return `true` if the connection was successful
	/// @throws IllegalStateException if neither `to(Godot, String)` nor
	///             `to(Callable)` was called before connect
	public boolean connect() {
		Callable cb = this.callable;
		if (cb == null && target != null && methodName != null) {
			cb = new Callable(target, methodName);
		}
		if (cb == null) {
			throw new IllegalStateException("Must specify target+method or callable via to()");
		}
		return source.connect(signalName, cb, flags);
	}
}
