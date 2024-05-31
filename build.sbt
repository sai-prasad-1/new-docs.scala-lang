val scala3Version = "3.4.2-SNAPSHOT-0.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "ScalaDocSiteBuilder",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,

    // Add the scalacOptions for Scaladoc
    Compile / doc / scalacOptions ++= Seq(
      "-siteroot", "docs",
      "-project", "ScalaDocSiteBuilder",
      "-project-version", "0.1.0-SNAPSHOT"
    )
  )
