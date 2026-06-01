/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Biblioteca {
    
    // 1. Atributos: Listas para aplicar la Agregación
    private final List<Usuario> listaUsuarios;
    private final List<MaterialBiblioteca> listaMateriales;
    private final List<Prestamo> listaPrestamos;

    // 2. Constructor
    public Biblioteca() {
        // Inicializamos las listas vacías
        this.listaUsuarios = new ArrayList<>();
        this.listaMateriales = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
    }

    // 3. Métodos básicos de agregación
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombres() + "' registrado en la biblioteca.");
    }

    public void agregarMaterial(MaterialBiblioteca material) {
        listaMateriales.add(material);
        System.out.println("Material '" + material.getTitulo() + "' agregado al catálogo.");
    }

    // 4. Método para realizar un préstamo manejando EXCEPCIONES
    // Usamos "throws Exception" en la firma del método para avisar que puede fallar
    public void realizarPrestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo) throws Exception {
        
        // Excepción 1: Intentar prestar un material no disponible
        if (!material.isDisponible()) {
            throw new Exception("Error: El material '" + material.getTitulo() + "' NO está disponible.");
        }

        // Excepción 2: Exceder el límite de préstamos (Pondremos un límite de 2 para el ejemplo)
        int prestamosActivos = 0;
        for (Prestamo p : listaPrestamos) {
            // Contamos si el usuario ya tiene préstamos sin devolver
            if (p.getUsuario().equals(usuario) && p.getFechaDevolucion() == null) {
                prestamosActivos++;
            }
        }
        if (prestamosActivos >= 2) {
            throw new Exception("Error: El usuario " + usuario.getNombres() + " ha excedido el límite de préstamos permitidos.");
        }

        // Si pasa las validaciones, creamos el préstamo
        Prestamo nuevoPrestamo = new Prestamo(usuario, material, fechaPrestamo);
        listaPrestamos.add(nuevoPrestamo);
        
        // Polimorfismo / Uso de Interfaces: Si es un Libro o Revista, llamamos a su método prestar()
        if (material instanceof IPrestamo) {
            ((IPrestamo) material).prestar();
        } else {
            // Si es Tesis (que no tiene interfaz), solo le cambiamos la disponibilidad
            material.setDisponible(false);
            System.out.println("La Tesis '" + material.getTitulo() + "' ha sido entregada para lectura en sala.");
        }
    }

    // 5. Método para devolver un material
    public void devolverMaterial(MaterialBiblioteca material, String fechaEntrega, int diasRetraso) throws Exception {
        Prestamo prestamoEncontrado = null;
        
        // Buscamos el préstamo activo de este material
        for (Prestamo p : listaPrestamos) {
            if (p.getMaterial().equals(material) && p.getFechaDevolucion() == null) {
                prestamoEncontrado = p;
                break;
            }
        }

        // Excepción 3: Intentar devolver un material inexistente o no prestado
        if (prestamoEncontrado == null) {
            throw new Exception("Error: No se encontró un préstamo activo para el material '" + material.getTitulo() + "'.");
        }

        // Procesamos la devolución usando la clase Prestamo
        prestamoEncontrado.procesarDevolucion(fechaEntrega, diasRetraso);
        
        if (material instanceof IPrestamo) {
            ((IPrestamo) material).devolver();
        } else {
            material.setDisponible(true);
            System.out.println("La Tesis '" + material.getTitulo() + "' ha sido devuelta.");
        }
        
        // Verificamos si hubo multa
        if (prestamoEncontrado.getMulta() > 0) {
            System.out.println("ATENCIÓN: Se ha generado una multa de $" + prestamoEncontrado.getMulta() + " por " + diasRetraso + " días de retraso.");
        }
    }

    // 6. Métodos para mostrar información
    public void mostrarUsuarios() {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (Usuario u : listaUsuarios) {
            System.out.println("- " + u.getNombres() + " (ID: " + u.getId() + ")");
        }
    }

    public void mostrarMateriales() {
        System.out.println("\n--- CATÁLOGO DE MATERIALES ---");
        for (MaterialBiblioteca m : listaMateriales) {
            System.out.println("- " + m.getTitulo() + " | Estado: " + (m.isDisponible() ? "Disponible" : "Prestado"));
        }
    }

    public void mostrarPrestamos() {
        System.out.println("\n--- REGISTRO DE PRÉSTAMOS ---");
        for (Prestamo p : listaPrestamos) {
            System.out.println("Usuario: " + p.getUsuario().getNombres() + " | Material: " + p.getMaterial().getTitulo() + " | Multa generada: $" + p.getMulta());
        }
    }
}
