package com.hs.invitation.service

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.hs.invitation.service.api.TriggerApi
import com.hs.invitation.service.service.InvitationService

import scala.io.StdIn
import scala.util.{Failure, Success}

object ApplicationRunner extends App{

  implicit val actorSystem = ActorSystem("invitationApplication")
  implicit val ec = actorSystem.getDispatcher

  val invitationService = actorSystem.actorOf(InvitationService.props(),InvitationService.Name)

  val apiRoutes = new TriggerApi(actorSystem,invitationService).route

  val bindingFuture = Http()(actorSystem)
    .newServerAt("localhost",6060).bind(apiRoutes)

  bindingFuture
    .onComplete {
      case Success(value) =>
        actorSystem.log.info(s"Web server started successfully with $value")
      case Failure(exception) =>
        actorSystem.log.error(s"Unable to start web server due to ${exception.getMessage}")
    }


  println("Type any key to stop application")

  StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => {
      actorSystem.log.info("Shutting down application")
      actorSystem.terminate()
    })






}
