/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public class Prestamo {
    
    // 1. Atributos solicitados
    // ASOCIACIÓN: La clase Prestamo "conoce" a un Usuario y a un MaterialBiblioteca
    private Usuario usuario;
    private MaterialBiblioteca material;
    private String fechaPrestamo;   // Usamos String para hacerlo básico y sin importaciones
    private String fechaDevolucion; // Usamos String 
    private double multa;

    // 2. Constructor
    public Prestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.multa = 0.0; // Al inicio, el préstamo no tiene multa
    }

    // 3. Método para procesar la devolución y calcular multa
    // Recibimos la fecha en texto y los días de retraso directamente
    public void procesarDevolucion(String fechaEntrega, int diasRetraso) {
        this.fechaDevolucion = fechaEntrega;
        
        if (diasRetraso > 0) {
            // POLIMORFISMO EN ACCIÓN: 
            // Llamamos a "calcularMulta()". Java sabrá automáticamente cuánto cobrar
            this.multa = material.calcularMulta(diasRetraso); 
        } else {
            this.multa = 0.0;
        }
    }

    // 4. Getters y Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MaterialBiblioteca getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBiblioteca material) {
        this.material = material;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}