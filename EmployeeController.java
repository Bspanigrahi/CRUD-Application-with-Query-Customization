package com.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.EmployeeDto;
import com.api.entity.Employee;
import com.api.service.EmployeeService;

@RestController
public class EmployeeController {
   
	@Autowired
	private EmployeeService empservice;
	
	@PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		return this.empservice.createEmployee(emp);
	}
	
	
	@GetMapping("/getemp")
	public List<EmployeeDto> getEmployee(@RequestParam(required = false) LocalDate dateOfJoining ,@RequestParam(required = false) String department) {
		
		return this.empservice.getEmployee(dateOfJoining,department);
		
	}
	
	
	@GetMapping("/getalldata")
	public List<EmployeeDto> fetchAllEmployee(){
		
		return this.empservice.getAllEmployee();
				
	}
	
	@PutMapping("/update")
	public EmployeeDto updateEmp(@RequestBody Employee emp) {
		
		return this.empservice.updateEmp(emp);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable int id) {
		
		  this.empservice.deleteEmployee(id);
	}
	
	
}




