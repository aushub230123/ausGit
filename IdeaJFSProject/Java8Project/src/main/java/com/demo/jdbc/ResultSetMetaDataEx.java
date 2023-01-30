package com.demo.jdbc;

import java.sql.*;

public class ResultSetMetaDataEx {
    public static void main(String[] args) {

            //        TOO MANY CHECKED EXCEPTIONS TO HANLDLE
//        TOO MUCH BOILERPLATE CODE
            Connection connection = null;
            try {
//            1. DRIVER LOADED
                Class.forName("com.mysql.cj.jdbc.Driver");
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
//                while(resultSet.next()){
//                    int actorId = resultSet.getInt("ACTOR_ID");
//                    String firstName = resultSet.getString(2);
//                    String lastName = resultSet.getString("LAST_NAME");
//                    System.out.println("Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t");
//                }
                System.out.println("META-DATA");
            ResultSetMetaData resultSetMetaData =     resultSet.getMetaData();
                System.out.println("NOC : " + resultSetMetaData.getColumnCount());
                for(int i=1; i<=resultSetMetaData.getColumnCount(); i++) {
                    System.out.println("Name : " + resultSetMetaData.getColumnName(i) + " > " + resultSetMetaData.getColumnTypeName(i));
                }

                System.out.println("DB INFO");
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                System.out.println("Driver " + databaseMetaData.getDriverName());
                System.out.println("User " +  databaseMetaData.getUserName());
                System.out.println("Product : " + databaseMetaData.getDatabaseProductName());
                System.out.println("Version : " + databaseMetaData.getDatabaseProductVersion());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
