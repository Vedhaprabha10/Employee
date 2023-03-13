package com.java.employee.Controller;

import com.java.employee.Entity.Employee;
import com.java.employee.Service.EmployeeService;
import com.java.employee.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmpController {
    @Autowired
    EmployeeService empServcie;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeDTO employee){
        Employee employee1=empServcie.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entered Employee details added successfully");
    }

    @GetMapping(value = "/{emp_id}")
    public ResponseEntity<?> getById(@PathVariable("emp_id") Integer emp_id){
        Optional<Employee> emp=empServcie.getById(emp_id);
        if (!emp.isEmpty()){
            empServcie.getById(emp_id);
            return ResponseEntity.status(HttpStatus.FOUND).body(emp);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("enter a valid id");
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(){
        List<Employee> empList = empServcie.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(empList);
    }
    @PutMapping(value = "/update/{emp_id}")
    public ResponseEntity<?> updateId(@RequestBody Employee employee,@PathVariable("emp_id")Integer id){
      Optional<Employee> employee2 = empServcie.getById(id);
      if (!employee2.isEmpty()) {
          empServcie.update(employee, id);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee updated successfully");
      }
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("Enter a valid Id");
    }
}
//    public ResponseEntity<?> dataUpdateBYId(@RequestBody Floor floor , @PathVariable int id){
//        Optional<Floor> validData= (Optional<Floor>)floorService.dataById(id);
//        if (!validData.isEmpty()){
//            floorService.updatById(floor,id);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter a valid Id");
//    }