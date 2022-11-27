package io.github.sdev.mpf.application.port

import io.github.sdev.mpf.application.port.in.CreateBudgetUseCase
import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO

class CreateBudgetService(budgetRepository: BudgetRepository) extends CreateBudgetUseCase:
  // TODO
  def create(budget: Budget): IO[Budget] = ???
