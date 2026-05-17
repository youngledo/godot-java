extends Node

func _ready():
    print("=== Game Config Constants ===")
    print("MAX_PLAYERS: ", GameConfig.MAX_PLAYERS)
    print("DEFAULT_PORT: ", GameConfig.DEFAULT_PORT)
    print("TICK_RATE: ", GameConfig.TICK_RATE)
    print("MAX_STACK_SIZE: ", GameConfig.MAX_STACK_SIZE)
    print("Config summary: ", GameConfig.new().getConfigSummary())
