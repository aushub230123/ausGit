package com.demo.controller;

import com.demo.model.EmployeeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/v0")
public class EmployeeController {
    @GetMapping("/welcome")
    public String greetings() {
        return "Welcome to EFicti Shop";
    }
    @GetMapping("/employee")
    public EmployeeModel getEmployee() {
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }
    @GetMapping("/employees")
    public List getEmployees() {
        List employeesList = new ArrayList<EmployeeModel>();
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        employeesList.add(employeeModel);
        employeeModel = new EmployeeModel(2,"Zen",15000);
        employeesList.add(employeeModel);
        employeeModel = new EmployeeModel(2,"Eli",500);
        employeesList.add(employeeModel);
        return employeesList;
    }

    @GetMapping("/employeeMap")
    public Map getEmployeeMap() {
        Map<Integer,EmployeeModel> employeeMap = new TreeMap<>();
        employeeMap.put(5, new EmployeeModel(5, "JumboJets", 55));
        employeeMap.put( 5555,new EmployeeModel(5555, "JumboJets", 55));
//		return "{id : 1}";
        return employeeMap;
    }
    @GetMapping("/employeesHTML")
    public String getEmployeesWithHTMLAsUI() {
        return "<?xml version=\"1.0\"?>\n" +
                "<html><head><title>Employees</title></head><body><table style=\"border:2px solid green\"><thead><tr style=\"border:1px solid red\"><th>Employee Id </th><th>Name</th><th>Salary</th></tr><tr><td>1</td><td>Ben</td><td>5000</td></tr><tr><td>2</td><td>Sam</td><td>6000</td></tr></thead></table></body></html>";
    }
}
