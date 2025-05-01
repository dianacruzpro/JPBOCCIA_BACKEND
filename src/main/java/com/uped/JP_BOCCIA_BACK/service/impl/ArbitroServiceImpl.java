package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.repository.ArbitroRepository;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import com.uped.JP_BOCCIA_BACK.service.ArbitroService;
import org.springframework.stereotype.Service;

@Service
public abstract class ArbitroServiceImpl implements ArbitroService {
    private final ArbitroRepository arbitroRepository;
    private final PaisRepository paisRepository;
    private final UsuarioRepository usuarioRepository;

    public ArbitroServiceImpl(ArbitroRepository arbitroRepository, PaisRepository paisRepository, UsuarioRepository usuarioRepository){
        this.arbitroRepository = arbitroRepository;
        this.paisRepository = paisRepository;
        this.usuarioRepository = usuarioRepository;
    }
}
