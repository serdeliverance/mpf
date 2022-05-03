package domain.entities

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import io.github.sdev.mpf.domain.entities.Account
import stubs.AccountStubs
import cats.data.NonEmptyList
import cats.data.Validated.Valid
import io.github.sdev.mpf.domain.entities.UserIdIsInvalid
import cats.data.Validated.Invalid
import io.github.sdev.mpf.domain.entities.InitialAmountNotPositive

class AccountValidatorSpec extends AnyFlatSpec with Matchers with AccountStubs:

  it should "return valid account" in {
    val result = validAccount.toValidated
    result mustBe Valid(validAccount)
  }

  it should "return invalid userId" in {
    val result = simpleReasonInvalidAccount.toValidated
    result mustBe Invalid(NonEmptyList(UserIdIsInvalid, Nil))
  }

  it should "return accumulated invalid results" in {
    val result = multipleReasonsInvalidAccount.toValidated
    result match
      case Invalid(nel) => nel.toList mustBe List(UserIdIsInvalid, InitialAmountNotPositive)
      case _            => fail("multiple account validation error expected")
  }
