/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author PC
 */
public class Docente extends Usuario {
    
    // Atributos propios del docente
    private String departamento;
    private String especialidad;

    // Constructor
    public Docente(String id, String cedula, String nombres, int edad, String direccionDomicilio, String departamento, String especialidad) {
        super(id, cedula, nombres, edad, direccionDomicilio);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
