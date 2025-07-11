import React, { useState, useEffect } from 'react';
import { listEmployees } from '../services/EmpService';
import { useNavigate } from 'react-router-dom';

function ListEmpComp() {

    const [employees, setEmployees] = useState([]);

    const navigator = useNavigate();
 
    useEffect(() => {
        listEmployees()
            .then((response) => {
                setEmployees(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    function addNewEmployee() {
        navigator('/add-employee');
    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`);
    }

    return (
        <div className='container'>
            <h2 className='text-center'>List Of Employees</h2>
            <button type="button" className="btn btn-primary mb-2" onClick={addNewEmployee}>
                Add Employee
            </button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee) => (
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default ListEmpComp;
