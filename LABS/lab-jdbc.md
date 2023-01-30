:one: _Connect to database Sakila and fetch Actor Details from table to store them in a Map._  


```java
public class SelectStatementEx {
    public static void main(String[] args) {
        getActorsAsMap();

    }
//    GOAL IS TO UNDERSTAND THE WORKING OF ORM
    public Map<Integer,ActorModel> getActorsAsMap() {
//        USE JDBC TO POPULATE ACTORS INSIDE THE MAP.
        return null;
    }
```


```java
package com.demo.jdbc;

public class ActorModel {
    private int actorId;
    private String firstName;
    private String lastName;
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public ActorModel(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return   "Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t";
    }
}

```
