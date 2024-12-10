/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller4TercerCorte;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Atleta hilo1 = new Atleta("pepe",0);
        Atleta hilo2 = new Atleta("luca",0);
        Atleta hilo3 = new Atleta("luna",0);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
}
