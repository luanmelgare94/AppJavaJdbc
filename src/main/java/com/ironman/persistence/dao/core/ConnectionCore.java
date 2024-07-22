package com.ironman.persistence.dao.core;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConnectionCore {

    public Connection getConnection() throws Exception {
        // Attributes
        String hostName = "localhost";
        String port = "5432";
        String dbName = "restaurant_management_db";
        String userName = "postgres";
        String password = "123";

        // process

        // load driver
        Class.forName("org.postgresql.Driver");

        // url connection
        String url = "jdbc:postgresql://" + hostName + ":" + port + "/" + dbName;

        // result
        return DriverManager.getConnection(url, userName, password);
    }
}