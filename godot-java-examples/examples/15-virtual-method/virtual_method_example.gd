extends Node

func _ready():
    var enemy = BaseEnemy.new()
    print("Base enemy damage (type 0): ", enemy.calculateDamage(0))
    print("Base enemy name: ", enemy.getDisplayName())
    enemy.queue_free()
