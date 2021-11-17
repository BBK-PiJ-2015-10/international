package com.hs.partnerservice.messaging

import akka.actor.{Actor, ActorLogging, Props}
import com.hs.partnerservice.model.{Partner, Partners}
import com.hs.partnerservice.rest.JsonSupport
import spray.json._

import scala.io.Source

object PartnerServiceRouter {
  def props() = Props(new PartnerServiceRouter())
}

class PartnerServiceRouter extends Actor with ActorLogging with JsonSupport{

  override def receive: Receive = {
    case message : Any => {
      log.info(s"Partner service has received $message")
      val input = Source.fromResource("partners_data.json").mkString
      val partners = input.parseJson.convertTo[Partners]
      sender() ! partners
    }
  }

}
