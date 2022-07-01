package util;

import java.sql.*;
import java.sql.PreparedStatement;

public class ConnectionDB {

    Connection connection = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE = "finance";
    public static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public void open() throws Exception {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error connecting to database");
        }
    }

    public void close() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection");
        }
    }
}
