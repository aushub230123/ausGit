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

    //    JAVA OBJECT SERIALIZED INTO JSON
    @ResponseBody
    @GetMapping(value = "/employees", produces = {MediaType.APPLICATION_XML_VALUE})
    public EmployeeModel getEmployees(){
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }
    //    IP : RETURN A LIST OF 3-5 EMPLOYEES IN JSON FORMAT
    // ADD NECESSARY ANNOTATOINS HERE
    public List getEmployeeList() {
    // IMPLEMENT CODE HERE

        return employeeModelList;
    }
    //    IP : RETURN A MAP OF 3-5 EMPLOYEES (EMPLOYEEID : KEY, EMPLOYEE INSTANCE : VALUE) IN JSON FORMAT
    @GetMapping("/employees-map")
    // IMPLEMENT CODE HERE
    public Map getEmployeeMap() {
        return map;
    }


    //   EMPLOYEES OF DEPARTMENTS IT, FINANCE
    //   LIST OF TWO MAPS (EACH MAP WILL CONTAIN THREE EMPLOYEES OF THE DEPARTMENT)
       // ADD NECESSARY ANNOTATOINS HERE
    public List<Map<Integer,EmployeeModel>> getDepartmentWiseEmployees() {
        return listMap;
    }
}

```
