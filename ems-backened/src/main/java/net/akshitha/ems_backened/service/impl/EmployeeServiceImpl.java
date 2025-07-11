package net.akshitha.ems_backened.service.impl;

import lombok.AllArgsConstructor;
import net.akshitha.ems_backened.dto.EmployeeDto;
import net.akshitha.ems_backened.entity.Employee;
import net.akshitha.ems_backened.exceptions.ResourceNotFoundException;
import net.akshitha.ems_backened.mapper.EmployeeMapper;
import net.akshitha.ems_backened.repository.EmployeeRepo;
import net.akshitha.ems_backened.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("NO such Employee with Given ID : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepo.findAll();
        return allEmployees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updatedEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee updateEmployee = employeeRepo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("NO such Employee with Given ID : + employeeId")
        );

        updateEmployee.setFirstName(updatedEmployee.getFirstName());
        updateEmployee.setLastName(updatedEmployee.getLastName());
        updateEmployee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmpObj = employeeRepo.save(updateEmployee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmpObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee updateEmployee = employeeRepo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("NO such Employee with Given ID : + employeeId")
        );
        employeeRepo.deleteById(employeeId);
    }
}