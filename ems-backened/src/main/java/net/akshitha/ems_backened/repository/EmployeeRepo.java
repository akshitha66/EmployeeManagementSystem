package net.akshitha.ems_backened.repository;

import net.akshitha.ems_backened.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
