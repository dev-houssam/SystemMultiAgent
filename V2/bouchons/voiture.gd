extends RigidBody3D

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta: float) -> void:
	var vitesse : float = 5
	var virage : float = 0.45
	apply_central_force( basis.x * vitesse)
	apply_torque( Vector3(0, virage, 0) )


func _on_body_entered(body: Node) -> void:
	linear_velocity = Vector3.ZERO
	angular_velocity = Vector3.ZERO
