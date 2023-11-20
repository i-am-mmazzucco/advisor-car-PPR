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
                    + "tipoVehiculo ENUM('automovil', 'camioneta', 'motocicleta'), "
                    + "marca VARCHAR(15), "
                    + "modelo VARCHAR(15), "
                    + "color VARCHAR(10), "
                    + "año VARCHAR(10), "
                    + "chasis INT, "
                    + "patente VARCHAR(10), "
                    + "precio FLOAT, "
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
                    + "nombre VARCHAR(15), "
                    + "apellido VARCHAR(15), "
                    + "dni VARCHAR(15), "
                    + "legajo VARCHAR(15), "
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
                    + "nombreComprador VARCHAR(15), "
                    + "apellidoComprador VARCHAR(15), "
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

    // Funcion para devolver todos los elementos de la tabla Vehiculo.
    public ResultSet getVehiculos() {
        ResultSet vehiculos = null;
        try {
            Statement stmt = conn.createStatement();
            vehiculos = stmt.executeQuery("SELECT * FROM Vehiculo");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vehiculos;
    }
}
