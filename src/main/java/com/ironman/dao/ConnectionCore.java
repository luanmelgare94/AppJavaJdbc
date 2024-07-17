package com.ironman.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCore {

    public Connection getConnection () {
        // Attributes
        String hostName = "localhost";
        String port = "5432";
        String dbName = "restaurant_management_db";
        String userName = "postgres";
        String password = "123";

        // process

        try {
            // load driver
            Class.forName("org.postgresql.Driver");

            // url connection
            String url = "jdbc:postgresql://" + hostName + ":" + port + "/" + dbName;

            // result
            return DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}