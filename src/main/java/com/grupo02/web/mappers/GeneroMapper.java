package com.grupo02.web.mappers;

import com.grupo02.web.dto.GeneroDto;
import com.grupo02.web.models.Genero;

public class GeneroMapper {
    public static GeneroDto toDto(Genero bean) {
        return new GeneroDto(
            bean.getId(),
            bean.getNombre()
        );
    }

    public static Genero toModel(GeneroDto bean) {
        return new Genero(
            bean.getId(),
            bean.getNombre()
        );
    }
}
