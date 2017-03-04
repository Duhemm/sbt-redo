lazy val redo = project.in(file("."))

version := "0.1.0-SNAPSHOT"
sbtPlugin := true
organization := "org.duhemm"
name := "sbt-redo"
description := "sbt plugin to re-run the last command."
scalacOptions ++=
  Seq("-deprecation", "-feature", "-unchecked", "-Xlint", "-Ywarn-all")
