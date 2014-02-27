package org.cronos.command

import scala.util.matching.Regex
import akka.actor.Actor

object ConnectCommand extends ControlCommandType{
  override def name: String = "Connect"

  val validator: Regex =  "connect ([\\d\\w-]+);".r


  override def query(application:String): ConnectCommandQuery = {
    new ConnectCommandQuery(application)
  }
}
class ConnectActor extends Actor {

  override def receive: Actor.Receive = {
    case query:ConnectCommandQuery => sender ! "Connecting to " + query.application+ "..."
    case _ => println("ERROR")
  }
}




class ConnectCommandQuery(val application:String) extends ControlCommandQuery{
  lazy val name= "CONNECT"
}

