package com.uped.JP_BOCCIA_BACK.controller;
import com.uped.JP_BOCCIA_BACK.dto.JugadorDTO;
import com.uped.JP_BOCCIA_BACK.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/jugadores")
public class JugadorController {
    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<JugadorDTO> listar() {
        return jugadorService.listarJugadores();
    }

    @PostMapping
    public ResponseEntity<JugadorDTO> crear(@RequestBody JugadorDTO jugadorDTO) {
        JugadorDTO creado = jugadorService.guardarJugador(jugadorDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> buscarPorId(@PathVariable Long id) {
        JugadorDTO jugador = jugadorService.buscarPorId(id);
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> actualizar(@PathVariable Long id, @RequestBody JugadorDTO dto) {
        JugadorDTO actualizado = jugadorService.actualizarJugador(id, dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Jugador eliminado con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
