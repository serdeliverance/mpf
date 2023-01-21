package io.github.sdev.mpf.adapter.in.web.dto

import io.circe.Codec

object CreateBudgetDto:
  case class IncomeDto(concept: String, amount: BigDecimal) derives Codec.AsObject
  case class OutcomeDto(concept: String, amount: BigDecimal) derives Codec.AsObject
  case class CreateBudgetDto(userId: Int, month: Int, year: Int, ins: List[IncomeDto], outs: List[OutcomeDto])
      derives Codec.AsObject
