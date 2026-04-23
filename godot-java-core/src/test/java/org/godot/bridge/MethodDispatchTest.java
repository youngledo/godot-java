package org.godot.bridge;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MethodDispatchTest {

	@Test
	void methodKeyGenerationIsUnique() throws Exception {
		// Access the private nextMethodKey field
		var field = MethodDispatch.class.getDeclaredField("nextMethodKey");
		field.setAccessible(true);
		AtomicLong keyGen = (AtomicLong) field.get(null);

		long start = keyGen.get();
		int count = 1000;
		List<Long> keys = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			keys.add(keyGen.getAndIncrement());
		}

		// All keys should be unique
		assertEquals(count, keys.stream().distinct().count());
		// Keys should be sequential from start
		for (int i = 0; i < count; i++) {
			assertEquals(start + i, keys.get(i));
		}
	}

	@Test
	void concurrentKeyGenerationNoCollisions() throws Exception {
		var field = MethodDispatch.class.getDeclaredField("nextMethodKey");
		field.setAccessible(true);
		AtomicLong keyGen = (AtomicLong) field.get(null);

		int threadCount = 8;
		int keysPerThread = 1000;
		List<Long> allKeys = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch latch = new CountDownLatch(threadCount);

		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		for (int t = 0; t < threadCount; t++) {
			executor.submit(() -> {
				try {
					for (int i = 0; i < keysPerThread; i++) {
						allKeys.add(keyGen.getAndIncrement());
					}
				} finally {
					latch.countDown();
				}
			});
		}

		assertTrue(latch.await(5, TimeUnit.SECONDS));
		executor.shutdown();

		// All keys should be unique
		int expectedTotal = threadCount * keysPerThread;
		assertEquals(expectedTotal, allKeys.size());
		assertEquals(expectedTotal, allKeys.stream().distinct().count());
	}

	@Test
	void coerceTypeHandlesNumericConversions() throws Exception {
		var method = MethodDispatch.class.getDeclaredMethod("coerceType", Object.class, Class.class);
		method.setAccessible(true);

		// Int conversions
		assertEquals(42, method.invoke(null, 42L, int.class));
		assertEquals(42, method.invoke(null, 42.0, int.class));
		assertEquals(42, method.invoke(null, (short) 42, int.class));

		// Double conversions
		assertEquals(42.0, method.invoke(null, 42, double.class));
		assertEquals(42.5, method.invoke(null, 42.5f, double.class));

		// Float conversions
		assertEquals(42.0f, method.invoke(null, 42, float.class));

		// Long conversions
		assertEquals(42L, method.invoke(null, 42, long.class));
	}

	@Test
	void coerceTypeReturnsNullForNull() throws Exception {
		var method = MethodDispatch.class.getDeclaredMethod("coerceType", Object.class, Class.class);
		method.setAccessible(true);

		assertNull(method.invoke(null, null, int.class));
		assertNull(method.invoke(null, null, String.class));
	}

	@Test
	void coerceTypePassesThroughNonNumeric() throws Exception {
		var method = MethodDispatch.class.getDeclaredMethod("coerceType", Object.class, Class.class);
		method.setAccessible(true);

		String value = "hello";
		assertEquals(value, method.invoke(null, value, String.class));
	}
}
