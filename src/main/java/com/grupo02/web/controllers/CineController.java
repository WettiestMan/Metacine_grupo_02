package com.grupo02.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo02.web.dto.CineDto;
import com.grupo02.web.services.CineService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cines")
public class CineController {
    
    private final CineService intf;

    public CineController(CineService cs) {
        intf = cs;
    }

    @PostMapping
    public ResponseEntity<CineDto> registrarCine(@RequestBody CineDto bean) {
        try {
            return ResponseEntity.ok(intf.insertar(bean));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CineDto>> obtenerTodosLosCines() {
        try {
            return new ResponseEntity<>(intf.obtenerTodos(), HttpStatus.OK);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porId")
    public ResponseEntity<CineDto> obtenerPorId(@RequestParam(name = "id", required = true) Long id) {
        try {
            Optional<CineDto> resp = intf.obtenerPorId(id);
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

    @GetMapping("porAdminId")
    public ResponseEntity<CineDto> obtenerPorAdministradorId(@RequestParam(name = "idAdmin", required = true) Long id) {
        try {
            Optional<CineDto> resp = intf.obtenerPorAdministradorId(id);
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

    @PutMapping
    public ResponseEntity<CineDto> actualizarCine(@RequestBody CineDto bean) {
        try {
            Optional<CineDto> resp = intf.actualizar(bean.getId(), bean);
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
    public ResponseEntity<CineDto> eliminarCine(@RequestBody Long id) {
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
