package com.example.service.impl;

import com.example.dto.EmployeeDTO;
import com.example.entities.Employee;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee.toString();
    }

    @Override
    public String deleteEmployeeByID(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
        return "Deleted";
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer employeeId) {
        return employeeRepo.findEmployeeByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeDTO> findAllEmployee() {
        return employeeRepo.findAllEmployee();
    }


}
