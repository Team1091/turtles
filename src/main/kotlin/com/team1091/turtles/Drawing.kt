package com.team1091.turtles

import processing.core.PApplet
import kotlin.random.Random

class Drawing : PApplet() {
    var y = 1f
    var x = 1f
    var yVelocity = 10f
    var xVelocity = 5f
    var leftPaddle = Paddle(10f, 265f, 70f, 10f)
    var rightPaddle = Paddle(780f, 265f, 70f, 10f)
    override fun settings() {
        size(800, 600)
    }

    // Setup runs after everything is set up, but before we start looping
    override fun setup() {

    }

    var wPressed = false
    var sPressed = false
    override fun keyPressed() {
        when (key) {
            'w' -> wPressed = true
            's' -> sPressed = true
        }
    }

    override fun keyReleased() {
        when (key) {
            'w' -> wPressed = false
            's' -> sPressed = false
        }
    }

    // The program keeps hitting this each time it wants a new frame.
    // There is a loop calling this method
    override fun draw() {
        background(0f, 50f, 0f)
        rect(x, y, 25f, 25f)
        rect(leftPaddle.x, leftPaddle.y, leftPaddle.width, leftPaddle.height)
        rect(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height)

        leftPaddle.y = min(max(0f,
            leftPaddle.y + if (wPressed) -5 else 0 + if (sPressed) 5 else 0
            ), 600 - leftPaddle.height)



        y = y + yVelocity
        x = x + xVelocity
        if (y <= 0) {
            yVelocity = yVelocity * -1
        }
        if (y > 575) {
            yVelocity = yVelocity * -1
        }
        if (x <= 0) {
            x = 400f
            xVelocity = 5f
            yVelocity = randomNumber() * 5f
        }
        if (x > 775) {
            x = 400f
            xVelocity = -5f
            yVelocity = randomNumber() * 5f
        }
        if(x <= leftPaddle.width && y > leftPaddle.y && y < leftPaddle.y + leftPaddle.height){
            xVelocity = xVelocity * -1
        }
    }
}

class Paddle(
    var x: Float, var y: Float, var height: Float, var width: Float
)

fun randomNumber() = Random.nextFloat() * 2 - 1


