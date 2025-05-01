package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.ArbitroDTO;
import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;

public class ArbitroMapper {
    public static ArbitroDTO toDTO(Arbitro arbitro) {
        return ArbitroDTO.builder()
                .id(arbitro.getId())
                .nombre(arbitro.getNombre())
                .rolJuez(arbitro.getRolJuez().name())
                .certificacion(arbitro.getCertificacion())
                .paisId(arbitro.getPais() != null ? arbitro.getPais().getId() : null)
                .usuarioId(arbitro.getUsuario() != null ? arbitro.getUsuario().getId() : null)
                .build();
    }

    public static Arbitro toEntity(ArbitroDTO dto, Pais pais, Usuario usuario){
        return Arbitro.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .rolJuez(Arbitro.RolJuez.valueOf(dto.getRolJuez()))
                .certificacion(dto.getCertificacion())
                .pais(pais)
                .usuario(usuario)
                .build();
    }
}
