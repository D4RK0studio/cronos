import de.johoop.jacoco4sbt._
import JacocoPlugin._

name := "cronos"

version := "1.0"

scalaVersion := "2.10.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3"

libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "2.0.0-rc2"

libraryDependencies += "commons-configuration" % "commons-configuration" % "1.9"

libraryDependencies += "com.fasterxml.uuid" % "java-uuid-generator" % "3.1.3"

mainClass := Some("Main")

jacoco.settings