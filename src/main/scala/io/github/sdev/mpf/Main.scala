package io.github.sdev.mpf

import cats.effect.IOApp
import cats.effect.IO
import cats.effect.Resource
import io.github.sdev.mpf.adapter.out.migration.Migrator.initializeDb
import io.github.sdev.mpf.adapter.out.migration.Migrator
import io.github.sdev.mpf.config.Database.{ DbConfig, checkPostgresConnection }
import skunk.Session
import natchez.Trace.Implicits.noop
import io.github.sdev.mpf.application.port.CreateBudgetService
import io.github.sdev.mpf.adapter.out.persistence.BudgetRepositoryImpl
import io.github.mpf.sdev.adapter.in.web.BudgetApi
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Router
import org.http4s.implicits.*
import cats.effect.ExitCode

object Main extends IOApp.Simple:

  def run: IO[Unit] =
    val resources =
      for
        _ <- Resource.eval(Migrator.initializeDb(DbConfig("jdbc:postgresql://localhost:45432/mpfdb", "root", "root")))
        pool <- Session
          .pooled[IO](
            host = "localhost",
            port = 45432,
            user = "root",
            password = Some("root"),
            database = "mpfdb",
            max = 10
          )
          .evalTap(checkPostgresConnection)
        budgetRepository    = new BudgetRepositoryImpl(pool)
        createBudgetUseCase = new CreateBudgetService(budgetRepository)
        apis                = new BudgetApi(createBudgetUseCase)
        httpApp             = Router("/api" -> apis.routes).orNotFound
        server <- EmberServerBuilder.default[IO].withHttpApp(httpApp).build
      yield server

    resources
      .use(_ => IO.never)
      .as(ExitCode.Success)
