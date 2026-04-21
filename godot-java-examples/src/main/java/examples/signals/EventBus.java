package examples.signals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.node.Node;

/**
 * Example 04: Signals
 *
 * Demonstrates how to declare signals in Java and emit them. Signals allow Java
 * objects to notify GDScript of events.
 */
@GodotClass(name = "EventBus", parent = "Node")
public class EventBus extends Node {

	private static final Logger logger = LogManager.getLogger(EventBus.class);

	private int score = 0;

	@Signal
	public void scoreChanged(int newScore) {
	}

	@Signal
	public void levelCompleted(String levelName, int score) {
	}

	@Override
	public void _ready() {
		logger.info("EventBus ready! Signals: scoreChanged, levelCompleted");
	}

	@GodotMethod
	public void addScore(int points) {
		score += points;
		logger.info("Score updated: {}", score);
		call("emit_signal", "scoreChanged", score);
	}

	@GodotMethod
	public void completeLevel(String name) {
		logger.info("Level completed: {} with score {}", name, score);
		call("emit_signal", "levelCompleted", name, score);
	}

	@GodotMethod
	public int getScore() {
		return score;
	}
}
