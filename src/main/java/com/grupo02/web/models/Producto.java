package com.grupo02.web.models;

import java.io.Serializable;

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
@Table(name = "producto")
public class Producto implements Serializable{
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTipoProd", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TipoProducto tipoProd;  // esto debería ser de tipo TipoProducto, pero no tengo el modelo ahorita

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDuleria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Dulceria dulceria;  // ... cambiar a tipo Dulcería cuando el modelo esté hecho

    public Producto() {
        id = null;
        nombre = null;
        precio = null;
        descripcion = null;
        stock = null;
        tipoProd = null;
        dulceria = null;
    }

    public Producto(Long id, String nombre, Double precio, String descripcion, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Dulceria getDulceria() {
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

    public TipoProducto getTipoProd() {
        return tipoProd;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDulceria(Dulceria dulceria) {
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

    public void setTipoProd(TipoProducto tipoProd) {
        this.tipoProd = tipoProd;
    }
}
