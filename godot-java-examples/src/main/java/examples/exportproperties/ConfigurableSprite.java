package examples.exportproperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.PropertyHint;
import org.godot.node.Node2D;

/**
 * Example 02: Export Properties
 *
 * Demonstrates how to expose Java fields to the Godot Inspector with various
 * property hints. Users can modify these values directly in the editor.
 */
@GodotClass(name = "ConfigurableSprite", parent = "Node2D")
public class ConfigurableSprite extends Node2D {

	private static final Logger logger = LogManager.getLogger(ConfigurableSprite.class);

	// --- Plain exports (no hint) ---

	@Export
	public String playerName = "Player 1";

	@Export
	public float speed = 200.0f;

	@Export
	public int health = 100;

	// --- Property hint demos ---

	@Export(hint = PropertyHint.RANGE, hintString = "0,500,1")
	public int score = 0;

	@Export(hint = PropertyHint.ENUM, hintString = "Easy,Normal,Hard,Extreme")
	public String difficulty = "Normal";

	@Export(hint = PropertyHint.MULTILINE_TEXT)
	public String description = "Edit this in\na multiline text box";

	@Export(hint = PropertyHint.EXP_EASING)
	public float easing = 0.5f;

	@Export(hint = PropertyHint.PASSWORD)
	public String secretToken = "abc123";

	@Export(hint = PropertyHint.PLACEHOLDER_TEXT, hintString = "Enter your name")
	public String username = "";

	@Override
	public void _ready() {
		logger.info("ConfigurableSprite ready!");
		logger.info("  playerName: {}", playerName);
		logger.info("  speed: {}", speed);
		logger.info("  health: {}", health);
		logger.info("  score: {}", score);
		logger.info("  difficulty: {}", difficulty);
		logger.info("  description: {}", description);
		logger.info("  easing: {}", easing);
		logger.info("  secretToken: {}", secretToken);
		logger.info("  username: {}", username);
		logger.info("Try changing these values in the Godot Inspector!");
	}
}
