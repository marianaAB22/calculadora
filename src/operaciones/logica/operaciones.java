/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones.logica;

/**
 *
 * @author Administrator
 */
public class operaciones {
    private double resultado;

    
    public operaciones(){

    }
    
    public double Sumar(float num1, float num2){
        double suma = num1+num2;

        return suma;
    }
    
    public double Restar(float num1, float num2){
        double resta = num1-num2;

        return resta;
    }

    public double Multiplicar(float num1, float num2){
        double multi = num1*num2;

        return multi;
    }
    public double Dividir(float num1, float num2){
        double divi = num1/num2;
        return divi;
    }
}
