package com.example.repository;

import com.example.dto.EmployeeDTO;
import com.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {



    @Query( "SELECT new com.example.dto.EmployeeDTO(e.employeeId, e.account, e.department, e.employeeAddress," +
            "e.employeeBirthdate, e.employeeEmail, e.employeeName, e.employeePhone, e.sex) FROM Employee e " +
            "WHERE e.employeeId = :id")
    EmployeeDTO findEmployeeByEmployeeId(@Param("id") Integer id);


    @Query( "SELECT new com.example.dto.EmployeeDTO(e.employeeId, e.account, e.department, e.employeeAddress," +
            "e.employeeBirthdate, e.employeeEmail, e.employeeName, e.employeePhone, e.sex) FROM Employee e ")
    List<EmployeeDTO> findAllEmployee();


}
