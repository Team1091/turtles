package com.team1091.turtles

import com.team1091.turtles.command.Command



class Turtle(
    var x: Double, // fields in here need to be set when you create an instance,
    var y: Double,
    facingDegrees: Double, // Notice how this does not have var before it?  That means its not saved, just used.  Take a look at facing below
    var penDown: Boolean = true,  // This is a default.  If you dont set it, it will be true
    val commands: MutableList<Command> = mutableListOf()
) {
    var facing: Double = Math.toRadians(facingDegrees)
}