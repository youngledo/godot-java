package org.godot.lifecycle;

import org.godot.Godot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GodotNotificationTest {
	@Test
	void normalNotificationOnlyCallsGenericHook() {
		TestGodot godot = new TestGodot();

		godot.onNotification(13);

		assertEquals(List.of(13), godot.notifications);
		assertEquals(0, godot.accessibilityUpdates);
		assertEquals(0, godot.accessibilityInvalidates);
	}

	@Test
	void accessibilityUpdateCallsGenericAndSpecificHooks() {
		TestGodot godot = new TestGodot();

		godot.onNotification(Godot.NOTIFICATION_ACCESSIBILITY_UPDATE);

		assertEquals(List.of(Godot.NOTIFICATION_ACCESSIBILITY_UPDATE), godot.notifications);
		assertEquals(1, godot.accessibilityUpdates);
		assertEquals(0, godot.accessibilityInvalidates);
	}

	@Test
	void accessibilityInvalidateCallsGenericAndSpecificHooks() {
		TestGodot godot = new TestGodot();

		godot.onNotification(Godot.NOTIFICATION_ACCESSIBILITY_INVALIDATE);

		assertEquals(List.of(Godot.NOTIFICATION_ACCESSIBILITY_INVALIDATE), godot.notifications);
		assertEquals(0, godot.accessibilityUpdates);
		assertEquals(1, godot.accessibilityInvalidates);
	}

	private static final class TestGodot extends Godot {
		final List<Integer> notifications = new ArrayList<>();
		int accessibilityUpdates;
		int accessibilityInvalidates;

		@Override
		public void _notification(int what) {
			notifications.add(what);
		}

		@Override
		public void _accessibilityUpdate() {
			accessibilityUpdates++;
		}

		@Override
		public void _accessibilityInvalidate() {
			accessibilityInvalidates++;
		}
	}
}
