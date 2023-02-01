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
