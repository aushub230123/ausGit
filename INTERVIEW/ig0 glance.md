:books: **SPRING FRAMEWORK**  
 - A Java based framework
 - Allows POJO based development
 - Supports several design patterns like IOC and DI
 - It is light weight
 - Can be used to create stand alone and web applications too.
 - It is an MVC framework (Model-View-Controller)
 - Spring integrate well with thrid party libraries like hibernate.
 - It is an opinionated framework.
 - It automatically configures libraries from 3rd parties like hibernate.

:beginner: _**Design Pattern : IOC (Inversion Of Control) / Dependency Injection (Dependency Injection)**_  

In software engineering, dependency injection is a design pattern in which an object or function receives other objects or functions that it depends on. 
- A form of inversion of control, dependency injection aims to separate the concerns of constructing objects and using them, leading to loosely coupled programs.
- The pattern ensures that an object or function which wants to use a given service should not have to know how to construct those services. Instead, the receiving 'client' (object or function) is provided with its dependencies by external code (an 'injector'), which it is not aware of.

<img src="di-types.png">

:boom: No such thing as getter based injection.
  
:green_book: **DI configuration**  
Dependency injection can be configured in three ways
:one: _XML Configuration_  
:two: _Annotation Configuration_
:three: _Java Based Configuration_  
  


:beginner: _**Application Context**_  

- A Spring ApplicationContext allows you to get access to the objects that are configured in a
BeanFactory in a framework manner.  
-  The Application Context should be explicitly instantiated in a standalone application with the main method.
```java
public static void main( String[] args )
    {
        PaymentGatewayService paymentGatewayService = null;
//      access the spring container (spring bean container, spring ioc container)
//        The Application Context should be explicitly instantiated in a standalone application with the main method.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        Object object = new PaymentGatewayServiceImpl();
//        PaymentGatewayService paymentGatewayService1 =  (PaymentGatewayService)object;
//        paymentGatewayService = applicationContext.getBean("paymentGatewayService",PaymentGatewayService.class);
        paymentGatewayService = (PaymentGatewayService) applicationContext.getBean("paymentGatewayService");
        paymentGatewayService.creditPay();
    }
```

:green_book: **XML based DI**  
```xml
// ensure that we have an id for the AccountDao which is used in ref.
<!-- To define a bean scope (ex.prototype), you can set the scope property to prototype in the bean configuration file -->
<bean id="accountService" scope="prototype" class = "com.demo.AccountService>
	<property name="repository" ref = "accountDao"/>
</bean>
<bean id="accountDao" class = "com.demo.AccountDao"/>

<bean 
  class="com.demo.IndexApp" >
    <property name="service" ref="indexService" init-method="postConstructMethod" />
</bean> 

<bean 
  id="indexService" 
  class="com.demo.IndexService" />
```


:beginner: _**Beans**_  
- The objects that form the backbone of your application are managed by the Spring IoC container are called Beans
- A bean is an object that is instantiated,assembled, and otherwise managed by a Spring IoC container

- By default singleton is the scope when no scope is specified.
:bell: *Defaults : By default spring beans are singltons and eagerly loaded by the application context*  
<img src="beanscopes.png">

```java
   @Autowired
//    Field based dependency injection
// UserRepository is the Bean class
// userRepository is the Bean instance.
    private UserRepository userRepository;
```

:beginner: _**_Autowiring_**_  

- Autowiring feature of spring framework enables you to inject the object dependency implicitly. It
internally uses setter or constructor injection

- Advantage of Autowiring
  -   It requires the less code because we don't need to write the code to inject the dependency  explicitly
- Disadvantage of Autowiring
  -   No control of programmer.
  -   It can't be used for primitive and string values.

:point_right: Types of Autowiring
1. byName
2. byType
3. constructor
4. autodetect  

:point_right: @Autowired with Qualifier   
- Used to auto inject a field by name.
- The @Qualifier annotation along with @Autowired can be used to remove the confusion by specifiying which exact bean will be wired

:beginner: _**ANNOTATIONS**_  
- @RequestMapping
```java
// Annotation for mapping web requests onto methods in request-handling 
// Provides routing information form HTTP request mapping to methods.
@RequestMapping(method = RequestMethod.GET, value = "/api/v1/users")
```
@PathVariable takes and input parameter to the handler method.
```java
    @DeleteMapping("/api/v1/employees/delete/{id}")
    public EmployeeEntity deleteEmployee(@PathVariable(value="id") Integer employeeId) {
      // @PathVariable 
        EmployeeEntity deletedEmployeeEntity = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(deletedEmployeeEntity);
        return deletedEmployeeEntity;
    }
```


- @RestController can be used instead of adding two annotations @Controller and @ResponseBody

- JSR-250 Annotations
- The @Resource, @PostConstruct and @PreDestroy annotations are specified in JSR-250


:beginner: _**COMPONENTS of layered architecture**_  
<img src="components.jpg">

-----------------------------

:books: **SPRING DATA**  
- makes it easy to use data access technologies, 
- relational and non-relational databases,
- cloud-based data services,
- and other data access technologies.
  
  ------------------------
- This is an umbrella project which contains many subprojects that are specific to a given database.
- These three core interfaces of Spring Data are:
• Repository,
• CrudRepository
• PagingAndSortingRepository
• JPARepository
```java
@Repository
//The spring framework internally implements the UserRepository
// The two parameters of JPA Repository are 
// 1. Name of the Model class (UserEntity)
// 2. Primary Key data type
public interface UserRepository extends JpaRepository<UserEntity,String> {
}
```

```java
// The entity class is mapped to a database row.
@Entity
// Creates a table with the name specified with this annotation.
@Table(name = "USERS")
public class UserEntity implements Serializable {
    // uniqueness
    // Specifies the primary key of an entity.
    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private String userId;
```


:one: _SPRING DATA JDBC_
  -  is a part of the larger Spring Data family, makes it easy to implement JDBC based repositories.
  
:two: _SPRING DATA JPA_  
- Sophisticated support to build repositories based on Spring and JPA

:beginner: _**Spring JDBC Template**_  
- Spring Framework provides excellent integration with JDBC API and provides
JdbcTemplate utility class that we can use to avoid bolier plate code from our
database operations logic such as Opening/Closing Connection, ResultSet ,
PreparedStatement etc.
• JdbcTemplate class takes care of creation and release of resources such as
creating and closing of connection object etc.
• It handles the exception and through org.springframework.dao package.
Database operations like insertion, updation , deletion and retrieval of the data
from the database can be execute through JdbcTemplate

:writing_hand: **_Methods_**  
:one: getConnection()
- Get a JDBC Connection, either from the current transaction or a new one.
  
:two:   	getJdbcTemplate()
Return the JdbcTemplate for this DAO, pre-initialized with the DataSource or set explicitly.

getJdbcTemplate()
Return the JdbcTemplate for this DAO, pre-initialized with the DataSource or set explicitly.


:books: **SPRNG FRAMEWORK, SPRING BOOT, MICROSERVICES, SPRING CLOUD**  

:beginner: _**SPRING FRAMEWORK**_  

- The Spring Framework is an application framework and inversion of control container for the Java platform. 
- The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform.

:beginner: _**SPRING BOOT**_  
- Spring Boot is a project/module built on top of Spring Framework.
- Spring Boot provide RAD feature to Spring Framework.
- Spring Boot added power with embedded HTTP server(Tomcat and Jetty).
- Spring Boot is a freamework and not an IDE.
- Spring Boot reduces the cost and development time of the application.
- Spring Boot aggregates common dependencies together and improves productivity.
- Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
- Spring boot takes an opinionated view of the Spring platform
- Spring boot has baked in
  - Auto-dependency management 
  - Provides HTTP servers like Tomcat
  - Provides management endpoints
  - Spring Boot CLi for creating and running projects.

:point_right: creating spring boot project
- Spring Initalizr (https://start.spring.io/)
- Spring Starter Project wizard
- Maven spring or spring maven project
- Spring Boot CLI  

:book: **Dependencies**  
- configured in pom.xml
```xml
<!-- spring boot starter parent -->
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.12</version>
	</parent>
```
<!-- spring data jpa -->
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
```
```xml
<!-- spring boot devtools -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
```
<!-- spring boot web -->
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

:beginner: _**REST (Representational State Transfer) API**_

:point_right: REST uses
  :one:Standard http methods (GET, POST,PUT,DELETE)
  :two:JSON  data transfer format. JSON stands for (Javascript Object Notation).
    
:green_book: **Standard HTTP request methods**  
<img src="HTTPRequestMethods.jpg">


:beginner: _**TOOLING SUPPORT**_

SPRING BOOT DEVTOOLS
- Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant.
-   Automates the process of  building  the project and deploy/start the application for new changes done by the developer to take effect.  

SPRING BOOT ACTUATOR
- Spring Boot includes a number of additional features to help you monitor and manage your application when you push it to production. 
- Provides help while running spring boot applications.



:book: **Externalized configuration for running application in different environments**  

- Spring Boot allows you to externalize your configuration so you can work with the same application code in different environments. 
- properties files, 
- YAML files, 
- environment variables 
- command-line arguments  

:beginner: _**MICROSERVICES**_  
- A microservice is a small, loosely coupled distributed service
- Microservice Architecture , is an architectural style that structures an application as a collection of small autonomous services, modeled around a business
domain.
- Microservice Architecture, each service is self contained and implements
a single business capability.
- Each Microservice has its separate data store.
- Microservices follow partitioned database architecture.
- Microservice Architecture, the Data is federated.

:writing_hand: **_Messaging Formats_**
:one: _Synchronous Messages:_  Microservices usually tend to use REST Representational
State Transfer) as it relies on a stateless, client
:two: _Asynchronous Messages_  
In the situation where clients do not wait for the
responses from a service, Microservices usually tend to use protocols such as
AMQP, STOMP, MQTT.



:beginner: _**SPRING CLOUD**_  

- Spring Cloud is Configuration server technology and communicate with many
services and collect in one Application
- Spring Cloud provides tools for developers to build the common patterns in
distributed systems quickly

:green_book: **Features of Spring Cloud**  

- Service Discovery
- Circuit Breakers
- Routing
- Distributed Tracing
- API Gateway


:green_book: **EUREKA SERVER - SERVICE REGISTRATION & DISCOVERY**  

- The Eureka server registers all the microservices and allows it to be discovered.
- The Eureka server is created with @EnableEurekaServer
- The Eureka client application is created with @EnableEurekaClient annotation.   
<img src="eureka-server-client.png">

```xml
<!-- eureka server dependency -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>

<!-- eureka client dependency -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```
:bell: Features of Spring Cloud
1. Service Registration
2. Service Discovery
3. Routing
4. Distributed Configuration
5. Circuit Breaker  

:books: **FEIGN CLIENT : Microservice Client**  

- FeignClient is a Declarative REST Client in Spring Boot Web Application. -
- Declarative REST Client means you just give the client specification as an Interface and spring boot takes care of the implementation for you.
- Use @EnableFeignClients with the Application and @FeignClient with the interface.

:beginner: _**Databases**_  
<img src="acid.png">


:beginner: _**Maven**_  

- Apache Maven is a software project management and comprehension tool. 
- Based on the concept of a project object model (POM)
- Maven can manage a project's build, reporting and documentation from a central piece of information.
