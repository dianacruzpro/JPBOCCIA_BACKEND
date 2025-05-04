package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.AuditoriaDTO;
import com.uped.JP_BOCCIA_BACK.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/auditorias")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    @Autowired
    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @GetMapping
    public List<AuditoriaDTO> listar() {
        return auditoriaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<AuditoriaDTO> crear(@RequestBody AuditoriaDTO auditoriaDTO) {
        AuditoriaDTO creado = auditoriaService.crearAuditoria(auditoriaDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaDTO> buscarPorId(@PathVariable Long id) {
        AuditoriaDTO auditoria = auditoriaService.obtenerPorId(id);
        return new ResponseEntity<>(auditoria, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditoriaDTO> actualizar(@PathVariable Long id, @RequestBody AuditoriaDTO dto) {
        AuditoriaDTO actualizado = auditoriaService.actualizarAuditoria(id, dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id) {
        auditoriaService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Auditoría eliminada con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}