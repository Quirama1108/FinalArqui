package com.dto;

import java.util.List;

public class EstudianteDTO {
    
    private Long id;
    private String nombre;
    private String cedula;
    private List<MateriaDTO> materias;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Long id, String nombre, String cedula, List<MateriaDTO> materias) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.materias = materias;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
}
