package com.erglog.domain.workout

import org.scalatest._
import org.scalatest.prop.PropertyChecks

class IntervalSpec extends PropSpec with PropertyChecks with ShouldMatchers {

  property("Interval should not be able to be constructed with a null list of splits") {
    evaluating {
      Interval(null, true)
    } should produce [IllegalArgumentException]
  }

  property("Interval should not be able to be constructed with an empty list of splits") {
    evaluating {
      Interval(List(), true)
    } should produce [IllegalArgumentException]
  }

  property("Interval should not be able to be constructed with a rest time that is less than zero") {
    val splits = List(Split(1, 1))
    forAll { (restPeriod: Double) =>
      whenever (restPeriod < 0) {
        evaluating {
          Interval(splits, true, restPeriod)
        } should produce [IllegalArgumentException]
      }
    }
  }

  property("Interval should not be able to be constructed with a recovery distance that is less than zero") {
    val splits = List(Split(1, 1))
    forAll { (recoveryDistance: Double) =>
      whenever (recoveryDistance < 0) {
        evaluating {
          Interval(splits, true, 1, recoveryDistance)
        } should produce [IllegalArgumentException]
      }
    }
  }

  property("An interval's recovery distance must equal zero if the rest period is zero") {
    val splits = List(Split(1, 1))
    forAll { (recoveryDistance: Double) =>
      whenever (recoveryDistance > 0) {
        evaluating {
          Interval(splits, true, 0, recoveryDistance)
        } should produce [IllegalArgumentException]
      }
    }
  }

  property("Interval should be able to be constructed with valid values") {
    val splits = List(Split(1, 1))
    forAll { (param: Double) =>
      whenever (param >= 0) {
        Interval(splits, true, param, param)
      }
    }
  }

  property("Interval should be able to calculate its distance") {
    val splits = List(Split(500, 120), Split(500, 125), Split(500, 119), Split(500, 110))
    val interval = Interval(splits, true);
    interval.distance should equal (2000)
  }

  property("Interval should be able to calculate its average split time") {
    val splits = List(Split(500, 120), Split(500, 122), Split(500, 120), Split(500, 122))
    val interval = Interval(splits, true);
    interval.averageSplitTime should equal (121)
  }

  property("Interval should be able to calculate its average heart rate") {
    val splits = List(Split(500, 120, 80), Split(500, 122, 100), Split(500, 120, 120), Split(500, 122, 120))
    val interval = Interval(splits, true);
    interval.averageHeartRate should equal (105)
  }

  property("Interval should be able to calculate its average recovery split time") {
    val interval = Interval(List(Split(1, 1)), true, 180, 600);
    interval.averageRecoverySplitTime should equal (150)
  }

}
