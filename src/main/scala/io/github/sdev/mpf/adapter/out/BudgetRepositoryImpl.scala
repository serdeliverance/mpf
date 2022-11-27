package io.github.sdev.mpf.adapter.out

import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO

class BudgetRepositoryImpl extends BudgetRepository:
  // TODO
  def save(budget: Budget): IO[Budget] = ???
