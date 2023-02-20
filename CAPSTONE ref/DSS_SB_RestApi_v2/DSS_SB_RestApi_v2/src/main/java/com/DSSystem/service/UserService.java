package com.DSSystem.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.DSSystem.entity.User;
import com.DSSystem.exceptions.EmailAlreadyInUseException;
import com.DSSystem.exceptions.EmailNotFoundException;
import com.DSSystem.exceptions.PasswordNotMatchedException;
import com.DSSystem.exceptions.PhoneAlreadyInUseException;
import com.DSSystem.exceptions.PhoneNotFoundException;


public interface UserService {

	User save(User registration)throws EmailAlreadyInUseException,PhoneAlreadyInUseException;
	User findByEmailAndPassword(String email, String password) ;
	User findByEmail(String email) ;
	Boolean isValidUser(String email, String password) throws EmailNotFoundException,PasswordNotMatchedException;
	
	
	public Boolean emailInUse(String email) throws EmailNotFoundException ;
	public Boolean phoneInUse(String phone) throws PhoneNotFoundException;
	public Boolean isValidPassword(String email, String pass) ;

	
}