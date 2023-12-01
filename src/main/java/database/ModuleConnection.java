/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mmazzucco
 */
public class ModuleConnection {

    // Nos aseguramos que solo una instancia es creada.
    private static Connection conn;

    // Contructor privado para prevenir la instanciacion.
    private ModuleConnection() {
    }

    public static Connection getConnection() throws SQLException {
        // Metodo SINGLETONE para instanciar solo una conexion.
        if (conn == null || conn.isClosed()) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/sys";
                String username = "root";
                String password = "root";

                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);

                System.out.println("Connected");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
                // Lanza SQLException() en el caso de que falle la conexion.
            }
        }

        return conn;
    }
}
