package com.uped.JP_BOCCIA_BACK.dto;

import com.uped.JP_BOCCIA_BACK.entity.Clasificacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Integer posicion;
    private LocalDate fechaRegistro;
    private String errorMessage;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    }

