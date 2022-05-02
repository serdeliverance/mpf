package io.github.sdev.mpf.application

import io.github.sdev.mpf.domain.usecases.CreateAccountUseCase
import io.github.sdev.mpf.domain.Account

class CreateAccountService[F[_]] extends CreateAccountUseCase[F]:
  override def createAccount(account: Account): F[Account] = ???
