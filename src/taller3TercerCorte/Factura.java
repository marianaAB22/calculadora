/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller3TercerCorte;

/**
 *
 * @author Administrator
 */
public class Factura {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    private int impuesto;
    private double total;

    public Factura(String codigo, String nombre, int cantidad, double precio, int impuesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.impuesto = impuesto;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double subtotal = cantidad * precio;
        return subtotal + (subtotal * (impuesto / 100.0));
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}

