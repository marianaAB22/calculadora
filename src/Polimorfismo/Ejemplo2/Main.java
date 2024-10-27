/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Polimorfismo.Ejemplo2;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Notificacion notificacion = new Notificacion();
        notificacion.enviarNotificacion("MENSAJE DE TEXTO");
        notificacion.enviarNotificacion("MENSAJE DE TEXTO", "MENSAJE A CORREO");
        notificacion.enviarNotificacion("MENSAJE DE TEXTO", "MENSAJE A CORREO", "MENSAJE A CORREO");
        
    }
    
}
