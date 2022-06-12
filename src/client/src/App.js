import './App.css';

import HomepageComponent from "./Components/HomepageComponent";


import UserLoginComponent from "./Components/UserLogin/UserLoginComponent";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';



function App() {
    return (
        <div className="App-main">
            <Router>
                    <Switch>
                        <Route exact path="/" component={HomepageComponent}/>
                        <Route path="/login" component={UserLoginComponent}/>
                        <HomepageComponent/>
                    </Switch>
            </Router>
        </div>

    );
}

export default App;
