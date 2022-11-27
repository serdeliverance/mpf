package io.github.sdev.mpf.domain

import Budget._

class BudgetSpec extends munit.FunSuite {

    test("total income calculation") {
        val budget = Budget(12, 2022, ins = basicIncome(3000, 200, 50))

        val result = budget.totalIncome()

        assertEquals(result, BigDecimal(3250))
    }

    test("total outcome calculation") {
        val budget = Budget(12, 2022, outs = basicOutcome(120, 500, 60, 15, 200, 200, 20))

        val result = budget.totalOutcome()

        assertEquals(result, BigDecimal(1115))
    }

}