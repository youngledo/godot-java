package org.godot.annotation;

/**
 * Transfer mode for Godot multiplayer RPC. Controls packet delivery guarantees.
 *
 * <p>
 * Matches Godot's {@code MultiplayerPeer.TransferMode} values.
 */
public enum TransferMode {
	UNRELIABLE(0), UNRELIABLE_ORDERED(1), RELIABLE(2);

	public final int value;

	TransferMode(int value) {
		this.value = value;
	}
}
