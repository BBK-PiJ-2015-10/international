package com.hs.partnerservice.messaging

import akka.actor.{Actor, ActorLogging, Props}
import com.hs.partnerservice.model.SimpleMessage

object SimpleService {

  def props() = Props(new SimpleService())

}

class SimpleService extends Actor with ActorLogging{

  override def receive: Receive = {

    case message : Any => {
      log.info(s"Simple service has received $message")
      sender() ! SimpleMessage(s"$message processed")
    }

  }

}
