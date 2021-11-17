package com.hs.partnerservice.rest

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import com.hs.partnerservice.model._

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol{

  implicit val simpleCommandFormat : RootJsonFormat[FetchPartnerDataCommand]= jsonFormat1(FetchPartnerDataCommand)

  implicit val simpleMessageFormat : RootJsonFormat[SimpleMessage] = jsonFormat1(SimpleMessage)

  implicit val errorMessageFormat : RootJsonFormat[ErrorMessage] = jsonFormat1(ErrorMessage)

  implicit val partnerMessageFormat: RootJsonFormat[Partner] = jsonFormat5(Partner)

  implicit val partnersMessageFormat: RootJsonFormat[Partners] = jsonFormat1(Partners)

}
