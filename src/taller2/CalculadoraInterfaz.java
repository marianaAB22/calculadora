/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class CalculadoraInterfaz {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("mi primera ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLayout(null);
        
        JLabel etiqueta = new JLabel("CALCULADORA UAM");
        etiqueta.setBounds(330, 10, 150, 30);
        ventana.add(etiqueta);

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
      
        String[] opciones= new String[4];
        opciones[0] = "sumar";
        opciones[1] = "restar";
        opciones[2] = "multiplicar";
        opciones[3] = "dividir";
        JComboBox combo1 = new JComboBox(opciones);
        combo1.setBounds(310, 150, 150, 30);
        combo1.setSelectedIndex(0);
        ventana.add(combo1);
        
        //FUNCIONES PARA EL MOUSE 

        boton1.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero1 = "1"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero1);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero1);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton2.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero2 = "2"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero2);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero2);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MÁS NÚMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton3.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero3 = "3"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero3);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero3);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton4.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero4 = "4"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero4);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero4);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MÁS NÚMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton5.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero5 = "5"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero5);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero5);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton6.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero6 = "6"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero6);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero6);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton7.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero7 = "7"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero7);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero7);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton8.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero8 = "8"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero8);
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero8); 
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 

        boton9.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero9 = "9"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero9);  
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero9);  
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 

        }); 

  

        boton0.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                String numero0 = "0"; 
                String PrimerNumero = campo1.getText(); 
                String SegundoNumero = campo2.getText(); 
                if (PrimerNumero.equals("")) { 
                    campo1.setText(numero0); 
                } else if (SegundoNumero.equals("")) { 
                    campo2.setText(numero0); 
                } else { 
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INGRESAR MAS NUMEROS", "INFO", JOptionPane.INFORMATION_MESSAGE); 
                } 
            } 
        }); 
 
        //OPERACIONES BOTON CALCULAR
        botonCalcular.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                double num1 = Double.parseDouble(campo1.getText()); 
                double num2 = Double.parseDouble(campo2.getText()); 
                String operacion = (String) combo1.getSelectedItem(); 
                double resultado = 0; 
                switch (operacion) { 
                    case "sumar": 
                        resultado = num1 + num2; 
                        break; 
                    case "restar": 
                        resultado = num1 - num2; 
                        break; 
                    case "multiplicar": 
                        resultado = num1 * num2; 
                        break; 
                    case "dividir": 
                        if (num2 != 0) { 
                            resultado = num1 / num2; 
                        } else { 
                            JOptionPane.showMessageDialog(ventana, "No se puede dividir entre 0"); 
                            return; 
                        } 
                        break; 
                    default: 
                        JOptionPane.showMessageDialog(ventana, "Operacion no valida"); 
                        return; 
                } 
                JOptionPane.showMessageDialog(ventana, "El resultado es: " + resultado); 

            } 

        }); 

        ventana.setLayout(null); 
        ventana.setVisible(true); 

    } 

    
}
