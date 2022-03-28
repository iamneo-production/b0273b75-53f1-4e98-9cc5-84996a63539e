import { fontSize } from '@mui/system';
import React from 'react';
import { useForm } from 'react-hook-form';
import { Link } from "react-router-dom";
import './login.css'

function Login() {
    return (
        <div style={myStyle}>
            <div style={{ display: "flex", height: "100vh" }}>
                <div style={{ height: "100vh", display: "flex", justifyContent: "center", alignItems: "center", width: "75%", }}>

                    <p className=""><h1 style={{ color: "black" ,fontSize:"60px", }} ><strong>Remote Hire</strong></h1></p>
                </div>
                <center style={{ height: "100vh", display: "flex", justifyContent: "center", alignItems: "center", width: "50%", }}>
                    <div className="colors" style={{ display: "flex", flexDirection: "column",  padding: "50px", borderRadius: "10px" }}>

                        <h2 style={{ color: "black" , fontSize:"25px" }}>Login</h2><br></br>
                        <div class="text">
                            <a><p>Please sign in to continue</p></a>
                        </div>  

                        <form method="post">
                        <div class="txt_field" id='email'>
                            <input type="text" required></input>
                            <span></span>
                            <label>Email or username</label>
                        </div>
                        <div class="txt_field" id='password'>
                            <input type="password" required></input>
                            <span></span>
                         <label>Password</label>
                        </div>
                            < input type="submit" value="Login" classname ="login"></input>
                        <div class="signup_link">
                            New here?<a><Link to="/signup">Click to signup</Link></a>
                        </div>
                        </form>
                    </div>
                </center>
            </div>
        </div>
    );
}

const myStyle = {
    backgroundImage:
        "url('https://drive.google.com/uc?export=download&id=1uKvZY6-os_GEjvrWVEr4h0D4AtN2r1LB')",
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};

export default Login;