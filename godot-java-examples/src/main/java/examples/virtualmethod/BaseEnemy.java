package examples.virtualmethod;

import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.CharacterBody2D;

/// Base enemy class with a virtual method that GDScript can override.
@GodotClass(name = "BaseEnemy", parent = "CharacterBody2D")
public class BaseEnemy extends CharacterBody2D {

	/// Calculate damage based on the attack type.
    ///
    /// GDScript can override this method to provide custom damage calculations.
    /// If not overridden, returns a default value of 10.
	@GodotMethod(virtual = true)
	public int calculateDamage(int attackType) {
		return 10; // default damage
	}

	/// Get the enemy's display name.
	@GodotMethod(virtual = true)
	public String getDisplayName() {
		return "Base Enemy";
	}
}
