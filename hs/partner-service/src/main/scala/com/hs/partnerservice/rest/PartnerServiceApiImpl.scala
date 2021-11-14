package com.hs.partnerservice.rest



import akka.actor.{ActorSystem, ActorRef,Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.pattern.ask
import akka.util.Timeout
import com.hs.partnerservice.messaging.SimpleService
import com.hs.partnerservice.model.{ErrorMessage, SimpleCommand, SimpleMessage}
import com.hs.partnerservice.rest.PartnerServiceApiImpl
import com.typesafe.config.ConfigFactory
import spray.json.RootJsonFormat

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

import scala.io.StdIn

class PartnerServiceApiImpl(system: ActorSystem, processor: ActorRef, timeout: Timeout) {


  implicit val simpleCommandFormat : RootJsonFormat[SimpleCommand]= jsonFormat1(SimpleCommand)

  implicit val simpleMessageFormat : RootJsonFormat[SimpleMessage] = jsonFormat1(SimpleMessage)

  implicit val errorMessageFormat : RootJsonFormat[ErrorMessage] = jsonFormat1(ErrorMessage)

  implicit def executionContext = system.dispatcher

  implicit def requestTimeout = timeout

  val partnerService: ActorRef = processor

  val route : Route =
    concat(
      get {
        pathPrefix("culon"/LongNumber){id =>
          val fucker = partnerService.ask(SimpleCommand(s"Tonto $id"))
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
      },
      get {
        pathPrefix("culona"/LongNumber){id =>
          val fucker = partnerService.ask(SimpleCommand(s"Tonto $id"))
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
      },
    )

}

