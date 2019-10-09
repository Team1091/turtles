package com.team1091.turtles

class Turtle(
    var x: Float,
    var y: Float,
    var facing: Facing,
    var draw: Boolean = true
) {
    fun moveForward(distance: Float) {
        x += facing.x * distance
        y += facing.y * distance
    }

    fun moveBackward(distance: Float) {
        x -= facing.x * distance
        y -= facing.y * distance
    }

    fun turnRight() {
        val id = (Facing.values().indexOfFirst { it == facing } + 1) % Facing.values().size
        facing = Facing.values()[id]
    }

    fun turnLeft() {
        val id = Facing.values().indexOfFirst { it == facing } - 1
        facing = Facing.values()[if (id == -1) 3 else id]
    }

}