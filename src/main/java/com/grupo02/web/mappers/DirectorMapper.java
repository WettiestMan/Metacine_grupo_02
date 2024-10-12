package com.grupo02.web.mappers;

import com.grupo02.web.dto.DirectorDto;
import com.grupo02.web.models.Director;

public class DirectorMapper {
    public static DirectorDto toDto(Director bean) {
        return new DirectorDto(
            bean.getId(),
            bean.getNombre(),
            bean.getApellido()
        );
    }

    public static Director toModel(DirectorDto bean) {
        return new Director(
            bean.getId(),
            bean.getNombre(),
            bean.getApellido()
        );
    }
}
