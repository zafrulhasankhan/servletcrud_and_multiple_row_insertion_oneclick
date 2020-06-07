
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static String dbUrl = "jdbc:mysql://localhost:3306/test";
    private static String dbUser = "root";
    private static String dbPass = "";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        System.out.println("Successfully connected to MySQL Database.");
        return con;
    }
    
    

    
}


