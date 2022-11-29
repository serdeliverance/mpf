package io.github.sdev.mpf

import cats.effect.IOApp
import cats.effect.IO
import cats.effect.Resource
import io.github.sdev.mpf.adapter.out.migration.Migrator.initializeDb
import io.github.sdev.mpf.adapter.out.migration.Migrator
import io.github.sdev.mpf.config.Database.DbConfig
import skunk.Session

object Main extends IOApp.Simple {

  // TODO finish
  def run: IO[Unit] =
    val r = 
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
      yield ()

}
