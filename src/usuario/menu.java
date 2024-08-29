/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import java.util.Scanner;
import operaciones.logica.operaciones;

/**
 *
 * @author Administrator
 */

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        operaciones calc = new operaciones();
        
        int opcion;

        do {
            System.out.println("Bienvenido a la calculadora\n");
            System.out.println("Escoja que desea hacer:\n");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();
            
            if (opcion == 5) {
                System.out.println("Saliendo del programa...");
                break;
            }

            float a, b;    
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el primer numero, por favor: ");
                    a = scanner.nextFloat();
                    System.out.print("Ingresa el segundo numero, por favor: ");
                    b = scanner.nextFloat();
                    System.out.println("Resultado: " + calc.Sumar(a, b));
                    break;

                case 2:
                    System.out.print("Ingresa el primer numero: ");
                    a = scanner.nextFloat();
                    System.out.print("Ingresa el segundo numero: ");
                    b = scanner.nextFloat();
                    System.out.println("Resultado: " + calc.Restar(a, b));
                    break;

                case 3:
                    System.out.print("Ingresa el primer numero: ");
                    a = scanner.nextFloat();
                    System.out.print("Ingresa el segundo numero: ");
                    b = scanner.nextFloat();
                    System.out.println("Resultado: " + calc.Multiplicar(a, b));
                    break;

                case 4:
                    System.out.print("Ingresa el primer numero: ");
                    a = scanner.nextFloat();
                    System.out.print("Ingresa el segundo numero: ");
                    b = scanner.nextFloat();
                    double resultado = calc.Dividir(a, b);
                    if (Double.isNaN(resultado)) {
                        
                    } else {
                        System.out.println("Resultado: " + resultado);
                    }
                    break;

                default:
                    System.out.println("");
                    break;
            }

            System.out.println(); // Línea en blanco para separación

        } while (opcion != 5);

        scanner.close();
    }
}

