package com.dss.controller;

import com.dss.entity.AdminEntity;
import com.dss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private Environment environment;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public AdminEntity register(@RequestBody AdminEntity admin) {
        System.out.println("Registration : " + admin);
        AdminEntity savedAdmin = adminService.save(admin);
        return savedAdmin;
    }
    @GetMapping("/login")

    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AdminEntity user) {
        String loginMessage = adminService.login(user.getEmailId(),user.getPassword());
        System.out.println(loginMessage);
        return loginMessage;
    }

    @GetMapping("/instance")
    public String getInstancePort(){return environment.getProperty("local.server.port");}

}
