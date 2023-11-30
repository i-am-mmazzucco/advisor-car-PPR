package factura;

public class Factura {

    private Integer idFactura;
    private String fecha;
    private Integer idVehiculo;
    private Integer idVendedor;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String cuitcuilCliente;
    private Float montoVenta;

    public Factura(Integer idFactura, String fecha, Integer idVehiculo, Integer idVendedor, String nombreCliente, String apellidoCliente, String direccionCliente, String cuitcuilCliente, Float montoVenta) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.idVehiculo = idVehiculo;
        this.idVendedor = idVendedor;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.cuitcuilCliente = cuitcuilCliente;
        this.montoVenta = montoVenta;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
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

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
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
