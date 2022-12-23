package io.github.sdev.mpf.adapter.out.persistence

import skunk._
import skunk.codec.all._
import skunk.circe.codec.json._
import skunk.implicits._
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome
import io.github.sdev.mpf.domain.Budget
import skunk.Encoder
import io.circe.Json
import io.circe.Decoder
import io.circe.parser.decode
import io.circe.syntax._
import io.circe.generic.semiauto._

object SqlCodecs:

  val incomeCodec: Codec[Income] = ???
  val outcomeCodec: Codec[Outcome] = ???

  val listIncomeCodec: Codec[List[Income]] = ??? 
  val listOutcomeCodec: Codec[List[Outcome]] = ???

  given decoderIncome: Decoder[Income] = ???
  given encoderIncome: Encoder[Income] = ???
  
  given decoderOutcome: Decoder[Outcome] = ???
  given encoderOutcome: Encoder[Outcome] = ???

  val codec: Codec[Budget] = (int4 ~ int4 ~ jsonb ~ jsonb).imap {
    case m ~ n ~ j1 ~ j2 => 
      val result = for 
        income <- j1.as[List[Income]]
        outcome <- j2.as[List[Outcome]]
      yield Budget(m, n, income, outcome)

      result match 
        case Right(budget) => budget
        // TODO convert to empty list just the one that fails and log it
        case _ => Budget(m, n, List.empty, List.empty) // TODO add logger info for parsing error
  } (b => b.month ~ b.year ~ b.ins.asJson ~ b.outs.asJson)

  val insertCmd = sql"""
    INSERT INTO budget
    VALUES ($codec)
  """.command