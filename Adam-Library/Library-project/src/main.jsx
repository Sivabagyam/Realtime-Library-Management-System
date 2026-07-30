import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import Home from './pages/Home.jsx'
import Login from './pages/Login.jsx'
import {createBrowserRouter,RouterProvider} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'bootstrap-icons/font/bootstrap-icons.css';
import Wholecard from './components/Wholecard.jsx'
import Admindashnoard from './pages/Admindashnoard.jsx'
import Adminedit from './components/Adminedit.jsx'
const router=createBrowserRouter([
  {
  path:'/',
  element:<App/>,
  children:[{ 
  path:'/login',
  element:<Login/>
  

},

{
    index:true,
    element:<Home/>
  },
  {
    path:'/Wholecard/:id',
    element:<Wholecard/>
  },{
    path:'/admin',
    element:<Admindashnoard/>
  },{
    path:'/adminedit/:id',
    element:<Adminedit/>

  }
]

}]);
createRoot(document.getElementById('root')).render(
  
  <StrictMode>
  
    <RouterProvider router={router}/>
  </StrictMode>
)
