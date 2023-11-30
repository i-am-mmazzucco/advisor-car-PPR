package database;

import java.util.Random;
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
                    + "idVehiculo INT AUTO_INCREMENT, "
                    + "tipoVehiculo ENUM('automovil', 'camioneta', 'motocicleta'), "
                    + "marca VARCHAR(15), "
                    + "modelo VARCHAR(15), "
                    + "color VARCHAR(10), "
                    + "año VARCHAR(10), "
                    + "chasis INT, "
                    + "patente VARCHAR(10), "
                    + "precio FLOAT, "
                    + "imagen VARCHAR(255), "
                    + "url VARCHAR(255), "
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
                    + "idVendedor INT AUTO_INCREMENT, "
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
                    + "dniCliente VARCHAR(15), "
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

    // Funcion para devolver todos los elementos de la tabla Factura.
    public ResultSet getFacturas() {
        ResultSet facturas = null;
        try {
            Statement stmt = conn.createStatement();
            facturas = stmt.executeQuery("SELECT * FROM Factura");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return facturas;
    }

    // Funcion para devolver un vehiculo por id.
    public ResultSet getVehiculo(Integer id) {
        ResultSet vheiculo = null;
        try {
            Statement stmt = conn.createStatement();
            vheiculo = stmt.executeQuery("SELECT * FROM Vehiculo WHERE idVehiculo=" + id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vheiculo;
    }

    // Funcion para devolver un vendedor por id.
    public ResultSet getVendedor(Integer id) {
        ResultSet vendedor = null;
        try {
            Statement stmt = conn.createStatement();
            vendedor = stmt.executeQuery("SELECT * FROM Vendedor WHERE idVendedor=" + id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vendedor;
    }

    // Funcion para postear elementos a la tabla Factura.
    public void postFacturas(String fecha, Integer idVendedor, Integer idVehiculo, String nombreCliente, String apellidoCliente, String direccionCliente, String cuitcuilCliente, String dniCliente, Float montoVenta) {
        String query = "INSERT INTO Factura (fecha, idVendedor, idVehiculo, nombreCliente, apellidoCliente, direccionCliente, cuitcuilCliente, dniCliente, montoVenta)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedstmt = conn.prepareStatement(query);
            preparedstmt.setString(1, fecha);
            preparedstmt.setInt(2, idVendedor);
            preparedstmt.setInt(3, idVehiculo);
            preparedstmt.setString(4, nombreCliente);
            preparedstmt.setString(5, apellidoCliente);
            preparedstmt.setString(6, direccionCliente);
            preparedstmt.setString(7, cuitcuilCliente);
            preparedstmt.setString(8, dniCliente);
            preparedstmt.setFloat(9, montoVenta);
            preparedstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertFakeVehiculos() {
        try {
            String query = "INSERT INTO Vehiculo (tipoVehiculo, marca, modelo, color, año, chasis, patente, precio, imagen, url) "
                    + "SELECT 'automovil', 'Toyota', 'Corolla', 'Azul', '2022', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'ABC123', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen0.jpg', 'https://www.autopista.es/uploads/s1/47/85/40/9/5be953b60de69440393494a0-toyota-corolla-sedan-2019-asi-es-la-3a-carroceria-del-nuevo-compacto.jpeg' FROM DUAL "
                    + "UNION ALL SELECT 'camioneta', 'Ford', 'Explorer', 'Negro', '2021', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'XYZ789', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen1.jpg', 'https://vehicle-images.dealerinspire.com/stock-images/chrome/45ec39af3ee794371d7c9c21112a4668.png' FROM DUAL "
                    + "UNION ALL SELECT 'motocicleta', 'Honda', 'CBR600RR', 'Rojo', '2020', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'DEF456', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen2.jpg', 'https://pueyrredonmotos.com/wp-content/uploads/2018/01/cbr600.jpg' FROM DUAL "
                    + "UNION ALL SELECT 'automovil', 'Chevrolet', 'Cruze', 'Blanco', '2023', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'GHI789', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen3.jpg', 'https://www.chevrolet.com.ar/content/dam/chevrolet/mercosur/argentina/espanol/index/cars/2019-cruze-premier/colorizer/enero-21/colorizer-branco-summit.jpg?imwidth=960' FROM DUAL "
                    + "UNION ALL SELECT 'camioneta', 'BMW', 'X5', 'Gris', '2022', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'JKL012', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen4.jpg', 'https://prod-01-loadandpay-media.s3.eu-west-1.amazonaws.com/medias/cache/app_auction_slides_thumb/628137176043d436127894.jpg' FROM DUAL "
                    + "UNION ALL SELECT 'motocicleta', 'Suzuki', 'GSX-R1000', 'Negro', '2021', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'MNO345', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen5.jpg', 'https://img.remediosdigitales.com/09f956/suzuki-gsx-r-1000-phantom-2022-013/1366_2000.jpeg' FROM DUAL "
                    + "UNION ALL SELECT 'automovil', 'Audi', 'A4', 'Plateado', '2023', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'PQR678', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen6.jpg', 'https://acroadtrip.blob.core.windows.net/publicaciones-imagenes/Large/audi/a4/ar/RT_PU_5f1fa2bff3f7434a9b52cca3e8ef3546.webp' FROM DUAL "
                    + "UNION ALL SELECT 'camioneta', 'Mercedes-Benz', 'GLC', 'Azul', '2022', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'STU901', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen7.jpg', 'https://live.staticflickr.com/4534/37549041745_ceab0d4eca_b.jpg' FROM DUAL "
                    + "UNION ALL SELECT 'motocicleta', 'Kawasaki', 'Ninja ZX-10R', 'Verde', '2021', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'VWX234', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen8.jpg', 'https://lamoto.com.ar/wp-content/uploads/2023/02/Kawasaki-Ninja-ZX-10RR-2023-ambiente.jpg' FROM DUAL "
                    + "UNION ALL SELECT 'automovil', 'Tesla', 'Model 3', 'Negro', '2023', "
                    + (new Random().nextInt(1000000) + 100000) + ", 'YZA567', "
                    + (new Random().nextFloat() * 50000 + 10000) + ", 'imagen9.jpg', 'https://www.autonocion.com/wp-content/uploads/2018/04/Tesla-Model-3-T-Sportsline-3.jpg' FROM DUAL";

            PreparedStatement preparedstmt = conn.prepareStatement(query);
            preparedstmt.execute();
        } catch (SQLException e) {
            System.out.println("Error al insertar vehículos: " + e.getMessage());
        }
    }

    // Función para agregar vendedores a la tabla Vendedor.
    public void insertFakeVendedores() {
        String[] nombres = {"Juan", "Maria", "Pedro", "Luis", "Ana"};
        String[] apellidos = {"Perez", "Gomez", "Fernandez", "Lopez", "Rodriguez"};
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            String nombre = nombres[rand.nextInt(nombres.length)];
            String apellido = apellidos[rand.nextInt(apellidos.length)];
            String dni = String.valueOf(rand.nextInt(90000000) + 10000000);
            String legajo = "L" + rand.nextInt(1000);

            try {
                String query = "INSERT INTO Vendedor (nombre, apellido, dni, legajo) "
                        + "VALUES (?, ?, ?, ?)";
                PreparedStatement preparedstmt = conn.prepareStatement(query);
                preparedstmt.setString(1, nombre);
                preparedstmt.setString(2, apellido);
                preparedstmt.setString(3, dni);
                preparedstmt.setString(4, legajo);
                preparedstmt.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
