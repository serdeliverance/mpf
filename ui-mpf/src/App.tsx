import React from 'react';
import {
  AppBar,
  Button,
  IconButton,
  Toolbar,
} from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';

function App() {
  return (
    <>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" color="inherit">
            <MenuIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
      <Button variant="contained" color="primary">Hello world!</Button>
    </>
  );
}

export default App;
