/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TallerHerencia;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //OBJETOS
        
        Empresa empresa = new Empresa();
        //empleado por sueldo
        EmpleadoPorSueldo empleadoSueldo1 = new EmpleadoPorSueldo("Juan", "Stiven", "434245", 3000);
        EmpleadoPorSueldo empleadoSueldo2= new EmpleadoPorSueldo("Maria", "Jose", "4456546", 5000);
        EmpleadoPorSueldo empleadoSueldo3 = new EmpleadoPorSueldo("Juan", "Stiven", "434245", 6000);
        
        //empleadoHoras
        EmpleadoPorHoras empleadoHoras1 = new EmpleadoPorHoras("Ana", "Ramirez", "111223333", 0, 40, 20.5);
        EmpleadoPorHoras empleadoHoras2 = new EmpleadoPorHoras("Luis", "Martinez", "444556666", 0, 35, 18.75);
        EmpleadoPorHoras empleadoHoras3 = new EmpleadoPorHoras("Elena", "Gomez", "777889999", 0, 45, 22.0);
        
        //gerente
        Gerente gerente1 = new Gerente(
            "Juan",
            "Pérez",
            "123-45-6789",
            3000.0,    //salarioBase
            5000.0,    //sueldoMensual
            1000.0,    //bonoMensual
            300.0,     //retencionFuente
            200.0,     //fondoSalud
            150.0,     //fondoPension
            250.0      //impuestoRiqueza
        );     
        //agregando los objetos
        empresa.AgregarEmpleado(empleadoSueldo1);
        empresa.AgregarEmpleado(empleadoSueldo2);
        empresa.AgregarEmpleado(empleadoSueldo3);
        empresa.AgregarEmpleado(empleadoHoras1);
        empresa.AgregarEmpleado(empleadoHoras2);
        empresa.AgregarEmpleado(empleadoHoras3);
        empresa.AgregarEmpleado(gerente1);
        
        
        
        
        
    }
    
}
