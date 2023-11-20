package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hirachy {

    private Connection conn;

    // Contructor de la clase. Se instancia la conexion.
    public Hirachy() {
        try {
            this.conn = ModuleConnection.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Funcion para crear la tabla Vehiculo.
    public void createVehiculoTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Vehiculo ("
                    + "idVehiculo INT, "
                    + "marca VARCHAR(20), "
                    + "modelo VARCHAR(20), "
                    + "color VARCHAR(20), "
                    + "PRIMARY KEY (idVehiculo))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Funcion para crear la tabla Vendedor.
    public void createVendedorTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Vendedor ("
                    + "idVendedor INT, "
                    + "nombre VARCHAR(20), "
                    + "apellido VARCHAR(20), "
                    + "dni VARCHAR(20), "
                    + "legajo VARCHAR(20), "
                    + "PRIMARY KEY (idVendedor))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Funcion para crear la tabla Factura.
    public void createFacturaTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Factura ("
                    + "idFactura INT, "
                    + "fecha VARCHAR(20), "
                    + "idVendedor INT, "
                    + "idVehiculo INT, "
                    + "nombreComprador VARCHAR(20), "
                    + "apellidoComprador VARCHAR(20), "
                    + "direccionComprador VARCHAR(60), "
                    + "cuitcuilComprador VARCHAR(20), "
                    + "montoVenta FLOAT, "
                    + "PRIMARY KEY (idFactura), "
                    + "FOREIGN KEY (idVendedor) REFERENCES Vendedor(idVendedor), "
                    + "FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Funcion para devolver todos los elementos de la tabla Vendedor.
    public ResultSet getVendedores() {
        ResultSet vendedores = null;
        try {
            Statement stmt = conn.createStatement();
            vendedores = stmt.executeQuery("SELECT * FROM Vendedor");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vendedores;
    }
}
