package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.JugadorDTO;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import com.uped.JP_BOCCIA_BACK.entity.Pais;

public class JugadorMapper {
    public static JugadorDTO toDTO(Jugador jugador) {
        if (jugador == null) return null;

        JugadorDTO dto = new JugadorDTO();
        dto.setId(jugador.getId());
        dto.setNombre(jugador.getNombre());
        dto.setGenero(jugador.getGenero() != null ? jugador.getGenero().name() : null);
        dto.setCategoria(jugador.getCategoria() != null ? jugador.getCategoria().name() : null);
        if (jugador.getPais() != null) {
            dto.setPaisId(jugador.getPais().getId());
            dto.setPaisNombre(jugador.getPais().getNombre());
        }

        return dto;
    }

    public static Jugador toEntity(JugadorDTO dto) {
        if (dto == null) return null;

        Jugador jugador = new Jugador();
        jugador.setId(dto.getId());
        jugador.setNombre(dto.getNombre());
        jugador.setGenero(dto.getGenero() != null ? Jugador.Genero.valueOf(dto.getGenero()) : null);
        jugador.setCategoria(dto.getCategoria() != null ? Jugador.Categoria.valueOf(dto.getCategoria()) : null);

        // el objeto Pais se debe setear despues en el Service al buscarlo por ID
        Pais pais = new Pais();
        pais.setId(dto.getPaisId());
        jugador.setPais(pais);

        return jugador;
    }
}
