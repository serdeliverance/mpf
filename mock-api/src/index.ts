import express from 'express'
import { expenses } from './mocks/expenses'
import cors from 'cors'

const app = express()

const router = express.Router()

app.use(express.json())
app.use(cors)
app.use('/api/v1', router)


const port = 5000

router.get('/expenses/:userId', (req, res) => {
    return res.status(200).send(expenses)
})

app.listen(port, () => console.log(`listening on port: ${port}`))