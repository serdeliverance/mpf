package io.github.sdev.mpf.adapter.out

import io.github.sdev.mpf.application.port.out.persistence.BudgetRepository
import io.github.sdev.mpf.domain.Budget
import cats.effect.IO
import skunk._
import skunk.codec.all._
import skunk.circe.codec.json._
import skunk.implicits._
import io.github.sdev.mpf.domain.Income
import io.github.sdev.mpf.domain.Outcome
import skunk.Encoder
import io.circe.Json

class BudgetRepositoryImpl extends BudgetRepository:
  import SQL._
  // TODO
  def save(budget: Budget): IO[Budget] = ???

object SQL:

  val incomeCodec: Codec[Income] = ???
  val outcomeCodec: Codec[Outcome] = ???

  val listIncomeCodec: Codec[List[Income]] = ??? 
  val listOutcomeCodec: Codec[List[Outcome]] = ???  

  val codec: Codec[Budget] = (int4 ~ int4 ~ jsonb ~ jsonb).imap {
    case m ~ n ~ j1 ~ j2 => Budget(m, n, j1, j2) // TODO fix from here
  } (b => b.month ~ b.year ~ b.ins ~ b.outs)

  val insertCmd = sql"""
    INSERT INTO budget
    VALUES ($codec)
  """.command