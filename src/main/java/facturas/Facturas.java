package facturas;

import persona.Persona;

public class Facturas extends Persona {
    private String fecha;
    private Integer idVehiculo;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String cuitcuilCliente;
    private Float montoVenta;

    public Facturas(Integer id, String nombre, String apellido, String dni,
                    String fecha, Integer idVehiculo, String nombreCliente,
                    String apellidoCliente, String direccionCliente,
                    String cuitcuilCliente, Float montoVenta) {
        super(id, nombre, apellido, dni);
        this.fecha = fecha;
        this.idVehiculo = idVehiculo;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.cuitcuilCliente = cuitcuilCliente;
        this.montoVenta = montoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCuitcuilCliente() {
        return cuitcuilCliente;
    }

    public void setCuitcuilCliente(String cuitcuilCliente) {
        this.cuitcuilCliente = cuitcuilCliente;
    }

    public Float getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Float montoVenta) {
        this.montoVenta = montoVenta;
    }
}
