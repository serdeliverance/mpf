package io.github.sdev.mpf.domain.entities

import cats.data.Validated
import cats.data.NonEmptyList
import cats.data.Validated.Invalid
import cats.data.Validated.Valid
import cats.implicits._

object AccountValidator:

  type ValidationResult[T] = Validated[NonEmptyList[AccountValidation], T]

  extension [T](error: AccountValidation) def invalidResult: ValidationResult[T] = Invalid(NonEmptyList(error, Nil))

  extension [T](t: T) def validResult: ValidationResult[T] = Valid(t)

  private def validateName(name: String): ValidationResult[String] =
    if (name.nonEmpty) name.validResult else NameIsEmpty.invalidResult

  private def validateUserId(userId: Long): ValidationResult[Long] =
    if (userId > 0) userId.validResult else UserIdIsInvalid.invalidResult

  private def validateInitialAmount(initialAmount: BigDecimal): ValidationResult[BigDecimal] =
    if (initialAmount > 0) initialAmount.validResult else InitialAmountIsInvalid.invalidResult

  def validate(account: Account): ValidationResult[Account] =
    (validateName(account.name), validateUserId(account.userId), validateInitialAmount(account.initialAmount))
      .mapN((_, _, _) => account)
