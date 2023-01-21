package io.github.sdev.mpf.adapter

import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.semiauto.*

import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome

object JsonCodecs:

  given encoderIncome: Encoder[Income] = deriveEncoder
  given decoderIncome: Decoder[Income] = deriveDecoder

  given decoderOutcome: Encoder[Outcome] = deriveEncoder
  given encoderOutcome: Decoder[Outcome] = deriveDecoder
