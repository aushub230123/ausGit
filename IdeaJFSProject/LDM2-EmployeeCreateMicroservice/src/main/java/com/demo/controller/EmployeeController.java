package com.demo.controller;

import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;

// annotations add metadata.
// palced on classes, methods, parameters
@RestController
@RequestMapping("/api")
public class EmployeeController {

	// Employee Controller is dependent on the Employee Repository
	// Spring creates the instance of the dependency / (EmployeeRepository)
	// Spring injects the dependency
	@Autowired
	EmployeeRepository employeeRepository;
	
	//get all emp
//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees() {
//		List<Employee> employeesList = null;
//		employeesList = employeeRepository.findAll();
//		return employeesList;
//	}
////	search for emp
//// empID = path variable
//	@GetMapping("/employees/{empId}")
//	public Employee getEmployeeById(@PathVariable(value="empId") Long employeeId) {
//	Employee employee =	employeeRepository.findById(employeeId).get();
//		return employee;
//	}
//	
//	// insert emp
	@PostMapping(value="/employees")
	public Employee createEmployee(@RequestBody Employee employeeFromClient) {
		return employeeRepository.save(employeeFromClient);
	}
//	
//	// update emp
//	@PutMapping("/employees/{empId}")
//	public Employee updateEmployee(@RequestBody Employee employeeFromClient, @PathVariable(value="empId") Long employeeId) {
//		Employee employeeFromDB =	employeeRepository.findById(employeeId).get();
//		employeeFromDB.setFirstName(employeeFromClient.getFirstName());
//		employeeFromDB.setLastName(employeeFromClient.getLastName());
//		employeeFromDB.setEmailId(employeeFromClient.getEmailId());
//		Employee updatedEmployee =  employeeRepository.save(employeeFromDB);
//		return updatedEmployee;
//	}
//	
//	// delete emp
//	@DeleteMapping("/employees/{empId}")
//	public Employee deleteEmployee( @PathVariable(value="empId") Long employeeId) {
//		Employee employeeFromDB =	employeeRepository.findById(employeeId).get();
//		 employeeRepository.delete(employeeFromDB);
//		return employeeFromDB;
//	}
}
