package org.cronos.command

import scala.util.matching.Regex

trait Command{
  def env:String
  def name:String
  def validator:Regex



  override def toString = "[" + env +"] "+ name
}

trait ControlCommandType extends Command{
  lazy val env = "CONTROL"
}
trait OperationCommandType extends Command{
  lazy val env = "OPERATION"
}







