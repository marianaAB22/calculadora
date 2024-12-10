/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MINIPROYECTOCORTE3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrator
 */
public class VentanaInfoFactura extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInfoFactura
     */
    public VentanaInfoFactura() {
        initComponents();
        cargarProductosDesdeXML();
        campoImpuesto.setText("10");
        campoTotal.setText(Double.toString(mostrarTotalFactura()));
    }
    
    private void cargarProductosDesdeXML() {
        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (!archivoXML.exists()) return;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();
            NodeList productos = doc.getElementsByTagName("Producto");
            DefaultTableModel model = (DefaultTableModel) tablaProductosFactura.getModel();
            model.setRowCount(0);

            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) producto;
                    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                    String precio = elemento.getElementsByTagName("Precio").item(0).getTextContent();
                    model.addRow(new Object[]{nombre, precio});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos desde XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double mostrarTotalFactura() {
        double total = 0;
        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (archivoXML.exists()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(archivoXML);
                doc.getDocumentElement().normalize();
                NodeList productos = doc.getElementsByTagName("Producto");
                for (int i = 0; i < productos.getLength(); i++) {
                    Node producto = productos.item(i);
                    if (producto.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) producto;

                        String precioString = elemento.getElementsByTagName("Precio").item(0).getTextContent();
                        double precio = Double.parseDouble(precioString);

                        total += precio;
                    }
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos desde XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        double impuesto = total * 0.10;
        total += impuesto;

        return total;
    }

    
    private void guardarInfoEnJSON() {
        File file = new File("factura.json");
        JsonArray historialFacturas = new JsonArray();

        // Leer el archivo JSON existente, si existe
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                Gson gson = new Gson();
                historialFacturas = gson.fromJson(reader, JsonArray.class);
                if (historialFacturas == null) {
                    historialFacturas = new JsonArray();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo JSON existente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        JsonArray arregloProductos = new JsonArray();
        DefaultTableModel model = (DefaultTableModel) tablaProductosFactura.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            JsonObject producto = new JsonObject();
            producto.addProperty("nombre", model.getValueAt(i, 0).toString());
            producto.addProperty("precio", Double.parseDouble(model.getValueAt(i, 1).toString()));
            arregloProductos.add(producto);
        }
        JsonObject nuevaFactura = new JsonObject();
        nuevaFactura.addProperty("comprador", campoNombreFactura.getText());
        nuevaFactura.addProperty("idComprador", campoIdFactura.getText());
        nuevaFactura.addProperty("direccion", campoDireccionFactura.getText());
        nuevaFactura.addProperty("impuesto", Double.parseDouble(campoImpuesto.getText()));
        nuevaFactura.addProperty("total", Double.parseDouble(campoTotal.getText()));
        nuevaFactura.add("productos", arregloProductos);

        historialFacturas.add(nuevaFactura);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(historialFacturas));
            JOptionPane.showMessageDialog(this, "Factura guardada con éxito en factura.json");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo JSON: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNombreFactura = new javax.swing.JTextField();
        campoIdFactura = new javax.swing.JTextField();
        campoDireccionFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoImpuesto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoTotal = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonGenerarFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductosFactura = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("POR FAVOR INGRESA LOS DATOS PARA GENERAR LA FACTURA");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("IDENTIFICACION:");

        jLabel4.setText("DIRECCION:");

        campoNombreFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreFacturaActionPerformed(evt);
            }
        });

        campoIdFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdFacturaActionPerformed(evt);
            }
        });

        campoDireccionFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionFacturaActionPerformed(evt);
            }
        });

        jLabel5.setText("INFORMACION DEL COMPRADOR");

        jLabel11.setText("IMPUESTO");

        campoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoImpuestoActionPerformed(evt);
            }
        });

        jLabel12.setText("TOTAL");

        campoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTotalActionPerformed(evt);
            }
        });

        botonCancelar.setText("CANCELAR");
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonGenerarFactura.setText("GENERAR FACTURA");
        botonGenerarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGenerarFacturaMouseClicked(evt);
            }
        });
        botonGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarFacturaActionPerformed(evt);
            }
        });

        tablaProductosFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                " NOMBRE", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tablaProductosFactura);

        jLabel13.setText("PRODUCTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(34, 34, 34))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoDireccionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel11)))
                                .addGap(82, 82, 82)
                                .addComponent(jLabel12))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addComponent(jLabel1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(campoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botonCancelar)
                                    .addGap(37, 37, 37)
                                    .addComponent(botonGenerarFactura)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoDireccionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonGenerarFactura))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreFacturaActionPerformed

    private void campoIdFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdFacturaActionPerformed

    private void campoDireccionFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDireccionFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionFacturaActionPerformed

    private void campoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoImpuestoActionPerformed

    private void campoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTotalActionPerformed

    private void botonGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarFacturaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        new ventanaComprar().setVisible(true);
        dispose();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void botonGenerarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarFacturaMouseClicked
        String nombre = campoNombreFactura.getText().trim();
        String identificacion = campoIdFactura.getText().trim();
        String direccion = campoDireccionFactura.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Identificación' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Dirección' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!identificacion.matches("\\d+")) { 
            JOptionPane.showMessageDialog(null, "El campo 'Identificación' debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        guardarInfoEnJSON();
        JOptionPane.showMessageDialog(null, "Se generó la factura", "Información", JOptionPane.INFORMATION_MESSAGE);

        int respuesta = JOptionPane.showConfirmDialog(
            null, 
            "¿Deseas ver el historial de facturas?", 
            "Pregunta", 
            JOptionPane.YES_NO_OPTION
        );

        // Verificar la respuesta del usuario
        if (respuesta == JOptionPane.YES_OPTION) {
            new historialFacturas().setVisible(true);
            dispose();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Gracias por su compra", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Has cerrado el diálogo.");
        }
    }//GEN-LAST:event_botonGenerarFacturaMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaInfoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInfoFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGenerarFactura;
    private javax.swing.JTextField campoDireccionFactura;
    private javax.swing.JTextField campoIdFactura;
    private javax.swing.JTextField campoImpuesto;
    private javax.swing.JTextField campoNombreFactura;
    private javax.swing.JTextField campoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductosFactura;
    // End of variables declaration//GEN-END:variables
}
