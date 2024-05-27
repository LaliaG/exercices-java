package org.example.Util.Ihm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URI = "jdbc:mysql://localhost:3306/Recipe_JDBC";
    private static final String USER = "root";
    private static final String PASSWORD = "Laliayou19";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URI,USER,PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
