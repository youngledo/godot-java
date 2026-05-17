package org.godot.core;

import org.godot.Godot;

/**
 * Builder for signal connections with fluent API.
 *
 * <p>
 * Usage:
 *
 * <pre>
 * node.signals().ready().builder().to(target, "onReady").deferred().oneShot().build();
 * </pre>
 */
public final class ConnectBuilder {

	private final Godot owner;
	private final String signalName;
	private Callable callable;
	private int flags;

	ConnectBuilder(Godot owner, String signalName) {
		this.owner = owner;
		this.signalName = signalName;
	}

	public ConnectBuilder to(Callable callable) {
		this.callable = callable;
		return this;
	}

	public ConnectBuilder to(Godot target, String method) {
		this.callable = new Callable(target, method);
		return this;
	}

	public ConnectBuilder flags(int flags) {
		this.flags |= flags;
		return this;
	}

	public ConnectBuilder deferred() {
		this.flags |= ConnectHandle.CONNECT_DEFERRED;
		return this;
	}

	public ConnectBuilder persist() {
		this.flags |= ConnectHandle.CONNECT_PERSIST;
		return this;
	}

	public ConnectBuilder oneShot() {
		this.flags |= ConnectHandle.CONNECT_ONE_SHOT;
		return this;
	}

	public ConnectBuilder referenceCounted() {
		this.flags |= ConnectHandle.CONNECT_REFERENCE_COUNTED;
		return this;
	}

	public ConnectHandle build() {
		if (callable == null) {
			throw new IllegalStateException("No callable set. Call to() before build().");
		}
		owner.connect(signalName, callable, flags);
		return new ConnectHandle(owner, signalName, callable);
	}
}
