/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class EventoMouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("EJEMPLO MOUSECLICKED");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);

        
        JLabel labelPrimerNumero = new JLabel("PRIMER NUMERO");
        JTextField campoPrimerNumero = new JTextField();
        labelPrimerNumero.setBounds(400, 50, 150, 25);
        campoPrimerNumero.setBounds(550, 50, 150, 25);
        
        JLabel labelSegundoNumero = new JLabel("INGRESE EL NUMERO 2");
        JTextField campoSegundoNumero = new JTextField();
        labelSegundoNumero.setBounds(400, 50, 150, 25);
        campoSegundoNumero.setBounds(550, 50, 150, 25);
        
        JButton botonNumero1 = new JButton("1");
        botonNumero1.setBounds(150,80, 30,25);
        JButton botonNumero2 = new JButton("2");
        botonNumero2.setBounds(150,80, 30,25);
        JButton botonNumero3 = new JButton("3");
        botonNumero3.setBounds(150,80, 30,25);
        
        JButton botonSumar = new JButton("SUMAR");
        botonSumar.setBounds(250, 120, 100, 25);
        
        ventana.add(labelPrimerNumero);
        ventana.add(campoPrimerNumero);
        ventana.add(labelSegundoNumero);
        ventana.add(campoSegundoNumero);
        ventana.add(botonNumero1);
        ventana.add(botonNumero2);
        ventana.add(botonNumero3);
        ventana.add(botonSumar);
        
        
        botonSumar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                /**
                int numero1 = Integer.parseInt(campoNumero1.getText());
                int numero2 = Integer.parseInt(campoNumero2.getText());
                int resultado = numero1 + numero2;
                
                JOptionPane.showMessageDialog(null, "EL RESULTADO ES: " + resultado, "INFO",JOptionPane.INFORMATION_MESSAGE );
                */
                String numero1 = "1";
                String PrimerNumero = campoPrimerNumero.getText();
                String SegundoNumero = campoSegundoNumero.getText();
                if (PrimerNumero.equals("")){
                    campoPrimerNumero.setText(numero1);
                }
                else if(SegundoNumero.equals("")){
                    campoPrimerNumero.setText(numero1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
        
        
        
        
        
        ventana.setLayout(null);
        ventana.setVisible(true);
    }
    
}
