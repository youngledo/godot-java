package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal3<A, B, C> extends TypedSignal {

	public TypedSignal3(Godot owner, String name) {
		super(owner, name);
	}

	public void emit(A a, B b, C c) {
		owner.emitSignal(name, a, b, c);
	}

	/// Await this signal and return the arguments as an array.
	public Object[] await() {
		return awaitSignalArgs();
	}

	/// Await this signal with a timeout. Returns null if timed out.
	public Object[] await(Duration timeout) {
		return awaitSignalArgs(timeout);
	}
}
