package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.exception.UsuarioNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.dto.UsuarioDTO;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import com.uped.JP_BOCCIA_BACK.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(UsuarioDTO usuarioDTO) {
        // Crear nueva entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow( ()-> new UsuarioNoEncontradoException(id) );
    }

    /*public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }*/

    public void eliminarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new UsuarioNoEncontradoException(id);
        }
        usuarioRepository.deleteById(id);
    }



    public Usuario actualizarUsuario(Usuario usuarioExistente) {
        return usuarioRepository.save(usuarioExistente);
    }

}