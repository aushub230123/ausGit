package com.DSSystem.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DSSystem.entity.User;
import com.DSSystem.exceptions.EmailAlreadyInUseException;
import com.DSSystem.exceptions.EmailNotFoundException;
import com.DSSystem.exceptions.PasswordNotMatchedException;
import com.DSSystem.exceptions.PhoneAlreadyInUseException;
import com.DSSystem.repository.UserRepository;
import com.DSSystem.exceptions.EmailNotFoundException;
import com.DSSystem.exceptions.PhoneNotFoundException;

//Dependency injection to get access to repository auto-created by hybernate
/*
* what is dependancy injection?
* Dependency injection is an implementation of “inversion of control” principle. 
* Inversion of control (IoC) says that objects don’t create other objects that they rely on to do their job; 
* instead, they get the objects they need from an external source (eg, an XML configuration file).	
*/
	//We inject the UserRepository into the userRepository field.

@Service
public class UserServiceImpl implements UserService {
	// Dependency Injection (spring framework creates the Repository internally and
	// injects the instance into your app
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) throws EmailAlreadyInUseException,PhoneAlreadyInUseException{
		// SECURE THE PASSWORD AND STORE IN DB
		// if registration exists return error / null
	
		User existingUser = findByEmail(user.getEmail());
		if (existingUser != null)
			throw new EmailAlreadyInUseException("This email is already in use.");
		else if(userRepository.findByPhone(user.getPhone()) != null) {
			throw new PhoneAlreadyInUseException("Phone number is already in use");	
		}
		else {
				
			user.setPassword(convertToMd5(user.getPassword()));
			User savedUser = userRepository.save(user);
			return savedUser;
		}
	}

	private String convertToMd5(String anyString) {
		MessageDigest messageDigest;
		String hashedPassword = "";
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(anyString.getBytes());
			byte[] resultByteArray = messageDigest.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : resultByteArray) {
				sb.append(String.format("%02x", b));
			}
			 hashedPassword = sb.toString();
			System.out.println("Converted password : " + hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm...");
		}
		finally { 
			
		}
		return  hashedPassword; 
		
	}
	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, convertToMd5(password));
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public Boolean isValidUser(String email, String password) throws EmailNotFoundException ,PasswordNotMatchedException{
		System.out.println("email " + email + "password " + password);
		User registration = findByEmailAndPassword(email, password);
		if (registration != null)
			return true;
		else if(!emailInUse(email)) {
			throw new EmailNotFoundException("Email is not in use.");	
		}
		else 
			throw new PasswordNotMatchedException("Invalid password for the registered email.");	
	}

	@Override
	public Boolean emailInUse(String email) throws EmailNotFoundException {
		
		User exictingUser = userRepository.findByEmail(email);
		if(exictingUser != null)
			return true;
		else
			throw new EmailNotFoundException("Email is not in use.");	
	}

	@Override
	public Boolean phoneInUse(String phone) throws PhoneNotFoundException{
		User exictingUser = userRepository.findByPhone(phone);
		if(exictingUser != null)
			return true;
		else
			throw new PhoneNotFoundException("Phone number is not in use.");	
	}

	@Override
	public Boolean isValidPassword(String email, String pass) {
		User foundUser = userRepository.findByEmailAndPassword(email,pass);
		
		if(foundUser != null)
			return  true;
		return false;
	}
	
	
}
