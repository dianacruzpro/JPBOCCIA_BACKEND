package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.PartidoDTO;
import com.uped.JP_BOCCIA_BACK.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<PartidoDTO> getPartidos() {
        return partidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public PartidoDTO getPartidoPorId(@PathVariable Long id) {
        return partidoService.buscarPorId(id);
    }

    @PostMapping
    public PartidoDTO crearPartido(@RequestBody PartidoDTO partidoDTO) {
        return partidoService.guardar(partidoDTO);
    }

    @PutMapping("/{id}")
    public PartidoDTO actualizarPartido(@PathVariable Long id, @RequestBody PartidoDTO partidoDTO) {
        return partidoService.actualizar(id, partidoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminarPartido(@PathVariable Long id) {
        boolean eliminado = partidoService.eliminar(id);
        if (eliminado) {
            return "Partido eliminado con éxito.";
        } else {
            return "Partido no encontrado.";
        }
    }
}
