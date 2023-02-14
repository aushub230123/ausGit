package com.demo.ldm1servicediscoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ldm1ServiceDiscoveryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ldm1ServiceDiscoveryEurekaApplication.class, args);
    }

}
