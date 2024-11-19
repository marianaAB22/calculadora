/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taller2TercerCorte;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrator
 */
public class VentanaProductos extends javax.swing.JFrame {

    /**
     * Creates new form VentanaProductos
     */
    public VentanaProductos() {
        initComponents();
    }
    public boolean guardarProductosDocumento(String nombre, String precio, String categoria, String codigo) {
        try {
            File archivo = new File("productosPrueba.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document documento;

            if(archivo.exists()) {
                documento = builder.parse(archivo);
            }else{
                documento = builder.newDocument();
                Element root = documento.createElement("productos");
                documento.appendChild(root);
            }

            //Crear el nuevo producto
            Element producto1 = documento.createElement("producto");
            Element nombre1 = documento.createElement("nombre");
            nombre1.appendChild(documento.createTextNode(nombre));
            producto1.appendChild(nombre1);

            Element precio1 = documento.createElement("precio");
            precio1.appendChild(documento.createTextNode(precio));
            producto1.appendChild(precio1);

            Element categoria1 = documento.createElement("categoria");
            categoria1.appendChild(documento.createTextNode(categoria));
            producto1.appendChild(categoria1);

            Element codigo1 = documento.createElement("codigo");
            codigo1.appendChild(documento.createTextNode(codigo));
            producto1.appendChild(codigo1);

            Element root = (Element) documento.getDocumentElement();
            root.appendChild(producto1);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(documento);
            StreamResult result = new StreamResult(archivo);
            transformer.transform(domSource, result);

            System.out.println("SE HA ACTUALIZADO EL ARCHIVO XML");
            return true;

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
public org.w3c.dom.Document leerXML() {
    try {
        File file = new File("productosPrueba.xml");
        if (!file.exists()) {
            System.out.println("El archivo XML no existe.");
            return null;
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document documento = builder.parse(file);
        return documento;
    } catch (Exception e) {
        System.out.println("Error al leer el archivo XML: " + e.getMessage());
    }
    return null;
}


    
public void escribirXML(org.w3c.dom.Document documento) {
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(documento);
        File file = new File("productosPrueba.xml");
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    } catch (Exception e) {
        System.out.println("Error al escribir el XML: " + e.getMessage());
    }
}

    
    public boolean modificarProductoDocumento(String nombre, String nuevoNombre, String nuevoPrecio, String nuevaCategoria, String nuevoCodigo) {
        try {
            File archivo = new File("productosPrueba.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document documento = builder.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList productos = documento.getElementsByTagName("producto");
            for (int i = 0; i < productos.getLength(); i++) {
                Node nodo = productos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element producto = (Element) nodo;
                    String nombreProducto = producto.getElementsByTagName("nombre").item(0).getTextContent();

                    if (nombreProducto.equals(nombre)) {
                        producto.getElementsByTagName("nombre").item(0).setTextContent(nuevoNombre);
                        producto.getElementsByTagName("precio").item(0).setTextContent(nuevoPrecio);
                        producto.getElementsByTagName("categoria").item(0).setTextContent(nuevaCategoria);
                        producto.getElementsByTagName("codigo").item(0).setTextContent(nuevoCodigo);
  
                        escribirXML((org.w3c.dom.Document)documento);
                        return true;
                    }
                }
            }
        return false;
    }catch(Exception e){
        System.out.println("Error al modificar el producto: " + e.getMessage());
        return false;
    }
}
    
public boolean eliminarProductoDocumento(String nombre) {
    try {
        File archivo = new File("productosPrueba.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document documento = builder.parse(archivo);
        documento.getDocumentElement().normalize();

        NodeList productos = documento.getElementsByTagName("producto");
        for (int i = 0; i < productos.getLength(); i++) {
            Node nodo = productos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element producto = (Element) nodo;
                String nombreProducto = producto.getElementsByTagName("nombre").item(0).getTextContent();
                if (nombreProducto.equals(nombre)) {
                    producto.getParentNode().removeChild(producto);

                    escribirXML(documento);
                    return true;
                }
            }
        }
        return false;
    } catch (Exception e) {
        System.out.println("Error al eliminar el producto: " + e.getMessage());
        return false;
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
        campoNombreProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoPrecioProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCategoriaProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoCodigoProducto = new javax.swing.JTextField();
        botonGuardarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonCargar = new javax.swing.JButton();
        botonModificarProducto = new javax.swing.JButton();
        botonEliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("!BIENVENIDO AL APARTADO DE AGREGAR PRODUCTO¡");

        campoNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreProductoActionPerformed(evt);
            }
        });

        jLabel2.setText(" NOMBRE:");

        jLabel3.setText("PRECIO:");

        campoPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioProductoActionPerformed(evt);
            }
        });

        jLabel4.setText("CATEGORIA:");

        campoCategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCategoriaProductoActionPerformed(evt);
            }
        });

        jLabel5.setText("CODIGO:");

        campoCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCodigoProductoActionPerformed(evt);
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

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "PRECIO", "CATEGORIA", "CODIGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        botonCargar.setText("CARGAR");
        botonCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCargarMouseClicked(evt);
            }
        });
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5)
                                                    .addComponent(botonCargar)))))
                                    .addComponent(botonGuardarProducto))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(campoPrecioProducto)
                                            .addComponent(campoCategoriaProducto)
                                            .addComponent(campoCodigoProducto)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(botonModificarProducto)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonEliminarProducto))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCargar)
                    .addComponent(botonGuardarProducto)
                    .addComponent(botonModificarProducto)
                    .addComponent(botonEliminarProducto))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreProductoActionPerformed

    private void campoPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioProductoActionPerformed

    private void campoCategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCategoriaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCategoriaProductoActionPerformed

    private void campoCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCodigoProductoActionPerformed

    private void botonGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarProductoActionPerformed
        String nombre = campoNombreProducto.getText();
        String precio = campoPrecioProducto.getText();
        String categoria = campoCategoriaProducto.getText();
        String codigo = campoCodigoProducto.getText();

        if (guardarProductosDocumento(nombre, precio, categoria, codigo)) {
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
            model.addRow(new Object[]{nombre, precio, categoria, codigo});
            System.out.println("Producto agregado correctamente a la tabla.");
        }

        campoNombreProducto.setText("");
        campoPrecioProducto.setText("");
        campoCategoriaProducto.setText("");
        campoCodigoProducto.setText("");
    }//GEN-LAST:event_botonGuardarProductoActionPerformed

    private void botonGuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarProductoMouseClicked
        String nombre = campoNombreProducto.getText();
        String precio = campoPrecioProducto.getText();
        String categoria = campoCategoriaProducto.getText();
        String codigo = campoCodigoProducto.getText();

        if(!nombre.isEmpty() && !precio.isEmpty() && !categoria.isEmpty() && !codigo.isEmpty()) {
            guardarProductosDocumento(nombre, precio, categoria, codigo);
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
            model.addRow(new Object[]{nombre, precio, categoria, codigo});
            System.out.println("Producto agregado correctamente a la tabla.");
        }else{
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }//GEN-LAST:event_botonGuardarProductoMouseClicked

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCargarMouseClicked
            try {
            org.w3c.dom.Document documento = (org.w3c.dom.Document) leerXML();
            if (documento == null) {
                System.out.println("No se pudo leer el archivo XML o no existe.");
                return;
            }

            documento.getDocumentElement().normalize();
            org.w3c.dom.NodeList productos = documento.getElementsByTagName("producto");
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
            model.setRowCount(0);

            for (int i = 0; i < productos.getLength(); i++) {
                org.w3c.dom.Node nodo = productos.item(i);
                if (nodo.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    org.w3c.dom.Element producto = (org.w3c.dom.Element) nodo;

                    String nombre = producto.getElementsByTagName("nombre").item(0).getTextContent();
                    String precio = producto.getElementsByTagName("precio").item(0).getTextContent();
                    String categoria = producto.getElementsByTagName("categoria").item(0).getTextContent();
                    String codigo = producto.getElementsByTagName("codigo").item(0).getTextContent();

                    model.addRow(new Object[]{nombre, precio, categoria, codigo});
                }
            }

        } catch (Exception e) {
            System.out.println("Error al cargar los datos en la tabla: " + e.getMessage());
        }
    }//GEN-LAST:event_botonCargarMouseClicked

    private void botonModificarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarProductoMouseClicked
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if(filaSeleccionada != -1){
           String nombre = (String) tablaProductos.getValueAt(filaSeleccionada, 0); // Obtener el nombre del producto seleccionado
           String nuevoNombre = campoNombreProducto.getText();
           String nuevoPrecio = campoPrecioProducto.getText();
           String nuevaCategoria = campoCategoriaProducto.getText();
           String nuevoCodigo = campoCodigoProducto.getText();

           if (modificarProductoDocumento(nombre, nuevoNombre, nuevoPrecio, nuevaCategoria, nuevoCodigo)) {
               tablaProductos.setValueAt(nuevoNombre, filaSeleccionada, 0);
               tablaProductos.setValueAt(nuevoPrecio, filaSeleccionada, 1);
               tablaProductos.setValueAt(nuevaCategoria, filaSeleccionada, 2);
               tablaProductos.setValueAt(nuevoCodigo, filaSeleccionada, 3);
               JOptionPane.showMessageDialog(this, "Producto modificado correctamente.");
           }else{
               JOptionPane.showMessageDialog(this, "No se encontró el producto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
           }
        }else{
           JOptionPane.showMessageDialog(this, "Selecciona un producto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarProductoMouseClicked

    private void botonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonModificarProductoActionPerformed

    private void botonEliminarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarProductoMouseClicked
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = (String) tablaProductos.getValueAt(filaSeleccionada, 0); // Obtener el nombre del producto seleccionado

            if(eliminarProductoDocumento(nombre)){

                DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
                model.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
            }else{
                JOptionPane.showMessageDialog(this, "No se encontró el producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarProductoMouseClicked

    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JButton botonGuardarProducto;
    private javax.swing.JButton botonModificarProducto;
    private javax.swing.JTextField campoCategoriaProducto;
    private javax.swing.JTextField campoCodigoProducto;
    private javax.swing.JTextField campoNombreProducto;
    private javax.swing.JTextField campoPrecioProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
