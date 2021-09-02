import express from 'express'
import { expenses } from './mocks/expenses'
import cors from 'cors'
import dotenv from 'dotenv'

dotenv.config()

const app = express()

const router = express.Router()

app.use(express.json())
app.use(cors)

const port = process.env.SERVER_PORT

router.get('/expenses', (req, res) => {
    console.log('here')
    return res.status(200).send(expenses)
})

app.use('/api/v1', router)

app.listen(port, () => console.log(`listening on port: ${port}`))