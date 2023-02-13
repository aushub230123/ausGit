package com.demo.entity;

import javax.persistence.*;

// MODEL MAPPED TO A ROW IN THE TABLE (ORM)
@Entity(name="EMPLOYEES")
public class EmployeeEntity {
    // UNIQUENESS
    @Id
//    Auto generated ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMPLOYEE_ID")
    private int id;
    @Column(name="FIRST_NAME", nullable = false)
    private String name;
    private int salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String name, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}