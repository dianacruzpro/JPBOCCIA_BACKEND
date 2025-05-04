package com.uped.JP_BOCCIA_BACK.dto;
import com.uped.JP_BOCCIA_BACK.entity.Evento.TipoEvento;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDTO {
    private Long id;
    private String categoria;
    private String cancha;
    private TipoEvento tipo;
    private LocalDate fecha;
    private Long torneoId;
}
