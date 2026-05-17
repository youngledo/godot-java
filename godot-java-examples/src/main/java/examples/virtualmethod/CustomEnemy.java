package examples.virtualmethod;

import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.CharacterBody2D;

/// A custom enemy that extends the virtual method behavior from Java side.
@GodotClass(name = "CustomEnemy", parent = "CharacterBody2D")
public class CustomEnemy extends CharacterBody2D {

	@GodotMethod
	public int getAttackDamage() {
		return 25;
	}
}
