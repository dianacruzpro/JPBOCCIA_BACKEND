package com.uped.JP_BOCCIA_BACK.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String correo;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    private Boolean estado = true;

    public enum RolUsuario {
        admin, operador, arbitro, juez, jugador
    }

    /*   Getters and Setters    */
    //Generados con lombok
}
