import { Request, Response } from 'express'
import { expenses } from './mocks/expenses'

const express = require('express')
const app = express()

app.use(express.json())

const port = 5000

app.get('/expenses', (req: Request, res: Response) => {
    return res.status(200).send(expenses)
})

app.listen(port, () => console.log(`listening on port: ${port}`))