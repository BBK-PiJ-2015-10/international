package com.hs.invitation.service.service

import akka.actor.{Actor, ActorLogging, Props,ActorRef}

object InvitationService {

  final val Name = "invitationService"

  def props(partnerClient: ActorRef): Props = Props(new InvitationService(partnerClient))

}

class InvitationService(partnerClient: ActorRef) extends Actor with ActorLogging {

  override def receive: Receive = {
    case triggerRequest: String => {
      log.info(s"Received trigger request for $triggerRequest")
      partnerClient ! triggerRequest
      sender() ! "Request has been triggered"
    }
    case other: Any => log.info(s"Received a weird message $other ")
  }

}
