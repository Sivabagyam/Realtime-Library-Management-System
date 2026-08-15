import React from 'react'
import "../styles/profile.css"

function Profilemain() {
  return (
    <div className="d-flex main">
        <div className="w-50 my-3 mx-3">
               <h3>Sivabagyam</h3>
               <p>I am a active book reader and love to read book and have completed thousands of book and hahahaha</p>
               <button className="btn btn-primary " ><i className="bi bi-pencil m-1 "></i>Edit Profile</button>
        </div>
      <div className=" d-flex mx-5 my-5">
         <div >
            
             <div className="d-flex ">
               <div>
                   <i class="bi bi-person-lines-fill mx-2"></i>
               </div>
                <div>
                    <p>Member ID</p>
                    <p>memberno</p>
                </div>
          </div>
           <div className="d-flex ">
                <div>
                   <i class="bi bi-envelope mx-2"></i>
                </div>
                 <div>
                    <p>Email</p>
                    <p>sivabagyam@gmail.com</p>
                </div>
          </div>
           <div className="d-flex ">
                <div>
                   <i class="bi bi-telephone mx-2"></i>
               </div>
                <div>
                   <p>Phone</p>
                  <p>9976051810</p>
                </div>
            </div>
         </div>
           <div className="mx-5" >
            
             <div className="d-flex ">
               <div>
                  <i class="bi bi-calendar mx-2"></i>
               </div>
                <div>
                    <p>Joined Date</p>
                    <p>15-09-2004</p>
                </div>
          </div>
           <div className="d-flex ">
                <div>
                  <i class="bi bi-geo-alt mx-2"></i>
                </div>
                 <div>
                    <p>Location</p>
                    <p>Jayankondam</p>
                </div>
          </div>
          
         </div>
         
      </div>
     

       
    </div>
  )
}

export default Profilemain