extends Node2D

func _ready():
	var bus = ClassDB.instantiate("EventBus")
	if bus:
		add_child(bus)
		# Connect signals
		bus.connect("scoreChanged", _on_score_changed)
		bus.connect("levelCompleted", _on_level_completed)
		# Trigger events
		print("--- Signal Tests ---")
		bus.addScore(10)
		bus.addScore(25)
		bus.completeLevel("Level 1")
		print("Final score: ", bus.getScore())
	else:
		print("ERROR: EventBus not found")

func _on_score_changed(new_score):
	print("[GDScript] scoreChanged signal received: ", new_score)

func _on_level_completed(level_name, score):
	print("[GDScript] levelCompleted signal received: ", level_name, " score=", score)
