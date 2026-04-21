extends Node2D

func _ready():
	var hello = ClassDB.instantiate("HelloNode")
	if hello:
		add_child(hello)
		print("HelloNode added to scene!")
	else:
		print("ERROR: HelloNode not found - check GODOT_JAVA_CLASSPATH")
