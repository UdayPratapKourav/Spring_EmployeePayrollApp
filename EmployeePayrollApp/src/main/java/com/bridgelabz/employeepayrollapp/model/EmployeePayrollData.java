package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData(){}

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData (EmployeePayrollDTO employeePayrollDTO){

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
