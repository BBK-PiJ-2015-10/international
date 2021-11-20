name := "akka-invitation-service"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= {

  val akkaVersion = "2.6.8"
  val akkaHttpVersion = "10.2.7"
  val scalaTestVersion = "3.2.10"

  Seq(
    "com.typesafe.akka" %% "akka-actor" %akkaVersion,

    "com.typesafe.akka" %% "akka-stream" %akkaVersion,

    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" %akkaHttpVersion,

    "org.scalatest" %% "scalatest" %scalaTestVersion,

    "ch.qos.logback" % "logback-classic" % "1.2.6"

  )


}
