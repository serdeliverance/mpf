package io.github.sdev.mpf.domain

case class Budget(month: Int, year: Int, ins: List[Income] = List.empty, outs: List[Outcome] = List.empty):
    def totalIncome(): BigDecimal = ins.map(_.amount).sum

    def totalOutcome(): BigDecimal = outs.map(_.amount).sum

object Budget:

    def basicIncome(salary: BigDecimal, bank: BigDecimal, hand: BigDecimal, others: List[Income] = List.empty): List[Income] =
        List(Income("salary", salary), Income("bank", bank), Income("hand", hand)) ++ others

    def basicOutcome(self: BigDecimal, food: BigDecimal, transport: BigDecimal, learning: BigDecimal, travel: BigDecimal, entertainment: BigDecimal, house: BigDecimal, others: List[Outcome] = List.empty): List[Outcome] =
        List(Outcome("self", self), Outcome("food", food), Outcome("transport", transport) ,Outcome("learning", learning) ,Outcome("travel", travel),Outcome("entertainment", entertainment), Outcome("house", house)) ++ others
