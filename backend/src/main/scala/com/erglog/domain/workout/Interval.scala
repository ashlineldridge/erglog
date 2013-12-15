package com.erglog.domain.workout

case class Interval(val splits: List[Split], val isDistanceBased: Boolean, val restTime: Double = 0, val recoveryDistance: Double = 0) {
  require(splits != null, "Splits cannot be null")
  require(splits.length > 0, "At least one split must be specified")
  require(restTime >= 0, "Rest times must be greater than or equal to zero")
  require(recoveryDistance >= 0, "Recovery distance must be greater than or equal to zero")
  require(if (restTime == 0) recoveryDistance == 0 else true, "Recovery distance may only be specified if the rest time is greater than zero")

  /**
   * @return Distance covered in metres.
   */
  def distance: Double = splits.foldLeft(0.0)(_ + _.distance)

  /**
   * @return Time spent covering the distance in seconds.
   */
  def workTime: Double = splits.foldLeft(0.0)(_ + _.workTime)

  /**
   * @return Average 500m split time in seconds (yes, this could be optimized).
   */
  def averageSplitTime: Double = workTime / (distance / 500)

  /**
   * @return Average heart rate for the interval in beats-per-minute.
   */
  def averageHeartRate: Double =  splits.foldLeft(0.0)(_ + _.averageHeartRate) / splits.length

  /**
   * @return Average 500m split time in seconds during the recovery period.
   */
  def averageRecoverySplitTime: Double = if (recoveryDistance > 0) restTime / (recoveryDistance / 500) else 0
}
