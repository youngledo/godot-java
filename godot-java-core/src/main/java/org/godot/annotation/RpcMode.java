package org.godot.annotation;

/**
 * RPC mode for Godot multiplayer. Controls who can call the RPC method.
 *
 * <p>
 * Matches Godot's {@code MultiplayerPeer.ConnectionState} / RPC mode values.
 */
public enum RpcMode {
	DISABLED(0), ANY_PEER(1), AUTHORITY(2);

	public final int value;

	RpcMode(int value) {
		this.value = value;
	}
}
