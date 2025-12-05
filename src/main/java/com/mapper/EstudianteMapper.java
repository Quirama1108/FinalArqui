package com.mapper;

import com.dto.EstudianteDTO;
import com.entities.Estudiante;

import java.util.stream.Collectors;

public class EstudianteMapper {

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }
        return new EstudianteDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getCedula(),
                estudiante.getMaterias().stream()
                        .map(MateriaMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) {
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setCedula(dto.getCedula());
        return estudiante;
    }
}
