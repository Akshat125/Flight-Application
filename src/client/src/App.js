import './App.css';

import HomepageComponent from "./Components/HomepageComponent";
import UserLoginComponent from "./Components/UserLoginComponent";
//routing is used to direct to a specific homepage depending on the path.
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import HeaderComponent from "./Components/HeaderComponent";
import FooterComponent from "./Components/FooterComponent";

function App() {
    return (
        <div className="App-main">
            <HeaderComponent />
            <Router>
                <div className="container">
                    <Switch>
                        <Route exact path="/" component={HomepageComponent}/>
                        <Route path="/login" component={UserLoginComponent}/>
                        <HomepageComponent/>
                    </Switch>
                </div>
            </Router>
            <FooterComponent />
        </div>

    );
}

export default App;
