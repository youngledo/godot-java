package examples.pong;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.node.Node;

/**
 * Example 09: Pong
 *
 * Classic Pong game logic with AI opponent. Rendering and input are handled by
 * GDScript — this class manages ball physics, paddle movement, collision
 * detection, and scoring.
 */
@GodotClass(name = "PongGame", parent = "Node")
public class PongGame extends Node {

	private static final Logger logger = LogManager.getLogger(PongGame.class);

	// Play area
	private static final double WIDTH = 800.0;
	private static final double HEIGHT = 500.0;
	private static final double PADDLE_W = 15.0;
	private static final double PADDLE_H = 100.0;
	private static final double BALL_SIZE = 12.0;
	private static final double PADDLE_OFFSET = 30.0;
	private static final int WIN_SCORE = 5;

	@Export
	public double ballSpeed = 400.0;

	@Export
	public double paddleSpeed = 350.0;

	// Ball state
	private double ballX;
	private double ballY;
	private double ballVX;
	private double ballVY;

	// Paddle positions (Y center)
	private double playerY;
	private double aiY;

	// Input
	private double playerDirection;

	// Score
	private int playerScore;
	private int aiScore;

	private boolean running;
	private final Random random = new Random();

	@Override
	public void _ready() {
		resetGame();
		logger.info("PongGame ready! First to {} wins.", WIN_SCORE);
	}

	@Override
	public void _process(double delta) {
		if (!running) {
			return;
		}

		// Move player paddle
		playerY += playerDirection * paddleSpeed * delta;
		playerY = clamp(playerY, PADDLE_H / 2, HEIGHT - PADDLE_H / 2);

		// AI paddle: track ball with smoothing
		double aiTarget = ballY;
		double aiDiff = aiTarget - aiY;
		double aiMove = Math.signum(aiDiff) * Math.min(Math.abs(aiDiff), paddleSpeed * 0.7 * delta);
		aiY += aiMove;
		aiY = clamp(aiY, PADDLE_H / 2, HEIGHT - PADDLE_H / 2);

		// Move ball
		ballX += ballVX * delta;
		ballY += ballVY * delta;

		// Ball bounce off top/bottom
		if (ballY - BALL_SIZE / 2 <= 0) {
			ballY = BALL_SIZE / 2;
			ballVY = Math.abs(ballVY);
		} else if (ballY + BALL_SIZE / 2 >= HEIGHT) {
			ballY = HEIGHT - BALL_SIZE / 2;
			ballVY = -Math.abs(ballVY);
		}

		// Ball vs player paddle (left side)
		double playerPaddleX = PADDLE_OFFSET;
		if (ballVX < 0 && ballX - BALL_SIZE / 2 <= playerPaddleX + PADDLE_W && ballX + BALL_SIZE / 2 >= playerPaddleX
				&& ballY >= playerY - PADDLE_H / 2 - BALL_SIZE / 2 && ballY <= playerY + PADDLE_H / 2 + BALL_SIZE / 2) {
			ballX = playerPaddleX + PADDLE_W + BALL_SIZE / 2;
			bounceOffPaddle(playerY, 1);
		}

		// Ball vs AI paddle (right side)
		double aiPaddleX = WIDTH - PADDLE_OFFSET - PADDLE_W;
		if (ballVX > 0 && ballX + BALL_SIZE / 2 >= aiPaddleX && ballX - BALL_SIZE / 2 <= aiPaddleX + PADDLE_W
				&& ballY >= aiY - PADDLE_H / 2 - BALL_SIZE / 2 && ballY <= aiY + PADDLE_H / 2 + BALL_SIZE / 2) {
			ballX = aiPaddleX - BALL_SIZE / 2;
			bounceOffPaddle(aiY, -1);
		}

		// Scoring
		if (ballX < -BALL_SIZE) {
			aiScore++;
			logger.info("AI scores! Player {} - AI {}", playerScore, aiScore);
			call("emit_signal", "onScore", playerScore, aiScore);
			if (aiScore >= WIN_SCORE) {
				running = false;
				logger.info("AI wins!");
			} else {
				launchBall(1);
			}
		} else if (ballX > WIDTH + BALL_SIZE) {
			playerScore++;
			logger.info("Player scores! Player {} - AI {}", playerScore, aiScore);
			call("emit_signal", "onScore", playerScore, aiScore);
			if (playerScore >= WIN_SCORE) {
				running = false;
				logger.info("Player wins!");
			} else {
				launchBall(-1);
			}
		}
	}

	private void bounceOffPaddle(double paddleYCenter, int directionX) {
		// Bounce angle depends on where the ball hit the paddle
		double relativeHit = (ballY - paddleYCenter) / (PADDLE_H / 2);
		double maxAngle = Math.PI / 3; // 60 degrees max
		double angle = relativeHit * maxAngle;

		double speed = Math.sqrt(ballVX * ballVX + ballVY * ballVY);
		// Speed up slightly on each hit
		speed = Math.min(speed * 1.05, ballSpeed * 2.0);

		ballVX = directionX * speed * Math.cos(angle);
		ballVY = speed * Math.sin(angle);
	}

	private void launchBall(int directionX) {
		ballX = WIDTH / 2;
		ballY = HEIGHT / 2;
		double angle = (random.nextDouble() - 0.5) * Math.PI / 3;
		ballVX = directionX * ballSpeed * Math.cos(angle);
		ballVY = ballSpeed * Math.sin(angle);
	}

	@Signal
	public void onScore(int player, int ai) {
	}

	@GodotMethod
	public double getBallX() {
		return ballX;
	}

	@GodotMethod
	public double getBallY() {
		return ballY;
	}

	@GodotMethod
	public double getPlayerY() {
		return playerY;
	}

	@GodotMethod
	public double getAiY() {
		return aiY;
	}

	@GodotMethod
	public int getPlayerScore() {
		return playerScore;
	}

	@GodotMethod
	public int getAiScore() {
		return aiScore;
	}

	@GodotMethod
	public void setPlayerDirection(double dir) {
		this.playerDirection = dir;
	}

	@GodotMethod
	public boolean isRunning() {
		return running;
	}

	@GodotMethod
	public void resetGame() {
		playerY = HEIGHT / 2;
		aiY = HEIGHT / 2;
		playerScore = 0;
		aiScore = 0;
		playerDirection = 0;
		running = true;
		launchBall(random.nextBoolean() ? 1 : -1);
	}

	private static double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(max, value));
	}
}
