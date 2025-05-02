package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.EquipoJugadorDTO;
import com.uped.JP_BOCCIA_BACK.service.EquipoJugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo-jugador")
public class EquipoJugadorController {

    private final EquipoJugadorService service;

    public EquipoJugadorController(EquipoJugadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<EquipoJugadorDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<EquipoJugadorDTO> guardar(@RequestBody EquipoJugadorDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Eliminada");
    }
}