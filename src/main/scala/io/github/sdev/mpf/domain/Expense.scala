package io.github.sdev.mpf.domain

case class Expense(content: String, description: Option[String], where: Option[String], category: ExpenseCategory, amount: BigDecimal)