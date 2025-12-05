package com.dto;

public class MateriaDTO {
    
    private Long id;
    private String nombre;
    private Float nota;

    public MateriaDTO() {
    }

    public MateriaDTO(Long id, String nombre, Float nota) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
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

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
