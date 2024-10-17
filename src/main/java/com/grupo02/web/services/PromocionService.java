package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.PromocionDto;

public interface PromocionService {
    PromocionDto insertar(PromocionDto newBean);

    Optional<PromocionDto> obtenerPorId(Long id);

    List<PromocionDto> obtenerPorCineId(Long id);

    List<PromocionDto> obtenerPorStock(Integer stock);

    List<PromocionDto> obtenerTodos();

    Optional<PromocionDto> actualizar(Long id, PromocionDto updBean);

    boolean eliminar(Long id);
}
