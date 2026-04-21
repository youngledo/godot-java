extends Node2D

var game
var score_label: Label
var message_label: Label

const CELL_SIZE = 18
const GRID_W = 30
const GRID_H = 30

func _ready():
	game = ClassDB.instantiate("SnakeGame")
	if not game:
		print("ERROR: SnakeGame not found")
		return
	add_child(game)
	game.connect("onScoreChanged", _on_score_changed)
	game.connect("onGameOver", _on_game_over)

	# Offset to center the grid in viewport
	var offset_x = (1152 - GRID_W * CELL_SIZE) / 2
	var offset_y = (648 - GRID_H * CELL_SIZE) / 2
	var container = Node2D.new()
	container.position = Vector2(offset_x, offset_y)
	add_child(container)

	# Grid background
	var bg = ColorRect.new()
	bg.color = Color(0.08, 0.08, 0.12)
	bg.size = Vector2(GRID_W * CELL_SIZE, GRID_H * CELL_SIZE)
	container.add_child(bg)

	# Drawing node (uses _draw)
	var drawer = Node2D.new()
	drawer.set_script(preload("res://drawer.gd"))
	container.add_child(drawer)
	drawer.game = game

	# Score label
	score_label = Label.new()
	score_label.add_theme_font_size_override("font_size", 24)
	score_label.position = Vector2(10, 10)
	add_child(score_label)
	_update_score()

	# Message label
	message_label = Label.new()
	message_label.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	message_label.add_theme_font_size_override("font_size", 28)
	message_label.position = Vector2(1152 / 2 - 200, 648 / 2 - 20)
	message_label.size = Vector2(400, 40)
	message_label.visible = false
	add_child(message_label)

func _process(_delta):
	if not game:
		return

	# Input
	if Input.is_action_just_pressed("move_up"):
		game.setDirection(0)
	elif Input.is_action_just_pressed("move_right"):
		game.setDirection(1)
	elif Input.is_action_just_pressed("move_down"):
		game.setDirection(2)
	elif Input.is_action_just_pressed("move_left"):
		game.setDirection(3)

	# Restart
	if game.isGameOver() and Input.is_action_just_pressed("ui_accept"):
		game.restart()
		message_label.visible = false
		_update_score()

func _on_score_changed(new_score):
	_update_score()

func _on_game_over(final_score):
	message_label.text = "Game Over! Score: " + str(final_score) + "  [Space to restart]"
	message_label.visible = true

func _update_score():
	score_label.text = "Score: " + str(game.getScore())
