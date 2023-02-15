
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


