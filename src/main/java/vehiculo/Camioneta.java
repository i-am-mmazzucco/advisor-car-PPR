/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author juansa6201
 */
// Clase Camioneta con sus atributos y constructor. Los setters y getters son heredados. Se implementa la interaz Vehiculo siguiendo el patron Factory.
public class Camioneta extends VehiculoClass implements VehiculoInterface {

    public Camioneta(String marca, String modelo, String año, String color, Integer chasis, String patente, Float precio) {
        super(marca, modelo, año, color, chasis, patente, precio);
    }

    @Override
    public String toStr() {
        String concat = "Camioneta: " + this.toString();
        return concat;
    }

}
