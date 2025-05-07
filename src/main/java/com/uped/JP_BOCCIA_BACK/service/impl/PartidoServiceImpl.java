package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.PartidoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import com.uped.JP_BOCCIA_BACK.entity.Evento;
import com.uped.JP_BOCCIA_BACK.entity.Partido;
import com.uped.JP_BOCCIA_BACK.exception.ArbitroNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.EventoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.PartidoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.PartidoMapper;
import com.uped.JP_BOCCIA_BACK.repository.ArbitroRepository;
import com.uped.JP_BOCCIA_BACK.repository.EventoRepository;
import com.uped.JP_BOCCIA_BACK.repository.PartidoRepository;
import com.uped.JP_BOCCIA_BACK.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ArbitroRepository arbitroRepository;

    @Override
    public List<PartidoDTO> listarTodos() {
        return partidoRepository.findAll().stream()
                .map(PartidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoDTO guardar(PartidoDTO dto) {
        Evento evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(() -> new EventoNoEncontradoException(dto.getEventoId()));

        Arbitro arbitro = arbitroRepository.findById(dto.getArbitro_id())
                .orElseThrow(() -> new ArbitroNoEncontradoException(dto.getArbitro_id()));

        // Validación para evitar mezcla de jugadores y equipos
        if ((dto.getJugador1_id() != null || dto.getJugador2_id() != null) && (dto.getEquipo1_id() != null || dto.getEquipo2_id() != null)) {
            throw new IllegalArgumentException("No se puede registrar un partido con mezcla de jugadores y equipos.");
        }

        Partido partido = PartidoMapper.toEntity(dto, evento, arbitro);
        Partido partidoGuardado = partidoRepository.save(partido);
        return PartidoMapper.toDTO(partidoGuardado);
    }

    @Override
    public PartidoDTO buscarPorId(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new PartidoNoEncontradoException(id));
        return PartidoMapper.toDTO(partido);
    }

    @Override
    public PartidoDTO actualizar(Long id, PartidoDTO dto) {
        Partido partidoExistente = partidoRepository.findById(id)
                .orElseThrow(() -> new PartidoNoEncontradoException(id));

        Evento evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(() -> new EventoNoEncontradoException(dto.getEventoId()));

        Arbitro arbitro = arbitroRepository.findById(dto.getArbitro_id())
                .orElseThrow(() -> new ArbitroNoEncontradoException(dto.getArbitro_id()));

        // Validación para evitar mezcla de jugadores y equipos
        if ((dto.getJugador1_id() != null || dto.getJugador2_id() != null) && (dto.getEquipo1_id() != null || dto.getEquipo2_id() != null)) {
            throw new IllegalArgumentException("No se puede actualizar un partido con mezcla de jugadores y equipos.");
        }

        partidoExistente.setEvento(evento);
        partidoExistente.setArbitroPrincipal(arbitro);
        partidoExistente.setJugador1_id(dto.getJugador1_id());
        partidoExistente.setJugador2_id(dto.getJugador2_id());
        partidoExistente.setEquipo1_id(dto.getEquipo1_id());
        partidoExistente.setEquipo2_id(dto.getEquipo2_id());
        partidoExistente.setEstado(Partido.EstadoPartido.valueOf(dto.getEstado()));
        partidoExistente.setResultadoFinal(dto.getResultadoFinal());

        Partido partidoActualizado = partidoRepository.save(partidoExistente);
        return PartidoMapper.toDTO(partidoActualizado);
    }

    @Override
    public boolean eliminar(Long id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
