/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploKeyType;


import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class EjemploKeyTyped {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("EJEMPLO KEYTYPED");
        ventana.setSize(800,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.setVisible(true);
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(100, 100, 300, 15);
        ventana.add(etiqueta);
        
        ventana.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char letra = e.getKeyChar();
                etiqueta.setText("el usuario presionó la letra: "+ letra);
            }  
        });
    }
}
