/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4TercerCorte;

import java.util.Random;
/**
 *
 * @author Administrator
 */
public class Atleta extends Thread{
    private String nombre;
    private int velocidad = 0;
    Random random = new Random();

    public Atleta(String nombre, float velocidad) {
        this.nombre = nombre;
        this.velocidad = random.nextInt(1, 1001);     
    }
    @Override
    public void run(){
        for(int i = velocidad; i<10000;i++){
            System.out.println(" atleta: "+ Thread.currentThread().getId() + "-- velocidad del hilo: " + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Error de hilo");
            }
        }
    }
    
    
    
}
