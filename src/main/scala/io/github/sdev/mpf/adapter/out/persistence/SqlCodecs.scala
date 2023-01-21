package io.github.sdev.mpf.adapter.out.persistence

import skunk.*
import skunk.codec.all.*
import skunk.circe.codec.json.*
import skunk.implicits.*
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome
import io.github.sdev.mpf.domain.Budget
import skunk._
import io.circe.generic.semiauto.*
import io.github.sdev.mpf.adapter.JsonCodecs.given

import io.github.sdev.mpf.adapter.JsonCodecs
object SqlCodecs:

  val codec: Codec[Budget] = (int4 ~ int4 ~ jsonb[List[Income]] ~ jsonb[List[Outcome]]).imap {
    case m ~ y ~ ins ~ outs => Budget(m, y, ins, outs)
  }(budget => budget.month ~ budget.year ~ budget.ins ~ budget.outs)

  val insertCmd = sql"""
    INSERT INTO budget
    VALUES ($codec)
  """.command
