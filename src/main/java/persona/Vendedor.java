/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author juansa6201
 */
// Clase Vendedor con sus atributos, contructor, setters y getters.
public class Vendedor extends Persona {

    private String legajo;

    public Vendedor(Integer id, String legajo, String nombre, String apellido, String dni) {
        super(id, nombre, apellido, dni);
        this.legajo = legajo;
    }
public String facturaStr(){
    String concat = this.getNombre() + " " + this.getApellido() + " - Legajo: " + this.getLegajo();
    return concat;
}
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

}
