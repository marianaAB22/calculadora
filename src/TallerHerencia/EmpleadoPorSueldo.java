/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerHerencia;

/**
 *
 * @author Administrator
 */
public class EmpleadoPorSueldo extends Empleado {
    private double sueldoMensual;
    private double retencionFuente;
    private double fondoSolidaridad;
    private double fondoSalud;
    private double fondoPension;

    public EmpleadoPorSueldo(String nombre, String apellido, String numSeguroSocial, double salarioBase) {
        super(nombre, apellido, numSeguroSocial, salarioBase);
        this.sueldoMensual = salarioBase;
        this.retencionFuente = sueldoMensual * 0.1;  
        this.fondoSolidaridad = sueldoMensual * 0.02; 
        this.fondoSalud = sueldoMensual * 0.04;       
        this.fondoPension = sueldoMensual * 0.06;
    }
    
    @Override
    public double calcularDevengado(){
        return sueldoMensual;
    }
    
    @Override
    public double calcularDeducciones(){
        return retencionFuente + fondoSolidaridad + fondoSalud + fondoPension;
    }
    
    @Override
    public double calcularSalarioNeto(){ 
        return calcularDevengado() - calcularDeducciones(); 
    }
    
}
