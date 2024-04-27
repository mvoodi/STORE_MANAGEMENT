package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static String dbURL = "jdbc:mysql://localhost:3306/student";
    private static String dbUsername = "root";
    private static String dbPassword = "Jiminkook88.";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
