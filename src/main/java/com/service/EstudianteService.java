package com.service;

import com.dto.EstudianteDTO;
import com.dto.MateriaDTO;
import com.entities.Estudiante;
import com.entities.Materia;
import com.mapper.EstudianteMapper;
import com.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    public EstudianteDTO obtenerNotasPorCedula(String cedula) {
        Estudiante estudiante = estudianteRepository.findByCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con cédula: " + cedula));
        return EstudianteMapper.toDTO(estudiante);
    }

    @Transactional
    public EstudianteDTO agregarMaterias(String cedula, java.util.List<MateriaDTO> materiasDTO) {
        // Buscar el estudiante por cédula
        Estudiante estudiante = estudianteRepository.findByCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con cédula: " + cedula));

        // Añadir las nuevas materias
        if (materiasDTO != null) {
            for (MateriaDTO materiaDTO : materiasDTO) {
                Materia materia = new Materia(materiaDTO.getNombre(), materiaDTO.getNota());
                estudiante.agregarMateria(materia);
            }
        }

        // Guardar estudiante
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return EstudianteMapper.toDTO(estudianteGuardado);
    }
}
