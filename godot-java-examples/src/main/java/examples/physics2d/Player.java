package examples.physics2d;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.math.Vector2;
import org.godot.node.Node2D;

/**
 * Example 07: Physics 2D
 *
 * Demonstrates physics movement with a CharacterBody2D parent. Since generated
 * classes like CharacterBody2D don't expose public no-arg constructors, we
 * extend Node2D and use call() to invoke physics methods on the Godot-side
 * CharacterBody2D.
 *
 * The @GodotClass parent="CharacterBody2D" makes Godot create this as a
 * CharacterBody2D subclass, so all physics methods are available.
 */
@GodotClass(name = "Player", parent = "CharacterBody2D")
public class Player extends Node2D {

	private static final Logger logger = LogManager.getLogger(Player.class);

	@Export
	public double speed = 300.0;

	@Export
	public double jumpVelocity = -400.0;

	private double gravity = 980.0;
	private double direction = 0;

	@Override
	public void _ready() {
		logger.info("Player ready! speed={} jumpVelocity={}", speed, jumpVelocity);
	}

	@GodotMethod
	public void setDirection(double dir) {
		this.direction = dir;
	}

	@GodotMethod
	public void jump() {
		boolean onFloor = (boolean) call("is_on_floor");
		if (onFloor) {
			Vector2 vel = (Vector2) call("get_velocity");
			call("set_velocity", new Vector2(vel.x, jumpVelocity));
		}
	}

	@Override
	public void _physicsProcess(double delta) {
		Vector2 vel = (Vector2) call("get_velocity");

		// Apply gravity
		double vy = vel.y + gravity * delta;

		// Apply horizontal movement from input
		double vx = direction * speed;

		call("set_velocity", new Vector2(vx, vy));
		call("move_and_slide");
	}
}
