package io.github.sdev.mpf.adapter.out.persistence

import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome

import SqlCodecs._

class BudgetRepositoryImpl extends BudgetRepository:

  // TODO
  def save(budget: Budget): IO[Budget] = ???

