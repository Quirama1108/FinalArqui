package com.controller;

import com.dto.EstudianteDTO;
import com.dto.MateriaDTO;
import com.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Tag(name = "Estudiantes", description = "API para gestión de estudiantes y sus notas")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Operation(summary = "Consultar notas de un estudiante", 
               description = "Obtiene todas las materias y notas de un estudiante mediante su cédula")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estudiante encontrado",
                     content = @Content(mediaType = "application/json", 
                                      schema = @Schema(implementation = EstudianteDTO.class))),
        @ApiResponse(responseCode = "404", description = "Estudiante no encontrado",
                     content = @Content)
    })
    @GetMapping("/{cedula}")
    public ResponseEntity<EstudianteDTO> obtenerNotasPorCedula(
            @Parameter(description = "Cédula del estudiante", required = true, example = "12345678")
            @PathVariable String cedula) {
        try {
            EstudianteDTO estudiante = estudianteService.obtenerNotasPorCedula(cedula);
            return ResponseEntity.ok(estudiante);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Agregar materias a un estudiante", 
               description = "Añade una o varias materias con sus notas a un estudiante existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Materias agregadas correctamente",
                     content = @Content(mediaType = "application/json", 
                                      schema = @Schema(implementation = EstudianteDTO.class))),
        @ApiResponse(responseCode = "404", description = "Estudiante no encontrado",
                     content = @Content),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                     content = @Content)
    })
    @PostMapping("/{cedula}/materias")
    public ResponseEntity<EstudianteDTO> agregarMaterias(
            @Parameter(description = "Cédula del estudiante", required = true, example = "12345678")
            @PathVariable String cedula,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Lista de materias a agregar. Solo se requiere nombre y nota (el ID se genera automáticamente)",
                required = true,
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                        type = "array",
                        example = "[{\"nombre\": \"Matemáticas\", \"nota\": 4.5}, {\"nombre\": \"Física\", \"nota\": 3.8}]"
                    )
                ))
            @RequestBody List<MateriaDTO> materias) {
        try {
            EstudianteDTO resultado = estudianteService.agregarMaterias(cedula, materias);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
