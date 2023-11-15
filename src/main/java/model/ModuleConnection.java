/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author mmazzucco
 */
public class ModuleConnection {

    // Ensure only one instance of Connection is created
    private static Connection conn;

    // Private constructor to prevent instantiation from outside
    private ModuleConnection() {
    }

    public static Connection getConnection() throws SQLException {
        // Create the connection if it doesn't exist
        if (conn == null || conn.isClosed()) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/sys";
                String username = "root";
                String password = "pepe12341";

                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);

                System.out.println("Connected");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
                // Log or rethrow exceptions as needed
                // Logging.getLogger(ModuleConnection.class.getName()).log(Level.SEVERE, null, e);
                // throw new SQLException("Error connecting to the database", e);
            }
        }

        return conn;
    }
}
