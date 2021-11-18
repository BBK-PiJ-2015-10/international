package com.hs.invitation.service.source

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._

import scala.concurrent.Future
import scala.util.{Failure, Success}

object PartnerClient {

  final val Name = "PartnerClient"

  def props(uriSource: String) = Props(new PartnerClient(uriSource))

}


class PartnerClient(uriSource: String) extends Actor with ActorLogging{

  implicit val actorSystem = context.system

  override def receive: Receive = {
    case fetchAvailabilityCommand : String => {
      log.info(s"Received a $fetchAvailabilityCommand request" )
      //val requester :ActorRef = sender()
      val response : Future[HttpResponse] = Http().singleRequest(HttpRequest(uri=uriSource))
      log.info(s"Was sent $response")
    }
    case other : Any => log.warning(s"Received unexpected request $other")

  }
}
