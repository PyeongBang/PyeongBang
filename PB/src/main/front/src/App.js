import logo from './logo.svg';
import React, {useState, useEffect} from "react";
import './App.css';

function App() {
  const [message, setMessage] = useState("");

  useEffect(()=>{
      fetch('/home')
          .then(response => response.text())
          .then(message =>{
          setMessage(message);
          });
      },[])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo"/>
          <hi className="App-title">{message}</hi>
      </header>
        <p className="App-intro">
            To get started, edit <code>src/App.js</code> and save to reload
        </p>
    </div>
  );
}

export default App;
