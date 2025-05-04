package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.AuditoriaDTO;
import com.uped.JP_BOCCIA_BACK.entity.Auditoria;
import com.uped.JP_BOCCIA_BACK.exception.AuditoriaNoEncontradaException;
import com.uped.JP_BOCCIA_BACK.mapper.AuditoriaMapper;
import com.uped.JP_BOCCIA_BACK.repository.AuditoriaRepository;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import com.uped.JP_BOCCIA_BACK.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public AuditoriaDTO crearAuditoria(AuditoriaDTO auditoriaDTO) {
        Auditoria auditoria = AuditoriaMapper.toEntity(auditoriaDTO);
        auditoria = auditoriaRepository.save(auditoria);
        return AuditoriaMapper.toDTO(auditoria);
    }

    @Override
    public List<AuditoriaDTO> obtenerTodas() {
        return auditoriaRepository.findAll().stream()
                .map(AuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuditoriaDTO obtenerPorId(Long id) {
        Optional<Auditoria> auditoriaOpt = auditoriaRepository.findById(id);
        return auditoriaOpt.map(AuditoriaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Auditoría con ID " + id + " no encontrada"));
    }

    @Override
    public AuditoriaDTO actualizarAuditoria(Long id, AuditoriaDTO auditoriaDTO) {
        Auditoria existente = auditoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auditoría con ID " + id + " no encontrada"));

        existente.setAccion(auditoriaDTO.getAccion());
        existente.setEntidadAfectada(auditoriaDTO.getEntidadAfectada());
        existente.setFechaHora(auditoriaDTO.getFechaHora());
        if (auditoriaDTO.getUsuarioId() != null) {
            existente.setUsuario(usuarioRepository.findById(auditoriaDTO.getUsuarioId()).orElse(null));
        }

        Auditoria actualizada = auditoriaRepository.save(existente);
        return AuditoriaMapper.toDTO(actualizada);
    }
    @Override
    public void eliminar(Long id) {
        if (!auditoriaRepository.existsById(id)) {
            throw new AuditoriaNoEncontradaException(id);
        }
        auditoriaRepository.deleteById(id);
    }
}