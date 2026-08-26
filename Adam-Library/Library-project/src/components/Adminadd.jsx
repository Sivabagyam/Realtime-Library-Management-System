 import React from 'react'
import { useState } from 'react';
import axios from 'axios';
function Adminadd() {
  const [bookTitle,setBookTitle]=useState("");
   const [bookAuthor,setBookAuthor]=useState("");
   const[bookCapacity,setBookCapacity]=useState(0);
    const[bookImage,setBookImage]=useState("");
     const[bookCategory,setBookCategory]=useState("");
      const[bookDescription,setBookDescripton]=useState("");
       const[bookPrice,setBookPrice]=useState(0);
function handleTitle(event){
   setBookTitle(event.target.value);
}
function handleAuthor(event){
  setBookAuthor(event.target.value);
}
function handleCapacity(event){
  setBookCapacity(event.target.value);
}
function handleImage(event){
  setBookImage(event.target.value);
}
function handleCategory(event){
  setBookCategory(event.target.value);
}
function handleDescription(event){
  setBookDescripton(event.target.value);
}
function handlePrice(event){
  setBookPrice(event.target.value);
}


  function add(){
  axios.post('http://localhost:8080/library/addbooks',{
    "bookTitle":bookTitle,
    "bookAuthor":bookAuthor,
    "bookCapacity":bookCapacity,
    "bookImage":bookImage,
    "bookCategory":bookCategory,
    "bookDescription":bookDescription,
    "bookPrice":bookPrice
  })
  .catch((error)=>console.log(error))
  }
  return (
   <div className="d-flex justify-content-center">
     <div className="adminadd card m-4 w-50"> 
       
        <label className="label mx-3" >Book Title</label>
            <input type="text" name="bookTitle" value={bookTitle} onChange={handleTitle} className="form-control mx-5 my-3 w-75 input" placeholder="Enter the book name"></input>
        <label className="label mx-3">Book Author</label>
            <input type="text" name="bookAuthor"  value={bookAuthor} onChange={handleAuthor} className="input form-control  mx-5 my-3 w-75 " placeholder="Enter the Author name"></input>
         <label className="label mx-3">Book Capacity</label>
             <input type="text" name="bookCapacity"  value={bookCapacity} onChange={handleCapacity} className="form-control  mx-5 my-3 w-75 input" placeholder="Enter the availability of the book "></input>
        <label className="label mx-3">Book Image</label>
             <input type="text" name="bookImage"  value={bookImage} onChange={handleImage}  className="form-control  mx-5 my-3 w-75 input" placeholder="Enter the image urlof the book"></input>
       <label className="label mx-3">Book Category</label>
             <input type="text" name="bookCategory" value={bookCategory} onChange={handleCategory} className="form-control  mx-5 my-3 w-75 input" placeholder="Enter the category of the book"></input>
       <label className="label mx-3">Book Description</label>
             <input type="text" name="bookDescription"  value={bookDescription}  onChange={handleDescription} className="form-control  mx-5 my-3 w-75 input" placeholder="Give a short description"></input>
      <label className="label mx-3">Book Price</label>
             <input type="text" name="bookPrice"   value={bookPrice}  onChange={handlePrice} className="form-control  mx-5 my-3 w-75 input" placeholder="Enter the price of the book"></input>
             <button  className="btn btn-primary ms-auto" onClick={add}>Add</button>
        
    </div>
   </div>
  )
}

export default Adminadd