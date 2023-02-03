:one: _Display Actor Details in a styled and tabular format_  

```java
package com.demo.labs;

public class ActorController {
    public String getActorDetails() {
        // DISPLAY ACTOR NAME & ACTOR MOVIE AS A TABLE WITH CSS STYLING
        // USE A MAP CONTAINING DATA FOR 5 MOVIES
        // ITERATE THROUGH THE MAP AND GENERATE THE TABLE ROWS.
        return null;
    }
}

```
:two: _Aalayze the following controller and perform the required implementation_  
:bell: Use MediaType Enumeration and add the required dependnecy for XML Serialization.  

```java
@Controller
@RequestMapping("/api/v0")
public class EmployeeController {
    @ResponseBody
    @GetMapping("/welcome")
    public String getWelcomeWithHTMLAsUI() {
        String htmlOutput = "<!DOCTYPE html>";
        htmlOutput += "<html>";
        htmlOutput += "<head><title>Welcome to the Web</title></head>";
        htmlOutput += "<body><h1>This demo is a from spring boot and REST API ....</h1>" +
                "<h1 style='color:red;font-weight:bold'>Ensures developer productivity!</h1> <br/> " +
                " Enter text to search :  <input type = 'text' value=></input> <br/>" +
                " <input type='Submit' value='Search'></input>";
        htmlOutput += "</html>";
        return  htmlOutput;
    }

    //    JAVA OBJECT SERIALIZED INTO XML FORMAT
    // ADD NECESSARY ANNOTATOINS HERE
    public EmployeeModel getEmployee(){
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }
   @ResponseBody
   @GetMapping(value = "/employees-list")
public List getEmployees() {
       List<EmployeeModel> employeeModelList = new ArrayList<>();
       employeeModelList.add(new EmployeeModel(1,"Ben",5000));
       employeeModelList.add(new EmployeeModel(2,"Benny",50000));
        return employeeModelList;
   }
    //    IP : RETURN A MAP OF 3-5 EMPLOYEES (EMPLOYEEID : KEY, EMPLOYEE INSTANCE : VALUE) IN XML FORMAT
    @GetMapping("/employees-map-xml")
    // IMPLEMENT CODE HERE
    public Map getEmployeeMap() {
        return map;
    }


    //   EMPLOYEES OF DEPARTMENTS IT, FINANCE
    //   LIST OF TWO MAPS (EACH MAP WILL CONTAIN THREE EMPLOYEES OF A DEPARTMENT) IN JSON FORMAT
    // CONSIDER HAVING TWO DEPARTEMENTS.
       // ADD NECESSARY ANNOTATOINS HERE
    public List<Map<Integer,EmployeeModel>> getDepartmentWiseEmployees() {
        return listMap;
    }
}

```
:three: _Migrate the application.properties to yaml format_ 
```properties
spring.datasource.url="jdbc:mysql://localhost:3306/LIBRARYDB?useSSL=false";
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true;

```
:four: _EXPLORE : Create SpringBootJPAEclipseLinkJPA project for connnecting using Eclipse link_  


:five: _US5 : Setup the Actor Module_  

:five: _US6 PERFORM UPDATE AND DELETE USING RESTFUL SERVICE AND POSTMAN_  
```java
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

```
