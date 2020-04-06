package name.tflucke.tonegame

import org.scalajs.dom.{XMLHttpRequest,html,document}
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.{HTMLDocument,EventTarget}
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global
import net.exoego.scalajs.jquery._
import net.exoego.scalajs.jquery.JQuery.TriggeredEvent
import play.api.libs.json.Json
import name.tflucke.tonegame.shared.models._

// TODO: Replace dynamic typing with strongly typed reference to Routes
import scala.scalajs.js.Dynamic.{global => js}

object Game {
  def main(args: Array[String]): Unit = {
    val api = ""+js.jsRoutes.name.tflucke.tonegame.controllers.WordController.getRandomWordGroup().url
    JQueryStatic(document).ready($ => {
      Ajax.get(api).foreach({
        x => setWords(Json.parse(x.responseText).as[Seq[Word]])
      })
    })
  }

  def setWords(group: Seq[Word]): Unit = {
    val doc = JQueryStatic("body")
    val answer = group(Random.nextInt(group.length))
    audioPlayer(answer)
    for (word <- group) {
      doc.append(toneButton(word, word == answer))
    }
  }

  def audioPlayer(word: Word): Unit = {
    JQueryStatic("<source>")
      .attr("src", ""+js.jsRoutes.name.tflucke.tonegame.controllers.WordController.pronounceRandom(word.id).url)
      .prependTo("#player")
  }

  def toneButton(word: Word, correct: Boolean): JQuery[html.Element] = {
    val newClass = if (correct) "btn-success" else "btn-danger"
    val btn = JQueryStatic("<button>")
      .addClass("btn")
      .addClass("btn-outline-secondary")
      .attr("type", "button")
      .text(word.spelling)
    btn.click(() => {
      btn.removeClass("btn-outline-secondary").addClass(newClass)
    })
  }
}
