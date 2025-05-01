package com.uped.JP_BOCCIA_BACK.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol; // Aqui puede ser "admin", "operador", "arbitro", "juez"
    private Boolean estado;


}
