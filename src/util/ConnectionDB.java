package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionDB {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE = "finance";
    public static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to database", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection");
        }
    }
}