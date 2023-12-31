package swing;

import database.Hirachy;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import vehiculo.VehiculoInterface;
import vehiculo.VehiculoFactory;
import factura.Factura;
import java.awt.Dimension;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author mmazzucco
 */
public class Historial extends javax.swing.JFrame {

    List<VehiculoInterface> listaVehiculosVendidos = new ArrayList();
    List<Factura> listFacturas = new ArrayList();

    /**
     * Creates new form Formularios
     */
    public Historial() {
        initComponents();
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Historial");
        Hirachy hierachy = new Hirachy();
        loadFacturas(hierachy);
        loadSoldVehicle(hierachy);
        loadSoldVehicleList();
        loadFirstImg();
    }

    private void loadFacturas(Hirachy hierachy) {
        ResultSet facturas = hierachy.getFacturas();
        try {
            while (facturas.next()) {
                Integer idFactura = facturas.getInt("idFactura");
                String fecha = facturas.getString("fecha");
                Integer idVendedor = facturas.getInt("idVendedor");
                Integer idVehiculo = facturas.getInt("idVehiculo");
                String nombreCliente = facturas.getString("nombreCliente");
                String apellidoCliente = facturas.getString("apellidoCliente");
                String direccionCliente = facturas.getString("direccionCliente");
                String cuitcuilCliente = facturas.getString("cuitcuilCliente");
                String dniCliente = facturas.getString("dniCliente");
                Float montoVenta = facturas.getFloat("montoVenta");
                Factura facturaInstance = new Factura(idFactura, fecha, idVehiculo, idVendedor, nombreCliente, apellidoCliente, direccionCliente, cuitcuilCliente, dniCliente, montoVenta);
                this.listFacturas.add(facturaInstance);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Instanciamos una lista de vendedores a partir de los resultados de la base de datos.
    private void loadSoldVehicle(Hirachy hierachy) {
        for (Factura factura : this.listFacturas) {
            ResultSet vehiculo = hierachy.getVehiculo(factura.getIdVehiculo());
            VehiculoFactory vehiculofactory = new VehiculoFactory();
            try {
                while (vehiculo.next()) {
                    VehiculoInterface vehiculoInstance = vehiculofactory.createVehiculo(vehiculo);
                    this.listaVehiculosVendidos.add(vehiculoInstance);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private void loadSoldVehicleList() {
        for (VehiculoInterface vehiculo : this.listaVehiculosVendidos) {
            lstVehiculos.add(vehiculo.toStr());

        }
    }

    private void loadFirstImg() {
        try {
            if (!this.listaVehiculosVendidos.isEmpty()) {
                String urlImagen = this.listaVehiculosVendidos.getFirst().getUrlImg();
                BufferedImage img = ImageIO.read(new URL(urlImagen));
                ImageIcon icon = new ImageIcon(img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH));
                SwingUtilities.invokeLater(() -> imgLabel.setIcon(icon));
            } else {
                // Handle the case when the list is empty
                System.out.println("The list of sold vehicles is empty.");
                // You can choose to set a default image or display a message to the user.
                // For example: imgLabel.setIcon(new ImageIcon("default_image.png"));
            }
        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lstVehiculos = new java.awt.List();
        imgLabel = new javax.swing.JLabel();
        btnVerFactura = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        jLabel2.setText("HISTORIAL DE VENTAS");

        lstVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstVehiculosMouseClicked(evt);
            }
        });

        imgLabel.setText("jLabel4");

        btnVerFactura.setText("Ver Factura");
        btnVerFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFacturaActionPerformed(evt);
            }
        });

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(343, 343, 343))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lstVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnVerFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstVehiculosMouseClicked
        Integer selectedVehiculo = lstVehiculos.getSelectedIndex();
        VehiculoInterface vehiculo = this.listaVehiculosVendidos.get(selectedVehiculo);
        String urlImagen = vehiculo.getUrlImg();
        // Cargar la imagen en un hilo separado para mejorar rendimiento.
        new Thread(() -> {
            try {
                BufferedImage img = ImageIO.read(new URL(urlImagen));
                ImageIcon icon = new ImageIcon(img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH));
                SwingUtilities.invokeLater(() -> imgLabel.setIcon(icon));
            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();
    }//GEN-LAST:event_lstVehiculosMouseClicked

    private void btnVerFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFacturaActionPerformed
        Integer selectedVehiculo = lstVehiculos.getSelectedIndex();
        VehiculoInterface vehiculo = this.listaVehiculosVendidos.get(selectedVehiculo);
        Factura factura = this.listFacturas.get(selectedVehiculo);
        FacturaUI screenFactura = new FacturaUI(vehiculo, factura);
        screenFactura.setVisible(true);
    }//GEN-LAST:event_btnVerFacturaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu screenMenu = new Menu();
        screenMenu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerFactura;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private java.awt.List lstVehiculos;
    // End of variables declaration//GEN-END:variables
}
