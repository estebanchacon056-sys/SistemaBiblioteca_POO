/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public class Revista extends MaterialBiblioteca implements IPrestamo {
    
    // Atributos propios
    private int numeroEdicion;
    private String categoria;

    // Constructor
    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion, String categoria) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.categoria = categoria;
    }

    // Implementación de IPrestamo
    @Override
    public void prestar() {
        if (isDisponible()) {
            setDisponible(false);
            System.out.println("La revista '" + getTitulo() + "' ha sido prestada.");
        } else {
            System.out.println("La revista '" + getTitulo() + "' no está disponible.");
        }
    }

    @Override
    public void devolver() {
        setDisponible(true);
        System.out.println("La revista '" + getTitulo() + "' ha sido devuelta.");
    }

    // Implementación de métodos abstractos (Polimorfismo)
    @Override
    public double calcularMulta(int diasRetraso) {
        // La multa para revistas es de $1.0 [cite: 68]
        return diasRetraso * 1.0; 
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Información de la Revista ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnioPublicacion());
        System.out.println("Edición: " + numeroEdicion);
        System.out.println("Categoría: " + categoria);
        System.out.println("Disponible: " + (isDisponible() ? "Sí" : "No"));
    }

    // Getters y Setters
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}