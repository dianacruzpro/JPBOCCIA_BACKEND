package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.ClasificacionDTO;
import com.uped.JP_BOCCIA_BACK.service.ClasificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
@CrossOrigin(origins = "*")
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
        ClasificacionDTO clasificacion = clasificacionService.buscarPorId(id);
        return ResponseEntity.ok(clasificacion);
    }

    @PostMapping
    public ResponseEntity<ClasificacionDTO> guardar(@RequestBody ClasificacionDTO dto) {
        ClasificacionDTO guardado = clasificacionService.guardar(dto);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping
    public ResponseEntity<ClasificacionDTO> actualizar(@RequestBody ClasificacionDTO dto) {
        ClasificacionDTO actualizado = clasificacionService.actualizar(dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clasificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
