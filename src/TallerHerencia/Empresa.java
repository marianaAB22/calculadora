/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerHerencia;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Empresa {
    ArrayList<Empleado> Empleados= new ArrayList<>();

    public Empresa() {}
    
    
    public void AgregarEmpleado(Empleado empleadoAgregar){
        Empleados.add(empleadoAgregar);
    }

    public double calcularNominaEmpleado(){
        double totalNomina = 0;
        for (int i = 0; i < Empleados.size(); i++) {
            totalNomina += Empleados.get(i).calcularSalarioNeto();
        }
        return totalNomina;
        
    }
    
}
