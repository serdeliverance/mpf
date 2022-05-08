package io.github.sdev.mpf.application

import io.github.sdev.mpf.domain.usecases.CreateAccountUseCase
import io.github.sdev.mpf.domain.entities.Account
import io.github.sdev.mpf.application.ports.out.AccountRepository
import cats.ApplicativeError
import cats.data.Validated.Valid
import cats.data.Validated.Invalid
import cats.data.NonEmptyList
import io.github.sdev.mpf.domain.entities.AccountValidation

class CreateAccountService[F[_]](accountRepository: AccountRepository[F])(implicit
    ae: ApplicativeError[F, NonEmptyList[AccountValidation]]
) extends CreateAccountUseCase[F]:

  override def createAccount(account: Account): F[Account] =
    account.toValidated match
      case Valid(account)     => accountRepository.save(account)
      case Invalid(errorList) => ae.raiseError(errorList) // TODO look for cleanest way to consolidate errors
