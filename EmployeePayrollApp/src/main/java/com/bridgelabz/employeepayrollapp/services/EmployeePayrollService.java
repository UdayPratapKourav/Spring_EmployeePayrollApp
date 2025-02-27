package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

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

    @Override
    public EmployeePayrollData createEmployeePayrollDaya(EmployeePayrollDTO employeePayrollDTO) {
       EmployeePayrollData employeePayrollData=null;
       employeePayrollData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
       employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
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
