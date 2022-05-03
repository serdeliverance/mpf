package io.github.sdev.mpf.application

import io.github.sdev.mpf.domain.usecases.CreateAccountUseCase
import io.github.sdev.mpf.domain.Account
import io.github.sdev.mpf.application.ports.out.AccountRepository
import cats.data.Validated
import cats.data.NonEmptyList
import cats.data.Validated.Valid
import cats.data.Validated.Invalid
import cats.ApplicativeError

class CreateAccountService[F[_]](accountRepository: AccountRepository[F])(implicit ae: ApplicativeError[F, String])
    extends CreateAccountUseCase[F]:

  // TODO account validation
  // TODO persist into repository
  override def createAccount(account: Account): F[Account] =
    validate(account) match
      case Valid(account)     => accountRepository.save(account)
      case Invalid(errorList) => ae.raiseError(errorList.toString) // TODO look for cleanest way to consolidate errors

  // TODO implement and move to another package
  private def validate(account: Account): Validated[NonEmptyList[ValidationError], Account] = ???

  // TODO implement and move to another package
  trait ValidationError:
    def message(): String
