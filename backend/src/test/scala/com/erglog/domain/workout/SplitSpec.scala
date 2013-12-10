package com.erglog.domain.workout

import org.scalatest.{PropSpec, ShouldMatchers}
import org.scalatest.prop.PropertyChecks

class SplitSpec extends PropSpec with PropertyChecks with ShouldMatchers {

  property("Split should be able to be constructed with valid values") {
    forAll { (v1: Double, v2: Double) =>
      whenever (v1 > 0 && v2 >= 0) {
        Split(v1, v1, v2)
      }
    }
  }

  property("Split should not be able to be constructed with invalid values") {
    forAll { (v1: Double, v2: Double) =>
      whenever (v1 <= 0 || v2 < 0) {
        evaluating {
          Split(v1, v1, v2)
        } should produce [IllegalArgumentException]
      }
    }
  }
}
