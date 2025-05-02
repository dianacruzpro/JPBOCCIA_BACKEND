package com.uped.JP_BOCCIA_BACK.dto;
import lombok.Data;

@Data
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String tipo;      // una pareja o un equipo
    private String categoria;
    private Long paisId;
}
