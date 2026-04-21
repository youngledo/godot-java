extends Node2D

func _ready():
	var sprite = $ConfigurableSprite
	if sprite:
		print("--- @Export Properties ---")
		print("playerName = ", sprite.playerName)
		print("speed = ", sprite.speed)
		print("health = ", sprite.health)
		print("score = ", sprite.score)
		print("difficulty = ", sprite.difficulty)
		print("description = ", sprite.description)
		print("easing = ", sprite.easing)
		print("secretToken = ", sprite.secretToken)
		print("username = ", sprite.username)
		print("Try changing these in the Godot Inspector!")
	else:
		print("ERROR: ConfigurableSprite not found")
