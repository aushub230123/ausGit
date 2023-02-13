package com.demo.controller;

import com.demo.entity.Registration;
import com.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registrations")
    public Registration createRegistration(@RequestBody Registration registration) {
        System.out.println("Registration : " + registration);
        Registration savedRegistration = registrationService.save(registration);
        return registration;
    }

    @GetMapping("/registrations/{email}/{password}")
    public Boolean authenticate(@PathVariable(value="email") String email, @PathVariable( value ="password") String password) {
        Boolean authenticated = registrationService.isValidUser(email,password);
        System.out.println("RegistrationController - authenticate : " + authenticated);
        return authenticated;
    }
}
