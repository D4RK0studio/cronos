package org.cronos.command

import scala.util.matching.Regex
import akka.actor.Actor
import org.cronos.store.entity.DataType

object CreateCommand extends ControlCommandType{
  override def name: String = "Connect"

  val validator: Regex =  "create \\[([\\d\\w\\-\\_]+),(number|decimal|string)\\]".r


   def query(application:String, dataType:String): CreateCommandQuery = {
    val eDataType=DataType.getDataType(dataType)
    if(eDataType == DataType.UNKNOWN) {
      throw new UnknownDataTypeException(dataType)
    }else new CreateCommandQuery(application,eDataType)
  }
}

class CreateActor extends Actor {

  override def receive: Actor.Receive = {
    case query:CreateCommandQuery => sender ! "Creating to " + query.application + " type " + query.dataType + "..."
    case _ => println("ERROR")
  }
}

class CreateCommandQuery(val application:String,val dataType:DataType) extends ControlCommandQuery{
  lazy val name= "Create"
}
