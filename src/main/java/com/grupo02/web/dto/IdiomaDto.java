package com.grupo02.web.dto;

public class IdiomaDto {
    private Long id;
    private String nombre;

    public IdiomaDto() {
    }

    public IdiomaDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
