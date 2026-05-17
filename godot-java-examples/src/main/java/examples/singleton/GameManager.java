package examples.singleton;

import org.godot.annotation.Constant;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

/// A global game manager accessible from any script.
///
/// This singleton demonstrates the `@GodotClass(singleton = true)` feature.
/// Access it from GDScript via `GameManager`.
@GodotClass(name = "GameManager", parent = "Node", singleton = true)
public class GameManager extends Node {

	/// Maximum player health
	@Constant
	public static final int MAX_HEALTH = 100;

	/// Starting level
	@Constant
	public static final int STARTING_LEVEL = 1;

	@Export
	public int score = 0;

	@Export
	public int level = STARTING_LEVEL;

	/// Reset the game state to defaults
	@GodotMethod
	public void resetGame() {
		score = 0;
		level = STARTING_LEVEL;
	}

	/// Add points to the current score
	@GodotMethod
	public void addScore(int points) {
		score += points;
	}

	/// Advance to the next level
	@GodotMethod
	public void nextLevel() {
		level++;
	}
}
