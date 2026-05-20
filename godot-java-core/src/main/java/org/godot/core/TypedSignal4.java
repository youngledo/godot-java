package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal4<A, B, C, D> extends TypedSignal {

	public TypedSignal4(Godot owner, String name) {
		super(owner, name);
	}

	public void emit(A a, B b, C c, D d) {
		owner.emitSignal(name, a, b, c, d);
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
