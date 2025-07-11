package net.akshitha.ems_backened.controller;

import lombok.AllArgsConstructor;
import net.akshitha.ems_backened.dto.EmployeeDto;
import net.akshitha.ems_backened.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee
    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee By Id
    @GetMapping("/id/{myId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("myId") Long employeeId){
        EmployeeDto employeeById = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeById);
    }

    //Build Get All Employees
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    //Build Update Employee REST API
    @PutMapping("/edit/{myId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("myId") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updatedEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build DELTE By Id REST API
    @DeleteMapping("/id/{myId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("myId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!");
    }
}
