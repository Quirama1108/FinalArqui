package com.dto;

import java.util.List;

public class AgregarMateriasRequest {
    
    private String cedula;
    private List<MateriaDTO> materias;

    public AgregarMateriasRequest() {
    }

    public AgregarMateriasRequest(String cedula, List<MateriaDTO> materias) {
        this.cedula = cedula;
        this.materias = materias;
    }

    // Getters y setters

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
