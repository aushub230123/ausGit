package com.demo.library;

//import javax.persistence.Entity;

//import org.hibernate.annotations.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name="LIBRARIES")
//@Column
public class Library {

    @Id
    private int id;
    private String name;

    public Library() {

    }
    public Library(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
