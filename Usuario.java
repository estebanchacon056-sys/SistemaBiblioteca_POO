/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public abstract class Usuario {
    
    // 1. Atributos comunes y encapsulados
    private String id;
    private String cedula;
    private String nombres;
    private int edad;
    private String direccionDomicilio;

    // 2. Constructor
    public Usuario(String id, String cedula, String nombres, int edad, String direccionDomicilio) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.setEdad(edad); // Usamos el setter para aplicar la validación
        this.direccionDomicilio = direccionDomicilio;
    }

    // 3. Métodos generales sugeridos por el documento
    public void consultarMateriales() {
        System.out.println(nombres + " está consultando el catálogo de materiales de la biblioteca.");
    }

    public void solicitarPrestamo() {
        System.out.println(nombres + " está iniciando el proceso de solicitud de un préstamo.");
    }

    // 4. Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        // Validación: La edad no puede ser negativa
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Error: La edad ingresada para " + nombres + " no es válida (no puede ser negativa).");
        }
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }
}