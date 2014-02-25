package org.cronos.server

import com.datastax.driver.core.Cluster
import akka.actor.ActorSystem
import scala.io.Source


trait CassandraConfig {
    def cluster:Cluster
    def keyspaceName:String
    def init():Unit
}

trait ConfigCassandra extends CassandraConfig {
  def system: ActorSystem

  private def config = system.settings.config

  import scala.collection.JavaConversions._
  private val cassandraConfig = config.getConfig("cronos.db.cassandra")
  private val port = cassandraConfig.getInt("port")
  private val hosts = cassandraConfig.getStringList("hosts").toList
  private val name= cassandraConfig.getString("keyspace.name")
  private val replication= cassandraConfig.getInt("keyspace.replication")


  lazy val cluster:Cluster = {
    Cluster.builder().
    addContactPoints(hosts: _*).
    withPort(port).
    build()
  }
  lazy val keyspaceName=name

  def init() ={
    if(cluster!=null) {
      val session= cluster.connect()
      val query = Source.fromURL(getClass.getResource("/keyspace.cql")).mkString
        .replace(CassandraConfigReservedWords.KeyspaceName,name)
        .replace(CassandraConfigReservedWords.KeyspaceReplication,replication.toString)
      query.split(";").foreach(session.execute)
    }
  }
}

object CassandraConfigReservedWords{
   val KeyspaceName= "[%KEYSPACE_NAME%]"
   val KeyspaceReplication="[%KEYSPACE_REPLICATION%]"
}



