package io.github.sdev.mpf.domain.entities

import cats.data.Validated
import cats.data.NonEmptyList
import cats.data.Validated.Invalid
import cats.data.Validated.Valid
import cats.implicits._
import java.time.OffsetDateTime

object AccountValidator:

  type ValidationResult[T] = Validated[NonEmptyList[AccountValidation], T]

  private def validateName(name: String): ValidationResult[String] =
    if (name.nonEmpty) name.validNel else NameIsEmpty.invalidNel

  private def validateUserId(userId: Long): ValidationResult[Long] =
    if (userId > 0) userId.validNel else UserIdIsInvalid.invalidNel

  private def validateInitialAmount(initialAmount: BigDecimal): ValidationResult[BigDecimal] =
    if (initialAmount > 0) initialAmount.validNel else InitialAmountNotPositive.invalidNel

  private def validateCreatedAt(createdAt: OffsetDateTime): ValidationResult[OffsetDateTime] =
    if (createdAt.isBefore(OffsetDateTime.now)) createdAt.validNel else CreationDateIsInvalid.invalidNel

  def validate(account: Account): ValidationResult[Account] =
    (
      validateName(account.name),
      validateUserId(account.userId),
      validateInitialAmount(account.initialAmount),
      validateCreatedAt(account.createdAt)
    )
      .mapN((_, _, _, _) => account)
