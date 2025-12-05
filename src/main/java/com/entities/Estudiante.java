package com.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true, length = 20)
    private String cedula;

    @OneToMany(
            mappedBy = "estudiante",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Materia> materias = new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
        materia.setEstudiante(this);
    }

    public void limpiarMaterias() {
        for (Materia m : materias) {
            m.setEstudiante(null);
        }
        materias.clear();
    }
}
