package org.godot.internal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.godot.Godot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DestroyedDuringCallReporterTest {

	@AfterEach
	void reset() {
		DestroyedDuringCallReporter.resetForTesting();
	}

	@Test
	void skipsValidObjectsAndReportsEachClassOnce() {
		Godot obj = new Godot() {
		};
		obj.setNativeObject(0x42);

		// Object alive during the call — nothing to report
		DestroyedDuringCallReporter.reportIfDestroyed(obj, "MyClass", "tick");
		assertFalse(DestroyedDuringCallReporter.wasReported("MyClass"));

		// Destroyed during the call — reported
		obj.invalidate();
		DestroyedDuringCallReporter.reportIfDestroyed(obj, "MyClass", "die");
		assertTrue(DestroyedDuringCallReporter.wasReported("MyClass"));

		// Same class again — suppressed (once per class)
		DestroyedDuringCallReporter.reportIfDestroyed(obj, "MyClass", "other");

		// A different class gets its own report
		DestroyedDuringCallReporter.reportIfDestroyed(obj, "OtherClass", "x");
		assertTrue(DestroyedDuringCallReporter.wasReported("OtherClass"));
	}
}
