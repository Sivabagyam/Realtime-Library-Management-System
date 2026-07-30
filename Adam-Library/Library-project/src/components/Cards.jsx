import { useEffect } from "react";
import { useState } from "react";
import {useNavigate} from "react-router-dom"
import "../styles/Home.css"
import useFetch from "../useFetch";
import Wholecard from "./Wholecard";
function Cards(){
    const size=12;
    const cards =useFetch("http://localhost:8080/library/getpagebooks?page=0&size=12");
    const [page,setPage]=useState(0);
    const navigate =useNavigate();
  
    return(
        <div className="container">
        <div className="row">
       
        {cards.content?.map((book)=>(
          
           
          <div className="col-md-3" key={book.bookId}> <div className="card"  onClick={()=>{navigate('/Wholecard/'+book.bookId)}}>
  <img src={book.bookImage} className="card-img-top" alt="..."/>
  <div className="card-body">
    <h5 className="card-title">{book.bookTitle}</h5>
    <p className="card-text">A book by {book.bookAuthor}</p>
   <h5>₹{book.bookPrice}</h5>
  </div>
  
</div></div>

          
        ))}
      {[...Array(cards.totalPages).keys()].map((pages)=>
      <button className="rounded-circle pageno" onClick={()=>setPage(pages)}>
        {pages+1}
      </button>)
        
      }
      </div>
    

      </div>
   
);
   
}

export default Cards;