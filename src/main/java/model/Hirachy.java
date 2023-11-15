package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Hirachy {
    public static void main(String[] args) {
        try {
            Connection conn = ModuleConnection.getConnection();
            createVehiculoTable(conn);
            createVendedorTable(conn);
            createFacturaTable(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void createVehiculoTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Vehiculo (" +
                "idVehiculo INT, " +
                "marca VARCHAR(20), " +
                "modelo VARCHAR(20), " +
                "color VARCHAR(20), " +
                "PRIMARY KEY (idVehiculo))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void createVendedorTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Vendedor (" +
                "idVendedor INT, " +
                "nombre VARCHAR(20), " +
                "apellido VARCHAR(20), " +
                "PRIMARY KEY (idVendedor))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void createFacturaTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Factura (" +
                "idFactura INT, " +
                "fecha VARCHAR(20), " +
                "idVendedor INT, " +
                "idVehiculo INT, " +
                "PRIMARY KEY (idFactura), " +
                "FOREIGN KEY (idVendedor) REFERENCES Vendedor(idVendedor), " +
                "FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo))");        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}