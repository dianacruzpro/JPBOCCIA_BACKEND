package com.uped.JP_BOCCIA_BACK.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArbitroDTO {
    private Long id;
    private String nombre;
    private String certificacion;
    private String rolJuez;
    private Long paisId;
    private Long usuarioId;
}
