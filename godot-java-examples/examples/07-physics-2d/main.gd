extends Node2D

var player

func _ready():
	player = ClassDB.instantiate("Player")
	if player:
		player.set_name("Player")
		add_child(player)
		print("Player created! Use WASD or Arrow keys to move.")
	else:
		print("ERROR: Player not found")

func _physics_process(delta):
	if not player:
		return
	var direction = Input.get_axis("move_left", "move_right")
	player.setDirection(direction)
	if Input.is_action_just_pressed("jump"):
		player.jump()
