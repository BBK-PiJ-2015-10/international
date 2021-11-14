//import akka.actor.typed.ActorSystem
//import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.Done
import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import com.typesafe.config.ConfigFactory
// for JSON serialization/deserialization following dependency is required:
// "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.7"
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

import scala.io.StdIn

import scala.concurrent.Future

object HttpServerSprayJsonExample extends App{

  val config = ConfigFactory.load()

  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("partnerService", config)

  //implicit val system = ActorSystem(Behaviors.empty,"SprayExample")

  //implicit val ec = system.executionContext

  implicit val ex = system.getDispatcher

  var orders: List[Item] = Nil

  // domain model
  final case class Item(name: String, id: Long)
  final case class Order(items: List[Item])

  //formats for marshalling and unmarshalling
  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat1(Order)

  //mock async database query api
  def fetchItem(itemId: Long) : Future[Option[Item]] = Future {
    orders.find(o => o.id == itemId )
  }

  def saveOrder(order: Order) : Future[Done] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _ => orders
    }
    Future {Done}
  }

  val route : Route =
    concat(
      get {
        pathPrefix("item"/LongNumber){id =>
          val maybeItem: Future[Option[Item]] = fetchItem(id)
          onSuccess(maybeItem){
            case Some(item) => complete(item)
            case None  => complete(StatusCodes.NotFound)
          }
        }
      },
      post {
        path("create-order"){
          entity(as[Order]){ order =>
            val saved: Future[Done] = saveOrder(order)
            onSuccess(saved){ _=>
              complete("orderCreated")
            }
          }
        }
      }
    )

  val bindingFuture = Http().newServerAt("localhost",5050).bind(route)
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate()) // and shutdown when done

}
