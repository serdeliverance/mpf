const { Router } = require('express')
const { expensesRouter } = require('./expenses')

const apiRouter = Router()

apiRouter.use('/expenses', expensesRouter)

module.exports = {
    apiRouter
}