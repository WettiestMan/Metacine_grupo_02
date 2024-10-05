package com.grupo02.web.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "stock")
    private Integer stock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTipoProd", referencedColumnName = "idTipoProd")
    private Object tipoProd;  // esto debería ser de tipo TipoProducto, pero no tengo el modelo ahorita

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDuleria", referencedColumnName = "idDuleria")
    private Object dulceria;  // ... cambiar a tipo Dulcería cuando el modelo esté hecho

    public Producto() {
        id = null;
        nombre = null;
        precio = null;
        descripcion = null;
        stock = null;
        tipoProd = null;
        dulceria = null;
    }

    public Producto(Long id, String nombre, Double precio, String descripcion, Integer stock, Object tipoProd, Object dulceria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.tipoProd = tipoProd;
        this.dulceria = dulceria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Object getDulceria() {
        return dulceria;
    }

    public Long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public Object getTipoProd() {
        return tipoProd;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDulceria(Object dulceria) {
        this.dulceria = dulceria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setTipoProd(Object tipoProd) {
        this.tipoProd = tipoProd;
    }
}
