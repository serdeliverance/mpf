package io.github.sdev.mpf.application

import io.github.sdev.mpf.domain.usecases.CreateAccountUseCase
import io.github.sdev.mpf.domain.entities.Account
import io.github.sdev.mpf.application.ports.out.AccountRepository
import cats.ApplicativeError
import cats.data.Validated.Valid
import cats.data.Validated.Invalid

class CreateAccountService[F[_]](accountRepository: AccountRepository[F])(implicit ae: ApplicativeError[F, String])
    extends CreateAccountUseCase[F]:

  override def createAccount(account: Account): F[Account] =
    account.toValidated match
      case Valid(account)     => accountRepository.save(account)
      case Invalid(errorList) => ae.raiseError(errorList.toString) // TODO look for cleanest way to consolidate errors
