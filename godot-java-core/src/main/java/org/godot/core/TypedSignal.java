package org.godot.core;

import org.godot.Godot;
import org.godot.coroutine.GodotScope;
import java.time.Duration;

/// Base class for typed signal facades. Provides type-safe emit, connect,
/// and await without string-based signal names.
public abstract class TypedSignal {

	protected final Godot owner;
	protected final String name;

	protected TypedSignal(Godot owner, String name) {
		this.owner = owner;
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public final ConnectHandle connect(Callable callable, int flags) {
		owner.connect(name, callable, flags);
		return new ConnectHandle(owner, name, callable);
	}

	public final ConnectHandle connect(Callable callable) {
		return connect(callable, 0);
	}

	public final ConnectHandle connect(Godot target, String method, int flags) {
		return connect(new Callable(target, method), flags);
	}

	public final ConnectHandle connect(Godot target, String method) {
		return connect(target, method, 0);
	}

	public final ConnectBuilder builder() {
		return new ConnectBuilder(owner, name);
	}

	/// Await this signal asynchronously. Must be called from a coroutine
	/// launched via `GodotScope.launch()`. Returns the raw signal arguments.
	protected final Object[] awaitSignalArgs() {
		return GodotScope.awaitSignal(owner, name);
	}

	/// Await this signal with a timeout. Returns null if timed out.
	protected final Object[] awaitSignalArgs(Duration timeout) {
		return GodotScope.awaitSignal(owner, name, timeout);
	}
}
