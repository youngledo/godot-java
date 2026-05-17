package examples.sceneloading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;
import org.godot.node.Node2D;
import org.godot.node.PackedScene;
import org.godot.singleton.ResourceLoader;
import org.godot.math.Vector2;

/**
 * Example 11: Scene Loading
 *
 * Demonstrates how to load a PackedScene from disk using ResourceLoader and
 * instantiate it at runtime. This is the standard Godot workflow for creating
 * reusable scene components.
 */
@GodotClass(name = "SceneSpawner", parent = "Node2D")
public class SceneSpawner extends Node2D {

	private static final Logger logger = LogManager.getLogger(SceneSpawner.class);

	private boolean initialized;

	@Override
	public void _ready() {
		if (initialized) {
			return;
		}
		initialized = true;

		logger.info("--- Scene Loading Example ---");

		// Approach 1: Load a .tscn file and instantiate it
		spawnFromSceneFile();

		// Approach 2: Create engine nodes programmatically
		spawnProgrammaticNode();
	}

	private void spawnFromSceneFile() {
		ResourceLoader loader = ResourceLoader.singleton();

		String scenePath = "res://player.tscn";
		if (!loader.exists(scenePath)) {
			logger.warn("Scene file not found: {}", scenePath);
			logger.info("In a real project, create player.tscn in the Godot editor first");
			return;
		}

		org.godot.node.Resource resource = loader.load(scenePath);
		if (resource == null) {
			logger.error("Failed to load scene: {}", scenePath);
			return;
		}

		// Wrap the loaded Resource as a PackedScene
		PackedScene scene = new PackedScene(resource.getPtr());
		logger.info("Loaded PackedScene: {}", scenePath);

		// instantiate() creates a Node tree from the packed scene data
		Node instance = scene.instantiate();
		if (instance == null) {
			logger.error("Failed to instantiate scene: {}", scenePath);
			return;
		}

		// Position the instance (only Node2D and CanvasItem have setPosition)
		if (instance instanceof Node2D node2d) {
			node2d.setPosition(new Vector2(200, 100));
		}
		addChild(instance);
		logger.info("Spawned player from scene file at (200, 100)");
	}

	private void spawnProgrammaticNode() {
		// You can also create engine nodes directly without a .tscn file.
		// Custom @GodotClass nodes are created by Godot when they appear in
		// scene files or via ClassDB.
		Node2D marker = Node2D.create();
		marker.setName("ProgrammaticNode");
		marker.setPosition(new Vector2(500, 100));
		addChild(marker);
		logger.info("Spawned programmatic Node2D at (500, 100)");
	}

	@GodotMethod
	public int getChildCount() {
		return getChildren(false).size();
	}
}
