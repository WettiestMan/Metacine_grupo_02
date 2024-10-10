package com.grupo02.web.dto;

import java.time.LocalDate;

public class PromocionDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private CineDto cine;

    public PromocionDto() {
    }

    public PromocionDto(Long id, String nombre, String descripcion, Integer stock, LocalDate fechaInicio, LocalDate fechaFin, CineDto cine) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CineDto getCine() {
        return this.cine;
    }

    public void setCine(CineDto cine) {
        this.cine = cine;
    }
}
