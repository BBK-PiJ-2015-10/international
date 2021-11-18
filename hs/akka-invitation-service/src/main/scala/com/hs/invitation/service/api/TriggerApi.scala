package com.hs.invitation.service.api

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

class TriggerApi(system: ActorSystem, invitationService: ActorRef) {

  implicit val executionContextExecutor = system.dispatcher

  implicit val requestTimeOut = Timeout(3.seconds)

  val route: Route =
    concat(
      path("invitation") {
        parameter("userKey") { key =>
          val triggerResponse = invitationService.ask(s"User key $key")
          onComplete(triggerResponse) {
            case Success(value) => {
              value match {
                case expectedResponse: String => complete(expectedResponse)
                case _: Any => complete(StatusCodes.NotFound)
              }
            }
            case Failure(exception) => {
              complete(StatusCodes.NotFound)
            }
          }
        }
      }
    )


}
