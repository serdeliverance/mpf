const { Router } = require('express')
const { expenses } = require('../mocks/expenses')

const expensesRouter = Router()

expensesRouter.get('/:userId', (req, res) => res.status(200).send(expenses))

module.exports = {
    expensesRouter
}