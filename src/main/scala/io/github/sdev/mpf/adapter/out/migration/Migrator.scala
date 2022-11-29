package io.github.sdev.mpf.adapter.out.migration

import cats.effect.IO
import io.github.sdev.mpf.config.Database.DbConfig
import org.flywaydb.core.Flyway

object Migrator:

    def initializeDb(dbConfig: DbConfig): IO[Unit] =
        IO.delay {
            val fw = Flyway
                .configure()
                .dataSource(dbConfig.url, dbConfig.user, dbConfig.password)
                .load()
            fw.migrate()
        }
        .as(())