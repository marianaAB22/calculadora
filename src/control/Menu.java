/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;
import operaciones.logica.operaciones;

public class Menu {

    public operaciones operacion;

    public Menu() {
        this.operacion = new operaciones();
    }

    public void iniciar() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                "Ingrese el numero de la operacion deseada:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicacion\n" +
                "4. Division\n" +
                "5. Salir"
            );


            if (opcion != null) {
         
                float num1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el primer valor por favor:"));
                float num2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el segundo valor por favor"));

                switch (opcion) {
                    case "1":
                        double suma = operacion.Sumar(num1, num2);
                        JOptionPane.showMessageDialog(null, "el resultado es: " + suma);
                        break;
                    case "2":
                        double resta = operacion.Restar(num1, num2);
                        JOptionPane.showMessageDialog(null, "el resultado es" + resta);
                        break;
                    case "3":
                        double multiplicacion = operacion.Multiplicar(num1, num2);
                        JOptionPane.showMessageDialog(null, "el resultado es: " + multiplicacion);
                        break;
                    case "4":
                        if (num2 != 0) {
                            double division = operacion.Dividir(num1, num2);
                            JOptionPane.showMessageDialog(null, "el resultado es: " + division);
                        } else {
                            JOptionPane.showMessageDialog(null, "no se puede dividir pot 0");
                        }
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestra calculadora.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese una opcion valida.");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "nos vemos pronto");
                opcion = "5"; 
            }
        } while (!"5".equals(opcion));
    }
}



                   



