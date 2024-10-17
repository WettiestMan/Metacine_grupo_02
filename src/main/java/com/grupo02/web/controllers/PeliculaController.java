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

import com.grupo02.web.services.PeliculaService;
import com.grupo02.web.dto.PeliculaDto;

@CrossOrigin("*")
@RestController
@RequestMapping("api/peliculas")
public class PeliculaController {

    private final PeliculaService intf;

    public PeliculaController(PeliculaService intf) {
        this.intf = intf;
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> registrarPelicula(@RequestBody PeliculaDto bean) {
        try {
            return ResponseEntity.ok(intf.insertar(bean));
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<PeliculaDto> obtenerPorId (@RequestParam(name = "id", required = true) Long id) {
        try {
            Optional<PeliculaDto> resp = intf.obtenerPorId(id);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodos() {
        try {
            return ResponseEntity.ok(intf.obtenerTodos());
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPorIdiomaId (@RequestParam(name = "idIdioma", required = true) Long id) {
        try {
            return ResponseEntity.ok(intf.obtenerPorIdiomaId(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPorClasificacionId (@RequestParam(name = "idClasificacion", required = true) Long id) {
        try {
            return ResponseEntity.ok(intf.obtenerPorClasificacionId(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPorGeneroId (@RequestParam(name = "idGenero", required = true) Long id) {
        try {
            return ResponseEntity.ok(intf.obtenerPorGeneroId(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPorDirectorId (@RequestParam(name = "idDirector", required = true) Long id) {
        try {
            return ResponseEntity.ok(intf.obtenerPorDirectorId(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<PeliculaDto> actualizarPelicula (@RequestBody PeliculaDto bean) {
        try {
            Optional<PeliculaDto> resp = intf.actualizar(bean.getId(), bean);
            if (resp.isPresent()) {
                return ResponseEntity.ok(resp.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<PeliculaDto> eliminarCine(@RequestBody Long id) {
        try {
            if (intf.eliminar(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}