package io.github.sdev.mpf.domain.entities

import io.github.sdev.mpf.domain.entities.Account
import cats.data.Validated
import cats.data.NonEmptyList

object AccountValidation:
  // TODO maybe add syntax to account
  // TODO implement
  def validate(account: Account): Validated[NonEmptyList[ValidationError], Account] = ???

  // TODO implement and move to another package
  trait ValidationError:
    def message(): String
