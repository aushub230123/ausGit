:one: _Connect to database Sakila and fetch Actor Details from table to store them in a Map._  


```java
public class SelectStatementEx {
    public static void main(String[] args) {
        getActorsAsMap();

    }
//    GOAL IS TO UNDERSTAND THE WORKING OF ORM
    public Map<Integer,ActorModel> getActorsAsMap() {
//        USE JDBC TO POPULATE ACTORS INSIDE THE MAP.
        return null;
    }
```


```java
package com.demo.jdbc;

public class ActorModel {
    private int actorId;
    private String firstName;
    private String lastName;
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public ActorModel(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return   "Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t";
    }
}

```

:two: _INSERT RECORDS INTO THE BOOKINGS TABLE AND DO A PERFORMANCE TEST FOR STATEMENT VS PREPARED STATEMENT_  

```java
package com.demo.jdbc;

public class BookingModel {
    private int bookingId;
    private String source;
    private String destination;

    public BookingModel() {
    }

    public BookingModel(int bookingId, String source, String destination) {
        this.bookingId = bookingId;
        this.source = source;
        this.destination = destination;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "bookingId=" + bookingId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
```
```java
package com.demo.jdbc;

import java.sql.*;

public class PreparedStatementEx {
    public static void main(String[] args) {
        preparedStatementPerformanceTest();
    }

    private static void preparedStatementPerformanceTest() {
        //Load the driver class
        try {
            System.out.println("Loading the the driver!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Establishting connection!");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GFLIGHTSDB","root","mysql");
            System.out.println("Created Statement");

            String insertQuery = "INSERT INTO BOOKINGS VALUES(?,?,?)";
            System.out.println(insertQuery);
//            An object that represents a precompiled SQL statement.
//            A SQL statement is precompiled and stored in a PreparedStatement object.
//            This object can then be used to efficiently execute this statement multiple times.
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            System.out.println("Execute the statements");
            long start = System.currentTimeMillis();
            for(int i=1; i<=1000; i++) {
                BookingModel bookingModel = new BookingModel(i, "Manila"+i ,"Charles"+i);
                preparedStatement.setInt(1,bookingModel.getBookingId());
                preparedStatement.setString(2,bookingModel.getSource());
                preparedStatement.setString(3,bookingModel.getDestination());
                preparedStatement.executeUpdate();
            }
//            int noOfRowsInserted = preparedStatement.executeUpdate();
//            if(noOfRowsInserted > 0) {
//                System.out.println("Row(s) inserted " + noOfRowsInserted);
//            }
            long end = System.currentTimeMillis();
            System.out.println("Records inserted in " + ( end -start) + " ms.");
            System.out.println("CLOSING THE CONNECTION");
            connection.close();
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("Driver class not found " + e);
        }
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Duplicate Primary Key : " + e.getMessage());
        }
        catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println("Error connecting to the database " + e);
        }
    }
    private static void statementPerformanceTest() {
        //Load the driver class
        try {
            System.out.println("Loading the the driver!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Establishting connection!");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GFLIGHTSDB","root","mysql");
            System.out.println("Created Statement");
            Statement statement = connection.createStatement();
            System.out.println("Execute the statements");
            long start = System.currentTimeMillis();
            for(int i=1; i<=1000; i++) {
                BookingModel bookingModel = new BookingModel(i, "Manila"+i ,"Charles"+i);
                String insertQuery = "INSERT INTO BOOKINGS VALUES(" + bookingModel.getBookingId() + ",'" +
                        bookingModel.getSource() + "','" + bookingModel.getDestination()  + "')";
                statement.executeUpdate(insertQuery);
            }
//            int noOfRowsInserted = preparedStatement.executeUpdate();
//            if(noOfRowsInserted > 0) {
//                System.out.println("Row(s) inserted " + noOfRowsInserted);
//            }
            long end = System.currentTimeMillis();
            System.out.println("Records inserted in " + ( end -start) + " ms.");
            System.out.println("CLOSING THE CONNECTION");
            connection.close();
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("Driver class not found " + e);
        }
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Duplicate Primary Key : " + e.getMessage());
        }
        catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println("Error connecting to the database " + e);
        }
    }
}

```

:three: _Using CallableStatement fetch details of FILM TITLE, LANGUAGE AND CATEGORY by passing LANGUAGE as input_  

```java
private static void getMoviesWithCategoryAndLanguage() {
        //        Unhandled exception: java.lang.ClassNotFoundException (checked exception)
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.....");
//            https <protocol> : set of rules governing the transfer of data
//            <protocol><subprotocol><url>
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAKILA","root","mysql");

            // CREATE CALLABLE STATEMENT
            // PASS THE LANGUAGE AS INPUT PARAMETER
            // FETCH THE RESULTS

            while(resultSet.next()){
             System.out.println("Movie details : " + resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t");
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Missing the Driver class!" + classNotFoundException);
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL " + e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the connection " + e);
            }
        }
    }
```
```sql
-- CREATE PROCEDURE GET_MOVIE_DETAILS1 
-- WHICH ACCEPTS THE LANGUAGE AS THE INPUT
-- AND SELECT'S FILM TITLE, LANGUAGE AND CATEGORY FOR THE LANGUAGE.
```
