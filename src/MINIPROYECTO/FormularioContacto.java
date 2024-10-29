/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MINIPROYECTO;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 */
/**
 *
 * @author Administrator
 */
public class FormularioContacto extends javax.swing.JPanel {

    private static final int TOTAL_CAMPOS = 5; 
    private int progresoPorCampo; 
    
    public FormularioContacto() {
        initComponents();
        
        //botonGruop
        buttonGroup1.add(RadioButtonOpcionSoltero);
        buttonGroup1.add(RadioButtonOpcionCasado);
        buttonGroup1.add(RadioButtonOpcionUnion);
        buttonGroup1.add(RadioButtonOpcionDivorciado);
        
       
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
       
        progresoPorCampo = 100 / TOTAL_CAMPOS;

        agregarDocumentListener(campo1Nombre);
        agregarDocumentListener(campo2Apellido);
        agregarDocumentListener(campo3Telefono);
        agregarDocumentListener(campo4Correo);
        agregarDocumentListener(campo5Direccion);
        
        RadioButtonOpcionSoltero.addActionListener(e -> actualizarProgreso());
        RadioButtonOpcionCasado.addActionListener(e -> actualizarProgreso());
        RadioButtonOpcionUnion.addActionListener(e -> actualizarProgreso());
        RadioButtonOpcionDivorciado.addActionListener(e -> actualizarProgreso());
         
    }
    
    //METODOS
    //barra de progreso
    private void actualizarProgreso() {
        int camposLlenos = 0;
        if (!campo1Nombre.getText().trim().isEmpty()) camposLlenos++;
        if (!campo2Apellido.getText().trim().isEmpty()) camposLlenos++;
        if (!campo3Telefono.getText().trim().isEmpty()) camposLlenos++;
        if (!campo4Correo.getText().trim().isEmpty()) camposLlenos++;
        if (!campo5Direccion.getText().trim().isEmpty()) camposLlenos++;

        if (RadioButtonOpcionSoltero.isSelected() || 
            RadioButtonOpcionCasado.isSelected() || 
            RadioButtonOpcionUnion.isSelected() || 
            RadioButtonOpcionDivorciado.isSelected()) {
            camposLlenos++;
        }
        int progreso = Math.min(camposLlenos * progresoPorCampo, 100); 
        barraProgreso.setValue(progreso);
      
        if (camposLlenos >= TOTAL_CAMPOS + 1) { 
            barraProgreso.setValue(100);
        }
    }
    private void agregarDocumentListener(JTextField campo) {
        campo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarProgreso();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarProgreso();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarProgreso();
            }
        });
    }
    
    
    //Geters
    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public JTextField getCampo1Nombre() {
        return campo1Nombre;
    }

    public JTextField getCampo2Apellido() {
        return campo2Apellido;
    }

    public JTextField getCampo3Telefono() {
        return campo3Telefono;
    }

    public JTextField getCampo4Correo() {
        return campo4Correo;
    }

    public JTextField getCampo5Direccion() {
        return campo5Direccion;
    }
    
    //Setter para establecer el estado civil
    public void setEstadoCivil(String estadoCivil) {
        RadioButtonOpcionSoltero.setSelected(false);
        RadioButtonOpcionCasado.setSelected(false);
        RadioButtonOpcionUnion.setSelected(false);
        RadioButtonOpcionDivorciado.setSelected(false);
        
        switch(estadoCivil) {
            case "Soltero":
                RadioButtonOpcionSoltero.setSelected(true);
                break;
            case "Casado":
                RadioButtonOpcionCasado.setSelected(true);
                break;
            case "Unido":
                RadioButtonOpcionUnion.setSelected(true);
                break;
            case "Divorciado":
                RadioButtonOpcionDivorciado.setSelected(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                break;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campo1Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campo2Apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo3Telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campo4Correo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campo5Direccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        RadioButtonOpcionSoltero = new javax.swing.JRadioButton();
        RadioButtonOpcionCasado = new javax.swing.JRadioButton();
        RadioButtonOpcionUnion = new javax.swing.JRadioButton();
        RadioButtonOpcionDivorciado = new javax.swing.JRadioButton();
        botonGuardarCambios = new javax.swing.JButton();
        botonCancelarCambios = new javax.swing.JButton();
        BotonAgregarImagen = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        barraProgreso = new javax.swing.JProgressBar();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jLabel1.setText("¡BIENVENIDO AL APARTADO DE AGREGAR/EDITAR CONTACTO!");

        jLabel2.setText("Por favor rellena los campos para agregar el nuevo contacto");

        jLabel3.setText("Nombre:");

        campo1Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo1NombreActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellido:");

        campo2Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo2ApellidoActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero de telefono:");

        campo3Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo3TelefonoActionPerformed(evt);
            }
        });

        jLabel6.setText("Correo Electronico:");

        campo4Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo4CorreoActionPerformed(evt);
            }
        });

        jLabel7.setText("Direccion:");

        campo5Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo5DireccionActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado Civil");

        RadioButtonOpcionSoltero.setText("Soltero");

        RadioButtonOpcionCasado.setText("Casado");
        RadioButtonOpcionCasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonOpcionCasadoActionPerformed(evt);
            }
        });

        RadioButtonOpcionUnion.setText("Union libre");

        RadioButtonOpcionDivorciado.setText("Divorciado");
        RadioButtonOpcionDivorciado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonOpcionDivorciadoActionPerformed(evt);
            }
        });

        botonGuardarCambios.setText("GUARDAR");
        botonGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarCambiosMouseClicked(evt);
            }
        });
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });

        botonCancelarCambios.setText("CANCELAR");
        botonCancelarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarCambiosActionPerformed(evt);
            }
        });

        BotonAgregarImagen.setText("AGREGAR IMAGEN");
        BotonAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarImagenActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVolverMouseClicked(evt);
            }
        });
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonGuardarCambios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCancelarCambios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonAgregarImagen))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel5))
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RadioButtonOpcionSoltero)
                                    .addComponent(RadioButtonOpcionUnion)
                                    .addComponent(RadioButtonOpcionDivorciado)
                                    .addComponent(RadioButtonOpcionCasado)
                                    .addComponent(jLabel8)))
                            .addComponent(campo3Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)))
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo2Apellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo1Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo5Direccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo4Correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botonVolver)
                .addContainerGap(593, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo1Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo5Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(RadioButtonOpcionCasado)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(RadioButtonOpcionDivorciado)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo2Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo4Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RadioButtonOpcionSoltero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campo3Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(RadioButtonOpcionUnion)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarCambios)
                    .addComponent(botonCancelarCambios)
                    .addComponent(BotonAgregarImagen))
                .addGap(45, 45, 45)
                .addComponent(botonVolver)
                .addGap(18, 18, 18)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo1NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo1NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo1NombreActionPerformed

    private void campo2ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo2ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo2ApellidoActionPerformed

    private void campo3TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo3TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo3TelefonoActionPerformed

    private void campo4CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo4CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo4CorreoActionPerformed

    private void campo5DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo5DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo5DireccionActionPerformed

    private void RadioButtonOpcionCasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonOpcionCasadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonOpcionCasadoActionPerformed

    private void RadioButtonOpcionDivorciadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonOpcionDivorciadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonOpcionDivorciadoActionPerformed

    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed

    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void botonCancelarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarCambiosActionPerformed
        JOptionPane.showMessageDialog(null, "Cancelacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        campo1Nombre.setText("");
        campo2Apellido.setText("");
        campo3Telefono.setText("");
        campo4Correo.setText("");
        campo5Direccion.setText("");
        buttonGroup1.clearSelection();
        barraProgreso.setValue(0);
    }//GEN-LAST:event_botonCancelarCambiosActionPerformed

    private void BotonAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarImagenActionPerformed

    }//GEN-LAST:event_BotonAgregarImagenActionPerformed

    private void botonGuardarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarCambiosMouseClicked
        //Captura los datos de los campos
        String nombre = campo1Nombre.getText();
        String apellido = campo2Apellido.getText();
        String telefono = campo3Telefono.getText();
        String correo = campo4Correo.getText();
        String direccion = campo5Direccion.getText();

        String estadoCivil = "";
        if(RadioButtonOpcionSoltero.isSelected()) {
            estadoCivil = "Soltero";
        }else if(RadioButtonOpcionCasado.isSelected()) {
            estadoCivil = "Casado";
        }else if(RadioButtonOpcionUnion.isSelected()) {
            estadoCivil = "Unión libre";
        }else if(RadioButtonOpcionDivorciado.isSelected()) {
            estadoCivil = "Divorciado";
        }

        //Verifica si todos los campos estan llenos
        if(nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || correo.isEmpty() || direccion.isEmpty() || 
            !(RadioButtonOpcionSoltero.isSelected() || RadioButtonOpcionCasado.isSelected() || 
            RadioButtonOpcionUnion.isSelected() || RadioButtonOpcionDivorciado.isSelected())) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos y seleccione un estado civil.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } 
        else if(!correo.contains("@") || !correo.contains(".") || correo.indexOf('@') > correo.lastIndexOf('.')) {
            JOptionPane.showMessageDialog(null, "El correo debe contener '@' y un dominio valido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else{
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                "¿Seguro quieres guardar los cambios?", 
                "Confirmacion", 
                JOptionPane.YES_NO_OPTION
            );
            if(respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Informacion guardada correctamente.", 
                    "Informacion", 
                    JOptionPane.INFORMATION_MESSAGE
                );
                JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
                if(framePrincipal instanceof ventanaPrincipal) {
                    ventanaPrincipal VentanaPrincipal = (ventanaPrincipal) framePrincipal;
                    VentanaPrincipal.agregarContacto(nombre, apellido, telefono, correo, direccion, estadoCivil);
                }else{
                    JOptionPane.showMessageDialog(
                        null, 
                        "La informacion no se guardo.", 
                        "Cancelado", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        } 
    }//GEN-LAST:event_botonGuardarCambiosMouseClicked

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed

    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVolverMouseClicked
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        if(framePrincipal instanceof ventanaPrincipal) {
            ventanaPrincipal VentanaPrincipal = (ventanaPrincipal) framePrincipal;
            VentanaPrincipal.mostrarVentanaPrincipal();
            
            campo1Nombre.setText("");
            campo2Apellido.setText("");
            campo3Telefono.setText("");
            campo4Correo.setText("");
            campo5Direccion.setText("");
            buttonGroup1.clearSelection(); 
            
        }
    }//GEN-LAST:event_botonVolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarImagen;
    private javax.swing.JRadioButton RadioButtonOpcionCasado;
    private javax.swing.JRadioButton RadioButtonOpcionDivorciado;
    private javax.swing.JRadioButton RadioButtonOpcionSoltero;
    private javax.swing.JRadioButton RadioButtonOpcionUnion;
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton botonCancelarCambios;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botonVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField campo1Nombre;
    private javax.swing.JTextField campo2Apellido;
    private javax.swing.JTextField campo3Telefono;
    private javax.swing.JTextField campo4Correo;
    private javax.swing.JTextField campo5Direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    // End of variables declaration//GEN-END:variables
}
