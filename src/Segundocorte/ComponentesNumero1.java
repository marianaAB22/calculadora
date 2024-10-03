/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Segundocorte;

import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Administrator
 */
public class ComponentesNumero1 extends javax.swing.JFrame {

    /**
     * Creates new form ComponentesNumero1
     */
    public ComponentesNumero1() {
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        comboBoxProgramas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingeniería de Sistemas", "Medicina", "Derecho", "Psicologia", "Administracion" }));
        barraProgreso.setForeground(Color.GREEN); 
        barraProgreso.setUI(new BasicProgressBarUI());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100); 
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true); 
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        opcionFacultadIng = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoCarta = new javax.swing.JTextArea();
        botonEnviarCarta = new javax.swing.JToggleButton();
        titulo = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        textoApellido = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        textoCarta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoNacionalidad = new javax.swing.JLabel();
        campoNacionalidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoFacultad = new javax.swing.JLabel();
        opcionFacultadHumanidades = new javax.swing.JCheckBox();
        opcionFacultadSalud = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        comboBoxProgramas = new javax.swing.JComboBox<>();
        campoSegundoApellido = new javax.swing.JTextField();
        textoSegundoApellido = new javax.swing.JLabel();
        textoDosisCovid = new javax.swing.JLabel();
        opcionUnaDosis = new javax.swing.JRadioButton();
        opcionDosDosis = new javax.swing.JRadioButton();
        opcionTresDosis = new javax.swing.JRadioButton();
        opcionNingunaDosis = new javax.swing.JRadioButton();
        barraProgreso = new javax.swing.JProgressBar();
        botonInstructivo = new javax.swing.JToggleButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        opcionFacultadIng.setText("Ingenieria");
        opcionFacultadIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionFacultadIngActionPerformed(evt);
            }
        });

        campoCarta.setColumns(20);
        campoCarta.setRows(5);
        jScrollPane1.setViewportView(campoCarta);

        botonEnviarCarta.setText("ENVIAR");
        botonEnviarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarCartaActionPerformed(evt);
            }
        });

        titulo.setText("FORMULARIO DE INGRESO");

        textoNombre.setText("NOMBRE DEL ASPIRANTE");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        textoApellido.setText("APELLIDO DEL ASPIRANTE");

        campoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidoActionPerformed(evt);
            }
        });

        textoCarta.setText("ESCRIBA SU CARTA DE MOTIVACION");

        jLabel4.setText("UAM");

        textoNacionalidad.setText("NACIONALIDAD:");

        campoNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNacionalidadActionPerformed(evt);
            }
        });

        textoFacultad.setText("FACULTAD:");

        opcionFacultadHumanidades.setText("Humanidades");
        opcionFacultadHumanidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionFacultadHumanidadesActionPerformed(evt);
            }
        });

        opcionFacultadSalud.setText("Salud");
        opcionFacultadSalud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionFacultadSaludActionPerformed(evt);
            }
        });

        jLabel8.setText("PROGRAMA");

        comboBoxProgramas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProgramasActionPerformed(evt);
            }
        });

        campoSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSegundoApellidoActionPerformed(evt);
            }
        });

        textoSegundoApellido.setText("SEGUNDO APELLIDO");

        textoDosisCovid.setText("¿Cuantas dosis tiene contra el covid?");

        opcionUnaDosis.setText("Unica dosis");
        opcionUnaDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionUnaDosisActionPerformed(evt);
            }
        });

        opcionDosDosis.setText("Dos dosis");
        opcionDosDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionDosDosisActionPerformed(evt);
            }
        });

        opcionTresDosis.setText("Tres dosis");
        opcionTresDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionTresDosisActionPerformed(evt);
            }
        });

        opcionNingunaDosis.setText("Ninguna");
        opcionNingunaDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionNingunaDosisActionPerformed(evt);
            }
        });

        botonInstructivo.setText("SI LO DESEO");
        botonInstructivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInstructivoActionPerformed(evt);
            }
        });

        jLabel1.setText("¿Cuál es su percepcion de la Universidad?");

        jLabel2.setText("puntue en una escala del 1 al 10");

        jLabel3.setText("1");

        jLabel5.setText("10");

        jLabel9.setText("Presione si desea un instructivo virtual");

        jLabel10.setText("de matricula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(559, 559, 559)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)
                                .addComponent(textoFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(jLabel1)))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoApellido)
                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoSegundoApellido))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(opcionFacultadIng)
                            .addComponent(comboBoxProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoDosisCovid)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(opcionUnaDosis)
                                    .addComponent(opcionDosDosis))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(opcionNingunaDosis)
                                    .addComponent(opcionTresDosis)))
                            .addComponent(opcionFacultadSalud)
                            .addComponent(opcionFacultadHumanidades))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(132, 132, 132))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel7)
                                        .addGap(62, 62, 62))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(botonInstructivo)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(361, 361, 361)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(botonEnviarCarta)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(textoCarta)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNombre)
                    .addComponent(textoFacultad)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(opcionFacultadIng)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoApellido)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(opcionFacultadSalud)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcionFacultadHumanidades)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSegundoApellido)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNacionalidad)
                    .addComponent(textoDosisCovid)
                    .addComponent(botonInstructivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionUnaDosis)
                    .addComponent(opcionTresDosis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionDosDosis)
                    .addComponent(opcionNingunaDosis))
                .addGap(39, 39, 39)
                .addComponent(textoCarta)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEnviarCarta)
                .addGap(24, 24, 24)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionFacultadIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionFacultadIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionFacultadIngActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed

    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidoActionPerformed
    String nombre = this.campoNombre.getText();
    String apellido = this.campoApellido.getText();
    JOptionPane.showMessageDialog(this, "Bienvenido " + nombre + " " + apellido, "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_campoApellidoActionPerformed

    private void botonEnviarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarCartaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, 
        "¿seguro que desea enviar la informacion?", 
        "Confirmacion de envio", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Informacion enviada correctamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } else if (respuesta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "El envio ha sido cancelado", "Cancelacion", JOptionPane.INFORMATION_MESSAGE);
        }
        
        for (int i = 0; i <= 100; i += 10) { 
        barraProgreso.setValue(i); 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_botonEnviarCartaActionPerformed

    private void campoNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNacionalidadActionPerformed

    private void opcionFacultadHumanidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionFacultadHumanidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionFacultadHumanidadesActionPerformed

    private void opcionFacultadSaludActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionFacultadSaludActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionFacultadSaludActionPerformed

    private void comboBoxProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProgramasActionPerformed
        
    }//GEN-LAST:event_comboBoxProgramasActionPerformed

    private void campoSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSegundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSegundoApellidoActionPerformed

    private void opcionUnaDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionUnaDosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionUnaDosisActionPerformed

    private void opcionDosDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionDosDosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionDosDosisActionPerformed

    private void opcionTresDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionTresDosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionTresDosisActionPerformed

    private void opcionNingunaDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionNingunaDosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionNingunaDosisActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void botonInstructivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstructivoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, 
        "¿desea que se le envie el instructivo al correo proporcionado en la ficha de inscripcion?", 
        "Confirmacion de envio", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "informacion enviada al correo", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } else if (respuesta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "El envio ha sido cancelado", "Cancelacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonInstructivoActionPerformed

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
            java.util.logging.Logger.getLogger(ComponentesNumero1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComponentesNumero1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComponentesNumero1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComponentesNumero1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComponentesNumero1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JToggleButton botonEnviarCarta;
    private javax.swing.JToggleButton botonInstructivo;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextArea campoCarta;
    private javax.swing.JTextField campoNacionalidad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoSegundoApellido;
    private javax.swing.JComboBox<String> comboBoxProgramas;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton opcionDosDosis;
    private javax.swing.JCheckBox opcionFacultadHumanidades;
    private javax.swing.JCheckBox opcionFacultadIng;
    private javax.swing.JCheckBox opcionFacultadSalud;
    private javax.swing.JRadioButton opcionNingunaDosis;
    private javax.swing.JRadioButton opcionTresDosis;
    private javax.swing.JRadioButton opcionUnaDosis;
    private javax.swing.JLabel textoApellido;
    private javax.swing.JLabel textoCarta;
    private javax.swing.JLabel textoDosisCovid;
    private javax.swing.JLabel textoFacultad;
    private javax.swing.JLabel textoNacionalidad;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoSegundoApellido;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
