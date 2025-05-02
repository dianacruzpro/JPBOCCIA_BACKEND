package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;
import com.uped.JP_BOCCIA_BACK.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    @GetMapping
    public List<TorneoDTO> listarTorneos() {
        return torneoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TorneoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(torneoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TorneoDTO> crear(@RequestBody TorneoDTO torneoDTO) {
        return ResponseEntity.ok(torneoService.guardar(torneoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TorneoDTO> actualizar(@PathVariable Long id, @RequestBody TorneoDTO torneoDTO) {
        return ResponseEntity.ok(torneoService.actualizar(id, torneoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        torneoService.eliminar(id);
        return ResponseEntity.ok("Torneo eliminado exitosamente");
    }
}
