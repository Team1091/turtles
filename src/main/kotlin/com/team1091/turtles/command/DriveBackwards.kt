package com.team1091.turtles.command

import com.team1091.turtles.Turtle
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

private val distancePerSecond = 10.0

class DriveBackward(val distance: Double) : Command {

    var distanceTraveled = 0.0

    override fun apply(turtle: Turtle, dt: Double): Command? {

        val distTraveledNow = min(dt * distancePerSecond, distance - distanceTraveled)
        distanceTraveled += distTraveledNow

        with(turtle) {
            x -= cos(facing) * distTraveledNow
            y -= sin(facing) * distTraveledNow
        }

        if (distanceTraveled >= distance)
            return null

        return this
    }

}
