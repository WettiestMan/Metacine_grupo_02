package com.grupo02.web.dto;

import java.time.LocalTime;

public class PeliculaDto {
    private Long id;
    private LocalTime duracion;
    private String descripcion;
    private IdiomaDto idioma;
    private ClasificacionDto clasificacion;
    private DirectorDto director;
    private GeneroDto genero;

    public PeliculaDto() {
    }

    public PeliculaDto(Long id, LocalTime duracion, String descripcion, IdiomaDto idioma, ClasificacionDto clasificacion, DirectorDto director, GeneroDto genero) {
        this.id = id;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.clasificacion = clasificacion;
        this.director = director;
        this.genero = genero;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getDuracion() {
        return this.duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public IdiomaDto getIdioma() {
        return this.idioma;
    }

    public void setIdioma(IdiomaDto idioma) {
        this.idioma = idioma;
    }

    public ClasificacionDto getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(ClasificacionDto clasificacion) {
        this.clasificacion = clasificacion;
    }

    public DirectorDto getDirector() {
        return this.director;
    }

    public void setDirector(DirectorDto director) {
        this.director = director;
    }

    public GeneroDto getGenero() {
        return this.genero;
    }

    public void setGenero(GeneroDto genero) {
        this.genero = genero;
    }
}
