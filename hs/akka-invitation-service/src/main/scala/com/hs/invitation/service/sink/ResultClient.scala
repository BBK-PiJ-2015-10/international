package com.hs.invitation.service.sink

import akka.actor.{Actor, ActorLogging, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpMethods,HttpRequest}
import com.hs.invitation.service.model.{Countries}
import spray.json._
import com.hs.invitation.service.utils.JsonSupport

import scala.util.{Failure, Success}

object ResultClient {

  final val Name : String = "ResultClient"
  def props(uriDestination: String) = Props(new ResultClient(uriDestination))

}

class ResultClient(uriDestination: String) extends Actor with ActorLogging with JsonSupport {

  implicit val actorSystem = context.system
  implicit val ec = actorSystem.getDispatcher
  val http = Http(actorSystem)

  override def receive: Receive = {
    case countries: Countries => {
      log.info(s"Will send countries $countries")
      val jsonBody = countries.toJson.compactPrint
      log.info(s"NOW with $jsonBody")
      val entity = HttpEntity(ContentTypes.`application/json`, jsonBody)
      val request = HttpRequest(HttpMethods.POST, uri = uriDestination, entity = entity)
      http.singleRequest(request).onComplete {
        case Success(value) => log.info(s"Successful submission with response $value")
        case Failure(exception) => log.info(s"Something went off ${exception.getMessage}")
      }


    }
    case other : Any => log.info(s"Received weird stuff $other")
  }
}
