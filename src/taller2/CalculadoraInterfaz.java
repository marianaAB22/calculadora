/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller2;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class CalculadoraInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("mi primera ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLayout(null);
        
        JLabel etiqueta = new JLabel("CALCULADORA UAM");
        etiqueta.setBounds(330, 10, 150, 30);
        ventana.add(etiqueta);
    /**    
        String informacionJLabel = etiqueta.getText();
        System.out.println(informacionJLabel); */ 
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("NUMERO 1:");
        etiqueta2.setBounds(220, 70, 150, 30);
        ventana.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("NUMERO 2:");
        etiqueta3.setBounds(450, 70, 100, 30);
        ventana.add(etiqueta3);
        
        //CAMPOS
        JTextField campo1 = new JTextField();
        campo1.setBounds(220, 100, 100, 30);
        ventana.add(campo1);
        
        JTextField campo2 = new JTextField();
        campo2.setBounds(450, 100, 100, 30);
        //campo2.setText("campo2");
        ventana.add(campo2);
        
        
        //BOTONES
        JButton boton1 = new JButton("1");
        boton1.setBounds(300, 200, 50, 50);
        ventana.add(boton1);
        
        JButton boton2 = new JButton("2");
        boton2.setBounds(360, 200, 50, 50);
        ventana.add(boton2);

        JButton boton3 = new JButton("3");
        boton3.setBounds(420, 200, 50, 50); 
        ventana.add(boton3);

        JButton boton4 = new JButton("4");
        boton4.setBounds(300, 260, 50, 50);
        ventana.add(boton4);

        JButton boton5 = new JButton("5");
        boton5.setBounds(360, 260, 50, 50);
        ventana.add(boton5);

        JButton boton6 = new JButton("6");
        boton6.setBounds(420, 260, 50, 50);
        ventana.add(boton6);

        JButton boton7 = new JButton("7");
        boton7.setBounds(300, 320, 50, 50);
        ventana.add(boton7);

        JButton boton8 = new JButton("8");
        boton8.setBounds(360, 320, 50, 50);
        ventana.add(boton8);

        JButton boton9 = new JButton("9");
        boton9.setBounds(420, 320, 50, 50);
        ventana.add(boton9);

        JButton boton0 = new JButton("0");
        boton0.setBounds(360, 380, 50, 50); 
        ventana.add(boton0);
        
        //OTROS BOTONES
        JButton botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(310, 450, 150, 30);
        ventana.add(botonCalcular);
        
        JButton botonSumar = new JButton("Sumar");
        botonSumar.setBounds(310, 150, 150, 30);
        ventana.add(botonSumar);
        
        
        



 
        ventana.setVisible(true);
    }
    
}
