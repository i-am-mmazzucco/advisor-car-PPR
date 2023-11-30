package swing;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.Hirachy;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import persona.Vendedor;
import vehiculo.VehiculoFactory;
import vehiculo.VehiculoInterface;

public class Venta extends javax.swing.JFrame {

    List<VehiculoInterface> listaVehiculos = new ArrayList();
    List<Vendedor> listaVendedores = new ArrayList();

    public Venta() {
        initComponents();
        this.setSize(new Dimension(1280, 720));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventas");
        Hirachy hierachy = new Hirachy();
        loadVendedores(hierachy);
        loadVehiculos(hierachy);
        loadComboBoxVendedores();
        loadComboBoxVehiculos();
    }

    // Instanciamos una lista de vendedores a partir de los resultados de la base de datos.
    private void loadVendedores(Hirachy hierachy) {
        try {
            ResultSet vendedores = hierachy.getVendedores();
            while (vendedores.next()) {
                Integer id = vendedores.getInt("idVendedor");
                String nombre = vendedores.getString("nombre");
                String apellido = vendedores.getString("apellido");
                String dni = vendedores.getString("dni");
                String legajo = vendedores.getString("legajo");
                Vendedor vendedor = new Vendedor(id, legajo, nombre, apellido, dni);
                this.listaVendedores.add(vendedor);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Instanciamos una lista de vehiculos a partir de los resultados de la base de datos.
    private void loadVehiculos(Hirachy hierachy) {
        ResultSet vehiculos = hierachy.getVehiculos();
        VehiculoFactory vehiculofactory = new VehiculoFactory();
        try {
            while (vehiculos.next()) {
                VehiculoInterface vehiculo = vehiculofactory.createVehiculo(vehiculos);
                this.listaVehiculos.add(vehiculo);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    // Cargamos la caja de vendedores a partir de la lista previamente creada.
    private void loadComboBoxVendedores() {
        for (Vendedor vendedor : this.listaVendedores) {
            BoxVendedores.addItem(vendedor.getNombre() + " " + vendedor.getApellido() + " - " + vendedor.getLegajo());
        }

    }

    // Cargamos la caja de vehiculos a partir de la lista previamente creada.
    private void loadComboBoxVehiculos() {
        for (VehiculoInterface vehiculo : this.listaVehiculos) {
            BoxVehiculos.addItem(vehiculo.toStr());

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
        jLabel1 = new javax.swing.JLabel();
        BoxVendedores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        BtnVender = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BoxVehiculos = new javax.swing.JComboBox<>();
        imgLabel = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        jLabel2.setText("SECCION DE VENTAS");

        jLabel1.setText("Vendedor:");

        BoxVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxVendedoresActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione el auto a vender:");

        BtnVender.setText("Vender");
        BtnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        BoxVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxVehiculosActionPerformed(evt);
            }
        });

        imgLabel.setText("jLabel4");

        btnAtras.setText("Menu");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(BoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(BoxVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                        .addComponent(BtnVender)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(264, 264, 264))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(BoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(BoxVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVender)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnAtras)))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVenderActionPerformed

        Integer selectedVehiculo = BoxVehiculos.getSelectedIndex();
        Integer selectedVendedor = BoxVendedores.getSelectedIndex();
        Vendedor vendedor = this.listaVendedores.get(selectedVendedor);
        VehiculoInterface vehiculo = this.listaVehiculos.get(selectedVehiculo);
        ClienteForm screenCliente = new ClienteForm(vendedor, vehiculo);
        screenCliente.setVisible(true);
    }//GEN-LAST:event_BtnVenderActionPerformed

    // Mostramos la imagen del vehiculo seleccionado.
    private void BoxVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxVehiculosActionPerformed
        int selectedIndex = BoxVehiculos.getSelectedIndex();
        if (selectedIndex >= 0) {
            VehiculoInterface vehiculoSeleccionado = listaVehiculos.get(selectedIndex);
            String urlImagen = vehiculoSeleccionado.getUrlImg();

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
        }
// TODO add your handling code here:
    }//GEN-LAST:event_BoxVehiculosActionPerformed

    private void BoxVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxVendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxVendedoresActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Menu screenMenu = new Menu();
        screenMenu.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxVehiculos;
    private javax.swing.JComboBox<String> BoxVendedores;
    private javax.swing.JButton BtnVender;
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}