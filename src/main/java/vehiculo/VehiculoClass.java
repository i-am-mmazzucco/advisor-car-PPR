/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author juansa6201
 */
// Clase Vehiculo con sus atributos, contructor, setters y getters.
public abstract class VehiculoClass implements VehiculoInterface {

    private final Integer id;
    private String marca;
    private String modelo;
    private String año;
    private String color;
    private Integer chasis;
    private String patente;
    private Float precio;

    public VehiculoClass(Integer id, String marca, String modelo, String año, String color, Integer chasis, String patente, Float precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.chasis = chasis;
        this.patente = patente;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + año + " $" + precio;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getChasis() {
        return chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}
