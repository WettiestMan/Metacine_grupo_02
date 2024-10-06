package com.grupo02.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "idioma")
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIdioma")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Idioma() {
        id = null;
        nombre = null;
    }

    public Idioma(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
