import React from 'react'
import {
  Box,
  makeStyles,
} from '@material-ui/core'

const useStyles = makeStyles(() => ({
  footer: {
    bottom: 0,
    position: 'fixed',
    width: '100%',
  },
}))

function Footer() {
  const classes = useStyles()

  return (
    <footer className={classes.footer}>
      <Box bgcolor="primary.main" color="white">
        <Box textAlign="center" pt={{ xs: 4, sm: 10 }} pb={{ xs: 4, sm: 5 }}>
          serdeliverance&reg;
          {new Date().getFullYear()}
        </Box>
      </Box>
    </footer>
  )
}

export default Footer
