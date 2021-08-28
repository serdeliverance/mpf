import React from 'react';
import NavBar from './navbar/NavBar';
import Expenses from './expenses/Expenses';
import Charts from './charts/Charts';
import Footer from './footer/Footer';

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
