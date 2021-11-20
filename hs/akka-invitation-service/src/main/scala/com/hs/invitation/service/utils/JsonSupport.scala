package com.hs.invitation.service.utils

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import com.hs.invitation.service.model._

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol{

  implicit val partnerMessageFormat: RootJsonFormat[Partner] = jsonFormat5(Partner)

  implicit val partnersMessageFormat: RootJsonFormat[Partners] = jsonFormat1(Partners)


}
