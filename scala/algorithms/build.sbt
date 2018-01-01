name := "algorithms"

version := "0.1"

scalaVersion := "2.12.4"

lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "scala.algorithms",
  scalaVersion := "2.10.1",
  test in assembly := {}
)

lazy val app = (project in file("app")).
  settings(commonSettings: _*).
  settings(
    mainClass in assembly := Some("io.github.suzp1984.sort.Main"),
  )
