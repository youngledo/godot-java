package examples.sceneloading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Label;
import org.godot.node.Node2D;
import org.godot.math.Vector2;
import org.godot.math.Color;

/**
 * A simple player node that can be loaded from a .tscn file via
 * PackedScene.instantiate().
 */
@GodotClass(name = "ScenePlayer", parent = "Node2D")
public class ScenePlayer extends Node2D {

	private static final Logger logger = LogManager.getLogger(ScenePlayer.class);

	@Export
	public double speed = 200.0;

	@Export
	public String playerName = "Player1";

	private Label nameLabel;
	private boolean initialized;

	@Override
	public void _ready() {
		if (initialized) {
			return;
		}
		initialized = true;

		nameLabel = Label.create();
		nameLabel.setText(playerName);
		nameLabel.setPosition(new Vector2(-20, -30));
		nameLabel.addThemeColorOverride("font_color", new Color(1, 1, 0));
		nameLabel.addThemeFontSizeOverride("font_size", 16);
		addChild(nameLabel);

		logger.info("Player '{}' ready with speed={}", playerName, speed);
	}

	@GodotMethod
	public void greet() {
		logger.info("Hi, I'm {}! Speed: {}", playerName, speed);
	}
}
