
import './App.css'
import ListEmpComp from './components/ListEmpComp'
import AddEmpComp from './components/AddEmpComp'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <>
    <BrowserRouter>
    <Routes>
      {/* http://localhost:3000 */}
      <Route path='/' element = {<ListEmpComp/>}></Route>
      {/* http://localhost:3000/employees */}
      <Route path='/employees' element = {<ListEmpComp/>}></Route>
       {/* http://localhost:3000/add-employee */}
       <Route path='/add-employee' element = {<AddEmpComp />}></Route>
       {/* http://localhost:3000/edit-employee/id */}
       <Route path='/edit-employee/:id' element = {<AddEmpComp />}></Route>
    </Routes>   
    </BrowserRouter>
    </>
  )
}

export default App