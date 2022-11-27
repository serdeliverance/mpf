package io.github.sdev.mpf.application.port.in

import cats.effect.IO
import io.github.sdev.mpf.domain.Balance

trait GetBalanceUseCase:
    def get(month: Int, year: Int): IO[Balance]