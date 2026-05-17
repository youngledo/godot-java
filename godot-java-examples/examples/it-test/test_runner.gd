extends Node

## Integration test runner. Validates all core godot-java features.
## In headless mode, _process may not fire, so we test everything in _ready.

var tests_passed := 0
var tests_failed := 0
var test_node: Object
var stress_iterations := 50

func _ready():
	call_deferred("run_tests")

func run_tests():
	print("TEST_RUNNER: starting tests...")
	if OS.get_environment("GODOT_JAVA_STABILITY_LONG") == "true":
		stress_iterations = 1000
	print("TEST_RUNNER: stability stress iterations=%d" % stress_iterations)

	# Create the Java test node
	test_node = ClassDB.instantiate("IntegrationTestNode")
	if test_node == null:
		print("TEST_FATAL: could not instantiate IntegrationTestNode")
		print("TEST_FAILED")
		get_tree().quit(1)
		return

	add_child(test_node)
	print("TEST_RUNNER: IntegrationTestNode created and added to scene")
	print("TEST_DIAGNOSTIC: %s" % test_node.captureMemoryStats("startup"))

	# Run all tests immediately (_ready already fired on the Java node)
	test_virtual_ready()
	test_method_call()
	test_method_string()
	test_export_properties()
	test_signal()
	test_process_virtual()
	test_control_minimum_size()
	test_enum_round_trip()
	test_enum_default_value_overload()
	test_virtual_method_override()
	test_variant_round_trip()
	test_notification()
	test_lifecycle_order()
	test_dispatch_matrix()
	test_java_to_godot_calls()
	test_ref_counted_lifecycle()
	test_typed_collection_returns()
	test_generated_registry()
	test_scoped_memory_diagnostics()
	test_callback_exception()
	test_missing_method_call()
	test_diagnostic_context()
	test_short_stress()
	test_rpc_registration()
	test_rpc_proxies()
	await test_java_object_mapping_cleanup()
	print("TEST_DIAGNOSTIC: %s" % test_node.captureMemoryStats("teardown"))

	# Summary
	var total := tests_passed + tests_failed
	print("TEST_RESULT: %d/%d passed" % [tests_passed, total])
	if tests_failed > 0:
		print("TEST_FAILED")
		get_tree().quit(1)
	else:
		print("TEST_PASSED")
		get_tree().quit(0)

# ---- Test helpers ----

func assert_true(condition: bool, test_name: String):
	if condition:
		print("PASS: %s" % test_name)
		tests_passed += 1
	else:
		print("FAIL: %s" % test_name)
		tests_failed += 1

func assert_eq(actual, expected, test_name: String):
	if actual == expected:
		print("PASS: %s" % test_name)
		tests_passed += 1
	else:
		print("FAIL: %s (expected=%s actual=%s)" % [test_name, str(expected), str(actual)])
		tests_failed += 1

# ---- Test cases ----

func test_virtual_ready():
	var events: String = test_node.getLifecycleEvents()
	assert_true(test_node.wasReadyCalled() or events.contains("notification_ready"), "ready lifecycle was observed (%s)" % events)

func test_process_virtual():
	# _process may or may not have fired; just report the status
	var was_called: bool = test_node.wasProcessCalled()
	if was_called:
		assert_true(true, "_process() virtual was called (headless)")
		var delta: float = test_node.getLastDelta()
		assert_true(delta > 0.0, "_process() delta > 0 (got %s)" % str(delta))
	else:
		print("SKIP: _process() not called in headless mode")

func test_method_call():
	var result: int = test_node.add(3, 4)
	assert_eq(result, 7, "@GodotMethod add(3,4) == 7")

	var result2: int = test_node.add(-1, 1)
	assert_eq(result2, 0, "@GodotMethod add(-1,1) == 0")

func test_method_string():
	var result: String = test_node.echo("test")
	assert_eq(result, "echo:test", "@GodotMethod echo returns 'echo:test'")

func test_export_properties():
	# Read default values exported from Java
	var default_int: int = test_node.getExportedInt()
	assert_eq(default_int, 42, "@Export default exportedInt == 42")

	# Modify from GDScript
	test_node.setExportedInt(99)
	var modified: int = test_node.getExportedInt()
	assert_eq(modified, 99, "@Export setExportedInt(99) round-trip")

func test_signal():
	# Use Dictionary to pass result from lambda (GDScript closures capture by value for primitives)
	var result := {"received": false, "value": 0}

	test_node.testSignal.connect(func(val):
		result["received"] = true
		result["value"] = val
	)

	# Emit from Java side
	test_node.emitTestSignal(123)

	# Signal should have been received synchronously
	assert_true(result["received"], "@Signal testSignal was received by GDScript")
	assert_eq(result["value"], 123, "@Signal testSignal value == 123")

func test_control_minimum_size():
	var result: bool = test_node.test_control_minimum_size()
	assert_true(result, "Control minimum size methods working")

func test_enum_round_trip():
	var result: bool = test_node.testEnumRoundTrip()
	assert_true(result, "Enum arg/return round-trip via typed ptrcall")

func test_enum_default_value_overload():
	var result: bool = test_node.testEnumDefaultValueInOverload()
	assert_true(result, "Enum default-value overload (addChild) works")

func test_virtual_method_override():
	var result: bool = test_node.testVirtualMethodOverride()
	assert_true(result, "Virtual method override exists and is callable")

func test_variant_round_trip():
	var result: bool = test_node.testVariantRoundTrip()
	assert_true(result, "Variant round-trip covers String, Vector2, Object, Array, Dictionary, RefCounted")

func test_notification():
	# NOTIFICATION_READY = 13 should have been delivered when the node entered the tree
	var notif_count: int = test_node.getNotificationCount()
	assert_true(notif_count > 0, "onNotification was called (count=%d)" % notif_count)

	var last_notif: int = test_node.getLastNotification()
	# At minimum, NOTIFICATION_READY (13) or NOTIFICATION_ENTER_TREE (10) should have fired
	assert_true(last_notif > 0, "onNotification received a valid notification (last=%d)" % last_notif)

func test_lifecycle_order():
	var events: String = test_node.getLifecycleEvents()
	var ready_index := events.find("ready")
	if ready_index < 0:
		ready_index = events.find("notification_ready")
	assert_true(ready_index >= 0, "ready lifecycle event was recorded (%s)" % events)
	if events.contains("enter_tree") and ready_index >= 0:
		assert_true(events.find("enter_tree") <= ready_index, "enter_tree occurs before ready (%s)" % events)
	else:
		assert_true(test_node.getNotificationCount() > 0, "notification lifecycle was observed (%s)" % events)

func test_dispatch_matrix():
	var primitive_result: String = test_node.primitiveDispatchMatrix(7, 8, 1.5, 2.5, true, "ok")
	assert_eq(primitive_result, "7:8:15:25:true:ok", "primitive dispatch matrix round-trip")

	var length_squared: float = test_node.vector2LengthSquared(Vector2(3, 4))
	assert_eq(length_squared, 25.0, "Vector2 dispatch round-trip")

func test_java_to_godot_calls():
	var result: bool = test_node.testJavaToGodotNodeChurn(10)
	assert_true(result, "Java-to-Godot generated Node wrapper calls survive churn")

func test_ref_counted_lifecycle():
	var before: int = test_node.getTrackedRefCountedCount()
	var result: bool = test_node.testRefCountedLifecycle()
	var after: int = test_node.getTrackedRefCountedCount()
	assert_true(result, "RefCounted helper reference/unreference lifecycle")
	assert_eq(after, before, "RefCounted tracked count returns to baseline")

func test_typed_collection_returns():
	assert_true(test_node.testTypedArrayReturn(), "typed Array return stays valid after ptrcall")
	assert_true(test_node.testTypedDictionaryReturn(), "typed Dictionary return stays valid after ptrcall")
	assert_true(test_node.testTypedStringArrayReturn(), "typed StringName array return copies to Java array")

func test_generated_registry():
	assert_true(test_node.generatedRegistryAvailable(), "generated class registry is present")

func test_scoped_memory_diagnostics():
	var stats: String = test_node.runScopedMemoryDiagnostics(25)
	print("TEST_DIAGNOSTIC: %s" % stats)
	assert_true(stats.contains("scoped-memory-diagnostics"), "scoped native memory diagnostics recorded")

func test_short_stress():
	assert_true(test_node.testShortStress(stress_iterations), "stability stress run completed")

func test_java_object_mapping_cleanup():
	var child = ClassDB.instantiate("IntegrationTestNode")
	if child == null:
		assert_true(false, "Java object mapping cleanup child can be instantiated")
		return

	add_child(child)
	await get_tree().process_frame
	var before: int = test_node.getJavaObjectMapSize()
	child.queue_free()
	await get_tree().process_frame
	await get_tree().process_frame
	var after: int = test_node.getJavaObjectMapSize()
	assert_true(after < before, "JavaObjectMap shrinks after Java-backed node queue_free (before=%d after=%d)" % [before, after])

func test_callback_exception():
	# Verify Java-side exception handling and resilience
	var result: bool = test_node.testCallbackExceptionResilience()
	assert_true(result, "Java callback exception is caught and node remains functional")

func test_missing_method_call():
	# Verify missing method dispatch is handled gracefully
	var result: bool = test_node.testMissingMethodHandling()
	assert_true(result, "missing method dispatch returns gracefully without crash")

func test_diagnostic_context():
	var result: bool = test_node.testDiagnosticContextAvailable()
	assert_true(result, "Dispatch registry has class/method/property context for IntegrationTestNode")

func test_rpc_registration():
	var result: bool = test_node.testRpcRegistration()
	assert_true(result, "@Rpc methods are registered via rpc_config")

func test_rpc_proxies():
	var result: bool = test_node.testRpcProxies()
	assert_true(result, "Typed RPC proxy methods are callable")
