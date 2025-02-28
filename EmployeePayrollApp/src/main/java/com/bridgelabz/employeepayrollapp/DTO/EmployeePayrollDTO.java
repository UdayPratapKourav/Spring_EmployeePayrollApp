package com.bridgelabz.employeepayrollapp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.util.List;

public @ToString class EmployeePayrollDTO {
   @NotEmpty(message = "Employee can not be null")
   @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;

   @Min(value = 500,message = "Min salary should be more then 500")
    public long salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;


//
//    public EmployeePayrollDTO(String name,long salary){
//        this.name=name;
//        this.salary=salary;
//    }
//
//    public String toString(){
//        return "Name : "+name+" Salary : "+salary;
//    }
}
