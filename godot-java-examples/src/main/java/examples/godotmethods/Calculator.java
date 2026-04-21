package examples.godotmethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

/**
 * Example 03: Godot Methods
 *
 * Demonstrates how to expose Java methods to GDScript. Methods annotated
 * with @GodotMethod can be called from GDScript.
 */
@GodotClass(name = "Calculator", parent = "Node")
public class Calculator extends Node {

	private static final Logger logger = LogManager.getLogger(Calculator.class);

	@Override
	public void _ready() {
		logger.info("Calculator ready! Call methods from GDScript.");
	}

	@GodotMethod
	public int add(int a, int b) {
		return a + b;
	}

	@GodotMethod
	public int multiply(int a, int b) {
		return a * b;
	}

	@GodotMethod
	public String greet(String name) {
		return "Hello, " + name + "! Welcome to godot-java!";
	}

	@GodotMethod
	public boolean isEven(int number) {
		return number % 2 == 0;
	}
}
