package com.hs.partnerservice.rest

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{RootJsonFormat}
import com.hs.partnerservice.model._
import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat1}

trait MyJsonSupport {

  implicit val simpleCommandFormat : RootJsonFormat[SimpleCommand]= jsonFormat1(SimpleCommand)

  implicit val simpleMessageFormat : RootJsonFormat[SimpleMessage] = jsonFormat1(SimpleMessage)

  implicit val errorMessageFormat : RootJsonFormat[ErrorMessage] = jsonFormat1(ErrorMessage)


}
