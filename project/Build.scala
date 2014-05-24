

object Build extends sbt.Build {
  lazy val root = (Project(id = "cronos", base = file("."))
    aggregate(client, common, commonTest, gui, server, test)
    settings(ScoverageSbtPlugin.instrumentSettings: _*)
    )

  lazy val common = (Project(id = "common", base = file("cronos-common"))
    settings(ScoverageSbtPlugin.instrumentSettings: _*)
    )
}
