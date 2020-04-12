package name.tflucke.tonegame.controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import name.tflucke.tonegame.models.Context
import name.tflucke.tonegame.shared.models._

@Singleton
class WordController @Inject()(
  val controllerComponents: ControllerComponents,
  val db: Context
) extends BaseController {

  import db._

  implicit val encodeTone = MappedEncoding[Tone.Tone, String](_.toString)
  implicit val decodeTone = MappedEncoding[String, Tone.Tone](Tone.withName(_))
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  val words = quote(querySchema[Word]("Words"))
  val groups = quote(querySchema[WordGroup]("WordGroups"))
  val pronunciations = quote(querySchema[Pronunciation]("Pronunciations"))
  val jsonMime = "application/json;charset=UTF-16"

  def getRandomWord = Action.async { implicit request: Request[AnyContent] =>
    run(words.sortBy(w => random).take(1)
    ).map(_.headOption) map {
      case Some(word) => Ok(Json.toJson(word)).as(jsonMime)
      case None =>  InternalServerError("Could not find random word.")
    }
  }

  def getWord(id: Long) = Action.async { implicit request: Request[AnyContent] =>
    run(words.filter(c => c.id == lift(id)).take(1)).map(_.headOption) map {
      case Some(word) => Ok(Json.toJson(word)).as(jsonMime)
      case None => NotFound(s"No word with id $id")
    }
  }

  def getRandomWordGroup = Action.async { implicit request: Request[AnyContent] =>
    run(
      groups.sortBy(g => random).take(1).join(words).on(_.id == _.wordGroup)
    ) map {
      case Nil => InternalServerError("Could not find random word")
      case words => Ok(Json.toJson(words.map(_._2))).as(jsonMime)
    }
  }

  def getGrouping(id: Long) = Action.async {
    implicit request: Request[AnyContent] =>
    run(words.filter(c => c.wordGroup == lift(id))) map {
      case Nil => NotFound(s"No word group with id $id")
      case words => Ok(Json.toJson(words)).as(jsonMime)
    }
  }

  def pronounce(id: Long, speaker: Int) = Action.async {
    implicit request: Request[AnyContent] =>
    run(pronunciations.filter(p =>
      p.word == lift(id) &&
      p.speaker == lift(speaker)
    ).take(1)).map(_.headOption) map {
      case None => NotFound(s"No pronunciation from speaker $speaker for word $id")
      case Some(pronunciation) => Ok(pronunciation.audio)
          .as(pronunciation.mimeType)
    }
  }

  def pronounceRandom(id: Long) = Action.async {
    implicit request: Request[AnyContent] =>
    run(pronunciations
      .filter(p => p.word == lift(id))
      .sortBy(g => random)
      .take(1)
    ).map(_.headOption) map {
      case None => NotFound(s"No pronunciations for word $id")
      case Some(pronunciation) => Ok(pronunciation.audio)
          .as(pronunciation.mimeType)
    }
  }
}
