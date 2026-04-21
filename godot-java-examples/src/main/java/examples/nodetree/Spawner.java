package examples.nodetree;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

/**
 * Example 06: Node Tree
 *
 * Demonstrates scene tree traversal: getChildren, getName, addChild, getNode.
 * Prints the tree structure to console for debugging.
 */
@GodotClass(name = "Spawner", parent = "Node")
public class Spawner extends Node {

	private static final Logger logger = LogManager.getLogger(Spawner.class);

	@Override
	public void _ready() {
		logger.info("Spawner ready! Children: {}", getChildren().size());
	}

	@GodotMethod
	public void describeTree() {
		logger.info("--- Scene Tree ---");
		logger.info("Spawner (children: {})", getChildren().size());
		List<Node> children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			Node child = children.get(i);
			logger.info("  [{}] ptr={} valid={}", i, Long.toHexString(child.getPtr()), child.isValid());
		}
		logger.info("--- End ---");
	}

	@GodotMethod
	public void spawnChild(String name) {
		Node child = Node.create();
		child.setName(name);
		addChild(child);
		logger.info("Spawned child: {}", name);
	}
}
