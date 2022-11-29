package io.github.sdev.mpf.adapter.out.migration

import cats.effect.IO
import io.github.sdev.mpf.config.Database.DbConfig

object Migrator:

    def initializeDb(dbConfig: DbConfig): IO[Unit] = ???