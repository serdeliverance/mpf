package io.github.sdev.mpf.application.port

import io.github.sdev.mpf.application.port.in.CreateBudgetUseCase
import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

class CreateBudgetService(budgetRepository: BudgetRepository) extends CreateBudgetUseCase:
  // TODO look for best practices of defining loggers
  given Logger[IO] = Slf4jLogger.getLogger[IO]
  def create(budget: Budget): IO[Budget] =
    Logger[IO].info("creating budget") *>
      budgetRepository.save(budget)
