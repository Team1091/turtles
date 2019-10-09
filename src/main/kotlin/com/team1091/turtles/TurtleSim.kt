package com.team1091.turtles

import processing.core.PApplet
import processing.core.PConstants
import processing.core.PGraphics
import processing.core.PImage

class TurtleSim : PApplet() {

    lateinit var turtleImage: PImage
    lateinit var background: PGraphics
    val turtle = Turtle(20f, 20f, Facing.EAST)

    override fun setup() {
        turtleImage = loadImage("turtle.png")

        background = createGraphics(width, height)
        background.beginDraw()
        background.background(230)
        background.endDraw()
    }

    override fun settings() {
        size(800, 600)
    }

    override fun draw() {
        imageMode(PConstants.CORNER)
        image(background, 0f, 0f)

        val oldX = turtle.x
        val oldY = turtle.y

        if (keyPressed && key == 'a') {
            turtle.turnLeft()

        } else if (keyPressed && key == 'd') {
            turtle.turnRight()

        } else if (keyPressed && key == 'w') {
            turtle.moveForward(10f)

        } else if (keyPressed && key == 's') {
            turtle.moveBackward(10f)
        }

        if(turtle.draw){
            background.beginDraw()
            background.stroke(10)
            background.line(oldX, oldY, turtle.x, turtle.y)
            background.endDraw()
        }

        //turtle.render(turtleImage)
        imageMode(CENTER)
        pushMatrix()
        translate(turtle.x, turtle.y)
        rotate(turtle.facing.angle)

        image(turtleImage, 0f, 0f)
        popMatrix()
    }
}

