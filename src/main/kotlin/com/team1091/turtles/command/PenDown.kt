package com.team1091.turtles.command

import com.team1091.turtles.Turtle

class PenDown : Command {

    override fun apply(turtle: Turtle, dt: Double): Command? {
        turtle.penDown = true
        return null
    }

}