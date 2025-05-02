package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import com.uped.JP_BOCCIA_BACK.exception.PaisNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.repository.TorneoRepository;
import com.uped.JP_BOCCIA_BACK.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TorneoServiceImpl implements TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<TorneoDTO> listarTodos() {
        return torneoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TorneoDTO guardar(TorneoDTO dto) {
        Torneo torneo = mapToEntity(dto);
        return mapToDTO(torneoRepository.save(torneo));
    }

    @Override
    public TorneoDTO buscarPorId(Long id) {
        return torneoRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public TorneoDTO actualizar(Long id, TorneoDTO dto) {
        Torneo torneo = torneoRepository.findById(id).orElseThrow();
        torneo.setNombre(dto.getNombre());
        torneo.setTipo(dto.getTipo());
        torneo.setFechaInicio(dto.getFechaInicio());
        torneo.setFechaFin(dto.getFechaFin());
        torneo.setPais(paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new PaisNoEncontradoException(dto.getPaisId())));
        return mapToDTO(torneoRepository.save(torneo));
    }

    @Override
    public void eliminar(Long id) {
        torneoRepository.deleteById(id);
    }

    private TorneoDTO mapToDTO(Torneo torneo) {
        return TorneoDTO.builder()
                .id(torneo.getId())
                .nombre(torneo.getNombre())
                .tipo(torneo.getTipo())
                .fechaInicio(torneo.getFechaInicio())
                .fechaFin(torneo.getFechaFin())
                .paisId(torneo.getPais().getId())
                .build();
    }

    private Torneo mapToEntity(TorneoDTO dto) {
        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new PaisNoEncontradoException(dto.getPaisId()));

        return Torneo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .pais(pais)
                .build();
    }
}
