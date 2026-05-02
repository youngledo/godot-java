package examples.snake;

import java.util.ArrayList;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.node.ColorRect;
import org.godot.node.Label;
import org.godot.node.Node2D;
import org.godot.singleton.Input;

/**
 * Example 10: Snake
 *
 * Classic Snake game with all logic, UI, input, and rendering in pure Java.
 * Uses ColorRect nodes for visual rendering instead of canvas _draw() API,
 * since GDExtension canvas drawing context doesn't cross the FFI boundary.
 *
 * Direction constants: 0=up, 1=right, 2=down, 3=left
 */
@GodotClass(name = "SnakeGame", parent = "Node2D")
public class SnakeGame extends Node2D {

	private static final Logger logger = LogManager.getLogger(SnakeGame.class);

	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int[][] DIR_VECTORS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	private static final int CELL_SIZE = 18;
	private static final int GRID_W = 30;
	private static final int GRID_H = 30;
	private static final Color FOOD_COLOR = new Color(1.0, 0.3, 0.3);
	private static final Color HEAD_COLOR = new Color(0.2, 1.0, 0.3);
	private static final Color BG_COLOR = new Color(0.08, 0.08, 0.12);
	private static final Color GRID_LINE_COLOR = new Color(0.12, 0.12, 0.16);

	@Export
	public double moveInterval = 0.15;

	private final ArrayList<int[]> segments = new ArrayList<>();
	private int foodX;
	private int foodY;
	private int direction = RIGHT;
	private int nextDirection = RIGHT;
	private int score;
	private boolean gameOver;
	private double moveTimer;
	private boolean growing;
	private boolean initialized;
	private final Random random = new Random();

	// Visual nodes
	private final ArrayList<ColorRect> segmentRects = new ArrayList<>();
	private ColorRect foodRect;
	private Label scoreLabel;
	private Label messageLabel;
	private Node2D container;

	@Override
	public void _ready() {
		if (initialized) {
			return;
		}
		initialized = true;

		double offsetX = (1152 - GRID_W * CELL_SIZE) / 2.0;
		double offsetY = (648 - GRID_H * CELL_SIZE) / 2.0;
		container = Node2D.create();
		container.call("set_position", new Vector2(offsetX, offsetY));
		add_child(container, false, 0);

		// Grid background
		ColorRect bg = ColorRect.create();
		bg.call("set_color", BG_COLOR);
		bg.call("set_size", new Vector2(GRID_W * CELL_SIZE, GRID_H * CELL_SIZE));
		container.add_child(bg, false, 0);

		// Grid lines (horizontal)
		for (int y = 0; y <= GRID_H; y++) {
			ColorRect line = ColorRect.create();
			line.call("set_color", GRID_LINE_COLOR);
			line.call("set_size", new Vector2(GRID_W * CELL_SIZE, 1));
			line.call("set_position", new Vector2(0, y * CELL_SIZE));
			container.add_child(line, false, 0);
		}
		// Grid lines (vertical)
		for (int x = 0; x <= GRID_W; x++) {
			ColorRect line = ColorRect.create();
			line.call("set_color", GRID_LINE_COLOR);
			line.call("set_size", new Vector2(1, GRID_H * CELL_SIZE));
			line.call("set_position", new Vector2(x * CELL_SIZE, 0));
			container.add_child(line, false, 0);
		}

		// Food rect
		foodRect = ColorRect.create();
		foodRect.call("set_color", FOOD_COLOR);
		foodRect.call("set_size", new Vector2(CELL_SIZE - 2, CELL_SIZE - 2));
		container.add_child(foodRect, false, 0);

		// Score label
		scoreLabel = Label.create();
		scoreLabel.call("add_theme_font_size_override", "font_size", 24);
		scoreLabel.call("set_position", new Vector2(10, 10));
		add_child(scoreLabel, false, 0);

		// Message label
		messageLabel = Label.create();
		messageLabel.call("set_horizontal_alignment", 1);
		messageLabel.call("add_theme_font_size_override", "font_size", 28);
		messageLabel.call("set_position", new Vector2(1152 / 2 - 200, 648 / 2 - 20));
		messageLabel.call("set_size", new Vector2(400, 40));
		messageLabel.call("set_visible", false);
		add_child(messageLabel, false, 0);

		restart();
		updateScoreDisplay();
		logger.info("SnakeGame ready! Use arrow keys to move.");
	}

	@Override
	public void _process(double delta) {
		Input input = Input.singleton();

		if (input.is_action_just_pressed("move_up", false)) {
			setDirection(UP);
		} else if (input.is_action_just_pressed("move_right", false)) {
			setDirection(RIGHT);
		} else if (input.is_action_just_pressed("move_down", false)) {
			setDirection(DOWN);
		} else if (input.is_action_just_pressed("move_left", false)) {
			setDirection(LEFT);
		}

		if (gameOver && input.is_action_just_pressed("ui_accept", false)) {
			restart();
			messageLabel.call("set_visible", false);
			updateScoreDisplay();
		}

		if (gameOver) {
			return;
		}

		moveTimer += delta;
		if (moveTimer < moveInterval) {
			return;
		}
		moveTimer = 0;

		direction = nextDirection;

		int[] head = segments.get(0);
		int[] dir = DIR_VECTORS[direction];
		int newX = head[0] + dir[0];
		int newY = head[1] + dir[1];

		if (newX < 0 || newX >= GRID_W || newY < 0 || newY >= GRID_H) {
			endGame();
			return;
		}

		int limit = growing ? segments.size() : segments.size() - 1;
		for (int i = 0; i < limit; i++) {
			int[] seg = segments.get(i);
			if (seg[0] == newX && seg[1] == newY) {
				endGame();
				return;
			}
		}

		segments.add(0, new int[]{newX, newY});

		if (newX == foodX && newY == foodY) {
			score++;
			growing = true;
			call("emit_signal", "onScoreChanged", score);
			spawnFood();
			updateScoreDisplay();
		}

		if (growing) {
			growing = false;
		} else {
			segments.remove(segments.size() - 1);
		}

		updateVisuals();
	}

	private void updateVisuals() {
		// Sync segment rects to match segments list
		while (segmentRects.size() < segments.size()) {
			ColorRect rect = ColorRect.create();
			rect.call("set_size", new Vector2(CELL_SIZE - 2, CELL_SIZE - 2));
			container.add_child(rect, false, 0);
			segmentRects.add(rect);
		}
		while (segmentRects.size() > segments.size()) {
			ColorRect removed = segmentRects.remove(segmentRects.size() - 1);
			container.call("remove_child", removed);
		}

		// Update positions and colors
		for (int i = 0; i < segments.size(); i++) {
			int sx = segments.get(i)[0];
			int sy = segments.get(i)[1];
			ColorRect rect = segmentRects.get(i);
			rect.call("set_position", new Vector2(sx * CELL_SIZE + 1, sy * CELL_SIZE + 1));
			if (i == 0) {
				// Head: brighter, full size
				rect.call("set_color", HEAD_COLOR);
				rect.call("set_size", new Vector2(CELL_SIZE, CELL_SIZE));
				rect.call("set_position", new Vector2(sx * CELL_SIZE, sy * CELL_SIZE));
			} else {
				float t = (float) i / segments.size();
				double g = 0.8 - t * 0.4;
				rect.call("set_color", new Color(0.1, g, 0.2));
				rect.call("set_size", new Vector2(CELL_SIZE - 2, CELL_SIZE - 2));
			}
		}

		// Update food position
		foodRect.call("set_position", new Vector2(foodX * CELL_SIZE + 1, foodY * CELL_SIZE + 1));
	}

	private void endGame() {
		gameOver = true;
		call("emit_signal", "onGameOver", score);
		messageLabel.call("set_text", "Game Over! Score: " + score + "  [Space to restart]");
		messageLabel.call("set_visible", true);
		logger.info("Game Over! Final score: {}", score);
	}

	private void spawnFood() {
		for (int attempt = 0; attempt < 1000; attempt++) {
			int x = random.nextInt(GRID_W);
			int y = random.nextInt(GRID_H);
			boolean occupied = false;
			for (int[] seg : segments) {
				if (seg[0] == x && seg[1] == y) {
					occupied = true;
					break;
				}
			}
			if (!occupied) {
				foodX = x;
				foodY = y;
				return;
			}
		}
		foodX = random.nextInt(GRID_W);
		foodY = random.nextInt(GRID_H);
	}

	private void updateScoreDisplay() {
		scoreLabel.call("set_text", "Score: " + score);
	}

	@Signal
	public void onScoreChanged(int score) {
	}

	@Signal
	public void onGameOver(int finalScore) {
	}

	@GodotMethod
	public void setDirection(int dir) {
		if ((dir + 2) % 4 == direction) {
			return;
		}
		nextDirection = dir;
	}

	@GodotMethod
	public int getSegmentCount() {
		return segments.size();
	}

	@GodotMethod
	public int getSegmentX(int index) {
		if (index >= 0 && index < segments.size()) {
			return segments.get(index)[0];
		}
		return 0;
	}

	@GodotMethod
	public int getSegmentY(int index) {
		if (index >= 0 && index < segments.size()) {
			return segments.get(index)[1];
		}
		return 0;
	}

	@GodotMethod
	public int getFoodX() {
		return foodX;
	}

	@GodotMethod
	public int getFoodY() {
		return foodY;
	}

	@GodotMethod
	public int getScore() {
		return score;
	}

	@GodotMethod
	public boolean isGameOver() {
		return gameOver;
	}

	@GodotMethod
	public void restart() {
		segments.clear();
		int startX = GRID_W / 2;
		int startY = GRID_H / 2;
		for (int i = 0; i < 3; i++) {
			segments.add(new int[]{startX - i, startY});
		}
		direction = RIGHT;
		nextDirection = RIGHT;
		score = 0;
		gameOver = false;
		moveTimer = 0;
		growing = false;
		spawnFood();
		updateVisuals();
	}
}
