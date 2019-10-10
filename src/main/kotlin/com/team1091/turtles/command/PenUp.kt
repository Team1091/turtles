package com.team1091.turtles.command

import com.team1091.turtles.Turtle

class PenUp : Command {

    override fun apply(turtle: Turtle, dt: Double): Command? {
        turtle.penDown = false
        return null
    }

}