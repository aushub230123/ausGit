
:beginner: _**Eureka server**_  

:one: _dependency_  

```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
```
:two: _properties_  
```properties
#spring-application.name=discovery-server
server.port=8761

# transfer the settings to application.yml
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

```
```java
@EnableEurekaServer
```



:beginner: _**Registration Service**_  

:one: _dependency_  
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```
:two: _properties_ 
```properties
#register with eureka
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka/
    instance:
      hostname: localhost

```
```properties
server.port=9301
```
```java
@EnableEurekaClient
```

:beginner: _**Standalone Client App**_  

:one: _dependency_ 
```xml
			<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
```
```properties

```

:two: _properties_  

```properties
# register with eureka
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

```properties
spring.application.name=client-application
server.port=7070
```
:three: _Java_  

```java
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
```

```java
//Directly invoking a service instance
//@FeignClient(name="registration-service" , url = "http://localhost:9302")
@FeignClient(name="registration-service")
public interface RegistrationProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstanceThroughProxy();
	@GetMapping("/api/v2/registrations/{email}/{password}")
	public Boolean login(@PathVariable String email, @PathVariable String password);
	}
```

:beginner: _**Microservice Client App**_  
```xml
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
```

:two: _properties_  

```properties
# register with eureka
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

```properties
spring.application.name=client-service
server.port=7075
```

:three: _Proxy_  

```java
//Directly invoking a service instance
//@FeignClient(name="registration-service" , url = "http://localhost:9302")
@FeignClient(name="registration-service")
public interface RegistrationProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstanceThroughProxy();
	@GetMapping("/api/v2/registrations/{email}/{password}")
	public Boolean login(@PathVariable String email, @PathVariable String password);
	}
```

:four: _Service_  
```java
@Service
//public class RegistrationServiceImpl implements RegistrationService{
public class RegistrationService{

	@Autowired
	private RegistrationProxy registrationProxy;

	
	public Boolean login(String email, String password) {
		boolean loggedIn = false;
		loggedIn = registrationProxy.login(email, password);
		return loggedIn;
	}
	public String getServiceInstance() {
	String serverInstancePortString = registrationProxy.getServiceInstance();
	return serverInstancePortString;
	}

}
```
:five: _controller_  
```java
@RestController
@RequestMapping("api/v3")
public class LoginController {
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/api/v2/instance")
	public String getServiceInstance() {
		String serverInstancePortString = registrationService.getServiceInstance();	
		return serverInstancePortString;
	}
	
	@GetMapping("/registrations/{email}/{password}")
	public boolean login(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		boolean loggedIn = registrationService.login(email, password);
		if (loggedIn) {
			return true;
		} else {
			return false;
		}
	}
}

```
:six: _client app_
```java
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Md4ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md4ClientServiceApplication.class, args);
	}

}
```
  

:beginner: _**API Gateway**_  
:one: _dep_  
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
```

:two: _prop_  
```properties
spring.application.name=api-gateway-service
server.port=8765

#spring.cloud.gateway.discovery.locator.enabled=true
#spring.cloud.gateway.discovery.locator.lower-case-service-id=true
# eureka registration
eureka.client.service-url.default-zone=http://localhost:8761/eureka/
eureka.instance=localhost
```
