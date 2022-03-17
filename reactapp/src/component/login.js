import React from 'react';
import { Link } from "react-router-dom";
import './login.css'

function Login() {
    return (
        <div className="App">
            <p className="App1" id="loginBox"><h1 style={{ color: "white"}} ><strong>Remote Hire</strong></h1></p>
            <center>
                <h2 style={{ color: "red"}}>Login</h2>
                <form>
                    <input type="text" id= "email" placeholder="Enter email" className="form-control" />
                    <br />
                    <input type="text" id= "password" placeholder="Enter password" className="form-control" />
                    <br />
                    <button className="button-container" id= "loginButton" >login</button><br />
                     <p className ="controler">New Users? <Link to="/signup" id="signupLink">signup</Link></p>
                     <p><Link to="/home">home</Link></p>
                </form>
            </center>
        </div>
    );
}
export default Login;



