package org.cronos.server

import akka.actor.{Props, ActorSystem}
import scala.annotation.tailrec


object Main extends App with ConfigCassandra {
  import ConsoleCommands._
  implicit lazy val system = ActorSystem()
  val commandExecutor =  system.actorOf(Props(new CommandExecutorActor()))

  @tailrec
  private def commandLoop(): Unit = {
    Console.readLine() match {
      case QuitCommand  => return
      case x            => commandExecutor ! x
    }
    commandLoop()
  }

  commandLoop()

  system.shutdown()
}

object ConsoleCommands {
  val QuitCommand   = "quit"
}


