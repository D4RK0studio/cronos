name := "cronos"

version := "1.0"

scalaVersion := "2.10.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3"

libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "2.0.0-rc2"

mainClass := Some("Main")

