package io.github.sdev.mpf.adapter.out.persistence

import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO
import cats.effect.Resource
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome

import SqlCodecs.*
import skunk.Session
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

class BudgetRepositoryImpl(pool: Resource[IO, Session[IO]]) extends BudgetRepository:

  given Logger[IO] = Slf4jLogger.getLogger[IO]

  def save(budget: Budget): IO[Budget] =
    pool.use { session =>
      session
        .prepare(insertCmd)
        .use { cmd =>
          // TODO fix this... it is never invoked and fails silently
          Logger[IO].info(s"making the insert: $budget") *>
            cmd.execute(budget).as(budget)
        }
        .handleErrorWith { err =>
          Logger[IO].error(err.getMessage()) *> IO.delay(budget)
        }
    }
