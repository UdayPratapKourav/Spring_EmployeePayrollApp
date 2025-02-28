package com.bridgelabz.employeepayrollapp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
   @NotEmpty(message = "Employee can not be null")
   @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;

   @Min(value = 500,message = "Min salary should be more then 500")
    public long salary;

   @Pattern(regexp ="male|female",message = "Gender needs to be male or female")
    public String gender;

   @JsonFormat(pattern = "dd MMM yyyy")
   @NotNull(message = "StartDate should not be empty")
   @PastOrPresent(message = "Start date should be past or today's date")
    public LocalDate startDate;

   @NotBlank(message = "Note can not be empty")
    public String note;
   @NotBlank(message = "profile pic can not be empty ")
    public String profilePic;
   @NotNull(message = "Department should not be empty ")
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
