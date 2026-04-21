package examples.processloop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.node.Node2D;

/**
 * Example 05: Process Loop
 *
 * Demonstrates _process(delta) for per-frame updates. This node moves in a
 * circular orbit around the origin. Adjust rotationSpeed in the Inspector to
 * change speed.
 */
@GodotClass(name = "RotatingSprite", parent = "Node2D")
public class RotatingSprite extends Node2D {

	private static final Logger logger = LogManager.getLogger(RotatingSprite.class);

	@Export
	public double rotationSpeed = 1.0;

	private double time = 0;

	@Override
	public void _ready() {
		logger.info("RotatingSprite ready! rotationSpeed = {}", rotationSpeed);
	}

	@Override
	public void _process(double delta) {
		time += delta;
		double radius = 100;
		double x = Math.cos(time * rotationSpeed) * radius;
		double y = Math.sin(time * rotationSpeed) * radius;
		setPosition(x, y);
	}
}
