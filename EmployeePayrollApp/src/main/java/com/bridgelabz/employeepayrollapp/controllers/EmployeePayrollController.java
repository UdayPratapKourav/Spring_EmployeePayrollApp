package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList=null;
        empDataList=employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Successful",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empDataList=null;
        empDataList=employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO=new ResponseDTO("Get Call for ID Successful",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=employeePayrollService.createEmployeePayrollDaya(employeePayrollDTO);
//        empData=new EmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created employee payroll data successfully",empData);

        return new ResponseEntity<ResponseDTO >(responseDTO ,HttpStatus.OK);
    }



    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO(" Update Employee Payroll Data Successfully ",empData);

        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO=new ResponseDTO("Delete successfully","deleted id "+empId);
         return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
