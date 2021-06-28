package controllers

import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class HealthcheckController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def healthcheck() = Action(Ok("up and running"))
}
