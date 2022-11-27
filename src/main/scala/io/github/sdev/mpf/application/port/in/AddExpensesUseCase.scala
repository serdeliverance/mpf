package io.github.sdev.mpf.application.port.in

import io.github.sdev.mpf.domain.Expense
import cats.effect.IO

trait AddExpensesUseCase:

  def add(expenses: List[Expense]): IO[Unit]
