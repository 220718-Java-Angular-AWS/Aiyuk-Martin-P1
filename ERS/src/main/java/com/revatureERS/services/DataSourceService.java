package com.revatureERS.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceService {

    private static Connection connection;

    //Private constructor for Singleton Design Pattern
    private DataSourceService() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    private static void connect() {
        // Connecting to the database here
        //jdbc:postgresql://hostname:port/databaseName
        try {
            Properties props = new Properties();
            //using the class path loading method
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("jdbc.properties");
            props.load(input);

            String host = props.getProperty("host");
            String port = props.getProperty("port");
            String dbname = props.getProperty("dbname");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            String schema = props.getProperty("schema");
            String driver = props.getProperty("driver");

            StringBuilder builder = new StringBuilder("jdbc:postgresql://");
            builder.append(host);
            builder.append(":");
            builder.append(port);
            builder.append("/");
            builder.append(dbname);
            builder.append("?user=");
            builder.append(username);
            builder.append("&password=");
            builder.append(password);
            builder.append("&currentSchema=");
            builder.append(schema);

            Class.forName(driver);

            connection = DriverManager.getConnection(builder.toString());

        } catch(FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
