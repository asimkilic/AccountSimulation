import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
    state = {
        customer: {
            accounts: []
        }
    };

    async componentDidMount() {
        const response = await fetch('/v1/customer/a9328a57-f326-4ad1-bac9-c0ab9fb3d946');
        const body = await response.json();
        this.setState({customer: body});
    }

    render() {
        const {customer} = this.state;
        console.log(customer);
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <div className="App-intro">
                        <h2>Customer</h2>
                        {
                            <div key={customer.id}>
                                {customer.name} {customer.surname}
                                { customer.accounts.map(acc =>
                                        (<>{acc.id}, {acc.balance} </> )

                                )}
                            </div>
                        }
                    </div>
                </header>
            </div>
        );

    }

}

export default App;

