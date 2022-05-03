package io.github.sdev.mpf.domain.entities

import io.github.sdev.mpf.domain.entities.Account
import cats.data.Validated
import cats.implicits._
import cats.data.NonEmptyList
import cats.data.Validated.Invalid
import cats.data.Validated.Valid

sealed trait AccountValidation:
  def errorMessage: String

case object NameIsEmpty extends AccountValidation:
  def errorMessage: String = "name cannot be empty"

case object UserIdIsInvalid extends AccountValidation:
  def errorMessage: String = "userId is not valid"

case object InitialAmountIsInvalid extends AccountValidation:
  def errorMessage: String = "Initial amount should be positive"
