package com.hs.invitation.service.service

import akka.actor.{Actor, ActorLogging, Props}

object InvitationService {

  final val Name = "invitationService"

  def props(): Props = Props(new InvitationService)

}

class InvitationService extends Actor with ActorLogging {

  override def receive: Receive = {
    case triggerRequest: String => {
      log.info(s"Received trigger request for $triggerRequest")
      sender() ! "Request has been triggered"
    }
    case other: Any => log.info(s"Received a weird message $other ")
  }

}
