package com.DSSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "NAME",nullable = false)
    private String name;
	@Column(name = "EMAIL",nullable = false,unique =  true)
    private String email;
	@Column(name = "PASSWORD",nullable = false)
    private String password ;
	
	@Column(name = "PHONE",nullable = false)
    private String phone;
	public User() {};
	public User(Integer userId, String name, String email, String password, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	
    
	
	
	
	
}
