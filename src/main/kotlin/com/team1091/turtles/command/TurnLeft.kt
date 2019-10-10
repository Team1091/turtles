package com.team1091.turtles.command

import com.team1091.turtles.Turtle
import kotlin.math.min


private val turnPerSec = 30.0

class TurnLeft(val turn: Double) : Command {

    var distanceTurned = 0.0

    override fun apply(turtle: Turtle, dt: Double): Command? {
        val distanceTurnedNow = min(dt * turnPerSec, turn - distanceTurned)
        distanceTurned += distanceTurnedNow

        with(turtle) {
            facing -= Math.toRadians(distanceTurnedNow)
        }

        if (distanceTurned >= turn)
            return null

        return this;
    }

}
