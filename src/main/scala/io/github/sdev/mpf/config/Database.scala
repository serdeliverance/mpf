package io.github.sdev.mpf.config

import cats.effect.{IO, Resource}
import skunk.Session
import skunk.implicits._
import skunk.codec.text._

object Database:
    case class DbConfig(url: String, user: String, password: String)

    def checkPostgresConnection(pool: Resource[IO, Session[IO]]): IO[Unit] =
        pool.use { session =>
            session
                .unique(sql"select version();".query(text))
                // TODO add logger library
                .map(v => println(s"Connected to Postgres $v"))    
        }