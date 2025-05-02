package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.EquipoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.exception.EquipoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.PaisNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.EquipoMapper;
import com.uped.JP_BOCCIA_BACK.repository.EquipoRepository;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.service.EquipoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;
    private final PaisRepository paisRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository, PaisRepository paisRepository) {
        this.equipoRepository = equipoRepository;
        this.paisRepository = paisRepository;
    }

    @Override
    public List<EquipoDTO> listarEquipos() {
        return equipoRepository.findAll()
                .stream()
                .map(EquipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO guardarEquipo(EquipoDTO dto) {
        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new PaisNoEncontradoException(dto.getPaisId()));
        Equipo equipo = EquipoMapper.toEntity(dto, pais);
        return EquipoMapper.toDTO(equipoRepository.save(equipo));
    }

    @Override
    public EquipoDTO obtenerEquipoPorId(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new EquipoNoEncontradoException(id));
        return EquipoMapper.toDTO(equipo);
    }

    @Override
    public EquipoDTO actualizarEquipo(Long id, EquipoDTO dto) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new EquipoNoEncontradoException(id));

        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new PaisNoEncontradoException(dto.getPaisId()));

        equipo.setNombre(dto.getNombre());
        equipo.setTipo(Equipo.TipoEquipo.valueOf(dto.getTipo()));
        equipo.setCategoria(dto.getCategoria());
        equipo.setPais(pais);

        return EquipoMapper.toDTO(equipoRepository.save(equipo));
    }

    @Override
    public void eliminarEquipo(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new EquipoNoEncontradoException(id));
        equipoRepository.delete(equipo);
    }
}
