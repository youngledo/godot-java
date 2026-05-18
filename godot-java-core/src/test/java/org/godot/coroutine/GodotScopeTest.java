package org.godot.coroutine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class GodotScopeTest {

	@Test
	void launchRunsVirtualThread() throws InterruptedException {
		AtomicBoolean ran = new AtomicBoolean(false);
		GodotScope.launch(() -> {
			ran.set(true);
		});
		Thread.sleep(50);
		assertTrue(ran.get());
	}

	@Test
	void delaySuspendsAndResumes() throws InterruptedException {
		AtomicReference<String> state = new AtomicReference<>("started");
		GodotScope.launch(() -> {
			state.set("before-delay");
			GodotScope.delay(0.05); // 50ms
			state.set("after-delay");
		});
		Thread.sleep(20);
		assertEquals("before-delay", state.get());
		Thread.sleep(100);
		GodotScope.flush();
		Thread.sleep(20);
		assertEquals("after-delay", state.get());
	}

	@Test
	void awaitOnSignalResumesOnEmit() throws InterruptedException {
		AtomicBoolean resumed = new AtomicBoolean(false);
		var signal = new GodotScope.SignalHandle();
		GodotScope.launch(() -> {
			signal.await();
			resumed.set(true);
		});
		Thread.sleep(50);
		assertFalse(resumed.get());
		signal.fire();
		GodotScope.flush();
		Thread.sleep(50);
		assertTrue(resumed.get());
	}
}
