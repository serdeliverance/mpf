package io.github.sdev.mpf.domain.usecases

import io.github.sdev.mpf.domain.entities.Account

trait GetAllAccountsUseCase[F[_]]:
  def getAllAccounts(): F[List[Account]]
