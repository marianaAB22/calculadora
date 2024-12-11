/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taller3TercerCorte;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Administrator
 */
public class VentanaFacturas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaProductos
     */
    public VentanaFacturas() {
        initComponents();
        cargarFacturasTabla();
    }
    public List<Factura> manipularFacturasJSON() {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("FacturasTaller3.json");
            if (!file.exists()) {
                return new ArrayList<>();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            JsonArray listaJson = gson.fromJson(bufferedReader, JsonArray.class);
            if (listaJson == null) {
                return new ArrayList<>();
            }
            // Usamos TypeToken para convertir el JsonArray a una lista de Facturas
            java.lang.reflect.Type facturasType = new TypeToken<List<Factura>>(){}.getType();
            List<Factura> listaFacturas = gson.fromJson(listaJson, facturasType);
            return listaFacturas;
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean agregarFacturaJSON(String codigo, String nombre, int cantidad, double precio, int impuesto) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            Factura nuevaFactura = new Factura(codigo, nombre, cantidad, precio, impuesto);
            List<Factura> listaFacturas = manipularFacturasJSON();
            listaFacturas.add(nuevaFactura);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String cadenaJson = gson.toJson(listaFacturas);
            File file = new File("FacturasTaller3.json");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(cadenaJson);
            System.out.println("Factura agregada con eito.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar la factura: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el escritor: " + ex.getMessage());
            }
        }

        return false;
    }

    public void agregarFacturaATabla(Factura factura) {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        model.addRow(new Object[]{
            factura.getCodigo(),
            factura.getNombre(),
            factura.getCantidad(),
            factura.getPrecio(),
            factura.getImpuesto(),
            factura.getTotal()
        });
    }
    
    public void cargarFacturasTabla() {
        List<Factura> listaFacturas = manipularFacturasJSON();
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        model.setRowCount(0);

        for (Factura factura : listaFacturas) {
            model.addRow(new Object[]{
                factura.getCodigo(),
                factura.getNombre(),
                factura.getCantidad(),
                factura.getPrecio(),
                factura.getImpuesto(),
                factura.getTotal()
            });
        }
    }
    
    public boolean eliminarFactura(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        String codigoFactura = model.getValueAt(rowIndex, 0).toString();
        List<Factura> listaFacturas = manipularFacturasJSON();

        for (Factura factura : listaFacturas) {
            if (factura.getCodigo().equals(codigoFactura)) {
                listaFacturas.remove(factura);
                break;
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("FacturasTaller3.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String cadenaJson = gson.toJson(listaFacturas);
            bufferedWriter.write(cadenaJson);
            System.out.println("Factura eliminada correctamente.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }

        return false;
    }
    
    public void eliminarFilaTabla(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        model.removeRow(rowIndex);
    }
    
    public boolean modificarFactura(int rowIndex, String codigo, String nombre, int cantidad, double precio, int impuesto) {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        String codigoFactura = model.getValueAt(rowIndex, 0).toString();
        List<Factura> listaFacturas = manipularFacturasJSON();

        for (Factura factura : listaFacturas) {
            if (factura.getCodigo().equals(codigoFactura)) {
                factura.setCodigo(codigo);
                factura.setNombre(nombre);
                factura.setCantidad(cantidad);
                factura.setPrecio(precio);
                factura.setImpuesto(impuesto);

                double total = cantidad * precio + (cantidad * precio * impuesto / 100);
                factura.setTotal(total);

                break;
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("FacturasTaller3.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String cadenaJson = gson.toJson(listaFacturas);
            bufferedWriter.write(cadenaJson);
            System.out.println("Factura modificada correctamente.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }

        return false;
    }

    
    public void modificarFilaTabla(int rowIndex, String codigo, String nombre, int cantidad, double precio, int impuesto, double total) {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();

        model.setValueAt(codigo, rowIndex, 0);
        model.setValueAt(nombre, rowIndex, 1);
        model.setValueAt(cantidad, rowIndex, 2);
        model.setValueAt(precio, rowIndex, 3);
        model.setValueAt(impuesto, rowIndex, 4);
        model.setValueAt(total, rowIndex, 5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        botonGuardarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        botonModificarProducto = new javax.swing.JButton();
        botonEliminarProducto = new javax.swing.JButton();
        campoImpuesto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("!BIENVENIDO AL APARTADO DE REGISTRO DE FACTURA¡");

        campoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("CODIGO:");

        jLabel3.setText("NOMBRE:");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("CANTIDAD:");

        campoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCantidadActionPerformed(evt);
            }
        });

        jLabel5.setText("PRECIO:");

        campoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioActionPerformed(evt);
            }
        });

        botonGuardarProducto.setText("GUARDAR");
        botonGuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarProductoMouseClicked(evt);
            }
        });
        botonGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarProductoActionPerformed(evt);
            }
        });

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO", "IMPUESTO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);

        botonModificarProducto.setText("MODIFICAR");
        botonModificarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonModificarProductoMouseClicked(evt);
            }
        });
        botonModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarProductoActionPerformed(evt);
            }
        });

        botonEliminarProducto.setText("ELIMINAR");
        botonEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarProductoMouseClicked(evt);
            }
        });
        botonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProductoActionPerformed(evt);
            }
        });

        campoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoImpuestoActionPerformed(evt);
            }
        });

        jLabel6.setText("IMPUESTO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(botonGuardarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonModificarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEliminarProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarProducto)
                    .addComponent(botonModificarProducto)
                    .addComponent(botonEliminarProducto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCodigoActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCantidadActionPerformed

    private void campoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioActionPerformed

    private void botonGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarProductoActionPerformed

    }//GEN-LAST:event_botonGuardarProductoActionPerformed

    private void botonGuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarProductoMouseClicked
        String codigo = campoCodigo.getText();
        String nombre = campoNombre.getText();
        int cantidad = Integer.parseInt(campoCantidad.getText());
        double precio = Double.parseDouble(campoPrecio.getText());
        int impuesto = Integer.parseInt(campoImpuesto.getText());

        Factura nuevaFactura = new Factura(codigo, nombre, cantidad, precio, impuesto);
        boolean facturaGuardada = agregarFacturaJSON(codigo, nombre, cantidad, precio, impuesto);

        if (facturaGuardada) {
            agregarFacturaATabla(nuevaFactura);

            campoCodigo.setText("");
            campoNombre.setText("");
            campoCantidad.setText("");
            campoPrecio.setText("");
            campoImpuesto.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar la factura.");
        }    
    }//GEN-LAST:event_botonGuardarProductoMouseClicked

    private void botonModificarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarProductoMouseClicked
        // Obtener la fila seleccionada en la tabla
        int rowIndex = tablaFacturas.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una factura para modificar.");
            return;
        }

        String codigo = campoCodigo.getText();
        String nombre = campoNombre.getText();

        if (codigo.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Codigo y nombre no pueden estar vacíos.");
            return;
        }
        int cantidad = 0;
        double precio = 0.0;
        int impuesto = 0;

        try {
            cantidad = Integer.parseInt(campoCantidad.getText());
            precio = Double.parseDouble(campoPrecio.getText());
            impuesto = Integer.parseInt(campoImpuesto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores numericos validos.");
            return;
        }
        double total = cantidad * precio + (cantidad * precio * impuesto / 100);
        boolean facturaModificada = modificarFactura(rowIndex, codigo, nombre, cantidad, precio, impuesto);
        if (facturaModificada) {
            modificarFilaTabla(rowIndex, codigo, nombre, cantidad, precio, impuesto, total);
            JOptionPane.showMessageDialog(this, "Factura modificada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar la factura.");
        }
    }//GEN-LAST:event_botonModificarProductoMouseClicked

    private void botonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonModificarProductoActionPerformed

    private void botonEliminarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarProductoMouseClicked
        int rowIndex = tablaFacturas.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una factura para eliminar.");
            return;
        }
        boolean facturaEliminada = eliminarFactura(rowIndex);
        if (facturaEliminada) {
            eliminarFilaTabla(rowIndex);
            JOptionPane.showMessageDialog(this, "Factura eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la factura.");
        }
    }//GEN-LAST:event_botonEliminarProductoMouseClicked

    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarProductoActionPerformed

    private void campoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoImpuestoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JButton botonGuardarProducto;
    private javax.swing.JButton botonModificarProducto;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoImpuesto;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturas;
    // End of variables declaration//GEN-END:variables
}
