package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.PuntuacionDTO;
import com.uped.JP_BOCCIA_BACK.service.PuntuacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/puntuaciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntuacionController {

    private final PuntuacionService puntuacionService;

    @GetMapping
    public List<PuntuacionDTO> listar() {
        return puntuacionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public PuntuacionDTO obtener(@PathVariable Long id) {
        return puntuacionService.obtenerPorId(id);
    }

    @PostMapping
    public PuntuacionDTO crear(@RequestBody PuntuacionDTO dto) {
        return puntuacionService.crear(dto);
    }

    @PutMapping("/{id}")
    public PuntuacionDTO actualizar(@PathVariable Long id, @RequestBody PuntuacionDTO dto) {
        return puntuacionService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        puntuacionService.eliminar(id);
    }
}
