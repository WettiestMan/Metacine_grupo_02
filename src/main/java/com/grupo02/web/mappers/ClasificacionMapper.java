package com.grupo02.web.mappers;

import com.grupo02.web.dto.ClasificacionDto;
import com.grupo02.web.models.Clasificacion;

public class ClasificacionMapper {
    public static ClasificacionDto toDto(Clasificacion bean) {
        return new ClasificacionDto(
            bean.getId(),
            bean.getNombre()
        );
    }

    public static Clasificacion toModel(ClasificacionDto bean) {
        return new Clasificacion(
            bean.getId(),
            bean.getNombre()
        );
    }
}
