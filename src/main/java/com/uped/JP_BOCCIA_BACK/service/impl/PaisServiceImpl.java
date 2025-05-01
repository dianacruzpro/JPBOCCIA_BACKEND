package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.exception.PaisNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    @Override
    public Pais guardar(Pais pais){
        return paisRepository.save(pais);
    }

    @Override
    public Pais buscarPorId(Long id){
        return paisRepository.findById(id).orElseThrow(() -> new PaisNoEncontradoException(id));
    }

    @Override
    public Pais actualizar(Long id, Pais paisActualizado){
        Optional<Pais> paisOptional = paisRepository.findById(id);
        if (paisOptional.isPresent()){
            Pais pais = paisOptional.get();
            pais.setNombre(paisActualizado.getNombre());
            pais.setSiglas(paisActualizado.getSiglas());
            return paisRepository.save(pais);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new PaisNoEncontradoException(id));
        paisRepository.delete(pais);
    }

    @Override
    public List<Pais> guardarVariosPaises(List<Pais> paises) {
        return paisRepository.saveAll(paises);
    }
}
