package sbt
package redo

import sbt.Exec

object Compat {
  def toExec(cmd: String): Exec = Exec(cmd, source = None)
}
