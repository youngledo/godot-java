extends Node2D

var game

const CELL_SIZE = 18
const GRID_W = 30
const GRID_H = 30

func _process(_delta):
	queue_redraw()

func _draw():
	if not game:
		return

	# Draw grid lines
	var grid_color = Color(0.15, 0.15, 0.2)
	for x in range(GRID_W + 1):
		draw_line(Vector2(x * CELL_SIZE, 0), Vector2(x * CELL_SIZE, GRID_H * CELL_SIZE), grid_color)
	for y in range(GRID_H + 1):
		draw_line(Vector2(0, y * CELL_SIZE), Vector2(GRID_W * CELL_SIZE, y * CELL_SIZE), grid_color)

	# Draw food
	var food_color = Color(1.0, 0.3, 0.3)
	var fx = game.getFoodX()
	var fy = game.getFoodY()
	draw_rect(Rect2(fx * CELL_SIZE + 1, fy * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2), food_color)

	# Draw snake
	var count = game.getSegmentCount()
	for i in range(count):
		var sx = game.getSegmentX(i)
		var sy = game.getSegmentY(i)
		if i == 0:
			# Head: bright green
			draw_rect(Rect2(sx * CELL_SIZE, sy * CELL_SIZE, CELL_SIZE, CELL_SIZE), Color(0.2, 1.0, 0.3))
		else:
			# Body: darker green, fading with distance
			var t = float(i) / float(count)
			var g = 0.8 - t * 0.4
			draw_rect(Rect2(sx * CELL_SIZE + 1, sy * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2), Color(0.1, g, 0.2))
