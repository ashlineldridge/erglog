package com.erglog.domain.workout

import org.joda.time.DateTime


/**
 *
 * @param title
 * @param date
 * @param comment
 * @param intervals
 * @param tags
 */
class Workout(val title: String, val date: DateTime, val comment: String, val intervals: List[Interval], val tags: List[String] = List()) {
  require(date != null, "Date cannot be null")
  require(intervals != null, "Intervals cannot be null")
  require(!intervals.isEmpty, "At lease one interval must be specified")
  require(tags != null, "Tags cannot be null")

  /**
   * @return Average 500m split time over the course of the workout.
   */
  def averageSplitTime: Double = intervals.foldLeft(0.0)(_ + _.averageSplitTime) / intervals.length

  /**
   * @return Average heart rate over the course of the workout.
   */
  def averageHeartRate: Double = intervals.foldLeft(0.0)(_ + _.averageHeartRate) / intervals.length

  /**
   * @return Average 500m split time in seconds during the recovery period of the workout.
   */
  def averageRecoverySplitTime: Double = intervals.foldLeft(0.0)(_ + _.averageRecoverySplitTime) / intervals.length

  /**
   * @return Total distance in metres covered during the workout (does not include distance covered during recovery periods).
   */
  def totalDistance: Double = intervals.foldLeft(0.0)(_ + _.distance)

  /**
   * @return Total time spent covering the distance in seconds.
   */
  def totalWorkTime: Double = intervals.foldLeft(0.0)(_ + _.workTime)

  /**
   * @return Total time spent resting between intervals in seconds.
   */
  def totalRestTime: Double = intervals.foldLeft(0.0)(_ + _.restTime)

  /**
   * @return Total distance covered during recovery periods in metres.
   */
  def totalRecoveryDistance: Double = intervals.foldLeft(0.0)(_ + _.recoveryDistance)
}