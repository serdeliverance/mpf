package io.github.sdev.mpf.domain.usecases

import io.github.sdev.mpf.domain.entities.Account

trait GetAccountUseCase[F[_]]:
  def getAccount(): F[Option[Account]]
