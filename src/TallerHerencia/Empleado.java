/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerHerencia;

/**
 *
 * @author Administrator
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String numSeguroSocial;
    private double salarioBase;
    
    public Empleado(String nombre, String apellido, String numSeguroSocial,double salarioBase ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numSeguroSocial = numSeguroSocial;
        this.salarioBase = salarioBase;
    }
    
    public double calcularDevengado(){
        return 0;
    }
    public double calcularDeducciones(){
        return 0; 
    }
    public double calcularSalarioNeto(){ 
        return 0;
        
    }
    
    public void getInfo(){
        System.out.println("nombre del empleado: " + nombre + " " + apellido);
        System.out.println("numero de seguro social: " + numSeguroSocial);
        System.out.println("salario base del empleado: " + salarioBase);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumSeguroSocial() {
        return numSeguroSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
    
}
