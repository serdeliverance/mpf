package io.github.sdev.mpf.application.ports.out

import io.github.sdev.mpf.domain.Account

trait AccountRepository[F[_]]:
  def save(account: Account): F[Account]
