import React from "react";
import { BrowserRouter as Router, Routes, Navigate, Route } from "react-router-dom";
import Login from "./component/login";
import Signup from "./component/signup";
import Home from "./component/home";

function App() {
	return (
		<div className="App">
			<Router>
				<Routes>
					<Route exact path="/" element={<Navigate to="/login" />} />
					<Route exact path="/login" element={<Login />} />
					<Route exact path="/signup" element={<Signup />} />
					<Route exact path="/home" element={<Home />} />
				</Routes>
			</Router>
		</div>

	);
}

export default App;