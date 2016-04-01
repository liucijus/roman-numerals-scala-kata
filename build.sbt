lazy val scalaDojo = (project in file("."))
  .settings(
     name := "scala-dojo",
     scalaVersion := "2.11.8",
     version := "1.0.0"
  )

val ScalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.6"
libraryDependencies += ScalaTest % "test"
