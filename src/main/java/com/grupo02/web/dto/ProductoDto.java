package com.grupo02.web.dto;

public class ProductoDto {
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private Integer stock;
    private TipoProductoDto tipoProd;
    private DulceriaDto dulceria;

    public ProductoDto() {
    }

    public ProductoDto(Long id, String nombre, Double precio, String descripcion, Integer stock, TipoProductoDto tipoProd, DulceriaDto dulceria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.tipoProd = tipoProd;
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

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public TipoProductoDto getTipoProd() {
        return this.tipoProd;
    }

    public void setTipoProd(TipoProductoDto tipoProd) {
        this.tipoProd = tipoProd;
    }

    public DulceriaDto getDulceria() {
        return this.dulceria;
    }

    public void setDulceria(DulceriaDto dulceria) {
        this.dulceria = dulceria;
    }

}
