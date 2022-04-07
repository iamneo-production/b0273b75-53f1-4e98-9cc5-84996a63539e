import React from "react";
import {Link,NavLink} from "react-router-dom";


const Navbar=()=>{
    return(
        
     <nav className="NavbarItems">
       <h3 className="navbar-logo">Remote hire <i class="fa-solid fa-magnifying-glass"></i></h3>
       <div className="menu-icons">

       </div>
       <ul className="nav-menu">
         <li>
           <NavLink className="nav-links" exact to="/"><b>Home</b></NavLink>
         </li>
         <li>
           <NavLink className="nav-links" exact to="/logout"><b>Logout</b></NavLink>

         </li>
   
         
       </ul>
       <div> <Link className="btn btn-outline-light" to="/users/add">AddUser</Link></div>
       
  
     </nav>
    

    )
}



export default Navbar;