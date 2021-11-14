package com.hs.partnerservice

import akka.http.scaladsl.Http
import akka.Done
import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.pattern.ask
import akka.util.Timeout
import com.hs.partnerservice.messaging.SimpleService
import com.hs.partnerservice.model.{ErrorMessage, SimpleCommand, SimpleMessage}
import com.typesafe.config.ConfigFactory
import spray.json.RootJsonFormat

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}
// for JSON serialization/deserialization following dependency is required:
// "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.7"
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

import scala.io.StdIn

import scala.concurrent.Future

object PartnerServiceApp extends App {

  val config = ConfigFactory.load()

  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("partnerService", config)
  implicit val ec = system.dispatcher

  system.log.info("fucker")

  val simpleService = system.actorOf(Props(new SimpleService))

  var orders: List[Item] = Nil

  // domain model
  final case class Item(name: String, id: Long)
  final case class Order(items: List[Item])

  //formats for marshalling and unmarshalling
  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat1(Order)
  implicit val simpleCommandFormat : RootJsonFormat[SimpleCommand]= jsonFormat1(SimpleCommand)
  implicit val simpleMessageFormat : RootJsonFormat[SimpleMessage] = jsonFormat1(SimpleMessage)
  implicit val errorMessageFormat : RootJsonFormat[ErrorMessage] = jsonFormat1(ErrorMessage)

  implicit val timeOut = Timeout(3.seconds)

  //mock async database query api
  def fetchItem(itemId: Long) : Future[Option[Item]] = Future {
    orders.find(o => o.id == itemId )
  }

  def saveOrder(order: Order) : Future[Done] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _ => orders
    }
    Future {Done}
  }

  val route : Route =
    concat(
      get {
        pathPrefix("culon"/LongNumber){id =>
          val fucker = simpleService.ask(SimpleCommand(s"Tonto $id"))
          onComplete(fucker){
            case Success(value) => {
              value match {
                case simpleMessage: SimpleMessage => complete(simpleMessage)
                case _ : Any => complete(StatusCodes.NotFound)
              }
            }
            case Failure(exception) => {
              complete(StatusCodes.NotFound)
            }
          }
          }
      }
    )

  val bindingFuture = Http().newServerAt("localhost",7070).bind(route)


  println("Please enter any text to stop application")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate()) // and shutdown when done

}
