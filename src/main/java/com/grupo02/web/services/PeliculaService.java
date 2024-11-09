package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.PeliculaDto;

public interface PeliculaService {
    PeliculaDto insertar(PeliculaDto newBean);

    Optional<PeliculaDto> obtenerPorId(Long id);

    List<PeliculaDto> obtenerTodos();

    List<PeliculaDto> obtenerPorIdiomaId(Long id);

    List<PeliculaDto> obtenerPorNombre(String nombre);

    List<PeliculaDto> obtenerPorClasificacionId(Long id);

    List<PeliculaDto> obtenerPorGeneroId(Long id);

    List<PeliculaDto> obtenerPorDirectorId(Long id);

    Optional<PeliculaDto> actualizar(Long id, PeliculaDto updBean);

    boolean eliminar(Long id);
}
