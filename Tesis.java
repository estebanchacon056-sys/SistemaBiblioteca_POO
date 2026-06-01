/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
// Nota que aquí NO usamos "implements IPrestamo"
public class Tesis extends MaterialBiblioteca {
    
    // Atributos propios
    private String tema;
    private String departamento;

    // Constructor
    public Tesis(String codigo, String titulo, String autor, int anioPublicacion, String tema, String departamento) {
        super(codigo, titulo, autor, anioPublicacion);
        this.tema = tema;
        this.departamento = departamento;
    }

    // Implementación de métodos abstractos (Polimorfismo)
    @Override
    public double calcularMulta(int diasRetraso) {
        // La multa para tesis es de $1.5 [cite: 69]
        return diasRetraso * 1.5;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Información de la Tesis ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnioPublicacion());
        System.out.println("Tema: " + tema);
        System.out.println("Departamento: " + departamento);
        System.out.println("Disponible para lectura en sala: " + (isDisponible() ? "Sí" : "No"));
    }

    // Getters y Setters
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
