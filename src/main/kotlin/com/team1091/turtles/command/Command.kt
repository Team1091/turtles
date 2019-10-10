package com.team1091.turtles.command

import com.team1091.turtles.Turtle

interface Command {
    fun apply(turtle: Turtle, dt: Double): Command?
}