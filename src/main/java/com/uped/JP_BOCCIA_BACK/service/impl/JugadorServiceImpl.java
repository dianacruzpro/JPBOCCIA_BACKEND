package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.JugadorDTO;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.exception.JugadorNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.JugadorMapper;
import com.uped.JP_BOCCIA_BACK.repository.JugadorRepository;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.service.JugadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImpl implements JugadorService {
    private final JugadorRepository jugadorRepository;
    private final PaisRepository paisRepository;

    public JugadorServiceImpl(JugadorRepository jugadorRepository, PaisRepository paisRepository) {
        this.jugadorRepository = jugadorRepository;
        this.paisRepository = paisRepository;
    }

    @Override
    public List<JugadorDTO> listarJugadores() {
        return jugadorRepository.findAll()
                .stream()
                .map(JugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorDTO guardarJugador(JugadorDTO dto) {
        Jugador jugador = JugadorMapper.toEntity(dto);

        if (dto.getPaisId() != null) {
            Pais pais = paisRepository.findById(dto.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + dto.getPaisId()));
            jugador.setPais(pais);
        }

        Jugador guardado = jugadorRepository.save(jugador);
        return JugadorMapper.toDTO(guardado);
    }

    @Override
    public JugadorDTO buscarPorId(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new JugadorNoEncontradoException(id));
        return JugadorMapper.toDTO(jugador);
    }

    @Override
    public JugadorDTO actualizarJugador(Long id, JugadorDTO dto) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new JugadorNoEncontradoException(id));

        jugador.setNombre(dto.getNombre());
        jugador.setGenero(dto.getGenero() != null ? Jugador.Genero.valueOf(dto.getGenero()) : null);
        jugador.setCategoria(dto.getCategoria() != null ? Jugador.Categoria.valueOf(dto.getCategoria()) : null);

        if (dto.getPaisId() != null) {
            Pais pais = paisRepository.findById(dto.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + dto.getPaisId()));
            jugador.setPais(pais);
        }

        Jugador actualizado = jugadorRepository.save(jugador);
        return JugadorMapper.toDTO(actualizado);
    }

    @Override
    public void eliminarJugador(Long id) {
        if (!jugadorRepository.existsById(id)) {
            throw new JugadorNoEncontradoException(id);
        }
        jugadorRepository.deleteById(id);
    }
}
