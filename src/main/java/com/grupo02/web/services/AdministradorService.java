package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.AdministradorDto;

public interface AdministradorService {
    AdministradorDto insertar(AdministradorDto newBean);

    Optional<AdministradorDto> obtenerPorId(Long id);

    Optional<AdministradorDto> obtenerPorCineId(Long id);

    List<AdministradorDto> obtenerTodos();

    Optional<AdministradorDto> actualizar(Long id, AdministradorDto updBean);

    boolean eliminar(Long id);
}
