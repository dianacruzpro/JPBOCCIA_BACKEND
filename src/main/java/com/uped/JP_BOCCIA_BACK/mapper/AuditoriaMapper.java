package com.uped.JP_BOCCIA_BACK.mapper;
import com.uped.JP_BOCCIA_BACK.dto.AuditoriaDTO;
import com.uped.JP_BOCCIA_BACK.entity.Auditoria;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AuditoriaMapper  {
    public static AuditoriaDTO toDTO(Auditoria auditoria) {
        if (auditoria == null) return null;

        AuditoriaDTO dto = new AuditoriaDTO();
        dto.setId(auditoria.getId());
        dto.setAccion(auditoria.getAccion());
        dto.setEntidadAfectada(auditoria.getEntidadAfectada());
        dto.setFechaHora(auditoria.getFechaHora());

        if (auditoria.getUsuario() != null) {
            dto.setUsuarioId(auditoria.getUsuario().getId());

        }

        return dto;
    }

    public static Auditoria toEntity(AuditoriaDTO dto) {
        if (dto == null) return null;

        Auditoria auditoria = new Auditoria();
        auditoria.setId(dto.getId());
        auditoria.setAccion(dto.getAccion());
        auditoria.setEntidadAfectada(dto.getEntidadAfectada());
        auditoria.setFechaHora(dto.getFechaHora());

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            auditoria.setUsuario(usuario);
        }

        return auditoria;
    }
}