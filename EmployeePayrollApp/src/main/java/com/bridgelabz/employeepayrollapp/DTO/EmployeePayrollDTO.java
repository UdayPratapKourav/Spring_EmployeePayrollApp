package com.bridgelabz.employeepayrollapp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeePayrollDTO {
   @NotEmpty(message = "Employee can not be null")
   @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;
   @Min(value = 500,message = "Min salary should be more then 500")
    public long salary;

    public EmployeePayrollDTO(String name,long salary){
        this.name=name;
        this.salary=salary;
    }

    public String toString(){
        return "Name : "+name+" Salary : "+salary;
    }
}
