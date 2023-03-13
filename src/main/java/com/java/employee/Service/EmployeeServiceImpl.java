package com.java.employee.Service;

import com.java.employee.Entity.Employee;
import com.java.employee.Repository.EmployeeRepository;
import com.java.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    @Override
    public Employee save(EmployeeDTO employee) {
        Employee employee1 = new Employee();
        employee1.setEmp_id(employee.getEmp_id());
        employee1.setEmp_name(employee.getEmp_name());
        employee1.setEmail(employee.getEmail());
        employee1.setCompany(employee.getCompany());
        employee1.setProject(employee.getProject());
        return empRepo.save(employee1);
    }

    @Override
    public Optional<Employee> getById(Integer emp_id) {
        return empRepo.findById(emp_id);
    }

    @Override
    public List<Employee> getAll() {
        return empRepo.findAll();
    }

   @Override
    public Employee update(Employee emp,Integer id) {
        emp.setEmp_id(id);
        return empRepo.save(emp);
    }
}
