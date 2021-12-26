import React, {useState, useEffect, Component} from 'react';
import './App.css';
import List from './components/List';
import Demo from './components/demo';
import Header from './components/Header';
import Content from "./pages/Content";
import Main from "./pages/Main";
import Register from "./pages/Register";
import axios from "axios";
import Estates from './components/Estates';
import Detail from './pages/Detail';
import Board from "./pages/Board";

class App extends Component{
    render(){
        return (
            <React.Fragment>
                <Board/>
            </React.Fragment>
        );
    }
}
export default App;