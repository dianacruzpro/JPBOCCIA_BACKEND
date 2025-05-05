package com.uped.JP_BOCCIA_BACK.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntuacionDTO {
    private Long id;
    private Long partidoId;
    private Integer numeroSet;
    private Integer puntosEquipo1;
    private Integer puntosEquipo2;
}
