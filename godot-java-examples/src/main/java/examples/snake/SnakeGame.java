package examples.snake;

import java.util.ArrayList;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.node.Node;

/**
 * Example 10: Snake
 *
 * Classic Snake game logic on a grid. Rendering and input are handled by
 * GDScript — this class manages the snake body, food, movement, collision, and
 * scoring.
 *
 * Direction constants: 0=up, 1=right, 2=down, 3=left
 */
@GodotClass(name = "SnakeGame", parent = "Node")
public class SnakeGame extends Node {

	private static final Logger logger = LogManager.getLogger(SnakeGame.class);

	// Direction constants
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;

	// Direction vectors: [dx, dy] indexed by direction constant
	private static final int[][] DIR_VECTORS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

	@Export
	public int gridWidth = 30;

	@Export
	public int gridHeight = 30;

	@Export
	public double moveInterval = 0.1;

	private final ArrayList<int[]> segments = new ArrayList<>();
	private int foodX;
	private int foodY;
	private int direction = RIGHT;
	private int nextDirection = RIGHT;
	private int score;
	private boolean gameOver;
	private double moveTimer;
	private boolean growing;
	private final Random random = new Random();

	@Override
	public void _ready() {
		restart();
		logger.info("SnakeGame ready! Grid: {}x{}", gridWidth, gridHeight);
	}

	@Override
	public void _process(double delta) {
		if (gameOver) {
			return;
		}

		moveTimer += delta;
		if (moveTimer < moveInterval) {
			return;
		}
		moveTimer = 0;

		// Apply queued direction
		direction = nextDirection;

		// Calculate new head position
		int[] head = segments.get(0);
		int[] dir = DIR_VECTORS[direction];
		int newX = head[0] + dir[0];
		int newY = head[1] + dir[1];

		// Wall collision
		if (newX < 0 || newX >= gridWidth || newY < 0 || newY >= gridHeight) {
			endGame();
			return;
		}

		// Self collision (check against all segments except the tail, which will move)
		int limit = growing ? segments.size() : segments.size() - 1;
		for (int i = 0; i < limit; i++) {
			int[] seg = segments.get(i);
			if (seg[0] == newX && seg[1] == newY) {
				endGame();
				return;
			}
		}

		// Add new head
		segments.add(0, new int[]{newX, newY});

		// Check food
		if (newX == foodX && newY == foodY) {
			score++;
			growing = true;
			call("emit_signal", "onScoreChanged", score);
			spawnFood();
			logger.info("Food eaten! Score: {}", score);
		}

		// Remove tail (unless growing)
		if (growing) {
			growing = false;
		} else {
			segments.remove(segments.size() - 1);
		}
	}

	private void endGame() {
		gameOver = true;
		call("emit_signal", "onGameOver", score);
		logger.info("Game Over! Final score: {}", score);
	}

	private void spawnFood() {
		// Try to find an empty cell
		for (int attempt = 0; attempt < 1000; attempt++) {
			int x = random.nextInt(gridWidth);
			int y = random.nextInt(gridHeight);
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
		// Fallback: just place it randomly
		foodX = random.nextInt(gridWidth);
		foodY = random.nextInt(gridHeight);
	}

	@Signal
	public void onScoreChanged(int score) {
	}

	@Signal
	public void onGameOver(int finalScore) {
	}

	@GodotMethod
	public void setDirection(int dir) {
		// Prevent 180° reversal
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
		int startX = gridWidth / 2;
		int startY = gridHeight / 2;
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
	}
}
