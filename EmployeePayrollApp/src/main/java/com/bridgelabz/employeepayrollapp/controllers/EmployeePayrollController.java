package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO responseDTO=new ResponseDTO("Get Call for Id Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
            EmployeePayrollData empData=null;
            empData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
            ResponseDTO responseDTO=new ResponseDTO("Get Call for ID successful :",empData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created employee payroll data successfully",empData);

        return new ResponseEntity<ResponseDTO >(responseDTO ,HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO(" Update Employee Payroll Data Successfully ",empData);

        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO=new ResponseDTO("Deleted successfully ",empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
