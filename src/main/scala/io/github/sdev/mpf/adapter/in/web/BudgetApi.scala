package io.github.mpf.sdev.adapter.in.web

import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes
import cats.effect.IO

class BudgetApi extends Http4sDsl[IO] {

  val routes = HttpRoutes.of[IO] {

    // TODO implement
    case body @ POST -> Root / "budgets" =>
      Ok()
  }
}
