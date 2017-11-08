package sbt
package redo

import sbt.Keys.{commands, onLoad}

object Plugin extends AutoPlugin {
  override def requires = sbt.plugins.JvmPlugin
  override def trigger  = allRequirements

  override def buildSettings: Seq[Setting[_]] =
    Seq(
      commands += hijackShell,
      onLoad in Global := {
        val previous = (onLoad in Global).value
        ((s: State) => Hijack :: s) compose previous
      }
    )

  private var previous: Option[String] = None
  private val Hijack                   = "hijack"
  private val hijackShell = Command.command(Hijack)(s =>
    s.copy(definedCommands = s.definedCommands :+ hijackedShell))

  private val hijackedShell =
    Command.command(BasicCommandStrings.Shell) { s =>
      val history = (s get BasicKeys.historyPath) getOrElse Some(
          new File(s.baseDir, ".history"))
      val prompt = (s get BasicKeys.shellPrompt) match {
        case Some(pf) => pf(s); case None => "> "
      }
      val reader = new FullReader(history, s.combinedParser)
      val line   = reader.readLine(prompt)

      def run(cmd: String): State = {
        val newState = s
          .copy(
            onFailure = Some(Compat.toExec(BasicCommandStrings.Shell)),
            remainingCommands = Compat.toExec(cmd) +: Compat.toExec(BasicCommandStrings.Shell) +: s.remainingCommands)
          .setInteractive(true)
        if (cmd.trim.isEmpty) newState else newState.clearGlobalLog
      }

      (line, previous) match {
        case (Some("r"), Some(line)) =>
          run(line)
        case (Some(line), _) =>
          if (line.nonEmpty) previous = Some(line)
          run(line)
        case (None, _) =>
          s.setInteractive(false)
      }
    }
}
