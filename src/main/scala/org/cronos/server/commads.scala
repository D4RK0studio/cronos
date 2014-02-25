package org.cronos.server

import akka.actor.{Props, Actor}
import scala.util.matching.Regex


class CommandExecutorActor extends Actor{
  val connect =  context.actorOf(Props(new ConnectActor()))
  override def receive: Actor.Receive = {
    case x:String => x match{
      case ConnectCommand.validator() => connect ! Seq(("test","test"))
      case _ => println("ERROR")
    }
  }
}


class ConnectActor extends Actor {

  override def receive: Actor.Receive = {
    case x: Seq[(String,String)] => println("connect")
  }
}

class ArgumentsCommand(args:Seq[(String,String)])

object ConnectCommand extends ControlCommandType{
  override def name: String = "Connect"

  val validator: Regex = "connect".r
}



trait ControlCommandType extends Command{
  def env = "CONTROL"
}
trait OperationCommandType extends Command{
  def env = "OPERATION"
}

trait Command{
  def env:String
  def name:String
  def validator:Regex

  override def toString = "[" + env +"] "+ name
}