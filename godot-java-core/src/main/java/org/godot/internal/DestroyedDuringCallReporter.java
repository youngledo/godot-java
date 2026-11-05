package org.godot.internal;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.Godot;

/**
 * Reports Godot objects destroyed while a Godot→Java call is still running.
 *
 * <p>
 * The Java side survives such a destruction, but the engine may still
 * dereference {@code this} after the callback returns, which is undefined
 * behavior on the engine side. Mirrors gdext's destruction-during-call
 * reporting: logged once per class, with guidance toward a clean destruction
 * order.
 */
public final class DestroyedDuringCallReporter {

	private static final Logger logger = LogManager.getLogger(DestroyedDuringCallReporter.class);

	private static final Set<String> REPORTED = ConcurrentHashMap.newKeySet();

	private DestroyedDuringCallReporter() {
	}

	/**
	 * Report that {@code obj} became invalid during the invocation of
	 * {@code methodName}, unless this class was already reported.
	 */
	public static void reportIfDestroyed(Godot obj, String className, String methodName) {
		if (obj.isValid()) {
			return;
		}
		if (REPORTED.add(className)) {
			logger.error(
					"Godot object destroyed during Godot->Java call ({}.{}). "
							+ "The engine may access the freed object after the method returns. "
							+ "Prefer queue_free() or otherwise defer destruction. Reported once per class.",
					className, methodName);
		}
	}

	/** Whether this class already had a destruction reported. */
	static boolean wasReported(String className) {
		return REPORTED.contains(className);
	}

	/** Test hook: forget already-reported classes. */
	public static void resetForTesting() {
		REPORTED.clear();
	}
}
