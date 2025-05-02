package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.EquipoJugadorDTO;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;
import com.uped.JP_BOCCIA_BACK.entity.EquipoJugador;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import com.uped.JP_BOCCIA_BACK.exception.EquipoJugadorNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.EquipoJugadorMapper;
import com.uped.JP_BOCCIA_BACK.repository.EquipoJugadorRepository;
import com.uped.JP_BOCCIA_BACK.repository.EquipoRepository;
import com.uped.JP_BOCCIA_BACK.repository.JugadorRepository;
import com.uped.JP_BOCCIA_BACK.service.EquipoJugadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoJugadorServiceImpl implements EquipoJugadorService {

    private final EquipoJugadorRepository repository;
    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;

    public EquipoJugadorServiceImpl(EquipoJugadorRepository repository,
                                    EquipoRepository equipoRepository,
                                    JugadorRepository jugadorRepository) {
        this.repository = repository;
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public List<EquipoJugadorDTO> listarTodos() {
        return repository.findAll().stream()
                .map(EquipoJugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoJugadorDTO guardar(EquipoJugadorDTO dto) {
        Equipo equipo = equipoRepository.findById(dto.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        Jugador jugador = jugadorRepository.findById(dto.getJugadorId())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        EquipoJugador ej = EquipoJugadorMapper.toEntity(dto, equipo, jugador);
        return EquipoJugadorMapper.toDTO(repository.save(ej));
    }

    @Override
    public EquipoJugadorDTO buscarPorId(Long id) {
        EquipoJugador ej = repository.findById(id)
                .orElseThrow(() -> new EquipoJugadorNoEncontradoException(id));
        return EquipoJugadorMapper.toDTO(ej);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new EquipoJugadorNoEncontradoException(id);
        }
        repository.deleteById(id);
    }
}