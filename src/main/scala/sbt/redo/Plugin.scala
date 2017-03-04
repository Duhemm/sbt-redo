package sbt
package redo

import sbt.Keys.commands

object Plugin extends AutoPlugin {
  override def requires = sbt.plugins.JvmPlugin
  override def trigger  = allRequirements

  override def projectSettings: Seq[Setting[_]] =
    Seq(
      commands += Command.command("r") { state =>
        state.history.executed.lift(2) match {
          case Some(previous) =>
            previous :: state
          case None =>
            state
        }
      }
    )
}
