package com.team1091.turtles

enum class Facing(val x: Int, val y: Int, val angle: Float) {
    NORTH(0, -1, 0f),
    EAST(1, 0, Math.PI.toFloat() / 2f),
    SOUTH(0, 1, Math.PI.toFloat()),
    WEST(-1, 0, 3f * Math.PI.toFloat() / 2f)
}