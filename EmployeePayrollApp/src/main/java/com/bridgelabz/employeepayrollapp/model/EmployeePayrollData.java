package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public EmployeePayrollData(){}
    public EmployeePayrollData (int employeeId,EmployeePayrollDTO employeePayrollDTO){
            this.employeeId=employeeId;
            this.name= employeePayrollDTO.name;
            this.salary=employeePayrollDTO.salary;
            this.gender=employeePayrollDTO.gender;
            this.startDate=employeePayrollDTO.startDate;
            this.note=employeePayrollDTO.note;
            this.profilePic=employeePayrollDTO.profilePic;
            this.department=employeePayrollDTO.department;
    }

//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public long getSalary() {
//        return salary;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSalary(long salary) {
//        this.salary = salary;
//    }
}
