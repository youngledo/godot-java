extends Node2D

func _ready():
	var sprite = ClassDB.instantiate("RotatingSprite")
	if sprite:
		add_child(sprite)
		print("RotatingSprite added! Watch it orbit in the viewport.")
		print("Adjust rotationSpeed in the Inspector to change speed.")
	else:
		print("ERROR: RotatingSprite not found")
