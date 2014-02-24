package org.cronos.server

import akka.actor.ActorSystem
import scala.annotation.tailrec


object Main extends App with ConfigCassandraCluster {
  import Commands._
  implicit lazy val system = ActorSystem()

  @tailrec
  private def commandLoop(): Unit = {
    Console.readLine() match {
      case QuitCommand                => return
//      case ScanCommand(query)         => scan ! query.toString
//
//      case ListCommand(count)         => read ! FindAll(count.toInt)
//      case CountCommand               => read ! CountAll
      case _                          =>
    }
    commandLoop()
  }

  commandLoop()

  system.shutdown()
}

object Commands {
  val QuitCommand  = "quit"
//  val ListCommand  = "list (\\d+)".r
//  val CountCommand = "count"
//  val ScanCommand  = "scan (.*)".r

}


