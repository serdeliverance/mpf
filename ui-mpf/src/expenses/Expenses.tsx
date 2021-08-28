import {
  Table,
  TableCell,
  TableHead,
  TableRow,
} from '@material-ui/core';

import React from 'react';

function Expenses() {
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
