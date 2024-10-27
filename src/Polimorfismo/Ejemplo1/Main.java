/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Polimorfismo.Ejemplo1;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        calculadora calculadora1 = new calculadora();
        int resultado = calculadora1.sumar(a,b);
        System.out.println(resultado);
        
        double c = 15;
        double d = 10;
        double resultado2 = calculadora1.sumar(c, d);
        System.out.println(resultado2);
        
    }
    
}
