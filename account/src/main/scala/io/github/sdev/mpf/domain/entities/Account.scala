package io.github.sdev.mpf.domain.entities

import java.time.OffsetDateTime

case class Account(
    name: String,
    description: Option[String],
    userId: Long,
    initialAmount: BigDecimal,
    createdAt: OffsetDateTime,
    id: Option[Long] = None
)
