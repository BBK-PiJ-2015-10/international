package com.hs.invitation.service.source

import akka.actor.{Actor, ActorLogging, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.util.ByteString

import scala.util.{Failure, Success}

object PartnerClient {

  final val Name = "PartnerClient"

  def props(uriSource: String) = Props(new PartnerClient(uriSource))

}


class PartnerClient(uriSource: String) extends Actor with ActorLogging{

  implicit val actorSystem = context.system
  implicit val ec = actorSystem.getDispatcher
  val http = Http(actorSystem)

  override def receive: Receive = {
    case fetchAvailabilityCommand: String => {
      log.info(s"Received a $fetchAvailabilityCommand request")
      //val requester: ActorRef = sender()
      http.singleRequest(HttpRequest(uri = uriSource))
        .onComplete {
          case Success(response) => response match {
            case HttpResponse(StatusCodes.OK, headers, entity, _) =>
              entity.dataBytes.runFold(ByteString(""))(_ ++ _).foreach { body =>
                log.info("Got response, body: " + body.utf8String)
              }
            case resp@HttpResponse(code, _, _, _) =>
              log.info("Request failed, response code: " + code)
              resp.discardEntityBytes()
          }
          case Failure(exception) =>
            log.error(s"Something went off ${exception.getMessage}")
        }
    }
    case other: Any => log.warning(s"Received unexpected request $other")
  }

}
