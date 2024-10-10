package com.grupo02.web.dto;

public class DulceriaDto {
    private Long id;
    private String direccion;
    private CineDto cine;

    public DulceriaDto() {
    }

    public DulceriaDto(Long id, String direccion, CineDto cine) {
        this.id = id;
        this.direccion = direccion;
        this.cine = cine;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CineDto getCine() {
        return this.cine;
    }

    public void setCine(CineDto cine) {
        this.cine = cine;
    }
}
