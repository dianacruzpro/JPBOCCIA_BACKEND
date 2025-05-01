package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "arbitro")
public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private RolJuez rolJuez;

    private String certificacion;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public enum RolJuez {
        REF, LINE, TD, TIME
    }

    /*   Getters and Setters    */
    //Generados con lombok
}

