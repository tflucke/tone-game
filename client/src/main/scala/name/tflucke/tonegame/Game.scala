package name.tflucke.tonegame

import org.scalajs.dom.{XMLHttpRequest,html,document}
import org.scalajs.dom.raw.{HTMLDocument,EventTarget}
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}
import scala.util.{Random,Try,Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import net.exoego.scalajs.jquery.{JQuery,JQueryStatic => $}
import net.exoego.scalajs.jquery.JQuery.TriggeredEvent
import name.tflucke.tonegame.shared.models._
import name.tflucke.tonegame.controllers.WordController

@JSExportTopLevel(name="Game")
object Game {
  import org.scalajs.dom.raw.HTMLAudioElement
  var totalCorrect = 0
  var totalGuessed = 0
  var firstGuess   = true
  
  def main(args: Array[String]): Unit = {
    $(document).ready($ => { Nav.home() })
  }

  @JSExport
  def nextWord(): Unit = {
    $("#next-word").hide()
    WordController.getRandomWordGroup()() andThen({
      case Success(words) => setWords(words)
      case Failure(error) => println(error)
    })
  }

  def setWords(group: Seq[Word]): Unit = {
    firstGuess = true
    val doc = $("#answers").empty()
    val answer = group(Random.nextInt(group.length))
    audioPlayer(answer)
    for (word <- group) {
      doc.append(toneButton(word, word == answer))
    }
  }

  def audioPlayer(word: Word): Unit = {
    $("source").attr("src", WordController.pronounceRandom(word.id).url)
    val player = $("#player")(0).asInstanceOf[HTMLAudioElement]
    player.load()
  }

  def setProgress(value: Double): Unit = {
    val percentage = Math.round(100*value).toString
    $("#accuracy").attr("percentage", percentage).css("width", percentage+"%")
  }

  def toneButton(word: Word, correct: Boolean): JQuery[html.Element] = {
    val btn = $("<button>")
      .addClass("btn")
      .addClass("btn-outline-secondary")
      .attr("type", "button")
      .text(word.spelling)
    if (correct) {
      btn.click(() => {
        if (firstGuess) {
          firstGuess = false
          totalCorrect += 1
          totalGuessed += 1
          setProgress(totalCorrect*1.0f/totalGuessed)
        }
        btn.removeClass("btn-outline-secondary").addClass("btn-success")
        $("#next-word").show()
      })
    }
    else {
      btn.click(() => {
        if (firstGuess) {
          firstGuess = false
          totalGuessed += 1
          setProgress(totalCorrect*1.0f/totalGuessed)
        }
        btn.removeClass("btn-outline-secondary").addClass("btn-danger")
      })
    }
  }
}
