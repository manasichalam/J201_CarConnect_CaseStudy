package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provides utility methods to interact with the database.
 */
public class DBUtil {
    
    static Connection con;
    
    /**
     * Retrieves a connection to the database.
     * 
     * @return A Connection object representing the database connection.
     */
    public static Connection getDBConn(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthex", "root", "Rajakanti@98");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Main method to test the database connection.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println(getDBConn());
    }
}
