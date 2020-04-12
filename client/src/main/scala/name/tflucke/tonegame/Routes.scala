package name.tflucke.tonegame

// Wrapper classes to add stict typing to dynamic objects
import scala.scalajs.js

trait JsRoute extends js.Any {
  val url: String
  val method: String
}

object WordController {
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.{Try, Success, Failure}
  import scala.scalajs.js.{Array,Dynamic}
  import scala.scalajs.js.Dynamic.{global => js}
  import scala.scalajs.js.annotation.JSName
  import play.api.libs.json.{Json,Reads}
  import org.scalajs.dom.XMLHttpRequest
  import org.scalajs.dom.ext.Ajax
  import org.scalajs.dom.ext.Ajax.InputData
  import name.tflucke.tonegame.shared.models.{Word,WordGroup}

  def getRandomWordGroup(timeout: Int = 0, headers: Map[String, String] = Map.empty,
    withCredentials: Boolean = false)(implicit reads: Reads[Seq[Word]]) = {
    val route = Routes.getRandomWordGroup()
    Ajax.apply(route.method, route.url, null, timeout, headers, withCredentials,
      "text").transform(
      (x: Try[XMLHttpRequest]) => Try(Json.parse(x.get.responseText).as[Seq[Word]])
    )
  }

  def pronounceRandom(id: Long, timeout: Int = 0, headers: Map[String, String] = Map.empty,
    withCredentials: Boolean = false)(implicit reads: Reads[Array[Byte]]) = {
    val route = Routes.pronounceRandom(id)
    Ajax.apply(route.method, route.url, null, timeout, headers, withCredentials,
      "blob").transform(
      (x: Try[XMLHttpRequest]) => Try(Json.parse(x.get.responseText).as[Array[Byte]])
    )
  }

  object Routes {
    private val inner = js.jsRoutes.name.tflucke.tonegame.controllers.WordController

    def getRandomWordGroup() = inner.getRandomWordGroup().asInstanceOf[JsRoute]
    def pronounceRandom(id: Long) = inner.pronounceRandom(id).asInstanceOf[JsRoute]
  }
}

