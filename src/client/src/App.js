import './App.css';

import HomepageComponent from "./Components/HomepageComponent";
import UserLoginComponent from "./Components/UserLogin/UserLoginComponent";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import HeaderComponent from "./Components/Header/HeaderComponent";
import FooterComponent from "./Components/Footer/FooterComponent";

//

function App() {
    return (
        <div className="App-main">
            <Router>
            <HeaderComponent />
                <div className="container">
                    <Switch>
                        <Route exact path="/" component={HomepageComponent}/>
                        <Route path="/login" component={UserLoginComponent}/>
                        <HomepageComponent/>
                    </Switch>
                </div>
            <FooterComponent />
            </Router>
        </div>

    );
}

export default App;
