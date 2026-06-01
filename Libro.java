/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
// "extends" aplica la Herencia y "implements" conecta con la Interfaz
public class Libro extends MaterialBiblioteca implements IPrestamo {
    
    // 1. Atributos propios de Libro (Encapsulados)
    private String genero;
    private int numeroPaginas;

    // 2. Constructor
    public Libro(String codigo, String titulo, String autor, int anioPublicacion, String genero, int numeroPaginas) {
        // "super" llama al constructor de la clase padre (MaterialBiblioteca)
        super(codigo, titulo, autor, anioPublicacion); 
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
    }

    // 3. Implementación de los métodos de la interfaz IPrestamo
    @Override
    public void prestar() {
        if (isDisponible()) {
            setDisponible(false);
            System.out.println("El libro '" + getTitulo() + "' ha sido prestado exitosamente.");
        } else {
            System.out.println("El libro '" + getTitulo() + "' no está disponible en este momento.");
        }
    }

    @Override
    public void devolver() {
        setDisponible(true);
        System.out.println("El libro '" + getTitulo() + "' ha sido devuelto y está disponible.");
    }

    // 4. Implementación de los métodos abstractos de MaterialBiblioteca (Polimorfismo)
    @Override
    public double calcularMulta(int diasRetraso) {
        // El documento exige que los libros apliquen una multa de $0.50 por día [cite: 67]
        return diasRetraso * 0.50;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Información del Libro ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnioPublicacion());
        System.out.println("Género: " + genero); // Atributo propio
        System.out.println("Páginas: " + numeroPaginas); // Atributo propio
        System.out.println("Disponible: " + (isDisponible() ? "Sí" : "No"));
    }

    // 5. Getters y Setters para los atributos propios
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
