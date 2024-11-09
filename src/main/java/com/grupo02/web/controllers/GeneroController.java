package com.grupo02.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo02.web.dto.GeneroDto;
import com.grupo02.web.services.GeneroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/generos")
public class GeneroController {
    
    private final GeneroService intf;

    public GeneroController(GeneroService intf) {
        this.intf = intf;
    }

    @PostMapping
    public ResponseEntity<GeneroDto> registrarPelicula(@RequestBody GeneroDto bean) {
        try {
            return ResponseEntity.ok(intf.insertar(bean));
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porId")
    public ResponseEntity<GeneroDto> obtenerPorId (@RequestParam(name = "id", required = true) Long id) {
        try {
            Optional<GeneroDto> resp = intf.obtenerPorId(id);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<GeneroDto>> obtenerTodos() {
        try {
            return ResponseEntity.ok(intf.obtenerTodos());
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<GeneroDto> actualizarClasificacion(@RequestBody GeneroDto bean) {
        try {
            Optional<GeneroDto> resp = intf.actualizar(bean.getId(), bean);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<GeneroDto> eliminarClasificacion(@RequestBody Long id) {
        try {
            if (intf.eliminar(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
