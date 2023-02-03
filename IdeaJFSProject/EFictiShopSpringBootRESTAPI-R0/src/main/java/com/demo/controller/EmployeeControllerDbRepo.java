package com.demo.controller;

import com.demo.entity.EmployeeEntity;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerDbRepo {
//    FIELD BASED DI
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List getEmployees(){
        System.out.println("All Emp From Repo");
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeFromClient){
      EmployeeEntity employeeEntity =  employeeRepository.save(employeeFromClient);
      return employeeEntity;
    }

//    US LAB : CODE THE UPDATE FUNCTIONALITY
//    "/employees" = fixed path
//    "{id}" = variable
//    /employees/1 passed in url
//    pass the details to be updated in the body.
//    @PutMapping("/employees/{id}")
//public EmployeeEntity updateEmployee(.......) {
//        return the updated employee
//}

    //  US  LAB : CODE THE DELETE FUNCTIONALITY
//    "/employees" = fixed path
//    "{id}" = variable
//    /employees/1 passed in url
//    pass the details to be updated in the body.
//    @PutMapping("/employees/{id}")
//public EmployeeEntity deleteEmployeeById(.......) {
//        return the deleted employee
//}
}
