package com.hs.invitation.service.service

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.hs.invitation.service.model.{Countries, Partners}

object InvitationService {

  final val Name = "invitationService"

  def props(partnerClient: ActorRef, resultClient: ActorRef): Props = Props(new InvitationService(partnerClient,resultClient))

}

class InvitationService(partnerClient: ActorRef,resultClient: ActorRef) extends Actor with ActorLogging {

  val availabilityCalculator = new AvailabilityCalculator()


  override def receive: Receive = {
    case triggerRequest: String => {
      log.info(s"Received trigger request for $triggerRequest")
      partnerClient ! triggerRequest
      sender() ! "Request has been triggered"
    }
    case partners: Partners => {
      log.info("GOOD ONE")
      log.info(s" $partners")
      partners.partners.foreach(partner => availabilityCalculator.processAvailability(partner))
      val listOfCountries = availabilityCalculator.processCountries
      log.info(s"fucker with size ${listOfCountries.size}")
      val countries = Countries(listOfCountries)
      log.info(s"Will send $countries")
      resultClient ! countries
    }
    case other: Any => log.info(s"Received a weird message $other ")
  }

}
