package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.ClasificacionDTO;
import com.uped.JP_BOCCIA_BACK.service.ClasificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {

    private final ClasificacionService clasificacionService;

    public ClasificacionController(ClasificacionService clasificacionService) {
        this.clasificacionService = clasificacionService;
    }

    @GetMapping
    public ResponseEntity<List<ClasificacionDTO>> listarTodos() {
        return ResponseEntity.ok(clasificacionService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasificacionDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clasificacionService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClasificacionDTO> guardar(@RequestBody ClasificacionDTO dto) {
        return ResponseEntity.ok(clasificacionService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasificacionDTO> actualizar(@PathVariable Long id, @RequestBody ClasificacionDTO dto) {
        dto.setId(id); // Asegura que el ID del path se use en la actualización
        return ResponseEntity.ok(clasificacionService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clasificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
