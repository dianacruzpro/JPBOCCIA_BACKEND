package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String accion;
    private String entidadAfectada;

    private LocalDateTime fechaHora = LocalDateTime.now();

    /*   Getters and Setters    */
    //Generados con lombok
}

