package com.hs.partnerservice

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.pattern.ask
import akka.util.Timeout
import com.hs.partnerservice.messaging.PartnerServiceRouter
import com.hs.partnerservice.model.{ErrorMessage, FetchPartnerDataCommand, SimpleMessage}
import com.hs.partnerservice.rest.PartnerServiceApi
import com.typesafe.config.ConfigFactory
import spray.json.RootJsonFormat

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

import scala.io.StdIn


object PartnerServiceAppRunner extends App {

  val config = ConfigFactory.load()

  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("partnerService", config)
  implicit val ec = system.getDispatcher

  val simpleService = system.actorOf(Props(new PartnerServiceRouter))

  implicit val timeOut = Timeout(3.seconds)

  val apiRoutes = new PartnerServiceApi(system,simpleService,timeOut).route

  val bindingFuture = Http()(system)
    .newServerAt("localhost",9070).bind(apiRoutes)


  bindingFuture.onComplete {
    case Success(result) =>
      println("Web application started")
    case Failure(ex) =>
      println("Something went off", ex)
  }


  println("Please enter any text to stop application")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate()) // and shutdown when done

}
