name := "partner-service"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= {

  val akkaVersion = "2.6.8"
  val akkaHttpVersion = "10.2.7"

  Seq (
    "com.typesafe.akka" %% "akka-actor" %akkaVersion,

    "com.typesafe.akka" %% "akka-actor-typed" %akkaVersion,
    "com.typesafe.akka" %% "akka-stream" %akkaVersion,

    "com.typesafe.akka" %% "akka-http" %akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" %akkaHttpVersion,

    "ch.qos.logback" % "logback-classic" % "1.2.6"

  )


}
