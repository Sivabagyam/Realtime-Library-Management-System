import "../styles/login.css";
import {Link} from 'react-router-dom';
function Login(){
    return(<>
    <div className="login-page">
      <div className="container">
         <div className="row align-items-center min-vh-100">
      <div className="col-md-6">
        <div className="login-card text-align-center ">
  
  <div className="card-body ">
   <h2 className="quotes">"A reader lives a thousand lives before he dies. The man who never reads lives only one."</h2>
   <h5 className="author">-George R.R Martin</h5>
  </div>
</div>
      </div>
    
    
<div className="col-md-6">
   <h2 className="head">Welcome to adams library</h2> 
<form className="login  ">
  <div className="mb-3">
    
   
    <label htmlfor="exampleInputEmail1" className="form-label">Email address</label>
    <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required/>
   
  </div>
  <div className="mb-3">
    <label htmlfor="exampleInputPassword1" className="form-label">Password</label>
    <input type="password" className="form-control" id="exampleInputPassword1" required/>
  </div>
   <div className="mb-3">
    <label htmlfor="exampleInputPassword1" className="form-label">Confirm Password</label>
    <input type="password" className="form-control" id="exampleInputPassword1" required/>
  </div>
  <div className="mb-3 form-check">
    <input type="checkbox" className="form-check-input" id="exampleCheck1" />
    <label className="form-check-label" htmlfor="exampleCheck1">I agree to share my details</label>
  </div>
 
  <button type="submit" className="btn btn-primary">Create Account</button>
   <div className="signup">Already Registered?<Link to='/'>login</Link></div>
</form>
  </div>
</div>
</div>
      </div>
     

</>);

}
export default Login;