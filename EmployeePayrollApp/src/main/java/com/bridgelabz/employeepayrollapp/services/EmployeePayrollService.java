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
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElseThrow(()->new EmployeePayrollException("Employee with empId "+empId+" does not exists...."));
      //  return employeePayrollList.stream().filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId).findFirst().orElseThrow(()->new EmployeePayrollException("Employee not found "));
    }


    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=new EmployeePayrollData(employeePayrollDTO);

        log.debug("Emp Data :"+empData.toString());
        return employeeRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {

       EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(empId);
       employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);

        return employeeRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(employeePayrollData);

    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }
}
