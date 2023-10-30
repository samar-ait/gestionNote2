package mod.sco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/scolarité";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Samar@123";

    public static Connection getConnection() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
