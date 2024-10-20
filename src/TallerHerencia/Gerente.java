/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerHerencia;

/**
 *
 * @author Administrator
 */
public class Gerente extends Empleado {
    private double sueldoMensual;
    private double bonoMensual;
    private double retencionFuente;
    private double fondoSalud;
    private double fondoPension;
    private double impuestoRiqueza;

    public Gerente(String nombre, String apellido, String numSeguroSocial, double salarioBase,double sueldoMensual, double bonoMensual, double retencionFuente, double fondoSalud, double fondoPension, double impuestoRiqueza) {
        super(nombre, apellido, numSeguroSocial, salarioBase);
        this.sueldoMensual = sueldoMensual;
        this.bonoMensual = bonoMensual;
        this.retencionFuente = retencionFuente;
        this.fondoSalud = fondoSalud;
        this.fondoPension = fondoPension;
        this.impuestoRiqueza = impuestoRiqueza;
    }
    
    @Override
    public double calcularDevengado(){
        return sueldoMensual;
    }
    
    @Override
    public double calcularDeducciones(){
        return retencionFuente + fondoSalud + fondoPension + impuestoRiqueza;
    }
    
    @Override
    public double calcularSalarioNeto(){ 
        return calcularDevengado()+bonoMensual-calcularDeducciones();
    }
}
