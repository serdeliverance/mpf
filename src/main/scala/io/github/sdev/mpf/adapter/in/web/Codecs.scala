package io.github.sdev.mpf.adapter.in.web

import io.circe.Encoder
import io.github.sdev.mpf.domain.Budget
import io.circe.generic.semiauto.deriveEncoder
import io.github.sdev.mpf.domain.Outcome
import io.github.sdev.mpf.domain.Income

object Codecs:

  given incomeEncoder: Encoder[Income]   = deriveEncoder
  given outcomeEncoder: Encoder[Outcome] = deriveEncoder
  given budgetEncoder: Encoder[Budget]   = deriveEncoder
