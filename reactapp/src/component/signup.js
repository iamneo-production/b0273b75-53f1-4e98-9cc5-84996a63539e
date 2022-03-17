import React, { usesState } from "react";
import { Redirect } from 'react-router';
import { Link } from "react-router-dom";
import './signup.css';

function Signup() {
    
    return (
        <div>
            <center>
            <p className="App1"><h1 style={{ color: "white"}} ><strong>Remote Hire</strong></h1></p>
                    <h1 style={{ color: "Red" }}>Sign Up</h1>
                <form>
                    <input type="text" id="email" placeholder="Enter email" className="form-control" /><br />
                    <input type="text" id="username" placeholder="Enter Username" className="form-control" /><br />
                    <input type="text" id="moblieNumber"placeholder="Enter Mobilenumber" className="form-control" /><br />
                    <input type="text" id="password" placeholder="password" className="form-control" /><br />
                    <input type="text" id="confirmPassword" placeholder="Confirm Password" className="form-control" />
                    <br />
                    <button className="button-container" id="submitButton">Submit</button>
                </form>
            </center>    
        </div>
    );
}

export default Signup;