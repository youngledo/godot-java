extends Node2D

func _ready():
	var spawner = ClassDB.instantiate("Spawner")
	if spawner:
		add_child(spawner)
		# Spawn some children via Java
		spawner.spawnChild("JavaChild1")
		spawner.spawnChild("JavaChild2")
		# Print the tree again after spawning
		spawner.describeTree()
		print("GDScript: All done!")
	else:
		print("ERROR: Spawner not found")
