package name.tflucke.tonegame

import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}
import scala.scalajs.js._
import net.exoego.scalajs.jquery.{JQueryStatic => $}
import net.exoego.scalajs.jquery.JQuery.jqXHR

@JSExportTopLevel(name="Nav")
object Nav {
  @JSExport
  def home(): Unit = load("game.html",
    Some((_: HTMLElement, _: String, _: |[String,String], _: jqXHR) => {
      Game.nextWord()
    })
  )

  @JSExport
  def about(): Unit = load("about.html")

  @JSExport
  def contrib(): Unit = load("contrib.html")

  type JqueryCallback = ThisFunction3[HTMLElement, String, |[String,String],
    jqXHR, Unit]

  @JSExport
  def load(page: String, fn: Option[JqueryCallback] = None) = fn match {
    case Some(cfn) => $("#content").load(s"/assets/views/$page", "", cfn)
    case None => $("#content").load(s"/assets/views/$page")
  }
}
