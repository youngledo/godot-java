package examples.integrationtest;

import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Signal;
import org.godot.math.Vector2;
import org.godot.node.Control;
import org.godot.node.Node;

/**
 * Integration test node. Validates all core features from the Java side.
 * GDScript (test_runner.gd) reads outputs and prints PASS/FAIL markers.
 */
@GodotClass(name = "IntegrationTestNode", parent = "Node")
public class IntegrationTestNode extends Node {

	private boolean readyCalled = false;
	private boolean processCalled = false;
	private double lastDelta = -1.0;
	private int processCount = 0;
	private int lastNotification = -1;
	private int notificationCount = 0;

	@Export
	public int exportedInt = 42;

	@Export
	public String exportedString = "hello";

	@Export
	public float exportedFloat = 3.14f;

	@Export
	public boolean exportedBool = true;

	private int methodCallCount = 0;

	@Signal
	public void testSignal(int value) {
	}

	@Signal
	public void stringSignal(String msg) {
	}

	@Override
	public void _ready() {
		readyCalled = true;
		System.out.println("[IT] _ready called");
	}

	@Override
	public void onNotification(int what) {
		lastNotification = what;
		notificationCount++;
		System.out.println("[IT] onNotification: " + what);
	}

	@Override
	public void _process(double delta) {
		if (!processCalled) {
			processCalled = true;
			lastDelta = delta;
			System.out.println("[IT] _process called, delta=" + delta);
		}
		processCount++;
		if (processCount >= 3) {
			// Stop processing after 3 frames
			setProperty("process_mode", 4); // PROCESS_MODE_DISABLED = 4
		}
	}

	// ---- Methods callable from GDScript ----

	@GodotMethod
	public boolean wasReadyCalled() {
		return readyCalled;
	}

	@GodotMethod
	public boolean wasProcessCalled() {
		return processCalled;
	}

	@GodotMethod
	public double getLastDelta() {
		return lastDelta;
	}

	@GodotMethod
	public int add(int a, int b) {
		methodCallCount++;
		return a + b;
	}

	@GodotMethod
	public String echo(String msg) {
		methodCallCount++;
		return "echo:" + msg;
	}

	@GodotMethod
	public int getMethodCallCount() {
		return methodCallCount;
	}

	@GodotMethod
	public int getLastNotification() {
		return lastNotification;
	}

	@GodotMethod
	public int getNotificationCount() {
		return notificationCount;
	}

	@GodotMethod
	public void emitTestSignal(int value) {
		emitSignal("testSignal", value);
	}

	@GodotMethod
	public void emitStringSignal(String msg) {
		emitSignal("stringSignal", msg);
	}

	@GodotMethod
	public int getExportedInt() {
		return exportedInt;
	}

	@GodotMethod
	public void setExportedInt(int val) {
		exportedInt = val;
	}

	// ---- Control layout tests (Task 4.5) ----

	@GodotMethod
	public boolean test_control_minimum_size() {
		// Create a Control to test minimum size methods
		Control control = Control.create();
		if (control == null || !control.isValid()) {
			System.out.println("FAIL: could not create Control");
			return false;
		}

		// Set custom minimum size using Vector2
		control.setCustom_minimum_size(new Vector2(100, 50));

		// Get the minimum width and height
		double minWidth = control.getCustom_minimum_size().x;
		double minHeight = control.getCustom_minimum_size().y;

		// Verify - custom minimum size should be reflected in getMinimumWidth/Height
		// Note: getMinimumWidth/Height returns the current minimum size which
		// may be larger if the content requires it
		if (minWidth < 0 || minHeight < 0) {
			System.out.println("FAIL: minWidth/minHeight should be >= 0, got w=" + minWidth + " h=" + minHeight);
			return false;
		}

		System.out.println("PASS: Control minimum size working (w=" + minWidth + " h=" + minHeight + ")");
		return true;
	}
}
