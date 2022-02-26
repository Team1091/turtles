package com.team1091.turtles

import processing.core.PApplet
import kotlin.random.Random

class Drawing : PApplet() {
    var y = 487f
    var x = 287f
    var yVelocity = 3f
    var xVelocity = 5f
    var leftPaddle = Paddle(10f, 265f, 70f, 10f)
    var rightPaddle = Paddle(780f, 265f, 70f, 10f)
    var leftScore = 0
    var rightScore = 0
    override fun settings() {
        size(800, 600)
    }

    // Setup runs after everything is set up, but before we start looping
    override fun setup() {

    }

    var wPressed = false
    var sPressed = false
    var oPressed = false
    var lPressed = false
    override fun keyPressed() {
        when (key) {
            'w' -> wPressed = true
            's' -> sPressed = true
            'o' -> oPressed = true
            'l' -> lPressed = true
        }
    }

    override fun keyReleased() {
        when (key) {
            'w' -> wPressed = false
            's' -> sPressed = false
            'o' -> oPressed = false
            'l' -> lPressed = false
        }
    }

    // The program keeps hitting this each time it wants a new frame.
    // There is a loop calling this method
    override fun draw() {
        background(35f, 35f, 35f)
        fill(color(255, 130, 0))
        rect(x, y, 25f, 25f, 14f)
        rect(leftPaddle.x, leftPaddle.y, leftPaddle.width, leftPaddle.height, 5f)
        rect(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height, 5f)
        leftPaddle.y = min(max(0f,
            leftPaddle.y + if (wPressed) -5 else 0 + if (sPressed) 5 else 0
            ), 600 - leftPaddle.height)
        rightPaddle.y = min(max(0f,
            rightPaddle.y + if (oPressed) -5 else 0 + if (lPressed) 5 else 0
        ), 600 - rightPaddle.height)
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
            rightScore ++
        }
        if (x > 775) {
            x = 400f
            xVelocity = -5f
            yVelocity = randomNumber() * 5f
            leftScore ++
        }
        if(x <= leftPaddle.width && y + 14 > leftPaddle.y && y + 14 < leftPaddle.y + leftPaddle.height){
            xVelocity = xVelocity * -1
        }
        if(x >= 800 - rightPaddle.width - 25 && y + 14 > rightPaddle.y && y + 14 < rightPaddle.y + rightPaddle.height){
            xVelocity = xVelocity * -1
        }
        fill(color(255, 255, 255))
        textSize(100f)
        text(leftScore, 100f, 100f)
        text(rightScore, 600f, 100f)
        if(leftScore >= 10){
            textSize(50f)
            text("Player 1 Wins!", 225f, 300f)
            noLoop()
        }
        if(rightScore >= 10){
            textSize(50f)
            text("Player 2 Wins!", 225f, 300f)
            noLoop()
        }
    }
}

class Paddle(
    var x: Float, var y: Float, var height: Float, var width: Float
)

fun randomNumber() = Random.nextFloat() * 2 - 1


