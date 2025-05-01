package com.uped.JP_BOCCIA_BACK.controller;


import com.uped.JP_BOCCIA_BACK.entity.Pais;
import com.uped.JP_BOCCIA_BACK.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> listarPaises(){
        return paisService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Pais> crearPais(@RequestBody Pais pais){
        return ResponseEntity.ok(paisService.guardar(pais));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(paisService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizarPais(@PathVariable Long id, @RequestBody Pais pais){
        return ResponseEntity.ok(paisService.actualizar(id, pais));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarPais(@PathVariable Long id){
        paisService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Pais eliminado con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    //Agregando metodo para agregar multiples registros *Implementar en las demas entidades posteriormente*
    @PostMapping("/multiple")
    public ResponseEntity<List<Pais>> guardarVariosPaises(@RequestBody List<Pais> paises) {
        List<Pais> paisesGuardados = paisService.guardarVariosPaises(paises);
        return new ResponseEntity<>(paisesGuardados, HttpStatus.CREATED);
    }
}
