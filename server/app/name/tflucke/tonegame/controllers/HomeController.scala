package name.tflucke.tonegame.controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
  val controllerComponents: ControllerComponents,
  val indexTemplate: views.html.index
) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(indexTemplate())
  }

  def clientRoutes() = Action { implicit request =>
    import play.api.routing._
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.WordController.getRandomWordGroup,
        routes.javascript.WordController.pronounceRandom
      )
    ).as("text/javascript")
  }
}