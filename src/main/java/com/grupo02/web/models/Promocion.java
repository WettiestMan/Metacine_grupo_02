package com.grupo02.web.models;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "promocion")
public class Promocion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPromocion")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCine", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cine cine;

    public Promocion() {
        id = null;
        nombre = null;
        descripcion = null;
        stock = null;
        fechaInicio = null;
        fechaFin = null;
        cine = null;
    }

    public Promocion(Long id, String nombre, String descripcion, Integer stock, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Cine getCine() {
        return cine;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
