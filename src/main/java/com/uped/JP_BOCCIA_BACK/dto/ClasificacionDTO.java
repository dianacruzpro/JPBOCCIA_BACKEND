package com.uped.JP_BOCCIA_BACK.dto;

import com.uped.JP_BOCCIA_BACK.entity.Clasificacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasificacionDTO {
    private Long id;
    private Long torneoID;
    private String tipo;
    private Long jugadorID;
    private Long equipoID;
    private String posicion;
    private LocalDate fechaRegistro;

    }

