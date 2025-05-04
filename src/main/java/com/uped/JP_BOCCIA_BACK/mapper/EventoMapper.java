package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.EventoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Evento;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;

public class EventoMapper {

    public static EventoDTO toDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();
        dto.setId(evento.getId());
        dto.setCategoria(evento.getCategoria());
        dto.setCancha(evento.getCancha());
        dto.setFecha(evento.getFecha());
        dto.setTipo(evento.getTipo());
        dto.setTorneoId(evento.getTorneo().getId());
        return dto;
    }

    public static Evento toEntity(EventoDTO dto, Torneo torneo) {
        return Evento.builder()
                .id(dto.getId())
                .categoria(dto.getCategoria())
                .cancha(dto.getCancha())
                .fecha(dto.getFecha())
                .tipo(dto.getTipo())
                .torneo(torneo)
                .build();
    }
}

