package stubs

import io.github.sdev.mpf.domain.entities.Account
import java.time.OffsetDateTime

trait AccountStubs:
  val validAccount = Account("n26-23", None, 34, 23, OffsetDateTime.now, Some(2))

  val simpleReasonInvalidAccount = validAccount.copy(userId = -1)

  val multipleReasonsInvalidAccount = simpleReasonInvalidAccount.copy(initialAmount = -500)
