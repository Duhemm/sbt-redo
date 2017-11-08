lazy val redo = project.in(file("."))

version := "0.3.0"
sbtPlugin := true
organization := "org.duhemm"
name := "sbt-redo"
description := "sbt plugin to re-run the last command."
scalacOptions ++=
  Seq("-deprecation", "-feature", "-unchecked", "-Xlint")
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
crossSbtVersions := Seq("0.13.16", "1.0.3")
bintrayReleaseOnPublish := false
