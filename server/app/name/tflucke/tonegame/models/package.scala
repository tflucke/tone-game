package name.tflucke.tonegame.models

import io.getquill.{PostgresAsyncContext, SnakeCase}
import javax.inject.Singleton

// TODO: Paramaterize DB type
@Singleton
final class Context extends PostgresAsyncContext[SnakeCase](SnakeCase, "db.default") {
  val random = quote(infix"""random()""".as[Ordering[Any]])
}
