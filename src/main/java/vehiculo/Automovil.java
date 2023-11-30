/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author juansa6201
 */
// Clase Automovil con atributos, setters, getters heredados y su constructor. Se implementa la interaz Vehiculo siguiendo el patron Factory.
public class Automovil extends VehiculoClass {

    public Automovil(Integer id, String marca, String modelo, String año, String color, Integer chasis, String patente, Float precio, String url) {
        super(id, marca, modelo, año, color, chasis, patente, precio, url);
    }
// Sobreescribimos los metodos de la interfaz para que se adapten a la clase Automovil.
    @Override
    public String toStr() {
        String concat = "Automovil: " + this.toString();
        return concat;
    }

    @Override
    public Float montoVenta() {
        Float monto = 100 + this.getPrecio();
        return monto;
    }
    
    @Override
    public String getUrlImg() {
        return this.getUrl();
    }
}
