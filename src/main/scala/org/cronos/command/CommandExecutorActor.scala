package org.cronos.command

import akka.actor.{Props, Actor}

class CommandExecutorActor extends Actor{
  val create =  context.actorOf(Props(new CreateActor()))
  override def receive: Actor.Receive = {
    case q:String => q match{
      case CreateCommand.validator(application,typeData) => create forward CreateCommand.query(application,typeData)
      case _ => println("EXECUTOR ERROR")
    }
  }
}
