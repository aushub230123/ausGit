package com.demo.controller;

import com.demo.entity.EmployeeEntity;
import com.demo.model.EmployeeModel;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmplyeeControllerDbRepo {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List getEmployees() {
        System.out.println("Get All Employees from Repository");
        List employeesList = null;
        employeesList = employeeRepository.findAll();
        return employeesList;
    }

    @GetMapping("/employees/{id}")
//  @PathVariable - Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods.
    public EmployeeEntity getEmployeesById(@PathVariable(value = "id") Integer idFromClient) {
        System.out.println("Getting the employee for " + idFromClient);
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
        EmployeeEntity employeeEntity = employeeEntityOptional.get();
        return employeeEntity;
    }

    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeFromClient) {
        System.out.println("Get all employees!");
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeFromClient);
        return savedEmployeeEntity;
    }

    @PutMapping("/employees/{id}")
    public EmployeeEntity updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody EmployeeEntity employeeEntityFromClient) {
        EmployeeEntity savedEmployeeEntity = null;
        //Fetch the existing employee
//        Optional A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
//        update it's values
            employeeEntity.setName(employeeEntityFromClient.getName());
            employeeEntity.setSalary(employeeEntityFromClient.getSalary());
            savedEmployeeEntity = employeeRepository.save(employeeEntity);
        }
        return savedEmployeeEntity;
    }

    @DeleteMapping("/employees/{id}")
    public EmployeeEntity deleteEmployeeById(@PathVariable(value = "id") Integer idFromClient) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
        EmployeeEntity existingEmployee = employeeEntityOptional.get();
        employeeRepository.delete(existingEmployee);
        return existingEmployee;
    }
}
