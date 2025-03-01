package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository employeeRepository;

    private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//      return employeePayrollList.get(empId-1);
        return employeePayrollList.stream().filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId).findFirst().orElseThrow(()->new EmployeePayrollException("Employee not found "));
    }

//    @Override
//    public EmployeePayrollData createEmployeePayrollDaya(EmployeePayrollDTO employeePayrollDTO) {
//       EmployeePayrollData employeePayrollData=null;
////       employeePayrollData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
//       employeePayrollList.add(employeePayrollData);
//        return employeePayrollData;
//    }
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=new EmployeePayrollData(employeePayrollDTO);
//        empData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
        log.debug("Emp Data :"+empData.toString());
        return employeeRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {

       EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(empId);
       employeePayrollData.setName(employeePayrollDTO.name);
       employeePayrollData.setSalary(employeePayrollDTO.salary);
       employeePayrollList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
