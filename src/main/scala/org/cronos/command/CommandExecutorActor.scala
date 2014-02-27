package org.cronos.command

import akka.actor.{Props, Actor}

class CommandExecutorActor extends Actor{
  val connect =  context.actorOf(Props(new ConnectActor()))
  override def receive: Actor.Receive = {
    case q:String => q match{
      case ConnectCommand.validator(application) => connect forward ConnectCommand.query(application)
      case _ => println("EXECUTOR ERROR")
    }
  }
}
