package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolJuez getRolJuez() {
        return rolJuez;
    }

    public void setRolJuez(RolJuez rolJuez) {
        this.rolJuez = rolJuez;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

