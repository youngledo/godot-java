extends Node2D

func _ready():
	var calc = ClassDB.instantiate("Calculator")
	if calc:
		add_child(calc)
		print("--- @GodotMethod Tests ---")
		print("add(3, 5) = ", calc.add(3, 5))
		print("multiply(4, 7) = ", calc.multiply(4, 7))
		print("greet('Godot') = ", calc.greet("Godot"))
		print("isEven(42) = ", calc.isEven(42))
		print("isEven(13) = ", calc.isEven(13))
	else:
		print("ERROR: Calculator not found")
