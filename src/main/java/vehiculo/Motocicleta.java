/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author juansa6201
 */
// Clase Motocicleta con atributos, setters, getters heredados y su constructor. Se implementa la interaz Vehiculo siguiendo el patron Factory.
public class Motocicleta extends VehiculoClass implements VehiculoInterface {

    public Motocicleta(String marca, String modelo, String año, String color, Integer chasis, String patente, Float precio) {
        super(marca, modelo, año, color, chasis, patente, precio);
    }

    @Override
    public String toStr() {
        String concat = "Motocicleta: " + this.toString();
        return concat;
    }

}
