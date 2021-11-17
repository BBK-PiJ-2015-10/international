package com.hs.partnerservice.rest

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.pattern.ask
import akka.util.Timeout
import com.hs.partnerservice.model.{ErrorMessage, Partner, Partners, FetchPartnerDataCommand, SimpleMessage}

import scala.util.{Failure, Success}

class PartnerServiceApi(system: ActorSystem, processor: ActorRef, timeout: Timeout) extends JsonSupport {

  implicit def executionContext = system.dispatcher

  implicit def requestTimeout = timeout

  val partnerService: ActorRef = processor

  val route: Route =
    concat(
      get {
        path("availability") {
          parameter("userKey") { key =>
            val fucker = partnerService.ask(FetchPartnerDataCommand(s"Customer userKey is : $key"))
            onComplete(fucker) {
              case Success(value) => {
                value match {
                  case partners: Partners => complete(partners)
                  case _: Any => complete(StatusCodes.NotFound)
                }
              }
              case Failure(exception) => {
                complete(StatusCodes.NotFound)
              }
            }
          }
        }
      },
      get {
        //pathPrefix("dataset"/LongNumber){id =>
        path("dataset") {
          val fucker = partnerService.ask(FetchPartnerDataCommand(s"Customer id any"))
          onComplete(fucker) {
            case Success(value) => {
              value match {
                case partners: Partners => complete(partners)
                case _: Any => complete(StatusCodes.NotFound)
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




