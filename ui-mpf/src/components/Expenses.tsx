import {
  Table,
  TableCell,
  TableHead,
  TableRow,
} from '@material-ui/core';

import React from 'react';

function Expenses() {

  async function getExpenses() {
    const response = await fetch('http://locahost:5000/api/v1/expenses', {
      method: 'GET'
    })
  }

  return (
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
    </Table>
  );
}

export default Expenses;
