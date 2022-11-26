package io.github.sdev.mpf.adapter.in.web

import cats.effect.IO
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes

class ExpensesApi extends Http4sDsl[IO] {
    
    val routes = HttpRoutes.of[IO] {

        // TODO implement
        // must receive month and year, if year is not provided it takes the current one
        // if month is not provided, it retrieves current month and year
        case GET -> Root / "expenses" => Ok()
    }
}