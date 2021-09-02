const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const dotenv = require('dotenv')

const expenses = require('./mocks/expenses')

dotenv.config()

const app = express()

app.use(cors())

app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

const port = process.env.SERVER_PORT

app.get('/api/v1/expenses/:userId', (req, res) => {
    res.status(200).send(expenses)
})

app.listen(port, () => console.log(`listening on port: ${port}`))