import { useForm } from 'react-hook-form';
import { Link } from "react-router-dom";
import './signup.css'

function Signup() {
    return (
        <div style={myStyle}>
            <div style={{ display: "flex", height: "100vh" }}>
                <div style={{ height: "100vh", display: "flex", justifyContent: "center", alignItems: "center", width: "75%", }}>

                    <p className=""><h1 style={{ color: "black" ,fontSize:"60px" }} ><strong>Remote Hire</strong></h1></p>
                </div>
                <center style={{ height: "100vh", display: "flex", justifyContent: "center", alignItems: "center", width: "50%", }}>
                         <div className="color" style={{ display: "flex", flexDirection: "column",  padding: "30px", borderRadius: "25px" }}> 

                        <h2 className='signup' style={{ color: "black" ,fontSize:"25px", }}>Sign Up</h2><br></br>
                          <div class="text">
                             <a><p>Please enter all your details to continue</p></a>
                          </div>  
                      <form method="post">
                      <div class="txt_field" id='Enter Email'>
                    <input type="text" required></input>
                    <span></span>
                    <label>Enter Email</label>
                </div>
                <div class="txt_field" id='Username'>
                    <input type="text" required></input>
                    <span></span>
                    <label>Enter Username</label>
                </div>
                <div class="txt_field" id='MobileNumber'>
                    <input type="number" required></input>
                    <span></span>
                    <label>Enter Mobilenumber</label>
                </div>
                <div class="txt_field" id='Paasword' >
                    <input type="password" required></input>
                    <span></span>
                    <label>password</label>
                </div>
                <div class="txt_field"id='Confirm Password'>
                    <input type="password" required></input>
                    <span></span>
                    <label>Confirm Password</label>
                </div>
                <input type="submit" value="Sign up"></input>
                <div class="signup_link">
                    Have an account?<a>< Link to="#">sign in </Link></a>
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

export default Signup;