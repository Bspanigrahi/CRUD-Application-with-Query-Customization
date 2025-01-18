package com.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.dto.EmployeeDto;
import com.api.entity.Employee;
import com.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
     
	@Autowired
	private EmployeeRepository emprepo;
	
	public Employee createEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	

	public List<EmployeeDto> getEmployee(LocalDate dateOfJoining,String department) {
		
		List<Employee> emp = null;
		if(dateOfJoining != null && department!=null && ! department.equalsIgnoreCase("")) {
			emp = emprepo.findEmployeeByJoiningDateInbetween(dateOfJoining,department);
		}
		else if(department!=null && ! department.equalsIgnoreCase("") && dateOfJoining == null) {
			emp = emprepo.findEmployeeByJoiningDateInbetween(department);
		}
		else if((department==null ||  department.equalsIgnoreCase("") )&& dateOfJoining != null) {
			emp = emprepo.findEmployeeByJoiningDateInbetween(dateOfJoining);
		}
		else {
			emp = emprepo.findAll();
		}
		
		//List<Employee> emp = emprepo.findAll() ;
		
		List<EmployeeDto> empdto = new ArrayList<>();
		       
		for (Employee employee : emp) {
	        EmployeeDto dto = new EmployeeDto();
	        
	        
	        dto.setEmployeeId(employee.getEmployeeId());
	        dto.setName(employee.getName());
	        dto.setEmail(employee.getEmail());
	        dto.setDepartment(employee.getDepartment());
	        dto.setDateOfJoining(employee.getDateOfJoining());
	        
	       
	        empdto.add(dto);
	    }
	    
		
		return empdto;
	}

	
	public List<EmployeeDto> getAllEmployee() {
		 
		List<Employee> emp = emprepo.findAll() ;
        List<EmployeeDto> empdto = new ArrayList<>();
		
		for (Employee employee : emp) {
	        EmployeeDto dto = new EmployeeDto();
	        
	        
	        dto.setEmployeeId(employee.getEmployeeId());
	        dto.setName(employee.getName());
	        dto.setEmail(employee.getEmail());
	        dto.setDepartment(employee.getDepartment());
	        dto.setDateOfJoining(employee.getDateOfJoining());
	        
	       
	        empdto.add(dto);
	    }
	    
		
		return empdto;
		
	}


	public EmployeeDto updateEmp(Employee emp) {
		
		 Employee existingEmployee = emprepo.findById(emp.getEmployeeId())
                 .orElseThrow(() -> new RuntimeException("Employee not found"));


                

                 Employee updatedEmployee = emprepo.save(emp);
                  EmployeeDto employeedto = new EmployeeDto();
                  employeedto.setName(updatedEmployee.getName());
                  employeedto.setEmployeeId(updatedEmployee.getEmployeeId());
                  employeedto.setEmail(updatedEmployee.getEmail());
                  employeedto.setDepartment(updatedEmployee.getDepartment());
                  employeedto.setDateOfJoining(updatedEmployee.getDateOfJoining());

                  return employeedto;
                
	}


	    public void deleteEmployee(int id) {
		
		Employee existEmployee = emprepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
		
		emprepo.delete(existEmployee);
	   }


		
	   
	

}





