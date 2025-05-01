package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.ArbitroDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArbitroService {
    List<ArbitroDTO> listar();
    ArbitroDTO guardar(ArbitroDTO arbitroDTO);
    ArbitroDTO buscarPorId(Long id);
    ArbitroDTO actualizar(Long id, ArbitroDTO arbitroDTO);
    void eliminar(Long id);
}
