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

import com.grupo02.web.dto.DirectorDto;
import com.grupo02.web.services.DirectorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/directores")
public class DirectorController {
    
    private final DirectorService intf;

    public DirectorController(DirectorService intf) {
        this.intf = intf;
    }

    @PostMapping
    public ResponseEntity<DirectorDto> registrarPelicula(@RequestBody DirectorDto bean) {
        try {
            return ResponseEntity.ok(intf.insertar(bean));
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porId")
    public ResponseEntity<DirectorDto> obtenerPorId (@RequestParam(name = "id", required = true) Long id) {
        try {
            Optional<DirectorDto> resp = intf.obtenerPorId(id);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> obtenerTodos() {
        try {
            return ResponseEntity.ok(intf.obtenerTodos());
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porDirectorNombre")
    public ResponseEntity<List<DirectorDto>> obtenerPorNombre (@RequestParam(name = "nombre", required = true) String nombre) {
        try {
            return ResponseEntity.ok(intf.obtenerPorNombre(nombre));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porDirectorApellido")
    public ResponseEntity<List<DirectorDto>> obtenerPorApellido (@RequestParam(name = "apellido", required = true) String apellido) {
        try {
            return ResponseEntity.ok(intf.obtenerPorApellido(apellido));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("porDirectorNombreApellido")
    public ResponseEntity<List<DirectorDto>> obtenerPorNombreYApellido (
        @RequestParam(name = "nombre", required = true) String nombre,
        @RequestParam(name = "apellido", required = true) String apellido
    ) {
        try {
            return ResponseEntity.ok(intf.obtenerPorNombreYApellido(nombre, apellido));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<DirectorDto> actualizarClasificacion(@RequestBody DirectorDto bean) {
        try {
            Optional<DirectorDto> resp = intf.actualizar(bean.getId(), bean);
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
    public ResponseEntity<DirectorDto> eliminarClasificacion(@RequestBody Long id) {
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
