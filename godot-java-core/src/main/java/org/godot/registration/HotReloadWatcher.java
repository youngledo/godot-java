package org.godot.registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Watches a JAR file for changes and triggers hot reload when the file is
 * modified.
 *
 * <p>
 * Enabled via environment variable {@code GODOT_JAVA_HOT_RELOAD=true}. When
 * enabled, monitors the JAR file containing user classes and calls
 * {@link org.godot.Godot#reloadUserCode(String)} when changes are detected.
 *
 * <p>
 * A debounce delay of 500ms prevents multiple reloads during a single
 * compilation cycle.
 */
public final class HotReloadWatcher {

	private static final Logger logger = LogManager.getLogger(HotReloadWatcher.class);
	private static final long DEBOUNCE_MS = 500;

	private static final AtomicBoolean running = new AtomicBoolean(false);
	private static Thread watcherThread;

	private HotReloadWatcher() {
	}

	/**
	 * Check if hot reload is enabled via environment variable.
	 */
	public static boolean isEnabled() {
		return "true".equalsIgnoreCase(System.getenv("GODOT_JAVA_HOT_RELOAD"));
	}

	/**
	 * Start watching the given JAR file for changes.
	 *
	 * @param jarPath
	 *            Absolute path to the JAR file to watch
	 */
	public static void start(String jarPath) {
		if (!isEnabled()) {
			logger.debug("Hot reload disabled (set GODOT_JAVA_HOT_RELOAD=true to enable)");
			return;
		}
		if (!running.compareAndSet(false, true)) {
			logger.warn("HotReloadWatcher already running");
			return;
		}

		Path jarFile = Path.of(jarPath).toAbsolutePath();
		Path parentDir = jarFile.getParent();
		Path fileName = jarFile.getFileName();
		if (parentDir == null || fileName == null) {
			logger.error("HotReloadWatcher: invalid jar path {}", jarPath);
			running.set(false);
			return;
		}
		String jarName = fileName.toString();

		watcherThread = new Thread(() -> {
			logger.info("HotReloadWatcher started: watching {}", jarPath);
			try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
				parentDir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

				long lastReload = 0;
				while (running.get()) {
					WatchKey key = watcher.take();
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
							continue;
						}
						Path changedFile = (Path) event.context();
						if (jarName.equals(changedFile.toString())) {
							long now = System.currentTimeMillis();
							if (now - lastReload > DEBOUNCE_MS) {
								lastReload = now;
								logger.info("JAR change detected: {}", jarPath);
								org.godot.Godot.reloadUserCode(jarPath);
							}
						}
					}
					key.reset();
				}
			} catch (InterruptedException e) {
				logger.info("HotReloadWatcher interrupted, stopping");
			} catch (Exception e) {
				logger.error("HotReloadWatcher error", e);
			} finally {
				running.set(false);
			}
		}, "godot-java-hot-reload");
		watcherThread.setDaemon(true);
		watcherThread.start();
	}

	/** Stop the watcher thread. */
	public static void stop() {
		running.set(false);
		if (watcherThread != null) {
			watcherThread.interrupt();
		}
	}
}
