package com.erglog.domain.workout

import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class DistanceResultSpec extends PropSpec with PropertyChecks with ShouldMatchers {

  property("DistanceResult should be able to be constructed with valid values") {
    val genSplit = for {
      v <- Gen.choose(1, 1000)
    } yield Split(v, v)
    val genSplitList = Gen.listOf1[Split](genSplit)
    forAll (genSplitList) { (splits: List[Split]) =>
      DistanceResult(splits, true)
    }
  }

  property("DistanceResult should not be able to be constructed with a null list of splits") {
    evaluating {
      DistanceResult(null, true)
    } should produce [IllegalArgumentException]
  }

  property("DistanceResult should not be able to be constructed with an empty list of splits") {
    evaluating {
      DistanceResult(List(), true)
    } should produce [IllegalArgumentException]
  }

  property("DistanceResult should be able to calculate its total distance") {

  }
}
