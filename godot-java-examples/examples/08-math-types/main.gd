extends Node2D

func _ready():
	var demo = ClassDB.instantiate("MathDemo")
	if demo:
		add_child(demo)
		print("MathDemo complete! Check console output for math operations.")
	else:
		print("ERROR: MathDemo not found")
