val scala3Version = "3.5.1-RC1-bin-SNAPSHOT"
lazy val root = project
  .in(file("."))
  .settings(
    name := "ScalaDocSiteBuilder",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "org.scala-lang" %% "scala3-language-server" % scala3Version,
      "org.scala-lang" %% "scala2-library-tasty-experimental" % scala3Version,
      "org.scala-lang" %% "scala3-compiler" % scala3Version,
      "org.scala-lang" %% "scaladoc" % scala3Version
    ),
    // Add the scalacOptions for Scaladoc
    Compile / doc / scalacOptions ++= Seq(
      "-siteroot", "docs",
      "-project", "Scala Docs",
      "-project-version", "0.1.0-SNAPSHOT",
      "-quick-links", "Learn::https://docs.scala-lang.org/,Install::https://www.scala-lang.org/download/,Playground::https://scastie.scala-lang.org,Find A Library::https://index.scala-lang.org,Community::https://www.scala-lang.org/community/,Blog::https://www.scala-lang.org/blog/,"
    )
  )