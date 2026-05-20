package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal2<A, B> extends TypedSignal {

	public TypedSignal2(Godot owner, String name) {
		super(owner, name);
	}

	public void emit(A a, B b) {
		owner.emitSignal(name, a, b);
	}

	/// Await this signal and return the arguments as an array.
	/// Use `get(0)` and `get(1)` for typed access.
	public Object[] await() {
		return awaitSignalArgs();
	}

	/// Await this signal with a timeout. Returns null if timed out.
	public Object[] await(Duration timeout) {
		return awaitSignalArgs(timeout);
	}
}
