package examples.helloworld;

import org.godot.annotation.GodotClass;
import org.godot.node.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Example 01: Hello World
 *
 * Demonstrates the basics of creating a Godot class in Java. This node prints a
 * message when it enters the scene tree.
 */
@GodotClass(name = "HelloNode", parent = "Node")
public class HelloNode extends Node {

	private static final Logger logger = LogManager.getLogger(HelloNode.class);

	@Override
	public void _ready() {
		logger.info("Hello from Java! godot-java binding is working!");
		logger.info("This message was printed from HelloNode._ready()");
	}
}
