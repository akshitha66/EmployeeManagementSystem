import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

// GET all employees
export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL);
};

// POST - create new employee
export const createEmployee = (employee) => {
    return axios.post(REST_API_BASE_URL, employee);
};

// GET - get employee by ID
export const getEmployee = (employeeId) => {
    return axios.get(`${REST_API_BASE_URL}/id/${employeeId}`);
};

// PUT - update employee by ID
export const updateEmployee = (employeeId, employee) => {
    return axios.put(`${REST_API_BASE_URL}/edit/${employeeId}`, employee);
};

//Delete
export const deleteEmployee = (employeeId) => {
    return axios.delete(`${REST_API_BASE_URL}/delete/${employeeId}`, employeeId);
};