import React from 'react';
import NavBar from './components/NavBar';
import Expenses from './components/Expenses';
import Charts from './components/Charts';
import Footer from './components/Footer';

function App() {
  return (
    <>
      <NavBar />
      <Expenses />
      <Charts />
      <Footer />
    </>
  );
}

export default App;
