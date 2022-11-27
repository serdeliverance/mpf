package io.github.sdev.mpf.adapter.in.web

import cats.effect.IO
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes

class BalanceApi extends Http4sDsl[IO] {

  val routes = HttpRoutes.of[IO] {

    // TODO implement
    // TODO define endpoint to receive year and month, if year is not passed it retrieves current one
    case GET -> Root / "balances" / IntVar(ble) => Ok()
  }
}
