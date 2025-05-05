package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.PuntuacionDTO;
import com.uped.JP_BOCCIA_BACK.entity.Partido;
import com.uped.JP_BOCCIA_BACK.entity.Puntuacion;
import com.uped.JP_BOCCIA_BACK.exception.RecursoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.PuntuacionMapper;
import com.uped.JP_BOCCIA_BACK.repository.PartidoRepository;
import com.uped.JP_BOCCIA_BACK.repository.PuntuacionRepository;
import com.uped.JP_BOCCIA_BACK.service.PuntuacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PuntuacionServiceImpl implements PuntuacionService {

    private final PuntuacionRepository puntuacionRepository;
    private final PartidoRepository partidoRepository;

    @Override
    public List<PuntuacionDTO> obtenerTodas() {
        return puntuacionRepository.findAll().stream()
                .map(PuntuacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PuntuacionDTO obtenerPorId(Long id) {
        Puntuacion puntuacion = puntuacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una puntuación con ID: " + id));
        return PuntuacionMapper.toDTO(puntuacion);
    }

    @Override
    public PuntuacionDTO crear(PuntuacionDTO dto) {
        Partido partido = partidoRepository.findById(dto.getPartidoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el partido con ID: " + dto.getPartidoId()));
        Puntuacion puntuacion = PuntuacionMapper.toEntity(dto, partido);
        return PuntuacionMapper.toDTO(puntuacionRepository.save(puntuacion));
    }

    @Override
    public PuntuacionDTO actualizar(Long id, PuntuacionDTO dto) {
        Puntuacion puntuacionExistente = puntuacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una puntuación con ID: " + id));
        Partido partido = partidoRepository.findById(dto.getPartidoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el partido con ID: " + dto.getPartidoId()));

        puntuacionExistente.setPartido(partido);
        puntuacionExistente.setNumeroSet(dto.getNumeroSet());
        puntuacionExistente.setPuntosEquipo1(dto.getPuntosEquipo1());
        puntuacionExistente.setPuntosEquipo2(dto.getPuntosEquipo2());

        return PuntuacionMapper.toDTO(puntuacionRepository.save(puntuacionExistente));
    }

    @Override
    public void eliminar(Long id) {
        if (!puntuacionRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: puntuación con ID " + id + " no existe.");
        }
        puntuacionRepository.deleteById(id);
    }
}
