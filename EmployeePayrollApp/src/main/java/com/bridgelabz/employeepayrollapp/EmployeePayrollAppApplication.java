package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeePayrollAppApplication.class, args);

		log.info("Employee Payroll app started in {} environment",context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll db user is {}",context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
