const expensesMock = require('./mocks/expenses')

const express = require('express')
const app = express()

const port = 5000

app.get('/expenses', (req: Request, res: Response) => {
    return JSON.parse(expensesMock.expenses)
})

app.listen(port, () => console.log(`listening on port: ${port}`))