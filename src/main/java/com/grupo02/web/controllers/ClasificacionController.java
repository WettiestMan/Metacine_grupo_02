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

import com.grupo02.web.dto.ClasificacionDto;
import com.grupo02.web.services.ClasificacionService;

@CrossOrigin
@RestController
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {
    
    private final ClasificacionService intf;

    public ClasificacionController(ClasificacionService intf) {
        this.intf = intf;
    }

    @PostMapping
    public ResponseEntity<ClasificacionDto> registrarPelicula(@RequestBody ClasificacionDto bean) {
        try {
            return ResponseEntity.ok(intf.insertar(bean));
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porId")
    public ResponseEntity<ClasificacionDto> obtenerPorId (@RequestParam(name = "id", required = true) Long id) {
        try {
            Optional<ClasificacionDto> resp = intf.obtenerPorId(id);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClasificacionDto>> obtenerTodos() {
        try {
            return ResponseEntity.ok(intf.obtenerTodos());
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<ClasificacionDto> actualizarClasificacion(@RequestBody ClasificacionDto bean) {
        try {
            Optional<ClasificacionDto> resp = intf.actualizar(bean.getId(), bean);
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
    public ResponseEntity<ClasificacionDto> eliminarClasificacion(@RequestBody Long id) {
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