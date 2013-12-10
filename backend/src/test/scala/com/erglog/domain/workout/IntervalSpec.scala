package com.erglog.domain.workout

import org.scalatest._
import org.scalatest.prop.PropertyChecks

class IntervalSpec extends PropSpec with PropertyChecks with ShouldMatchers {

  property("Interval should be able to be constructed with valid values") {
    val distanceResult = DistanceResult(List(Split(1, 1)), true)
    forAll { (restPeriod: Double) =>
      whenever (restPeriod >= 0) {
        Interval(distanceResult, restPeriod)
      }
    }
  }

  property("Interval should not be able to be constructed with a null distanceResult") {
    evaluating {
      Interval(null)
    } should produce [IllegalArgumentException]
  }

  property("Interval should not be able to be constructed with a rest period that is less than zero") {
    val distanceResult = DistanceResult(List(Split(1, 1)), true)
    forAll { (restPeriod: Double) =>
      whenever (restPeriod < 0) {
        evaluating {
          Interval(distanceResult, restPeriod)
        } should produce [IllegalArgumentException]
      }
    }
  }
}
