package com.grupo02.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CineDto {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;

    @JsonIgnore
    private AdministradorDto admin;

    @JsonIgnore
    private DulceriaDto dulceria;


    public CineDto() {
    }

    public CineDto(Long id, String nombre, String direccion, String telefono, AdministradorDto admin, DulceriaDto dulceria) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.admin = admin;
        this.dulceria = dulceria;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public AdministradorDto getAdmin() {
        return this.admin;
    }

    public void setAdmin(AdministradorDto admin) {
        this.admin = admin;
    }

    public DulceriaDto getDulceria() {
        return this.dulceria;
    }

    public void setDulceria(DulceriaDto dulceria) {
        this.dulceria = dulceria;
    }
}
