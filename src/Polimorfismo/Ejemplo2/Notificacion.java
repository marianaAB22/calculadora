/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polimorfismo.Ejemplo2;

/**
 *
 * @author Administrator
 */
public class Notificacion {
    public void enviarNotificacion(String mensaje){
        System.out.println("ENVIANDO NOTIFICACION DE TEXTO");
    }
    public void enviarNotificacion(String correo, String Asunto,String cuerpo){
        System.out.println("ENVIANDO NOTIFICACION A CELULAR");
    }
    public void enviarNotificacion(String dispositivo,String mensaje){
        System.out.println("ENVIANDO NOTIFICACION A DISPOSITIVO");
    }
    
}
