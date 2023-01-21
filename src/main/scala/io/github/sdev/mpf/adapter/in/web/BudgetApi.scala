package io.github.mpf.sdev.adapter.in.web

import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes
import cats.effect.IO
import io.github.sdev.mpf.adapter.in.web.dto.CreateBudgetDto.*
import org.http4s.circe.CirceEntityDecoder.*
import org.http4s.circe.jsonOf
import org.http4s.circe.jsonEncoderOf
import io.github.sdev.mpf.application.port.in.CreateBudgetUseCase
import io.github.sdev.mpf.domain.Budget
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome
import io.github.sdev.mpf.adapter.in.web.Codecs.budgetEncoder
import org.http4s.circe.CirceEntityEncoder.circeEntityEncoder
import org.http4s.EntityEncoder

class BudgetApi(createBudgetUseCase: CreateBudgetUseCase) extends Http4sDsl[IO]:

  val createBudgetDtoDecoder =
    jsonOf[IO, CreateBudgetDto]

  given budgetEntityEncoder: EntityEncoder[IO, Budget] =
    jsonEncoderOf[IO, Budget]

  val routes = HttpRoutes
    .of[IO] { case req @ POST -> Root / "budgets" =>
      for
        createBudgetDto <- req.as[CreateBudgetDto]
        budget = Budget(
          createBudgetDto.month,
          createBudgetDto.year,
          createBudgetDto.ins.map(i => Income(i.concept, i.amount)),
          createBudgetDto.outs.map(o => Outcome(o.concept, o.amount))
        )
        createdBudget <- createBudgetUseCase.create(budget)
        resp          <- Ok(createdBudget)
      yield resp
    }
