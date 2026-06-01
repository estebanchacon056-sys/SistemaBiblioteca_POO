/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public class Estudiante extends Usuario {
    
    // Atributos propios del estudiante
    private String carrera;
    private String semestre;

    // Constructor
    public Estudiante(String id, String cedula, String nombres, int edad, String direccionDomicilio, String carrera, String semestre) {
        // super() llama al constructor de la clase padre (Usuario)
        super(id, cedula, nombres, edad, direccionDomicilio);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    // Getters y Setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
