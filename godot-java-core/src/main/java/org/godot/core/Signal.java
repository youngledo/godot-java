package org.godot.core;

import org.godot.Godot;

/**
 * A signal definition. Signals are event notifications that Godot objects can
 * emit. Connect a Callable to a Signal to handle it.
 *
 * <pre>
 * {@code
 * Node button = getNode("Button");
 * button.connect("pressed", new Callable(this, "onButtonPressed").asNativeCallable(), 0);
 * }
 * </pre>
 */
public final class Signal {

	private final Godot object;
	private final String name;

	public Signal(Godot object, String name) {
		this.object = object;
		this.name = name;
	}

	public Godot getObject() {
		return object;
	}

	public String getName() {
		return name;
	}

	/**
	 * Connect this signal to a callable.
	 *
	 * @param callable
	 *            Callable to invoke when signal fires. Use
	 *            {@link Callable#asNativeCallable()} to create a native callable.
	 * @param flags
	 *            Connection flags (e.g., CONNECT_DEFERRED)
	 * @return true if connected
	 */
	public boolean connect(Callable callable, int flags) {
		return object.connect(name, callable, flags);
	}
}
