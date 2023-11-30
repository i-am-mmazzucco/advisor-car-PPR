/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import database.Hirachy;
import swing.Menu;

/**
 *
 * @author mmazzucco
 */
public class Main {

    public static void main(String[] args) {
        // Creamos las tablas en la base de datos.
        Hirachy hierarchy = new Hirachy();
        hierarchy.createVehiculoTable();
        hierarchy.insertFakeVehiculos();
        hierarchy.createVendedorTable();
        hierarchy.insertFakeVendedores();
        hierarchy.createFacturaTable();
        Menu screenMenu = new Menu();
        screenMenu.setVisible(true);
    }
}
