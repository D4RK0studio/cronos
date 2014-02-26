package org.cronos.command

import scala.util.matching.Regex

trait Command{
  def env:String
  def name:String
  def validator:Regex
  def query(q:String):CommandQuery


  override def toString = "[" + env +"] "+ name
}

trait ControlCommandType extends Command{
  lazy val env = "CONTROL"
  def query(q:String):ControlCommandQuery
}
trait OperationCommandType extends Command{
  lazy val env = "OPERATION"
  def query(q:String):OperationCommandQuery
}





