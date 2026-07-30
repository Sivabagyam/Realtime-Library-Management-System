import React, { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import useFetch from '../useFetch';
import '../styles/Admin.css'
import { useState } from 'react';
import axios from 'axios'

function Adminedit() {
    const {id}=useParams();
       const[edit,setEdit]=useState({});
    const book=useFetch('http://localhost:8080/library/getbooks/'+id);
    useEffect(()=>{
      if(book){
        setEdit(book);
      }
    },[book] );
 
    function HandleonChange(e){
      setEdit(prev=>({
        ...prev,
        [e.target.name]:e.target.value
      }))
    }
    const handleupdate=async()=>{
      axios.put("http://localhost:8080/library/updatebook/"+id,edit);
      alert("Changes saved Successfully");
    }
  
  return (
    book&&
    <div className="adminedit card ">
        <label className="label">Book Title</label>
        <input type="text" name="bookTitle" value={edit.bookTitle ||""} onChange={HandleonChange} className="form-control m-3"></input>
        <label className="label">Book Author</label>
        
        <input type="text" name="bookAuthor" value={edit.bookAuthor ||""} onChange={HandleonChange} className="form-control m-3"></input>
        <label className="label" >Book Category</label>
        <input type="text" name="bookCategory" value={edit.bookCategory ||""} onChange={HandleonChange} className="form-control m-3"></input>
        <label className="label">Book Description</label>
        <input type="text" name="bookDescription" value={edit.bookDescription||""} onChange={HandleonChange} className="form-control m-3"></input>
         <label className="label">Book Image</label>
        <input type="text" name="bookImage" value={edit.bookImage ||""} onChange={HandleonChange} className="form-control m-3"></input>
         <label className="label">Book Price</label>
        <input type="text" name="bookPrice" value={edit.bookPrice||""} onChange={HandleonChange} className="form-control m-3"></input>
          <label className="label">Book Capacity</label>
        <input type="text" name="bookCapacity" value={edit.bookCapacity||""} onChange={HandleonChange}className="form-control m-3"></input>
        <button className="ms-auto btn btn-primary"  onClick={handleupdate}>Save</button>

    </div>
   
  )
}

export default Adminedit