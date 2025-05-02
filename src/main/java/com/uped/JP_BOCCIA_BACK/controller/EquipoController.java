package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.EquipoDTO;
import com.uped.JP_BOCCIA_BACK.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipos")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<EquipoDTO> listar() {
        return equipoService.listarEquipos();
    }

    @PostMapping
    public ResponseEntity<EquipoDTO> crear(@RequestBody EquipoDTO dto) {
        return ResponseEntity.status(201).body(equipoService.guardarEquipo(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.obtenerEquipoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoDTO> actualizar(@PathVariable Long id, @RequestBody EquipoDTO dto) {
        return ResponseEntity.ok(equipoService.actualizarEquipo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return ResponseEntity.ok().body("Equipo eliminado correctamente");
    }
}
