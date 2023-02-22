1. What is OOP (Object-Oriented Programming)?

- An object-oriented programming is a way programming which enables programmers to think like they are working with real-life entities(a thing with distinct and independent existence) or objects. In real-life, people have knowledge and can do various works. In OOP, objects have fields to store knowledge/state/data and can do various works — methods.
- https://medium.com/from-the-scratch/oop-everything-you-need-to-know-about-object-oriented-programming-aee3c18e281b

2. What are the 4 concepts/pillars of OOP? Explain each.

- Encapsulation
  - Encapsulation is a mechanism of wrapping the data (instance variables) and code acting on the data (methods) together as a single unit like a Class.
- Abstraction
  - Abstraction is a process of hiding the implementation details from the user, only the functionality will be provided to the user.
- Polymorphism
  - In object-oriented programming, polymorphism (from the Greek meaning “having multiple forms”) is the characteristic of being able to assign a different meaning or usage to something in different contexts — specifically, to allow an entity such as a function, or an object to have more than one form.
    There are 2 types of polymorphism implementations:
    Static Polymorphism
    Dynamic Polymorphism
- Inheritance
  - Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another.
- https://medium.com/from-the-scratch/oop-everything-you-need-to-know-about-object-oriented-programming-aee3c18e281b

3. What is Eureka Server?

- Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.
- https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm

4. Difference between Hibernate and Spring Data JPA?

- Hibernate is the most popular ORM (Object Relational Mapping) framework for working with a database,
- Spring Data JPA is a library that adds an extra layer of abstraction on top of the ORM JPA implementation. By default, Spring Data JPA uses Hibernate as the ORM provider (to execute queries).
- https://hackernoon.com/the-difference-between-jdbc-jpa-hibernate-and-spring-data-jpa

5. What is static?

- A static keyword used with a variable means that the variable in that class is not object specific but it is now class specific. In simple words if the value of a static variable is changed for one object then it will be changed for all other objects belonging to that class.
- https://medium.com/analytics-vidhya/static-keyword-in-java-6d9cb56b8253

6. Difference between Monolithic and Microservice Architecture?

- If all the functionalities of a project exists in a single codebase, then that application is known as monolithic application
- It is an architectural development style in which the application is made up of smaller services communicating with each other directly using lightweight protocols like HTTP.
- https://www.geeksforgeeks.org/monolithic-vs-microservices-architecture/

7. Difference between Method Overloading and Method Overriding?
   https://www.geeksforgeeks.org/difference-between-method-overloading-and-method-overriding-in-java/
8. How do you connect to the database?

- https://www.javatpoint.com/steps-to-connect-to-the-database-in-java

9. What are the HTTP methods? Explain each.

- The primary or most-commonly-used HTTP verbs (or methods, as they are properly called) are POST, GET, PUT and DELETE. These correspond to create, read, update, and delete (or CRUD) operations, respectively. There are a number of other verbs, too, but are utilized less frequently.
- https://www.restapitutorial.com/lessons/httpmethods.html

10. Difference between API and REST API?

- The first thing to understand is that API is the superset while REST API is the subset. This means all REST APIs are APIs while not all APIs are REST APIs. API is a broad term while REST API is a specialized API. There are a lot of differences between an API and REST API. REST stands for Representational State Transfer while API stands for Application Program Interface.
- https://www.freelancinggig.com/blog/2018/11/02/what-is-the-difference-between-api-and-rest-api/

11. Explain One to Many and Many to One relationship.

- relationship between the Customers table and the Addresses table.
  - If each address can belong to only one customer, this relationship is "One to One".
  - Each customer may have zero, one or multiple orders. But an order can belong to only one customer. this is "One To Many" relationship.
  - Many Orders belong to one customer. The vice versa of "One To Many" is "Many To One" relationship.
  - https://code.tutsplus.com/articles/sql-for-beginners-part-3-database-relationships--net-8561
  - - https://stackoverflow.com/questions/4601703/difference-between-one-to-many-and-many-to-one-relationship
- For example, if one department can employ for several employees then, department to employee is a one to many relationship (1 department employs many employees), while employee to department relationship is many to one (many employees work in one department).

12. Difference between Abstract Class and Interface?

- Abstract class and interface both are used to achieve abstraction where we can declare the abstract methods. Abstract class and interface both can't be instantiated.

- But there are many differences between abstract class and interface
- https://www.javatpoint.com/difference-between-abstract-class-and-interface
- https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/

13. Difference between Controller and RestController?

- The @Controller annotations is used for traditional spring MVC framework Controller.
- The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services.
  The @RestController annotation in Spring MVC/Spring BOOT is nothing but a combination of @Controller and @ResponseBody annotation.
- https://medium.com/@akshaypawar911/java-spring-framework-controller-vs-restcontroller-3ef2eb360917

14. What is Autowired?

- The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring.
- https://medium.com/@akshaypawar911/java-spring-framework-controller-vs-restcontroller-3ef2eb360917

15. What are the dependencies used in your project?

- mysql dependency, hibernate dependency, web dependency for rest api and tomcat, eureka server dependency, eureka client dependency

```xml
<!-- ADD MYSQL DEPENDENCY -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<!-- HIBERNATE DEPENDENCY -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<!-- TOMCAT DEPENDENCY -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- DEV TOOLS -->
<!-- 		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency> -->

      <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
```

16. Difference between Constructor and Method of a Class?

- Constructors:
  Constructors are used to initialize the object’s state. Like methods, a constructor also contains collection of statements(i.e. instructions) that are executed at time of Object creation. Each time an object is created using new() keyword at least one constructor (it could be default constructor) is invoked to assign initial values to the data members of the same class.
- Methods:
  A method is a collection of statements that perform some specific task and return the result to the caller. A method can perform some specific task without returning anything. Methods allow us to reuse the code without retyping the code. In Java, every method must be part of some class
- https://www.geeksforgeeks.org/difference-between-the-constructors-and-methods/

17. Difference between Instance Variable and Local Variable?

- These variables are declared within a class but outside a method, constructor, or block and always get a default value.
  These variables are usually created when we create an object and are destroyed when the object is destroyed.
  We may use an access specifier, for instance, variable, and if no access specifier is specified, then the default access specifier is used.
  Each and every object will have its own copy of instance variables.
- Local Variable: These variables are declared within a method but do not get any default value.
- https://www.geeksforgeeks.org/difference-between-instance-variable-and-local-variable/

18. What are the access modifiers of Java? Explain each.

- access modifiers in Java helps to restrict the scope of a class, constructor, variable, method, or data member.
- There are four types of access modifiers available in java:
  - Default – No keyword required
  - Private
  - Protected
  - Public
- https://www.geeksforgeeks.org/access-modifiers-java/

19. What is the keyword for Inheritance?

- the extends keyword

20. What are the HTTP Methods and their use?

- The primary or most-commonly-used HTTP verbs (or methods, as they are properly called) are POST, GET, PUT and DELETE. These correspond to create, read, update, and delete (or CRUD) operations, respectively. There are a number of other verbs, too, but are utilized less frequently.
  https://www.restapitutorial.com/lessons/httpmethods.html

21. What password-encryption did you use in your project?

- I used plain passwords and did not implement password-encryption.The password can be encrypted in Spring Boot Password using Jasypt library.
- - https://medium.com/@javatechie/spring-boot-password-encryption-using-jasypt-e92eed7343ab

22. Will the program work if RestController is changed into Controller?

- The program will not work by only changing RestController into Controller. But it will work if we also add @ResponseBody on each and every handler method.
- Using @Controller instead of @RestController
-

:loudspeaker: _watch out @Controller used instead of @RestController and @RequestBody used for every handler method_

```java
package dem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dem.entity.Product;
import dem.entity.ProductsResponse;
import dem.repository.ProductRepository;

@Controller
//@RestController
@RequestMapping("/api")
public class ProductController {
//	SPRING FRAMEWORK CREATES THE INSTANCE OF REPOSITORY.
	@Autowired
	ProductRepository productRepository;

//	RETURNS HTML
	@ResponseBody
	@GetMapping("/welcome")
	protected String welcome()  {
		System.out.println("TO THE WORLD OF SPRING BOOT AND REST API");
		return "<html><head><title>Welcome Servlet</title></head><body><h1>Welcome to the world of springboot............</h1></body></html>";
//		return "WELCOME TO THE WORLD OF SPRING BOOT AND REST API";
	}
	@ResponseBody
	@GetMapping("/productsAsHTML")
	protected String getAllProductsAsHTML()  {
		List<Product> productsList = productRepository.findAll();
		String productsHTML = "<html><head><title>Display Product Details !!!</title>"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" +
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" +
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" +
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script></head><body><h1>Products List</h1>";
		productsHTML +=	"<table class=\"table table-dark table-striped\" style = \"width:500px\"><tr><th>Product ID</th><th>Name</th><th>Product Price</th></tr>";
		for(Product product : productsList) {
			productsHTML +=	 "<tr><td>"+product.getProductId()+ "</td><td>" + product.getProductName() + "</td><td>" + product.getPrice() + "</td></tr>";
		}
		productsHTML +=	 "</table></body></html>";
		return productsHTML;
	}
// GET ALL THE PRODUCTS
	@ResponseBody
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> productsList = productRepository.findAll();
		return productsList;
	}
	// GET ALL THE PRODUCTS
		@ResponseBody
		@GetMapping("/productsResponse")
		public ProductsResponse getAllProductsResponse() {
			List<Product> productsList = productRepository.findAll();
			ProductsResponse productsResponse = new ProductsResponse();
			productsResponse.setProducts(productsList);
			return productsResponse;
		}
//  CREATE A NEW PRODUCT
	@ResponseBody
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product productFromBrowser) {
		System.out.println("Inserting : " + productFromBrowser);
		Product savedProduct = productRepository.save(productFromBrowser);
		return savedProduct;
	}
//  UPDATE EXISTING PRODUCT
	@ResponseBody
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product productFromBrowser) {
		System.out.println("Updating : " + productFromBrowser);
//		fetch the product from the database with the id
		Product existingProduct = productRepository.findById(productId).get();
//		update the existing product with the details from the browser
		existingProduct.setProductName(productFromBrowser.getProductName());
		existingProduct.setPrice(productFromBrowser.getPrice());
//		save the updated details
		Product updatedProduct = productRepository.save(existingProduct);
		return updatedProduct;
	}

//	DELETE AN EXISTING PRODUCT
	@ResponseBody
	@DeleteMapping("/products/{productIdfromBrowser}")
	public void deleteProduct(@PathVariable(value="productIdfromBrowser")Long productId) {
		System.out.println("Deleting : " + productId);
		productRepository.deleteById(productId);
	}
}

```

23.What are the steps you should do if you want to change the port number of the service?

- in the application.properties file in the resource folder add the following
  server.port = 9090

24. What will happen to the project if the server does not have a port number?

- the project will run on the default port of tomcat. Tomcat by default will start on port: 8080

25. How do you create custom queries?

- Custom Queries can be creatd using the @Query annotation. The @Query annotation declares finder queries directly on repository methods.
  https://zetcode.com/springboot/datajpaquery/
  :point_right: Repository

```java
package dem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dem.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
//	/**
//     * Finds a product by using the productName as search criteria.
//     * @param productName
//     * @return  A list of products whose name is an exact match with the given productName.
//     * If no products are found, this method returns an empty list.
//     */
	@Query("select  product from Product product where product.productName = :productNameParam")
	  public List<Product> findByProductName(@Param("productNameParam") String productName);
}
```

:point_right: RESTController

```java
	// SEARCH PRODUCTS BY PRODUCT NAME
		@GetMapping("/products/find/{productName}")
//		@ResponseBody
		public List<Product> searchProductByName(@PathVariable(value = "productName") String productName) {
			List<Product> productsList = productRepository.findByProductName(productName);
			return productsList;
		}
```

:point_right: Postman url to search for all products with name "DW"

```html
http://localhost:9090/ecz/api/products/find/DW
```

:point_right: Postman result

```json
[
  {
    "productId": 10,
    "productName": "DW",
    "price": 550.5
  },
  {
    "productId": 11,
    "productName": "DW",
    "price": 550.5
  },
  {
    "productId": 12,
    "productName": "DW",
    "price": 550.5
  }
]
```

26. How do you send data to an HTTP request?

- You can use several HTTP methods in an HTTP request. Each method sends data in the request in a different manner. For example, the GET method uses the query string of the RequestURI to pass parameter and value pairs.
  :loudspeaker: _we have used post man to send GET request with url below_
  http://localhost:9090/ecz/api/products/find/DW

- Other methods use the HTTP message body to send data in the request.  
   :loudspeaker: _we have used postman to send post request with data in body_
  http://localhost:9090/ecz/api/products/find/DW

```json
{
  "productName": "SWY",
  "price": 55.5
}
```

:bell: we can also the get url in the browser and post data with html forms.

27. What is Discovery Server used for or its advantages?

- Eureka Server is a discovery server. Eureka Server registers all other microservices which are called Eureka Clients. Eureka Clients are the independent microservices.
  https://dzone.com/articles/netflix-eureka-discovery-microservice

  :bell: Advantages :- discovers the updated and current URL of the client services at all times. This process is called Service Discovery, and Eureka by Netflix is a tool used for this service discovery
- https://medium.com/techno101/spring-boot-netflix-eureka-for-service-discovery-in-microservices-cc81cca96144

28. What methodology did you use in creating your project?

- We implemented a microservices architecture with three spring boot applications and Euerka Server. We built the REST Controller and used a Repository to connect to the database.
- Mysql server as the backend.
- The Login microservice with REST Controller for handling the user authentication with its own dedicated database.
- The Accounts microservice with REST Controller for handling the account and transactions with its own dedicated database.
- The Client application connected with the microservices.
- The REST API's were tested with Postman.

29. What is Spring Boot?
    - Spring Boot is an open source, microservice-based Java web framework. The Spring Boot framework creates a fully production-ready environment that is completely configurable using its prebuilt code within its codebase. The microservice architecture provides developers with a fully enclosed application, including embedded application servers.

- The embedded application server is TomCat.
  https://www.jrebel.com/blog/what-is-spring-boot

30. What is an Object?

- A Java object is a member (also called an instance) of a Java class. Each object has an identity, a behavior and a state. The state of an object is stored in fields (variables), while methods (functions) display the object's behavior. ... In Java, an object is created using the keyword "new".
  https://www.techopedia.com/definition/24339/java-object

31. What is the purpose of Spring DevTools Dependency?

- Spring Boot provides anaother module called Spring Boot DevTools. DevTools stands for Developer Tool. The aim of the module is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application.
  https://www.javatpoint.com/spring-boot-devtools

32. What is a repository?

- A repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects which are entities mapped to database rows.
- @Repository is a Spring annotation that indicates that the decorated class is a repository.
  https://zetcode.com/springboot/repository/

33. What is the server port used for?

- The spring boot application runs Apache Tomcat on a server port.
- We can run multiple microservices on different ports
- We can configure the server port in the application.properties file using server.port property.

34. Difference between Path Variable and Request Param?

- The key difference between @RequestParam and @PathVariable is that @RequestParam used for accessing the values of the query parameters where as @PathVariable used for accessing the values from the URI template.
  https://www.dineshonjava.com/requestparam-vs-pathvariable-annotations-in-spring-mvc/

35. Difference between Class and Object?

- Class: A class is the building block that leads to Object-Oriented Programming. It is a user-defined data type, that holds its own data members and member functions, which can be accessed and used by creating an instance of that class. It is the blueprint of any object.

- Object: An object is an instance of a class. All data members and member functions of the class can be accessed with the help of objects. When a class is defined, no memory is allocated but when it is instantiated (i.e. an object is created), memory is allocated. For example, considering the objects for the Account class is Saving account, Current account, etc.
  https://www.geeksforgeeks.org/difference-between-class-and-object/

36. How do you create an instance of a Class?

- using the "new" keyword.
- eg. Product barbieDoll = new Product();


