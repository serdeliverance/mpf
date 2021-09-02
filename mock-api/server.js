const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const dotenv = require('dotenv')

const expenses = require('./mocks/expenses')
const { apiRouter } = require('./api')

dotenv.config()

const app = express()

const port = process.env.SERVER_PORT

// middlewares
app.use(cors())
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

app.use('/api/v1', apiRouter)

app.listen(port, () => console.log(`listening on port: ${port}`))