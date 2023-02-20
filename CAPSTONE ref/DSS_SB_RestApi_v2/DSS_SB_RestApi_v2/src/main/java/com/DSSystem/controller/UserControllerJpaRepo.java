package com.DSSystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DSSystem.entity.User;
import com.DSSystem.exceptions.EmailAlreadyInUseException;
import com.DSSystem.exceptions.EmailNotFoundException;
import com.DSSystem.exceptions.PasswordNotMatchedException;
import com.DSSystem.exceptions.PhoneAlreadyInUseException;
import com.DSSystem.exceptions.PhoneNotFoundException;
import com.DSSystem.service.UserService;

/*
 * if (existingUser != null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } if (existingUserPhone != null) {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        } else {

            User savingNewUser = userService.save(user);

            return new ResponseEntity<>(savingNewUser, HttpStatus.OK);

        }
 * 
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerJpaRepo {

	@Autowired
	private UserService userService;

	//The @GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = null;
		try {
			System.out.print("User being added: "+user);
			return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
			
		}catch (EmailAlreadyInUseException ex){
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(PhoneAlreadyInUseException  ex) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
// /users/itsmymail@gmail.com/test
	@GetMapping("/users/{email}/{pass}")
	public ResponseEntity<Boolean> authenticate(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		
		try {
			System.out.print("entered the user controller");
			return new ResponseEntity<>(userService.isValidUser(email, pass), HttpStatus.OK);
		} catch (EmailNotFoundException e) {
			System.out.print("entered the user controller: caught the invalid email exception");
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(PasswordNotMatchedException e) {
			System.out.print("entered the user controller: caught the invalid password exception");
			 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/users/checkEmail/{email}")
	public ResponseEntity<Boolean> emailInUse(@PathVariable(value="email") String email)  {
		
		try{
			return new ResponseEntity<>(userService.emailInUse(email), HttpStatus.OK);
		}catch(EmailNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/users/checkPhone/{phone}")
	public ResponseEntity<Boolean> phoneInUse(@PathVariable(value="phone") String phone) {
		try{
			return new ResponseEntity<>(userService.phoneInUse(phone), HttpStatus.OK);
		}catch(PhoneNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/users/checkPassword/{email}/{pass}")
	public Boolean isValidPassword(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		System.out.print(email+ " "+ pass);
		return userService.isValidPassword(email, pass);
	}
}
