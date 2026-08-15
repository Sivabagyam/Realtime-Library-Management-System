import React from 'react'
import "../styles/profile.css"

function Profilesearch() {
  return (
    <div className="d-flex flex-row align-items-center prosearch my-3">
        
          <form className="w-50 m-3 d-flex" role="search">
        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
        <button className="btn btn-outline-success" type="submit">Search</button>
      </form>
        
      <i className="bi bi-bell ms-auto mx-5 bell fs-5"></i>
     <i class="bi bi-person-circle mx-5 fs-5"></i>
    </div>
   
   
  )
}

export default Profilesearch