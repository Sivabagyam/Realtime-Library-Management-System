import React from 'react'
import useFetch from '../useFetch';
import axios from 'axios';
import {useNavigate} from 'react-router-dom'

function Adminbooklist() {
    const navigate=useNavigate();
  
   const booklists=useFetch("http://localhost:8080/library/getbooks");
   const Deletebook = async(id) => {
     axios.delete(`http://localhost:8080/library/deletebooks/${id}`);
   }
  
 return(
   <div>
    {
         booklists.length>0?(
        <div className="m-5 p-5"><table >
            <thead >
              <tr>
                  <th  className="p-3 border-1">BookName</th>
                <th  className="p-3 border-1">BookAuthor </th>
                <th  className="p-3 border-1">BookCapacity </th>
                <th  className="p-3 border-1">BookCategory</th>
                <th  className="p-3 border-1">BookPrice</th>
              </tr>
                
                </thead>
                <tbody >
                    {
                        booklists.map((book)=>(
                           <tr  key={book.bookId}>
                            <td className="p-3 border-1">
                                {book.bookTitle}
                            </td>
                            <td  className="p-3 border-1">
                                {book.bookAuthor}
                            </td>
                            <td  className="p-3 border-1">
                                {book.bookCapacity}
                            </td>
                            <td  className="p-3 border-1">
                                {book.bookCategory}
                            </td>
                            <td  className="p-3 border-1">
                                {book.bookPrice}
                            </td>
                            <td >
                                <button className="btn btn-primary m-3" onClick={()=>navigate('/adminedit/'+book.bookId)}>Edit</button>
                            </td>
                            <td>
                                <button className="btn btn-danger m-3" >Delete</button>
                            </td>

                           </tr>

                        ))
                    }
                </tbody>
                </table></div>
        ):(
       <div>Loading</div>
        )};
    
   </div>
 );

}
export default Adminbooklist