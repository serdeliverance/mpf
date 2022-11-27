package io.github.sdev.mpf.application.port.out.persistence

import io.github.sdev.mpf.domain.Budget
import cats.effect.IO

trait BudgetRepository:
  def save(budget: Budget): IO[Budget]
