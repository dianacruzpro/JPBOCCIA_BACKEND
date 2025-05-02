package com.uped.JP_BOCCIA_BACK.dto;

import com.uped.JP_BOCCIA_BACK.entity.Torneo.TipoTorneo;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TorneoDTO {
    private Long id;
    private String nombre;
    private TipoTorneo tipo;
    private Long paisId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
