package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private Integer employeeId;

    private String account;

    private String department;

    private String employeeAddress;

    private Date employeeBirthdate;

    private String employeeEmail;

    private String employeeName;

    private String employeePhone;

    private String sex;

//    public EmployeeDTO(Integer employeeId, String account, String department,
//                       String employeeAddress, Date employeeBirthdate, String employeeEmail,
//                       String employeeName, String employeePhone, String sex) {
//        this.employeeId = employeeId;
//        this.account = account;
//        this.department = department;
//        this.employeeAddress = employeeAddress;
//        this.employeeBirthdate = employeeBirthdate;
//        this.employeeEmail = employeeEmail;
//        this.employeeName = employeeName;
//        this.employeePhone = employeePhone;
//        this.sex = sex;
//    }
}
