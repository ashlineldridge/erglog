import com.erglog.domain.workout.Split
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen

val genSplit = for {
  v <- Gen.choose(1, 1000)
} yield Split(v, v)
genSplit.sample
val genSplitList = Gen.containerOf[List, Split](genSplit)
genSplitList.sample










