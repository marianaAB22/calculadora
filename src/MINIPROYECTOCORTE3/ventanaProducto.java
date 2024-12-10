/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MINIPROYECTOCORTE3;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrator
 */
public class ventanaProducto extends javax.swing.JFrame {

    /**
     * Creates new form ventanaProducto
     */
    public ventanaProducto() {
        initComponents();
        cargarProductosDesdeXML();
    }
    
    
    public void GuardarProductoEnTablaYXML(String codigo, String nombre, String precio, String categoria) {
        if (productoExisteEnTabla(codigo)) {
            JOptionPane.showMessageDialog(this, "El producto con el código " + codigo + " ya existe en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (productoExisteEnXML(codigo)) {
            JOptionPane.showMessageDialog(this, "El producto con el código " + codigo + " ya existe en el archivo XML.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        agregarProductoATabla(codigo, nombre, precio, categoria);
        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (!archivoXML.exists()) {
                crearArchivoXML(codigo, nombre, precio, categoria);
            } else {
                agregarProductoAArchivoXML(codigo, nombre, precio, categoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar producto en XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    private void agregarProductoATabla(String codigo, String nombre, String precio, String categoria) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tablaFormularioProductos.getModel();
        model.addRow(new Object[]{codigo, nombre, precio, categoria});
    }



    private void crearArchivoXML(String codigo, String nombre, String precio, String categoria) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("Productos");
        doc.appendChild(rootElement);
        agregarProductoADocumento(doc, rootElement, codigo, nombre, precio, categoria);
        guardarDocumentoXML(doc);
    }

    private void agregarProductoAArchivoXML(String codigo, String nombre, String precio, String categoria) throws Exception {
        if (productoExisteEnXML(codigo)) {
            JOptionPane.showMessageDialog(this, "El producto con código " + codigo + " ya existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("documentoProyecto.xml"));
        doc.getDocumentElement().normalize();
        Element rootElement = doc.getDocumentElement();
        agregarProductoADocumento(doc, rootElement, codigo, nombre, precio, categoria);
        guardarDocumentoXML(doc);
    }


    private void agregarProductoADocumento(Document doc, Element rootElement, String codigo, String nombre, String precio, String categoria) {
        Element producto = doc.createElement("Producto");
        rootElement.appendChild(producto);
        Element codigoElement = doc.createElement("Codigo");
        codigoElement.appendChild(doc.createTextNode(codigo));
        producto.appendChild(codigoElement);
        Element nombreElement = doc.createElement("Nombre");
        nombreElement.appendChild(doc.createTextNode(nombre));
        producto.appendChild(nombreElement);
        Element precioElement = doc.createElement("Precio");
        precioElement.appendChild(doc.createTextNode(precio));
        producto.appendChild(precioElement);
        Element categoriaElement = doc.createElement("Categoria");
        categoriaElement.appendChild(doc.createTextNode(categoria));
        producto.appendChild(categoriaElement);
    }

    private void guardarDocumentoXML(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("documentoProyecto.xml"));
        transformer.transform(source, result);
    }
    
    private boolean validarCampos(String codigo, String nombre, String precio, String categoria) {
        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
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
            DefaultTableModel model = (DefaultTableModel) tablaFormularioProductos.getModel();
            model.setRowCount(0);

            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) producto;

                    String codigo = elemento.getElementsByTagName("Codigo").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                    String precio = elemento.getElementsByTagName("Precio").item(0).getTextContent();
                    String categoria = elemento.getElementsByTagName("Categoria").item(0).getTextContent();

                    model.addRow(new Object[]{codigo, nombre, precio, categoria});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos desde XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarProductoDeTablaYXML() {
        int filaSeleccionada = tablaFormularioProductos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String codigo = tablaFormularioProductos.getValueAt(filaSeleccionada, 0).toString();
        DefaultTableModel model = (DefaultTableModel) tablaFormularioProductos.getModel();
        model.removeRow(filaSeleccionada);
        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (!archivoXML.exists()) return;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            NodeList productos = doc.getElementsByTagName("Producto");

            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);

                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) producto;
                    String codigoXML = elemento.getElementsByTagName("Codigo").item(0).getTextContent();

                    if (codigoXML.equals(codigo)) {
                        elemento.getParentNode().removeChild(elemento);
                        break;
                    }
                }
            }
            guardarDocumentoXML(doc);
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            if (model.getRowCount() == 0) {
                if (archivoXML.exists()) {
                    archivoXML.delete();
                    JOptionPane.showMessageDialog(this, "Todos los productos han sido eliminados. El archivo XML ha sido eliminado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar producto del archivo XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void editarProductoEnTablaYXML() {
        int filaSeleccionada = tablaFormularioProductos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String codigoActual = tablaFormularioProductos.getValueAt(filaSeleccionada, 0).toString();
        String nuevoCodigo = JOptionPane.showInputDialog(this, "Nuevo Código:", codigoActual);
        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre:", tablaFormularioProductos.getValueAt(filaSeleccionada, 1).toString());
        String nuevoPrecio = JOptionPane.showInputDialog(this, "Nuevo Precio:", tablaFormularioProductos.getValueAt(filaSeleccionada, 2).toString());
        String nuevaCategoria = JOptionPane.showInputDialog(this, "Nueva Categoría:", tablaFormularioProductos.getValueAt(filaSeleccionada, 3).toString());

        if (nuevoCodigo == null || nuevoNombre == null || nuevoPrecio == null || nuevaCategoria == null || 
            nuevoCodigo.isEmpty() || nuevoNombre.isEmpty() || nuevoPrecio.isEmpty() || nuevaCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tablaFormularioProductos.getModel();
        model.setValueAt(nuevoCodigo, filaSeleccionada, 0);
        model.setValueAt(nuevoNombre, filaSeleccionada, 1);
        model.setValueAt(nuevoPrecio, filaSeleccionada, 2);
        model.setValueAt(nuevaCategoria, filaSeleccionada, 3);

        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (!archivoXML.exists()) return;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            NodeList productos = doc.getElementsByTagName("Producto");

            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) producto;
                    String codigoXML = elemento.getElementsByTagName("Codigo").item(0).getTextContent();
                    if (codigoXML.equals(codigoActual)) {
                        elemento.getElementsByTagName("Codigo").item(0).setTextContent(nuevoCodigo);
                        elemento.getElementsByTagName("Nombre").item(0).setTextContent(nuevoNombre);
                        elemento.getElementsByTagName("Precio").item(0).setTextContent(nuevoPrecio);
                        elemento.getElementsByTagName("Categoria").item(0).setTextContent(nuevaCategoria);
                        break;
                    }
                }
            }

            guardarDocumentoXML(doc);
            JOptionPane.showMessageDialog(this, "Producto editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al editar producto en el archivo XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private boolean productoExisteEnTabla(String codigo) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tablaFormularioProductos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object cellValue = model.getValueAt(i, 0);
            if (cellValue != null && cellValue.toString().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean productoExisteEnXML(String codigo) {
        try {
            File archivoXML = new File("documentoProyecto.xml");
            if (!archivoXML.exists()) return false;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            NodeList productos = doc.getElementsByTagName("Producto");
            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) producto;
                    if (elemento.getElementsByTagName("Codigo").item(0).getTextContent().equals(codigo)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al verificar existencia en el archivo XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false; 
    }


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        campoCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botonImagenProducto = new javax.swing.JButton();
        botonCrearProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFormularioProductos = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonComprarProductos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("¡BIENVENIDO AL FORMULARIO DE LOS PRODUCTOS!");

        jLabel2.setText("CODIGO:");

        jLabel3.setText("NOMBRE:");

        jLabel4.setText("PRECIO:");

        jLabel5.setText("CATEGORIA:");

        botonImagenProducto.setText("IMAGEN");

        botonCrearProducto.setText("CREAR");
        botonCrearProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCrearProductoMouseClicked(evt);
            }
        });
        botonCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearProductoActionPerformed(evt);
            }
        });

        tablaFormularioProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO", "CATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaFormularioProductos);

        jScrollPane1.setViewportView(jScrollPane2);

        botonEliminar.setText("ELMINAR");
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonEditar.setText("EDITAR");
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonComprarProductos.setText("COMPRAR");
        botonComprarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonComprarProductosMouseClicked(evt);
            }
        });
        botonComprarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botonCrearProducto)))
                        .addGap(57, 57, 57)
                        .addComponent(botonImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonComprarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(botonImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(botonCrearProducto)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonEditar)
                    .addComponent(botonComprarProductos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearProductoActionPerformed

    private void botonCrearProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearProductoMouseClicked
        String codigo = campoCodigo.getText();
        String nombre = campoNombre.getText();
        String categoria = campoCategoria.getText();
        String precioTexto = campoPrecio.getText();
        double precio;

        try {
            precio = Double.parseDouble(precioTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio ingresado no es válido. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (validarCampos(codigo, precioTexto, nombre, categoria)) {
            GuardarProductoEnTablaYXML(codigo, nombre, String.valueOf(precio), categoria);
            campoCodigo.setText("");
            campoNombre.setText("");
            campoPrecio.setText("");
            campoCategoria.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonCrearProductoMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        eliminarProductoDeTablaYXML();
    }//GEN-LAST:event_botonEliminarMouseClicked

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        editarProductoEnTablaYXML();
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonComprarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonComprarProductosActionPerformed

    private void botonComprarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComprarProductosMouseClicked
        new ventanaComprar().setVisible(true);
        dispose();
    }//GEN-LAST:event_botonComprarProductosMouseClicked

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
            java.util.logging.Logger.getLogger(ventanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonComprarProductos;
    private javax.swing.JButton botonCrearProducto;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonImagenProducto;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFormularioProductos;
    // End of variables declaration//GEN-END:variables
}
