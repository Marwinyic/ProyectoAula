
package com.mycompany.hola;
import Controlador.controladorInventario;
import Modelo.Inventario;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bello
 */
public class Principal extends javax.swing.JFrame {
    private controladorInventario con;
    private Inventario inv;
   
    
    
    public Principal() {
        initComponents();
        con = new controladorInventario(this);
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setResizable(true); // Asegúrate de que la ventana pueda cambiar de tamaño
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 400));
        tablaI.setFillsViewportHeight(true);



        con = new controladorInventario(this);
        
    }
    public void actualizarTabla(ArrayList<Producto> productos) {
       
        String[] columnas = {"ID", "Nombre", "Precio", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (Producto p : productos) {
            Object[] fila = {p.getId(), p.getNombre(), p.getPrecio(), p.getCantidad()};
            modelo.addRow(fila);
            
    }tablaI.setModel(modelo);

        
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnGanancias = new javax.swing.JButton();
        btnRegistroe = new javax.swing.JButton();
        btnRegistroc = new javax.swing.JButton();
        btnListae = new javax.swing.JButton();
        btnListac = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaI = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setText("Agregar Prodcuto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnGanancias.setText("Mostrar Ganancias ");
        btnGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGananciasActionPerformed(evt);
            }
        });

        btnRegistroe.setText("Registrar Empleado");
        btnRegistroe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroeActionPerformed(evt);
            }
        });

        btnRegistroc.setText("Registrar Cliente");
        btnRegistroc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrocActionPerformed(evt);
            }
        });

        btnListae.setText("Lista de Empleados");
        btnListae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaeActionPerformed(evt);
            }
        });

        btnListac.setText("Lista de Clientes");
        btnListac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListacActionPerformed(evt);
            }
        });

        tablaI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablaI);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListae, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistroc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistroe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnGanancias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistroe, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistroc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListae, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListac, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        con.agregarProducto();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       con.editarProducto();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
       con.venderProducto();
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGananciasActionPerformed
        con.mostrarGanancias();
    }//GEN-LAST:event_btnGananciasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        con.buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistroeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroeActionPerformed
        con.registrarEmpleado();
    }//GEN-LAST:event_btnRegistroeActionPerformed

    private void btnRegistrocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrocActionPerformed
        con.registrarCliente();
    }//GEN-LAST:event_btnRegistrocActionPerformed

    private void btnListaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaeActionPerformed
        tablaEmpleados tE = new tablaEmpleados(con.getListaEmpleados());
        tE.setVisible(true);
        
    }//GEN-LAST:event_btnListaeActionPerformed

    private void btnListacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListacActionPerformed
        tablaClientes tC = new tablaClientes(con.getListaClientes());
        tC.setVisible(true);
        
    }//GEN-LAST:event_btnListacActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGanancias;
    private javax.swing.JButton btnListac;
    private javax.swing.JButton btnListae;
    private javax.swing.JButton btnRegistroc;
    private javax.swing.JButton btnRegistroe;
    private javax.swing.JButton btnVender;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaI;
    // End of variables declaration//GEN-END:variables
}
