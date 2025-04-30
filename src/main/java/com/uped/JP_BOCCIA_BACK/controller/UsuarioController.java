package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.UsuarioDTO;
import com.uped.JP_BOCCIA_BACK.entity.Usuario;
import com.uped.JP_BOCCIA_BACK.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> crear(@RequestBody UsuarioDTO usuarioDTO) {

        // Crear el usuario con los roles convertidos
        Usuario nuevo = usuarioService.guardarUsuario(usuarioDTO);

        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioService.buscarPorId(id);

        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setPassword(usuarioDTO.getPassword());

        Usuario actualizado = usuarioService.actualizarUsuario(usuarioExistente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    /*@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario eliminado con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }


}