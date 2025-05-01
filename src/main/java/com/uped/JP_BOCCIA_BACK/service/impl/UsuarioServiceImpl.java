package com.uped.JP_BOCCIA_BACK.service.impl;


import com.uped.JP_BOCCIA_BACK.dto.UsuarioDTO;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import com.uped.JP_BOCCIA_BACK.exception.UsuarioNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.UsuarioMapper;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import com.uped.JP_BOCCIA_BACK.service.UsuarioService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        Usuario guardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(guardado);
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));
        return UsuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setRol(Usuario.RolUsuario.valueOf(dto.getRol()));
        usuario.setEstado(dto.getEstado());

        Usuario actualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(actualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));
        usuarioRepository.delete(usuario);
    }

}
