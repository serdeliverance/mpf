import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Chip,
} from '@material-ui/core'

import React, { useState, useEffect } from 'react'
import Expense from '../domain/Expense'

import getExpenses from '../services/ExpenseService'

function Expenses() {
  const [expenses, setExpenses] = useState<Expense[]>([])

  useEffect(() => {
    const today = new Date()
    getExpenses(today.getMonth(), today.getFullYear())
      .then((expensesResp) => {
        setExpenses(expensesResp)
      })
      .catch((error) => {
        console.log(error)
      })
  }, [])

  return (
    <>
      <Table arial-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Category</TableCell>
            <TableCell>Subcategories</TableCell>
            <TableCell>Date</TableCell>
            <TableCell>Amount</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          { expenses && expenses.map((exp) => (
            <TableRow key={exp.id}>
              <TableCell component="th" scope="row">{exp.name}</TableCell>
              <TableCell align="right">{exp.description}</TableCell>
              <TableCell align="right">{exp.category}</TableCell>
              <TableCell align="right">
                { exp.subcategories.length > 0 ? exp.subcategories.map((cat: string) => <Chip label={cat} />) : '' }
              </TableCell>
              <TableCell align="right">{exp.date}</TableCell>
              <TableCell align="right">{exp.amount}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </>
  )
}

export default Expenses
