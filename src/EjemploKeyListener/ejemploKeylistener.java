/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjemploKeyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class ejemploKeylistener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("MI VENTANA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800,600);
        ventana.setLayout(null);
        JTextField campo1 = new JTextField();
        campo1.setBounds(100,100,100,15);
        ventana.add(campo1);
        campo1.addKeyListener(new KeyAdapter(){

            public void KeyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    JOptionPane.showMessageDialog(ventana, "LE DISTE A LA TECLA ENTER", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
                if (e.getKeyCode() == KeyEvent.VK_Z){
                    JOptionPane.showMessageDialog(ventana, "LE DISTE A LA TECLA Z", "INFO", JOptionPane.INFORMATION_MESSAGE);    
                }
                String texto = campo1.getText();
                texto = texto.substring(0,texto.length()-2);
                campo1.setText(texto);
            }        
        });
        ventana.setVisible(true);
    }
    
}
