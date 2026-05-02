package examples.nodetree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

/**
 * Example 06: Node Tree
 *
 * Demonstrates scene tree traversal: get_children, getName, add_child. Prints
 * the tree structure to console for debugging.
 */
@GodotClass(name = "Spawner", parent = "Node")
public class Spawner extends Node {

	private static final Logger logger = LogManager.getLogger(Spawner.class);

	@Override
	public void _ready() {
		// Build initial node tree
		Node player = Node.create();
		player.setName("Player");
		add_child(player, false, 0);

		Node enemies = Node.create();
		enemies.setName("Enemies");
		add_child(enemies, false, 0);

		Node enemy1 = Node.create();
		enemy1.setName("Enemy1");
		enemies.add_child(enemy1, false, 0);

		Node enemy2 = Node.create();
		enemy2.setName("Enemy2");
		enemies.add_child(enemy2, false, 0);

		logger.info("Initial tree:");
		describeTree();

		// Spawn additional children
		spawnChild("JavaChild1");
		spawnChild("JavaChild2");

		logger.info("Tree after spawning:");
		describeTree();
	}

	@GodotMethod
	public void describeTree() {
		Node[] children = get_children(false);
		logger.info("--- Scene Tree ---");
		logger.info("Spawner (children: {})", children.length);
		for (int i = 0; i < children.length; i++) {
			Node child = children[i];
			logger.info("  [{}] ptr={} valid={}", i, Long.toHexString(child.getPtr()), child.isValid());
		}
		logger.info("--- End ---");
	}

	@GodotMethod
	public void spawnChild(String name) {
		Node child = Node.create();
		child.setName(name);
		add_child(child, false, 0);
		logger.info("Spawned child: {}", name);
	}
}
