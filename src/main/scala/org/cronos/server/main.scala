package org.cronos.server

import akka.actor.{Props, ActorSystem}
import scala.annotation.tailrec
import org.cronos.command.CommandExecutorActor
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global


object Main extends App with ConfigCassandra {
  import ConsoleCommands._
  import scala.concurrent.duration._
  import akka.util.Timeout
  import akka.pattern.ask
  implicit val timeout = Timeout(5 seconds)
  implicit lazy val system = ActorSystem()
  val commandExecutor =  system.actorOf(Props(new CommandExecutorActor()))

  @tailrec
  private def commandLoop(): Unit = {
    Console.readLine() match {
      case QuitCommand  => return
      case x            => ask (commandExecutor, x).mapTo[String].onSuccess{
        case y => println(y)
      }
    }
    commandLoop()
  }

  commandLoop()

  system.shutdown()
}

object ConsoleCommands {
  val QuitCommand   = "quit"
}


