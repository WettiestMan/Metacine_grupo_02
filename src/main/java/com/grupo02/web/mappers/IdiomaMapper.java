package com.grupo02.web.mappers;

import com.grupo02.web.dto.IdiomaDto;
import com.grupo02.web.models.Idioma;

public class IdiomaMapper {
    public static IdiomaDto toDto(Idioma bean) {
        return new IdiomaDto(
            bean.getId(),
            bean.getNombre()
        );
    }

    public static Idioma toModel(IdiomaDto bean) {
        return new Idioma(
            bean.getId(),
            bean.getNombre()
        );
    }
}
