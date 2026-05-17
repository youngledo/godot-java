package examples.toolnode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.Tool;
import org.godot.node.Node2D;
import org.godot.node.ColorRect;
import org.godot.math.Vector2;
import org.godot.math.Color;

/**
 * Example 13: Tool Node
 *
 * Demonstrates the @Tool annotation which allows virtual callbacks (_ready,
 * _process, etc.) to execute in the Godot editor. Without @Tool, virtual
 * callbacks are suppressed when Engine.isEditorHint() is true.
 */
@Tool
@GodotClass(name = "EditorGrid", parent = "Node2D")
public class EditorGrid extends Node2D {

	private static final Logger logger = LogManager.getLogger(EditorGrid.class);

	@Export
	public double cellSize = 50.0;

	@Export
	public int gridWidth = 10;

	@Export
	public int gridHeight = 8;

	private boolean initialized;

	@Override
	public void _ready() {
		if (initialized) {
			return;
		}
		initialized = true;

		drawGrid();
		logger.info("EditorGrid ready! cellSize={}, grid={}x{}", cellSize, gridWidth, gridHeight);
		logger.info("This node runs in the editor because it has @Tool annotation");
	}

	private void drawGrid() {
		// Draw grid lines
		Color lineColor = new Color(0.4, 0.4, 0.4, 0.3);

		// Vertical lines
		for (int x = 0; x <= gridWidth; x++) {
			ColorRect line = ColorRect.create();
			line.setColor(lineColor);
			line.setSize(new Vector2(1, gridHeight * cellSize));
			line.setPosition(new Vector2(x * cellSize, 0));
			addChild(line);
		}

		// Horizontal lines
		for (int y = 0; y <= gridHeight; y++) {
			ColorRect line = ColorRect.create();
			line.setColor(lineColor);
			line.setSize(new Vector2(gridWidth * cellSize, 1));
			line.setPosition(new Vector2(0, y * cellSize));
			addChild(line);
		}
	}
}
