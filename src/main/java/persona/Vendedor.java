/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author juansa6201
 */
public class Vendedor extends Persona {

    public Vendedor(String legajo, String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
    }
    public String legajo;
}
