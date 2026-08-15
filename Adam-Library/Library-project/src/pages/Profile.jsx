import React from 'react'
import Profilesearch from '../components/Profilesearch'
import "../styles/profile.css"
import Profilemain from '../components/Profilemain'
import Profilebook from '../components/Profilebook'

function Profile() {
  return (
  <div>
 <Profilesearch/>
 <Profilemain/>
 <Profilebook/>
 </div>

  )
}

export default Profile