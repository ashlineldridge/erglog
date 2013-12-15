resolvers += "Spray Repo" at "http://repo.spray.io"

lazy val akkaVersion  = "2.2.3"
lazy val sprayVersion = "1.2.0"
lazy val scalaLanguageVersion = "2.10"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.10.3",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.5",
  "io.spray" % "spray-can" % sprayVersion,
  "io.spray" % "spray-routing" % sprayVersion,
  "com.typesafe.akka" % s"akka-actor_$scalaLanguageVersion" % akkaVersion,
  "com.typesafe.akka" % s"akka-testkit_$scalaLanguageVersion" % akkaVersion,
  "org.scalatest" % s"scalatest_$scalaLanguageVersion" % "2.0" % "test",
  "org.scalacheck" % s"scalacheck_$scalaLanguageVersion" % "1.10.1" % "test",
  "io.spray" % "spray-testkit" % sprayVersion % "test"
)