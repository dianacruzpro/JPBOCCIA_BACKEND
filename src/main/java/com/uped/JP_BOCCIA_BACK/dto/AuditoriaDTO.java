package com.uped.JP_BOCCIA_BACK.dto;
 import lombok.Data;
 import java.time.LocalDateTime;
@Data
public class AuditoriaDTO
{
    private Long id;
    private Long usuarioId;
    private String accion;
    private String entidadAfectada;
    private LocalDateTime fechaHora;
}
