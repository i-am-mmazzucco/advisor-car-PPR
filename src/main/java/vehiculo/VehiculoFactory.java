/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juansa6201
 */
public class VehiculoFactory {

    public VehiculoInterface createVehiculo(ResultSet vehiculo) {
        try {
            Integer id = vehiculo.getInt("idVehiculo");
            String tipo = vehiculo.getString("tipoVehiculo");
            String marca = vehiculo.getString("marca");
            String modelo = vehiculo.getString("modelo");
            String color = vehiculo.getString("color");
            String año = vehiculo.getString("año");
            Integer chasis = vehiculo.getInt("chasis");
            String patente = vehiculo.getString("patente");
            Float precio = vehiculo.getFloat("precio");
            if (null != tipo) {
                switch (tipo) {
                    case "automovil" -> {
                        return new Automovil(id, marca, modelo, año, color, chasis, patente, precio);
                    }
                    case "camioneta" -> {
                        return new Camioneta(id, marca, modelo, año, color, chasis, patente, precio);
                    }
                    case "motocicleta" -> {
                        return new Motocicleta(id, marca, modelo, año, color, chasis, patente, precio);
                    }
                    default -> {
                        System.out.println("Tipo de vehiculo no reconocido.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
