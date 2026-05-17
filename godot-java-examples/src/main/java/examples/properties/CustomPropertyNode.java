package examples.properties;

import org.godot.annotation.Export;
import org.godot.annotation.ExportGroup;
import org.godot.annotation.GodotClass;
import org.godot.annotation.PropertyHint;
import org.godot.node.Node2D;

@GodotClass(name = "CustomPropertyNode", parent = "Node2D")
public class CustomPropertyNode extends Node2D {

	@ExportGroup("Stats")
	@Export(getter = "getHealth", setter = "setHealth", hint = PropertyHint.RANGE, hintString = "0,100,1")
	private int health = 100;

	@Export(readOnly = true)
	private String status = "alive";

	@ExportGroup("Movement")
	@Export
	private float speed = 300.0f;

	public int getHealth() {
		return health;
	}

	public void setHealth(int value) {
		health = Math.max(0, Math.min(100, value));
		if (health == 0) {
			status = "dead";
		}
	}

	public String getStatus() {
		return status;
	}
}
