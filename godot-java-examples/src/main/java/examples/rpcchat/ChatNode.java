package examples.rpcchat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Rpc;
import org.godot.annotation.RpcMode;
import org.godot.annotation.Signal;
import org.godot.annotation.TransferMode;
import org.godot.node.Node;

/**
 * Example 12: RPC Chat
 *
 * Demonstrates the @Rpc annotation for Godot multiplayer. The annotated method
 * is automatically registered with rpc_config() during class initialization.
 *
 * <p>
 * APT generates typed proxy methods:
 * <ul>
 * <li>{@code receiveMessageRpc(...)} — broadcasts to all peers</li>
 * <li>{@code receiveMessageRpcId(peerId, ...)} — sends to a specific peer</li>
 * </ul>
 *
 * <p>
 * To test multiplayer:
 * <ol>
 * <li>Run one instance as server: Godot editor → Play</li>
 * <li>Run another instance as client from command line</li>
 * <li>Messages are broadcast via RPC to all connected peers</li>
 * </ol>
 */
@GodotClass(name = "ChatNode", parent = "Node")
public class ChatNode extends Node {

	private static final Logger logger = LogManager.getLogger(ChatNode.class);

	private boolean initialized;

	@Signal
	public void messageReceived(String sender, String message) {
	}

	@Override
	public void _ready() {
		if (initialized) {
			return;
		}
		initialized = true;

		long peerId = getMultiplayer().getUniqueId();
		logger.info("ChatNode ready! Peer ID: {}", peerId);
		logger.info("Use sendMessage() to broadcast to all peers");
	}

	/**
	 * RPC method: called remotely by other peers. Marked with @Rpc so Godot
	 * registers it for multiplayer dispatch.
	 */
	@Rpc(mode = RpcMode.ANY_PEER, callLocal = true, transfer = TransferMode.RELIABLE)
	@GodotMethod
	public void receiveMessage(String sender, String message) {
		logger.info("[RPC] {}: {}", sender, message);
		new ChatNodeSignals(this).messageReceived().emit(sender, message);
	}

	/**
	 * Broadcast a message to all connected peers. Uses the APT-generated proxy
	 * method which calls owner.rpc("receiveMessage", ...).
	 */
	@GodotMethod
	public void sendMessage(String message) {
		String sender = "Peer" + getMultiplayer().getUniqueId();
		logger.info("Sending: {}: {}", sender, message);
		// The APT-generated ChatNodeSignals class contains RPC proxy methods
		new ChatNodeSignals(this).receiveMessageRpc(sender, message);
	}

	/**
	 * Send a message to a specific peer. Uses the APT-generated proxy method which
	 * calls owner.rpc_id(peerId, "receiveMessage", ...).
	 */
	@GodotMethod
	public void sendToPeer(long peerId, String message) {
		String sender = "Peer" + getMultiplayer().getUniqueId();
		logger.info("Sending to peer {}: {}: {}", peerId, sender, message);
		new ChatNodeSignals(this).receiveMessageRpcId(peerId, sender, message);
	}
}
