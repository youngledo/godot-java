package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal5<A, B, C, D, E> extends TypedSignal {

	public TypedSignal5(Godot owner, String name) {
		super(owner, name);
	}

	public void emit(A a, B b, C c, D d, E e) {
		owner.emitSignal(name, a, b, c, d, e);
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
