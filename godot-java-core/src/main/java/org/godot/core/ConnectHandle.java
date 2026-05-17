package org.godot.core;

import org.godot.Godot;

/**
 * A handle to an active signal connection. Provides lifecycle management:
 * disconnect and connection state query.
 *
 * <p>
 * Usage:
 *
 * <pre>
 * ConnectHandle handle = node.signals().ready().connect(callable);
 * // later...
 * if (handle.isConnected()) {
 * 	handle.disconnect();
 * }
 * </pre>
 */
public final class ConnectHandle {

	// Godot connection flag constants
	public static final int CONNECT_DEFERRED = 1;
	public static final int CONNECT_PERSIST = 2;
	public static final int CONNECT_ONE_SHOT = 4;
	public static final int CONNECT_REFERENCE_COUNTED = 8;

	private final Godot owner;
	private final String signalName;
	private final Callable callable;

	public ConnectHandle(Godot owner, String signalName, Callable callable) {
		this.owner = owner;
		this.signalName = signalName;
		this.callable = callable;
	}

	public Callable getCallable() {
		return callable;
	}

	public boolean isConnected() {
		return owner.isConnected(signalName, callable);
	}

	public void disconnect() {
		owner.disconnect(signalName, callable);
	}
}
