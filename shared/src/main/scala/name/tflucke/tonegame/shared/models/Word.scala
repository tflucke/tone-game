package name.tflucke.tonegame.shared.models

//import com.fasterxml.jackson.annotation.JsonIgnore
import play.api.libs.json.{Format,Json}

/**
 * Model representing a Vietnamese word.
 */
case class Word (
  val id: Long,
  val spelling: String,
  val wordGroup: Long,
  val tone: Tone.Tone
)

object Tone extends Enumeration {
  type Tone = Value
  val ngang = Value("ngang")
  val huyen = Value("huyen")
  val sac = Value("sac")
  val hoi = Value("hoi")
  val nga = Value("nga")
  val nang = Value("nang")

  implicit val format: Format[Tone] = Json.formatEnum(this)
}

object Word {
  import play.api.libs.json._

  implicit val format: Format[Word] = Json.format[Word]
  implicit val writes: Writes[Word] = __.write[Word].transform((_: JsValue).as[JsObject] - "pronunciations")
}

/**
 * Model representing a single recording.
 */
case class Pronunciation (
  val word: Long,
  val speaker: Long,
  val audio: Array[Byte],
  val mimeType: String
)

object Pronunciation {
  implicit val format: Format[Pronunciation] = Json.format[Pronunciation]
}
