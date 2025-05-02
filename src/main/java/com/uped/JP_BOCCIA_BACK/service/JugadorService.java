package com.uped.JP_BOCCIA_BACK.service;
import com.uped.JP_BOCCIA_BACK.dto.JugadorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JugadorService {
    List<JugadorDTO> listarJugadores();

    JugadorDTO guardarJugador(JugadorDTO jugadorDTO);

    JugadorDTO buscarPorId(Long id);

    JugadorDTO actualizarJugador(Long id, JugadorDTO jugadorDTO);

    void eliminarJugador(Long id);
}
