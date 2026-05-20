package org.godot.core;

import org.godot.Godot;
import java.time.Duration;

public final class TypedSignal0 extends TypedSignal {

	public TypedSignal0(Godot owner, String name) {
		super(owner, name);
	}

	public void emit() {
		owner.emitSignal(name);
	}

	/// Await this signal. Blocks the coroutine until the signal fires.
	public void await() {
		awaitSignalArgs();
	}

	/// Await this signal with a timeout. Returns true if fired, false if timed out.
	public boolean await(Duration timeout) {
		return awaitSignalArgs(timeout) != null;
	}
}
