# sbt-redo

A very simple plugin that adds a new command to your build, `r`.

This command can be used to re-run the line that was typed, instead of using the up arrow key
which is too far and too small.

It works by hijacking the sbt shell and replacing it by one that will remember what was the
last typed command, so that it can be re-run if you simply enter `r`.

# Installation

## Stable

Simply add the following to your sbt configuration:

```scala
resolvers += Resolver.bintrayIvyRepo("duhemm", "sbt-plugins")
addSbtPlugin("org.duhemm" % "sbt-redo" % "0.3.0")
```

## Development

Clone and build the plugin:

```
$ git clone git@github.com:Duhemm/sbt-redo.git
$ sbt publishLocal
```

Add the following to your sbt configuration:

```scala
addSbtPlugin("org.duhemm" % "sbt-redo" % "0.4.0-SNAPSHOT")
```
