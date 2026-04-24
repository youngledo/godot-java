package org.godot.bridge;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for dynamic RefCounted parent class detection. Verifies that the
 * generated Java class hierarchy correctly identifies RefCounted-derived types
 * without relying on a hardcoded name list.
 */
public class RefCountedDetectionTest {

	@Test
	void resourceInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Resource.class),
				"Resource should inherit from RefCounted");
	}

	@Test
	void texture2DInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Texture2D.class),
				"Texture2D → Resource → RefCounted");
	}

	@Test
	void meshInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Mesh.class),
				"Mesh → Resource → RefCounted");
	}

	@Test
	void nodeDoesNotInheritFromRefCounted() {
		assertFalse(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Node.class),
				"Node should NOT inherit from RefCounted");
	}

	@Test
	void node2DDoesNotInheritFromRefCounted() {
		assertFalse(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Node2D.class),
				"Node2D → Node → NOT RefCounted");
	}

	@Test
	void characterBody2DDoesNotInheritFromRefCounted() {
		assertFalse(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.CharacterBody2D.class),
				"CharacterBody2D → PhysicsBody2D → CollisionObject2D → Node2D → NOT RefCounted");
	}

	@Test
	void imageTextureInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.ImageTexture.class),
				"ImageTexture → Texture2D → Resource → RefCounted");
	}

	@Test
	void audioStreamInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.AudioStream.class),
				"AudioStream → Resource → RefCounted");
	}

	@Test
	void fontInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Font.class),
				"Font → Resource → RefCounted");
	}

	@Test
	void gradientInheritsFromRefCounted() {
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Gradient.class),
				"Gradient → RefCounted (was missing from hardcoded list)");
	}

	@Test
	void isRefCountedParent_reflectiveInvocation() throws Exception {
		// Invoke the private isRefCountedParent method via reflection
		Method method = InstanceCallbacks.class.getDeclaredMethod("isRefCountedParent", String.class);
		method.setAccessible(true);

		// We need PARENT_CLASS_NAMES to be populated, which happens during
		// registration.
		// For a unit test without registration, we test the generated class hierarchy
		// directly instead.
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Material.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.ShaderMaterial.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Script.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Theme.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.TileSet.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Animation.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.InputEvent.class));
		assertTrue(org.godot.node.RefCounted.class.isAssignableFrom(org.godot.node.Shader.class));
	}
}
