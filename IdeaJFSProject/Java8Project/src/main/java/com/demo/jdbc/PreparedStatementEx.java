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
