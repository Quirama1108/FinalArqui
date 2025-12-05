package com.mapper;

import com.dto.MateriaDTO;
import com.entities.Materia;

public class MateriaMapper {

    public static MateriaDTO toDTO(Materia materia) {
        if (materia == null) {
            return null;
        }
        return new MateriaDTO(
                materia.getId(),
                materia.getNombre(),
                materia.getNota()
        );
    }

    public static Materia toEntity(MateriaDTO dto) {
        if (dto == null) {
            return null;
        }
        Materia materia = new Materia();
        materia.setNombre(dto.getNombre());
        materia.setNota(dto.getNota());
        return materia;
    }
}
