package com.uped.JP_BOCCIA_BACK.controller;

import com.uped.JP_BOCCIA_BACK.dto.ArbitroDTO;
import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import com.uped.JP_BOCCIA_BACK.service.ArbitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/arbitros")
public class ArbitroController {

    private final ArbitroService arbitroService;

    @Autowired
    public ArbitroController(ArbitroService arbitroService) {
        this.arbitroService = arbitroService;
    }

    @GetMapping
    public List<ArbitroDTO> listar() {
        return arbitroService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbitroDTO> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(arbitroService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArbitroDTO> crear(@RequestBody ArbitroDTO dto){
        return new ResponseEntity<>(arbitroService.guardar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArbitroDTO> actualizar(@PathVariable Long id, @RequestBody ArbitroDTO dto){
        return new ResponseEntity<>(arbitroService.actualizar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id){
        arbitroService.eliminar(id);
        Map<String, String> respuesta =  new HashMap<>();
        respuesta.put("mensaje", "Arbitro eliminado con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/multiples")
    public ResponseEntity<List<Arbitro>> crearMultiples(@RequestBody List<Arbitro> arbitros) {
        List<Arbitro> creados = arbitroService.guardarVarios(arbitros);
        return new ResponseEntity<>(creados, HttpStatus.CREATED);
    }
}
