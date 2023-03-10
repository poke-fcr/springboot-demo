package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.impl.EmployeeService;

@RestController
@RequestMapping("/apis/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}



	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee.toString());
		System.out.println(employee.getFirstName());
		return new ResponseEntity<Employee>(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(this.employeeService.getAllEmployee(), HttpStatus.ACCEPTED);
	}

}
