package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.entity.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> listarTodos();
    Pais guardar(Pais pais);
    Pais buscarPorId(Long id);
    Pais actualizar(Long id, Pais pais);
    void eliminar(Long id);
    List<Pais> guardarVariosPaises(List<Pais> paises);

}
