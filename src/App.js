import React from "react";
import { Route, Routes } from "react-router-dom";

import Header from "./header_and_footer/Header";
import Footer from "./header_and_footer/Footer";

import COVIDTrackerComponent from "./components/COVIDDataComponent";
import ReRouterComponent from './components/ReRouterComponent';

import '@fortawesome/fontawesome-free/css/all.min.css';  
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';


import './App.css';

const App = () => {

  return (

    <div>

      <header> <Header /> </header>

       <main>  </main>

       <div style={{ marginLeft: "10px" }} className="container">

        <Routes>

          <Route exact path="/" element={<ReRouterComponent />} />
          <Route exact path="/information/covid-data" element={<COVIDTrackerComponent />} />
          
        </Routes>

      </div>

      <footer> <Footer /> </footer>

    </div>

  );
  
}

export default App;
