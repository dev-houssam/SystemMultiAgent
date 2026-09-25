extends Node3D

const SCN_VITURE : PackedScene = preload("res://voiture.tscn")

var espace : bool = false

func ajout_voiture() -> void:
	var voiture : RigidBody3D = null
	voiture = SCN_VITURE.instantiate()
	voiture.position = Vector3(0, 0, 7)
	add_child(voiture)


# Création de voiture : plusieurs d'un coup : mais inutile
func __ready() -> void:
	var nb : int = 0
	for i in range(nb):
		var voiture : RigidBody3D = null
		voiture = SCN_VITURE.instantiate()
		voiture.position = Vector3(10, 0, i * 2)
		add_child(voiture)


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta: float) -> void:
	if Input.is_key_pressed(KEY_SPACE):
		if espace == false:
			ajout_voiture()
			espace = true
	else: 
		espace = false
