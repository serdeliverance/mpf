import { Request, Response } from 'express'
import { expenses } from './mocks/expenses'

const express = require('express')
const app = express()

app.use(express.json())

const port = 5000

// TODO parameterize api version to avoid harding it in every endpoint
app.get('/api/v1/expenses', (req: Request, res: Response) => {
    return res.status(200).send(expenses)
})

app.listen(port, () => console.log(`listening on port: ${port}`))