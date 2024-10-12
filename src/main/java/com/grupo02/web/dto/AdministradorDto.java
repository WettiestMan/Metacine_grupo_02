package com.grupo02.web.dto;

public class AdministradorDto {
    private Long id;
    private String nombre;
    private String correo;
    private CineDto cine;

    public AdministradorDto() {
    }

    public AdministradorDto(Long id, String nombre, String correo, CineDto cine) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cine = cine;
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

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public CineDto getCine() {
        return this.cine;
    }

    public void setCine(CineDto cine) {
        this.cine = cine;
    }

}
