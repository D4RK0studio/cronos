package org.cronos.command

trait CommandQuery{
  def env:String
  def name:String
}

trait ControlCommandQuery extends CommandQuery{
  lazy val env = "CONTROL"
}
trait OperationCommandQuery extends CommandQuery{
  lazy val env = "OPERATION"
}