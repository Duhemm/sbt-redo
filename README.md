# sbt-redo

A very simple plugin that adds a new command to your build, `r`.

This command can be used to re-run the last command, instead of using the up arrow key
which is too far and too small.

It's definitely not a bullet-proof solution, since it will just inspect sbt's history and
re-run the third element (first is `r`, second is `shell`).

# Installation

## Stable

Simply add the following to your sbt configuration:

```scala
resolvers += Resolver.bintrayIvyRepo("duhemm", "sbt-plugins")
addSbtPlugin("org.duhemm" % "sbt-redo" % "0.1.0")
```

## Development

Clone and build the plugin:

```
$ git clone git@github.com:Duhemm/sbt-redo.git
$ sbt publishLocal
```

Add the following to your sbt configuration:
addSbtPlugin("org.duhemm" % "sbt-redo" % "0.2.0-SNAPSHOT")
