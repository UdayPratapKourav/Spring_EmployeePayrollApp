package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
       List<EmployeePayrollData> empDataList = new ArrayList<>();
       empDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000)));
        return empDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
      EmployeePayrollData employeePayrollData=null;
      employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollDaya(EmployeePayrollDTO employeePayrollDTO) {
       EmployeePayrollData employeePayrollData=null;
       employeePayrollData=new EmployeePayrollData(1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
       EmployeePayrollData employeePayrollData=null;
       employeePayrollData=new EmployeePayrollData(1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
