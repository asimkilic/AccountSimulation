
import './App.css';
import {Component} from "react";
import Customer from "./Customer";
import Account from "./Account";
import {BrowserRouter as Router,Route,Switch} from "react-router-dom";

class App extends Component {

    render(){
        return(
            <Router>
                <Switch>
                    <Route path='/' exact component={Customer} />
                    <Route path='/account/:id' exact component={Account} />
                </Switch>
            </Router>
        )
    }

}

export default App;