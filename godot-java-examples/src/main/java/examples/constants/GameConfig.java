package examples.constants;

import org.godot.annotation.Constant;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

/// Game configuration constants accessible from GDScript.
@GodotClass(name = "GameConfig", parent = "Node")
public class GameConfig extends Node {

	/// Maximum number of players in a session
	@Constant
	public static final int MAX_PLAYERS = 4;

	/// Default port for multiplayer
	@Constant
	public static final int DEFAULT_PORT = 7777;

	/// Game tick rate in Hz
	@Constant
	public static final int TICK_RATE = 60;

	/// Maximum item stack size
	@Constant
	public static final int MAX_STACK_SIZE = 99;

	/// Get a formatted string of all config values
	@GodotMethod
	public String getConfigSummary() {
		return String.format("Players: %d, Port: %d, Tick: %d, Stack: %d", MAX_PLAYERS, DEFAULT_PORT, TICK_RATE,
				MAX_STACK_SIZE);
	}
}
