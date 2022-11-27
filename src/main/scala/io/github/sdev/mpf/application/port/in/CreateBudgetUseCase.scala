package io.github.sdev.mpf.application.port.in

import io.github.sdev.mpf.domain.Budget
import cats.effect.IO

trait CreateBudgetUseCase:

  def create(budget: Budget): IO[Budget]
