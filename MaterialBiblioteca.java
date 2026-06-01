/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public abstract class MaterialBiblioteca {
    // 1. Atributos y encapsulados (private)
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    // 2. Constructor
    public MaterialBiblioteca(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.setAnioPublicacion(anioPublicacion); // Usamos el setter para que aplique la validación
        this.disponible = true; // Por defecto, al ingresar un material, está disponible
    }

    // 3. Métodos abstractos
    public abstract double calcularMulta(int diasRetraso);
    public abstract void mostrarInformacion();

    // 4. Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        // Validación: El año no puede ser negativo
        if (anioPublicacion > 0) {
            this.anioPublicacion = anioPublicacion;
        } else {
            System.out.println("Error: El año de publicación no puede ser negativo.");
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}