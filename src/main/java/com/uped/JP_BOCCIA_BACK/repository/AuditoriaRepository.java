package com.uped.JP_BOCCIA_BACK.repository;
import com.uped.JP_BOCCIA_BACK.entity.Auditoria;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

    List<Auditoria> findByUsuario(Usuario usuario);
}
