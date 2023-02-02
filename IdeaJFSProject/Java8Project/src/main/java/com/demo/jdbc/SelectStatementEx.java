package com.demo.jdbc;

import java.sql.*;
import java.util.Map;
// 1. DATATYPE MISMATCH
// 2. OOPS VS RELATIONAL (INHERITANCE) / (PRIMARY KEY / FOREIGN KEY)
// 3. ACTOR (actorID, actorName, ......) / AUTOGENERATION (SEQUENCE)
// 4. CHECKED EXCEPTIONS
// 5. BOILER PLATE CODE
// 6. SQL QUERIES ARE EMBEDDED AS STRINGS
// ORM HIBERNATE.. SOLUTION
public class SelectStatementEx {
    public static void main(String[] args) {
        getActors();
    }
//    GOAL IS TO UNDERSTAND THE WORKING OF ORM
    public Map<Integer,ActorModel> getActorsAsMap() {
//        IP : 15 MINS.
//        USE JDBC TO POPULATE ACTORS INSIDE THE MAP.
        return null;
    }
    private static void getActors() {
        //        TOO MANY CHECKED EXCEPTIONS TO HANLDLE
//        TOO MUCH BOILERPLATE CODE
        Connection connection = null;
        try {
//            1. DRIVER LOADED
//            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.....");
            //https <protocol> : set of rules governing the transfer of data
//            <protocol><subprotocol><url>
//            2. ESTABLISH A CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAKILA","root","mysql");
            System.out.println("Connected!");
//            3. CREATE STATEMENT
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
//            4. CREATE THE QUERY
            String selectQuery = "SELECT ACTOR_ID, FIRST_NAME, LAST_NAME FROM ACTOR";
//            5. EXECUTE QUERY AND GET RESULTS
            ResultSet resultSet = statement.executeQuery(selectQuery);
//            6. TRAVERSE THROUGH THE RESULTS
            //            Moves the cursor forward one row from its current position.
            while(resultSet.next()){

                int actorId = resultSet.getInt("ACTOR_ID");
//                int mobileNumber = resultSet.getInt("ACTOR_MOBILE");
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println("Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t");
            }
        }
//        catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
