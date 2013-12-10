package com.erglog.domain.workout.template

/**
 *
 * @param distance
 * @param workTime
 * @param isDistanceBased
 * @param restTime
 */
class IntervalTemplate(val distance: Double, val workTime: Double, val isDistanceBased: Boolean, val restTime: Double = 0) {
  require(if (isDistanceBased) distance > 0 && workTime == 0 else workTime > 0 && distance == 0,
    if (isDistanceBased) "Distance based intervals must have a distance that is greater than zero and a work time that equals zero"
    else "Time based intervals must have a work time that is greater than zero and a distance that equals zero")
  require(restTime >= 0, "Rest times must be greater than or equal to zero")
}
