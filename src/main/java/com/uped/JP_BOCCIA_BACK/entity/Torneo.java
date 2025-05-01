package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoTorneo tipo;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public enum TipoTorneo {
        nacional, internacional
    }


    /*   Getters and Setters    */
    //Generado con lombok
}
