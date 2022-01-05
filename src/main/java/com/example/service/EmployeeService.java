package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

     String addEmployee(Employee employee);

     String deleteEmployeeByID(Integer employeeId);

     EmployeeDTO findEmployeeById(Integer employeeId);

     List<EmployeeDTO> findAllEmployee();

}
