package com.grupo02.web.models;

import java.time.LocalTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula")
    private Long id;

    @Column(name = "duration")
    private LocalTime duracion;

    @Column(name = "description")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idIdioma", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Idioma idioma;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idClasificacion", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Clasificacion clasificacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDirector", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Director director;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGenero", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Genero genero;

    public Pelicula() {
        id = null;
        duracion = null;
        descripcion = null;
        idioma = null;
        clasificacion = null;
        director = null;
        genero = null;
    }

    public Pelicula(Long id, LocalTime duracion, String descripcion, Idioma idioma, Clasificacion cl, Director dir, Genero gen) {
        this.id = id;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.clasificacion = cl;
        this.director = dir;
        this.genero = gen;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Director getDirector() {
        return director;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}