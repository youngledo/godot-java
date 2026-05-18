package org.godot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GodotDowncastTest {

	/// Fake non-zero pointer to make isValid() return true.
	private static final long PTR = 0xDEAD_BEEFL;

	@Test
	void asReturnsNullForNullObject() {
		assertNull(Godot.as(null, org.godot.node.Node.class));
	}

	@Test
	void asReturnsNullForInvalidObject() {
		var node = new org.godot.node.Node(0L);
		assertNull(Godot.as(node, org.godot.node.Node.class));
	}

	@Test
	void asReturnsSameObjectForExactType() {
		var node = new org.godot.node.Node2D(PTR);
		var result = Godot.as(node, org.godot.node.Node2D.class);
		assertSame(node, result);
	}

	@Test
	void asReturnsNullForIncompatibleType() {
		var node = new org.godot.node.Node(PTR);
		var result = Godot.as(node, org.godot.node.Node2D.class);
		assertNull(result);
	}

	@Test
	void asReturnsSubclassForCompatibleType() {
		var node2d = new org.godot.node.Node2D(PTR);
		var result = Godot.as(node2d, org.godot.node.Node.class);
		assertSame(node2d, result);
	}
}
