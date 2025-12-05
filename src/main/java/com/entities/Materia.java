package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private float nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public Materia() {
    }

    public Materia(String nombre, Float nota) {
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

    public Float getNota() {
        return nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
