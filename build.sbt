name := "ergolog"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.3"

lazy val root = project.in(file(".")).aggregate(backend, frontend)

lazy val backend = project

lazy val frontend = project