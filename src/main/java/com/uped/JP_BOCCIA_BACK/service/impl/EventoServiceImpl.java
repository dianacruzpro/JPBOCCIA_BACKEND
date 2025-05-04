package com.uped.JP_BOCCIA_BACK.service.impl;


import com.uped.JP_BOCCIA_BACK.dto.EventoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Evento;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import com.uped.JP_BOCCIA_BACK.exception.RecursoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.EventoMapper;
import com.uped.JP_BOCCIA_BACK.repository.EventoRepository;
import com.uped.JP_BOCCIA_BACK.repository.TorneoRepository;
import com.uped.JP_BOCCIA_BACK.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRespository;

    @Autowired
    private TorneoRepository torneoRepository;

    @Override
    public EventoDTO guardar(EventoDTO dto) {
        Torneo torneo = torneoRepository.findById(dto.getTorneoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Torneo no encontrado con ID: " + dto.getTorneoId()));

        Evento evento = EventoMapper.toEntity(dto, torneo);
        Evento eventoGuardado = eventoRespository.save(evento);
        return EventoMapper.toDTO(eventoGuardado);
    }

    @Override
    public List<EventoDTO> listarTodos() {
        return eventoRespository.findAll().stream()
                .map(EventoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventoDTO buscarPorId(Long id) {
        Evento evento = eventoRespository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Evento no encontrado con ID: " + id));
        return EventoMapper.toDTO(evento);
    }

    @Override
    public Evento actualizar(Long id, EventoDTO dto) {
        Evento eventoExistente = eventoRespository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Evento no encontrado con ID: " + id));

        Torneo torneo = torneoRepository.findById(dto.getTorneoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Torneo no encontrado con ID: " + dto.getTorneoId()));

        eventoExistente.setCategoria(dto.getCategoria());
        eventoExistente.setCancha(dto.getCancha());
        eventoExistente.setFecha(dto.getFecha());
        eventoExistente.setTipo(dto.getTipo());
        eventoExistente.setTorneo(torneo);

        return eventoRespository.save(eventoExistente);
    }

    @Override
    public boolean eliminar(Long id) {
        if (eventoRespository.existsById(id)) {
            eventoRespository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EventoDTO> guardarVariosEventos(List<EventoDTO> eventos) {
        List<Evento> entidades = eventos.stream().map(dto -> {
            Torneo torneo = torneoRepository.findById(dto.getTorneoId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Torneo no encontrado con ID: " + dto.getTorneoId()));
            return EventoMapper.toEntity(dto, torneo);
        }).collect(Collectors.toList());

        List<Evento> guardados = eventoRespository.saveAll(entidades);
        return guardados.stream().map(EventoMapper::toDTO).collect(Collectors.toList());
    }
}
