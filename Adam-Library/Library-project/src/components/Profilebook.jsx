import React from 'react'
import "../styles/profile.css"

function Profilebook() {
  return (
    <div className="d-flex my-3">

           <div className="w-25 profile-card mx-3 p-3 d-flex">
                <div>
                     <i className="bi bi-book fs-1"></i>
                </div>
                <div className="mx-4 my-4">
                    <h4>2</h4>
                    <p>Currently Borrowed</p>
                    <small>View Details  <i className="bi bi-arrow-right "></i></small>
                </div>
           </div>

           <div className="w-25 profile-card mx-3 p-3 d-flex ">
                  <div>
                       <i className="bi bi-check-square fs-1"></i>
                  </div>
                  <div className="mx-4 my-4">
                        <h4>8</h4>
                        <p>Book Returned</p>
                        <small>View History  <i className="bi bi-arrow-right "></i></small>
                  </div>
           </div>

           <div className="w-25 profile-card mx-3 p-3 d-flex">
                  <div>
                       <i className="bi bi-clock fs-1"></i>
                  </div>
                  <div className="mx-4 my-4">
                       <h4>1</h4>
                       <p>Reserved Books</p>
                       <small>View Details  <i className="bi bi-arrow-right "></i></small>
                  </div>
           </div>

           <div className="w-25 profile-card mx-3 p-3 d-flex">
                  <div>
                       <i className="bi bi-bookmark fs-1 "></i>
                  </div>
                  <div className="mx-4 my-4">
                         <h4>0</h4>
                         <p>Pending Fine</p>
                         <small>Pay Fines  <i className="bi bi-arrow-right "></i></small>
                  </div>
          </div>


    </div>
  )
}

export default Profilebook