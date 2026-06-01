/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Biblioteca;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class SistemaBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        int opcion = 0;

        System.out.println("=== SISTEMA DE GESTION DE BIBLIOTECA ===");

        // El bucle while mantiene el programa vivo hasta que elijas la opcion de Salir
        while (opcion != 6) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar nuevo Estudiante");
            System.out.println("2. Registrar nuevo Libro");
            System.out.println("3. Mostrar todos los Usuarios");
            System.out.println("4. Mostrar todos los Materiales");
            System.out.println("5. Realizar un Prestamo (Ejemplo rapido)");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = entrada.nextInt();
            entrada.nextLine(); // TRUCO VITAL: Esto "limpia" el enter que queda flotando despues de un numero

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n-- DATOS DEL ESTUDIANTE --");
                    System.out.print("ID (Ej. E001): ");
                    String id = entrada.nextLine();
                    System.out.print("Cedula: ");
                    String cedula = entrada.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = entrada.nextLine();
                    System.out.print("Edad: ");
                    int edad = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer otra vez
                    System.out.print("Direccion Domicilio (Ej. Yugsiloma): ");
                    String dir = entrada.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = entrada.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = entrada.nextLine();

                    // Creamos el objeto con lo que acabas de escribir y lo guardamos
                    Estudiante nuevoEstudiante = new Estudiante(id, cedula, nombres, edad, dir, carrera, semestre);
                    miBiblioteca.agregarUsuario(nuevoEstudiante);
                }

                case 2 -> {
                    System.out.println("\n-- DATOS DEL LIBRO --");
                    System.out.print("Codigo (Ej. L001): ");
                    String codigo = entrada.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = entrada.nextLine();
                    System.out.print("Autor: ");
                    String autor = entrada.nextLine();
                    System.out.print("Anio de Publicacion: ");
                    int anio = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer
                    System.out.print("Genero: ");
                    String genero = entrada.nextLine();
                    System.out.print("Numero de Paginas: ");
                    int paginas = entrada.nextInt();
                    entrada.nextLine();

                    Libro nuevoLibro = new Libro(codigo, titulo, autor, anio, genero, paginas);
                    miBiblioteca.agregarMaterial(nuevoLibro);
                }

                case 3 -> miBiblioteca.mostrarUsuarios();

                case 4 -> miBiblioteca.mostrarMateriales();

                case 5 -> {
                    System.out.println("\n(Nota: Para prestar, debes asegurarte de haber registrado al menos 1 usuario y 1 material antes)");
                    System.out.println("Opcion en construccion para que tu la completes con la logica de busqueda.");
                }

                case 6 -> System.out.println("Saliendo del sistema... Hasta luego!");

                default -> System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }
        
        // Es buena practica cerrar el Scanner al terminar el programa
        entrada.close();
    }
}
    

