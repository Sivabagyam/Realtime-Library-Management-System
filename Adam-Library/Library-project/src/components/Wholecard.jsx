 import useFetch from "../useFetch";
 import {useParams} from "react-router-dom"
 import '../styles/Home.css'
 function Wholecard(){
  const {id}= useParams();
    const data=useFetch("http://localhost:8080/library/getbooks/"+id);
    
  
       
        return (  
           
          <div className="d-flex">
               <div className="wholecard w-50 mx-5 my-5 d-flex">             
                    <img src={data.bookImage} className="card-img-top w-50" alt="..."/>
                    <i className="bi bi-heart wish mx-3"></i>
        
           
            
           </div>
 <div className="wholecard-body w-50 m-5">
    <h5 className="wholecard-title">{data.bookTitle}</h5>
    <p className="wholecard-text">A book by {data.bookAuthor}</p>
    <p className="wholecard-text1">{data.bookDescription}</p>
    <p className="wholecard-category d-flex"><h6>Category:</h6><p>{data.bookCategory}</p></p>
   <h5>₹{data.bookPrice}</h5>
   <button className="btn btn-primary m-2">Buy Now at ₹{data.bookPrice}</button>
   <button className="btn btn-primary m-2">Borrow Now</button>
  </div></div>

  
  
  
       );

}
export default Wholecard;