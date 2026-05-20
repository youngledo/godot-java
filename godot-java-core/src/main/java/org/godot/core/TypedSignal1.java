package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal1<A> extends TypedSignal {

	public TypedSignal1(Godot owner, String name) {
		super(owner, name);
	}

	public void emit(A a) {
		owner.emitSignal(name, a);
	}

	/// Await this signal and return the first argument.
	@SuppressWarnings("unchecked")
	public A await() {
		Object[] args = awaitSignalArgs();
		return args.length > 0 ? (A) args[0] : null;
	}

	/// Await this signal with a timeout. Returns the argument, or null if timed out.
	@SuppressWarnings("unchecked")
	public A await(Duration timeout) {
		Object[] args = awaitSignalArgs(timeout);
		if (args == null || args.length == 0) {
			return null;
		}
		return (A) args[0];
	}
}
