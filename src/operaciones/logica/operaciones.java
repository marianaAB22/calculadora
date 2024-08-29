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
        resultado = 0;

    }
    
    public double Sumar(float num1, float num2){
        double suma = num1+num2;
        resultado += suma;
        return suma;
    }
    
    public double Restar(float num1, float num2){
        double resta = num1-num2;
        resultado += resta;
        return resta;
    }

    public double Multiplicar(float num1, float num2){
        double multi = num1*num2;
        resultado += multi;
        return multi;
    }
    public double Dividir(float num1, float num2){
        double divi = num1/num2;
        resultado += divi;
        return divi;
    }
}
