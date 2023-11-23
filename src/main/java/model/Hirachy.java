package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                    + "idFactura INT AUTO_INCREMENT, "
                    + "fecha VARCHAR(20), "
                    + "idVendedor INT, "
                    + "idVehiculo INT, "
                    + "nombreCliente VARCHAR(15), "
                    + "apellidoCliente VARCHAR(15), "
                    + "direccionCliente VARCHAR(60), "
                    + "cuitcuilCliente VARCHAR(20), "
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
    // Funcion para devolver todos los elementos de la tabla Vehiculo.

    public void postFacturas(String fecha, Integer idVendedor, Integer idVehiculo, String nombreCliente, String apellidoCliente, String direccionCliente, String cuitcuilCliente, Float montoVenta) {
        String query = "INSERT INTO Factura (fecha, idVendedor, idVehiculo, nombreCliente, apellidoCliente, direccionCliente, cuitcuilCliente, montoVenta)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedstmt = conn.prepareStatement(query);
            preparedstmt.setString(1, fecha);
            preparedstmt.setInt(2, idVendedor);
            preparedstmt.setInt(3, idVehiculo);
            preparedstmt.setString(4, nombreCliente);
            preparedstmt.setString(5, apellidoCliente);
            preparedstmt.setString(6, direccionCliente);
            preparedstmt.setString(7, cuitcuilCliente);
            preparedstmt.setFloat(8, montoVenta);
            preparedstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
