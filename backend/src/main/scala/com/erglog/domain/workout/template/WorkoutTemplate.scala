package com.erglog.domain.workout.template

/**
 *
 * @param name
 * @param intervalTemplates
 * @param tags
 */
class WorkoutTemplate(val name: String, val intervalTemplates: List[IntervalTemplate], val tags: List[String] = List()) {
  require(name != null && !name.isEmpty, "A workout template must be given a name")
  require(intervalTemplates != null, "Interval templates cannot be null")
  require(!intervalTemplates.isEmpty, "At lease one interval template must be specified")
  require(tags != null, "Tags cannot be null")

  def totalDistance: Double = intervalTemplates.foldLeft(0.0)(_ + _.distance)

  def totalWorkTime: Double = intervalTemplates.foldLeft(0.0)(_ + _.workTime)

  def totalRestTime: Double = intervalTemplates.foldLeft(0.0)(_ + _.restTime)
}
