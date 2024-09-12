/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploJLabel;

import javax.swing.*;


/**
 *
 * @author Administrator
 */
public class ejemploJLabel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("mi primera ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLayout(null);
        
        JLabel etiqueta = new JLabel("mi calculadora 2");
        etiqueta.setBounds(350, 10, 150, 30);
        ventana.add(etiqueta);
    /**    
        String informacionJLabel = etiqueta.getText();
        System.out.println(informacionJLabel); */ 
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("INGRESE EL NOMBRE:");
        etiqueta2.setBounds(200, 100, 150, 30);
        ventana.add(etiqueta2);
        
        JTextField campo1 = new JTextField();
        campo1.setBounds(350, 100, 150, 30);
        campo1.setText("MARIANA ALZATE");
        ventana.add(campo1);
        
        JButton boton1 = new JButton("AYUDA");
        boton1.setBounds(300, 150, 150, 30);
        ventana.add(boton1);
        
        String[] opciones= new String[4];
        opciones[0] = "sumar";
        opciones[1] = "restar";
        opciones[2] = "multiplicar";
        opciones[3] = "dividir";
        JComboBox combo1 = new JComboBox(opciones);
        combo1.setBounds(300, 200, 150, 30);
        combo1.setSelectedIndex(2);
        ventana.add(combo1);
 
        
        
        
        
        
        
        
        ventana.setVisible(true);
 
    }
    
}
