package com.java.employee.Service;

import com.java.employee.Entity.Employee;
import com.java.employee.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(EmployeeDTO employee);
    Optional<Employee> getById(Integer emp_id);
    List<Employee> getAll();
    Employee update(Employee empDTO,Integer id);
}
