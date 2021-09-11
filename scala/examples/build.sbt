name := "examples"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= {

  val scalaTestVersion = "3.2.9"
  val commonsReference = "3.12.0"

  Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion,
    "org.scalactic" %% "scalactic" % scalaTestVersion,

    "org.apache.commons" % "commons-lang3" %commonsReference
  )


}
