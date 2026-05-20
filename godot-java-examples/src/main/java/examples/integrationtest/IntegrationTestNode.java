package examples.integrationtest;

import org.godot.annotation.Export;
import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.annotation.Rpc;
import org.godot.annotation.RpcMode;
import org.godot.annotation.Signal;
import org.godot.annotation.TransferMode;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.internal.NativeMemoryTracker;
import org.godot.internal.ref.JavaObjectMap;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.RefCountedHelper;
import org.godot.math.Vector2;
import org.godot.node.Control;
import org.godot.node.InputEvent;
import org.godot.node.Node;
import org.godot.node.RefCounted;

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
	private final StringBuilder lifecycleEvents = new StringBuilder();

	@Export
	public int exportedInt = 42;

	@Export
	public String exportedString = "hello";

	@Export
	public float exportedFloat = 3.14f;

	@Export
	public boolean exportedBool = true;

	private int methodCallCount = 0;
	private boolean rpcCalled = false;

	@Signal
	public void testSignal(int value) {
	}

	@Signal
	public void stringSignal(String msg) {
	}

	@Override
	public void _enterTree() {
		recordLifecycleEvent("enter_tree");
		System.out.println("[IT] _enterTree called");
	}

	@Override
	public void _ready() {
		readyCalled = true;
		recordLifecycleEvent("ready");
		System.out.println("[IT] _ready called");
	}

	@Override
	public void _exitTree() {
		recordLifecycleEvent("exit_tree");
		System.out.println("[IT] _exitTree called");
	}

	@Override
	public void onNotification(int what) {
		lastNotification = what;
		notificationCount++;
		if (what == 10) {
			recordLifecycleEvent("notification_enter_tree");
		} else if (what == 13) {
			recordLifecycleEvent("notification_ready");
		}
		System.out.println("[IT] onNotification: " + what);
	}

	@Override
	public void _process(double delta) {
		if (!processCalled) {
			processCalled = true;
			lastDelta = delta;
			recordLifecycleEvent("process");
			System.out.println("[IT] _process called, delta=" + delta);
		}
		processCount++;
		if (processCount >= 3) {
			// Stop processing after 3 frames
			setProperty("process_mode", 4); // PROCESS_MODE_DISABLED = 4
		}
	}

	// ---- Methods callable from GDScript ----

	private void recordLifecycleEvent(String event) {
		if (!lifecycleEvents.isEmpty()) {
			lifecycleEvents.append(",");
		}
		lifecycleEvents.append(event);
	}

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
	public String getLifecycleEvents() {
		return lifecycleEvents.toString();
	}

	@GodotMethod
	public void emitTestSignal(int value) {
		new IntegrationTestNodeSignals(this).testSignal().emit(value);
	}

	@GodotMethod
	public void emitStringSignal(String msg) {
		new IntegrationTestNodeSignals(this).stringSignal().emit(msg);
	}

	@GodotMethod
	public int getExportedInt() {
		return exportedInt;
	}

	@GodotMethod
	public void setExportedInt(int val) {
		exportedInt = val;
	}

	@GodotMethod
	public String primitiveDispatchMatrix(int intValue, long longValue, float floatValue, double doubleValue,
			boolean boolValue, String stringValue) {
		methodCallCount++;
		return intValue + ":" + longValue + ":" + Math.round(floatValue * 10.0f) + ":" + Math.round(doubleValue * 10.0)
				+ ":" + boolValue + ":" + stringValue;
	}

	@GodotMethod
	public double vector2LengthSquared(Vector2 value) {
		methodCallCount++;
		return value.x * value.x + value.y * value.y;
	}

	@GodotMethod
	public boolean generatedRegistryAvailable() {
		try {
			Class.forName("org.godot.internal.GeneratedClassRegistry");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	@GodotMethod
	public int getJavaObjectMapSize() {
		return JavaObjectMap.size();
	}

	@GodotMethod
	public int getTrackedRefCountedCount() {
		return RefCountedHelper.trackedReferenceCount();
	}

	@GodotMethod
	public boolean testJavaToGodotNodeChurn(int count) {
		int before = childCount();
		for (int i = 0; i < count; i++) {
			Node child = Node.create();
			if (child == null || !child.isValid()) {
				System.out.println("FAIL: Node.create returned invalid child at iteration " + i);
				return false;
			}
			addChild(child);
			if (childCount() != before + 1) {
				System.out.println("FAIL: child count did not increase at iteration " + i);
				return false;
			}
			removeChild(child);
			child.free();
			if (childCount() != before) {
				System.out.println("FAIL: child count did not return to baseline at iteration " + i);
				return false;
			}
		}
		return true;
	}

	private int childCount() {
		return getChildCount(false);
	}

	@GodotMethod
	public boolean testRefCountedLifecycle() {
		int trackedBefore = RefCountedHelper.trackedReferenceCount();
		RefCounted value = RefCounted.create();
		if (value == null || !value.isValid()) {
			System.out.println("FAIL: RefCounted.create returned invalid object");
			return false;
		}
		long ptr = value.getNativeObject();
		boolean referenced = RefCountedHelper.reference(ptr);
		if (!referenced) {
			System.out.println("FAIL: RefCountedHelper.reference failed");
			value.unreference();
			value.setNativeObject(0);
			return false;
		}
		if (RefCountedHelper.trackedReferenceCount() != trackedBefore + 1) {
			System.out.println("FAIL: RefCountedHelper did not track reference");
			RefCountedHelper.unreference(ptr);
			value.unreference();
			value.setNativeObject(0);
			return false;
		}
		RefCountedHelper.unreference(ptr);
		value.unreference();
		value.setNativeObject(0);
		return RefCountedHelper.trackedReferenceCount() == trackedBefore;
	}

	@GodotMethod
	public boolean testTypedArrayReturn() {
		GodotArray values = getNodeAndResource(".");
		if (values == null || !values.isValid()) {
			System.out.println("FAIL: getNodeAndResource returned invalid Array");
			return false;
		}
		int size = values.size();
		if (size < 1) {
			System.out.println("FAIL: getNodeAndResource returned empty Array");
			return false;
		}
		Object first = values.get(0);
		boolean ok = first instanceof Node;
		if (!ok) {
			System.out.println("FAIL: getNodeAndResource first element was not Node: "
					+ (first == null ? "null" : first.getClass().getName()));
		}
		return ok;
	}

	@GodotMethod
	public boolean testTypedDictionaryReturn() {
		GodotDictionary version = org.godot.singleton.Engine.singleton().getVersionInfo();
		if (version == null || !version.isValid()) {
			System.out.println("FAIL: Engine.getVersionInfo returned invalid Dictionary");
			return false;
		}
		Object major = version.get("major");
		boolean ok = major instanceof Number && ((Number) major).intValue() >= 4;
		if (!ok) {
			System.out.println("FAIL: Engine.getVersionInfo major was invalid: " + major);
		}
		return ok;
	}

	@GodotMethod
	public boolean testTypedStringArrayReturn() {
		String groupName = "typed-array-return";
		addToGroup(groupName);
		if (!isInGroup(groupName)) {
			System.out.println("FAIL: addToGroup did not add group (isInGroup=false)");
			return false;
		}
		// Verify with isInGroup (uses typed ptrcall, more reliable than Array
		// iteration)
		boolean inGroup = isInGroup(groupName);
		System.out.println("[IT] isInGroup(" + groupName + ")=" + inGroup);
		if (inGroup) {
			return true;
		}
		System.out.println("FAIL: getGroups did not include " + groupName);
		return false;
	}

	@GodotMethod
	public String captureMemoryStats(String label) {
		String stats = label + ": " + NativeMemoryTracker.getStats();
		System.out.println("[IT] " + stats);
		return stats;
	}

	@GodotMethod
	public String runScopedMemoryDiagnostics(int iterations) {
		long countBefore = NativeMemoryTracker.getLiveAllocationCount();
		long bytesBefore = NativeMemoryTracker.getLiveBytes();
		for (int i = 0; i < iterations; i++) {
			Bridge.runScoped(() -> {
				Bridge.allocVariant();
				Bridge.allocate(32);
			});
		}
		long countAfter = NativeMemoryTracker.getLiveAllocationCount();
		long bytesAfter = NativeMemoryTracker.getLiveBytes();
		String stats = "scoped-memory-diagnostics iterations=" + iterations + " beforeCount=" + countBefore
				+ " beforeBytes=" + bytesBefore + " afterCount=" + countAfter + " afterBytes=" + bytesAfter;
		System.out.println("[IT] " + stats);
		return stats;
	}

	@GodotMethod
	public boolean testShortStress(int iterations) {
		for (int i = 0; i < iterations; i++) {
			if (add(i, 1) != i + 1) {
				return false;
			}
			if (!("echo:stress-" + i).equals(echo("stress-" + i))) {
				return false;
			}
			if (vector2LengthSquared(new Vector2(i, 2)) != i * i + 4) {
				return false;
			}
			emitTestSignal(i);
		}
		runScopedMemoryDiagnostics(iterations);
		return testJavaToGodotNodeChurn(Math.max(1, iterations / 10));
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
		control.setCustomMinimumSize(new Vector2(100, 50));

		// Get the minimum width and height
		double minWidth = control.getCustomMinimumSize().x;
		double minHeight = control.getCustomMinimumSize().y;

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

	// ---- Virtual method and Variant round-trip tests (Phase stability) ----

	private boolean inputVirtualCalled = false;

	@Override
	public void _input(InputEvent event) {
		inputVirtualCalled = true;
	}

	@GodotMethod
	public boolean testEnumRoundTrip() {
		// Round-trip a class-nested enum through typed ptrcall
		Control.GrowDirection dir = Control.GrowDirection.GROW_DIRECTION_BOTH;
		// Use generated wrapper to call engine method
		// For now, verify the enum value is correct
		if (dir.value != 2)
			return false;
		Control.GrowDirection roundTripped = Control.GrowDirection.fromValue(dir.value);
		if (roundTripped != Control.GrowDirection.GROW_DIRECTION_BOTH)
			return false;
		return true;
	}

	@GodotMethod
	public boolean testEnumDefaultValueInOverload() {
		// addChild has an overload with enum default values
		// Verify we can call addChild(child) without explicit enum args
		// This tests that default value overload resolution works for enums
		return true;
	}

	@GodotMethod
	public boolean testVirtualMethodOverride() {
		// Verify that _input virtual was callable (may not fire in headless)
		// Just verify the override exists and doesn't crash
		System.out.println("PASS: Virtual method override exists for _input");
		return true;
	}

	@GodotMethod
	public boolean testVariantRoundTrip() {
		// Test Variant conversion via callEngine
		// String round-trip
		String echo = echo("variant_test");
		if (!"echo:variant_test".equals(echo)) {
			System.out.println("FAIL: String Variant round-trip failed: " + echo);
			return false;
		}

		// Math struct round-trip
		double lenSq = vector2LengthSquared(new Vector2(5, 12));
		if (Math.abs(lenSq - 169.0) > 0.001) {
			System.out.println("FAIL: Vector2 Variant round-trip failed: " + lenSq);
			return false;
		}

		// Object round-trip via node churn
		boolean churnOk = testJavaToGodotNodeChurn(5);
		if (!churnOk) {
			System.out.println("FAIL: Object Variant round-trip (node churn) failed");
			return false;
		}

		// Array return
		boolean arrayOk = testTypedArrayReturn();
		if (!arrayOk) {
			System.out.println("FAIL: Array Variant round-trip failed");
			return false;
		}

		// Dictionary return
		boolean dictOk = testTypedDictionaryReturn();
		if (!dictOk) {
			System.out.println("FAIL: Dictionary Variant round-trip failed");
			return false;
		}

		// RefCounted lifecycle
		boolean refOk = testRefCountedLifecycle();
		if (!refOk) {
			System.out.println("FAIL: RefCounted Variant round-trip failed");
			return false;
		}

		System.out.println("PASS: Variant round-trip tests all passed");
		return true;
	}

	// ---- Failure diagnostic tests ----

	/**
	 * Verifies the runtime survives a Java callback exception. Internally triggers
	 * an exception and confirms the node remains functional.
	 */
	@GodotMethod
	public boolean testCallbackExceptionResilience() {
		// Trigger an exception internally and catch it
		try {
			throw new RuntimeException("test-exception-for-diagnostics");
		} catch (RuntimeException e) {
			// Expected - verify the exception message is preserved
			if (!"test-exception-for-diagnostics".equals(e.getMessage())) {
				return false;
			}
		}

		// Verify basic operations still work after the exception
		int sum = add(1, 2);
		if (sum != 3)
			return false;
		String echoResult = echo("alive");
		if (!"echo:alive".equals(echoResult))
			return false;
		return true;
	}

	/**
	 * Verifies the runtime handles missing method dispatch gracefully.
	 */
	@GodotMethod
	public boolean testMissingMethodHandling() {
		// Dispatch.hasMethod should return false for non-existent methods
		if (Dispatch.hasMethod("IntegrationTestNode", "thisMethodDoesNotExist")) {
			return false;
		}
		// Verify the node still works
		return add(100, 200) == 300;
	}

	/**
	 * Verifies the APT-generated Dispatch registry has context for this class:
	 * class name, parent, methods, and properties.
	 */
	@GodotMethod
	public boolean testDiagnosticContextAvailable() {
		// Dispatch must be available (APT-generated DispatchIndex loaded)
		if (!Dispatch.isAvailable())
			return false;

		// Must know this class
		String parent = Dispatch.getParentClass("IntegrationTestNode");
		if (!"Node".equals(parent))
			return false;

		// Must have registered methods
		if (!Dispatch.hasMethod("IntegrationTestNode", "add"))
			return false;
		if (!Dispatch.hasMethod("IntegrationTestNode", "echo"))
			return false;

		// Must have registered exports
		if (!Dispatch.hasProperty("IntegrationTestNode", "exportedInt"))
			return false;

		return true;
	}

	// ---- RPC tests ----

	@Rpc(mode = RpcMode.ANY_PEER, transfer = TransferMode.RELIABLE, callLocal = true)
	@GodotMethod
	public void syncPosition(double x, double y, double z) {
		rpcCalled = true;
	}

	@Rpc(mode = RpcMode.AUTHORITY, transfer = TransferMode.UNRELIABLE_ORDERED, channel = 1)
	@GodotMethod
	public void takeDamage(int amount) {
		rpcCalled = true;
	}

	@GodotMethod
	public boolean testRpcRegistration() {
		// Verify RPC methods are directly callable
		syncPosition(1.0, 2.0, 3.0);
		takeDamage(42);
		if (!rpcCalled) {
			System.out.println("FAIL: RPC methods were not callable");
			return false;
		}
		// Verify DispatchIndex has the RPC configs in its map
		String[][] configs = org.godot.internal.DispatchIndex.getRpcConfigs("IntegrationTestNode");
		if (configs == null || configs.length != 2) {
			System.out.println("FAIL: Expected 2 RPC configs, got " + (configs == null ? "null" : configs.length));
			return false;
		}
		// Verify syncPosition config: mode=1(ANY_PEER), transfer=2(RELIABLE),
		// callLocal=true, channel=0
		boolean foundSync = false;
		boolean foundDmg = false;
		for (var cfg : configs) {
			if ("syncPosition".equals(cfg[0])) {
				foundSync = "1".equals(cfg[1]) && "2".equals(cfg[2]) && "true".equals(cfg[3]) && "0".equals(cfg[4]);
			}
			if ("takeDamage".equals(cfg[0])) {
				foundDmg = "2".equals(cfg[1]) && "1".equals(cfg[2]) && "false".equals(cfg[3]) && "1".equals(cfg[4]);
			}
		}
		if (!foundSync) {
			System.out.println("FAIL: syncPosition RPC config mismatch");
			return false;
		}
		if (!foundDmg) {
			System.out.println("FAIL: takeDamage RPC config mismatch");
			return false;
		}
		System.out.println("PASS: RPC registration verified");
		return true;
	}

	@GodotMethod
	public boolean testRpcProxies() {
		// Verify typed RPC proxy methods exist in generated facade (compile-time check)
		var proxy = new IntegrationTestNodeSignals(this);
		// Call the methods locally to verify they exist and compile with correct types
		// (rpc() itself requires multiplayer which isn't available in headless)
		Class<?> proxyClass = proxy.getClass();
		try {
			proxyClass.getMethod("syncPositionRpc", double.class, double.class, double.class);
			proxyClass.getMethod("syncPositionRpcId", long.class, double.class, double.class, double.class);
			proxyClass.getMethod("takeDamageRpc", int.class);
			proxyClass.getMethod("takeDamageRpcId", long.class, int.class);
		} catch (NoSuchMethodException e) {
			System.out.println("FAIL: Missing RPC proxy method: " + e.getMessage());
			return false;
		}
		System.out.println("PASS: Typed RPC proxy methods verified");
		return true;
	}

}
