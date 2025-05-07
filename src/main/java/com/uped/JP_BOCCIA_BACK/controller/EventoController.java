package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.EventoDTO;
import com.uped.JP_BOCCIA_BACK.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // GET /api/eventos
    @GetMapping
    public List<EventoDTO> getEventos() {
        return eventoService.listarTodos();
    }

    // GET /api/eventos/{id}
    @GetMapping(value = "/{id}")
    public EventoDTO getEventoPorId(@PathVariable Long id) {
        return (EventoDTO) eventoService.buscarPorId(id);
    }

    // POST /api/eventos
    @PostMapping
    public EventoDTO crearEvento(@RequestBody EventoDTO eventoDTO) {
        return eventoService.guardar(eventoDTO);
    }

    // DELETE /api/eventos/{id}
    @DeleteMapping("/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        boolean eliminado = eventoService.eliminar(id);
        if (eliminado) {
            return "Evento eliminado con éxito.";
        } else {
            return "Evento no encontrado.";
        }
    }
}
