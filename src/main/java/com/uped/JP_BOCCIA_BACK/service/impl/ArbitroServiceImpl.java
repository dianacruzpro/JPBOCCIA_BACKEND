package com.uped.JP_BOCCIA_BACK.service.impl;

import com.uped.JP_BOCCIA_BACK.dto.ArbitroDTO;
import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import com.uped.JP_BOCCIA_BACK.exception.ArbitroNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.PaisNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.UsuarioNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.ArbitroMapper;
import com.uped.JP_BOCCIA_BACK.repository.ArbitroRepository;
import com.uped.JP_BOCCIA_BACK.repository.PaisRepository;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import com.uped.JP_BOCCIA_BACK.service.ArbitroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArbitroServiceImpl implements ArbitroService {
    private final ArbitroRepository arbitroRepository;
    private final PaisRepository paisRepository;
    private final UsuarioRepository usuarioRepository;

    public ArbitroServiceImpl(ArbitroRepository arbitroRepository, PaisRepository paisRepository, UsuarioRepository usuarioRepository){
        this.arbitroRepository = arbitroRepository;
        this.paisRepository = paisRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<ArbitroDTO> listar() {
        return arbitroRepository.findAll()
                .stream()
                .map(ArbitroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArbitroDTO buscarPorId(Long id) {
        Arbitro arbitro = arbitroRepository.findById(id)
                .orElseThrow(() -> new ArbitroNoEncontradoException(id));
        return ArbitroMapper.toDTO(arbitro);
    }

    @Override
    public ArbitroDTO guardar(ArbitroDTO dto) {
        //Busca pais por id
        Pais pais = paisRepository.findById(dto.getPaisId()).orElse(null);
        // Busca usuario por id
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new UsuarioNoEncontradoException(dto.getUsuarioId()));
        // Covierte el dto a entidad
        Arbitro arbitro = ArbitroMapper.toEntity(dto, pais, usuario);
        //guarda el arbitro en la bd
        return ArbitroMapper.toDTO(arbitroRepository.save(arbitro));
    }

    @Override
    public ArbitroDTO actualizar(Long id, ArbitroDTO dto){
        Arbitro arbitro = arbitroRepository.findById(id)
                .orElseThrow(() -> new ArbitroNoEncontradoException(id));
        arbitro.setNombre(dto.getNombre());
        arbitro.setRolJuez(Arbitro.RolJuez.valueOf(dto.getRolJuez()));
        arbitro.setCertificacion(dto.getCertificacion());
        if (dto.getPaisId() != null){
            Pais pais = paisRepository.findById(dto.getPaisId()).orElseThrow(() -> new PaisNoEncontradoException(dto.getPaisId()));
            arbitro.setPais(pais);
        }
        if (dto.getUsuarioId() != null){
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new UsuarioNoEncontradoException(dto.getUsuarioId()));
            arbitro.setUsuario(usuario);
        }
        return ArbitroMapper.toDTO(arbitroRepository.save(arbitro));
    }

    @Override
    public void eliminar(Long id) {
        Arbitro arbitro = arbitroRepository.findById(id)
                .orElseThrow(() -> new ArbitroNoEncontradoException(id));
        arbitroRepository.delete(arbitro);
    }

    @Override
    public List<Arbitro> guardarVarios(List<Arbitro> arbitros) {
        return arbitroRepository.saveAll(arbitros);
    }
}
