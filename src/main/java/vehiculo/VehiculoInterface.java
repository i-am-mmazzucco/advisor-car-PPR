/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vehiculo;

/**
 *
 * @author juansa6201
 */
// Interfaz Vehiculo para seguir el patron Factory y simplificar la creacion de metodos.
public interface VehiculoInterface {
    String toStr();
    Float montoVenta();
    Integer getId();
    String getUrlImg();
    String facturaStr();
}
