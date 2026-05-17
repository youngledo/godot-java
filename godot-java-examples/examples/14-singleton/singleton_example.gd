extends Node

func _ready():
    # Access the Java singleton from GDScript
    var gm = GameManager
    print("Game Manager singleton: ", gm)
    print("MAX_HEALTH constant: ", GameManager.MAX_HEALTH)
    gm.addScore(50)
    print("Score after addScore(50): ", gm.score)
    gm.nextLevel()
    print("Level after nextLevel(): ", gm.level)
    gm.resetGame()
    print("After resetGame() - score: ", gm.score, " level: ", gm.level)
