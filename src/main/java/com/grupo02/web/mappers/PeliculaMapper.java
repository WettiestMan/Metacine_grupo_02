package com.grupo02.web.mappers;

import com.grupo02.web.dto.PeliculaDto;
import com.grupo02.web.models.Pelicula;

public class PeliculaMapper {
    public static PeliculaDto toDto(Pelicula bean) {
        return new PeliculaDto(
            bean.getId(),
            bean.getDuracion(),
            bean.getDescripcion(),
            IdiomaMapper.toDto(bean.getIdioma()),
            ClasificacionMapper.toDto(bean.getClasificacion()),
            DirectorMapper.toDto(bean.getDirector()),
            GeneroMapper.toDto(bean.getGenero())
        );
    }

    public static Pelicula toModel(PeliculaDto bean) {
        var ret = new Pelicula(
            bean.getId(),
            bean.getDuracion(),
            bean.getDescripcion()
        );

        ret.setClasificacion(ClasificacionMapper.toModel(bean.getClasificacion()));
        ret.setDirector(DirectorMapper.toModel(bean.getDirector()));
        ret.setGenero(GeneroMapper.toModel(bean.getGenero()));
        ret.setIdioma(IdiomaMapper.toModel(bean.getIdioma()));

        return ret;
    }
}
