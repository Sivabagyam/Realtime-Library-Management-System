import { useState } from "react";
import "../styles/Home.css"
import {Link} from 'react-router-dom'
function Navbar(){
     const [aria,setAria] = useState(false);
    function arias(){
      setAria(!aria);

    }
   return ( <nav className=" home-navbar ">
    
  
   
  <div className="left">
     
         <span className="nav-item mx-5">
          <Link to='/' className="nav-home" >
            <i className="bi bi-house-heart-fill me-2"></i>
            <span>Home</span>
             </Link>
        </span>
       
        </div>
          <div className="center"> 
      <form className="d-flex search-form" role="search">
        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
        <button className="search-button" type="submit">Search</button>
      </form>
      </div>
        
  
      <button
      className="navbar-toggler"
      
    
      
    
      
      onClick={arias}
      ><i className="bi bi-list"></i></button>
        
  <div className="right">
    <ul className={aria?"nav-links active":"nav-links"}>
        <li className="nav-item mx-5">
          <Link to='/login' className="nav-link" >
           
            <span>Community</span>
             </Link>
        </li>
        <li className="nav-item mx-5">
           <Link to='/login' className="nav-link" >
           
            <span>WishList</span>
             </Link>
        </li>
        
        <li className="nav-item mx-5">
          <Link to='/profile' className="nav-link" >
           
           <i class="bi bi-person-circle"></i>
             </Link>
          
        </li>
      
      
        
       </ul>    
       
  </div>
        
      
    
    
  
</nav>
   );
}
export default Navbar;