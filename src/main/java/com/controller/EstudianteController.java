package com.controller;

import com.dto.AgregarMateriasRequest;
import com.dto.EstudianteDTO;
import com.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // GET: Consultar notas de un estudiante por cédula
    @GetMapping("/{cedula}")
    public ResponseEntity<EstudianteDTO> obtenerNotasPorCedula(@PathVariable String cedula) {
        try {
            EstudianteDTO estudiante = estudianteService.obtenerNotasPorCedula(cedula);
            return ResponseEntity.ok(estudiante);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // POST: Ingresar información de notas de un estudiante
    @PostMapping("/{cedula}/materias")
    public ResponseEntity<EstudianteDTO> agregarMaterias(
            @PathVariable String cedula,
            @RequestBody AgregarMateriasRequest request) {
        try {
            EstudianteDTO resultado = estudianteService.agregarMaterias(cedula, request.getMaterias());
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
