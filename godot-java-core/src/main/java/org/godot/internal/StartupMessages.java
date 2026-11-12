package org.godot.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Buffers errors raised during extension startup and flushes them at the end of
 * each initialization level (gdext parity 15034934/0d70b3ab).
 *
 * <p>
 * Messages are deduplicated per key — typically one per class — so repeated
 * failures from the same source report once (gdext's {@code once_per} key).
 * Buffering keeps startup output readable: everything is printed together after
 * the level completes, instead of interleaved with registration logs.
 *
 * <p>
 * Fatal errors abort the engine once initialization settles (exit code 111),
 * except in the interactive editor, where the process stays alive so the
 * messages remain readable — see {@code Bootstrap.handleStartupMessages()}.
 */
public final class StartupMessages {

	private static final Logger logger = LogManager.getLogger(StartupMessages.class);

	/** Single lock for the whole struct (buffer + keys + fatal flag). */
	private static final Object LOCK = new Object();

	private static final List<Message> BUFFERED = new ArrayList<>();

	private static final Set<String> REPORTED_KEYS = new HashSet<>();

	private static boolean fatalSeen = false;

	private record Message(Level level, String text) {
	}

	private StartupMessages() {
	}

	/// Report a recoverable startup error, deduplicated per key.
	public static void error(String key, String message) {
		report(key, Level.ERROR, message);
	}

	/// Report a fatal startup error: the engine will quit (exit code 111) once
	/// initialization settles, unless running in the interactive editor.
	public static void fatal(String key, String message) {
		report(key, Level.FATAL, message);
	}

	/** Buffer a message unless its key was already reported. */
	public static void report(String key, Level level, String message) {
		synchronized (LOCK) {
			if (!REPORTED_KEYS.add(key)) {
				return;
			}
			if (level == Level.FATAL) {
				fatalSeen = true;
			}
			BUFFERED.add(new Message(level, message));
		}
	}

	/// Number of buffered messages not yet flushed.
	public static int pendingCount() {
		synchronized (LOCK) {
			return BUFFERED.size();
		}
	}

	/// Flush all buffered messages to the log. Returns whether any fatal error
	/// was reported since the last reset — fatals persist across flushes so
	/// later levels still abort after earlier ones flushed.
	public static boolean flush() {
		List<Message> toLog;
		synchronized (LOCK) {
			toLog = new ArrayList<>(BUFFERED);
			BUFFERED.clear();
		}
		for (Message message : toLog) {
			logger.log(message.level(), "[startup] {}", message.text());
		}
		synchronized (LOCK) {
			return fatalSeen;
		}
	}

	/** Test hook: forget all buffered messages and reported keys. */
	public static void resetForTesting() {
		synchronized (LOCK) {
			BUFFERED.clear();
			REPORTED_KEYS.clear();
			fatalSeen = false;
		}
	}
}
