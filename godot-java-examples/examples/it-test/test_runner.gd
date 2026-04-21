extends Node

## Integration test runner. Validates all core godot-java features.
## In headless mode, _process may not fire, so we test everything in _ready.

var tests_passed := 0
var tests_failed := 0
var test_node: Object

func _ready():
	print("TEST_RUNNER: starting tests...")

	# Create the Java test node
	test_node = ClassDB.instantiate("IntegrationTestNode")
	if test_node == null:
		print("TEST_FATAL: could not instantiate IntegrationTestNode")
		print("TEST_FAILED")
		get_tree().quit(1)
		return

	add_child(test_node)
	print("TEST_RUNNER: IntegrationTestNode created and added to scene")

	# Run all tests immediately (_ready already fired on the Java node)
	test_virtual_ready()
	test_method_call()
	test_method_string()
	test_export_properties()
	test_signal()
	test_process_virtual()
	test_control_minimum_size()
	test_notification()

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
	assert_true(test_node.wasReadyCalled(), "_ready() virtual was called")

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

func test_notification():
	# NOTIFICATION_READY = 13 should have been delivered when the node entered the tree
	var notif_count: int = test_node.getNotificationCount()
	assert_true(notif_count > 0, "onNotification was called (count=%d)" % notif_count)

	var last_notif: int = test_node.getLastNotification()
	# At minimum, NOTIFICATION_READY (13) or NOTIFICATION_ENTER_TREE (10) should have fired
	assert_true(last_notif > 0, "onNotification received a valid notification (last=%d)" % last_notif)
