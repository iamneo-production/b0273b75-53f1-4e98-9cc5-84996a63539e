

import React from "react";
import { BrowserRouter as Router, Routes, Navigate, Route } from "react-router-dom";
import Login from "./component/login";
import Signup from "./component/signup";

function App() {
	return (
		<div className="App">
			<Router>
				<Routes>
					<Route exact path="/" element={<Navigate to="/login" />} />
					<Route exact path="/login" element={<Login />} />
					<Route exact path="/signup" element={<Signup />} />
				</Routes>
			</Router>
		</div>

	);
}

export default App;
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from "./components/pages/home";

import logout from "./components/pages/logout";
import NotFound from "./components/pages/NotFound";
import AddUser from "./components/users/AddUser";
import EditUser from "./components/users/EditUser";
import Navbar from "./components/layout/Navbar";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";


function App(){
  return (
    <Router>
       <div className="App">
      <Navbar />
      <Switch>
        <Route exact path="/" component={Home}/>
        <Route exact path="/logout" component={logout}/>
        <Route exact path="/users/add" component={AddUser}/>
        <Route exact path="/users/edit/:id" component={EditUser} />
        <Route component={NotFound} />
     
      </Switch>    
    </div>
    </Router>
   
  )
}

export default App;
