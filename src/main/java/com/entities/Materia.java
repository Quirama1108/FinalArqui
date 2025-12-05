package com.Enti;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Nota numérica, puedes ajustar a int/float según tu criterio
    @Column(nullable = false)
    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public Materia() {
    }

    public Materia(String nombre, Double nota) {
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

    public Double getNota() {
        return nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
