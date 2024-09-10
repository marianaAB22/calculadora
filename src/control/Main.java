/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        // Mostrar un mensaje de bienvenida
        JOptionPane.showMessageDialog(null, "BIENVENIDO A MI CALCULADORA");

        // Pedir el nombre del usuario
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        JOptionPane.showMessageDialog(null, "Hola " + nombre + ", estás en la calculadora");
        menu.iniciar();
    }
}
