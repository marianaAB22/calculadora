/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerHerencia;

/**
 *
 * @author Administrator
 */
public class EmpleadoPorHoras extends Empleado {
    private float horasTrabajadas;
    private double tarifaPorHora;
    
    
    public EmpleadoPorHoras(String nombre, String apellido, String numSeguroSocial, double salarioBase, float horasTrabajadas,double tarifaPorHora) {
        super(nombre, apellido, numSeguroSocial, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularDevengado(){
        return horasTrabajadas*tarifaPorHora;
    }
    
    @Override
    public double calcularSalarioNeto(){ 
        return calcularDevengado()-calcularDeducciones();
    }
}
