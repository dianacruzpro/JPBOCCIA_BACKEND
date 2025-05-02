package com.uped.JP_BOCCIA_BACK.dto;
import lombok.Data;

@Data
public class JugadorDTO {
    private Long id;
    private String nombre;
    private String genero;     // En base al entity seran: "Masculino", "Femenino", "Otro"
    private String categoria;  // Aqui sera: "BC1", "BC2", "BC3", "BC4"
    private Long paisId;       // haremos referencia al país por su ID
    private String paisNombre; // este solo para mostrar el nombre del país si se quiere
}
