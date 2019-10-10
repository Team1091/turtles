package com.team1091.turtles

import com.team1091.turtles.command.*
import processing.core.PApplet
import processing.core.PConstants
import processing.core.PGraphics
import processing.core.PImage

class TurtleSim : PApplet() {

    // These are variables in our instance of TurtleSim
    lateinit var turtleImage: PImage                   // This is the picture of a turtle that we draw
    lateinit var background: PGraphics                 // this is our drawing
    var turtleList: MutableList<Turtle> = mutableListOf() // this is a list of each turtle that we are using to draw

    override fun settings() {
        size(800, 600)
    }

    // Setup runs after everything is set up, but before we start looping
    override fun setup() {
        turtleImage = loadImage("turtle.png")
        background = createGraphics(width, height)
        background.beginDraw()
        background.background(230)
        background.endDraw()

        // START HERE

        // Lets set a turtle up with a a plan to draw a square
        turtleList.add(
            Turtle(
                x = 400.0,
                y = 300.0,
                facingDegrees = 0.0,
                commands = mutableListOf( // Draw a square
                    DriveForward(100.0),
                    TurnLeft(90.0),
                    DriveForward(100.0),
                    TurnLeft(90.0),
                    DriveForward(100.0),
                    TurnLeft(90.0),
                    DriveForward(100.0),
                    TurnLeft(90.0)
                )
            )
        )

        // Lets make a new turtle that generates a dotted line
        val commandList = mutableListOf<Command>()
        for (i in 0..20) {
            commandList.add(PenUp())
            commandList.add(DriveForward(10.0))
            commandList.add(PenDown())
            commandList.add(DriveForward(10.0))
        }

        turtleList.add(
            Turtle(
                x = 200.0,
                y = 100.0,
                facingDegrees = 90.0,
                commands = commandList
            )
        )
        // END HERE
    }

    // The program keeps hitting this each time it wants a new frame.
    // There is a loop calling this method
    override fun draw() {

        // Draw the background
        imageMode(PConstants.CORNER)
        image(background, 0f, 0f)

        // Loop over the turtles, rendering them all
        for (turtle in turtleList) {
            val oldX = turtle.x
            val oldY = turtle.y

            // This code executes the current turtle's commands
            val commandToExecute = turtle.commands.firstOrNull()
            if (commandToExecute != null) {
                val result = commandToExecute.apply(turtle, 0.1)

                if (result == null)
                    turtle.commands.removeAt(0)
            }

            // if the pen is down, we can draw
            if (turtle.penDown) {
                background.beginDraw()
                background.stroke(10)
                background.line(oldX.toFloat(), oldY.toFloat(), turtle.x.toFloat(), turtle.y.toFloat())
                background.endDraw()
            }

            // This renders the turtles
            imageMode(CENTER)
            pushMatrix()
            translate(turtle.x.toFloat(), turtle.y.toFloat())
            rotate((turtle.facing + Math.PI.toFloat() / 2.0).toFloat())
            image(turtleImage, 0f, 0f)
            popMatrix()
        }
    }
}

