package com.api.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query(value="SELECT * \r\n"
			+ "FROM `crud_application`.`employee`\r\n"
			+ "WHERE `date_of_joining`  >?1 AND department=?2 ORDER BY `date_of_joining` desc",nativeQuery = true)
     public List<Employee> findEmployeeByJoiningDateInbetween(LocalDate dateOfJoining,String department);
	
	@Query(value="SELECT * \r\n"
			+ "FROM `crud_application`.`employee`\r\n"
			+ "WHERE `date_of_joining`  >?1 ORDER BY `date_of_joining` desc",nativeQuery = true)
     public List<Employee> findEmployeeByJoiningDateInbetween(LocalDate dateOfJoining);
	
	@Query(value="SELECT * \r\n"
			+ "FROM `crud_application`.`employee`\r\n"
			+ "WHERE `department =?1` ORDER BY `date_of_joining` desc",nativeQuery = true)
     public List<Employee> findEmployeeByJoiningDateInbetween(String department);
	 
	 
}

