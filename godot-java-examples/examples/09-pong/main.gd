extends Node2D

var game
var ball: ColorRect
var player_paddle: ColorRect
var ai_paddle: ColorRect
var player_label: Label
var ai_label: Label
var message_label: Label

const WIDTH = 800.0
const HEIGHT = 500.0
const PADDLE_W = 15.0
const PADDLE_H = 100.0
const BALL_SIZE = 12.0
const PADDLE_OFFSET = 30.0

func _ready():
	# Create game instance
	game = ClassDB.instantiate("PongGame")
	if not game:
		print("ERROR: PongGame not found")
		return
	add_child(game)
	game.connect("onScore", _on_score)

	# Offset to center the play area in viewport
	var offset_x = (1152 - WIDTH) / 2
	var offset_y = (648 - HEIGHT) / 2
	var container = Node2D.new()
	container.position = Vector2(offset_x, offset_y)
	add_child(container)

	# Play area background
	var bg = ColorRect.new()
	bg.color = Color(0.05, 0.05, 0.1)
	bg.size = Vector2(WIDTH, HEIGHT)
	container.add_child(bg)

	# Center dashed line
	for i in range(0, int(HEIGHT), 20):
		var dash = ColorRect.new()
		dash.color = Color(0.3, 0.3, 0.3)
		dash.size = Vector2(2, 10)
		dash.position = Vector2(WIDTH / 2 - 1, i)
		container.add_child(dash)

	# Ball
	ball = ColorRect.new()
	ball.color = Color.WHITE
	ball.size = Vector2(BALL_SIZE, BALL_SIZE)
	container.add_child(ball)

	# Player paddle (left)
	player_paddle = ColorRect.new()
	player_paddle.color = Color(0.3, 0.7, 1.0)
	player_paddle.size = Vector2(PADDLE_W, PADDLE_H)
	container.add_child(player_paddle)

	# AI paddle (right)
	ai_paddle = ColorRect.new()
	ai_paddle.color = Color(1.0, 0.4, 0.4)
	ai_paddle.size = Vector2(PADDLE_W, PADDLE_H)
	container.add_child(ai_paddle)

	# Score labels
	player_label = Label.new()
	player_label.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	player_label.add_theme_font_size_override("font_size", 48)
	player_label.position = Vector2(WIDTH / 4 - 30, 20)
	player_label.size = Vector2(60, 60)
	container.add_child(player_label)

	ai_label = Label.new()
	ai_label.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	ai_label.add_theme_font_size_override("font_size", 48)
	ai_label.position = Vector2(3 * WIDTH / 4 - 30, 20)
	ai_label.size = Vector2(60, 60)
	container.add_child(ai_label)

	# Message label
	message_label = Label.new()
	message_label.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	message_label.add_theme_font_size_override("font_size", 24)
	message_label.position = Vector2(WIDTH / 2 - 150, HEIGHT / 2 - 20)
	message_label.size = Vector2(300, 40)
	message_label.visible = false
	container.add_child(message_label)

	_update_scores()

func _process(_delta):
	if not game:
		return

	# Input
	var dir = Input.get_axis("move_up", "move_down")
	game.setPlayerDirection(dir)

	# Restart
	if not game.isRunning() and Input.is_action_just_pressed("ui_accept"):
		game.resetGame()
		message_label.visible = false
		_update_scores()

	# Update visual positions
	ball.position = Vector2(game.getBallX() - BALL_SIZE / 2, game.getBallY() - BALL_SIZE / 2)
	player_paddle.position = Vector2(PADDLE_OFFSET, game.getPlayerY() - PADDLE_H / 2)
	ai_paddle.position = Vector2(WIDTH - PADDLE_OFFSET - PADDLE_W, game.getAiY() - PADDLE_H / 2)

func _on_score(player, ai):
	_update_scores()

	if not game.isRunning():
		if player >= 5:
			message_label.text = "You Win! Press Space"
		else:
			message_label.text = "AI Wins! Press Space"
		message_label.visible = true

func _update_scores():
	player_label.text = str(game.getPlayerScore())
	ai_label.text = str(game.getAiScore())
