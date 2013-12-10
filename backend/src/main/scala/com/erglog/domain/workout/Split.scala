package com.erglog.domain.workout

/**
 *
 * @param distance Distance covered in metres.
 * @param workTime Time spent covering the distance in seconds.
 * @param averageHeartRate Average heart rate for the split in beats-per-minute.
 */
case class Split(val distance: Double, val workTime: Double, val averageHeartRate: Double = 0) {
  require(distance > 0, "Distance must be greater than zero")
  require(workTime > 0, "Work time must be greater than zero")
  require(averageHeartRate >= 0.0, "Average heart rate must be greater than or equal to zero")
}
