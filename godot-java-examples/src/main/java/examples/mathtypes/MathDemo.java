package examples.mathtypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.math.Vector3;
import org.godot.node.Node;

/**
 * Example 08: Math Types
 *
 * Demonstrates Vector2, Vector3, and Color math operations. Pure computation
 * example, outputs results to console.
 */
@GodotClass(name = "MathDemo", parent = "Node")
public class MathDemo extends Node {

	private static final Logger logger = LogManager.getLogger(MathDemo.class);

	@Override
	public void _ready() {
		logger.info("=== Math Types Demo ===");

		demoVector2();
		demoVector3();
		demoColor();
	}

	private void demoVector2() {
		logger.info("--- Vector2 ---");
		Vector2 a = new Vector2(3, 4);
		Vector2 b = new Vector2(1, 2);

		logger.info("a = ({}, {})", a.x, a.y);
		logger.info("b = ({}, {})", b.x, b.y);
		logger.info("length(a) = {}", a.length());
		logger.info("dot(a, b) = {}", a.dot(b));
		logger.info("cross(a, b) = {}", a.cross(b));

		Vector2 sum = a.add(b);
		logger.info("a + b = ({}, {})", sum.x, sum.y);

		Vector2 normalized = a.normalized();
		logger.info("normalized(a) = ({}, {})", normalized.x, normalized.y);

		Vector2 lerped = a.lerp(b, 0.5);
		logger.info("lerp(a, b, 0.5) = ({}, {})", lerped.x, lerped.y);

		logger.info("distanceTo(a, b) = {}", a.distanceTo(b));
	}

	private void demoVector3() {
		logger.info("--- Vector3 ---");
		Vector3 a = new Vector3(1, 2, 3);
		Vector3 b = new Vector3(4, 5, 6);

		logger.info("a = ({}, {}, {})", a.x, a.y, a.z);
		logger.info("b = ({}, {}, {})", b.x, b.y, b.z);
		logger.info("length(a) = {}", a.length());
		logger.info("dot(a, b) = {}", a.dot(b));

		Vector3 cross = a.cross(b);
		logger.info("cross(a, b) = ({}, {}, {})", cross.x, cross.y, cross.z);

		Vector3 sum = a.add(b);
		logger.info("a + b = ({}, {}, {})", sum.x, sum.y, sum.z);
	}

	private void demoColor() {
		logger.info("--- Color ---");
		Color red = new Color(1, 0, 0);
		Color blue = new Color(0, 0, 1);
		Color transparent = new Color(0.5, 0.5, 0.5, 0.5);

		logger.info("red = ({}, {}, {}, {})", red.r, red.g, red.b, red.a);
		logger.info("blue = ({}, {}, {}, {})", blue.r, blue.g, blue.b, blue.a);
		logger.info("semi-transparent gray = ({}, {}, {}, {})", transparent.r, transparent.g, transparent.b,
				transparent.a);
	}
}
