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
public class Camioneta extends VehiculoClass {

    public Camioneta(Integer id, String marca, String modelo, String año, String color, Integer chasis, String patente, Float precio, String url) {
        super(id, marca, modelo, año, color, chasis, patente, precio, url);
    }

    @Override
    public String toStr() {
        String concat = "Camioneta: " + this.toString();
        return concat;
    }

    // Sobreescribimos los metodos de la interfaz para que se adapten a la clase Camioneta.
    @Override
    public Float montoVenta() {
        Float monto = 200 + this.getPrecio();
        return monto;
    }

    @Override
    public String getUrlImg() {
        return this.getUrl();
    }

    @Override
    public String facturaStr() {
        String concat = "Camioneta: " + this.getMarca() + " " + this.getModelo() + " - " + this.getAño();
        return concat;
    }
}
