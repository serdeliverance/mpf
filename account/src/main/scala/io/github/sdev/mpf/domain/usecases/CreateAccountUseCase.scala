package io.github.sdev.mpf.domain.usecases

import io.github.sdev.mpf.domain.Account

trait CreateAccountUseCase[F[_]]:
  def createAccount(account: Account): F[Account]