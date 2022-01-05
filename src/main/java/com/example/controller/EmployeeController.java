package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.entities.Employee;
import com.example.service.EmployeeService;
import com.example.service.impl.EmployeeImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeImpl;

    public EmployeeController(EmployeeService employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @GetMapping("/findByID/{id}")
    public EmployeeDTO findById(@PathVariable Integer id){
        return employeeImpl.findEmployeeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employeeImpl.addEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeImpl.deleteEmployeeByID(id);
        return "Deleted";
    }

    @GetMapping("/findAll")
    public List<EmployeeDTO> findAllEmployee(){
        return employeeImpl.findAllEmployee();
    }




}
